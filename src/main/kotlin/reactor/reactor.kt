package reactor

import reactor.core.publisher.Flux
import java.time.Duration

fun main(args: Array<String>) {
    var a = Flux.interval(Duration.ofMillis(100))
    var aInt = 1

    a
        .doOnNext { println("${Thread.currentThread().name} ${aInt++} $it") }
        .window(100)
        .doOnNext { list -> list.doOnNext { println(it) }
            .subscribe()}
        .doOnComplete { println("COMPLETE-A") }
        .subscribe()

//    var b = Flux.interval(Duration.ofMillis(10))
//    b.limitRate(10)
//        .doOnNext { println("${Thread.currentThread().name} $it") }
//        .doOnComplete { println("COMPLETE-B") }
//        .subscribe()
    Thread.sleep(10000)
}
//999
