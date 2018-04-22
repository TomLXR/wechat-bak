package com.gasq.bdp.logn.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TUserShareRuleExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TUserShareRuleExample() {
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

		public Criteria andShareTypeIsNull() {
			addCriterion("share_type is null");
			return (Criteria) this;
		}

		public Criteria andShareTypeIsNotNull() {
			addCriterion("share_type is not null");
			return (Criteria) this;
		}

		public Criteria andShareTypeEqualTo(Integer value) {
			addCriterion("share_type =", value, "shareType");
			return (Criteria) this;
		}

		public Criteria andShareTypeNotEqualTo(Integer value) {
			addCriterion("share_type <>", value, "shareType");
			return (Criteria) this;
		}

		public Criteria andShareTypeGreaterThan(Integer value) {
			addCriterion("share_type >", value, "shareType");
			return (Criteria) this;
		}

		public Criteria andShareTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("share_type >=", value, "shareType");
			return (Criteria) this;
		}

		public Criteria andShareTypeLessThan(Integer value) {
			addCriterion("share_type <", value, "shareType");
			return (Criteria) this;
		}

		public Criteria andShareTypeLessThanOrEqualTo(Integer value) {
			addCriterion("share_type <=", value, "shareType");
			return (Criteria) this;
		}

		public Criteria andShareTypeIn(List<Integer> values) {
			addCriterion("share_type in", values, "shareType");
			return (Criteria) this;
		}

		public Criteria andShareTypeNotIn(List<Integer> values) {
			addCriterion("share_type not in", values, "shareType");
			return (Criteria) this;
		}

		public Criteria andShareTypeBetween(Integer value1, Integer value2) {
			addCriterion("share_type between", value1, value2, "shareType");
			return (Criteria) this;
		}

		public Criteria andShareTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("share_type not between", value1, value2, "shareType");
			return (Criteria) this;
		}

		public Criteria andLevelIsNull() {
			addCriterion("level is null");
			return (Criteria) this;
		}

		public Criteria andLevelIsNotNull() {
			addCriterion("level is not null");
			return (Criteria) this;
		}

		public Criteria andLevelEqualTo(Short value) {
			addCriterion("level =", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotEqualTo(Short value) {
			addCriterion("level <>", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelGreaterThan(Short value) {
			addCriterion("level >", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelGreaterThanOrEqualTo(Short value) {
			addCriterion("level >=", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelLessThan(Short value) {
			addCriterion("level <", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelLessThanOrEqualTo(Short value) {
			addCriterion("level <=", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelIn(List<Short> values) {
			addCriterion("level in", values, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotIn(List<Short> values) {
			addCriterion("level not in", values, "level");
			return (Criteria) this;
		}

		public Criteria andLevelBetween(Short value1, Short value2) {
			addCriterion("level between", value1, value2, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotBetween(Short value1, Short value2) {
			addCriterion("level not between", value1, value2, "level");
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