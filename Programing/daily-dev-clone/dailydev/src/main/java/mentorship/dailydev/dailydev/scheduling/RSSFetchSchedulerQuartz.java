package mentorship.dailydev.dailydev.scheduling;

import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.service.RssService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.quartz.JobBuilder.newJob;

@Component
public class RSSFetchSchedulerQuartz {

}
