package com.veselove.tic_tac_toev10;

public class Logic {

    static int[][] currentField = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public static boolean winDetector(int[][] field) {

        boolean isWinning = false;

        if (field[0][0] == 1 && field[0][1] == 1 && field[0][2] == 1) isWinning = true;
        if (field[1][0] == 1 && field[1][1] == 1 && field[1][2] == 1) isWinning = true;
        if (field[2][0] == 1 && field[2][1] == 1 && field[2][2] == 1) isWinning = true;
        if (field[0][0] == 1 && field[1][0] == 1 && field[2][0] == 1) isWinning = true;
        if (field[0][1] == 1 && field[1][1] == 1 && field[2][1] == 1) isWinning = true;
        if (field[0][2] == 1 && field[1][2] == 1 && field[2][2] == 1) isWinning = true;
        if (field[0][0] == 1 && field[1][1] == 1 && field[2][2] == 1) isWinning = true;
        if (field[2][0] == 1 && field[1][1] == 1 && field[0][2] == 1) isWinning = true;

        if (field[0][0] == 2 && field[0][1] == 2 && field[0][2] == 2) isWinning = true;
        if (field[1][0] == 2 && field[1][1] == 2 && field[1][2] == 2) isWinning = true;
        if (field[2][0] == 2 && field[2][1] == 2 && field[2][2] == 2) isWinning = true;
        if (field[0][0] == 2 && field[1][0] == 2 && field[2][0] == 2) isWinning = true;
        if (field[0][1] == 2 && field[1][1] == 2 && field[2][1] == 2) isWinning = true;
        if (field[0][2] == 2 && field[1][2] == 2 && field[2][2] == 2) isWinning = true;
        if (field[0][0] == 2 && field[1][1] == 2 && field[2][2] == 2) isWinning = true;
        if (field[2][0] == 2 && field[1][1] == 2 && field[0][2] == 2) isWinning = true;

        return isWinning;

    }

    public static boolean playerMoveHandler(int playerNumber, String address) {
        if (playerNumber == 0) {

            int index1 = Character.getNumericValue(address.charAt(0));
            int index2 = Character.getNumericValue(address.charAt(1));
            currentField[index1][index2] = 1;
        }
        if (playerNumber == 1) {
            int index1 = Character.getNumericValue(address.charAt(0));
            int index2 = Character.getNumericValue(address.charAt(1));
            currentField[index1][index2] = 2;
        }
        return winDetector(currentField);
    }

    public static void clearField(){
        currentField = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    }
}



//final String TAG = "aaaa";                                                                        //logging
//Log.d(TAG,  Character.getNumericValue(address.charAt(0)) + "ssssssssssssssssssssss");             //logging
//Log.d(TAG,  Character.getNumericValue(address.charAt(1)) + "ssssssssssssssssssssss");             //logging


//    public static void printArray(){
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(currentField[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }