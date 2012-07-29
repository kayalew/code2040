package org.code2040.dashboard.services

import org.code2040.dashboard.Candidate
import org.code2040.dashboard.ApplicationStep
import org.code2040.dashboard.Question
import org.code2040.dashboard.RecruitmentInfo

class CandidateService {

    def createCandidate(String name, String school, String graduationDate, String email,
		
		String password, String phoneNumber, char gender, String race, String homeCountry,
		int fellowYear, List<Question> questions, List<RecruitmentInfo> recruitmentInfo,
		String homeState) {
		Candidate c = new Candidate()
		c.name = name
		c.school = school
		c.graduationDate = graduationDate
		c.email = email
		c.password = password // HASH IT
		c.phoneNumber = phoneNumber
		c.gender = gender
		c.race = race
		c.homeCountry = homeCountry
		c.fellowYear = fellowYear
		//c.questions.addAll(questions)
		//c.recruitmentInfo.addAll(recruitmentInfo)
		c.homeState = homeState
		c.save()
		return c
    }
	
	def approveCandidate(int candidateID, int stepID) {
		Candidate c = Candidate.get(candidateID)
		if (c == null) return null
		
		ApplicationStep ps = c.currentStep
		if (ps != ApplicationStep.FOURTH_STEP) {
			ps.increment()
			c.currentStep = ps
			return c.save()
		}
		return c
	}
}
