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
package jcoderwall;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jcoderwall.gson.BadgeDeserializer;
import jcoderwall.gson.BadgesDeserializer;
import jcoderwall.gson.DateTimeDeserializer;

import org.joda.time.DateTime;

public class CoderwallClient
{

    /**
     * The CoderWall's API.
     */
    private static final String CODEWALL_URL = "https://coderwall.com/%s.json";

    /**
     * The coderwall username.
     */
    private final String username;

    /**
     * The informations about the coder.
     * 
     * @see Coder
     */
    private final Coder coder;

    /**
     * @param coderUsername
     *            The Coderwall's user name.
     * @throws IOException
     *             If an I/O error occurs.
     * @throws UserNotFoundException If the {@code username} was not found.
     */
    public CoderwallClient(String coderUsername) throws IOException
    {
        this.username = Preconditions.checkNotNull(coderUsername);

        Gson gson = new GsonBuilder().registerTypeAdapter(Badges.class, new BadgesDeserializer())
                .registerTypeAdapter(Badge.class, new BadgeDeserializer())
                .registerTypeAdapter(DateTime.class, new DateTimeDeserializer())
                .create();

        try
        {
            this.coder = gson.fromJson(request(), Coder.class);
        }
        catch (FileNotFoundException fne)
        {
            throw new UserNotFoundException(coderUsername);
        }
    }

    /**
     * Returns the reference for {@link Coder}.
     * 
     * @return the reference for {@link Coder}.
     */
    public Coder get()
    {
        return this.coder;
    }

    /**
     * Returns a {@link String} with the content return by the Coderwall's API.
     * 
     * @return A {@link String} with the content return by the Coderwall's API.
     * @throws IOException
     *             If an I/O error occurs.
     */
    private String request() throws IOException
    {
        return asText(new URL(String.format(CODEWALL_URL, this.username)).openStream());
    }

    /**
     * Returns a {@link String} with the contents of the {@link InputStream}.
     * 
     * @param is
     *            The {@link InputStream} to read its contents.
     * @return A {@link String} with the contents of the {@link InputStream}.
     * @throws IOException
     *             If an I/O error occurs.
     */
    private String asText(InputStream is) throws IOException
    {
        BufferedReader reader = null;
        try
        {
            StringBuilder text = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(is));

            for (int i = reader.read(); i != -1; i = reader.read())
            {
                text.append((char) i);
            }
            return text.toString();
        }
        finally
        {
            if (reader != null)
            {
                reader.close();
            }
        }
    }
}
