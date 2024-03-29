package org.nolat.tools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.awt.Color;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ToolkitTest {

    private static final Logger LOG = Logger.getLogger(ToolkitTest.class);
    private static final double EPSILON = .00005d;

    @Test
    public void testRandomRangeFloat() {
        for (int i = 0; i < 1000; i++) {
            float random = Toolkit.randomRange(0f, 5f);
            if (random < 0f || random > 5f) {
                LOG.error(random + " was outside the range of [0-5]");
                fail("A random value was out of the range.");
            }
        }
    }

    @Test
    public void testRandomRangeInt() {
        for (int i = 0; i < 1000; i++) {
            int random = Toolkit.randomRange(0, 5);
            if (random < 0f || random > 5f) {
                LOG.error(random + " was outside the range of [0-5]");
                fail("A random value was out of the range.");
            }
        }
    }

    @Test
    public void testRandomEdgeCases() {
        boolean[] hits = new boolean[10]; // 0 1 2 3 4 5 6 7 8 9
        for (int i = 0; i < 10000; i++) {
            int choice = Toolkit.randomRange(0, 9);
            hits[choice] = true;
        }
        for (int i = 0; i < hits.length; i++) {
            if (!hits[i]) {
                fail("This shouldn't fail, although it is statistically possible. If it shows up frequently, randomRange is broken");
            }
        }
    }

    @Test
    public void testAngleUnits() {
        for (int i = -360; i <= 360; i++) {
            float radian = Toolkit.toRadians(i);
            float degrees = Toolkit.toDegrees(radian);
            if (i % 20 == 0) {
                LOG.info("i: " + i + "; radians: " + radian + "; degrees: " + degrees);
            }
            assertEquals(i, degrees, EPSILON);
        }
    }

    @Test
    public void testAngleConversion() {

        Vector2 expectedVector = new Vector2(0f, 1f);
        float angle = Toolkit.toRadians(0f);
        LOG.info("Testing angle 0 (up)");
        LOG.info("expectedVector: " + expectedVector);
        Vector2 actualVector = Toolkit.angleToVector2(angle);
        LOG.info("actualVector: " + actualVector);
        assertEquals(expectedVector, actualVector);

        expectedVector = new Vector2(1f, 0f);
        angle = Toolkit.toRadians(90f);
        LOG.info("Testing angle 90 (right)");
        LOG.info("expectedVector: " + expectedVector);
        actualVector = Toolkit.angleToVector2(angle);
        LOG.info("actualVector: " + actualVector);
        assertEquals(expectedVector, actualVector);

        expectedVector = new Vector2(0f, -1f);
        angle = Toolkit.toRadians(180f);
        LOG.info("Testing angle 180 (down)");
        LOG.info("expectedVector: " + expectedVector);
        actualVector = Toolkit.angleToVector2(angle);
        LOG.info("actualVector: " + actualVector);
        assertEquals(expectedVector, actualVector);

        expectedVector = new Vector2(-1f, 0f);
        angle = Toolkit.toRadians(270f);
        LOG.info("Testing angle 270 (left)");
        LOG.info("expectedVector: " + expectedVector);
        actualVector = Toolkit.angleToVector2(angle);
        LOG.info("actualVector: " + actualVector);
        assertEquals(expectedVector, actualVector);
    }

    @Test
    public void testLerping() {
        float min = -100f;
        float max = 100f;

        float[] amounts = { 0f, 0.1f, 0.5f, .9f, 1f };
        float[] expectedResults = { -100f, -80f, 0f, 80f, 100f };
        for (int i = 0; i < amounts.length; i++) {
            LOG.info("LERPing " + amounts[i] + " should get " + expectedResults[i]);
            assertEquals(expectedResults[i], Toolkit.lerp(min, max, amounts[i]), EPSILON);
        }
    }

    @Test
    public void testColorLerping() {
        Color color1 = new Color(255, 0, 0);
        Color color2 = new Color(0, 255, 0);
        float amount = .5f;
        Color expected = new Color(128, 128, 0);
        Color actual = Toolkit.colorLerp(color1, color2, amount);
        assertEquals(expected, actual);
    }

    @Test
    public void testRandomColors() {
        for (int i = 0; i < 10000; i++) {
            Toolkit.randomColor(i % 2 == 0);
        }
    }
}
