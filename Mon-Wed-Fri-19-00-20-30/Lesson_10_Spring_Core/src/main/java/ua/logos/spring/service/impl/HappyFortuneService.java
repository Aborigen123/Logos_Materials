package ua.logos.spring.service.impl;

import ua.logos.spring.service.FortuneService;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Сьогодні твій щасливий день.";
	}

}
