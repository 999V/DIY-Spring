package org.spring.springframework.handler;

public class CHandler extends AbstractHandler {

    public static final String SCORE_NAME = "C";


    @Override
    public String getScoreName() {
        return SCORE_NAME;
    }

    @Override
    public Double getScore() {
        return null;
    }

}
