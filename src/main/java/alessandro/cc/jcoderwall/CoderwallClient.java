/**
 * Copyright (c) 2012 Alessandro Leite, http://alessandro.cc <alessandro.leite@alessandro.cc>
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation the 
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is furnished 
 * to do so, subject to the following conditions:
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
package alessandro.cc.jcoderwall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.joda.time.DateTime;

import alessandro.cc.jcoderwall.gson.BadgeDeserializer;
import alessandro.cc.jcoderwall.gson.BadgesDeserializer;
import alessandro.cc.jcoderwall.gson.DateTimeDeserializer;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CoderwallClient {

	private static final String CODEWALL_URL = "http://coderwall.com/%s.json";

	/**
	 * The coderwall username.
	 */
	private final String username;

	/**
	 * The informations of the coderwall username.
	 * 
	 * @see Coder
	 */
	private final Coder coder;

	public CoderwallClient(String username) throws IOException {
		this.username = Preconditions.checkNotNull(username);

		Gson gson = new GsonBuilder()
				.registerTypeAdapter(Badges.class, new BadgesDeserializer())
				.registerTypeAdapter(Badge.class, new BadgeDeserializer())
				.registerTypeAdapter(DateTime.class, new DateTimeDeserializer())
				.create();

		this.coder = gson.fromJson(request(), Coder.class);
	}

	public Coder get() {
		return this.coder;
	}

	private String request() throws IOException {
		return asText(new URL(String.format(CODEWALL_URL, this.username))
				.openStream());
	}

	private String asText(InputStream is) throws IOException {
		BufferedReader reader = null;

		try {
			StringBuilder text = new StringBuilder();
			reader = new BufferedReader(new InputStreamReader(is));
			int i;
			while ((i = reader.read()) != -1) {
				text.append((char) i);
			}
			return text.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}
}