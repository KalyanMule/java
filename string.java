String toXXString(String number, String XX) {
    int num = Integer.parseInt(number);
    
    if (XX.equalsIgnoreCase("toBinary")) {
        number = toBinary(num);
    } else if (XX.equalsIgnoreCase("toOctal")) {
        number = toOctal(num);
    } else if (XX.equalsIgnoreCase("toDecimal")) {
        number = Integer.toString(num);
    } else if (XX.equalsIgnoreCase("toHexa")) {
        number = toHexa(num);
    } else {
        number = "Invalid conversion type.";
    }

    return number;
}

String toBinary(int num) {
    if (num == 0) {
        return "0";
    }
    String result = "";
    while (num > 0) {
        result = (num % 2) + result;
        num = num / 2;
    }
    return result;
}

String toOctal(int num) {
    if (num == 0) {
        return "0";
    }
    String result = "";
    while (num > 0) {
        result = (num % 8) + result;
        num = num / 8;
    }
    return result;
}

String toHexa(int num) {
    if (num == 0) {
        return "0";
    }
    String result = "";
    String hexChars = "0123456789ABCDEF";
    while (num > 0) {
        result = hexChars.charAt(num % 16) + result;
        num = num / 16;
    }
    return result;
}
