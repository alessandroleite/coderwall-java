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

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Coder implements Serializable
{

    /**
     * Serial code version<code>serialVersionUID</code> for serialization.
     */
    private static final long serialVersionUID = -6431910894039769854L;

    /**
     * The developer's name.
     */
    private String username;

    /**
     * The developer's location.
     */
    private String location;

    /**
     * The developer's achievements.
     */
    private Badges badges = new Badges();

    /**
     * Constructor.
     */
    public Coder()
    {
        super();
    }

    /**
     * @param coderUsername
     *            The coder's name.
     * @param coderLocation
     *            The coder's location.
     * @param coderBadges
     *            the coder's badges.
     */
    public Coder(String coderUsername, String coderLocation, Badges coderBadges)
    {
        this.username = coderUsername;
        this.location = coderLocation;
        this.badges = coderBadges;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Coder))
        {
            return false;
        }
        Coder other = (Coder) obj;
        if (username == null)
        {
            if (other.username != null)
            {
                return false;
            }
        }
        else if (!username.equals(other.username))
        {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * @param newUsername
     *            the username to set
     */
    public void setUsername(String newUsername)
    {
        this.username = newUsername;
    }

    /**
     * @return the location
     */
    public String getLocation()
    {
        return location;
    }

    /**
     * @param newLocation
     *            the location to set
     */
    public void setLocation(String newLocation)
    {
        this.location = newLocation;
    }

    /**
     * @return the badges
     */
    public Badges getBadges()
    {
        return badges;
    }

    /**
     * @param newBadges
     *            the badges to set
     */
    public void setBadges(Badges newBadges)
    {
        this.badges = newBadges;
    }

}
