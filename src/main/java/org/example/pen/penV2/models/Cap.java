package org.example.pen.penV2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Cap {
    private String text;
    private String shape;
}
