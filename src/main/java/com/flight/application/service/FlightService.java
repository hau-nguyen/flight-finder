package com.flight.application.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlightService {
    private static final List<Character> FLIGHT_CHAR = Arrays.asList('f', 'l', 'i', 'g', 'h', 't');

    public Integer countFlight(String flightString) {
        if (flightString == null || flightString.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c: FLIGHT_CHAR) {
            charCount.put(c, 0);
        }

        for (char c : flightString.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            }
        }

        return findMinOccurrence(charCount);
    }

    private int findMinOccurrence(Map<Character, Integer> charCount) {
        int result = Integer.MAX_VALUE;
        for (char c: FLIGHT_CHAR) {
            result = Math.min(result, charCount.get(c));
        }
        return result;
    }
}
