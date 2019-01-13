package com.gaurav.knightquest.knights;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BraveKnight implements Knight, BeanNameAware, BeanFactoryAware {

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
}
