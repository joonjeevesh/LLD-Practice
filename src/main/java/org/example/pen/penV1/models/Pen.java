package org.example.pen.penV1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.pen.penV1.strategy.IWritingStrategy;

//v1 - we have pen that can ball, gel, fountain, marker
// our pen can be refillable - structure is pen has refill has ink, tip
//or non-refillable - pen has ink, tip
@Getter
@AllArgsConstructor
public abstract class Pen {
    private String brand;
    private String model;
    private PenType penType;
    private IWritingStrategy writingStrategy;

    public void write() {
        writingStrategy.write();
    }
}
