package com.javainuse.util;

import java.util.Random;

/**
 * Contains number handling static methods
 */
public class NumberUtil {

    /**
     * Generates random number for given maximum and minimum interval
     * @param max of the interval
     * @param min of the interval
     * @return random object
     */
    public static Object generateRandomNumber(int max, int min){

        Random rand = new Random();
        double randomN =Math.round(((Math.random() * ((max - min) + 1)) + min)*100)/100;/* create Random Number */
        return randomN;
    }

}
