/**
 * Copyright (c) 2012 Alessandro Leite, http://alessandro.cc <alessandro.leite@alessandro.cc>
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
package alessandro.cc.jcoderwall.client.test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import alessandro.cc.jcoderwall.Coder;
import alessandro.cc.jcoderwall.CoderwallClient;

public class CoderwallClientTest {

	@Test
	public void must_have_one_badge() {
		try {
			Coder coder = new CoderwallClient("alessandroleite").get();
			assertNotNull(coder);
			assertTrue(coder.getBadges().size() >= 1);
		} catch (IOException exception) {
			Assert.fail(exception.getMessage());
		}
	}

	@Test(expected = IOException.class)
	public void must_throws_io_exception() throws IOException {
		new CoderwallClient("alessandrodotleite").get();
	}
}