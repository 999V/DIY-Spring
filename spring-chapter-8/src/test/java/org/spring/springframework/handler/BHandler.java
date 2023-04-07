package org.spring.springframework.handler;

public class BHandler extends AbstractHandler {

    public static final String SCORE_NAME = "B";


    @Override
    public String getScoreName() {
        return SCORE_NAME;
    }

    @Override
    public Double getScore() {
        return null;
    }

}
