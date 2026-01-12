package org.example.snakesAndLadders.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Dice {
    private int maxFaceValue;

    //gives random value from 1 to maxFaceValue
    public int roll() {
       return (int) (Math.random() * maxFaceValue + 1);
    }
}
