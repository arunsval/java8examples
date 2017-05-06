package pack1;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LambdaExample {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Sam","Andrew","Bob");
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(9);
		numbers.add(3);
		numbers.add(23);
		
		Collections.sort(names,new Comparator<String>(){
			
			public int compare(String a,String b){
				return a.compareTo(b);
			}
			
		});
		for(String a: names){System.out.println(a);}
		/*names.forEach(new Consumer<String>(){
			@Override
			public void accept(String a){
				System.out.println(a);
			}
			
		});*/
		
		Collections.sort(numbers,(a,b) -> a.compareTo(b));
		
		for(Integer n:numbers){
			System.out.println(n);
		}

	}

}
