import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code {

    // Returns "Hello World!"
    public static String helloWorld() {
    	
    	String returnString = "Hello World!";
    	
        return returnString;
    }

    // Take a single-spaced <sentence>, and capitalize every <n> word starting with <offset>.
    public static String capitalizeEveryNthWord(String sentence, Integer offset, Integer n) {
    	
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        String returnString = "";
        ArrayList<String> words = new ArrayList<String>();
        
        // Break the sentence into tokens delimited by " "
        while(tokenizer.hasMoreTokens())
        	words.add(tokenizer.nextToken());
        
        // Reinsert spaces at the end of words
        for(int i = 0; i < words.size() - 1; i++)
        	words.set(i, words.get(i) + " ");
        
        // Capitalize every nth word starting at the offset
        for(int i = offset; i < words.size(); i += n){
        	String lowWord = words.get(i);
        	String capWord = "";
        	
        	capWord = lowWord.substring(0, 1).toUpperCase();
        	capWord += lowWord.substring(1);
        	
        	words.set(i, capWord);
        }
        
        // Rebuild the input sentence with the appropriate words now capitalized
        for(String s : words)
        	returnString += s;
        
        return returnString;
    }

    // Determine if a number is prime
    public static Boolean isPrime(Integer n) {
    	
    	int i = n - 1;
    	
    	// 2 is prime by definition
    	if(n == 2)
    		return true;
    	
    	// All integers < 2  are not prime by definition
    	if (n < 2)
    		return false;
        
    	// Try dividing n by all possible factors. Return false if a factor is found
    	while(i > 1){
    		if(n % i == 0)
    			return false;
    		
    		i -= 1;
    	}
    	
    	// return true if no factors were found
    	return true;
    }

    // Calculate the golden ratio.
    // Given two numbers a and b with a > b > 0, the ratio is b / a.
    // Let c = a + b, then the ratio c / b is closer to the golden ratio.
    // Let d = b + c, then the ratio d / c is closer to the golden ratio.
    // Let e = c + d, then the ratio e / d is closer to the golden ratio.
    // If you continue this process, the result will trend towards the golden ratio.
    public static Double goldenRatio(Double a, Double b) {
        
    	double sum = 0.0;
    	double ratio = 0.0;
    	
    	// Add the sum and larger of the two numbers to create the new sum repeatedly
    	for(int i = 0; i < 100; i++){
    		sum = a + b;
    		
    		if(a > b)
    			b = sum;
    		
    		else
    			a = sum;
    	}

    	// Divide sum by larger of numbers to approximate golden ratio
    	if(a > b)
    		ratio = a / b;
    	
    	else
    		ratio = b / a;
    	
    	return ratio;
    }

    // Give the nth Fibionacci number
    // Starting with 1 and 1, a Fibionacci number is the sum of the previous two.
    public static Integer fibionacci(Integer n) {
        
    	int fib = 0;
    	int prev = 1;
    	int temp = 0;
    	
    	if(n == 0)
    		return 0;
    	
    	// Add current and previous fibionacci numbers to get next fibionacci in sequence
    	// until the nth number has been calculated
    	for(int i = 0; i < n; i++){
    		temp = fib;
    		fib += prev;
    		prev = temp;
    	}
    	
    	return fib;
    }

    // Give the square root of a number
    // Using a binary search algorithm, search for the square root of a given number.
    // Do not use the built-in square root function.
    public static Double squareRoot(Double n) {
        
    	double upperBound = n;
    	double lowerBound = 0;
    	double root = 0;
    	
    	for(int i = 0; i < 100; i++){
    		
    		// Average upper and lower bounds to approximate root
    		root = (upperBound + lowerBound) / 2;
    		
    		// If root * root = n, the root has been found
    		if(root * root == n )
    			break;
    		
    		// If root * root > n, the upper bound is too great and must be lowered
    		else if(root * root > n)
    			upperBound = root;
    		
    		// If root * root < n, the lower bound is too small and must be raised
    		else
    			lowerBound = root;
    	}
    	
    	return root;
    }
    
    
}
