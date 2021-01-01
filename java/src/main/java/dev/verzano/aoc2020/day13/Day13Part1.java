package dev.verzano.aoc2020.day13;

import dev.verzano.aoc2020.Helper;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day13Part1 {
    public static void main(String[] args) {
        var input = Helper.getResourceAsStringList("day13/input.txt");
        var earliestLeaveTime = Integer.parseInt(input.get(0));
        var busIds = Arrays.stream(input.get(1).split(","))
                .filter(bid -> !bid.equals("x"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        var firstId = true;
        var actualLeaveTime = 0;
        var chosenBusId = 0;

        for (var busId : busIds) {
            var leaveTime = busId;
            while (leaveTime < earliestLeaveTime) {
                leaveTime += busId;
            }

            if (firstId) {
                actualLeaveTime = leaveTime;
                chosenBusId = busId;
                firstId = false;
            } else if (leaveTime < actualLeaveTime) {
                actualLeaveTime = leaveTime;
                chosenBusId = busId;
            }
        }

        System.out.println("Actual Leave Time: " + actualLeaveTime);
        System.out.println("Chosen Bus Id: " + chosenBusId);
        System.out.println((actualLeaveTime - earliestLeaveTime) * chosenBusId);
    }
}
