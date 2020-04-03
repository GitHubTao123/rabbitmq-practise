package com.yue.waimaiordersys.api.entity;

import java.util.ArrayList;
import java.util.List;

public class WaimaiSalerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaimaiSalerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSalerNameIsNull() {
            addCriterion("saler_name is null");
            return (Criteria) this;
        }

        public Criteria andSalerNameIsNotNull() {
            addCriterion("saler_name is not null");
            return (Criteria) this;
        }

        public Criteria andSalerNameEqualTo(String value) {
            addCriterion("saler_name =", value, "salerName");
            return (Criteria) this;
        }

        public Criteria andSalerNameNotEqualTo(String value) {
            addCriterion("saler_name <>", value, "salerName");
            return (Criteria) this;
        }

        public Criteria andSalerNameGreaterThan(String value) {
            addCriterion("saler_name >", value, "salerName");
            return (Criteria) this;
        }

        public Criteria andSalerNameGreaterThanOrEqualTo(String value) {
            addCriterion("saler_name >=", value, "salerName");
            return (Criteria) this;
        }

        public Criteria andSalerNameLessThan(String value) {
            addCriterion("saler_name <", value, "salerName");
            return (Criteria) this;
        }

        public Criteria andSalerNameLessThanOrEqualTo(String value) {
            addCriterion("saler_name <=", value, "salerName");
            return (Criteria) this;
        }

        public Criteria andSalerNameLike(String value) {
            addCriterion("saler_name like", value, "salerName");
            return (Criteria) this;
        }

        public Criteria andSalerNameNotLike(String value) {
            addCriterion("saler_name not like", value, "salerName");
            return (Criteria) this;
        }

        public Criteria andSalerNameIn(List<String> values) {
            addCriterion("saler_name in", values, "salerName");
            return (Criteria) this;
        }

        public Criteria andSalerNameNotIn(List<String> values) {
            addCriterion("saler_name not in", values, "salerName");
            return (Criteria) this;
        }

        public Criteria andSalerNameBetween(String value1, String value2) {
            addCriterion("saler_name between", value1, value2, "salerName");
            return (Criteria) this;
        }

        public Criteria andSalerNameNotBetween(String value1, String value2) {
            addCriterion("saler_name not between", value1, value2, "salerName");
            return (Criteria) this;
        }

        public Criteria andPoseitionIsNull() {
            addCriterion("poseition is null");
            return (Criteria) this;
        }

        public Criteria andPoseitionIsNotNull() {
            addCriterion("poseition is not null");
            return (Criteria) this;
        }

        public Criteria andPoseitionEqualTo(String value) {
            addCriterion("poseition =", value, "poseition");
            return (Criteria) this;
        }

        public Criteria andPoseitionNotEqualTo(String value) {
            addCriterion("poseition <>", value, "poseition");
            return (Criteria) this;
        }

        public Criteria andPoseitionGreaterThan(String value) {
            addCriterion("poseition >", value, "poseition");
            return (Criteria) this;
        }

        public Criteria andPoseitionGreaterThanOrEqualTo(String value) {
            addCriterion("poseition >=", value, "poseition");
            return (Criteria) this;
        }

        public Criteria andPoseitionLessThan(String value) {
            addCriterion("poseition <", value, "poseition");
            return (Criteria) this;
        }

        public Criteria andPoseitionLessThanOrEqualTo(String value) {
            addCriterion("poseition <=", value, "poseition");
            return (Criteria) this;
        }

        public Criteria andPoseitionLike(String value) {
            addCriterion("poseition like", value, "poseition");
            return (Criteria) this;
        }

        public Criteria andPoseitionNotLike(String value) {
            addCriterion("poseition not like", value, "poseition");
            return (Criteria) this;
        }

        public Criteria andPoseitionIn(List<String> values) {
            addCriterion("poseition in", values, "poseition");
            return (Criteria) this;
        }

        public Criteria andPoseitionNotIn(List<String> values) {
            addCriterion("poseition not in", values, "poseition");
            return (Criteria) this;
        }

        public Criteria andPoseitionBetween(String value1, String value2) {
            addCriterion("poseition between", value1, value2, "poseition");
            return (Criteria) this;
        }

        public Criteria andPoseitionNotBetween(String value1, String value2) {
            addCriterion("poseition not between", value1, value2, "poseition");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}