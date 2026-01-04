package org.example.pen.penV2.models;

import lombok.Builder;
import lombok.Getter;
import org.example.pen.penV2.models.enums.BodyMaterialType;

@Getter
public class CapBody extends Body{

    private Cap cap;

    @Builder
    public CapBody(String text, BodyMaterialType materialType, Cap cap) {
        super(text, materialType);
        this.cap = cap;
    }

    @Override
    public void toggle() {
        if(this.state == State.READY) {
            closeCap();
        }
        else {
            openCap();
        }
    }

    private void openCap() {
        System.out.println("Opening pen cap");
        this.state = State.READY;
    }

    private void closeCap() {
        System.out.println("Closing pen cap");
        this.state = State.NOT_READY;
    }
}
