package org.nolat;

/**
 * A basic implementation of a Vector2 class. It is based off of the Vector2
 * class in the XNA library for C#.
 * 
 * @author Talon
 * 
 */
public class Vector2 {
    /**
     * A Vector2 with x and y set to 0f.
     */
    public static final Vector2 ZERO = new Vector2(0f, 0f);
    /**
     * A Vector2 with x set to 0f and y set to 1f.
     */
    public static final Vector2 UP = new Vector2(0f, 1f);
    /**
     * A Vector2 with x set to 0f and y set to -1f.
     */
    public static final Vector2 DOWN = new Vector2(0f, -1f);
    /**
     * A Vector2 with x set to -1f and y set to 0f.
     */
    public static final Vector2 LEFT = new Vector2(-1f, 0f);
    /**
     * A Vector2 with x set to 1f and y set to 0f.
     */
    public static final Vector2 RIGHT = new Vector2(1f, 0f);

    public float x = 0f;
    public float y = 0f;

    /**
     * Creates a Vector2. x and y are set to 0f by default.
     */
    public Vector2() {
    }

    /**
     * Creates a Vector2 with the specified x and y values.
     * 
     * @param x
     *            The x value
     * @param y
     *            The y value
     */
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a Vector2 where x and y are set to the x and y of the specified
     * Vector2.
     * 
     * @param vector
     */
    public Vector2(Vector2 vector) {
        x = vector.x;
        y = vector.y;
    }

    /**
     * Sets the current vector's x and y values to the x and y values of the
     * specified Vector2.
     * 
     * @param vector
     *            The Vector2 to copy the x and y values from
     */
    public void setTo(Vector2 vector) {
        x = vector.x;
        y = vector.y;
    }

    /**
     * Sets the current vector's x and y values to the specified values.
     * 
     * @param x
     *            The new x value for this vector.
     * @param y
     *            The new y value for this vector.
     */
    public void setTo(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns a string representation of the vector in the form: [x,y]
     */
    @Override
    public String toString() {
        return new String("[" + x + "," + y + "]");
    }

    /**
     * Calculates the length of this vector.
     * 
     * @return the length of this vector.
     */
    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    /**
     * Calculates the length of this vector squared. This is useful when you
     * only need to compare the lengths relatively and do not need to know the
     * exact value. As this operation does not have to perform a costly square
     * root operation, it is faster than calculating the exact length.
     * 
     * @return The length of this vector, squared.
     */
    public float lengthSquared() {
        return x * x + y * y;
    }

    /**
     * Calculates a normalized version of this vector. If the length is equal to
     * 0, it will return the zero vector.
     * 
     * @return
     */
    public Vector2 normalize() {
        float length = length();

        if (length != 0f) {
            x /= length;
            y /= length;
        } else {
            x = 0f;
            y = 0f;
        }

        return new Vector2(this);
    }

    /**
     * Adds another vector to this vector.
     * 
     * @param vector
     *            The vector to be added to this vector.
     * @return This vector plus the specified vector.
     */
    public Vector2 add(Vector2 vector) {
        x += vector.x;
        y += vector.y;

        return new Vector2(this);
    }

    /**
     * Adds values to this vector.
     * 
     * @param x
     *            The x value to be added.
     * @param y
     *            The y value to be added.
     * @return This vector, plus the specified x and y values.
     */
    public Vector2 add(float x, float y) {
        this.x += x;
        this.y += y;

        return new Vector2(this);
    }

    /**
     * Subtracts another vector from this vector.
     * 
     * @param vector
     *            The vector to be subtracted from this vector.
     * @return This vector minus the specified vector.
     */
    public Vector2 subtract(Vector2 vector) {
        x -= vector.x;
        y -= vector.y;

        return new Vector2(this);
    }

    /**
     * Subtracts values to this vector.
     * 
     * @param x
     *            The x value to be subtracted.
     * @param y
     *            The y value to be subtracted.
     * @return This vector, minus the specified x and y values.
     */
    public Vector2 subtract(float x, float y) {
        this.x -= x;
        this.y -= y;

        return new Vector2(this);
    }

    /**
     * Multiplies another vector and this vector.
     * 
     * @param vector
     *            The vector to be multiplied with this vector.
     * @return This vector times the specified vector.
     */
    public Vector2 multiply(Vector2 vector) {
        x *= vector.x;
        y *= vector.y;

        return new Vector2(this);
    }

    /**
     * Multiplies values to this vector.
     * 
     * @param x
     *            The x value to be multiplied.
     * @param y
     *            The y value to be multiplied.
     * @return This vector, times the specified x and y values.
     */
    public Vector2 multiply(float x, float y) {
        this.x *= x;
        this.y *= y;

        return new Vector2(this);
    }

    /**
     * Multiplies this vector by a scalar value.
     * 
     * @param scalar
     *            The scalar
     * @return This vector after multiplying both values by the scalar.
     */
    public Vector2 multiply(float scalar) {
        x *= scalar;
        y *= scalar;

        return new Vector2(this);
    }
}
