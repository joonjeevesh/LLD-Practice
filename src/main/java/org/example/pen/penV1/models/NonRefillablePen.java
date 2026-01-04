package org.example.pen.penV1.models;

import lombok.Builder;
import lombok.Getter;
import org.example.pen.penV1.strategy.IWritingStrategy;

@Getter
public class NonRefillablePen extends Pen{

    @Builder
    public NonRefillablePen(String brand, String model, PenType penType, IWritingStrategy writingStrategy,
                            Ink ink, Tip tip) {
        super(brand, model, penType, writingStrategy);
        this.tip = tip;
        this.ink = ink;
    }

    private Ink ink;
    private Tip tip;
}
