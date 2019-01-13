package com.gaurav.knightquest.knights;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BraveKnight implements Knight, BeanNameAware {

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
}
