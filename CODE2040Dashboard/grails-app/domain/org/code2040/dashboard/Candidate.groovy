package org.code2040.dashboard

class Candidate {
	// All Classes already have a attribute called ID
	String name
	String school
	String graduationDate
	String email
	String password // This will be hashed
	String phoneNumber
	ProcessStep currentStep = ProcessStep.FIRST_STEP
	// int status ?!?!?
	char gender
	String race
	String homeCountry
	int fellowYear
	boolean needsReview = false
	
	List<Question> questions
	List<RecruitmentInfo> recruitmentInfo
	
	int timeCreated = System.currentTimeMillis() // When Created
	int timeModified = System.currentTimeMillis() // When Created
	int timeRemoved = 0
	int lastLogin
	
	// Optional
	String homeState

	    static constraints = {
    }
}

public enum ProcessStep {
	FIRST_STEP(1), SECOND_STEP(2), THIRD_STEP(3), FOURTH_STEP(4)
}