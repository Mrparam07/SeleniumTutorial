package io.section14;

import com.beust.ah.A;
import org.testng.Assert;
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
        //streamFormat.filter(s->s.length()>4).sorted().forEach(s -> System.out.println(s));
        //limit
        streamFormat.filter(s->s.length()>4).limit(2).sorted().forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap(){
        String arr[] = {"parama","rishabh","yash","aditya","bharath"};
        List<String> list = Arrays.asList(arr);
        Stream<String> streamFormat = list.stream();

        streamFormat.sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
//        streamFormat.filter(s -> s.endsWith("a")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //merge to list
        List<String> listTwo = Arrays.asList("man","woman","child");
        //listTwo.addAll(list);
        Stream<String> mergedStream = Stream.concat(list.stream(),listTwo.stream()).sorted();

        //modified stream cannot be modified

        boolean find = mergedStream.anyMatch(s -> s.equalsIgnoreCase("child"));
        System.out.println(find);
        Assert.assertTrue(find);
    }

    @Test
    public void collectStream(){
        String arr[] = {"parama","rishabh","yash","aditya","bharath"};
        List<String> list = Arrays.asList(arr);
        Stream<String> streamFormat = list.stream();
//        List<String> l = streamFormat.filter(s -> s.endsWith("a")).collect(Collectors.toList());
//        String li = streamFormat.filter(s -> s.endsWith("a")).limit(1);
        String li = streamFormat.filter(s -> s.endsWith("a")).findFirst().orElse(null);

        System.out.println(li);
//        System.out.println(l.get(0));
//        System.out.println(l.get(1));
    }

    @Test
    public void Assignment(){
        Integer arr[] = {1,1,2,3,3,4,5,6,7,7,0};
        System.out.println(Arrays.toString(Arrays.stream(arr).distinct().toArray(Integer[]::new)));
        List<Integer> l= Arrays.stream(arr).distinct().collect(Collectors.toList());

        Stream<Integer> li = Arrays.stream(arr);

        List<Integer> lii = Arrays.asList(arr);
        Stream<Integer> liii = lii.stream();

//        List<Integer> chc = Arrays.asList(arr);
//        Stream<Integer> noStream = Arrays.stream(arr);
//        Stream<Integer> anoStream = Arrays.asList(arr).stream();
//        Stream<Integer> noStreamOther = (Stream<Integer>) Arrays.asList(1,1,2,3,3,4,5,6,7,7,0);
        //find all unique nos
//        List<Integer> unique = (List<Integer>) chc.stream().distinct();

    }
}

/*
Java Streams, part of the Java Stream API introduced in Java 8,
allow for functional-style operations on streams of elements,
such as map-reduce transformations on collections.

Collection list - stream
 */
