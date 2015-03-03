package daniel.szabo.stringCalculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        String separator = findSeparator(numbers);
        String[] splitNumbers = numbers.split(Pattern.quote(separator));
        int sum = 0;
        for (String number : splitNumbers) {
            sum += Integer.valueOf(number);
        }
        return sum;
    }

    private String findSeparator(String numbers) {
        String separator = "";
        boolean isSeparatorReached = false;
        for(int i=0; i < numbers.length(); i++) {
            if(!Character.isDigit(numbers.charAt(i))) {
                separator += String.valueOf(numbers.charAt(i));
                isSeparatorReached = true;
            }
            if(isSeparatorReached && Character.isDigit(numbers.charAt(i))) {
                break;
            }
        }
        return separator;
    }
}
