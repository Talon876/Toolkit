package org.nolat;

import java.awt.Color;
import java.util.Random;

/**
 * A class that provides various mathematical/random functions.
 * 
 * @author Talon
 * 
 */
public class Toolkit {

    private static Random random = new Random();

    public static final float PI = (float) Math.PI;
    public static final float PiOver2 = (float) (Math.PI / 2.0);
    public static final float PiOver4 = (float) (Math.PI / 4.0);
    public static final float TwoPi = (float) (Math.PI * 2.0);

    /**
     * 
     * @return The Random instance this toolkit is using.
     */
    public static Random random() {
        return random;
    }

    /**
     * Generates a random float between the min and max.
     * 
     * @param min
     *            The minimum number, inclusive.
     * @param max
     *            The maximum number, inclusive.
     * @return A random float between the min and max.
     */
    public static float randomRange(float min, float max) {
        return (float) random.nextDouble() * (max - min) + min;
    }

    /**
     * Generates a random int between the min and max.
     * 
     * @param min
     *            The minimum number, inclusive.
     * @param max
     *            The maximum number, inclusive.
     * @return A random integer between the min and max.
     */
    public static int randomRange(int min, int max) {
        return (int) random.nextDouble() * (max - min) + min;
    }

    /**
     * Creates a random color by generating 3 (4 if random alpha is specified)
     * random integers between 0 and 255 and creating a Color out of them.
     * 
     * @param alpha
     *            If true, the color will have a random alpha value too.
     * @return A random color.
     */
    public static Color randomColor(boolean alpha) {
        byte r = (byte) randomRange(0, 255);
        byte g = (byte) randomRange(0, 255);
        byte b = (byte) randomRange(0, 255);
        byte a = (byte) randomRange(0, 255);
        if (alpha) {
            return new Color(r, g, b, a);
        } else {
            return new Color(r, g, b);
        }
    }

    /**
     * Creates a random color that has no transparency.
     * 
     * @return A random color.
     */
    public static Color randomColor() {
        return randomColor(false);
    }

    /**
     * Generates a random angle between 0 and 2*Pi
     * 
     * @return A random angle between 0 and 2*Pi
     */
    public static float randomAngle() {
        return randomRange(0, TwoPi);
    }

    /**
     * Converts an angle to a Vector2
     * 
     * @param angle
     *            the angle to be converted.
     * @return A Vector2 representing the angle.
     */
    public static Vector2 convertAngleToVector2(float angle) {
        return new Vector2((float) Math.sin(angle), (float) Math.cos(angle));
    }

    /**
     * Generates a random angle, then converts it to a Vector2
     * 
     * @return A vector2 representing the random angle
     */
    public static Vector2 randomAngleAsVector2() {
        return convertAngleToVector2(randomAngle());
    }

    /**
     * LERPs between two values.
     * 
     * @param value1
     *            The first value.
     * @param value2
     *            The second value.
     * @param amount
     *            The amount to LERP (0f to 1f)
     * @return The value after performing LERP
     */
    public static float lerp(float value1, float value2, float amount) {
        return value1 + (value2 - value1) * amount;
    }

    /**
     * LERPs between two colors.
     * 
     * @param color1
     *            The first color.
     * @param color2
     *            The second color.
     * @param amount
     *            The amount to LERP (0f to 1f)
     * @return The color after performing LERP
     */
    public static Color colorLerp(Color color1, Color color2, float amount) {
        byte r = (byte) lerp(color1.getRed(), color2.getRed(), amount);
        byte g = (byte) lerp(color1.getGreen(), color2.getGreen(), amount);
        byte b = (byte) lerp(color1.getBlue(), color2.getBlue(), amount);
        byte a = (byte) lerp(color1.getAlpha(), color2.getAlpha(), amount);

        return new Color(r, g, b, a);
    }
}
