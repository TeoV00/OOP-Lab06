package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
    
    private static final int MAX_NUM = 2000;
    private static final int MIN_NUM = 1000;
    private static final int FIRST_ELEM_INDEX = 0;
    private static final int ELEMS = 100_000;
    private static final int READING_TIMES = 1000;
    private static final Double AFRICA_POPULATION = 1_110_635_000d;
    private static final Double AMERICAS_POPULATION = 972_005_000d;
    private static final Double ASIA_POPULATION = 4_298_723_000d;
    private static final Double EUROPE_POPULATION = 742_452_000d;
    private static final Double OCEANIA_POPULATION = 38_304_000d;
    private static final Double ANTARCTICA_POPULATION = 0.0;
    
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        var list = new ArrayList<Integer>();
        for (Integer num = MIN_NUM; num < MAX_NUM; num++) {
            list.add(num);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        var list2 = new LinkedList<Integer>(list);
        
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer tmp = list.get(list.size()-1);
        list.set(list.size()-1, list.get(FIRST_ELEM_INDEX));
        list.set(FIRST_ELEM_INDEX, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(Integer elem : list) {
            System.out.println(elem);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        
        for (int i = 1; i <= ELEMS; i++) {
            list.add(FIRST_ELEM_INDEX,i);
        }
        time = System.nanoTime() - time;
        System.out.println("Time1: \t" + time + " us");
        
        long time2 = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            list2.add(FIRST_ELEM_INDEX,i);
        }
        time2 = System.nanoTime() - time2;
        System.out.println("Time2: \t" + time2 + " us");
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        int middleIndex = (int) list.size()/2;
        long time3 = System.nanoTime();
        for(int i = 0; i < READING_TIMES; i++) {
            list.get(middleIndex);
        }
        time3 = System.nanoTime() - time3;
        System.out.println("Read time3: \t" + time3 + " us");
        
        long time4 = System.nanoTime();
        for(int i = 0; i < READING_TIMES; i++) {
            list.get(middleIndex);
        }
        time4 = System.nanoTime() - time4;
        System.out.println("Read time4: \t" + time4 + " us");
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        Map<String, Double> worldMap = new HashMap<>();
        worldMap.put("Africa", AFRICA_POPULATION);
        worldMap.put("Americas", AMERICAS_POPULATION);
        worldMap.put("Antarctica", ANTARCTICA_POPULATION);
        worldMap.put("sia", ASIA_POPULATION);
        worldMap.put("Europe", EUROPE_POPULATION);
        worldMap.put("Oceania", OCEANIA_POPULATION);
        /*
         * 8) Compute the population of the world
         */
        
        double worldPopulation = 0.0;
        for (final Map.Entry<String, Double> continent : worldMap.entrySet()) {
            worldPopulation += continent.getValue();
        }
        System.out.println("World population is : " + worldPopulation);
    }
}
