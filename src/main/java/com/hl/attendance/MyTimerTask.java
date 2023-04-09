package com.hl.attendance;

import org.quartz.DisallowConcurrentExecution;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
@DisallowConcurrentExecution
public class MyTimerTask {
    //@Scheduled(cron = "0 55 7,17 * * ?") //每天07:55:00和17:55:00
    @Scheduled(cron = "${amClock}")
    public  void TimerTaskAm()  {
        long currentTimeStamp = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        Boolean workingDay;
        try {
            workingDay = HolidayUtils.isWorkingDay(currentTimeStamp);
            System.out.println("isWorkingDay:"+workingDay);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (workingDay) {
            AutoPhone autoPhone=new AutoPhone();
            autoPhone.mockAttendance();
        }
    }
    @Scheduled(cron = "${pmClock}")
    public static void TimerTaskPm()  {
        long currentTimeStamp = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        Boolean workingDay;
        try {
            workingDay = HolidayUtils.isWorkingDay(currentTimeStamp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (workingDay) {
            AutoPhone autoPhone=new AutoPhone();
            autoPhone.mockAttendance();
        }
    }
}
