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

package org.funktionale.either

import org.funktionale.collections.prependTo
import org.funktionale.either.Either.Left
import org.funktionale.either.Either.Right

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 17/05/13
 * Time: 19:01
 */
@Suppress("BASE_WITH_NULLABLE_UPPER_BOUND")
sealed class Either<out L, out R> {

    fun left(): LeftProjection<L, R> = LeftProjection(this)
    fun right(): RightProjection<L, R> = RightProjection(this)

    operator abstract fun component1(): L?
    operator abstract fun component2(): R?

    abstract fun isLeft(): Boolean
    abstract fun isRight(): Boolean

    fun<X> fold(fl: (L) -> X, fr: (R) -> X): X {
        return when (this) {
            is Left<L, R> -> fl(this.l)
            is Right<L, R> -> fr(this.r)
        }
    }

    fun swap(): Either<R, L> {
        return when (this) {
            is Left<L, R> -> Right(this.l)
            is Right<L, R> -> Left(this.r)
        }
    }

    @Suppress("BASE_WITH_NULLABLE_UPPER_BOUND") class Left<out L, out R>(val l: L) : Either<L, R>() {
        override fun component1(): L? = l
        override fun component2(): R? = null
        override fun isLeft(): Boolean = true
        override fun isRight(): Boolean = false

        override fun equals(other: Any?): Boolean {
            return when (other) {
                is Left<*, *> -> l!!.equals(other.l)
                else -> false

            }
        }

        override fun hashCode(): Int {
            return 43 * l!!.hashCode()
        }

        override fun toString(): String {
            return "Left($l)"
        }
    }

    @Suppress("BASE_WITH_NULLABLE_UPPER_BOUND") class Right<out L, out R>(val r: R) : Either<L, R>() {
        override fun component1(): L? = null
        override fun component2(): R? = r
        override fun isLeft(): Boolean = false
        override fun isRight(): Boolean = true

        override fun equals(other: Any?): Boolean {
            return when (other) {
                is Right<*, *> -> r!!.equals(other.r)
                else -> false
            }
        }

        override fun hashCode(): Int {
            return 43 * r!!.hashCode()
        }

        override fun toString(): String {
            return "Right($r)"
        }
    }
}

fun<T> Either<T, T>.merge(): T {
    return when (this) {
        is Left<T, T> -> this.l
        is Right<T, T> -> this.r
        else -> throw UnsupportedOperationException()
    }
}

fun<L, R> Pair<L, R>.toLeft(): Left<L, R> {
    return Left(this.component1())
}

fun<L, R> Pair<L, R>.toRight(): Right<L, R> {
    return Right(this.component2())
}

@Deprecated("Use eitherTry", ReplaceWith("eitherTry(body)")) fun<T> either(body: () -> T): Either<Exception, T> {
    return eitherTry(body)
}

fun<T> eitherTry(body: () -> T): Either<Exception, T> {
    return try {
        Right(body())
    } catch(e: Exception) {
        Left(e)
    }
}

fun<T, L, R> List<T>.traverse(f: (T) -> Either<L, R>): Either<L, List<R>> {
    return foldRight(Right(emptyList())) { i: T, accumulator: Either<L, List<R>> ->
        val either = f(i)
        when (either) {
            is Right -> either.right().map(accumulator) { head: R, tail: List<R> ->
                head prependTo tail
            }
            is Left -> Left(either.l)
            else -> throw UnsupportedOperationException()
        }
    }
}

fun<L, R> List<Either<L, R>>.sequential(): Either<L, List<R>> {
    return traverse { it }
}

