package com.gasq.bdp.logn.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TIntegralUseRecordExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TIntegralUseRecordExample() {
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

		public Criteria andGetIntegralIdIsNull() {
			addCriterion("get_integral_id is null");
			return (Criteria) this;
		}

		public Criteria andGetIntegralIdIsNotNull() {
			addCriterion("get_integral_id is not null");
			return (Criteria) this;
		}

		public Criteria andGetIntegralIdEqualTo(Long value) {
			addCriterion("get_integral_id =", value, "getIntegralId");
			return (Criteria) this;
		}

		public Criteria andGetIntegralIdNotEqualTo(Long value) {
			addCriterion("get_integral_id <>", value, "getIntegralId");
			return (Criteria) this;
		}

		public Criteria andGetIntegralIdGreaterThan(Long value) {
			addCriterion("get_integral_id >", value, "getIntegralId");
			return (Criteria) this;
		}

		public Criteria andGetIntegralIdGreaterThanOrEqualTo(Long value) {
			addCriterion("get_integral_id >=", value, "getIntegralId");
			return (Criteria) this;
		}

		public Criteria andGetIntegralIdLessThan(Long value) {
			addCriterion("get_integral_id <", value, "getIntegralId");
			return (Criteria) this;
		}

		public Criteria andGetIntegralIdLessThanOrEqualTo(Long value) {
			addCriterion("get_integral_id <=", value, "getIntegralId");
			return (Criteria) this;
		}

		public Criteria andGetIntegralIdIn(List<Long> values) {
			addCriterion("get_integral_id in", values, "getIntegralId");
			return (Criteria) this;
		}

		public Criteria andGetIntegralIdNotIn(List<Long> values) {
			addCriterion("get_integral_id not in", values, "getIntegralId");
			return (Criteria) this;
		}

		public Criteria andGetIntegralIdBetween(Long value1, Long value2) {
			addCriterion("get_integral_id between", value1, value2, "getIntegralId");
			return (Criteria) this;
		}

		public Criteria andGetIntegralIdNotBetween(Long value1, Long value2) {
			addCriterion("get_integral_id not between", value1, value2, "getIntegralId");
			return (Criteria) this;
		}

		public Criteria andProjectIdIsNull() {
			addCriterion("project_id is null");
			return (Criteria) this;
		}

		public Criteria andProjectIdIsNotNull() {
			addCriterion("project_id is not null");
			return (Criteria) this;
		}

		public Criteria andProjectIdEqualTo(Long value) {
			addCriterion("project_id =", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdNotEqualTo(Long value) {
			addCriterion("project_id <>", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdGreaterThan(Long value) {
			addCriterion("project_id >", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
			addCriterion("project_id >=", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdLessThan(Long value) {
			addCriterion("project_id <", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdLessThanOrEqualTo(Long value) {
			addCriterion("project_id <=", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdIn(List<Long> values) {
			addCriterion("project_id in", values, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdNotIn(List<Long> values) {
			addCriterion("project_id not in", values, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdBetween(Long value1, Long value2) {
			addCriterion("project_id between", value1, value2, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdNotBetween(Long value1, Long value2) {
			addCriterion("project_id not between", value1, value2, "projectId");
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

		public Criteria andUseDateTimeIsNull() {
			addCriterion("use_date_time is null");
			return (Criteria) this;
		}

		public Criteria andUseDateTimeIsNotNull() {
			addCriterion("use_date_time is not null");
			return (Criteria) this;
		}

		public Criteria andUseDateTimeEqualTo(Date value) {
			addCriterion("use_date_time =", value, "useDateTime");
			return (Criteria) this;
		}

		public Criteria andUseDateTimeNotEqualTo(Date value) {
			addCriterion("use_date_time <>", value, "useDateTime");
			return (Criteria) this;
		}

		public Criteria andUseDateTimeGreaterThan(Date value) {
			addCriterion("use_date_time >", value, "useDateTime");
			return (Criteria) this;
		}

		public Criteria andUseDateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("use_date_time >=", value, "useDateTime");
			return (Criteria) this;
		}

		public Criteria andUseDateTimeLessThan(Date value) {
			addCriterion("use_date_time <", value, "useDateTime");
			return (Criteria) this;
		}

		public Criteria andUseDateTimeLessThanOrEqualTo(Date value) {
			addCriterion("use_date_time <=", value, "useDateTime");
			return (Criteria) this;
		}

		public Criteria andUseDateTimeIn(List<Date> values) {
			addCriterion("use_date_time in", values, "useDateTime");
			return (Criteria) this;
		}

		public Criteria andUseDateTimeNotIn(List<Date> values) {
			addCriterion("use_date_time not in", values, "useDateTime");
			return (Criteria) this;
		}

		public Criteria andUseDateTimeBetween(Date value1, Date value2) {
			addCriterion("use_date_time between", value1, value2, "useDateTime");
			return (Criteria) this;
		}

		public Criteria andUseDateTimeNotBetween(Date value1, Date value2) {
			addCriterion("use_date_time not between", value1, value2, "useDateTime");
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