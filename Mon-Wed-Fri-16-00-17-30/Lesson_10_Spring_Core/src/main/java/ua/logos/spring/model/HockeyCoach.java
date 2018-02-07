package ua.logos.spring.model;

import ua.logos.spring.service.Coach;
import ua.logos.spring.service.FortuneService;

public class HockeyCoach implements Coach {

	private FortuneService fortuneService;

	public HockeyCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Тренер по хокею: катайся протягом 90хв";
	}

	@Override
	public String getDailyFortune() {
		return "Тренер по хокею: " + fortuneService.getFortune();
	}

}
