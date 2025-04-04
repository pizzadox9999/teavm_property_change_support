/*
 *  Copyright 2023 Alexey Andreev.
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
package org.teavm.gradle.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import org.gradle.api.Action;

public interface TeaVMTests {
    TeaVMJSTests getJs();

    void js(Action<TeaVMJSTests> config);

    void js(@DelegatesTo(TeaVMJSTests.class) Closure<?> config);

    TeaVMWasmTests getWasm();

    void wasm(Action<TeaVMWasmTests> config);

    void wasm(@DelegatesTo(TeaVMWasmTests.class) Closure<?> config);

    TeaVMWasmTests getWasmGC();

    void wasmGC(Action<TeaVMWasmTests> config);

    void wasmGC(@DelegatesTo(TeaVMWasmTests.class) Closure<?> config);
}
