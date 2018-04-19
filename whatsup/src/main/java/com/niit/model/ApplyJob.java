package com.niit.model;

import java.util.Date;

import javax.persistence.Id;

public class ApplyJob {
@Id
int applicationId;

int jobId;
String loginName;
Date applyDate;
public int getApplicationId() {
	return applicationId;
}
public void setApplicationId(int applicationId) {
	this.applicationId = applicationId;
}
public int getJobId() {
	return jobId;
}
public void setJobId(int jobId) {
	this.jobId = jobId;
}
public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = loginName;
}
public Date getApplyDate() {
	return applyDate;
}
public void setApplyDate(Date applyDate) {
	this.applyDate = applyDate;
}


}
