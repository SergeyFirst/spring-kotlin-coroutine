/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.kotlin.experimental.coroutine.util;

import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DefaultSuspendExecutor implements SuspendExecutor {
    static public final SuspendExecutor INSTANCE = new DefaultSuspendExecutor();

    @Nullable
    @Override
    public <T> Object execute(@NotNull Continuation<? super T> cont, @NotNull Function1<? super Continuation<? super T>, ?> lambda) {
        return lambda.invoke(cont);
    }
}
