package org.example.pen.penV2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.pen.penV2.models.enums.PenType;
import org.example.pen.penV2.strategy.IWritingStrategy;

//v2 - pen should have cap/button to preserve tip
// pen can have a refill but not able to change refill
@Getter
@AllArgsConstructor
public abstract class Pen {
    private Body body;
    private String brand;
    private String model;

    private PenType penType;
    private IWritingStrategy writingStrategy;

    public void write() {
        if(body.getState()!=State.READY) {
            throw new RuntimeException("Pen is not ready to write");
        }
        writingStrategy.write();
    }
}
