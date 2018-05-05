package com.xunyu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.xunyu.config.servlet.DruidStatViewServlet;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DruidConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);

    @Value("${db.host}")
    private String ip;
    @Value("${db.port}")
    private String port;
    @Value("${db.name}")
    private String dbName;
    @Value("${db.public-key}")
    private String publicKey;
    @Value("${spring.datasource.type}")
    private String type;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.initial-size}")
    private Integer initialSize;
    @Value("${spring.datasource.min-idle}")
    private Integer minIdle;
    @Value("${spring.datasource.max-active}")
    private Integer maxActive;
    @Value("${spring.datasource.query-timeout}")
    private Integer maxWait;
    //@Value("${db.encrypt.flag}")
    private String encryptFlag;

    @ConditionalOnClass(DruidDataSource.class)
    @ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource", matchIfMissing = true)
    class Druid extends DruidConfiguration {
		
		/*@Bean(name = "dataSource")
		public DruidDataSource dataSource(DataSourceProperties properties) throws SQLException {
			DruidDataSource druidDataSource = (DruidDataSource) properties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
			druidDataSource.setFilters("config");
			druidDataSource.addConnectionProperty("config.decrypt", "true");
			druidDataSource.addConnectionProperty("config.decrypt.key", publicKey);
			druidDataSource.addFilters("com.alibaba.druid.filter.stat.StatFilter");
			DatabaseDriver databaseDriver = DatabaseDriver.fromJdbcUrl(properties.determineUrl());
			String validationQuery = databaseDriver.getValidationQuery();
			if(validationQuery != null) {
				druidDataSource.setValidationQuery(validationQuery);
			}
			logger.info("DruidConfiguration init completed................");
			return druidDataSource;
		}*/

        @Bean     //声明其为Bean实例
        @Primary  //在同样的DataSource中，首先使用被标注的DataSource
        public DataSource dataSource() {
            DruidDataSource datasource = new DruidDataSource();
            datasource.setUrl(url);
            datasource.setUsername(username);
            datasource.setPassword(password);
            datasource.setDriverClassName(driverClassName);
            datasource.setInitialSize(initialSize);
            datasource.setMinIdle(minIdle);
            datasource.setMaxActive(maxActive);
            datasource.setMaxWait(maxWait);
            datasource.setTimeBetweenEvictionRunsMillis(60000);// 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
            datasource.setMinEvictableIdleTimeMillis(300000);// 配置一个连接在池中最小生存的时间，单位是毫秒
            datasource.setValidationQuery("SELECT 1 FROM DUAL");
            datasource.setTestWhileIdle(true);
            datasource.setTestOnBorrow(false);
            datasource.setTestOnReturn(false);
            //打开PSCache，并且指定每个连接上PSCache的大小
            datasource.setPoolPreparedStatements(true);
            datasource.setMaxPoolPreparedStatementPerConnectionSize(20);
            try {
                datasource.setFilters("config,stat,wall,log4j");
            } catch (SQLException e) {
                //logger.log(Level.ERROR, "druid configuration initialization filter : {0}", e);
                System.err.println("druid configuration initialization filter :");
                e.printStackTrace();
            }
            datasource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000;config.decrpt=true;config.decrypt.key=your public key");
            logger.info("DruidConfiguration init completed................");
            return datasource;
        }

        @Bean(name = "sqlSessionFactory")
        @Primary
        public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setDataSource(dataSource);
            bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/mybatis-config.xml"));
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/*.xml"));

            return bean.getObject();
        }

        @Bean(name = "sqlSessionTemplate")
        @Primary
        public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

   /* @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(209715200);//配置文件最大值  200MB
        multipartResolver.setMaxInMemorySize(1048576);//配置缓存
        return multipartResolver;
    }*/
   @Bean
   public ServletRegistrationBean registrationBean() {
       ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet());    //添加初始化参数：initParams
       servletRegistrationBean.addUrlMappings("/druid/*");
       //白名单：
       servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
       //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
       servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
       //登录查看信息的账号密码.
       servletRegistrationBean.addInitParameter("loginUsername", "admin");
       servletRegistrationBean.addInitParameter("loginPassword", "123456");
       //是否能够重置数据.
       servletRegistrationBean.addInitParameter("resetEnable", "false");
       return servletRegistrationBean;
   }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
