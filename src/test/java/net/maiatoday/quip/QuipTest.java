package net.maiatoday.quip;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for Quip
 * Created by maia on 2016/07/30.
 */
public class QuipTest {
    Quip test;
    @Before
    public void init() {
        test = new Quip(new String[]{"one", "two", "three"}, false);
    }

    @Test
    public void blurtSequence() throws Exception {
        test.setRandom(false);
        assertFalse(test.isRandom());
        assertTrue("one".equalsIgnoreCase(test.blurt()));
        assertTrue("two".equalsIgnoreCase(test.blurt()));
        assertTrue("three".equalsIgnoreCase(test.blurt()));
        // now check that it loops
        assertTrue("one".equalsIgnoreCase(test.blurt()));
        assertTrue("two".equalsIgnoreCase(test.blurt()));
        assertTrue("three".equalsIgnoreCase(test.blurt()));
    }

    @Test
    public void blurtRandom() throws Exception {
        test.setRandom(true);
        assertTrue(test.isRandom());
        StringBuilder res = new StringBuilder();
        res.append(test.blurt());
        res.append(test.blurt());
        res.append(test.blurt());
        res.append(test.blurt());
        res.append(test.blurt());
        res.append(test.blurt());
        assertFalse("onetwothreeonetwothree".equalsIgnoreCase(res.toString()));
    }

    @Test
    public void defaultFalse() throws Exception {
        Quip q = new Quip(new String[]{"one"});
        assertTrue(q.isRandom());
        q.setRandom(false);
        assertFalse(q.isRandom());
    }

}