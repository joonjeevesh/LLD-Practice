package org.example.pen.penV1.models;

import lombok.Builder;
import lombok.Getter;
import org.example.pen.penV1.strategy.IWritingStrategy;

@Getter
public class RefillablePen extends Pen{

    @Builder
    public RefillablePen(String brand, String model, PenType penType, IWritingStrategy writingStrategy, Refill refill) {
        super(brand, model, penType, writingStrategy);
        this.refill = refill;
    }

    private Refill refill;

    public void changeRefill(Refill refill) {
        if(refill.getType()!=this.refill.getType()) {
            throw new IllegalArgumentException("Refill types cannot be different");
        }

        this.refill = refill;
    }
}
