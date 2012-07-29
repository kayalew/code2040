package org.code2040.dashboard

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject

class CandidateController {

    def index() { 
		render "Hello! This is the Candidate Controller.. We're still working on it!\n" +
		"Available Endpoints:\n" +
		"/create\n" +
		"/update\n" +
		"/delete"
	}
	
	def create() {
		String jsonForm = params.jsonForm
		if (jsonForm == null) render "Not enough information to create an user"
	}
	
	def update() {
		int id = params.id
		Candidate c = Candidate.get(id)
		if (c == null) render "Candidate not found"
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
