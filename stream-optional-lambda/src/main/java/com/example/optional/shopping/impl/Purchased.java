/*
 * Copyright 2019 Shinya Mochida
 *
 * Licensed under the Apache License,Version2.0(the"License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,software
 * Distributed under the License is distributed on an"AS IS"BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.optional.shopping.impl;

import com.example.optional.shopping.Payment;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

public class Purchased implements Payment {

    @NotNull
    private final BigDecimal total;
    @NotNull
    private final Instant date;

    @Contract(pure = true)
    public Purchased(@NotNull BigDecimal total, @NotNull Instant date) {
        this.total = total;
        this.date = date;
    }

    @NotNull
    @Override
    public BigDecimal total() {
        return total;
    }

    @NotNull
    @Override
    public Instant purchased() {
        return date;
    }

    @NotNull
    @Override
    public Optional<Instant> date() {
        return Optional.empty();
    }
}
