package com.compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Board implements Runnable {

    public int numberOfTokens;
    List<Token> tokenList;

    public Board(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
        var tokens = IntStream.rangeClosed(0, numberOfTokens)
                .mapToObj(i -> new Token())
                .toArray(Token[]::new);
        tokenList = new ArrayList<>(); // list of tokens
        Collections.addAll(tokenList, tokens);

        for (Token tok : tokenList) {
            for (Token en : tokenList) {
                if (tok != en) {
                    tok.addNode(en);
                }
            }
        }

        for (Token t : tokenList) {
            System.out.println(t);
            System.out.println(t.getMap());
        }
    }

    @Override
    public void run() {

    }

}
