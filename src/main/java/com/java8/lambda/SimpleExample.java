package com.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Title: SimpleExample <br>
 * ProjectName: learn-base <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/15 15:54 <br>
 */
public class SimpleExample {

    public static void main(String[] args) {
        String[] words = {"a", "abc", "ab", "abcd", "abcde", "ac"};
        System.out.println("before:" + Arrays.toString(words));
//        Arrays.sort(words, Comparator.comparingInt(String::length));
        Arrays.sort(words, (first, second) -> Integer.compare(first.length(), second.length()));
        System.out.println("after:" + Arrays.toString(words));
    }
}
