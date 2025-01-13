public class NumberConverter {
    public static int getNumber(int number, String type) {
        int result = 0;

        if (type.equalsIgnoreCase("byte"){
            byte resultValue;
            int var = number / 128; 
            if (var % 2 == 0) {
                resultValue = (byte) (number % 128);
            } else {
                resultValue = (byte) (-128 + (number % 128));
            }
            result = resultValue; 
        } else if (type.equalsIgnoreCase("short")) {
            
            short resultValue;
            int var = number / 32767; 
            if (var % 2 == 0) {
                resultValue = (short) (number % 32767);
            } else {
                resultValue = (short) (-32767 + (number % 32767));
            }
            result = resultValue; // Store result in int format
        } else {
            System.out.println("Invalid type specified. Use 'byte' or 'short'.");
        }

        return result;
    }
}
