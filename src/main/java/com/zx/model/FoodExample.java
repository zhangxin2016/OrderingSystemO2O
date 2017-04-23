package com.zx.model;

import java.util.ArrayList;
import java.util.List;

public class FoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoodExample() {
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

        public Criteria andFnameIsNull() {
            addCriterion("fname is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("fname is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("fname =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("fname <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("fname >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("fname >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("fname <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("fname <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("fname like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("fname not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("fname in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("fname not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("fname between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("fname not between", value1, value2, "fname");
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

        public Criteria andFpriceIsNull() {
            addCriterion("fprice is null");
            return (Criteria) this;
        }

        public Criteria andFpriceIsNotNull() {
            addCriterion("fprice is not null");
            return (Criteria) this;
        }

        public Criteria andFpriceEqualTo(Integer value) {
            addCriterion("fprice =", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotEqualTo(Integer value) {
            addCriterion("fprice <>", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThan(Integer value) {
            addCriterion("fprice >", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("fprice >=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThan(Integer value) {
            addCriterion("fprice <", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThanOrEqualTo(Integer value) {
            addCriterion("fprice <=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLike(Integer value) {
            addCriterion("fprice like", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotLike(Integer value) {
            addCriterion("fprice not like", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceIn(List<Integer> values) {
            addCriterion("fprice in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotIn(List<Integer> values) {
            addCriterion("fprice not in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceBetween(Integer value1, Integer value2) {
            addCriterion("fprice between", value1, value2, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotBetween(Integer value1, Integer value2) {
            addCriterion("fprice not between", value1, value2, "fprice");
            return (Criteria) this;
        }

        public Criteria andFcollectionIsNull() {
            addCriterion("fcollection is null");
            return (Criteria) this;
        }

        public Criteria andFcollectionIsNotNull() {
            addCriterion("fcollection is not null");
            return (Criteria) this;
        }

        public Criteria andFcollectionEqualTo(Integer value) {
            addCriterion("fcollection =", value, "fcollection");
            return (Criteria) this;
        }

        public Criteria andFcollectionNotEqualTo(Integer value) {
            addCriterion("fcollection <>", value, "fcollection");
            return (Criteria) this;
        }

        public Criteria andFcollectionGreaterThan(Integer value) {
            addCriterion("fcollection >", value, "fcollection");
            return (Criteria) this;
        }

        public Criteria andFcollectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("fcollection >=", value, "fcollection");
            return (Criteria) this;
        }

        public Criteria andFcollectionLessThan(Integer value) {
            addCriterion("fcollection <", value, "fcollection");
            return (Criteria) this;
        }

        public Criteria andFcollectionLessThanOrEqualTo(Integer value) {
            addCriterion("fcollection <=", value, "fcollection");
            return (Criteria) this;
        }

        public Criteria andFcollectionIn(List<Integer> values) {
            addCriterion("fcollection in", values, "fcollection");
            return (Criteria) this;
        }

        public Criteria andFcollectionNotIn(List<Integer> values) {
            addCriterion("fcollection not in", values, "fcollection");
            return (Criteria) this;
        }

        public Criteria andFcollectionBetween(Integer value1, Integer value2) {
            addCriterion("fcollection between", value1, value2, "fcollection");
            return (Criteria) this;
        }

        public Criteria andFcollectionNotBetween(Integer value1, Integer value2) {
            addCriterion("fcollection not between", value1, value2, "fcollection");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeIsNull() {
            addCriterion("fsalesvolume is null");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeIsNotNull() {
            addCriterion("fsalesvolume is not null");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeEqualTo(Integer value) {
            addCriterion("fsalesvolume =", value, "fsalesvolume");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeNotEqualTo(Integer value) {
            addCriterion("fsalesvolume <>", value, "fsalesvolume");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeGreaterThan(Integer value) {
            addCriterion("fsalesvolume >", value, "fsalesvolume");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fsalesvolume >=", value, "fsalesvolume");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeLessThan(Integer value) {
            addCriterion("fsalesvolume <", value, "fsalesvolume");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeLessThanOrEqualTo(Integer value) {
            addCriterion("fsalesvolume <=", value, "fsalesvolume");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeIn(List<Integer> values) {
            addCriterion("fsalesvolume in", values, "fsalesvolume");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeNotIn(List<Integer> values) {
            addCriterion("fsalesvolume not in", values, "fsalesvolume");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeBetween(Integer value1, Integer value2) {
            addCriterion("fsalesvolume between", value1, value2, "fsalesvolume");
            return (Criteria) this;
        }

        public Criteria andFsalesvolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("fsalesvolume not between", value1, value2, "fsalesvolume");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNull() {
            addCriterion("fstatus is null");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNotNull() {
            addCriterion("fstatus is not null");
            return (Criteria) this;
        }

        public Criteria andFstatusEqualTo(Integer value) {
            addCriterion("fstatus =", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotEqualTo(Integer value) {
            addCriterion("fstatus <>", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThan(Integer value) {
            addCriterion("fstatus >", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fstatus >=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThan(Integer value) {
            addCriterion("fstatus <", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThanOrEqualTo(Integer value) {
            addCriterion("fstatus <=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusIn(List<Integer> values) {
            addCriterion("fstatus in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotIn(List<Integer> values) {
            addCriterion("fstatus not in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusBetween(Integer value1, Integer value2) {
            addCriterion("fstatus between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fstatus not between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFpicIsNull() {
            addCriterion("fpic is null");
            return (Criteria) this;
        }

        public Criteria andFpicIsNotNull() {
            addCriterion("fpic is not null");
            return (Criteria) this;
        }

        public Criteria andFpicEqualTo(String value) {
            addCriterion("fpic =", value, "fpic");
            return (Criteria) this;
        }

        public Criteria andFpicNotEqualTo(String value) {
            addCriterion("fpic <>", value, "fpic");
            return (Criteria) this;
        }

        public Criteria andFpicGreaterThan(String value) {
            addCriterion("fpic >", value, "fpic");
            return (Criteria) this;
        }

        public Criteria andFpicGreaterThanOrEqualTo(String value) {
            addCriterion("fpic >=", value, "fpic");
            return (Criteria) this;
        }

        public Criteria andFpicLessThan(String value) {
            addCriterion("fpic <", value, "fpic");
            return (Criteria) this;
        }

        public Criteria andFpicLessThanOrEqualTo(String value) {
            addCriterion("fpic <=", value, "fpic");
            return (Criteria) this;
        }

        public Criteria andFpicLike(String value) {
            addCriterion("fpic like", value, "fpic");
            return (Criteria) this;
        }

        public Criteria andFpicNotLike(String value) {
            addCriterion("fpic not like", value, "fpic");
            return (Criteria) this;
        }

        public Criteria andFpicIn(List<String> values) {
            addCriterion("fpic in", values, "fpic");
            return (Criteria) this;
        }

        public Criteria andFpicNotIn(List<String> values) {
            addCriterion("fpic not in", values, "fpic");
            return (Criteria) this;
        }

        public Criteria andFpicBetween(String value1, String value2) {
            addCriterion("fpic between", value1, value2, "fpic");
            return (Criteria) this;
        }

        public Criteria andFpicNotBetween(String value1, String value2) {
            addCriterion("fpic not between", value1, value2, "fpic");
            return (Criteria) this;
        }

        public Criteria andFdeleteIsNull() {
            addCriterion("fdelete is null");
            return (Criteria) this;
        }

        public Criteria andFdeleteIsNotNull() {
            addCriterion("fdelete is not null");
            return (Criteria) this;
        }

        public Criteria andFdeleteEqualTo(Integer value) {
            addCriterion("fdelete =", value, "fdelete");
            return (Criteria) this;
        }

        public Criteria andFdeleteNotEqualTo(Integer value) {
            addCriterion("fdelete <>", value, "fdelete");
            return (Criteria) this;
        }

        public Criteria andFdeleteGreaterThan(Integer value) {
            addCriterion("fdelete >", value, "fdelete");
            return (Criteria) this;
        }

        public Criteria andFdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("fdelete >=", value, "fdelete");
            return (Criteria) this;
        }

        public Criteria andFdeleteLessThan(Integer value) {
            addCriterion("fdelete <", value, "fdelete");
            return (Criteria) this;
        }

        public Criteria andFdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("fdelete <=", value, "fdelete");
            return (Criteria) this;
        }

        public Criteria andFdeleteIn(List<Integer> values) {
            addCriterion("fdelete in", values, "fdelete");
            return (Criteria) this;
        }

        public Criteria andFdeleteNotIn(List<Integer> values) {
            addCriterion("fdelete not in", values, "fdelete");
            return (Criteria) this;
        }

        public Criteria andFdeleteBetween(Integer value1, Integer value2) {
            addCriterion("fdelete between", value1, value2, "fdelete");
            return (Criteria) this;
        }

        public Criteria andFdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("fdelete not between", value1, value2, "fdelete");
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