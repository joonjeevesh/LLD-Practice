package org.example.pen.penV2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.pen.penV2.models.enums.TipType;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Tip {
    private Double radius;
    private TipType type;
}
