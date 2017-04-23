package com.zx.model;

import java.util.ArrayList;
import java.util.List;

public class UserBuyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserBuyExample() {
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

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUtruenameIsNull() {
            addCriterion("utruename is null");
            return (Criteria) this;
        }

        public Criteria andUtruenameIsNotNull() {
            addCriterion("utruename is not null");
            return (Criteria) this;
        }

        public Criteria andUtruenameEqualTo(String value) {
            addCriterion("utruename =", value, "utruename");
            return (Criteria) this;
        }

        public Criteria andUtruenameNotEqualTo(String value) {
            addCriterion("utruename <>", value, "utruename");
            return (Criteria) this;
        }

        public Criteria andUtruenameGreaterThan(String value) {
            addCriterion("utruename >", value, "utruename");
            return (Criteria) this;
        }

        public Criteria andUtruenameGreaterThanOrEqualTo(String value) {
            addCriterion("utruename >=", value, "utruename");
            return (Criteria) this;
        }

        public Criteria andUtruenameLessThan(String value) {
            addCriterion("utruename <", value, "utruename");
            return (Criteria) this;
        }

        public Criteria andUtruenameLessThanOrEqualTo(String value) {
            addCriterion("utruename <=", value, "utruename");
            return (Criteria) this;
        }

        public Criteria andUtruenameLike(String value) {
            addCriterion("utruename like", value, "utruename");
            return (Criteria) this;
        }

        public Criteria andUtruenameNotLike(String value) {
            addCriterion("utruename not like", value, "utruename");
            return (Criteria) this;
        }

        public Criteria andUtruenameIn(List<String> values) {
            addCriterion("utruename in", values, "utruename");
            return (Criteria) this;
        }

        public Criteria andUtruenameNotIn(List<String> values) {
            addCriterion("utruename not in", values, "utruename");
            return (Criteria) this;
        }

        public Criteria andUtruenameBetween(String value1, String value2) {
            addCriterion("utruename between", value1, value2, "utruename");
            return (Criteria) this;
        }

        public Criteria andUtruenameNotBetween(String value1, String value2) {
            addCriterion("utruename not between", value1, value2, "utruename");
            return (Criteria) this;
        }

        public Criteria andUpasswordIsNull() {
            addCriterion("upassword is null");
            return (Criteria) this;
        }

        public Criteria andUpasswordIsNotNull() {
            addCriterion("upassword is not null");
            return (Criteria) this;
        }

        public Criteria andUpasswordEqualTo(String value) {
            addCriterion("upassword =", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotEqualTo(String value) {
            addCriterion("upassword <>", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordGreaterThan(String value) {
            addCriterion("upassword >", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("upassword >=", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLessThan(String value) {
            addCriterion("upassword <", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLessThanOrEqualTo(String value) {
            addCriterion("upassword <=", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLike(String value) {
            addCriterion("upassword like", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotLike(String value) {
            addCriterion("upassword not like", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordIn(List<String> values) {
            addCriterion("upassword in", values, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotIn(List<String> values) {
            addCriterion("upassword not in", values, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordBetween(String value1, String value2) {
            addCriterion("upassword between", value1, value2, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotBetween(String value1, String value2) {
            addCriterion("upassword not between", value1, value2, "upassword");
            return (Criteria) this;
        }

        public Criteria andUidcardIsNull() {
            addCriterion("uidcard is null");
            return (Criteria) this;
        }

        public Criteria andUidcardIsNotNull() {
            addCriterion("uidcard is not null");
            return (Criteria) this;
        }

        public Criteria andUidcardEqualTo(String value) {
            addCriterion("uidcard =", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardNotEqualTo(String value) {
            addCriterion("uidcard <>", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardGreaterThan(String value) {
            addCriterion("uidcard >", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardGreaterThanOrEqualTo(String value) {
            addCriterion("uidcard >=", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardLessThan(String value) {
            addCriterion("uidcard <", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardLessThanOrEqualTo(String value) {
            addCriterion("uidcard <=", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardLike(String value) {
            addCriterion("uidcard like", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardNotLike(String value) {
            addCriterion("uidcard not like", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardIn(List<String> values) {
            addCriterion("uidcard in", values, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardNotIn(List<String> values) {
            addCriterion("uidcard not in", values, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardBetween(String value1, String value2) {
            addCriterion("uidcard between", value1, value2, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardNotBetween(String value1, String value2) {
            addCriterion("uidcard not between", value1, value2, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUphoneIsNull() {
            addCriterion("uphone is null");
            return (Criteria) this;
        }

        public Criteria andUphoneIsNotNull() {
            addCriterion("uphone is not null");
            return (Criteria) this;
        }

        public Criteria andUphoneEqualTo(Integer value) {
            addCriterion("uphone =", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneNotEqualTo(Integer value) {
            addCriterion("uphone <>", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneGreaterThan(Integer value) {
            addCriterion("uphone >", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("uphone >=", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneLessThan(Integer value) {
            addCriterion("uphone <", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneLessThanOrEqualTo(Integer value) {
            addCriterion("uphone <=", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneIn(List<Integer> values) {
            addCriterion("uphone in", values, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneNotIn(List<Integer> values) {
            addCriterion("uphone not in", values, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneBetween(Integer value1, Integer value2) {
            addCriterion("uphone between", value1, value2, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneNotBetween(Integer value1, Integer value2) {
            addCriterion("uphone not between", value1, value2, "uphone");
            return (Criteria) this;
        }

        public Criteria andUmailIsNull() {
            addCriterion("umail is null");
            return (Criteria) this;
        }

        public Criteria andUmailIsNotNull() {
            addCriterion("umail is not null");
            return (Criteria) this;
        }

        public Criteria andUmailEqualTo(String value) {
            addCriterion("umail =", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotEqualTo(String value) {
            addCriterion("umail <>", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailGreaterThan(String value) {
            addCriterion("umail >", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailGreaterThanOrEqualTo(String value) {
            addCriterion("umail >=", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailLessThan(String value) {
            addCriterion("umail <", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailLessThanOrEqualTo(String value) {
            addCriterion("umail <=", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailLike(String value) {
            addCriterion("umail like", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotLike(String value) {
            addCriterion("umail not like", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailIn(List<String> values) {
            addCriterion("umail in", values, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotIn(List<String> values) {
            addCriterion("umail not in", values, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailBetween(String value1, String value2) {
            addCriterion("umail between", value1, value2, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotBetween(String value1, String value2) {
            addCriterion("umail not between", value1, value2, "umail");
            return (Criteria) this;
        }

        public Criteria andUpicIsNull() {
            addCriterion("upic is null");
            return (Criteria) this;
        }

        public Criteria andUpicIsNotNull() {
            addCriterion("upic is not null");
            return (Criteria) this;
        }

        public Criteria andUpicEqualTo(String value) {
            addCriterion("upic =", value, "upic");
            return (Criteria) this;
        }

        public Criteria andUpicNotEqualTo(String value) {
            addCriterion("upic <>", value, "upic");
            return (Criteria) this;
        }

        public Criteria andUpicGreaterThan(String value) {
            addCriterion("upic >", value, "upic");
            return (Criteria) this;
        }

        public Criteria andUpicGreaterThanOrEqualTo(String value) {
            addCriterion("upic >=", value, "upic");
            return (Criteria) this;
        }

        public Criteria andUpicLessThan(String value) {
            addCriterion("upic <", value, "upic");
            return (Criteria) this;
        }

        public Criteria andUpicLessThanOrEqualTo(String value) {
            addCriterion("upic <=", value, "upic");
            return (Criteria) this;
        }

        public Criteria andUpicLike(String value) {
            addCriterion("upic like", value, "upic");
            return (Criteria) this;
        }

        public Criteria andUpicNotLike(String value) {
            addCriterion("upic not like", value, "upic");
            return (Criteria) this;
        }

        public Criteria andUpicIn(List<String> values) {
            addCriterion("upic in", values, "upic");
            return (Criteria) this;
        }

        public Criteria andUpicNotIn(List<String> values) {
            addCriterion("upic not in", values, "upic");
            return (Criteria) this;
        }

        public Criteria andUpicBetween(String value1, String value2) {
            addCriterion("upic between", value1, value2, "upic");
            return (Criteria) this;
        }

        public Criteria andUpicNotBetween(String value1, String value2) {
            addCriterion("upic not between", value1, value2, "upic");
            return (Criteria) this;
        }

        public Criteria andUsexIsNull() {
            addCriterion("usex is null");
            return (Criteria) this;
        }

        public Criteria andUsexIsNotNull() {
            addCriterion("usex is not null");
            return (Criteria) this;
        }

        public Criteria andUsexEqualTo(String value) {
            addCriterion("usex =", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotEqualTo(String value) {
            addCriterion("usex <>", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexGreaterThan(String value) {
            addCriterion("usex >", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexGreaterThanOrEqualTo(String value) {
            addCriterion("usex >=", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLessThan(String value) {
            addCriterion("usex <", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLessThanOrEqualTo(String value) {
            addCriterion("usex <=", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLike(String value) {
            addCriterion("usex like", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotLike(String value) {
            addCriterion("usex not like", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexIn(List<String> values) {
            addCriterion("usex in", values, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotIn(List<String> values) {
            addCriterion("usex not in", values, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexBetween(String value1, String value2) {
            addCriterion("usex between", value1, value2, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotBetween(String value1, String value2) {
            addCriterion("usex not between", value1, value2, "usex");
            return (Criteria) this;
        }

        public Criteria andUageIsNull() {
            addCriterion("uage is null");
            return (Criteria) this;
        }

        public Criteria andUageIsNotNull() {
            addCriterion("uage is not null");
            return (Criteria) this;
        }

        public Criteria andUageEqualTo(Integer value) {
            addCriterion("uage =", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageNotEqualTo(Integer value) {
            addCriterion("uage <>", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageGreaterThan(Integer value) {
            addCriterion("uage >", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageGreaterThanOrEqualTo(Integer value) {
            addCriterion("uage >=", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageLessThan(Integer value) {
            addCriterion("uage <", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageLessThanOrEqualTo(Integer value) {
            addCriterion("uage <=", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageIn(List<Integer> values) {
            addCriterion("uage in", values, "uage");
            return (Criteria) this;
        }

        public Criteria andUageNotIn(List<Integer> values) {
            addCriterion("uage not in", values, "uage");
            return (Criteria) this;
        }

        public Criteria andUageBetween(Integer value1, Integer value2) {
            addCriterion("uage between", value1, value2, "uage");
            return (Criteria) this;
        }

        public Criteria andUageNotBetween(Integer value1, Integer value2) {
            addCriterion("uage not between", value1, value2, "uage");
            return (Criteria) this;
        }

        public Criteria andUdelIsNull() {
            addCriterion("udel is null");
            return (Criteria) this;
        }

        public Criteria andUdelIsNotNull() {
            addCriterion("udel is not null");
            return (Criteria) this;
        }

        public Criteria andUdelEqualTo(Integer value) {
            addCriterion("udel =", value, "udel");
            return (Criteria) this;
        }

        public Criteria andUdelNotEqualTo(Integer value) {
            addCriterion("udel <>", value, "udel");
            return (Criteria) this;
        }

        public Criteria andUdelGreaterThan(Integer value) {
            addCriterion("udel >", value, "udel");
            return (Criteria) this;
        }

        public Criteria andUdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("udel >=", value, "udel");
            return (Criteria) this;
        }

        public Criteria andUdelLessThan(Integer value) {
            addCriterion("udel <", value, "udel");
            return (Criteria) this;
        }

        public Criteria andUdelLessThanOrEqualTo(Integer value) {
            addCriterion("udel <=", value, "udel");
            return (Criteria) this;
        }

        public Criteria andUdelIn(List<Integer> values) {
            addCriterion("udel in", values, "udel");
            return (Criteria) this;
        }

        public Criteria andUdelNotIn(List<Integer> values) {
            addCriterion("udel not in", values, "udel");
            return (Criteria) this;
        }

        public Criteria andUdelBetween(Integer value1, Integer value2) {
            addCriterion("udel between", value1, value2, "udel");
            return (Criteria) this;
        }

        public Criteria andUdelNotBetween(Integer value1, Integer value2) {
            addCriterion("udel not between", value1, value2, "udel");
            return (Criteria) this;
        }

        public Criteria andUcreditIsNull() {
            addCriterion("ucredit is null");
            return (Criteria) this;
        }

        public Criteria andUcreditIsNotNull() {
            addCriterion("ucredit is not null");
            return (Criteria) this;
        }

        public Criteria andUcreditEqualTo(Integer value) {
            addCriterion("ucredit =", value, "ucredit");
            return (Criteria) this;
        }

        public Criteria andUcreditNotEqualTo(Integer value) {
            addCriterion("ucredit <>", value, "ucredit");
            return (Criteria) this;
        }

        public Criteria andUcreditGreaterThan(Integer value) {
            addCriterion("ucredit >", value, "ucredit");
            return (Criteria) this;
        }

        public Criteria andUcreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("ucredit >=", value, "ucredit");
            return (Criteria) this;
        }

        public Criteria andUcreditLessThan(Integer value) {
            addCriterion("ucredit <", value, "ucredit");
            return (Criteria) this;
        }

        public Criteria andUcreditLessThanOrEqualTo(Integer value) {
            addCriterion("ucredit <=", value, "ucredit");
            return (Criteria) this;
        }

        public Criteria andUcreditIn(List<Integer> values) {
            addCriterion("ucredit in", values, "ucredit");
            return (Criteria) this;
        }

        public Criteria andUcreditNotIn(List<Integer> values) {
            addCriterion("ucredit not in", values, "ucredit");
            return (Criteria) this;
        }

        public Criteria andUcreditBetween(Integer value1, Integer value2) {
            addCriterion("ucredit between", value1, value2, "ucredit");
            return (Criteria) this;
        }

        public Criteria andUcreditNotBetween(Integer value1, Integer value2) {
            addCriterion("ucredit not between", value1, value2, "ucredit");
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