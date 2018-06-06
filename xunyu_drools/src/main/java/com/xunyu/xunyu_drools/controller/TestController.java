package com.xunyu.xunyu_drools.controller;

import com.xunyu.xunyu_drools.model.Address;
import com.xunyu.xunyu_drools.model.PaymentInfo;
import com.xunyu.xunyu_drools.model.fact.AddressCheckResult;
import org.drools.compiler.kproject.ReleaseIdImpl;
import org.drools.core.io.impl.UrlResource;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.Random;


@RequestMapping("/test")
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/remote")
    public void testUrl(int num) throws Exception{
        //tomcat bin目录下有repositories文件夹，下面是kie文件夹，对应目录下,即 bin/repositories/kie/路径A
        //http://ip:port/war包名称/maven2/路径A
        String url = "http://47.104.190.41:8080/kie-drools-wb/maven2/com/xunyu/xunyu_drools/1.0/xunyu_drools-1.0.jar";
        ReleaseIdImpl releaseId = new ReleaseIdImpl("com.xunyu", "xunyu_drools", "LATEST");
        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        UrlResource urlResource = (UrlResource) ks.getResources().newUrlResource(url);
        urlResource.setUsername("tomcat");
        urlResource.setPassword("tomcat");
        urlResource.setBasicAuthentication("enabled");
        InputStream is = urlResource.getInputStream();
        KieModule kModule = kr.addKieModule(ks.getResources().newInputStreamResource(is));
        KieContainer kContainer = ks.newKieContainer(kModule.getReleaseId());
        KieSession kieSession = kContainer.newKieSession();

        Address address = new Address();
        address.setPostcode(generateRandom(num));

        AddressCheckResult result = new AddressCheckResult();
        kieSession.insert(address);
        kieSession.insert(result);
        int ruleFiredCount = kieSession.fireAllRules();
        kieSession.destroy();
        System.out.println("触发了" + ruleFiredCount + "条规则");
        if(result.isPostCodeResult()){
            System.out.println("规则校验通过");
        }
        StatelessKieSession session = kContainer.newStatelessKieSession("defaultStatelessKieSession");

        PaymentInfo m = new PaymentInfo();
        m.setMoneyAmount(num);
        session.execute(m);
        System.out.println(m.getDecisionPath());
        if (m.getDecisionPath().equalsIgnoreCase("m")) {
            System.out.println("数额<=5000需要经理审批");
        } else {
            System.out.println("数额>5000需要总经理审批");
        }
    }

    /**
     * 生成随机数
     * @param num
     * @return
     */
    public String generateRandom(int num) {
        String chars = "0123456789";
        StringBuffer number=new StringBuffer();
        for (int i = 0; i < num; i++) {
            int rand = new Random().nextInt(10);
            number=number.append(chars.charAt(rand));
        }
        return number.toString();
    }

}
