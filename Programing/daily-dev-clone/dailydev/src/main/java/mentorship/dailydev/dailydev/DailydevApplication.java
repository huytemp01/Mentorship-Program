package mentorship.dailydev.dailydev;

import mentorship.dailydev.dailydev.scheduling.RSSFetchSchedulerQuartz;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class DailydevApplication {

	public static void main(String[] args) throws SchedulerException {
		ApplicationContext context = SpringApplication.run(DailydevApplication.class, args);
//		RSSFetchSchedulerQuartz fetchSchedulerQuartz = context.getBean(RSSFetchSchedulerQuartz.class);
//		fetchSchedulerQuartz.run();
	}

}
