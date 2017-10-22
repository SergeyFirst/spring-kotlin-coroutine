/*
 * Copyright 2002-2017 the original author or authors.
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

package org.springframework.web.server

import org.springframework.kotlin.experimental.coroutine.web.awaitFirstOrNull

interface CoroutineWebFilterChain {
    suspend fun filter(exchange: CoroutineServerWebExchange): Unit

    companion object {
        operator fun invoke(chain: WebFilterChain): CoroutineWebFilterChain = DefaultCoroutineWebFilterChain(chain)
    }
}

class DefaultCoroutineWebFilterChain(val chain: WebFilterChain): CoroutineWebFilterChain {
    suspend override fun filter(exchange: CoroutineServerWebExchange) {
        chain.filter(exchange.extractServerWebExchange()).awaitFirstOrNull()
    }
}