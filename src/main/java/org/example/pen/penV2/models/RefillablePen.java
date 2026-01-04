package org.example.pen.penV2.models;

import lombok.Builder;
import lombok.Getter;
import org.example.pen.penV2.models.enums.PenType;
import org.example.pen.penV2.strategy.IWritingStrategy;

@Getter
public class RefillablePen extends RefillPen {

    @Builder(builderMethodName = "refillablePenBuilder")
    public RefillablePen(Body body, String brand, String model, PenType penType, IWritingStrategy writingStrategy, Refill refill) {
        super(body, brand, model, penType, writingStrategy, refill);
    }

    public void changeRefill(Refill refill) {
        if(refill.getType()!=this.refill.getType()) {
            throw new IllegalArgumentException("Refill types cannot be different");
        }

        this.refill = refill;
    }
}
