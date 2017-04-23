package com.zx.model;

import java.util.ArrayList;
import java.util.List;

public class StoresExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoresExample() {
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

        public Criteria andStaddressIsNull() {
            addCriterion("staddress is null");
            return (Criteria) this;
        }

        public Criteria andStaddressIsNotNull() {
            addCriterion("staddress is not null");
            return (Criteria) this;
        }

        public Criteria andStaddressEqualTo(String value) {
            addCriterion("staddress =", value, "staddress");
            return (Criteria) this;
        }

        public Criteria andStaddressNotEqualTo(String value) {
            addCriterion("staddress <>", value, "staddress");
            return (Criteria) this;
        }

        public Criteria andStaddressGreaterThan(String value) {
            addCriterion("staddress >", value, "staddress");
            return (Criteria) this;
        }

        public Criteria andStaddressGreaterThanOrEqualTo(String value) {
            addCriterion("staddress >=", value, "staddress");
            return (Criteria) this;
        }

        public Criteria andStaddressLessThan(String value) {
            addCriterion("staddress <", value, "staddress");
            return (Criteria) this;
        }

        public Criteria andStaddressLessThanOrEqualTo(String value) {
            addCriterion("staddress <=", value, "staddress");
            return (Criteria) this;
        }

        public Criteria andStaddressLike(String value) {
            addCriterion("staddress like", value, "staddress");
            return (Criteria) this;
        }

        public Criteria andStaddressNotLike(String value) {
            addCriterion("staddress not like", value, "staddress");
            return (Criteria) this;
        }

        public Criteria andStaddressIn(List<String> values) {
            addCriterion("staddress in", values, "staddress");
            return (Criteria) this;
        }

        public Criteria andStaddressNotIn(List<String> values) {
            addCriterion("staddress not in", values, "staddress");
            return (Criteria) this;
        }

        public Criteria andStaddressBetween(String value1, String value2) {
            addCriterion("staddress between", value1, value2, "staddress");
            return (Criteria) this;
        }

        public Criteria andStaddressNotBetween(String value1, String value2) {
            addCriterion("staddress not between", value1, value2, "staddress");
            return (Criteria) this;
        }

        public Criteria andStnameIsNull() {
            addCriterion("stname is null");
            return (Criteria) this;
        }

        public Criteria andStnameIsNotNull() {
            addCriterion("stname is not null");
            return (Criteria) this;
        }

        public Criteria andStnameEqualTo(String value) {
            addCriterion("stname =", value, "stname");
            return (Criteria) this;
        }

        public Criteria andStnameNotEqualTo(String value) {
            addCriterion("stname <>", value, "stname");
            return (Criteria) this;
        }

        public Criteria andStnameGreaterThan(String value) {
            addCriterion("stname >", value, "stname");
            return (Criteria) this;
        }

        public Criteria andStnameGreaterThanOrEqualTo(String value) {
            addCriterion("stname >=", value, "stname");
            return (Criteria) this;
        }

        public Criteria andStnameLessThan(String value) {
            addCriterion("stname <", value, "stname");
            return (Criteria) this;
        }

        public Criteria andStnameLessThanOrEqualTo(String value) {
            addCriterion("stname <=", value, "stname");
            return (Criteria) this;
        }

        public Criteria andStnameLike(String value) {
            addCriterion("stname like", value, "stname");
            return (Criteria) this;
        }

        public Criteria andStnameNotLike(String value) {
            addCriterion("stname not like", value, "stname");
            return (Criteria) this;
        }

        public Criteria andStnameIn(List<String> values) {
            addCriterion("stname in", values, "stname");
            return (Criteria) this;
        }

        public Criteria andStnameNotIn(List<String> values) {
            addCriterion("stname not in", values, "stname");
            return (Criteria) this;
        }

        public Criteria andStnameBetween(String value1, String value2) {
            addCriterion("stname between", value1, value2, "stname");
            return (Criteria) this;
        }

        public Criteria andStnameNotBetween(String value1, String value2) {
            addCriterion("stname not between", value1, value2, "stname");
            return (Criteria) this;
        }

        public Criteria andStdescIsNull() {
            addCriterion("stdesc is null");
            return (Criteria) this;
        }

        public Criteria andStdescIsNotNull() {
            addCriterion("stdesc is not null");
            return (Criteria) this;
        }

        public Criteria andStdescEqualTo(String value) {
            addCriterion("stdesc =", value, "stdesc");
            return (Criteria) this;
        }

        public Criteria andStdescNotEqualTo(String value) {
            addCriterion("stdesc <>", value, "stdesc");
            return (Criteria) this;
        }

        public Criteria andStdescGreaterThan(String value) {
            addCriterion("stdesc >", value, "stdesc");
            return (Criteria) this;
        }

        public Criteria andStdescGreaterThanOrEqualTo(String value) {
            addCriterion("stdesc >=", value, "stdesc");
            return (Criteria) this;
        }

        public Criteria andStdescLessThan(String value) {
            addCriterion("stdesc <", value, "stdesc");
            return (Criteria) this;
        }

        public Criteria andStdescLessThanOrEqualTo(String value) {
            addCriterion("stdesc <=", value, "stdesc");
            return (Criteria) this;
        }

        public Criteria andStdescLike(String value) {
            addCriterion("stdesc like", value, "stdesc");
            return (Criteria) this;
        }

        public Criteria andStdescNotLike(String value) {
            addCriterion("stdesc not like", value, "stdesc");
            return (Criteria) this;
        }

        public Criteria andStdescIn(List<String> values) {
            addCriterion("stdesc in", values, "stdesc");
            return (Criteria) this;
        }

        public Criteria andStdescNotIn(List<String> values) {
            addCriterion("stdesc not in", values, "stdesc");
            return (Criteria) this;
        }

        public Criteria andStdescBetween(String value1, String value2) {
            addCriterion("stdesc between", value1, value2, "stdesc");
            return (Criteria) this;
        }

        public Criteria andStdescNotBetween(String value1, String value2) {
            addCriterion("stdesc not between", value1, value2, "stdesc");
            return (Criteria) this;
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

        public Criteria andStdeleteIsNull() {
            addCriterion("stdelete is null");
            return (Criteria) this;
        }

        public Criteria andStdeleteIsNotNull() {
            addCriterion("stdelete is not null");
            return (Criteria) this;
        }

        public Criteria andStdeleteEqualTo(Integer value) {
            addCriterion("stdelete =", value, "stdelete");
            return (Criteria) this;
        }

        public Criteria andStdeleteNotEqualTo(Integer value) {
            addCriterion("stdelete <>", value, "stdelete");
            return (Criteria) this;
        }

        public Criteria andStdeleteGreaterThan(Integer value) {
            addCriterion("stdelete >", value, "stdelete");
            return (Criteria) this;
        }

        public Criteria andStdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("stdelete >=", value, "stdelete");
            return (Criteria) this;
        }

        public Criteria andStdeleteLessThan(Integer value) {
            addCriterion("stdelete <", value, "stdelete");
            return (Criteria) this;
        }

        public Criteria andStdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("stdelete <=", value, "stdelete");
            return (Criteria) this;
        }

        public Criteria andStdeleteIn(List<Integer> values) {
            addCriterion("stdelete in", values, "stdelete");
            return (Criteria) this;
        }

        public Criteria andStdeleteNotIn(List<Integer> values) {
            addCriterion("stdelete not in", values, "stdelete");
            return (Criteria) this;
        }

        public Criteria andStdeleteBetween(Integer value1, Integer value2) {
            addCriterion("stdelete between", value1, value2, "stdelete");
            return (Criteria) this;
        }

        public Criteria andStdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("stdelete not between", value1, value2, "stdelete");
            return (Criteria) this;
        }

        public Criteria andUsidIsNull() {
            addCriterion("usid is null");
            return (Criteria) this;
        }

        public Criteria andUsidIsNotNull() {
            addCriterion("usid is not null");
            return (Criteria) this;
        }

        public Criteria andUsidEqualTo(Integer value) {
            addCriterion("usid =", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidNotEqualTo(Integer value) {
            addCriterion("usid <>", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidGreaterThan(Integer value) {
            addCriterion("usid >", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("usid >=", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidLessThan(Integer value) {
            addCriterion("usid <", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidLessThanOrEqualTo(Integer value) {
            addCriterion("usid <=", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidIn(List<Integer> values) {
            addCriterion("usid in", values, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidNotIn(List<Integer> values) {
            addCriterion("usid not in", values, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidBetween(Integer value1, Integer value2) {
            addCriterion("usid between", value1, value2, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidNotBetween(Integer value1, Integer value2) {
            addCriterion("usid not between", value1, value2, "usid");
            return (Criteria) this;
        }

        public Criteria andUscollIsNull() {
            addCriterion("uscoll is null");
            return (Criteria) this;
        }

        public Criteria andUscollIsNotNull() {
            addCriterion("uscoll is not null");
            return (Criteria) this;
        }

        public Criteria andUscollEqualTo(String value) {
            addCriterion("uscoll =", value, "uscoll");
            return (Criteria) this;
        }

        public Criteria andUscollNotEqualTo(String value) {
            addCriterion("uscoll <>", value, "uscoll");
            return (Criteria) this;
        }

        public Criteria andUscollGreaterThan(String value) {
            addCriterion("uscoll >", value, "uscoll");
            return (Criteria) this;
        }

        public Criteria andUscollGreaterThanOrEqualTo(String value) {
            addCriterion("uscoll >=", value, "uscoll");
            return (Criteria) this;
        }

        public Criteria andUscollLessThan(String value) {
            addCriterion("uscoll <", value, "uscoll");
            return (Criteria) this;
        }

        public Criteria andUscollLessThanOrEqualTo(String value) {
            addCriterion("uscoll <=", value, "uscoll");
            return (Criteria) this;
        }

        public Criteria andUscollLike(String value) {
            addCriterion("uscoll like", value, "uscoll");
            return (Criteria) this;
        }

        public Criteria andUscollNotLike(String value) {
            addCriterion("uscoll not like", value, "uscoll");
            return (Criteria) this;
        }

        public Criteria andUscollIn(List<String> values) {
            addCriterion("uscoll in", values, "uscoll");
            return (Criteria) this;
        }

        public Criteria andUscollNotIn(List<String> values) {
            addCriterion("uscoll not in", values, "uscoll");
            return (Criteria) this;
        }

        public Criteria andUscollBetween(String value1, String value2) {
            addCriterion("uscoll between", value1, value2, "uscoll");
            return (Criteria) this;
        }

        public Criteria andUscollNotBetween(String value1, String value2) {
            addCriterion("uscoll not between", value1, value2, "uscoll");
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