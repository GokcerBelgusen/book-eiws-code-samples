package net.lkrnac.book.eiws.chapter01.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.lkrnac.book.eiws.chapter01.async.task.Caller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan(basePackageClasses = Caller.class)
@EnableAsync
public class AsyncConfigurationSmallerPool {
  @Bean
  @Qualifier(SpringConstants.TASK_EXECUTOR)
  public ExecutorService createThreadPool() {
    return Executors.newWorkStealingPool();
  }
}