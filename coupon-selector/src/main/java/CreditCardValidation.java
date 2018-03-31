import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;
public class CreditCardValidation {

	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
        String[] bannedPrefixes = input.nextLine().split(",");
        int lines = Integer.parseInt(input.nextLine());
        String[] cardsToValidate = new String[lines];
        IntStream.range(0, lines).forEach(i -> cardsToValidate[i] = input.nextLine());    
        List<Map<String, Object>> processedCards = validateCards(bannedPrefixes, cardsToValidate);    
        processedCards.stream().forEach(CreditCardValidation::printCardResult);
	}
	

    static List<Map<String, Object>> validateCards(String[] bannedPrefixes, String[] cardsToValidate) {
    	List<Map<String, Object>> processedList = new ArrayList<Map<String, Object>>();
    	Map<String, Object> currentProcess = null;
    	
    	try{
    		if(null!=cardsToValidate && null != bannedPrefixes){
    			for(String nowCard : cardsToValidate){
    				currentProcess = new HashMap<String,Object>();
            		currentProcess.put("card", nowCard);
                	currentProcess.put("isValid", doLuhnCheck(nowCard));
                	currentProcess.put("isAllowed", doPrefixCheck(bannedPrefixes,nowCard));
                	processedList.add(currentProcess);
            	}
        	}
    		
    		
    	}catch(NumberFormatException | ArithmeticException ae){
    		System.err.println("Handled Exception:"+ae.getMessage());
    	}catch(Exception e){
    		System.err.println("Yet to Handle Exception:"+e.getMessage());
    	}
    	return processedList;

    }


    
	 private static boolean doPrefixCheck(String[] bannedPrefixes, String nowCard)  throws Exception{
		String cardPrefix = null;
			for(String bannedPrefix : bannedPrefixes){
				if(null!=nowCard && null!= bannedPrefix) {
					cardPrefix = "";
					cardPrefix = nowCard.substring(0, Math.min(nowCard.length(), bannedPrefix.length())); 
					if(bannedPrefix.equalsIgnoreCase(cardPrefix)){
						return false;
					}
				}
				
			}
	
		return true;
	}


	private static boolean doLuhnCheck(String nowCard) throws Exception{
		int sum = 0;
		int calculatedLastDigit = 0;
		int num = 0;
		for(int i=0;i<nowCard.length();i++){
			num = Integer.parseInt(nowCard.substring(i, i+1));
			System.out.print(num+"*");
			sum+= (num*2);
		}
		System.out.println(sum);
		calculatedLastDigit = sum /10;
		if(nowCard.substring(nowCard.length()-1, nowCard.length()).equalsIgnoreCase(String.valueOf(calculatedLastDigit))){
			return true;	
		}
		return false;
		
	}


	public static void printCardResult(Map<String, Object> cardResult){
	        System.out.print("{\"card\":\"" +  cardResult.get("card") + "\",");
	        System.out.print("\"isValid\":" +  cardResult.get("isValid") + ",");
	        System.out.println("\"isAllowed\":" +  cardResult.get("isAllowed") + "}");
	    }
	 
	 

}
