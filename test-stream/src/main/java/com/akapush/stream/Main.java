package com.akapush.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        IntStream stream = IntStream.range(1, 10);
        String result = stream.reduce("", (String accumulateur, int value) ->  {
            System.out.println(accumulateur + " - " + value);
            return accumulateur + value; });
        System.out.println(result);
    }
}
