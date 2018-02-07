package ua.logos.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.logos.spring.model.FootballCoach;
import ua.logos.spring.model.HockeyCoach;
import ua.logos.spring.model.TennisCoach;
import ua.logos.spring.service.Coach;

public class App {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
	
		Coach footballCoach = context.getBean("footballCoach", FootballCoach.class);
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getDailyFortune());
		
		Coach hockeyCoach = context.getBean("hockeyCoach", HockeyCoach.class);
		System.out.println(hockeyCoach.getDailyWorkout());
		System.out.println(hockeyCoach.getDailyFortune());
		
		Coach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());
		
		context.close();
	}
}
