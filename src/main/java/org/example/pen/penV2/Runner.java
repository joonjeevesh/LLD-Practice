package org.example.pen.penV2;

import org.example.pen.penV2.factories.PenFactory;
import org.example.pen.penV2.interfaces.IRefillable;
import org.example.pen.penV2.models.*;
import org.example.pen.penV2.models.enums.BodyMaterialType;
import org.example.pen.penV2.models.enums.InkType;
import org.example.pen.penV2.strategy.NotSoSmoothWritingStrategy;
import org.example.pen.penV2.models.enums.PenType;
import org.example.pen.penV2.models.enums.TipType;
import org.example.pen.penV2.strategy.SmoothWritingStrategy;

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

        Refill gelRefill = Refill.builder()
                .ink(blueGelInk)
                .tip(silvertip)
                .build();


        Body clickBody = ClickBody.builder()
                        .button(Button.builder()
                        .color("Yellow")
                        .materialType(BodyMaterialType.CARBON_FIBRE)
                        .build())
                 .materialType(BodyMaterialType.PLASTIC)
                 .text("Click Body")
                 .build();

        Body capBody = CapBody.builder()
                .cap(Cap.builder()
                        .shape("Cone")
                        .text("Supercap")
                        .build())
                .materialType(BodyMaterialType.PLASTIC)
                .text("Cap Body")
                .build();

        //subclass not mentioned!
        //can easily change nonRefillablePen instance from factory without anything breaking!!
        Pen blackNonRefillableBallPen = PenFactory.createNonRefillablePen()
                .penType(PenType.BALL)
                .body(clickBody)
                .model("Omni")
                .brand("Camel")
                .ink(blackBallInk)
                .tip(steelTip)
                .writingStrategy(new NotSoSmoothWritingStrategy())
                .build();

        Pen blueRefillableGenPen = PenFactory.createRefillablePen()
                .brand("Cello")
                .body(capBody)
                .refill(gelRefill)
                .model("X-190")
                .penType(PenType.GEL)
                .writingStrategy(new SmoothWritingStrategy())
                .build();

        blackNonRefillableBallPen.getBody().toggle();
        blueRefillableGenPen.getBody().toggle();
        blackNonRefillableBallPen.write();
        blueRefillableGenPen.write();

        ((IRefillable) blueRefillableGenPen).changeRefill(gelRefill);
    }
}
