package ua.logos.spring.model;

import ua.logos.spring.service.Coach;
import ua.logos.spring.service.FortuneService;

public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	private String name;

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDailyWorkout() {
		return "Тренер по тенісу: Відпрацьовуй подаі протягом 3годин";
	}

	@Override
	public String getDailyFortune() {
		return name + ", tренер по тенісу, сказав: " + fortuneService.getFortune();
	}

}
