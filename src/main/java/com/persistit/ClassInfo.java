/**
 * Copyright © 2005-2012 Akiban Technologies, Inc.  All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, version 3 (only) of the
 * License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * This program may also be available under different license terms. For more
 * information, see www.akiban.com or contact licensing@akiban.com.
 */

package com.persistit;

import java.io.ObjectStreamClass;

/**
 * A simple structure that holds a tuple consisting of a class, its serial
 * version UID and its Persistit handle.
 * 
 */

class ClassInfo {
    private Class<?> _class;
    private long _suid;
    private int _handle;
    private ObjectStreamClass _osc;

    ClassInfo(Class<?> cl, long suid, int handle, ObjectStreamClass osc) {
        _class = cl;
        _suid = suid;
        _handle = handle;
        _osc = osc;
    }

    public boolean equals(final Object object) {
        if (object instanceof ClassInfo) {
            ClassInfo ci = (ClassInfo) object;
            if (equals(_class, ci._class) && _handle == ci._handle && _suid == ci._suid) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return _class.hashCode() ^ _handle ^ (int) _suid;
    }

    /**
     * @return The <code>Class</code>
     */
    public Class<?> getDescribedClass() {
        return _class;
    }

    /**
     * @return The <code>Class</code>'s name
     */
    public String getName() {
        return _class.getName();
    }

    /**
     * @return The serial version UID of the <code>Class</code>
     */
    public long getSUID() {
        return _suid;
    }

    /**
     * @return The handle used to identify the <code>Class</code> in values
     *         stored by Persistit.
     */
    public int getHandle() {
        return _handle;
    }

    /**
     * @return The ObjectStreamClass for the described class, or
     *         <code>null</code> if there is none.
     */
    public ObjectStreamClass getClassDescriptor() {
        return _osc;
    }
    
    private boolean equals(Class<?> a, Class<?> b) {
        return a == null ? b == null : a.equals(b);
    }
}
