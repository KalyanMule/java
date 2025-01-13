public class GetByte(){
  public static byte getByte (int number) {
        byte result;
   int var = number / 128;
        if (var % 2 == 0) {     
            result = (byte) (number % 128); 
        } else {                
            result = (byte) (-128 + (number % 128)); 
        }
        return result;         
   }
