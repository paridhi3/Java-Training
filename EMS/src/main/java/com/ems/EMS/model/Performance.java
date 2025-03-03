package com.ems.EMS.model;

import java.util.List;

public class Performance {

	private int empID;
	private double rating;
	private String feedback;
	private List<String> projectsHandled;
	private boolean isEligibleForPromotion;
	
	public Performance() {
		super();
	}
	
	public Performance(int empID, double rating, String feedback, List<String> projectsHandled,
			boolean isEligibleForPromotion) {
		super();
		this.empID = empID;
		this.rating = rating;
		this.feedback = feedback;
		this.projectsHandled = projectsHandled;
		this.isEligibleForPromotion = isEligibleForPromotion;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public List<String> getProjectsHandled() {
		return projectsHandled;
	}

	public void setProjectsHandled(List<String> projectsHandled) {
		this.projectsHandled = projectsHandled;
	}

	public boolean isEligibleForPromotion() {
		return isEligibleForPromotion;
	}

	public void setEligibleForPromotion(boolean isEligibleForPromotion) {
		this.isEligibleForPromotion = isEligibleForPromotion;
	}

	@Override
	public String toString() {
		return "Performance [empID=" + empID + ", rating=" + rating + ", feedback=" + feedback + ", projectsHandled="
				+ projectsHandled + ", isEligibleForPromotion=" + isEligibleForPromotion + "]";
	}
	
	
}
