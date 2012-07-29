package org.code2040.dashboard

class LoginController {

    def index() {
		def htmlContent = new File('grails-app/views/login.html').text
		render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
	}
	
	def staff() {
		def htmlContent = new File('grails-app/views/staff-login.html').text
		render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
	}
}
