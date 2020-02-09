package com.x2yu.circleapi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SecRolePermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SecRolePermissionExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPermission_idIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        public Criteria andPermission_idIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermission_idEqualTo(Integer value) {
            addCriterion("permission_id =", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idNotEqualTo(Integer value) {
            addCriterion("permission_id <>", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idGreaterThan(Integer value) {
            addCriterion("permission_id >", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_id >=", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idLessThan(Integer value) {
            addCriterion("permission_id <", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idLessThanOrEqualTo(Integer value) {
            addCriterion("permission_id <=", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idIn(List<Integer> values) {
            addCriterion("permission_id in", values, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idNotIn(List<Integer> values) {
            addCriterion("permission_id not in", values, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idBetween(Integer value1, Integer value2) {
            addCriterion("permission_id between", value1, value2, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_id not between", value1, value2, "permission_id");
            return (Criteria) this;
        }

        public Criteria andRole_idIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRole_idIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRole_idEqualTo(Integer value) {
            addCriterion("role_id =", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idGreaterThan(Integer value) {
            addCriterion("role_id >", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idLessThan(Integer value) {
            addCriterion("role_id <", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idIn(List<Integer> values) {
            addCriterion("role_id in", values, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "role_id");
            return (Criteria) this;
        }

        public Criteria andRevisionIsNull() {
            addCriterion("revision is null");
            return (Criteria) this;
        }

        public Criteria andRevisionIsNotNull() {
            addCriterion("revision is not null");
            return (Criteria) this;
        }

        public Criteria andRevisionEqualTo(Integer value) {
            addCriterion("revision =", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotEqualTo(Integer value) {
            addCriterion("revision <>", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionGreaterThan(Integer value) {
            addCriterion("revision >", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("revision >=", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLessThan(Integer value) {
            addCriterion("revision <", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLessThanOrEqualTo(Integer value) {
            addCriterion("revision <=", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionIn(List<Integer> values) {
            addCriterion("revision in", values, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotIn(List<Integer> values) {
            addCriterion("revision not in", values, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionBetween(Integer value1, Integer value2) {
            addCriterion("revision between", value1, value2, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotBetween(Integer value1, Integer value2) {
            addCriterion("revision not between", value1, value2, "revision");
            return (Criteria) this;
        }

        public Criteria andCreated_timeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreated_timeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_timeEqualTo(Date value) {
            addCriterion("created_time =", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeGreaterThan(Date value) {
            addCriterion("created_time >", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeLessThan(Date value) {
            addCriterion("created_time <", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeIn(List<Date> values) {
            addCriterion("created_time in", values, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "created_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_byIsNull() {
            addCriterion("updated_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdated_byIsNotNull() {
            addCriterion("updated_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdated_byEqualTo(String value) {
            addCriterion("updated_by =", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byNotEqualTo(String value) {
            addCriterion("updated_by <>", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byGreaterThan(String value) {
            addCriterion("updated_by >", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byGreaterThanOrEqualTo(String value) {
            addCriterion("updated_by >=", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byLessThan(String value) {
            addCriterion("updated_by <", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byLessThanOrEqualTo(String value) {
            addCriterion("updated_by <=", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byLike(String value) {
            addCriterion("updated_by like", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byNotLike(String value) {
            addCriterion("updated_by not like", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byIn(List<String> values) {
            addCriterion("updated_by in", values, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byNotIn(List<String> values) {
            addCriterion("updated_by not in", values, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byBetween(String value1, String value2) {
            addCriterion("updated_by between", value1, value2, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byNotBetween(String value1, String value2) {
            addCriterion("updated_by not between", value1, value2, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeLessThan(Date value) {
            addCriterion("updated_time <", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updated_time");
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