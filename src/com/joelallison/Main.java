package com.joelallison;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String[] gameArray;

    public static void main(String[] args) {
        setup();
        //make a setup method or move code
        //add an array size int and a player names string
        int numOfPlayers = setupPlayerNum()
        gameloop(numOfPlayers, arraySize, setupNames(numOfPlayers));

        printArray(gameArray);
    }

    public static int setupPlayerNum(){
        System.out.println("How many [non-computer] players are playing?");
        return Integer.parseInt(getInput());

    }

    public static String[] setupNames(int numberOfPlayers){

        String[] playerNames = new String[numOfPlayers];
        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.println("What's player " + i + "'s name?");
            playerNames[i-1] = getInput();
        }
        return playerNames;
    }
    /*
        System.out.println("How big is the array going to be?");
        int arraySize = input.nextInt();
        gameArray = new String[arraySize];*/

    public static String getInput(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public static void gameloop(int numOfPlayers, int arraySize, String[] playerNames){
        Random random = new Random();
        int totalGuesses = 0;
        int currentPlayer = 0;
        while ((arraySize - totalGuesses - numOfPlayers) > 0) {
            if (currentPlayer == numOfPlayers+1){
                currentPlayer = 0;
            }//finish code
        }
    }

    public static void clearConsole(){ //this is done to try to prevent cheating
        System.out.println("\n\n\n\n\n\n\n\n");
    }

    public static void printArray(String[] array){
        for (String name : array) {
            if(name.equals("")){
                System.out.println("---");
            }else{
                System.out.println(name);
            }
        }
    }//add more try catches
}
