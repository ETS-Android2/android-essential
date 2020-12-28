package com.veselove.tic_tac_toev10;

public class Player {

    static Player player1 = new Player();
    static Player player2 = new Player();

    private String name;
    private int pointsCounter = 0;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPoint() {
        pointsCounter++;
    }

    public int getPointsCounter(){
        return pointsCounter;
    }

}
