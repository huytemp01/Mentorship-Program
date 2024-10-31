package mentorship.dailydev.dailydev;

import mentorship.dailydev.dailydev.scheduling.RSSFetchSchedulerQuartz;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DailydevApplication {

	public static void main(String[] args) throws SchedulerException {
		ApplicationContext context = SpringApplication.run(DailydevApplication.class, args);
	}

}
