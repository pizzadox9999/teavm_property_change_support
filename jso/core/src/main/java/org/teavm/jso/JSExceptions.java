/*
 *  Copyright 2018 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.jso;

import org.teavm.interop.Import;

public final class JSExceptions {
    private JSExceptions() {
    }

    @Import(name = "getJavaException", module = "teavmJso")
    public static native Throwable getJavaException(JSObject e);

    @Import(name = "getJSException", module = "teavmJso")
    public static native JSObject getJSException(Throwable e);
}
