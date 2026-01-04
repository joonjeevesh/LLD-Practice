package org.example.pen.penV2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.pen.penV2.models.enums.InkType;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Ink {
    private InkType type;
    private String color;
    private String brand;
}
