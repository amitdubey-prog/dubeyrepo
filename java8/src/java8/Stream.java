package java8;

import java.util.function.Consumer;
import java.util.stream.BaseStream;

public interface Stream<T> extends BaseStream<T, Stream<T>> {

	  void forEach(Consumer<? super T> action);
	  //...

	}