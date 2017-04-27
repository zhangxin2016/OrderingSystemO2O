package com.zx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DetailorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DetailorderExample() {
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

        public Criteria andDoidIsNull() {
            addCriterion("doid is null");
            return (Criteria) this;
        }

        public Criteria andDoidIsNotNull() {
            addCriterion("doid is not null");
            return (Criteria) this;
        }

        public Criteria andDoidEqualTo(Integer value) {
            addCriterion("doid =", value, "doid");
            return (Criteria) this;
        }

        public Criteria andDoidNotEqualTo(Integer value) {
            addCriterion("doid <>", value, "doid");
            return (Criteria) this;
        }

        public Criteria andDoidGreaterThan(Integer value) {
            addCriterion("doid >", value, "doid");
            return (Criteria) this;
        }

        public Criteria andDoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("doid >=", value, "doid");
            return (Criteria) this;
        }

        public Criteria andDoidLessThan(Integer value) {
            addCriterion("doid <", value, "doid");
            return (Criteria) this;
        }

        public Criteria andDoidLessThanOrEqualTo(Integer value) {
            addCriterion("doid <=", value, "doid");
            return (Criteria) this;
        }

        public Criteria andDoidIn(List<Integer> values) {
            addCriterion("doid in", values, "doid");
            return (Criteria) this;
        }

        public Criteria andDoidNotIn(List<Integer> values) {
            addCriterion("doid not in", values, "doid");
            return (Criteria) this;
        }

        public Criteria andDoidBetween(Integer value1, Integer value2) {
            addCriterion("doid between", value1, value2, "doid");
            return (Criteria) this;
        }

        public Criteria andDoidNotBetween(Integer value1, Integer value2) {
            addCriterion("doid not between", value1, value2, "doid");
            return (Criteria) this;
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

        public Criteria andDonumIsNull() {
            addCriterion("donum is null");
            return (Criteria) this;
        }

        public Criteria andDonumIsNotNull() {
            addCriterion("donum is not null");
            return (Criteria) this;
        }

        public Criteria andDonumEqualTo(Integer value) {
            addCriterion("donum =", value, "donum");
            return (Criteria) this;
        }

        public Criteria andDonumNotEqualTo(Integer value) {
            addCriterion("donum <>", value, "donum");
            return (Criteria) this;
        }

        public Criteria andDonumGreaterThan(Integer value) {
            addCriterion("donum >", value, "donum");
            return (Criteria) this;
        }

        public Criteria andDonumGreaterThanOrEqualTo(Integer value) {
            addCriterion("donum >=", value, "donum");
            return (Criteria) this;
        }

        public Criteria andDonumLessThan(Integer value) {
            addCriterion("donum <", value, "donum");
            return (Criteria) this;
        }

        public Criteria andDonumLessThanOrEqualTo(Integer value) {
            addCriterion("donum <=", value, "donum");
            return (Criteria) this;
        }

        public Criteria andDonumIn(List<Integer> values) {
            addCriterion("donum in", values, "donum");
            return (Criteria) this;
        }

        public Criteria andDonumNotIn(List<Integer> values) {
            addCriterion("donum not in", values, "donum");
            return (Criteria) this;
        }

        public Criteria andDonumBetween(Integer value1, Integer value2) {
            addCriterion("donum between", value1, value2, "donum");
            return (Criteria) this;
        }

        public Criteria andDonumNotBetween(Integer value1, Integer value2) {
            addCriterion("donum not between", value1, value2, "donum");
            return (Criteria) this;
        }

        public Criteria andDopriIsNull() {
            addCriterion("dopri is null");
            return (Criteria) this;
        }

        public Criteria andDopriIsNotNull() {
            addCriterion("dopri is not null");
            return (Criteria) this;
        }

        public Criteria andDopriEqualTo(Integer value) {
            addCriterion("dopri =", value, "dopri");
            return (Criteria) this;
        }

        public Criteria andDopriNotEqualTo(Integer value) {
            addCriterion("dopri <>", value, "dopri");
            return (Criteria) this;
        }

        public Criteria andDopriGreaterThan(Integer value) {
            addCriterion("dopri >", value, "dopri");
            return (Criteria) this;
        }

        public Criteria andDopriGreaterThanOrEqualTo(Integer value) {
            addCriterion("dopri >=", value, "dopri");
            return (Criteria) this;
        }

        public Criteria andDopriLessThan(Integer value) {
            addCriterion("dopri <", value, "dopri");
            return (Criteria) this;
        }

        public Criteria andDopriLessThanOrEqualTo(Integer value) {
            addCriterion("dopri <=", value, "dopri");
            return (Criteria) this;
        }

        public Criteria andDopriIn(List<Integer> values) {
            addCriterion("dopri in", values, "dopri");
            return (Criteria) this;
        }

        public Criteria andDopriNotIn(List<Integer> values) {
            addCriterion("dopri not in", values, "dopri");
            return (Criteria) this;
        }

        public Criteria andDopriBetween(Integer value1, Integer value2) {
            addCriterion("dopri between", value1, value2, "dopri");
            return (Criteria) this;
        }

        public Criteria andDopriNotBetween(Integer value1, Integer value2) {
            addCriterion("dopri not between", value1, value2, "dopri");
            return (Criteria) this;
        }

        public Criteria andDodateIsNull() {
            addCriterion("dodate is null");
            return (Criteria) this;
        }

        public Criteria andDodateIsNotNull() {
            addCriterion("dodate is not null");
            return (Criteria) this;
        }

        public Criteria andDodateEqualTo(Date value) {
            addCriterionForJDBCDate("dodate =", value, "dodate");
            return (Criteria) this;
        }

        public Criteria andDodateNotEqualTo(Date value) {
            addCriterionForJDBCDate("dodate <>", value, "dodate");
            return (Criteria) this;
        }

        public Criteria andDodateGreaterThan(Date value) {
            addCriterionForJDBCDate("dodate >", value, "dodate");
            return (Criteria) this;
        }

        public Criteria andDodateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dodate >=", value, "dodate");
            return (Criteria) this;
        }

        public Criteria andDodateLessThan(Date value) {
            addCriterionForJDBCDate("dodate <", value, "dodate");
            return (Criteria) this;
        }

        public Criteria andDodateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dodate <=", value, "dodate");
            return (Criteria) this;
        }

        public Criteria andDodateIn(List<Date> values) {
            addCriterionForJDBCDate("dodate in", values, "dodate");
            return (Criteria) this;
        }

        public Criteria andDodateNotIn(List<Date> values) {
            addCriterionForJDBCDate("dodate not in", values, "dodate");
            return (Criteria) this;
        }

        public Criteria andDodateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dodate between", value1, value2, "dodate");
            return (Criteria) this;
        }

        public Criteria andDodateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dodate not between", value1, value2, "dodate");
            return (Criteria) this;
        }

        public Criteria andDostatusIsNull() {
            addCriterion("dostatus is null");
            return (Criteria) this;
        }

        public Criteria andDostatusIsNotNull() {
            addCriterion("dostatus is not null");
            return (Criteria) this;
        }

        public Criteria andDostatusEqualTo(Integer value) {
            addCriterion("dostatus =", value, "dostatus");
            return (Criteria) this;
        }

        public Criteria andDostatusNotEqualTo(Integer value) {
            addCriterion("dostatus <>", value, "dostatus");
            return (Criteria) this;
        }

        public Criteria andDostatusGreaterThan(Integer value) {
            addCriterion("dostatus >", value, "dostatus");
            return (Criteria) this;
        }

        public Criteria andDostatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("dostatus >=", value, "dostatus");
            return (Criteria) this;
        }

        public Criteria andDostatusLessThan(Integer value) {
            addCriterion("dostatus <", value, "dostatus");
            return (Criteria) this;
        }

        public Criteria andDostatusLessThanOrEqualTo(Integer value) {
            addCriterion("dostatus <=", value, "dostatus");
            return (Criteria) this;
        }

        public Criteria andDostatusIn(List<Integer> values) {
            addCriterion("dostatus in", values, "dostatus");
            return (Criteria) this;
        }

        public Criteria andDostatusNotIn(List<Integer> values) {
            addCriterion("dostatus not in", values, "dostatus");
            return (Criteria) this;
        }

        public Criteria andDostatusBetween(Integer value1, Integer value2) {
            addCriterion("dostatus between", value1, value2, "dostatus");
            return (Criteria) this;
        }

        public Criteria andDostatusNotBetween(Integer value1, Integer value2) {
            addCriterion("dostatus not between", value1, value2, "dostatus");
            return (Criteria) this;
        }

        public Criteria andAdidIsNull() {
            addCriterion("adid is null");
            return (Criteria) this;
        }

        public Criteria andAdidIsNotNull() {
            addCriterion("adid is not null");
            return (Criteria) this;
        }

        public Criteria andAdidEqualTo(Integer value) {
            addCriterion("adid =", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidNotEqualTo(Integer value) {
            addCriterion("adid <>", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidGreaterThan(Integer value) {
            addCriterion("adid >", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adid >=", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidLessThan(Integer value) {
            addCriterion("adid <", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidLessThanOrEqualTo(Integer value) {
            addCriterion("adid <=", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidIn(List<Integer> values) {
            addCriterion("adid in", values, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidNotIn(List<Integer> values) {
            addCriterion("adid not in", values, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidBetween(Integer value1, Integer value2) {
            addCriterion("adid between", value1, value2, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidNotBetween(Integer value1, Integer value2) {
            addCriterion("adid not between", value1, value2, "adid");
            return (Criteria) this;
        }

        public Criteria andDodeleteIsNull() {
            addCriterion("dodelete is null");
            return (Criteria) this;
        }

        public Criteria andDodeleteIsNotNull() {
            addCriterion("dodelete is not null");
            return (Criteria) this;
        }

        public Criteria andDodeleteEqualTo(Integer value) {
            addCriterion("dodelete =", value, "dodelete");
            return (Criteria) this;
        }

        public Criteria andDodeleteNotEqualTo(Integer value) {
            addCriterion("dodelete <>", value, "dodelete");
            return (Criteria) this;
        }

        public Criteria andDodeleteGreaterThan(Integer value) {
            addCriterion("dodelete >", value, "dodelete");
            return (Criteria) this;
        }

        public Criteria andDodeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("dodelete >=", value, "dodelete");
            return (Criteria) this;
        }

        public Criteria andDodeleteLessThan(Integer value) {
            addCriterion("dodelete <", value, "dodelete");
            return (Criteria) this;
        }

        public Criteria andDodeleteLessThanOrEqualTo(Integer value) {
            addCriterion("dodelete <=", value, "dodelete");
            return (Criteria) this;
        }

        public Criteria andDodeleteIn(List<Integer> values) {
            addCriterion("dodelete in", values, "dodelete");
            return (Criteria) this;
        }

        public Criteria andDodeleteNotIn(List<Integer> values) {
            addCriterion("dodelete not in", values, "dodelete");
            return (Criteria) this;
        }

        public Criteria andDodeleteBetween(Integer value1, Integer value2) {
            addCriterion("dodelete between", value1, value2, "dodelete");
            return (Criteria) this;
        }

        public Criteria andDodeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("dodelete not between", value1, value2, "dodelete");
            return (Criteria) this;
        }

        public Criteria andDomessageIsNull() {
            addCriterion("domessage is null");
            return (Criteria) this;
        }

        public Criteria andDomessageIsNotNull() {
            addCriterion("domessage is not null");
            return (Criteria) this;
        }

        public Criteria andDomessageEqualTo(String value) {
            addCriterion("domessage =", value, "domessage");
            return (Criteria) this;
        }

        public Criteria andDomessageNotEqualTo(String value) {
            addCriterion("domessage <>", value, "domessage");
            return (Criteria) this;
        }

        public Criteria andDomessageGreaterThan(String value) {
            addCriterion("domessage >", value, "domessage");
            return (Criteria) this;
        }

        public Criteria andDomessageGreaterThanOrEqualTo(String value) {
            addCriterion("domessage >=", value, "domessage");
            return (Criteria) this;
        }

        public Criteria andDomessageLessThan(String value) {
            addCriterion("domessage <", value, "domessage");
            return (Criteria) this;
        }

        public Criteria andDomessageLessThanOrEqualTo(String value) {
            addCriterion("domessage <=", value, "domessage");
            return (Criteria) this;
        }

        public Criteria andDomessageLike(String value) {
            addCriterion("domessage like", value, "domessage");
            return (Criteria) this;
        }

        public Criteria andDomessageNotLike(String value) {
            addCriterion("domessage not like", value, "domessage");
            return (Criteria) this;
        }

        public Criteria andDomessageIn(List<String> values) {
            addCriterion("domessage in", values, "domessage");
            return (Criteria) this;
        }

        public Criteria andDomessageNotIn(List<String> values) {
            addCriterion("domessage not in", values, "domessage");
            return (Criteria) this;
        }

        public Criteria andDomessageBetween(String value1, String value2) {
            addCriterion("domessage between", value1, value2, "domessage");
            return (Criteria) this;
        }

        public Criteria andDomessageNotBetween(String value1, String value2) {
            addCriterion("domessage not between", value1, value2, "domessage");
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