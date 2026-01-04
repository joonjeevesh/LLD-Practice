package org.example.pen.penV2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.pen.penV2.models.enums.RefillType;

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
