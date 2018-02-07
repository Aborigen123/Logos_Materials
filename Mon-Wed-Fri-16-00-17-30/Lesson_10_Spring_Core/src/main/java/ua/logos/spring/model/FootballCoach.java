package ua.logos.spring.model;

import ua.logos.spring.service.Coach;

public class FootballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Тренер по футболу: Бігай протягом 120хв.";
	}

	@Override
	public String getDailyFortune() {
		return "Тренер по футболу: Сьогодні твій щасливий день.";
	}

}
