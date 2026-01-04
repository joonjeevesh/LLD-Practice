package org.example.pen.penV2.factories;

import org.example.pen.penV2.models.NonRefillablePen;
import org.example.pen.penV2.models.RefillPen;
import org.example.pen.penV2.models.RefillablePen;

public class PenFactory {
    public static NonRefillablePen.NonRefillablePenBuilder createNonRefillablePen() {
        return NonRefillablePen.builder();
    }

    public static RefillablePen.RefillablePenBuilder createRefillablePen() {
        return RefillablePen.refillablePenBuilder();
    }

    public static RefillPen.RefillPenBuilder createRefillPen() {
        return RefillPen.refillPenBuilder();
    }
}
