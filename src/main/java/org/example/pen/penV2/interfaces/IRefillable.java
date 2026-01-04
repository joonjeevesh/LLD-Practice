package org.example.pen.penV2.interfaces;

import org.example.pen.penV2.models.Refill;

//seems overkill right now, removing - when change refill was not needed because we were exposing subclass
//if we do not want to expose subclass using factory, we can cast to IRefillable and call change refill!!!
public interface IRefillable {
    public void changeRefill(Refill refill);
}
