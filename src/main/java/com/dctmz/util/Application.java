package com.dctmz.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
  public static void run(Class<?> primarySource, String[] args) throws UnknownHostException {
    ConfigurableApplicationContext application = SpringApplication.run(primarySource, args);
    Environment env = application.getEnvironment();
    String ip = InetAddress.getLocalHost().getHostAddress();
    String port = env.getProperty("server.port");
    String contextPath = env.getProperty("server.servlet.context-path");
    log.info("\n----------------------------------------------------------\n\t" +
        "Application is running! Access URLs:\n\t" +
        "Local: \t\thttp://localhost:" + port + contextPath + "/\n\t" +
        "External: \thttp://" + ip + ":" + port + contextPath + "/\n\t" +
        "----------------------------------------------------------");
  }
}
