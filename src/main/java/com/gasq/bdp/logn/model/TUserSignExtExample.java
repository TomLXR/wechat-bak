package com.gasq.bdp.logn.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TUserSignExtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserSignExtExample() {
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

        public Criteria andSignScoreIsNull() {
            addCriterion("sign_score is null");
            return (Criteria) this;
        }

        public Criteria andSignScoreIsNotNull() {
            addCriterion("sign_score is not null");
            return (Criteria) this;
        }

        public Criteria andSignScoreEqualTo(Long value) {
            addCriterion("sign_score =", value, "signScore");
            return (Criteria) this;
        }

        public Criteria andSignScoreNotEqualTo(Long value) {
            addCriterion("sign_score <>", value, "signScore");
            return (Criteria) this;
        }

        public Criteria andSignScoreGreaterThan(Long value) {
            addCriterion("sign_score >", value, "signScore");
            return (Criteria) this;
        }

        public Criteria andSignScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("sign_score >=", value, "signScore");
            return (Criteria) this;
        }

        public Criteria andSignScoreLessThan(Long value) {
            addCriterion("sign_score <", value, "signScore");
            return (Criteria) this;
        }

        public Criteria andSignScoreLessThanOrEqualTo(Long value) {
            addCriterion("sign_score <=", value, "signScore");
            return (Criteria) this;
        }

        public Criteria andSignScoreIn(List<Long> values) {
            addCriterion("sign_score in", values, "signScore");
            return (Criteria) this;
        }

        public Criteria andSignScoreNotIn(List<Long> values) {
            addCriterion("sign_score not in", values, "signScore");
            return (Criteria) this;
        }

        public Criteria andSignScoreBetween(Long value1, Long value2) {
            addCriterion("sign_score between", value1, value2, "signScore");
            return (Criteria) this;
        }

        public Criteria andSignScoreNotBetween(Long value1, Long value2) {
            addCriterion("sign_score not between", value1, value2, "signScore");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateIsNull() {
            addCriterion("latest_sign_date is null");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateIsNotNull() {
            addCriterion("latest_sign_date is not null");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateEqualTo(Date value) {
            addCriterionForJDBCDate("latest_sign_date =", value, "latestSignDate");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("latest_sign_date <>", value, "latestSignDate");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateGreaterThan(Date value) {
            addCriterionForJDBCDate("latest_sign_date >", value, "latestSignDate");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("latest_sign_date >=", value, "latestSignDate");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateLessThan(Date value) {
            addCriterionForJDBCDate("latest_sign_date <", value, "latestSignDate");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("latest_sign_date <=", value, "latestSignDate");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateIn(List<Date> values) {
            addCriterionForJDBCDate("latest_sign_date in", values, "latestSignDate");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("latest_sign_date not in", values, "latestSignDate");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("latest_sign_date between", value1, value2, "latestSignDate");
            return (Criteria) this;
        }

        public Criteria andLatestSignDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("latest_sign_date not between", value1, value2, "latestSignDate");
            return (Criteria) this;
        }

        public Criteria andW1IsNull() {
            addCriterion("w1 is null");
            return (Criteria) this;
        }

        public Criteria andW1IsNotNull() {
            addCriterion("w1 is not null");
            return (Criteria) this;
        }

        public Criteria andW1EqualTo(Integer value) {
            addCriterion("w1 =", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1NotEqualTo(Integer value) {
            addCriterion("w1 <>", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1GreaterThan(Integer value) {
            addCriterion("w1 >", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1GreaterThanOrEqualTo(Integer value) {
            addCriterion("w1 >=", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1LessThan(Integer value) {
            addCriterion("w1 <", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1LessThanOrEqualTo(Integer value) {
            addCriterion("w1 <=", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1In(List<Integer> values) {
            addCriterion("w1 in", values, "w1");
            return (Criteria) this;
        }

        public Criteria andW1NotIn(List<Integer> values) {
            addCriterion("w1 not in", values, "w1");
            return (Criteria) this;
        }

        public Criteria andW1Between(Integer value1, Integer value2) {
            addCriterion("w1 between", value1, value2, "w1");
            return (Criteria) this;
        }

        public Criteria andW1NotBetween(Integer value1, Integer value2) {
            addCriterion("w1 not between", value1, value2, "w1");
            return (Criteria) this;
        }

        public Criteria andW2IsNull() {
            addCriterion("w2 is null");
            return (Criteria) this;
        }

        public Criteria andW2IsNotNull() {
            addCriterion("w2 is not null");
            return (Criteria) this;
        }

        public Criteria andW2EqualTo(Integer value) {
            addCriterion("w2 =", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2NotEqualTo(Integer value) {
            addCriterion("w2 <>", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2GreaterThan(Integer value) {
            addCriterion("w2 >", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2GreaterThanOrEqualTo(Integer value) {
            addCriterion("w2 >=", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2LessThan(Integer value) {
            addCriterion("w2 <", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2LessThanOrEqualTo(Integer value) {
            addCriterion("w2 <=", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2In(List<Integer> values) {
            addCriterion("w2 in", values, "w2");
            return (Criteria) this;
        }

        public Criteria andW2NotIn(List<Integer> values) {
            addCriterion("w2 not in", values, "w2");
            return (Criteria) this;
        }

        public Criteria andW2Between(Integer value1, Integer value2) {
            addCriterion("w2 between", value1, value2, "w2");
            return (Criteria) this;
        }

        public Criteria andW2NotBetween(Integer value1, Integer value2) {
            addCriterion("w2 not between", value1, value2, "w2");
            return (Criteria) this;
        }

        public Criteria andW3IsNull() {
            addCriterion("w3 is null");
            return (Criteria) this;
        }

        public Criteria andW3IsNotNull() {
            addCriterion("w3 is not null");
            return (Criteria) this;
        }

        public Criteria andW3EqualTo(Integer value) {
            addCriterion("w3 =", value, "w3");
            return (Criteria) this;
        }

        public Criteria andW3NotEqualTo(Integer value) {
            addCriterion("w3 <>", value, "w3");
            return (Criteria) this;
        }

        public Criteria andW3GreaterThan(Integer value) {
            addCriterion("w3 >", value, "w3");
            return (Criteria) this;
        }

        public Criteria andW3GreaterThanOrEqualTo(Integer value) {
            addCriterion("w3 >=", value, "w3");
            return (Criteria) this;
        }

        public Criteria andW3LessThan(Integer value) {
            addCriterion("w3 <", value, "w3");
            return (Criteria) this;
        }

        public Criteria andW3LessThanOrEqualTo(Integer value) {
            addCriterion("w3 <=", value, "w3");
            return (Criteria) this;
        }

        public Criteria andW3In(List<Integer> values) {
            addCriterion("w3 in", values, "w3");
            return (Criteria) this;
        }

        public Criteria andW3NotIn(List<Integer> values) {
            addCriterion("w3 not in", values, "w3");
            return (Criteria) this;
        }

        public Criteria andW3Between(Integer value1, Integer value2) {
            addCriterion("w3 between", value1, value2, "w3");
            return (Criteria) this;
        }

        public Criteria andW3NotBetween(Integer value1, Integer value2) {
            addCriterion("w3 not between", value1, value2, "w3");
            return (Criteria) this;
        }

        public Criteria andW4IsNull() {
            addCriterion("w4 is null");
            return (Criteria) this;
        }

        public Criteria andW4IsNotNull() {
            addCriterion("w4 is not null");
            return (Criteria) this;
        }

        public Criteria andW4EqualTo(Integer value) {
            addCriterion("w4 =", value, "w4");
            return (Criteria) this;
        }

        public Criteria andW4NotEqualTo(Integer value) {
            addCriterion("w4 <>", value, "w4");
            return (Criteria) this;
        }

        public Criteria andW4GreaterThan(Integer value) {
            addCriterion("w4 >", value, "w4");
            return (Criteria) this;
        }

        public Criteria andW4GreaterThanOrEqualTo(Integer value) {
            addCriterion("w4 >=", value, "w4");
            return (Criteria) this;
        }

        public Criteria andW4LessThan(Integer value) {
            addCriterion("w4 <", value, "w4");
            return (Criteria) this;
        }

        public Criteria andW4LessThanOrEqualTo(Integer value) {
            addCriterion("w4 <=", value, "w4");
            return (Criteria) this;
        }

        public Criteria andW4In(List<Integer> values) {
            addCriterion("w4 in", values, "w4");
            return (Criteria) this;
        }

        public Criteria andW4NotIn(List<Integer> values) {
            addCriterion("w4 not in", values, "w4");
            return (Criteria) this;
        }

        public Criteria andW4Between(Integer value1, Integer value2) {
            addCriterion("w4 between", value1, value2, "w4");
            return (Criteria) this;
        }

        public Criteria andW4NotBetween(Integer value1, Integer value2) {
            addCriterion("w4 not between", value1, value2, "w4");
            return (Criteria) this;
        }

        public Criteria andW5IsNull() {
            addCriterion("w5 is null");
            return (Criteria) this;
        }

        public Criteria andW5IsNotNull() {
            addCriterion("w5 is not null");
            return (Criteria) this;
        }

        public Criteria andW5EqualTo(Integer value) {
            addCriterion("w5 =", value, "w5");
            return (Criteria) this;
        }

        public Criteria andW5NotEqualTo(Integer value) {
            addCriterion("w5 <>", value, "w5");
            return (Criteria) this;
        }

        public Criteria andW5GreaterThan(Integer value) {
            addCriterion("w5 >", value, "w5");
            return (Criteria) this;
        }

        public Criteria andW5GreaterThanOrEqualTo(Integer value) {
            addCriterion("w5 >=", value, "w5");
            return (Criteria) this;
        }

        public Criteria andW5LessThan(Integer value) {
            addCriterion("w5 <", value, "w5");
            return (Criteria) this;
        }

        public Criteria andW5LessThanOrEqualTo(Integer value) {
            addCriterion("w5 <=", value, "w5");
            return (Criteria) this;
        }

        public Criteria andW5In(List<Integer> values) {
            addCriterion("w5 in", values, "w5");
            return (Criteria) this;
        }

        public Criteria andW5NotIn(List<Integer> values) {
            addCriterion("w5 not in", values, "w5");
            return (Criteria) this;
        }

        public Criteria andW5Between(Integer value1, Integer value2) {
            addCriterion("w5 between", value1, value2, "w5");
            return (Criteria) this;
        }

        public Criteria andW5NotBetween(Integer value1, Integer value2) {
            addCriterion("w5 not between", value1, value2, "w5");
            return (Criteria) this;
        }

        public Criteria andW6IsNull() {
            addCriterion("w6 is null");
            return (Criteria) this;
        }

        public Criteria andW6IsNotNull() {
            addCriterion("w6 is not null");
            return (Criteria) this;
        }

        public Criteria andW6EqualTo(Integer value) {
            addCriterion("w6 =", value, "w6");
            return (Criteria) this;
        }

        public Criteria andW6NotEqualTo(Integer value) {
            addCriterion("w6 <>", value, "w6");
            return (Criteria) this;
        }

        public Criteria andW6GreaterThan(Integer value) {
            addCriterion("w6 >", value, "w6");
            return (Criteria) this;
        }

        public Criteria andW6GreaterThanOrEqualTo(Integer value) {
            addCriterion("w6 >=", value, "w6");
            return (Criteria) this;
        }

        public Criteria andW6LessThan(Integer value) {
            addCriterion("w6 <", value, "w6");
            return (Criteria) this;
        }

        public Criteria andW6LessThanOrEqualTo(Integer value) {
            addCriterion("w6 <=", value, "w6");
            return (Criteria) this;
        }

        public Criteria andW6In(List<Integer> values) {
            addCriterion("w6 in", values, "w6");
            return (Criteria) this;
        }

        public Criteria andW6NotIn(List<Integer> values) {
            addCriterion("w6 not in", values, "w6");
            return (Criteria) this;
        }

        public Criteria andW6Between(Integer value1, Integer value2) {
            addCriterion("w6 between", value1, value2, "w6");
            return (Criteria) this;
        }

        public Criteria andW6NotBetween(Integer value1, Integer value2) {
            addCriterion("w6 not between", value1, value2, "w6");
            return (Criteria) this;
        }

        public Criteria andW7IsNull() {
            addCriterion("w7 is null");
            return (Criteria) this;
        }

        public Criteria andW7IsNotNull() {
            addCriterion("w7 is not null");
            return (Criteria) this;
        }

        public Criteria andW7EqualTo(Integer value) {
            addCriterion("w7 =", value, "w7");
            return (Criteria) this;
        }

        public Criteria andW7NotEqualTo(Integer value) {
            addCriterion("w7 <>", value, "w7");
            return (Criteria) this;
        }

        public Criteria andW7GreaterThan(Integer value) {
            addCriterion("w7 >", value, "w7");
            return (Criteria) this;
        }

        public Criteria andW7GreaterThanOrEqualTo(Integer value) {
            addCriterion("w7 >=", value, "w7");
            return (Criteria) this;
        }

        public Criteria andW7LessThan(Integer value) {
            addCriterion("w7 <", value, "w7");
            return (Criteria) this;
        }

        public Criteria andW7LessThanOrEqualTo(Integer value) {
            addCriterion("w7 <=", value, "w7");
            return (Criteria) this;
        }

        public Criteria andW7In(List<Integer> values) {
            addCriterion("w7 in", values, "w7");
            return (Criteria) this;
        }

        public Criteria andW7NotIn(List<Integer> values) {
            addCriterion("w7 not in", values, "w7");
            return (Criteria) this;
        }

        public Criteria andW7Between(Integer value1, Integer value2) {
            addCriterion("w7 between", value1, value2, "w7");
            return (Criteria) this;
        }

        public Criteria andW7NotBetween(Integer value1, Integer value2) {
            addCriterion("w7 not between", value1, value2, "w7");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
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