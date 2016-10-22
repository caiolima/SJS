/* 
 * Copyright 2014-2016 Samsung Research America, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * FloatLiteral --- An awkwardly named representation of the SJS _double_ precision floating point
 * literal
 *
 * @author colin.gordon
 */
package com.samsung.sjs.backend.asts.ir;

public class FloatLiteral extends Expression {
    double v;
    public FloatLiteral(double x) {
        super(Tag.FloatLiteral);
        this.v = x;
    }
    public double getValue() { return v; }
    @Override
    public String toSource(int x) { return String.valueOf(v); }
    @Override
    public <R> R accept(IRVisitor<R> v) {
        return v.visitFloatLiteral(this);
    }

    @Override
    public boolean isPure() { return true; }
    @Override
    public boolean isConst() { return true; }
    @Override
    public boolean mustSaveIntermediates() { return false; }
}