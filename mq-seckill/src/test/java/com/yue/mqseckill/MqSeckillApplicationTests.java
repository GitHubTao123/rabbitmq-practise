package com.yue.mqseckill;

import com.yue.mqseckill.api.dto.CommitOrderDto;
import com.yue.mqseckill.api.entity.SeckillGood;
import com.yue.mqseckill.constant.OrderConstant;
import com.yue.mqseckill.result.Result;
import com.yue.mqseckill.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MqSeckillApplicationTests {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        orderService.readStockFromMysql();
        try {
            Thread.sleep(300); //读取数据到redis后稍微停留，防止后续操作发生之前，redis数据未完全读入
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch cdl = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            CountRunnable runnable = new CountRunnable(cdl);
            pool.execute(runnable);
            try {
                Thread.sleep(20); //隔一段时间新建任务，防止产生速度过快撑爆线程池
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static CommitOrderDto dto1;
    static CommitOrderDto dto2;
    static CommitOrderDto dto3;
    static CommitOrderDto dto4;

    static {
         dto1 = new CommitOrderDto(1,"hangzhou",1,3);
         dto2 = new CommitOrderDto(1,"hangzhou2",2,5);
         dto3 = new CommitOrderDto(1,"hangzhou3",1,2);
         dto4 = new CommitOrderDto(1,"hangzhou4",2,4);
    }

    class CountRunnable implements Runnable{

        private CountDownLatch countDownLatch;
        public CountRunnable (CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        public CountDownLatch getCountDownLatch() {
            return countDownLatch;
        }
        @Override
        public void run() {
            try{
                synchronized (countDownLatch){
                    CommitOrderDto dto = null;
                    Random random = new Random();
                    int i = random.nextInt(4);
                    switch (i){
                        case 0:
                            dto = dto1;
                            break;
                        case 1:
                            dto = dto2;
                            break;
                        case 2:
                            dto = dto3;
                            break;
                        case 3:
                            dto = dto4;
                            break;
                    }
                    Result commit = orderService.commit(dto);
                    log.info(commit.toString());
                    countDownLatch.countDown();
                }
                countDownLatch.await();
            }catch (Exception e){
                log.error(""+e);
            }
        }
    }


    @Test
    public void testRedisData(){
        SeckillGood seckillGood1 = (SeckillGood)redisTemplate.opsForHash().get(OrderConstant.GOOD_STOCK_REDIS_KEY,1);
        SeckillGood seckillGood2 = (SeckillGood)redisTemplate.opsForHash().get(OrderConstant.GOOD_STOCK_REDIS_KEY,2);
        System.out.println(seckillGood1.toString());
        System.out.println(seckillGood2.toString());
    }
}
