package org.code2040.dashboard;

public enum ApplicationStep {
	FIRST_STEP(1), SECOND_STEP(2), THIRD_STEP(3), FOURTH_STEP(4)
	
	int stepNumber
	
	ApplicationStep(int stepNumber) {
		this.stepNumber = stepNumber
	}
	
	def increment() {
		if (stepNumber < 4)
			stepNumber++
	}
	
	def decrement() {
		if (stepNumber > 1)
			stepNumber--
	}
}
