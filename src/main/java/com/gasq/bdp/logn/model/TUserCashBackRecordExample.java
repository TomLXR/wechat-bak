package com.gasq.bdp.logn.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TUserCashBackRecordExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TUserCashBackRecordExample() {
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

		public Criteria andMoneyIsNull() {
			addCriterion("money is null");
			return (Criteria) this;
		}

		public Criteria andMoneyIsNotNull() {
			addCriterion("money is not null");
			return (Criteria) this;
		}

		public Criteria andMoneyEqualTo(BigDecimal value) {
			addCriterion("money =", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotEqualTo(BigDecimal value) {
			addCriterion("money <>", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThan(BigDecimal value) {
			addCriterion("money >", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("money >=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThan(BigDecimal value) {
			addCriterion("money <", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("money <=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyIn(List<BigDecimal> values) {
			addCriterion("money in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotIn(List<BigDecimal> values) {
			addCriterion("money not in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("money between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("money not between", value1, value2, "money");
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