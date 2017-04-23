package com.zx.model;

import java.util.ArrayList;
import java.util.List;

public class StorestypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StorestypeExample() {
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

        public Criteria andStypeidIsNull() {
            addCriterion("stypeid is null");
            return (Criteria) this;
        }

        public Criteria andStypeidIsNotNull() {
            addCriterion("stypeid is not null");
            return (Criteria) this;
        }

        public Criteria andStypeidEqualTo(Integer value) {
            addCriterion("stypeid =", value, "stypeid");
            return (Criteria) this;
        }

        public Criteria andStypeidNotEqualTo(Integer value) {
            addCriterion("stypeid <>", value, "stypeid");
            return (Criteria) this;
        }

        public Criteria andStypeidGreaterThan(Integer value) {
            addCriterion("stypeid >", value, "stypeid");
            return (Criteria) this;
        }

        public Criteria andStypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stypeid >=", value, "stypeid");
            return (Criteria) this;
        }

        public Criteria andStypeidLessThan(Integer value) {
            addCriterion("stypeid <", value, "stypeid");
            return (Criteria) this;
        }

        public Criteria andStypeidLessThanOrEqualTo(Integer value) {
            addCriterion("stypeid <=", value, "stypeid");
            return (Criteria) this;
        }

        public Criteria andStypeidIn(List<Integer> values) {
            addCriterion("stypeid in", values, "stypeid");
            return (Criteria) this;
        }

        public Criteria andStypeidNotIn(List<Integer> values) {
            addCriterion("stypeid not in", values, "stypeid");
            return (Criteria) this;
        }

        public Criteria andStypeidBetween(Integer value1, Integer value2) {
            addCriterion("stypeid between", value1, value2, "stypeid");
            return (Criteria) this;
        }

        public Criteria andStypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("stypeid not between", value1, value2, "stypeid");
            return (Criteria) this;
        }

        public Criteria andStypenameIsNull() {
            addCriterion("stypename is null");
            return (Criteria) this;
        }

        public Criteria andStypenameIsNotNull() {
            addCriterion("stypename is not null");
            return (Criteria) this;
        }

        public Criteria andStypenameEqualTo(String value) {
            addCriterion("stypename =", value, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypenameNotEqualTo(String value) {
            addCriterion("stypename <>", value, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypenameGreaterThan(String value) {
            addCriterion("stypename >", value, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypenameGreaterThanOrEqualTo(String value) {
            addCriterion("stypename >=", value, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypenameLessThan(String value) {
            addCriterion("stypename <", value, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypenameLessThanOrEqualTo(String value) {
            addCriterion("stypename <=", value, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypenameLike(String value) {
            addCriterion("stypename like", value, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypenameNotLike(String value) {
            addCriterion("stypename not like", value, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypenameIn(List<String> values) {
            addCriterion("stypename in", values, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypenameNotIn(List<String> values) {
            addCriterion("stypename not in", values, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypenameBetween(String value1, String value2) {
            addCriterion("stypename between", value1, value2, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypenameNotBetween(String value1, String value2) {
            addCriterion("stypename not between", value1, value2, "stypename");
            return (Criteria) this;
        }

        public Criteria andStypedelIsNull() {
            addCriterion("stypedel is null");
            return (Criteria) this;
        }

        public Criteria andStypedelIsNotNull() {
            addCriterion("stypedel is not null");
            return (Criteria) this;
        }

        public Criteria andStypedelEqualTo(Integer value) {
            addCriterion("stypedel =", value, "stypedel");
            return (Criteria) this;
        }

        public Criteria andStypedelNotEqualTo(Integer value) {
            addCriterion("stypedel <>", value, "stypedel");
            return (Criteria) this;
        }

        public Criteria andStypedelGreaterThan(Integer value) {
            addCriterion("stypedel >", value, "stypedel");
            return (Criteria) this;
        }

        public Criteria andStypedelGreaterThanOrEqualTo(Integer value) {
            addCriterion("stypedel >=", value, "stypedel");
            return (Criteria) this;
        }

        public Criteria andStypedelLessThan(Integer value) {
            addCriterion("stypedel <", value, "stypedel");
            return (Criteria) this;
        }

        public Criteria andStypedelLessThanOrEqualTo(Integer value) {
            addCriterion("stypedel <=", value, "stypedel");
            return (Criteria) this;
        }

        public Criteria andStypedelIn(List<Integer> values) {
            addCriterion("stypedel in", values, "stypedel");
            return (Criteria) this;
        }

        public Criteria andStypedelNotIn(List<Integer> values) {
            addCriterion("stypedel not in", values, "stypedel");
            return (Criteria) this;
        }

        public Criteria andStypedelBetween(Integer value1, Integer value2) {
            addCriterion("stypedel between", value1, value2, "stypedel");
            return (Criteria) this;
        }

        public Criteria andStypedelNotBetween(Integer value1, Integer value2) {
            addCriterion("stypedel not between", value1, value2, "stypedel");
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