package org.code2040.dashboard

import org.code2040.dashboard.services.SecurityService
import org.code2040.dashboard.services.LoginService

class LoginController {
	//@Field Boolean staff = false
	boolean tryStaff = false
	def loginService

	def candidate(){
		tryStaff = false
		create()
	}
	
	def manager(){
		tryStaff = true
		create()
	}
	
	def create(){
		if (request.method == 'GET') {
			if (!tryStaff){
				def htmlContent = new File('grails-app/views/login.html').text
				render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
			}
			else{
				def htmlContent = new File('grails-app/views/staff-login.html').text
				render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
			}
		}
		if (request.method == 'POST') {
			String lookupEmail = params.email
			String possiblePassword = params.password
			String goodHash = new String()
			if (!tryStaff){
				//goodHash =  mysqldb.query("SELECT hash FROM students WHERE email="+lookupEmail)
				goodHash = (String) Candidate.executeQuery(
					"select candidate.password from Candidate candidate where email = "+lookupEmail)
				loginService.checkEmptyUser(goodHash, tryStaff)
				loginService.processPassword(possiblePassword, goodHash, tryStaff)
			}
			else{
				//goodHash = (String)this.jdbcTemplate.queryForObject("SELECT hash FROM staff WHERE email="+lookupEmail)
				goodHash = (String) Manager.executeQuery(
					"select manager.password from Manager manager having email = "+lookupEmail)
				loginService.checkEmptyUser(goodHash, tryStaff)
				loginService.processPassword(possiblePassword, goodHash, tryStaff)
			}
		}
	}
    def index() {
		render "Hello! This is the Login Controller.. We're still working on it!\n" +
		"Available Endpoints:\n" +
		"/candidate\n" +
		"/manager"
	}
	
	def update() {

	}
}
