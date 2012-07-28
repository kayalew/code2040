package org.code2040.dashboard


class ManagementController {
	
	def statisticsService

    def index() {
		int num = 0;
		num = statisticsService.serviceMethod(num)
		render "Hello! This is the Management Controller.. We're still working on it! (" + num + ")" 
	}
}
