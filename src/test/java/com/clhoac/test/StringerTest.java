package com.clhoac.test;

import com.clhoac.java.Stringer;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringerTest {

    public String getExampleText() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Line1");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Line2");
        return stringBuilder.toString();
    }

    @Test
    public void testInsertString() {
        String result = Stringer.insertText(getExampleText(), "@", "L", "i");
        StringBuilder expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append("L@ine1");
        expectedStringBuilder.append(System.lineSeparator());
        expectedStringBuilder.append("L@ine2");
        assertEquals(expectedStringBuilder.toString(), result);
    }

    @Test
    public void testAppendLineStart() {
        String result = Stringer.appendLineStart(getExampleText(), "@");
        StringBuilder expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append("@Line1");
        expectedStringBuilder.append(System.lineSeparator());
        expectedStringBuilder.append("@Line2");
        assertEquals(expectedStringBuilder.toString(), result);
    }

    @Test
    public void testAppendLineEnd() {
        String result = Stringer.appendLineEnd(getExampleText(), "@");
        StringBuilder expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append("Line1@");
        expectedStringBuilder.append(System.lineSeparator());
        expectedStringBuilder.append("Line2@");
        assertEquals(expectedStringBuilder.toString(), result);
    }

    @Test
    public void testRemoveBetween() {
        String result = Stringer.removeBetween(getExampleText(), "n", "L", "e");
        StringBuilder expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append("Lie1");
        expectedStringBuilder.append(System.lineSeparator());
        expectedStringBuilder.append("Lie2");
        assertEquals(expectedStringBuilder.toString(), result);

        result = Stringer.removeBetween(getExampleText(), "n", "i", "e");
        expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append("Lie1");
        expectedStringBuilder.append(System.lineSeparator());
        expectedStringBuilder.append("Lie2");
        assertEquals(expectedStringBuilder.toString(), result);
    }

    @Test
    public void testRemoveStart() {
        String result = Stringer.removeLineStart(getExampleText(), "L");
        StringBuilder expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append("ine1");
        expectedStringBuilder.append(System.lineSeparator());
        expectedStringBuilder.append("ine2");
        assertEquals(expectedStringBuilder.toString(), result);
    }

    @Test
    public void testRemoveEnd() {
        String result = Stringer.removeLineEnd(getExampleText(), "1");
        StringBuilder expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append("Line");
        expectedStringBuilder.append(System.lineSeparator());
        expectedStringBuilder.append("Line2");
        assertEquals(expectedStringBuilder.toString(), result);

        result = Stringer.removeLineEnd(getExampleText(), "2");
        expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append("Line1");
        expectedStringBuilder.append(System.lineSeparator());
        expectedStringBuilder.append("Line");
        assertEquals(expectedStringBuilder.toString(), result);
    }
}
