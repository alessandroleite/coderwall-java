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
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Preconditions;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Badges implements Iterable<Badge>, Serializable
{
    /**
     * Serial code version <code>serialVersionUID</code> for serialization.
     */
    private static final long serialVersionUID = 5444933409976871942L;

    /**
     * {@link List} with the badges of an user.
     */
    private final List<Badge> badges = new LinkedList<Badge>();

    @Override
    public Iterator<Badge> iterator()
    {
        return badges.iterator();
    }

    /**
     * Appends a {@link Badge} to the end of this {@link List}.
     * 
     * @param badge
     *            The {@link Badge} to add. Might not be <code>null</code>.
     * @return <code>true</code> if the elements was added.
     */
    public boolean add(Badge badge)
    {
        return this.badges.add(Preconditions.checkNotNull(badge));
    }

    /**
     * Removes a {@link Badge} of this {@link List}.
     * 
     * @param badge
     *            The {@link Badge} to be removed.
     * @return <code>true</code> if this list contained the given {@link Badge}.
     */
    public boolean remove(Badge badge)
    {
        return this.badges.remove(badge);
    }

    /**
     * Returns the number of elements in this {@link List}.
     * 
     * @return the size of this {@link List}.
     */
    public int size()
    {
        return this.badges.size();
    }

    /**
     * Returns a read-only {@link List} with the badges of this {@link List}.
     * 
     * @return a read-only {@link List} with the badges of this {@link List}.
     */
    public List<Badge> badges()
    {
        return Collections.unmodifiableList(this.badges);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
