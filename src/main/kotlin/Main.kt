import java.math.BigInteger
import kotlinx.coroutines.*

fun fibonacci(n: Int): BigInteger {
    if (n <= 1) {
        return BigInteger.valueOf(n.toLong())
    }

    var fibMinusTwo = BigInteger.ZERO
    var fibMinusOne = BigInteger.ONE

    for (i in 2..n) {
        val currentFib = fibMinusTwo + fibMinusOne
        fibMinusTwo = fibMinusOne
        fibMinusOne = currentFib
    }

    return fibMinusOne
}

object Fibonacci {
    suspend fun take(n: Int): BigInteger {
        return fibonacci(n)
    }
}

suspend fun main() {
    runBlocking {
        launch { println(Fibonacci.take(5)) }
        launch { println(Fibonacci.take(10)) }
        launch { println(Fibonacci.take(15)) }

        launch { println(Fibonacci.take(35)) }
        launch { println(Fibonacci.take(30)) }
        launch { println(Fibonacci.take(25)) }
    }
}