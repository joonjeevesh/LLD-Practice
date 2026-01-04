package org.example.pen.penV1.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Ink {
    private InkType type;
    private String color;
    private String brand;
}
