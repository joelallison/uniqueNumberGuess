package com.joelallison;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String[] gameArray;

    public static void main(String[] args) {
        int numOfPlayers = setupPlayerNum();
        gameloop(numOfPlayers, arraySize(), setupNames(numOfPlayers));

        printArray(gameArray);
    }

    public static int setupPlayerNum(){
        System.out.println("How many [non-computer] players are playing?");
        return Integer.parseInt(getInput());

    }

    public static String[] setupNames(int numOfPlayers){

        String[] playerNames = new String[numOfPlayers];
        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.println("What's player " + i + "'s name?");
            playerNames[i-1] = getInput();
        }
        return playerNames;
    }

    public static int arraySize(){
        System.out.println("How big is the array going to be?");
        int arraySize = Integer.parseInt(getInput());
        gameArray = new String[arraySize];
        return arraySize;
    }

    public static String getInput(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public static void gameloop(int numOfPlayers, int arraySize, String[] playerNames){
        int totalGuesses = 0;
        int currentPlayer = 0;
        while ((arraySize - totalGuesses - numOfPlayers) > 0) {
            if (currentPlayer == numOfPlayers+1){
                System.out.println("It's the computer's turn!");
                makeGuess(computerGuess(arraySize), "Computer");
                System.out.println("The computer has made its guess.");
                totalGuesses++;
                currentPlayer = 0;
            }else{
                currentPlayer++;
                System.out.println("It's " + playerNames[currentPlayer-1] + "'s turn!\nPlease make your guess:");
                int playerGuess = Integer.parseInt(getInput());
                makeGuess(playerGuess, playerNames[currentPlayer-1]);
                totalGuesses++;
                clearConsole();
            }
        }
    }

    public static void clearConsole(){ //this is done to try to prevent cheating
        System.out.println("\n\n\n\n\n\n\n\n");
    }

    public static int computerGuess(int arraySize){
        Random random = new Random();
        return random.nextInt(arraySize);
    }

    public static void makeGuess(int guess, String playerName){
        if(gameArray[guess-1] == null){
            gameArray[guess-1] = playerName;
        }
    }

    public static void printArray(String[] array){
        for (String name : array) {
            if(name.equals("")){
                System.out.println("---");
            }else{
                System.out.println(name);
            }
        }
    }
}
