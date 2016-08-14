/*
 * MIT License
 *
 * Copyright (c) [2016] [Maia Grotepass]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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