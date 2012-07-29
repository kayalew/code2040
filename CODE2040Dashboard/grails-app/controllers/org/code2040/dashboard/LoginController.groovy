package org.code2040.dashboard

import org.code2040.dashboard.services.SecurityService
import org.code2040.dashboard.services.LoginService

class LoginController {
	
	boolean staff = false
	def loginService

    def index() {
		def htmlContent = new File('grails-app/views/login.html').text
		render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
		staff = false
	}
	
	def staff() {
		def htmlContent = new File('grails-app/views/staff-login.html').text
		render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
		staff = true
	}
	
	def update() {
		String lookupEmail = params.email
		String possiblePassword = params.password
		String goodHash = new String()
		if (!staff){
			//goodHash =  mysqldb.query("SELECT hash FROM students WHERE email="+lookupEmail)
			//loginService.checkEmptyUser(goodHash, staff)
			//loginService.processPassword(possiblePassword, goodHash, staff)
		}
		else{
			//goodHash =  mysqldb.query("SELECT hash FROM staff WHERE email="+lookupEmail)
			//loginService.checkEmptyUser(goodHash, staff)
			//loginService.processPassword(possiblePassword, goodHash, staff)
		}
	}
}
