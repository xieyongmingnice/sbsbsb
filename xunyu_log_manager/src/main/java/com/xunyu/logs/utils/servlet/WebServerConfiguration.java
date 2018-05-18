package com.xunyu.logs.utils.servlet;

import org.apache.catalina.valves.AccessLogValve;
import org.apache.catalina.valves.Constants;
import org.apache.coyote.http11.Http11NioProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class WebServerConfiguration {
    private static final Logger log = LoggerFactory.getLogger(WebServerConfiguration.class);
    @Bean
    public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        //设置端口
        factory.setPort(8007);
        //设置404错误界面
        //factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        //设置在容器初始化的时候触发
        //factory.addInitializers((servletContext) -> {
            //log.info(" = = = = 获取服务器信息 = = " + servletContext.getServerInfo());
       // });
        //设置最大连接数和最大线程数
        factory.addConnectorCustomizers((connector) -> {
            Http11NioProtocol protocolHandler = (Http11NioProtocol) connector.getProtocolHandler();
            protocolHandler.setMaxConnections(2000);
            protocolHandler.setMaxThreads(500);
            protocolHandler.setMinSpareThreads(20);
            protocolHandler.setMinSpareThreads(50);
            protocolHandler.setMaxTrailerSize(512);

        });
        //设置访问日志记录文件的目录
        //factory.addContextValves(getLogAccessLogValue());
        return factory;
    }

    private AccessLogValve getLogAccessLogValue() {
        AccessLogValve accessLogValve = new AccessLogValve();
        //accessLogValve.setDirectory("d:/tmp/logs");
        accessLogValve.setDirectory("/opt/upload/msg-xunyu-all/catalina.base_IS_UNDEFINED/logs");
        accessLogValve.setEnabled(true);
        accessLogValve.setPattern(Constants.AccessLog.COMMON_PATTERN);
        accessLogValve.setPrefix("SpringBoot-Access-Log");
        accessLogValve.setSuffix(".txt");
        return accessLogValve;
    }
}