package org.code2040.dashboard

class Candidate {
	// All Classes already have a attribute called ID
	String name
	String school
	String graduationDate
	String email
	String password // This will be hashed
	String phoneNumber
	ApplicationStep currentStep = ApplicationStep.FIRST_STEP
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
	int lastLogin = 0
	
	// Optional
	String homeState

	    static constraints = {
    }
}