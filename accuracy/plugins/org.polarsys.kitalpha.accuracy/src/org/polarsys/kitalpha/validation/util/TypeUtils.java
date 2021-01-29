/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.validation.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Utility class for types.
 * 
 * @author Guillaume Gebhart
 */
public class TypeUtils {
	
	public TypeUtils() {
		// Prevent instantiation
	}

	public static <T> Iterable<T> cast(Iterable<?> iterable, Class<T> type) {
		return new CastedIterable<T>(iterable, type);
	}

	private static class CastedIterable<T> implements Iterable<T> {

		private Iterable<?> delegate;
		private Class<T> type;

		public CastedIterable(Iterable<?> delegate, Class<T> type) {
			this.delegate = delegate;
			this.type = type;
		}

		@Override
		public Iterator<T> iterator() {
			return new CastedIterator<T>(delegate.iterator(), type);
		}

	}

	private static class CastedIterator<T> implements Iterator<T> {

		private Iterator<?> delegate;
		private boolean goNext = true;
		private T current = null;
		private Class<T> type;

		public CastedIterator(Iterator<?> delegate, Class<T> type) {
			this.delegate = delegate;
			this.type = type;
		}

		@Override
		public boolean hasNext() {
			if (goNext) {
				current = internalNext();
				goNext = false;
			}
			return current != null;
		}

		@Override
		public T next() {
			if (hasNext()) {
				goNext = true;
				return current;
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			delegate.remove();
		}

		private T internalNext() {
			T next = null;
			while (delegate.hasNext() && next == null) {
				Object o = delegate.next();
				if (type.isInstance(o)) {
					next = type.cast(o);
				}
			}
			return next;
		}

	}

}
