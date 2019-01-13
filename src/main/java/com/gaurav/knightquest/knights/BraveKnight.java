package com.gaurav.knightquest.knights;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BraveKnight implements Knight, BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, BeanPostProcessor , InitializingBean {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Bean Name: "+s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        SlayDragonQuest dragonQuest = beanFactory.getBean("slayDragonQuest", SlayDragonQuest.class);
        dragonQuest.embark();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SlayDragonQuest dragonQuest = applicationContext.getBean("slayDragonQuest", SlayDragonQuest.class);
        dragonQuest.embark();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.getClass().getName()+" "+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("\n"+bean.getClass().getName()+" "+beanName);
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After Properties Set");
    }
}
