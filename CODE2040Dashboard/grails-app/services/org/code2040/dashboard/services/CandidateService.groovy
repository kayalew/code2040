package org.code2040.dashboard.services

import org.code2040.dashboard.Candidate

class CandidateService {

    def serviceMethod() {

    }
	
	def approveCandidate(int candidateID, int stepID) {
		Candidate c = Candidate.get(candidateID)
		if (c == null) return null
		
		// c.step++
		return c.save()
	}
}
