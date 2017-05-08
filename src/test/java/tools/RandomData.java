package tools;


import java.util.Random;


public class RandomData {
	public static String getUniqueString(int min, int max){
		
		int random = getRandomNumberInRange(min,max);
		
		byte randomByteLengthArray[] = new byte[random];
		
		for (int i =0; i < random;i++){
			randomByteLengthArray[i] = (byte)getRandomNumberInRange('a','z');
		}
		return new String(randomByteLengthArray,0);	
	}
	
	
	public static int getRandomNumberInRange(int min,int max){
		Random generate = new Random();
		int range = max - min + 1;
		int randomNumber = generate.nextInt(range);
		
		if(randomNumber < 0){
			randomNumber = -randomNumber;
		}
		return min + randomNumber;
	}
	
	public static String getUniquePassword(){
		return getUniqueString(1, 1).toUpperCase() + getUniqueString(5, 7) + "_" + getRandomNumberInRange(1, 99);
	}
	
	public static String getUniqueGmailEmail(String email){
		String base =email + "+";
		String emailEnding = "gmail.com";
		return base + getUniqueString(5,7) + "@" + emailEnding;
	}
	
	
	public static void main(String [ ] args){
		System.out.println(getUniqueString(5,8));
		System.out.println(getUniqueGmailEmail("victortomaciprian"));
		System.out.println(getUniquePassword());
	}
	
	
	
}
