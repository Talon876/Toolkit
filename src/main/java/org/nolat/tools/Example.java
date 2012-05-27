package org.nolat.tools;

import java.awt.Color;

public class Example {
    public static void main(String[] args) {
        System.out.println("This is a simple example of some of the things the Toolkit can do.");
        float angle = Toolkit.randomAngle();
        System.out.println(angle + " radians in degrees is " + Toolkit.toDegrees(angle));
        float lerpAmount = Toolkit.randomRange(0f, 1f);
        Color result = Toolkit.colorLerp(Color.RED, Color.BLUE, lerpAmount);
        System.out.println("The color " + lerpAmount + "% between red and blue is " + result.getRed() + ", "
                + result.getGreen() + ", " + result.getBlue());
    }
}
