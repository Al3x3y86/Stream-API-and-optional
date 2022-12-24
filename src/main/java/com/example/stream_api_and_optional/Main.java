package com.example.stream_api_and_optional;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbersList = Arrays.asList(11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        System.out.println("Массив чисел:\n" + numbersList);

        Stream<Integer> stream1 = numbersList.stream();
        System.out.println("Задание 1");
        findMinMax(
                stream1,
                (x, y) -> x.compareTo(y),
                (x, y) -> System.out.println("Минимальное число- " + x + "\nМаксимальное число- " + y)
        );

        System.out.println("Задание 2");
        Stream<Integer> stream2 = numbersList.stream();
        System.out.println("Количество четных чисел: " + findOfEvenNumbers(stream2.toList()));
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static int findOfEvenNumbers(List<Integer> numbersList) {

        return (int) numbersList.stream()
                .filter(i -> i % 2 == 0)
                .count();
    }
}