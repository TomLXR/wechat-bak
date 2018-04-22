package com.gasq.bdp.logn.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TIntegralGetRecordExample {
    protected String orderByClause;

    protected boolean distinct;
    
    
    /*
     * 增加 limit属性
     */
    protected      Integer start;
    protected      Integer end;

    public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	protected List<Criteria> oredCriteria;

    public TIntegralGetRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSupUserIdIsNull() {
            addCriterion("sup_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSupUserIdIsNotNull() {
            addCriterion("sup_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupUserIdEqualTo(Long value) {
            addCriterion("sup_user_id =", value, "supUserId");
            return (Criteria) this;
        }

        public Criteria andSupUserIdNotEqualTo(Long value) {
            addCriterion("sup_user_id <>", value, "supUserId");
            return (Criteria) this;
        }

        public Criteria andSupUserIdGreaterThan(Long value) {
            addCriterion("sup_user_id >", value, "supUserId");
            return (Criteria) this;
        }

        public Criteria andSupUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sup_user_id >=", value, "supUserId");
            return (Criteria) this;
        }

        public Criteria andSupUserIdLessThan(Long value) {
            addCriterion("sup_user_id <", value, "supUserId");
            return (Criteria) this;
        }

        public Criteria andSupUserIdLessThanOrEqualTo(Long value) {
            addCriterion("sup_user_id <=", value, "supUserId");
            return (Criteria) this;
        }

        public Criteria andSupUserIdIn(List<Long> values) {
            addCriterion("sup_user_id in", values, "supUserId");
            return (Criteria) this;
        }

        public Criteria andSupUserIdNotIn(List<Long> values) {
            addCriterion("sup_user_id not in", values, "supUserId");
            return (Criteria) this;
        }

        public Criteria andSupUserIdBetween(Long value1, Long value2) {
            addCriterion("sup_user_id between", value1, value2, "supUserId");
            return (Criteria) this;
        }

        public Criteria andSupUserIdNotBetween(Long value1, Long value2) {
            addCriterion("sup_user_id not between", value1, value2, "supUserId");
            return (Criteria) this;
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

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Long value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Long value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Long value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Long value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Long value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Long value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Long> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Long> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Long value1, Long value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Long value1, Long value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeIsNull() {
            addCriterion("get_date_time is null");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeIsNotNull() {
            addCriterion("get_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeEqualTo(Date value) {
            addCriterion("get_date_time =", value, "getDateTime");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeNotEqualTo(Date value) {
            addCriterion("get_date_time <>", value, "getDateTime");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeGreaterThan(Date value) {
            addCriterion("get_date_time >", value, "getDateTime");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("get_date_time >=", value, "getDateTime");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeLessThan(Date value) {
            addCriterion("get_date_time <", value, "getDateTime");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("get_date_time <=", value, "getDateTime");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeIn(List<Date> values) {
            addCriterion("get_date_time in", values, "getDateTime");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeNotIn(List<Date> values) {
            addCriterion("get_date_time not in", values, "getDateTime");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeBetween(Date value1, Date value2) {
            addCriterion("get_date_time between", value1, value2, "getDateTime");
            return (Criteria) this;
        }

        public Criteria andGetDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("get_date_time not between", value1, value2, "getDateTime");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Long value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Long value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Long value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Long value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Long> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Long> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Long value1, Long value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andValidDateIsNull() {
            addCriterion("valid_date is null");
            return (Criteria) this;
        }

        public Criteria andValidDateIsNotNull() {
            addCriterion("valid_date is not null");
            return (Criteria) this;
        }

        public Criteria andValidDateEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date =", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date <>", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateGreaterThan(Date value) {
            addCriterionForJDBCDate("valid_date >", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date >=", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateLessThan(Date value) {
            addCriterionForJDBCDate("valid_date <", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date <=", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateIn(List<Date> values) {
            addCriterionForJDBCDate("valid_date in", values, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("valid_date not in", values, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("valid_date between", value1, value2, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("valid_date not between", value1, value2, "validDate");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralIsNull() {
            addCriterion("has_used_integral is null");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralIsNotNull() {
            addCriterion("has_used_integral is not null");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralEqualTo(Long value) {
            addCriterion("has_used_integral =", value, "hasUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralNotEqualTo(Long value) {
            addCriterion("has_used_integral <>", value, "hasUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralGreaterThan(Long value) {
            addCriterion("has_used_integral >", value, "hasUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralGreaterThanOrEqualTo(Long value) {
            addCriterion("has_used_integral >=", value, "hasUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralLessThan(Long value) {
            addCriterion("has_used_integral <", value, "hasUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralLessThanOrEqualTo(Long value) {
            addCriterion("has_used_integral <=", value, "hasUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralIn(List<Long> values) {
            addCriterion("has_used_integral in", values, "hasUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralNotIn(List<Long> values) {
            addCriterion("has_used_integral not in", values, "hasUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralBetween(Long value1, Long value2) {
            addCriterion("has_used_integral between", value1, value2, "hasUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andHasUsedIntegralNotBetween(Long value1, Long value2) {
            addCriterion("has_used_integral not between", value1, value2, "hasUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralIsNull() {
            addCriterion("not_used_integral is null");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralIsNotNull() {
            addCriterion("not_used_integral is not null");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralEqualTo(Long value) {
            addCriterion("not_used_integral =", value, "notUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralNotEqualTo(Long value) {
            addCriterion("not_used_integral <>", value, "notUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralGreaterThan(Long value) {
            addCriterion("not_used_integral >", value, "notUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralGreaterThanOrEqualTo(Long value) {
            addCriterion("not_used_integral >=", value, "notUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralLessThan(Long value) {
            addCriterion("not_used_integral <", value, "notUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralLessThanOrEqualTo(Long value) {
            addCriterion("not_used_integral <=", value, "notUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralIn(List<Long> values) {
            addCriterion("not_used_integral in", values, "notUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralNotIn(List<Long> values) {
            addCriterion("not_used_integral not in", values, "notUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralBetween(Long value1, Long value2) {
            addCriterion("not_used_integral between", value1, value2, "notUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andNotUsedIntegralNotBetween(Long value1, Long value2) {
            addCriterion("not_used_integral not between", value1, value2, "notUsedIntegral");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNull() {
            addCriterion("rule_id is null");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNotNull() {
            addCriterion("rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuleIdEqualTo(Long value) {
            addCriterion("rule_id =", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotEqualTo(Long value) {
            addCriterion("rule_id <>", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThan(Long value) {
            addCriterion("rule_id >", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rule_id >=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThan(Long value) {
            addCriterion("rule_id <", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThanOrEqualTo(Long value) {
            addCriterion("rule_id <=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdIn(List<Long> values) {
            addCriterion("rule_id in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotIn(List<Long> values) {
            addCriterion("rule_id not in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdBetween(Long value1, Long value2) {
            addCriterion("rule_id between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotBetween(Long value1, Long value2) {
            addCriterion("rule_id not between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(BigDecimal value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(BigDecimal value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(BigDecimal value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(BigDecimal value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<BigDecimal> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<BigDecimal> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeIsNull() {
            addCriterion("ava_date_time is null");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeIsNotNull() {
            addCriterion("ava_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeEqualTo(Date value) {
            addCriterion("ava_date_time =", value, "avaDateTime");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeNotEqualTo(Date value) {
            addCriterion("ava_date_time <>", value, "avaDateTime");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeGreaterThan(Date value) {
            addCriterion("ava_date_time >", value, "avaDateTime");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ava_date_time >=", value, "avaDateTime");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeLessThan(Date value) {
            addCriterion("ava_date_time <", value, "avaDateTime");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("ava_date_time <=", value, "avaDateTime");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeIn(List<Date> values) {
            addCriterion("ava_date_time in", values, "avaDateTime");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeNotIn(List<Date> values) {
            addCriterion("ava_date_time not in", values, "avaDateTime");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeBetween(Date value1, Date value2) {
            addCriterion("ava_date_time between", value1, value2, "avaDateTime");
            return (Criteria) this;
        }

        public Criteria andAvaDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("ava_date_time not between", value1, value2, "avaDateTime");
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