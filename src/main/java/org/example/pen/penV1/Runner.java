package org.example.pen.penV1;

import org.example.pen.penV1.models.*;
import org.example.pen.penV1.strategy.NotSoSmoothWritingStrategy;
import org.example.pen.penV1.strategy.SmoothWritingStrategy;

public class Runner
{
    public static void main( String[] args )
    {
        Ink blackBallInk = Ink.builder()
                .brand("Camel")
                .type(InkType.BALL)
                .color("Black")
                .build();

        Ink blueGelInk = Ink.builder()
                .brand("Camel")
                .type(InkType.GEL)
                .color("Blue")
                .build();

        Tip steelTip = Tip.builder()
                .radius(0.5)
                .type(TipType.STEEL)
                .build();

        Tip silvertip = Tip.builder()
                .type(TipType.SILVER)
                .radius(0.7)
                .build();

        NonRefillablePen blackNonRefillableBallPen = NonRefillablePen.builder()
                .penType(PenType.BALL)
                .model("Omni")
                .brand("Camel")
                .ink(blackBallInk)
                .tip(steelTip)
                .writingStrategy(new NotSoSmoothWritingStrategy())
                .build();

        Refill gelSilverRefill = Refill.builder()
                .ink(blueGelInk)
                .tip(silvertip)
                .build();

        RefillablePen blueRefillableGenPen = RefillablePen.builder()
                .brand("Cello")
                .refill(gelSilverRefill)
                .model("X-190")
                .penType(PenType.GEL)
                .writingStrategy(new SmoothWritingStrategy())
                .build();

        blackNonRefillableBallPen.write();
        blueRefillableGenPen.write();

        blueRefillableGenPen.changeRefill(gelSilverRefill);
    }
}
