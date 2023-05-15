package reactor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.runBlocking
import reactor.core.publisher.Flux
import java.time.Duration

fun main(args: Array<String>) {
    runBlocking {
        var a = Channel<Int> { it.inc() }
        println(a.receive())
        a.send(1)
        println(a.receive())
        a.send(2)
        a.close()

        println()
        println(11)
    }

    Thread.sleep(10000)
}
