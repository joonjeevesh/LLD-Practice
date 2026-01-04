package org.example.pen.penV1.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Tip {
    private Double radius;
    private TipType type;
}
