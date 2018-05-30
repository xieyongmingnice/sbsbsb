package com.xunyu.xunyu_drools.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @description 配置类
 * @date 2018/5/17 10:56
 */
@Configuration
public class DroolsAutoConfiguration {

//    private static final String RULES_PATH = "rules/";
//
//    @Bean
//    @ConditionalOnMissingBean(KieFileSystem.class)
//    public KieFileSystem kieFileSystem() throws IOException {
//        KieFileSystem kieFileSystem = getKieServices().newKieFileSystem();
//        for (Resource file : getRuleFiles()) {
//            kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + file.getFilename(), "UTF-8"));
//        }
//        return kieFileSystem;
//    }
//
//    /**
//     * 获取规则文件
//     * @return rules/ 目录下的drl规则文件
//     * @throws IOException
//     */
//    private Resource[] getRuleFiles() throws IOException {
//        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//        return resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "**/*.*");
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(KieContainer.class)
//    public KieContainer kieContainer() throws IOException {
//        final KieRepository kieRepository = getKieServices().getRepository();
//
//        kieRepository.addKieModule(() -> kieRepository.getDefaultReleaseId());
//
//        KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem());
//        kieBuilder.buildAll();
//
//        KieContainer kieContainer=getKieServices().newKieContainer(kieRepository.getDefaultReleaseId());
//
//        return kieContainer;
//    }
//
//    private KieServices getKieServices() {
//        return KieServices.Factory.get();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(KieBase.class)
//    public KieBase kieBase() throws IOException {
//        return kieContainer().getKieBase();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(KieSession.class)
//    public KieSession kieSession() throws IOException {
//        return kieContainer().newKieSession();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(KModuleBeanFactoryPostProcessor.class)
//    public KModuleBeanFactoryPostProcessor kiePostProcessor() {
//        return new KModuleBeanFactoryPostProcessor();
//    }
}
