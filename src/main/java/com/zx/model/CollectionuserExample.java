package com.zx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectionuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectionuserExample() {
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

        public Criteria andCollidIsNull() {
            addCriterion("collid is null");
            return (Criteria) this;
        }

        public Criteria andCollidIsNotNull() {
            addCriterion("collid is not null");
            return (Criteria) this;
        }

        public Criteria andCollidEqualTo(Integer value) {
            addCriterion("collid =", value, "collid");
            return (Criteria) this;
        }

        public Criteria andCollidNotEqualTo(Integer value) {
            addCriterion("collid <>", value, "collid");
            return (Criteria) this;
        }

        public Criteria andCollidGreaterThan(Integer value) {
            addCriterion("collid >", value, "collid");
            return (Criteria) this;
        }

        public Criteria andCollidGreaterThanOrEqualTo(Integer value) {
            addCriterion("collid >=", value, "collid");
            return (Criteria) this;
        }

        public Criteria andCollidLessThan(Integer value) {
            addCriterion("collid <", value, "collid");
            return (Criteria) this;
        }

        public Criteria andCollidLessThanOrEqualTo(Integer value) {
            addCriterion("collid <=", value, "collid");
            return (Criteria) this;
        }

        public Criteria andCollidIn(List<Integer> values) {
            addCriterion("collid in", values, "collid");
            return (Criteria) this;
        }

        public Criteria andCollidNotIn(List<Integer> values) {
            addCriterion("collid not in", values, "collid");
            return (Criteria) this;
        }

        public Criteria andCollidBetween(Integer value1, Integer value2) {
            addCriterion("collid between", value1, value2, "collid");
            return (Criteria) this;
        }

        public Criteria andCollidNotBetween(Integer value1, Integer value2) {
            addCriterion("collid not between", value1, value2, "collid");
            return (Criteria) this;
        }

        public Criteria andFidIsNull() {
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("fid in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("fid not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andStidIsNull() {
            addCriterion("stid is null");
            return (Criteria) this;
        }

        public Criteria andStidIsNotNull() {
            addCriterion("stid is not null");
            return (Criteria) this;
        }

        public Criteria andStidEqualTo(Integer value) {
            addCriterion("stid =", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotEqualTo(Integer value) {
            addCriterion("stid <>", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThan(Integer value) {
            addCriterion("stid >", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stid >=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThan(Integer value) {
            addCriterion("stid <", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThanOrEqualTo(Integer value) {
            addCriterion("stid <=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidIn(List<Integer> values) {
            addCriterion("stid in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotIn(List<Integer> values) {
            addCriterion("stid not in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidBetween(Integer value1, Integer value2) {
            addCriterion("stid between", value1, value2, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotBetween(Integer value1, Integer value2) {
            addCriterion("stid not between", value1, value2, "stid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andColldateIsNull() {
            addCriterion("colldate is null");
            return (Criteria) this;
        }

        public Criteria andColldateIsNotNull() {
            addCriterion("colldate is not null");
            return (Criteria) this;
        }

        public Criteria andColldateEqualTo(Date value) {
            addCriterion("colldate =", value, "colldate");
            return (Criteria) this;
        }

        public Criteria andColldateNotEqualTo(Date value) {
            addCriterion("colldate <>", value, "colldate");
            return (Criteria) this;
        }

        public Criteria andColldateGreaterThan(Date value) {
            addCriterion("colldate >", value, "colldate");
            return (Criteria) this;
        }

        public Criteria andColldateGreaterThanOrEqualTo(Date value) {
            addCriterion("colldate >=", value, "colldate");
            return (Criteria) this;
        }

        public Criteria andColldateLessThan(Date value) {
            addCriterion("colldate <", value, "colldate");
            return (Criteria) this;
        }

        public Criteria andColldateLessThanOrEqualTo(Date value) {
            addCriterion("colldate <=", value, "colldate");
            return (Criteria) this;
        }

        public Criteria andColldateIn(List<Date> values) {
            addCriterion("colldate in", values, "colldate");
            return (Criteria) this;
        }

        public Criteria andColldateNotIn(List<Date> values) {
            addCriterion("colldate not in", values, "colldate");
            return (Criteria) this;
        }

        public Criteria andColldateBetween(Date value1, Date value2) {
            addCriterion("colldate between", value1, value2, "colldate");
            return (Criteria) this;
        }

        public Criteria andColldateNotBetween(Date value1, Date value2) {
            addCriterion("colldate not between", value1, value2, "colldate");
            return (Criteria) this;
        }

        public Criteria andColldeleteIsNull() {
            addCriterion("colldelete is null");
            return (Criteria) this;
        }

        public Criteria andColldeleteIsNotNull() {
            addCriterion("colldelete is not null");
            return (Criteria) this;
        }

        public Criteria andColldeleteEqualTo(Integer value) {
            addCriterion("colldelete =", value, "colldelete");
            return (Criteria) this;
        }

        public Criteria andColldeleteNotEqualTo(Integer value) {
            addCriterion("colldelete <>", value, "colldelete");
            return (Criteria) this;
        }

        public Criteria andColldeleteGreaterThan(Integer value) {
            addCriterion("colldelete >", value, "colldelete");
            return (Criteria) this;
        }

        public Criteria andColldeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("colldelete >=", value, "colldelete");
            return (Criteria) this;
        }

        public Criteria andColldeleteLessThan(Integer value) {
            addCriterion("colldelete <", value, "colldelete");
            return (Criteria) this;
        }

        public Criteria andColldeleteLessThanOrEqualTo(Integer value) {
            addCriterion("colldelete <=", value, "colldelete");
            return (Criteria) this;
        }

        public Criteria andColldeleteIn(List<Integer> values) {
            addCriterion("colldelete in", values, "colldelete");
            return (Criteria) this;
        }

        public Criteria andColldeleteNotIn(List<Integer> values) {
            addCriterion("colldelete not in", values, "colldelete");
            return (Criteria) this;
        }

        public Criteria andColldeleteBetween(Integer value1, Integer value2) {
            addCriterion("colldelete between", value1, value2, "colldelete");
            return (Criteria) this;
        }

        public Criteria andColldeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("colldelete not between", value1, value2, "colldelete");
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