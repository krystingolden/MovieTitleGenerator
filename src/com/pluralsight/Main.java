package com.pluralsight;

import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception

    {
        //Fill 2 arrays with values: adjectives from one URL and nouns from another URL
        String[] adjectives = arrayFromUrl("https://cs.leanderisd.org/txt/adjectives.txt");
        String[] nouns      = arrayFromUrl("https://cs.leanderisd.org/txt/nouns.txt");

        System.out.println("Mitchell's Random Movie Title Generator\n");

        System.out.print("Choosing randomly from " + adjectives.length + " adjectives ");
        System.out.println("and " + nouns.length + " nouns (" + (adjectives.length * nouns.length) + " combinations).");

        //Generate a random number from 0 to the number representing the size of the array
        //Use the random number as the index for the value from the array which should be stored in the variable
        String adjective = adjectives[(int) (Math.random() * adjectives.length)];
        String noun = nouns[(int) (Math.random() * nouns.length)];

        //Print out the movie title generated by using random values from the URL's
        System.out.println("Your movie title is: " + adjective + " " + noun);

    }

    //Store the list of values from the URL in an array and then return the array
    public static String[] arrayFromUrl( String url ) throws Exception
    {
        Scanner fin = new Scanner((new URL(url)).openStream());
        int count = fin.nextInt();

        String[] words = new String[count];

        for (int i = 0; i < words.length; i++)
        {
            words[i] = fin.next();
        }

        fin.close();
        return words;
    }

}

