package com.oussemaouakad.surpriseme.Story;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NameToStoryGenerator {

    private static Map<Character, String> traitsMap = new HashMap<>();

    static {
        assignRandomTraits();
    }

    private static void assignRandomTraits() {
        // Assign random traits to each letter of the alphabet
        for (char letter = 'a'; letter <= 'z'; letter++) {
            if (!traitsMap.containsKey(letter)) {
                traitsMap.put(letter, getRandomTrait());
            }
        }
    }

    private static String getRandomTrait() {
        // Define a list of possible traits
        String[] possibleTraits = {"powerful", "gentle", "charming", "mysterious", "brave", "graceful", "creative", "adventurous"};

        // Randomly select a trait from the list
        Random random = new Random();
        int randomIndex = random.nextInt(possibleTraits.length);
        return possibleTraits[randomIndex];
    }

    public static String generateeStory(String name) {
        StringBuilder story = new StringBuilder("You are");
        Map<Character, Boolean> traitAssigned = new HashMap<>();

        // Generate story based on traits
        for (char letter : name.toLowerCase().toCharArray()) {
            if (traitsMap.containsKey(letter) && !traitAssigned.getOrDefault(letter, false)) {
                story.append(" ").append(traitsMap.get(letter)).append(",");
                traitAssigned.put(letter, true);
            }
        }


        System.out.println(story.toString());
        return story.toString();
    }

}

