package org.code2040.dashboard


class ManagementController {
	
	def statisticsService
	def activityService
	def candidateService

    def index() {
		int num = 0;
		num = statisticsService.serviceMethod(num)
		render "Hello! This is the Management Controller.. We're still working on it! (" + num + ")" 
	}
	
	def approve() {
		int candidateID = params.id
		int stepID = params.stepID
		
		Candidate c = candidateService.approveCandidate(candidateID, stepID)
		if (c == null || c.hasErrors()) {
			render "Couldnt approve candidate"
		} else {
			render "Candidate with ID: " + candidateID + " was approved in step number: " + stepID
		}
	}
}
