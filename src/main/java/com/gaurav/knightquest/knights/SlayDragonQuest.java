package com.gaurav.knightquest.knights;

import org.springframework.stereotype.Component;

@Component
public class SlayDragonQuest implements Quest {

    @Override
    public void embark() {
        System.out.println("Embarking the quest to Slay Dragon!!");
    }
}
