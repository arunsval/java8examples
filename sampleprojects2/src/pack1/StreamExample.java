package pack1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.Comparator;;

public class StreamExample {
public static void main(String[] args){

	List<Person> persons = new ArrayList<Person>();
	persons.add(new Person("Zaheer",10));
	persons.add(new Person("Arun",29));
	persons.add(new Person("Bala",32));
	

	Stream<Person> s1 = persons.stream();
	s1.filter(k -> k.age < 18)
	.forEach(new Consumer<Person>(){
		@Override
		public void accept(Person p){
		System.out.println(p.name);
		}
	}
	);
	s1.close();
	s1 = persons.stream();
//	Comparator<Person> cm = (p1,p2) -> (p2.name).compareTo(p1.name);
	s1.map(p -> p.name)
	.sorted()
	.forEach(System.out::println);
	s1.close();
	
	s1 = persons.stream();
	long count = s1.count();
	s1.close();
	s1 = persons.stream();
	boolean allMatched = s1.allMatch(s -> s.name.startsWith("A"));
	System.out.println(allMatched + "" + count);
	
	findDuration();
}

public static void findDuration(){

	List<String> nums = new ArrayList<String>();
	for(int i=0;i<1000000;i++){
		UUID id = UUID.randomUUID();
		nums.add(id.toString());
	}
	 long t0 = System.nanoTime();
	 System.out.println("Sorted count"+nums.stream().sorted().count());
	 long t1 = System.nanoTime();
	 long duration = TimeUnit.NANOSECONDS.toMillis(t1-t0);
	 System.out.println("Sequemtial Duration in ms:"+duration);
	 
	 t0 = System.nanoTime();
	 System.out.println("Sorted count"+nums.parallelStream().sorted().count());
	 t1 = System.nanoTime();
	 duration = TimeUnit.NANOSECONDS.toMillis(t1-t0);
	 System.out.println("Parallel Duration in ms:"+duration);
	 
}
}
