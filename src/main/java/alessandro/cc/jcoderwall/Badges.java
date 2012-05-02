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
package alessandro.cc.jcoderwall;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.google.common.base.Preconditions;

public class Badges implements Iterable<Badge>, Serializable {

	/**
	 * Serial code version <code>serialVersionUID</code> 
	 */
	private static final long serialVersionUID = 5444933409976871942L;
	
	private final List<Badge> badges = new LinkedList<Badge>();

	@Override
	public Iterator<Badge> iterator() {
		return badges.iterator();
	}

	public boolean add(Badge badge) {
		return this.badges.add(Preconditions.checkNotNull(badge));
	}

	public boolean remove(Badge badge) {
		return this.badges.remove(badge);
	}

	public int size() {
		return this.badges.size();
	}

	public List<Badge> badges() {
		return Collections.unmodifiableList(this.badges);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}