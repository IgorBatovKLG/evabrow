package ru.mse.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.mse.service.Services.CountVisitsService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
		Runnable Direction = new Runnable() {
			@Override
			public void run() {
				while (true) {
					CountVisitsService countVisitsService = new CountVisitsService();
					int uniqueVisits = countVisitsService.getUniqueVisits();
					int visits = countVisitsService.getVisits();
					System.out.println("Уникальных " + uniqueVisits + " Всего " + visits);
					LocalDateTime now = LocalDateTime.now();
					try {
						Thread.sleep(1000 * 60 * 5);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					if (now.getHour() == 19) {
						countVisitsService.newMap();
						try {
							Thread.sleep(1000 * 60 * 60 * 7);
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
		};
		Thread myThready = new Thread(Direction);
		myThready.start();
	}

}
