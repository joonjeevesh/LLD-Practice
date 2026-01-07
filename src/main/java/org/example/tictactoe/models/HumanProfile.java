package org.example.tictactoe.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HumanProfile {
    private long id;
    private String name;
    private String email;
    private byte[] photo;
}
