package dev.verzano.aoc2020.day10;

import dev.verzano.aoc2020.Helper;

public class Day10Part1 {
    public static void main(String[] args) {
        var adapters = Helper.getResourceAsStringList("day10/input.txt")
                .stream()
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        var jump1s = 0;
        var jump3s = 0;

        var prevAdapter = 0;
        for (var adapter : adapters) {
            switch (adapter - prevAdapter) {
                case 1 -> jump1s++;
                case 3 -> jump3s++;
            }
            prevAdapter = adapter;
        }
        jump3s++;

        System.out.println("Number of 1 Jolt Jumps: " + jump1s);
        System.out.println("Number of 3 Jolt Jumps: " + jump3s);
        System.out.println("Product of 1 and 3 Jolt Jumps: " + (jump1s * jump3s));
    }
}
