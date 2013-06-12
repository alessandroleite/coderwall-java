/**
 * Copyright (c) 2012 Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package jcoderwall.test;

import java.io.IOException;

import jcoderwall.Coder;
import jcoderwall.CoderwallClient;
import jcoderwall.UserNotFoundException;
import junit.framework.Assert;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class CoderwallClientTest
{

    /**
     * Tests with the user: alessandroleite has at least one badge.
     */
    @Test
    public void must_have_one_badge()
    {
        try
        {
            Coder coder = new CoderwallClient("alessandroleite").get();
            assertNotNull(coder);
            assertTrue(coder.getBadges().size() >= 1);
        }
        catch (IOException exception)
        {
            Assert.fail(exception.getMessage());
        }
    }

    /**
     * Tests if an {@link UserNotFoundException} is thrown if the user does not exists.
     * @throws IOException If an I/O error occurs.
     */
    @Test(expected = UserNotFoundException.class)
    public void must_throws_user_exception() throws IOException
    {
        new CoderwallClient("alessandrodotleite").get();
    }
}
