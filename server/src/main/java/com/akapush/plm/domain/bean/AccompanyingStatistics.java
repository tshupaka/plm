package com.akapush.plm.domain.bean;

import java.util.Map;

public class AccompanyingStatistics {

    private Map<String, GeographicStatistics> sexStatistics;

    private Map<String,GeographicStatistics> ageStatistics;

    private Map<String, GeographicStatistics> departmentStatistics;

    private Map<String, GeographicStatistics> isQpvStatistics;

    private Map<String, GeographicStatistics> qpvQuarterStatistics;

    private Map<String, GeographicStatistics> employmentStatusStatistics;

    private Map<String, GeographicStatistics> rsaClaimerStatistics;

    private Map<String, GeographicStatistics> schoolLevelStatistics;

    private Map<String, GeographicStatistics> prescriberStatistics;

    public Map<String, GeographicStatistics> getSexStatistics() {
        return sexStatistics;
    }

    public void setSexStatistics(Map<String, GeographicStatistics> sexStatistics) {
        this.sexStatistics = sexStatistics;
    }

    public Map<String, GeographicStatistics> getAgeStatistics() {
        return ageStatistics;
    }

    public void setAgeStatistics(Map<String, GeographicStatistics> ageStatistics) {
        this.ageStatistics = ageStatistics;
    }

    public Map<String, GeographicStatistics> getDepartmentStatistics() {
        return departmentStatistics;
    }

    public void setDepartmentStatistics(Map<String, GeographicStatistics> departmentStatistics) {
        this.departmentStatistics = departmentStatistics;
    }

    public Map<String, GeographicStatistics> getIsQpvStatistics() {
        return isQpvStatistics;
    }

    public void setIsQpvStatistics(Map<String, GeographicStatistics> isQpvStatistics) {
        this.isQpvStatistics = isQpvStatistics;
    }

    public Map<String, GeographicStatistics> getQpvQuarterStatistics() {
        return qpvQuarterStatistics;
    }

    public void setQpvQuarterStatistics(Map<String, GeographicStatistics> qpvQuarterStatistics) {
        this.qpvQuarterStatistics = qpvQuarterStatistics;
    }

    public Map<String, GeographicStatistics> getEmploymentStatusStatistics() {
        return employmentStatusStatistics;
    }

    public void setEmploymentStatusStatistics(Map<String, GeographicStatistics> employmentStatusStatistics) {
        this.employmentStatusStatistics = employmentStatusStatistics;
    }

    public Map<String, GeographicStatistics> getRsaClaimerStatistics() {
        return rsaClaimerStatistics;
    }

    public void setRsaClaimerStatistics(Map<String, GeographicStatistics> rsaClaimerStatistics) {
        this.rsaClaimerStatistics = rsaClaimerStatistics;
    }

    public Map<String, GeographicStatistics> getSchoolLevelStatistics() {
        return schoolLevelStatistics;
    }

    public void setSchoolLevelStatistics(Map<String, GeographicStatistics> schoolLevelStatistics) {
        this.schoolLevelStatistics = schoolLevelStatistics;
    }

    public Map<String, GeographicStatistics> getPrescriberStatistics() {
        return prescriberStatistics;
    }

    public void setPrescriberStatistics(Map<String, GeographicStatistics> prescriberStatistics) {
        this.prescriberStatistics = prescriberStatistics;
    }
}

