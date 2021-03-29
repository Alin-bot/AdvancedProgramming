package com.compulsory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Token {

    Random rand = new Random();
    Map<Token, Integer> map = new HashMap<>();

    public Map<Token, Integer> getMap() {
        return map;
    }

    public Token() {

    }

    public void addNode(Token token) {
        map.put(token, rand.nextInt(5));
    }


}
