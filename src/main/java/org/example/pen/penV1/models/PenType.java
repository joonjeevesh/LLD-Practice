package org.example.pen.penV1.models;

import lombok.Getter;

@Getter
public enum PenType {
    GEL(RefillType.GEL, InkType.GEL),
    BALL(RefillType.BALL, InkType.BALL),
    FOUNTAIN(RefillType.FOUNTAIN, InkType.FOUNTAIN),
    MARKER(RefillType.COLOR, InkType.COLOR);

    private RefillType refillType;

    private InkType inkType;

    PenType(RefillType refillType, InkType inkType) {
        this.refillType = refillType;
        this.inkType = inkType;
    }
}
