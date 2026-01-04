package org.example.pen.penV2.models;

import lombok.Builder;
import lombok.Getter;
import org.example.pen.penV2.models.enums.BodyMaterialType;

@Getter
public class ClickBody extends Body{

    private Button button;

    @Builder
    public ClickBody(String text, BodyMaterialType materialType, Button button) {
        super(text, materialType);
        this.button = button;
    }

    @Override
    public void toggle() {
        if(this.state == State.READY) {
            unclickCap();
        }
        else {
            clickButton();
        }
    }

    private void clickButton() {
        System.out.println("Clicking pen button");
        this.state = State.READY;
    }

    private void unclickCap() {
        System.out.println("Unclicking pen button");
        this.state = State.NOT_READY;
    }
}
