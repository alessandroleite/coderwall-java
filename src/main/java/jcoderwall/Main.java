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

import java.io.IOException;

public final class Main
{

    /**
     * Constructor.
     */
    private Main()
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @param args The arguments for this program.
     * @see #usage()
     */
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            usage();
        }
        else
        {
            try
            {
                show(new CoderwallClient(args[0]).get());
            }
            catch (IOException exception)
            {
                System.err.println(exception.getMessage());
            }
        }
    }

    /**
     * Prints the informations about the code on console.
     * 
     * @param coder
     *            The reference to {@link Coder}.
     */
    private static void show(Coder coder)
    {
        System.out.printf("User: %s Location: %s \n", coder.getUsername(), coder.getLocation());
        System.out.println("Achievements:");
        for (Badge badge : coder.getBadges())
        {
            System.out.printf("- %s: %s\n", badge.getName(), badge.getDescription());
        }
    }

    /**
     * Shows the usage message.
     */
    private static void usage()
    {
        System.out.println("jcoderwall.Main <username> \n or java -jar coderwall-j <username>");
    }
}
