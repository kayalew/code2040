package org.code2040.dashboard.services
import org.code2040.dashboard.services.SecurityService
class LoginService {
	def securityService
	def checkEmptyUser(goodHash, staff){
		if (goodHash == null){
			reset(staff)
		}
	}
	
	def processPassword(possiblePassword, goodHash, tryStaff){
		boolean valid = securityService.validatePassword(possiblePassword, goodHash)
		if (!valid){
			reset(staff)
		}
		else{
			render "Login Successful!"
			if (tryStaff){
				staff = false
			}
		}
	}
	
	def reset(staff){
		if (staff){
			def htmlContent = new File('grails-app/views/login.html').text
			render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
		}
		else{
			def htmlContent = new File('grails-app/views/staff-login.html').text
			render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
		}
	}
}