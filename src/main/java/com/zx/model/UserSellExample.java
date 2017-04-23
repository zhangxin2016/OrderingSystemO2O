package com.zx.model;

import java.util.ArrayList;
import java.util.List;

public class UserSellExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserSellExample() {
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

        public Criteria andUsnameIsNull() {
            addCriterion("usname is null");
            return (Criteria) this;
        }

        public Criteria andUsnameIsNotNull() {
            addCriterion("usname is not null");
            return (Criteria) this;
        }

        public Criteria andUsnameEqualTo(String value) {
            addCriterion("usname =", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameNotEqualTo(String value) {
            addCriterion("usname <>", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameGreaterThan(String value) {
            addCriterion("usname >", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameGreaterThanOrEqualTo(String value) {
            addCriterion("usname >=", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameLessThan(String value) {
            addCriterion("usname <", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameLessThanOrEqualTo(String value) {
            addCriterion("usname <=", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameLike(String value) {
            addCriterion("usname like", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameNotLike(String value) {
            addCriterion("usname not like", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameIn(List<String> values) {
            addCriterion("usname in", values, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameNotIn(List<String> values) {
            addCriterion("usname not in", values, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameBetween(String value1, String value2) {
            addCriterion("usname between", value1, value2, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameNotBetween(String value1, String value2) {
            addCriterion("usname not between", value1, value2, "usname");
            return (Criteria) this;
        }

        public Criteria andUstruenameIsNull() {
            addCriterion("ustruename is null");
            return (Criteria) this;
        }

        public Criteria andUstruenameIsNotNull() {
            addCriterion("ustruename is not null");
            return (Criteria) this;
        }

        public Criteria andUstruenameEqualTo(String value) {
            addCriterion("ustruename =", value, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUstruenameNotEqualTo(String value) {
            addCriterion("ustruename <>", value, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUstruenameGreaterThan(String value) {
            addCriterion("ustruename >", value, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUstruenameGreaterThanOrEqualTo(String value) {
            addCriterion("ustruename >=", value, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUstruenameLessThan(String value) {
            addCriterion("ustruename <", value, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUstruenameLessThanOrEqualTo(String value) {
            addCriterion("ustruename <=", value, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUstruenameLike(String value) {
            addCriterion("ustruename like", value, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUstruenameNotLike(String value) {
            addCriterion("ustruename not like", value, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUstruenameIn(List<String> values) {
            addCriterion("ustruename in", values, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUstruenameNotIn(List<String> values) {
            addCriterion("ustruename not in", values, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUstruenameBetween(String value1, String value2) {
            addCriterion("ustruename between", value1, value2, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUstruenameNotBetween(String value1, String value2) {
            addCriterion("ustruename not between", value1, value2, "ustruename");
            return (Criteria) this;
        }

        public Criteria andUspasswordIsNull() {
            addCriterion("uspassword is null");
            return (Criteria) this;
        }

        public Criteria andUspasswordIsNotNull() {
            addCriterion("uspassword is not null");
            return (Criteria) this;
        }

        public Criteria andUspasswordEqualTo(String value) {
            addCriterion("uspassword =", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordNotEqualTo(String value) {
            addCriterion("uspassword <>", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordGreaterThan(String value) {
            addCriterion("uspassword >", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordGreaterThanOrEqualTo(String value) {
            addCriterion("uspassword >=", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordLessThan(String value) {
            addCriterion("uspassword <", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordLessThanOrEqualTo(String value) {
            addCriterion("uspassword <=", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordLike(String value) {
            addCriterion("uspassword like", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordNotLike(String value) {
            addCriterion("uspassword not like", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordIn(List<String> values) {
            addCriterion("uspassword in", values, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordNotIn(List<String> values) {
            addCriterion("uspassword not in", values, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordBetween(String value1, String value2) {
            addCriterion("uspassword between", value1, value2, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordNotBetween(String value1, String value2) {
            addCriterion("uspassword not between", value1, value2, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUsphoneIsNull() {
            addCriterion("usphone is null");
            return (Criteria) this;
        }

        public Criteria andUsphoneIsNotNull() {
            addCriterion("usphone is not null");
            return (Criteria) this;
        }

        public Criteria andUsphoneEqualTo(Integer value) {
            addCriterion("usphone =", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneNotEqualTo(Integer value) {
            addCriterion("usphone <>", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneGreaterThan(Integer value) {
            addCriterion("usphone >", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("usphone >=", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneLessThan(Integer value) {
            addCriterion("usphone <", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneLessThanOrEqualTo(Integer value) {
            addCriterion("usphone <=", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneIn(List<Integer> values) {
            addCriterion("usphone in", values, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneNotIn(List<Integer> values) {
            addCriterion("usphone not in", values, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneBetween(Integer value1, Integer value2) {
            addCriterion("usphone between", value1, value2, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneNotBetween(Integer value1, Integer value2) {
            addCriterion("usphone not between", value1, value2, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsidcardIsNull() {
            addCriterion("usidcard is null");
            return (Criteria) this;
        }

        public Criteria andUsidcardIsNotNull() {
            addCriterion("usidcard is not null");
            return (Criteria) this;
        }

        public Criteria andUsidcardEqualTo(String value) {
            addCriterion("usidcard =", value, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsidcardNotEqualTo(String value) {
            addCriterion("usidcard <>", value, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsidcardGreaterThan(String value) {
            addCriterion("usidcard >", value, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsidcardGreaterThanOrEqualTo(String value) {
            addCriterion("usidcard >=", value, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsidcardLessThan(String value) {
            addCriterion("usidcard <", value, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsidcardLessThanOrEqualTo(String value) {
            addCriterion("usidcard <=", value, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsidcardLike(String value) {
            addCriterion("usidcard like", value, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsidcardNotLike(String value) {
            addCriterion("usidcard not like", value, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsidcardIn(List<String> values) {
            addCriterion("usidcard in", values, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsidcardNotIn(List<String> values) {
            addCriterion("usidcard not in", values, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsidcardBetween(String value1, String value2) {
            addCriterion("usidcard between", value1, value2, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsidcardNotBetween(String value1, String value2) {
            addCriterion("usidcard not between", value1, value2, "usidcard");
            return (Criteria) this;
        }

        public Criteria andUsaddressIsNull() {
            addCriterion("usaddress is null");
            return (Criteria) this;
        }

        public Criteria andUsaddressIsNotNull() {
            addCriterion("usaddress is not null");
            return (Criteria) this;
        }

        public Criteria andUsaddressEqualTo(String value) {
            addCriterion("usaddress =", value, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsaddressNotEqualTo(String value) {
            addCriterion("usaddress <>", value, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsaddressGreaterThan(String value) {
            addCriterion("usaddress >", value, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsaddressGreaterThanOrEqualTo(String value) {
            addCriterion("usaddress >=", value, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsaddressLessThan(String value) {
            addCriterion("usaddress <", value, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsaddressLessThanOrEqualTo(String value) {
            addCriterion("usaddress <=", value, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsaddressLike(String value) {
            addCriterion("usaddress like", value, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsaddressNotLike(String value) {
            addCriterion("usaddress not like", value, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsaddressIn(List<String> values) {
            addCriterion("usaddress in", values, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsaddressNotIn(List<String> values) {
            addCriterion("usaddress not in", values, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsaddressBetween(String value1, String value2) {
            addCriterion("usaddress between", value1, value2, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsaddressNotBetween(String value1, String value2) {
            addCriterion("usaddress not between", value1, value2, "usaddress");
            return (Criteria) this;
        }

        public Criteria andUsdelIsNull() {
            addCriterion("usdel is null");
            return (Criteria) this;
        }

        public Criteria andUsdelIsNotNull() {
            addCriterion("usdel is not null");
            return (Criteria) this;
        }

        public Criteria andUsdelEqualTo(Integer value) {
            addCriterion("usdel =", value, "usdel");
            return (Criteria) this;
        }

        public Criteria andUsdelNotEqualTo(Integer value) {
            addCriterion("usdel <>", value, "usdel");
            return (Criteria) this;
        }

        public Criteria andUsdelGreaterThan(Integer value) {
            addCriterion("usdel >", value, "usdel");
            return (Criteria) this;
        }

        public Criteria andUsdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("usdel >=", value, "usdel");
            return (Criteria) this;
        }

        public Criteria andUsdelLessThan(Integer value) {
            addCriterion("usdel <", value, "usdel");
            return (Criteria) this;
        }

        public Criteria andUsdelLessThanOrEqualTo(Integer value) {
            addCriterion("usdel <=", value, "usdel");
            return (Criteria) this;
        }

        public Criteria andUsdelIn(List<Integer> values) {
            addCriterion("usdel in", values, "usdel");
            return (Criteria) this;
        }

        public Criteria andUsdelNotIn(List<Integer> values) {
            addCriterion("usdel not in", values, "usdel");
            return (Criteria) this;
        }

        public Criteria andUsdelBetween(Integer value1, Integer value2) {
            addCriterion("usdel between", value1, value2, "usdel");
            return (Criteria) this;
        }

        public Criteria andUsdelNotBetween(Integer value1, Integer value2) {
            addCriterion("usdel not between", value1, value2, "usdel");
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