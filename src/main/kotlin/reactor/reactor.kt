import reactor.core.publisher.Flux
import java.time.Duration
import java.util.function.LongConsumer

fun main(args: Array<String>) {
    var a = Flux.interval(Duration.ofMillis(1000))
    var aInt = 1

    a
        .limitRate(10,0)
        .doOnNext { println("${Thread.currentThread().name} ${aInt++} $it") }
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