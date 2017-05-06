package pack1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.*;
public class FnInterfaces2 {

	
public static void main(String[] args){
	Predicate<String> p = (s) -> s.length() > 0;
	Function<String,Integer> fn = (d) -> (d=="Apple"?23:12);
	Supplier s = ()->"Hours";
	Consumer<Float> c = (f) -> System.out.println(String.valueOf(f));
	Optional<String> op = Optional.ofNullable(null);
	Map<Integer,String> m = new HashMap<Integer,String>();
	
	//Comparator<Collection> cm = (s1,s2) -> s2.compareTo(s1); 
	System.out.println(p.test("ddd"));
	System.out.println(fn.apply("Banana"));
	System.out.println(s.get());
	c.accept(new Float(12.43));
	String str1 = null;
	String str2 = "22222";
	//System.out.println(op.get());
	System.out.println(op.orElse(str2));
	//Person ob;
	for(int i=0;i<5;i++){
		m.put(i, "val"+i);
	}
	
	m.forEach((k,v) -> System.out.println(v)) ;
	m.computeIfAbsent(15,v->"new"+15 );
	m.forEach((k,v) -> System.out.println(v)) ;
	
	System.out.println(m.getOrDefault(50,"dddd")) ;
	
}	
	
	
}
