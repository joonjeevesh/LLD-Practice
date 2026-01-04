package org.example.pen.penV2.models;

import lombok.Getter;
import org.example.pen.penV2.models.enums.BodyMaterialType;

@Getter
public abstract class Body {
    private String text;
    private BodyMaterialType materialType;
    protected State state;

    public Body(String text, BodyMaterialType materialType) {
        this.text = text;
        this.materialType = materialType;
        this.state = State.NOT_READY;
    }

    abstract public void toggle();
}
