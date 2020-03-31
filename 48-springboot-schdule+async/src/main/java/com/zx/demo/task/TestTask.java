package com.zx.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 
 * 定时任务测试类
 * @author zhang
 *
 */
@Component
public class TestTask {
	
	
//	second , minute, hour, day of month, month and day of week.
//	{@code "0（秒） *（分） *（时） *（日） *（月） MON-FRI（周几）"}
//	1、cron 定时任务表达式 @Scheduled(cron="*/1 * * * * *") 表示每秒
//	1）crontab 工具  https://tool.lu/crontab/
//	2、fixedRate: 定时多久执行一次（上一次开始执行时间点后xx秒再次执行；）
//	3、fixedDelay: 上一次执行结束时间点后xx秒再次执行
//	4、fixedDelayString:  字符串形式，可以通过配置文件指定
//	@Scheduled(cron = "0 * * * * 0-7")
	public void task() {
		System.out.println("我是定时任务");
	}
}
