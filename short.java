public class IntegerToShort {
    
    
    public static short getShort(int number) {
        short result;  
        int var = number / 32767; 
        
        if (var % 2 == 0) {  
            result = (short) (number % 32767);  
        } else {  
            result = (short) (-32767 + (number % 32767)); 
        }
        
        return result; 
    }

    public static void main(String[] args) {
        int number = 50000;  
        
        
        short result = getShort(number);
        
        
        System.out.println("Converted short value: " + result);
    }
}
