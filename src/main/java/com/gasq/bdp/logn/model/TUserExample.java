package com.gasq.bdp.logn.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNull() {
            addCriterion("mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("mobile_phone =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("mobile_phone <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("mobile_phone >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_phone >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("mobile_phone <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("mobile_phone <=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLike(String value) {
            addCriterion("mobile_phone like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("mobile_phone not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("mobile_phone in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("mobile_phone not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("mobile_phone between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("mobile_phone not between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Short value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Short value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Short value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Short value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Short value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Short> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Short> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Short value1, Short value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Short value1, Short value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserSourceIsNull() {
            addCriterion("user_source is null");
            return (Criteria) this;
        }

        public Criteria andUserSourceIsNotNull() {
            addCriterion("user_source is not null");
            return (Criteria) this;
        }

        public Criteria andUserSourceEqualTo(String value) {
            addCriterion("user_source =", value, "userSource");
            return (Criteria) this;
        }

        public Criteria andUserSourceNotEqualTo(String value) {
            addCriterion("user_source <>", value, "userSource");
            return (Criteria) this;
        }

        public Criteria andUserSourceGreaterThan(String value) {
            addCriterion("user_source >", value, "userSource");
            return (Criteria) this;
        }

        public Criteria andUserSourceGreaterThanOrEqualTo(String value) {
            addCriterion("user_source >=", value, "userSource");
            return (Criteria) this;
        }

        public Criteria andUserSourceLessThan(String value) {
            addCriterion("user_source <", value, "userSource");
            return (Criteria) this;
        }

        public Criteria andUserSourceLessThanOrEqualTo(String value) {
            addCriterion("user_source <=", value, "userSource");
            return (Criteria) this;
        }

        public Criteria andUserSourceLike(String value) {
            addCriterion("user_source like", value, "userSource");
            return (Criteria) this;
        }

        public Criteria andUserSourceNotLike(String value) {
            addCriterion("user_source not like", value, "userSource");
            return (Criteria) this;
        }

        public Criteria andUserSourceIn(List<String> values) {
            addCriterion("user_source in", values, "userSource");
            return (Criteria) this;
        }

        public Criteria andUserSourceNotIn(List<String> values) {
            addCriterion("user_source not in", values, "userSource");
            return (Criteria) this;
        }

        public Criteria andUserSourceBetween(String value1, String value2) {
            addCriterion("user_source between", value1, value2, "userSource");
            return (Criteria) this;
        }

        public Criteria andUserSourceNotBetween(String value1, String value2) {
            addCriterion("user_source not between", value1, value2, "userSource");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRecomCodeIsNull() {
            addCriterion("recom_code is null");
            return (Criteria) this;
        }

        public Criteria andRecomCodeIsNotNull() {
            addCriterion("recom_code is not null");
            return (Criteria) this;
        }

        public Criteria andRecomCodeEqualTo(String value) {
            addCriterion("recom_code =", value, "recomCode");
            return (Criteria) this;
        }

        public Criteria andRecomCodeNotEqualTo(String value) {
            addCriterion("recom_code <>", value, "recomCode");
            return (Criteria) this;
        }

        public Criteria andRecomCodeGreaterThan(String value) {
            addCriterion("recom_code >", value, "recomCode");
            return (Criteria) this;
        }

        public Criteria andRecomCodeGreaterThanOrEqualTo(String value) {
            addCriterion("recom_code >=", value, "recomCode");
            return (Criteria) this;
        }

        public Criteria andRecomCodeLessThan(String value) {
            addCriterion("recom_code <", value, "recomCode");
            return (Criteria) this;
        }

        public Criteria andRecomCodeLessThanOrEqualTo(String value) {
            addCriterion("recom_code <=", value, "recomCode");
            return (Criteria) this;
        }

        public Criteria andRecomCodeLike(String value) {
            addCriterion("recom_code like", value, "recomCode");
            return (Criteria) this;
        }

        public Criteria andRecomCodeNotLike(String value) {
            addCriterion("recom_code not like", value, "recomCode");
            return (Criteria) this;
        }

        public Criteria andRecomCodeIn(List<String> values) {
            addCriterion("recom_code in", values, "recomCode");
            return (Criteria) this;
        }

        public Criteria andRecomCodeNotIn(List<String> values) {
            addCriterion("recom_code not in", values, "recomCode");
            return (Criteria) this;
        }

        public Criteria andRecomCodeBetween(String value1, String value2) {
            addCriterion("recom_code between", value1, value2, "recomCode");
            return (Criteria) this;
        }

        public Criteria andRecomCodeNotBetween(String value1, String value2) {
            addCriterion("recom_code not between", value1, value2, "recomCode");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralIsNull() {
            addCriterion("history_integral is null");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralIsNotNull() {
            addCriterion("history_integral is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralEqualTo(Long value) {
            addCriterion("history_integral =", value, "historyIntegral");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralNotEqualTo(Long value) {
            addCriterion("history_integral <>", value, "historyIntegral");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralGreaterThan(Long value) {
            addCriterion("history_integral >", value, "historyIntegral");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralGreaterThanOrEqualTo(Long value) {
            addCriterion("history_integral >=", value, "historyIntegral");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralLessThan(Long value) {
            addCriterion("history_integral <", value, "historyIntegral");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralLessThanOrEqualTo(Long value) {
            addCriterion("history_integral <=", value, "historyIntegral");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralIn(List<Long> values) {
            addCriterion("history_integral in", values, "historyIntegral");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralNotIn(List<Long> values) {
            addCriterion("history_integral not in", values, "historyIntegral");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralBetween(Long value1, Long value2) {
            addCriterion("history_integral between", value1, value2, "historyIntegral");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegralNotBetween(Long value1, Long value2) {
            addCriterion("history_integral not between", value1, value2, "historyIntegral");
            return (Criteria) this;
        }

        public Criteria andValidIntegralIsNull() {
            addCriterion("valid_integral is null");
            return (Criteria) this;
        }

        public Criteria andValidIntegralIsNotNull() {
            addCriterion("valid_integral is not null");
            return (Criteria) this;
        }

        public Criteria andValidIntegralEqualTo(Long value) {
            addCriterion("valid_integral =", value, "validIntegral");
            return (Criteria) this;
        }

        public Criteria andValidIntegralNotEqualTo(Long value) {
            addCriterion("valid_integral <>", value, "validIntegral");
            return (Criteria) this;
        }

        public Criteria andValidIntegralGreaterThan(Long value) {
            addCriterion("valid_integral >", value, "validIntegral");
            return (Criteria) this;
        }

        public Criteria andValidIntegralGreaterThanOrEqualTo(Long value) {
            addCriterion("valid_integral >=", value, "validIntegral");
            return (Criteria) this;
        }

        public Criteria andValidIntegralLessThan(Long value) {
            addCriterion("valid_integral <", value, "validIntegral");
            return (Criteria) this;
        }

        public Criteria andValidIntegralLessThanOrEqualTo(Long value) {
            addCriterion("valid_integral <=", value, "validIntegral");
            return (Criteria) this;
        }

        public Criteria andValidIntegralIn(List<Long> values) {
            addCriterion("valid_integral in", values, "validIntegral");
            return (Criteria) this;
        }

        public Criteria andValidIntegralNotIn(List<Long> values) {
            addCriterion("valid_integral not in", values, "validIntegral");
            return (Criteria) this;
        }

        public Criteria andValidIntegralBetween(Long value1, Long value2) {
            addCriterion("valid_integral between", value1, value2, "validIntegral");
            return (Criteria) this;
        }

        public Criteria andValidIntegralNotBetween(Long value1, Long value2) {
            addCriterion("valid_integral not between", value1, value2, "validIntegral");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralIsNull() {
            addCriterion("consume_integral is null");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralIsNotNull() {
            addCriterion("consume_integral is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralEqualTo(Long value) {
            addCriterion("consume_integral =", value, "consumeIntegral");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralNotEqualTo(Long value) {
            addCriterion("consume_integral <>", value, "consumeIntegral");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralGreaterThan(Long value) {
            addCriterion("consume_integral >", value, "consumeIntegral");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralGreaterThanOrEqualTo(Long value) {
            addCriterion("consume_integral >=", value, "consumeIntegral");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralLessThan(Long value) {
            addCriterion("consume_integral <", value, "consumeIntegral");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralLessThanOrEqualTo(Long value) {
            addCriterion("consume_integral <=", value, "consumeIntegral");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralIn(List<Long> values) {
            addCriterion("consume_integral in", values, "consumeIntegral");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralNotIn(List<Long> values) {
            addCriterion("consume_integral not in", values, "consumeIntegral");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralBetween(Long value1, Long value2) {
            addCriterion("consume_integral between", value1, value2, "consumeIntegral");
            return (Criteria) this;
        }

        public Criteria andConsumeIntegralNotBetween(Long value1, Long value2) {
            addCriterion("consume_integral not between", value1, value2, "consumeIntegral");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralIsNull() {
            addCriterion("out_date_integral is null");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralIsNotNull() {
            addCriterion("out_date_integral is not null");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralEqualTo(Long value) {
            addCriterion("out_date_integral =", value, "outDateIntegral");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralNotEqualTo(Long value) {
            addCriterion("out_date_integral <>", value, "outDateIntegral");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralGreaterThan(Long value) {
            addCriterion("out_date_integral >", value, "outDateIntegral");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralGreaterThanOrEqualTo(Long value) {
            addCriterion("out_date_integral >=", value, "outDateIntegral");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralLessThan(Long value) {
            addCriterion("out_date_integral <", value, "outDateIntegral");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralLessThanOrEqualTo(Long value) {
            addCriterion("out_date_integral <=", value, "outDateIntegral");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralIn(List<Long> values) {
            addCriterion("out_date_integral in", values, "outDateIntegral");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralNotIn(List<Long> values) {
            addCriterion("out_date_integral not in", values, "outDateIntegral");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralBetween(Long value1, Long value2) {
            addCriterion("out_date_integral between", value1, value2, "outDateIntegral");
            return (Criteria) this;
        }

        public Criteria andOutDateIntegralNotBetween(Long value1, Long value2) {
            addCriterion("out_date_integral not between", value1, value2, "outDateIntegral");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdIsNull() {
            addCriterion("referrer_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdIsNotNull() {
            addCriterion("referrer_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdEqualTo(Long value) {
            addCriterion("referrer_user_id =", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdNotEqualTo(Long value) {
            addCriterion("referrer_user_id <>", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdGreaterThan(Long value) {
            addCriterion("referrer_user_id >", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("referrer_user_id >=", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdLessThan(Long value) {
            addCriterion("referrer_user_id <", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdLessThanOrEqualTo(Long value) {
            addCriterion("referrer_user_id <=", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdIn(List<Long> values) {
            addCriterion("referrer_user_id in", values, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdNotIn(List<Long> values) {
            addCriterion("referrer_user_id not in", values, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdBetween(Long value1, Long value2) {
            addCriterion("referrer_user_id between", value1, value2, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdNotBetween(Long value1, Long value2) {
            addCriterion("referrer_user_id not between", value1, value2, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCreditScoreIsNull() {
            addCriterion("credit_score is null");
            return (Criteria) this;
        }

        public Criteria andCreditScoreIsNotNull() {
            addCriterion("credit_score is not null");
            return (Criteria) this;
        }

        public Criteria andCreditScoreEqualTo(Long value) {
            addCriterion("credit_score =", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreNotEqualTo(Long value) {
            addCriterion("credit_score <>", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreGreaterThan(Long value) {
            addCriterion("credit_score >", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("credit_score >=", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreLessThan(Long value) {
            addCriterion("credit_score <", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreLessThanOrEqualTo(Long value) {
            addCriterion("credit_score <=", value, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreIn(List<Long> values) {
            addCriterion("credit_score in", values, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreNotIn(List<Long> values) {
            addCriterion("credit_score not in", values, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreBetween(Long value1, Long value2) {
            addCriterion("credit_score between", value1, value2, "creditScore");
            return (Criteria) this;
        }

        public Criteria andCreditScoreNotBetween(Long value1, Long value2) {
            addCriterion("credit_score not between", value1, value2, "creditScore");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlIsNull() {
            addCriterion("user_img_url is null");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlIsNotNull() {
            addCriterion("user_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlEqualTo(String value) {
            addCriterion("user_img_url =", value, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlNotEqualTo(String value) {
            addCriterion("user_img_url <>", value, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlGreaterThan(String value) {
            addCriterion("user_img_url >", value, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("user_img_url >=", value, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlLessThan(String value) {
            addCriterion("user_img_url <", value, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlLessThanOrEqualTo(String value) {
            addCriterion("user_img_url <=", value, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlLike(String value) {
            addCriterion("user_img_url like", value, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlNotLike(String value) {
            addCriterion("user_img_url not like", value, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlIn(List<String> values) {
            addCriterion("user_img_url in", values, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlNotIn(List<String> values) {
            addCriterion("user_img_url not in", values, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlBetween(String value1, String value2) {
            addCriterion("user_img_url between", value1, value2, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserImgUrlNotBetween(String value1, String value2) {
            addCriterion("user_img_url not between", value1, value2, "userImgUrl");
            return (Criteria) this;
        }

        public Criteria andLastLoginIsNull() {
            addCriterion("last_login is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIsNotNull() {
            addCriterion("last_login is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginEqualTo(Date value) {
            addCriterion("last_login =", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotEqualTo(Date value) {
            addCriterion("last_login <>", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginGreaterThan(Date value) {
            addCriterion("last_login >", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login >=", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginLessThan(Date value) {
            addCriterion("last_login <", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginLessThanOrEqualTo(Date value) {
            addCriterion("last_login <=", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginIn(List<Date> values) {
            addCriterion("last_login in", values, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotIn(List<Date> values) {
            addCriterion("last_login not in", values, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginBetween(Date value1, Date value2) {
            addCriterion("last_login between", value1, value2, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotBetween(Date value1, Date value2) {
            addCriterion("last_login not between", value1, value2, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andDeviceOsIsNull() {
            addCriterion("device_os is null");
            return (Criteria) this;
        }

        public Criteria andDeviceOsIsNotNull() {
            addCriterion("device_os is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceOsEqualTo(String value) {
            addCriterion("device_os =", value, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andDeviceOsNotEqualTo(String value) {
            addCriterion("device_os <>", value, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andDeviceOsGreaterThan(String value) {
            addCriterion("device_os >", value, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andDeviceOsGreaterThanOrEqualTo(String value) {
            addCriterion("device_os >=", value, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andDeviceOsLessThan(String value) {
            addCriterion("device_os <", value, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andDeviceOsLessThanOrEqualTo(String value) {
            addCriterion("device_os <=", value, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andDeviceOsLike(String value) {
            addCriterion("device_os like", value, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andDeviceOsNotLike(String value) {
            addCriterion("device_os not like", value, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andDeviceOsIn(List<String> values) {
            addCriterion("device_os in", values, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andDeviceOsNotIn(List<String> values) {
            addCriterion("device_os not in", values, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andDeviceOsBetween(String value1, String value2) {
            addCriterion("device_os between", value1, value2, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andDeviceOsNotBetween(String value1, String value2) {
            addCriterion("device_os not between", value1, value2, "deviceOs");
            return (Criteria) this;
        }

        public Criteria andAppTokenIsNull() {
            addCriterion("app_token is null");
            return (Criteria) this;
        }

        public Criteria andAppTokenIsNotNull() {
            addCriterion("app_token is not null");
            return (Criteria) this;
        }

        public Criteria andAppTokenEqualTo(String value) {
            addCriterion("app_token =", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenNotEqualTo(String value) {
            addCriterion("app_token <>", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenGreaterThan(String value) {
            addCriterion("app_token >", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenGreaterThanOrEqualTo(String value) {
            addCriterion("app_token >=", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenLessThan(String value) {
            addCriterion("app_token <", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenLessThanOrEqualTo(String value) {
            addCriterion("app_token <=", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenLike(String value) {
            addCriterion("app_token like", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenNotLike(String value) {
            addCriterion("app_token not like", value, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenIn(List<String> values) {
            addCriterion("app_token in", values, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenNotIn(List<String> values) {
            addCriterion("app_token not in", values, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenBetween(String value1, String value2) {
            addCriterion("app_token between", value1, value2, "appToken");
            return (Criteria) this;
        }

        public Criteria andAppTokenNotBetween(String value1, String value2) {
            addCriterion("app_token not between", value1, value2, "appToken");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdIsNull() {
            addCriterion("wx_pub_open_id is null");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdIsNotNull() {
            addCriterion("wx_pub_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdEqualTo(String value) {
            addCriterion("wx_pub_open_id =", value, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdNotEqualTo(String value) {
            addCriterion("wx_pub_open_id <>", value, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdGreaterThan(String value) {
            addCriterion("wx_pub_open_id >", value, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("wx_pub_open_id >=", value, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdLessThan(String value) {
            addCriterion("wx_pub_open_id <", value, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdLessThanOrEqualTo(String value) {
            addCriterion("wx_pub_open_id <=", value, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdLike(String value) {
            addCriterion("wx_pub_open_id like", value, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdNotLike(String value) {
            addCriterion("wx_pub_open_id not like", value, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdIn(List<String> values) {
            addCriterion("wx_pub_open_id in", values, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdNotIn(List<String> values) {
            addCriterion("wx_pub_open_id not in", values, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdBetween(String value1, String value2) {
            addCriterion("wx_pub_open_id between", value1, value2, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andWxPubOpenIdNotBetween(String value1, String value2) {
            addCriterion("wx_pub_open_id not between", value1, value2, "wxPubOpenId");
            return (Criteria) this;
        }

        public Criteria andGrowthIsNull() {
            addCriterion("growth is null");
            return (Criteria) this;
        }

        public Criteria andGrowthIsNotNull() {
            addCriterion("growth is not null");
            return (Criteria) this;
        }

        public Criteria andGrowthEqualTo(Long value) {
            addCriterion("growth =", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthNotEqualTo(Long value) {
            addCriterion("growth <>", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthGreaterThan(Long value) {
            addCriterion("growth >", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthGreaterThanOrEqualTo(Long value) {
            addCriterion("growth >=", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthLessThan(Long value) {
            addCriterion("growth <", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthLessThanOrEqualTo(Long value) {
            addCriterion("growth <=", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthIn(List<Long> values) {
            addCriterion("growth in", values, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthNotIn(List<Long> values) {
            addCriterion("growth not in", values, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthBetween(Long value1, Long value2) {
            addCriterion("growth between", value1, value2, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthNotBetween(Long value1, Long value2) {
            addCriterion("growth not between", value1, value2, "growth");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Long value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Long value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Long value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Long value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Long value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Long value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Long> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Long> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Long value1, Long value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Long value1, Long value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andPlusFlagIsNull() {
            addCriterion("plus_flag is null");
            return (Criteria) this;
        }

        public Criteria andPlusFlagIsNotNull() {
            addCriterion("plus_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPlusFlagEqualTo(String value) {
            addCriterion("plus_flag =", value, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusFlagNotEqualTo(String value) {
            addCriterion("plus_flag <>", value, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusFlagGreaterThan(String value) {
            addCriterion("plus_flag >", value, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusFlagGreaterThanOrEqualTo(String value) {
            addCriterion("plus_flag >=", value, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusFlagLessThan(String value) {
            addCriterion("plus_flag <", value, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusFlagLessThanOrEqualTo(String value) {
            addCriterion("plus_flag <=", value, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusFlagLike(String value) {
            addCriterion("plus_flag like", value, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusFlagNotLike(String value) {
            addCriterion("plus_flag not like", value, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusFlagIn(List<String> values) {
            addCriterion("plus_flag in", values, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusFlagNotIn(List<String> values) {
            addCriterion("plus_flag not in", values, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusFlagBetween(String value1, String value2) {
            addCriterion("plus_flag between", value1, value2, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusFlagNotBetween(String value1, String value2) {
            addCriterion("plus_flag not between", value1, value2, "plusFlag");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateIsNull() {
            addCriterion("plus_expiry_date is null");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateIsNotNull() {
            addCriterion("plus_expiry_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateEqualTo(Date value) {
            addCriterion("plus_expiry_date =", value, "plusExpiryDate");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateNotEqualTo(Date value) {
            addCriterion("plus_expiry_date <>", value, "plusExpiryDate");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateGreaterThan(Date value) {
            addCriterion("plus_expiry_date >", value, "plusExpiryDate");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("plus_expiry_date >=", value, "plusExpiryDate");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateLessThan(Date value) {
            addCriterion("plus_expiry_date <", value, "plusExpiryDate");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateLessThanOrEqualTo(Date value) {
            addCriterion("plus_expiry_date <=", value, "plusExpiryDate");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateIn(List<Date> values) {
            addCriterion("plus_expiry_date in", values, "plusExpiryDate");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateNotIn(List<Date> values) {
            addCriterion("plus_expiry_date not in", values, "plusExpiryDate");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateBetween(Date value1, Date value2) {
            addCriterion("plus_expiry_date between", value1, value2, "plusExpiryDate");
            return (Criteria) this;
        }

        public Criteria andPlusExpiryDateNotBetween(Date value1, Date value2) {
            addCriterion("plus_expiry_date not between", value1, value2, "plusExpiryDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyIsNull() {
            addCriterion("history_money is null");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyIsNotNull() {
            addCriterion("history_money is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyEqualTo(BigDecimal value) {
            addCriterion("history_money =", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyNotEqualTo(BigDecimal value) {
            addCriterion("history_money <>", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyGreaterThan(BigDecimal value) {
            addCriterion("history_money >", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("history_money >=", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyLessThan(BigDecimal value) {
            addCriterion("history_money <", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("history_money <=", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyIn(List<BigDecimal> values) {
            addCriterion("history_money in", values, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyNotIn(List<BigDecimal> values) {
            addCriterion("history_money not in", values, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("history_money between", value1, value2, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("history_money not between", value1, value2, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyIsNull() {
            addCriterion("valid_money is null");
            return (Criteria) this;
        }

        public Criteria andValidMoneyIsNotNull() {
            addCriterion("valid_money is not null");
            return (Criteria) this;
        }

        public Criteria andValidMoneyEqualTo(BigDecimal value) {
            addCriterion("valid_money =", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyNotEqualTo(BigDecimal value) {
            addCriterion("valid_money <>", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyGreaterThan(BigDecimal value) {
            addCriterion("valid_money >", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("valid_money >=", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyLessThan(BigDecimal value) {
            addCriterion("valid_money <", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("valid_money <=", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyIn(List<BigDecimal> values) {
            addCriterion("valid_money in", values, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyNotIn(List<BigDecimal> values) {
            addCriterion("valid_money not in", values, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("valid_money between", value1, value2, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("valid_money not between", value1, value2, "validMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyIsNull() {
            addCriterion("consume_money is null");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyIsNotNull() {
            addCriterion("consume_money is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyEqualTo(BigDecimal value) {
            addCriterion("consume_money =", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("consume_money <>", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyGreaterThan(BigDecimal value) {
            addCriterion("consume_money >", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_money >=", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyLessThan(BigDecimal value) {
            addCriterion("consume_money <", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_money <=", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyIn(List<BigDecimal> values) {
            addCriterion("consume_money in", values, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("consume_money not in", values, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_money between", value1, value2, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_money not between", value1, value2, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterion("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterion("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterion("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterion("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterion("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterion("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("register_time not between", value1, value2, "registerTime");
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