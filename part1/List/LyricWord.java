package java2.LabGroup2.part1.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LyricWord {
    private static final String[] lyric = {"you", "say", "it", "best",
            "when", "you", "say", "nothing", "at", "all"};

    public static void main(String[] args) {
        // Create a list that’s implemented by ArrayList
        // Add all String in string array to list
        List<String> words = new ArrayList<>(Arrays.asList(lyric));

        // Traverse the list
        for (Object o : words)
            System.out.print(o + " ");
        System.out.println("\n------------------");

        System.out.println("Contains [you]?:" + words.contains("you"));
        System.out.println("Contains [me]?:" + words.contains("me"));
        System.out.println("Where's [say]?:" + words.indexOf("say"));
        System.out.println("Where's the last [say]?: " + words.lastIndexOf("say"));

        //Sort words
        Collections.sort(words);

        //show all elements of words
        for (Object o : words) {
            System.out.print(o + " ");
        }
    }


}
