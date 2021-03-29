package com.compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Board implements Runnable {

    public int numberOfToken;
    List<Token> tokenList;

    public Board(int numberOfToken) {
        this.numberOfToken = numberOfToken;
        var tokens = IntStream.rangeClosed(0, numberOfToken)
                .mapToObj(i -> new Token() )
                .toArray(Token[]::new);
        List<Token> tokenList = new ArrayList<>(); // list of tokens
        Collections.addAll(tokenList, tokens);


    }

    @Override
    public void run() {

    }

}
