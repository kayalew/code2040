package org.code2040.dashboard

import java.util.List
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject

class CandidateController {
	
	def candidateService

    def index() { 
		render "Hello! This is the Candidate Controller.. We're still working on it!\n" +
		"Available Endpoints:\n" +
		"/create\n" +
		"/update\n" +
		"/delete"
	}
	
	def create() {
		String formString = params.jsonForm
		if (formString == null) {
			render "Not enough information to create an user"
			return
		}
		
		JSONObject jsonForm = JSON.parse(formString)
		
		String name = jsonForm.getString('name')
		String school = jsonForm.getString('school')
		String graduationDate = jsonForm.getString('gradDate')
		String email = jsonForm.getString('email')
		String password = jsonForm.getString('password') // This NEEDS TO BE HASHED
		String phoneNumber = jsonForm.getString('phone')
		char gender = jsonForm.getString('gender') != null ? jsonForm.getString('gender').charAt(0) : null
		String race = jsonForm.getString('race')
		String homeCountry = jsonForm.getString('country')
		int fellowYear = Calendar.getInstance().get(Calendar.YEAR); // Get Always Current Year - ? Or let user decide ?
		
		List<Question> questions
		// TBD
		
		List<RecruitmentInfo> recruitmentInfo
		// TBD
		
		// Optional
		String homeState = jsonForm.getString('homeState')
		
		Candidate c = candidateService.createCandidate(
			name, school, graduationDate, email, password, phoneNumber,
			gender, race, homeCountry, fellowYear, questions, recruitmentInfo,
			homeState
			)
		
	}
	
	def update() {
		int id = params.id
		Candidate c = Candidate.get(id)
		if (c == null) {
			render "Candidate not found"
			return
		}
		// This should be in Service!
		String updateJSON = params.updateJson
		JSONObject updatej = JSON.parse(updateJSON)
		for (String key : updatej.keys()) {
			c."$key" = updatej.getAt(key)
		}
		if (c.hasErrors()) render "Errors with parameters"
		else render "User Updated Sucessfully!"
	}
	
	def delete() {
		
	}
}
