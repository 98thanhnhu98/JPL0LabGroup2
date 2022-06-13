package java2.LabGroup2.part1.Set;

import java.util.HashSet;
import java.util.Iterator;

public class LyricHashSet {
    private static final String[] lyric = {"you", "say", "it", "best",
            "when", "you", "say", "nothing", "at", "all"};
    public static void main(String[] args) {
        // Create a set from HashSet that’s implemented Set
        HashSet words = new HashSet();
        // Add all words to set
        for (String w : lyric)
            words.add(w);

        // Traverse the list
        // NOTICE: set doesn't allow duplicate items
        for (Object o : words)
            System.out.print(o + " ");
        System.out.println("\n------------------");

        System.out.println("Contains [you]?:" + words.contains("you"));
        System.out.println("Contains [me]?:" + words.contains("me"));


        Iterator it = words.iterator();
    }
}
