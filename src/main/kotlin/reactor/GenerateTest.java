package reactor;

import java.util.concurrent.atomic.AtomicLong;

import reactor.core.publisher.Flux;

public class GenerateTest {
	public static void main(String[] agrs){
		Flux<String> flux = Flux.generate(
			AtomicLong::new,
			(state, sink) -> { // (1)
				long i = state.getAndIncrement(); // (2)
				sink.next("3 x " + i + " = " + 3*i);
				if (i == 10) sink.complete();
				return state; // (3)
			}, (state) -> System.out.println("state: " + state));

		return;
	}
}
