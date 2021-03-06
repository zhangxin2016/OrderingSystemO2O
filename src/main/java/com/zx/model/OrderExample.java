package com.zx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Integer value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Integer value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Integer value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Integer value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Integer value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Integer> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Integer> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Integer value1, Integer value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Integer value1, Integer value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOnumIsNull() {
            addCriterion("onum is null");
            return (Criteria) this;
        }

        public Criteria andOnumIsNotNull() {
            addCriterion("onum is not null");
            return (Criteria) this;
        }

        public Criteria andOnumEqualTo(Integer value) {
            addCriterion("onum =", value, "onum");
            return (Criteria) this;
        }

        public Criteria andOnumNotEqualTo(Integer value) {
            addCriterion("onum <>", value, "onum");
            return (Criteria) this;
        }

        public Criteria andOnumGreaterThan(Integer value) {
            addCriterion("onum >", value, "onum");
            return (Criteria) this;
        }

        public Criteria andOnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("onum >=", value, "onum");
            return (Criteria) this;
        }

        public Criteria andOnumLessThan(Integer value) {
            addCriterion("onum <", value, "onum");
            return (Criteria) this;
        }

        public Criteria andOnumLessThanOrEqualTo(Integer value) {
            addCriterion("onum <=", value, "onum");
            return (Criteria) this;
        }

        public Criteria andOnumIn(List<Integer> values) {
            addCriterion("onum in", values, "onum");
            return (Criteria) this;
        }

        public Criteria andOnumNotIn(List<Integer> values) {
            addCriterion("onum not in", values, "onum");
            return (Criteria) this;
        }

        public Criteria andOnumBetween(Integer value1, Integer value2) {
            addCriterion("onum between", value1, value2, "onum");
            return (Criteria) this;
        }

        public Criteria andOnumNotBetween(Integer value1, Integer value2) {
            addCriterion("onum not between", value1, value2, "onum");
            return (Criteria) this;
        }

        public Criteria andOtatalIsNull() {
            addCriterion("otatal is null");
            return (Criteria) this;
        }

        public Criteria andOtatalIsNotNull() {
            addCriterion("otatal is not null");
            return (Criteria) this;
        }

        public Criteria andOtatalEqualTo(Integer value) {
            addCriterion("otatal =", value, "otatal");
            return (Criteria) this;
        }

        public Criteria andOtatalNotEqualTo(Integer value) {
            addCriterion("otatal <>", value, "otatal");
            return (Criteria) this;
        }

        public Criteria andOtatalGreaterThan(Integer value) {
            addCriterion("otatal >", value, "otatal");
            return (Criteria) this;
        }

        public Criteria andOtatalGreaterThanOrEqualTo(Integer value) {
            addCriterion("otatal >=", value, "otatal");
            return (Criteria) this;
        }

        public Criteria andOtatalLessThan(Integer value) {
            addCriterion("otatal <", value, "otatal");
            return (Criteria) this;
        }

        public Criteria andOtatalLessThanOrEqualTo(Integer value) {
            addCriterion("otatal <=", value, "otatal");
            return (Criteria) this;
        }

        public Criteria andOtatalIn(List<Integer> values) {
            addCriterion("otatal in", values, "otatal");
            return (Criteria) this;
        }

        public Criteria andOtatalNotIn(List<Integer> values) {
            addCriterion("otatal not in", values, "otatal");
            return (Criteria) this;
        }

        public Criteria andOtatalBetween(Integer value1, Integer value2) {
            addCriterion("otatal between", value1, value2, "otatal");
            return (Criteria) this;
        }

        public Criteria andOtatalNotBetween(Integer value1, Integer value2) {
            addCriterion("otatal not between", value1, value2, "otatal");
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

        public Criteria andOdateIsNull() {
            addCriterion("odate is null");
            return (Criteria) this;
        }

        public Criteria andOdateIsNotNull() {
            addCriterion("odate is not null");
            return (Criteria) this;
        }

        public Criteria andOdateEqualTo(Date value) {
            addCriterionForJDBCDate("odate =", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("odate <>", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateGreaterThan(Date value) {
            addCriterionForJDBCDate("odate >", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("odate >=", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateLessThan(Date value) {
            addCriterionForJDBCDate("odate <", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("odate <=", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateIn(List<Date> values) {
            addCriterionForJDBCDate("odate in", values, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("odate not in", values, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("odate between", value1, value2, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("odate not between", value1, value2, "odate");
            return (Criteria) this;
        }

        public Criteria andOdeleteIsNull() {
            addCriterion("odelete is null");
            return (Criteria) this;
        }

        public Criteria andOdeleteIsNotNull() {
            addCriterion("odelete is not null");
            return (Criteria) this;
        }

        public Criteria andOdeleteEqualTo(Integer value) {
            addCriterion("odelete =", value, "odelete");
            return (Criteria) this;
        }

        public Criteria andOdeleteNotEqualTo(Integer value) {
            addCriterion("odelete <>", value, "odelete");
            return (Criteria) this;
        }

        public Criteria andOdeleteGreaterThan(Integer value) {
            addCriterion("odelete >", value, "odelete");
            return (Criteria) this;
        }

        public Criteria andOdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("odelete >=", value, "odelete");
            return (Criteria) this;
        }

        public Criteria andOdeleteLessThan(Integer value) {
            addCriterion("odelete <", value, "odelete");
            return (Criteria) this;
        }

        public Criteria andOdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("odelete <=", value, "odelete");
            return (Criteria) this;
        }

        public Criteria andOdeleteIn(List<Integer> values) {
            addCriterion("odelete in", values, "odelete");
            return (Criteria) this;
        }

        public Criteria andOdeleteNotIn(List<Integer> values) {
            addCriterion("odelete not in", values, "odelete");
            return (Criteria) this;
        }

        public Criteria andOdeleteBetween(Integer value1, Integer value2) {
            addCriterion("odelete between", value1, value2, "odelete");
            return (Criteria) this;
        }

        public Criteria andOdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("odelete not between", value1, value2, "odelete");
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