package com.developer.employee;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmployeeApplication {

	public static void main(String[] args) throws SchedulerException {
		SpringApplication.run(EmployeeApplication.class, args);
		
//		JobDetail jd=new JobDetail();
//		jd.setName("MyJobDetail");
//		jd.setJobClass(MyJob.class);
//		
//		SimpleTrigger t=new SimpleTrigger();
//		t.setName("MyTrigger");
//		t.setStartTime(new Date(System.currentTimeMillis()));
//		t.setRepeatInterval(3000);
//		t.setRepeatCount(t.REPEAT_INDEFINITELY);
//		
//		Scheduler sd=new StdSchedulerFactory().getScheduler();
//		sd.scheduleJob(jd,t);
//		sd.start();
	}

}
