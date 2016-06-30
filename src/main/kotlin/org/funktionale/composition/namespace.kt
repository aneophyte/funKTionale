/*
 * Copyright 2013 Mario Arias
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.funktionale.composition

infix fun<P1, IP, R> Function1<P1, IP>.andThen(f: (IP) -> R): (P1) -> R = forwardCompose(f)

infix fun<P1, IP, R> Function1<P1, IP>.forwardCompose(f: (IP) -> R): (P1) -> R {
    return { p1: P1 -> f(this(p1)) }
}

infix fun<IP, R, P1> Function1<IP, R>.compose(f: (P1) -> IP): (P1) -> R {
    return { p1: P1 -> this(f(p1)) }
}

fun <P1, IP, R> andThen(f: (P1) -> IP, g: (IP) -> R) : (P1) -> R {
    return forwardCompose(f, g)
}

fun <P1, IP1, IP2, R> andThen(f: (P1) -> IP1, a: (IP1) -> IP2, g: (IP2) -> R) : (P1) -> R {
    return forwardCompose(f, a, g)
}

fun <P1, IP1, IP2, IP3, R> andThen(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, g: (IP3) -> R) : (P1) -> R {
    return forwardCompose(f, a, b, g)
}

fun <P1, IP1, IP2, IP3, IP4, R> andThen(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, g: (IP4) -> R) : (P1) -> R {
    return forwardCompose(f, a, b, c, g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, R> andThen(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, g: (IP5) -> R) : (P1) -> R {
    return forwardCompose(f, a, b, c, d, g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, IP6, R> andThen(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, e: (IP5) -> IP6, g: (IP6) -> R) : (P1) -> R {
    return forwardCompose(f, a, b, c, d, e, g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, IP6, IP7, R> andThen(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, e: (IP5) -> IP6, h: (IP6) -> IP7, g: (IP7) -> R) : (P1) -> R {
    return forwardCompose(f, a, b, c, d, e, h, g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, IP6, IP7, IP8, R> andThen(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, e: (IP5) -> IP6, h: (IP6) -> IP7, i: (IP7) -> IP8, g: (IP8) -> R) : (P1) -> R {
    return forwardCompose(f, a, b, c, d, e, h, i, g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, IP6, IP7, IP8, IP9, R> andThen(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, e: (IP5) -> IP6, h: (IP6) -> IP7, i: (IP7) -> IP8, j: (IP8) -> IP9, g: (IP9) -> R) : (P1) -> R {
    return forwardCompose(f, a, b, c, d, e, h, i, j, g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, IP6, IP7, IP8, IP9, IP10, R> andThen(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, e: (IP5) -> IP6, h: (IP6) -> IP7, i: (IP7) -> IP8, j: (IP8) -> IP9, k: (IP9) -> IP10, g: (IP10) -> R) : (P1) -> R {
    return forwardCompose(f, a, b, c, d, e, h, i, j, k, g)
}

fun <P1, IP, R> forwardCompose(f: (P1) -> IP, g: (IP) -> R) : (P1) -> R {
    return { p1: P1 -> g(f(p1)) }
}

fun <P1, IP1, IP2, R> forwardCompose(f: (P1) -> IP1, a: (IP1) -> IP2, g: (IP2) -> R) : (P1) -> R {
    return forwardCompose(forwardCompose(f, a), g)
}

fun <P1, IP1, IP2, IP3, R> forwardCompose(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, g: (IP3) -> R) : (P1) -> R {
    return forwardCompose(forwardCompose(f, a, b), g)
}

fun <P1, IP1, IP2, IP3, IP4, R> forwardCompose(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, g: (IP4) -> R) : (P1) -> R {
    return forwardCompose(forwardCompose(f, a, b, c), g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, R> forwardCompose(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, g: (IP5) -> R) : (P1) -> R {
    return forwardCompose(forwardCompose(f, a, b, c, d), g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, IP6, R> forwardCompose(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, e: (IP5) -> IP6, g: (IP6) -> R) : (P1) -> R {
    return forwardCompose(forwardCompose(f, a, b, c, d, e), g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, IP6, IP7, R> forwardCompose(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, e: (IP5) -> IP6, h: (IP6) -> IP7, g: (IP7) -> R) : (P1) -> R {
    return forwardCompose(forwardCompose(f, a, b, c, d, e, h), g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, IP6, IP7, IP8, R> forwardCompose(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, e: (IP5) -> IP6, h: (IP6) -> IP7, i: (IP7) -> IP8, g: (IP8) -> R) : (P1) -> R {
    return forwardCompose(forwardCompose(f, a, b, c, d, e, h, i), g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, IP6, IP7, IP8, IP9, R> forwardCompose(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, e: (IP5) -> IP6, h: (IP6) -> IP7, i: (IP7) -> IP8, j: (IP8) -> IP9, g: (IP9) -> R) : (P1) -> R {
    return forwardCompose(forwardCompose(f, a, b, c, d, e, h, i, j), g)
}

fun <P1, IP1, IP2, IP3, IP4, IP5, IP6, IP7, IP8, IP9, IP10, R> forwardCompose(f: (P1) -> IP1, a: (IP1) -> IP2, b: (IP2) -> IP3, c: (IP3) -> IP4, d: (IP4) -> IP5, e: (IP5) -> IP6, h: (IP6) -> IP7, i: (IP7) -> IP8, j: (IP8) -> IP9, k: (IP9) -> IP10, g: (IP10) -> R) : (P1) -> R {
    return forwardCompose(forwardCompose(f, a, b, c, d, e, h, i, j, k), g)
}

fun <IP, R, P1> compose(f: (IP) -> R, g: (P1) -> IP) : (P1) -> R {
    return { p1: P1 -> f(g(p1)) }
}

fun <IP1, IP2, R, P1> compose(f: (IP2) -> R, a: (IP1) -> IP2, g: (P1) -> IP1) : (P1) -> R {
    return compose(f, (compose(a, g)))
}

fun <IP1, IP2, IP3, R, P1> compose(f: (IP3) -> R, b: (IP2) -> IP3, a: (IP1) -> IP2, g: (P1) -> IP1) : (P1) -> R {
    return compose(f, (compose(b, a, g)))
}

fun <IP1, IP2, IP3, IP4, R, P1> compose(f: (IP4) -> R, c: (IP3) -> IP4, b: (IP2) -> IP3, a: (IP1) -> IP2, g: (P1) -> IP1) : (P1) -> R {
    return compose(f, (compose(c, b, a, g)))
}

fun <IP1, IP2, IP3, IP4, IP5, R, P1> compose(f: (IP5) -> R, d: (IP4) -> IP5, c: (IP3) -> IP4, b: (IP2) -> IP3, a: (IP1) -> IP2, g: (P1) -> IP1) : (P1) -> R {
    return compose(f, (compose(d, c, b, a, g)))
}

fun <IP1, IP2, IP3, IP4, IP5, IP6, R, P1> compose(f: (IP6) -> R, e: (IP5) -> IP6, d: (IP4) -> IP5, c: (IP3) -> IP4, b: (IP2) -> IP3, a: (IP1) -> IP2, g: (P1) -> IP1) : (P1) -> R {
    return compose(f, (compose(e, d, c, b, a, g)))
}

fun <IP1, IP2, IP3, IP4, IP5, IP6, IP7, R, P1> compose(f: (IP7) -> R, h: (IP6) -> IP7, e: (IP5) -> IP6, d: (IP4) -> IP5, c: (IP3) -> IP4, b: (IP2) -> IP3, a: (IP1) -> IP2, g: (P1) -> IP1) : (P1) -> R {
    return compose(f, (compose(h, e, d, c, b, a, g)))
}

fun <IP1, IP2, IP3, IP4, IP5, IP6, IP7, IP8, R, P1> compose(f: (IP8) -> R, i: (IP7) -> IP8, h: (IP6) -> IP7, e: (IP5) -> IP6, d: (IP4) -> IP5, c: (IP3) -> IP4, b: (IP2) -> IP3, a: (IP1) -> IP2, g: (P1) -> IP1) : (P1) -> R {
    return compose(f, (compose(i, h, e, d, c, b, a, g)))
}

fun <IP1, IP2, IP3, IP4, IP5, IP6, IP7, IP8, IP9, R, P1> compose(f: (IP9) -> R, j: (IP8) -> IP9, i: (IP7) -> IP8, h: (IP6) -> IP7, e: (IP5) -> IP6, d: (IP4) -> IP5, c: (IP3) -> IP4, b: (IP2) -> IP3, a: (IP1) -> IP2, g: (P1) -> IP1) : (P1) -> R {
    return compose(f, (compose(j, i, h, e, d, c, b, a, g)))
}

fun <IP1, IP2, IP3, IP4, IP5, IP6, IP7, IP8, IP9, IP10, R, P1> compose(f: (IP10) -> R, k: (IP9) -> IP10, j: (IP8) -> IP9, i: (IP7) -> IP8, h: (IP6) -> IP7, e: (IP5) -> IP6, d: (IP4) -> IP5, c: (IP3) -> IP4, b: (IP2) -> IP3, a: (IP1) -> IP2, g: (P1) -> IP1) : (P1) -> R {
    return compose(f, (compose(k, j, i, h, e, d, c, b, a, g)))
}
