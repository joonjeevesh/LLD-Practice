package org.example.pen.penV2.models;

import lombok.Builder;
import lombok.Getter;
import org.example.pen.penV2.models.enums.PenType;
import org.example.pen.penV2.strategy.IWritingStrategy;

@Getter
public class RefillPen extends Pen {

    @Builder(builderMethodName = "refillPenBuilder")
    public RefillPen(Body body, String brand, String model, PenType penType, IWritingStrategy writingStrategy, Refill refill) {
        super(body, brand, model, penType, writingStrategy);
        this.refill = refill;
    }

    protected Refill refill;

}
