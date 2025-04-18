/*
 *  Copyright 2016 Alexey Andreev.
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
package org.teavm.backend.wasm.model.expression;

import java.util.Objects;
import org.teavm.backend.wasm.model.WasmNumType;

public class WasmConversion extends WasmExpression {
    private WasmNumType sourceType;
    private WasmNumType targetType;
    private boolean signed;
    private WasmExpression operand;
    private boolean reinterpret;
    private boolean nonTrapping;

    public WasmConversion(WasmNumType sourceType, WasmNumType targetType, boolean signed, WasmExpression operand) {
        Objects.requireNonNull(sourceType);
        Objects.requireNonNull(targetType);
        Objects.requireNonNull(operand);
        this.sourceType = sourceType;
        this.targetType = targetType;
        this.signed = signed;
        this.operand = operand;
    }

    public WasmNumType getSourceType() {
        return sourceType;
    }

    public void setSourceType(WasmNumType sourceType) {
        Objects.requireNonNull(sourceType);
        this.sourceType = sourceType;
    }

    public WasmNumType getTargetType() {
        return targetType;
    }

    public void setTargetType(WasmNumType targetType) {
        Objects.requireNonNull(targetType);
        this.targetType = targetType;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public boolean isReinterpret() {
        return reinterpret;
    }

    public void setReinterpret(boolean reinterpret) {
        this.reinterpret = reinterpret;
    }

    public WasmExpression getOperand() {
        return operand;
    }

    public void setOperand(WasmExpression operand) {
        Objects.requireNonNull(operand);
        this.operand = operand;
    }

    public boolean isNonTrapping() {
        return nonTrapping;
    }

    public void setNonTrapping(boolean nonTrapping) {
        this.nonTrapping = nonTrapping;
    }

    @Override
    public void acceptVisitor(WasmExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
