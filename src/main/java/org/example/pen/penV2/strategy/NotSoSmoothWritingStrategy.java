package org.example.pen.penV2.strategy;

public class NotSoSmoothWritingStrategy implements IWritingStrategy {
    @Override
    public void write() {
        System.out.println("Ugh! I am writing not so smoothly");
    }
}
