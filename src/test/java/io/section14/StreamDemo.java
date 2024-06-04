package io.section14;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        String arr[] = {"param","rishabh","yash","aditya","bharath"};
        List<String> list = Arrays.asList(arr);

        Stream<String> streamFormat = Stream.of(arr);
        Stream<Integer> streamCreate = Stream.of(1,2,3,4,5,6,7,8,9,0);

        List<String> result = list.stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }

    @Test
    public void streamFilter(){
        String arr[] = {"param","rishabh","yash","aditya","bharath"};
        List<String> list = Arrays.asList(arr);
        Stream<String> streamFormat = list.stream();

//        long size = list.stream().filter(s -> s.startsWith("p")).count();
        //System.out.println(size);

        long d = Stream.of("param","rishabh","yash","aditya","bharath").filter(s ->
        {
            s.startsWith("r");
            return true;
        }).count();

        //long a = Stream.of("param","rishabh","yash","aditya","bharath").filter(s ->
        long a = list.stream().filter(s ->
            s.startsWith("a")).count();
        System.out.println(a);

        //print all the name
        streamFormat.filter(s->s.length()>4).sorted().forEach(s -> System.out.println(s));
    }
}

/*
Java Streams, part of the Java Stream API introduced in Java 8,
allow for functional-style operations on streams of elements,
such as map-reduce transformations on collections.
 */
