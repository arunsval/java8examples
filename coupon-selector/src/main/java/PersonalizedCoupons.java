import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PersonalizedCoupons {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
        List<String> preferredCategories = Arrays.asList(input.nextLine().split(","));
        List<Map<String, Object>> coupons = new ArrayList<>();
        int lines = Integer.parseInt(input.nextLine());
        IntStream.range(0, lines).forEach(i -> coupons.add(readCoupon(input)));
        List<Map<String, Object>> personalizedCoupons = personalizeCoupons(coupons, preferredCategories);
        personalizedCoupons.stream().forEach(PersonalizedCoupons::printCoupon);

	}
	
	 static List<Map<String, Object>> personalizeCoupons(List<Map<String, Object>> coupons, 
             List<String> preferredCategories) {
		 List<Map<String,Object>> tempCoupons = coupons;
		 try{
		
		 if(null!= tempCoupons && !preferredCategories.isEmpty()){
		 //filter only preferred categories here 
	     tempCoupons = tempCoupons.stream().filter((c)-> {
	    	 if(preferredCategories.contains(c.get("category"))){
	    		 return true;
	    		 }
	    	 return false;
	     }).collect(Collectors.toList());
	     
	    //sort on discount
	     Comparator<Map<String,Object>> discountComparator = (c1,c2)->{
	    	 float discount1 = ((float)(c1.get("couponAmount")) / (float)c1.get("itemPrice"))*100;
	    	 float discount2 = ((float)(c2.get("couponAmount")) / (float)c2.get("itemPrice"))*100;
	    	 if((discount1 - discount2)<0)	
	    		 return -1;
	    	 else if((discount1 - discount2)>0)
				return 1;
			else
			   return 0;		
	     };
	     tempCoupons.sort(discountComparator.reversed());

	   //limit to first 10
	     tempCoupons = tempCoupons.subList(0, Math.min(10, tempCoupons.size()));
	     
	   //remove sensitive info 
	     tempCoupons.forEach(m ->{
				m.entrySet().removeIf(e -> ("code".equalsIgnoreCase(e.getKey())));
				});
		 }
		 
		 }catch(NumberFormatException |ArithmeticException ae){
			 System.err.println(ae.getMessage());
		 }
		
	 return tempCoupons;
}
	
	
	 public static Map<String, Object> readCoupon(Scanner input) {
	        String[] couponItems = input.nextLine().split(",");
	        Map<String,Object> coupon = new HashMap<>();
	        coupon.put("upc", couponItems[0]);
	        coupon.put("code", couponItems[1]);
	        coupon.put("category", couponItems[2]);
	        coupon.put("itemPrice", Float.parseFloat(couponItems[3]));
	        coupon.put("couponAmount", Float.parseFloat(couponItems[4]));
	        return coupon;
	    }

	    public static void printCoupon(Map<String, Object> coupon)
	    {
	        System.out.print("{");
	        System.out.print("\"couponAmount\":" +  coupon.get("couponAmount") + ",");
	        System.out.print("\"upc\":\"" +  coupon.get("upc") + "\",");
	        if(coupon.containsKey("code")) {
	            System.out.print("\"code\":\"" +  coupon.get("code") + "\",");
	        }
	        System.out.print("\"itemPrice\":" +  coupon.get("itemPrice") + ",");
	        System.out.println("\"category\":\"" +  coupon.get("category") + "\"}");
	    }
}
