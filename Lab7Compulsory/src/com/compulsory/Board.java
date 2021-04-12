package com.compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Board implements Runnable {

    public int numberOfTokens;
    List<Token> tokenList;
    Random rand;

    public Board(int numberOfTokens) {

        rand = new Random();
        this.numberOfTokens = numberOfTokens;
        tokenList = new ArrayList<>();

        for (int i = 0; i < numberOfTokens; i++) {
            Token t = new Token(i, i+1, rand.nextInt(5));
            tokenList.add(t);
        }
        //Token t = new Token(numberOfTokens - 2, 0, rand.nextInt(5));
        //tokenList.add(t);



        /*
        var tokens = IntStream.rangeClosed(0, numberOfTokens)
                .mapToObj(i -> new Token(rand.nextInt(numberOfTokens + 1), rand.nextInt(numberOfTokens + 1), rand.nextInt(4)))
                .toArray(Token[]::new);
        tokenList = new ArrayList<>(); // list of tokens
        Collections.addAll(tokenList, tokens);
        */



    }

    @Override
    public void run() {

    }

}
