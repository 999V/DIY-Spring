package org.spring.springframework.handler;

public class AHandler extends AbstractHandler {

    public static final String SCORE_NAME = "A";


    @Override
    public String getScoreName() {
        return SCORE_NAME;
    }

    @Override
    public Double getScore() {
        return null;
    }
}
