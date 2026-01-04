package org.example.pen.penV2.models;

import lombok.Builder;
import lombok.Getter;
import org.example.pen.penV2.models.enums.BodyMaterialType;

@Getter
@Builder
public class Button {
    private String color;
    private BodyMaterialType materialType;
}
