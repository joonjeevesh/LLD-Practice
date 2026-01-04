package org.example.pen.penV1.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class Refill {
    private Double radius;
    private Ink ink;
    private Tip tip;
    private RefillType type;
}
