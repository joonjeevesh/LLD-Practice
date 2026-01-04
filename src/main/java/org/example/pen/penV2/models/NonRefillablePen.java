package org.example.pen.penV2.models;

import lombok.Builder;
import lombok.Getter;
import org.example.pen.penV2.models.enums.PenType;
import org.example.pen.penV2.strategy.IWritingStrategy;

@Getter
public class NonRefillablePen extends Pen {

    @Builder
    public NonRefillablePen(Body body, String brand, String model, PenType penType, IWritingStrategy writingStrategy,
                            Ink ink, Tip tip) {
        super(body, brand, model, penType, writingStrategy);
        this.tip = tip;
        this.ink = ink;
    }

    private Ink ink;
    private Tip tip;
}
