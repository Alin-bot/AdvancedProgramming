package com.compulsory;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private final List<Token> pointList = new ArrayList<>();

    public void addTokenPoint(Token token) {
        pointList.add(token);
    }
}
