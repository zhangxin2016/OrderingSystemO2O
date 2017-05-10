package com.zx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluateExample() {
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

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("eid not between", value1, value2, "eid");
            return (Criteria) this;
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

        public Criteria andEbuycontentIsNull() {
            addCriterion("ebuycontent is null");
            return (Criteria) this;
        }

        public Criteria andEbuycontentIsNotNull() {
            addCriterion("ebuycontent is not null");
            return (Criteria) this;
        }

        public Criteria andEbuycontentEqualTo(String value) {
            addCriterion("ebuycontent =", value, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEbuycontentNotEqualTo(String value) {
            addCriterion("ebuycontent <>", value, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEbuycontentGreaterThan(String value) {
            addCriterion("ebuycontent >", value, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEbuycontentGreaterThanOrEqualTo(String value) {
            addCriterion("ebuycontent >=", value, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEbuycontentLessThan(String value) {
            addCriterion("ebuycontent <", value, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEbuycontentLessThanOrEqualTo(String value) {
            addCriterion("ebuycontent <=", value, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEbuycontentLike(String value) {
            addCriterion("ebuycontent like", value, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEbuycontentNotLike(String value) {
            addCriterion("ebuycontent not like", value, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEbuycontentIn(List<String> values) {
            addCriterion("ebuycontent in", values, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEbuycontentNotIn(List<String> values) {
            addCriterion("ebuycontent not in", values, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEbuycontentBetween(String value1, String value2) {
            addCriterion("ebuycontent between", value1, value2, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEbuycontentNotBetween(String value1, String value2) {
            addCriterion("ebuycontent not between", value1, value2, "ebuycontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentIsNull() {
            addCriterion("esellcontent is null");
            return (Criteria) this;
        }

        public Criteria andEsellcontentIsNotNull() {
            addCriterion("esellcontent is not null");
            return (Criteria) this;
        }

        public Criteria andEsellcontentEqualTo(String value) {
            addCriterion("esellcontent =", value, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentNotEqualTo(String value) {
            addCriterion("esellcontent <>", value, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentGreaterThan(String value) {
            addCriterion("esellcontent >", value, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentGreaterThanOrEqualTo(String value) {
            addCriterion("esellcontent >=", value, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentLessThan(String value) {
            addCriterion("esellcontent <", value, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentLessThanOrEqualTo(String value) {
            addCriterion("esellcontent <=", value, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentLike(String value) {
            addCriterion("esellcontent like", value, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentNotLike(String value) {
            addCriterion("esellcontent not like", value, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentIn(List<String> values) {
            addCriterion("esellcontent in", values, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentNotIn(List<String> values) {
            addCriterion("esellcontent not in", values, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentBetween(String value1, String value2) {
            addCriterion("esellcontent between", value1, value2, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEsellcontentNotBetween(String value1, String value2) {
            addCriterion("esellcontent not between", value1, value2, "esellcontent");
            return (Criteria) this;
        }

        public Criteria andEbuydateIsNull() {
            addCriterion("ebuydate is null");
            return (Criteria) this;
        }

        public Criteria andEbuydateIsNotNull() {
            addCriterion("ebuydate is not null");
            return (Criteria) this;
        }

        public Criteria andEbuydateEqualTo(Date value) {
            addCriterion("ebuydate =", value, "ebuydate");
            return (Criteria) this;
        }

        public Criteria andEbuydateNotEqualTo(Date value) {
            addCriterion("ebuydate <>", value, "ebuydate");
            return (Criteria) this;
        }

        public Criteria andEbuydateGreaterThan(Date value) {
            addCriterion("ebuydate >", value, "ebuydate");
            return (Criteria) this;
        }

        public Criteria andEbuydateGreaterThanOrEqualTo(Date value) {
            addCriterion("ebuydate >=", value, "ebuydate");
            return (Criteria) this;
        }

        public Criteria andEbuydateLessThan(Date value) {
            addCriterion("ebuydate <", value, "ebuydate");
            return (Criteria) this;
        }

        public Criteria andEbuydateLessThanOrEqualTo(Date value) {
            addCriterion("ebuydate <=", value, "ebuydate");
            return (Criteria) this;
        }

        public Criteria andEbuydateIn(List<Date> values) {
            addCriterion("ebuydate in", values, "ebuydate");
            return (Criteria) this;
        }

        public Criteria andEbuydateNotIn(List<Date> values) {
            addCriterion("ebuydate not in", values, "ebuydate");
            return (Criteria) this;
        }

        public Criteria andEbuydateBetween(Date value1, Date value2) {
            addCriterion("ebuydate between", value1, value2, "ebuydate");
            return (Criteria) this;
        }

        public Criteria andEbuydateNotBetween(Date value1, Date value2) {
            addCriterion("ebuydate not between", value1, value2, "ebuydate");
            return (Criteria) this;
        }

        public Criteria andEselldateIsNull() {
            addCriterion("eselldate is null");
            return (Criteria) this;
        }

        public Criteria andEselldateIsNotNull() {
            addCriterion("eselldate is not null");
            return (Criteria) this;
        }

        public Criteria andEselldateEqualTo(Date value) {
            addCriterion("eselldate =", value, "eselldate");
            return (Criteria) this;
        }

        public Criteria andEselldateNotEqualTo(Date value) {
            addCriterion("eselldate <>", value, "eselldate");
            return (Criteria) this;
        }

        public Criteria andEselldateGreaterThan(Date value) {
            addCriterion("eselldate >", value, "eselldate");
            return (Criteria) this;
        }

        public Criteria andEselldateGreaterThanOrEqualTo(Date value) {
            addCriterion("eselldate >=", value, "eselldate");
            return (Criteria) this;
        }

        public Criteria andEselldateLessThan(Date value) {
            addCriterion("eselldate <", value, "eselldate");
            return (Criteria) this;
        }

        public Criteria andEselldateLessThanOrEqualTo(Date value) {
            addCriterion("eselldate <=", value, "eselldate");
            return (Criteria) this;
        }

        public Criteria andEselldateIn(List<Date> values) {
            addCriterion("eselldate in", values, "eselldate");
            return (Criteria) this;
        }

        public Criteria andEselldateNotIn(List<Date> values) {
            addCriterion("eselldate not in", values, "eselldate");
            return (Criteria) this;
        }

        public Criteria andEselldateBetween(Date value1, Date value2) {
            addCriterion("eselldate between", value1, value2, "eselldate");
            return (Criteria) this;
        }

        public Criteria andEselldateNotBetween(Date value1, Date value2) {
            addCriterion("eselldate not between", value1, value2, "eselldate");
            return (Criteria) this;
        }

        public Criteria andEdeleteIsNull() {
            addCriterion("edelete is null");
            return (Criteria) this;
        }

        public Criteria andEdeleteIsNotNull() {
            addCriterion("edelete is not null");
            return (Criteria) this;
        }

        public Criteria andEdeleteEqualTo(Integer value) {
            addCriterion("edelete =", value, "edelete");
            return (Criteria) this;
        }

        public Criteria andEdeleteNotEqualTo(Integer value) {
            addCriterion("edelete <>", value, "edelete");
            return (Criteria) this;
        }

        public Criteria andEdeleteGreaterThan(Integer value) {
            addCriterion("edelete >", value, "edelete");
            return (Criteria) this;
        }

        public Criteria andEdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("edelete >=", value, "edelete");
            return (Criteria) this;
        }

        public Criteria andEdeleteLessThan(Integer value) {
            addCriterion("edelete <", value, "edelete");
            return (Criteria) this;
        }

        public Criteria andEdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("edelete <=", value, "edelete");
            return (Criteria) this;
        }

        public Criteria andEdeleteIn(List<Integer> values) {
            addCriterion("edelete in", values, "edelete");
            return (Criteria) this;
        }

        public Criteria andEdeleteNotIn(List<Integer> values) {
            addCriterion("edelete not in", values, "edelete");
            return (Criteria) this;
        }

        public Criteria andEdeleteBetween(Integer value1, Integer value2) {
            addCriterion("edelete between", value1, value2, "edelete");
            return (Criteria) this;
        }

        public Criteria andEdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("edelete not between", value1, value2, "edelete");
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