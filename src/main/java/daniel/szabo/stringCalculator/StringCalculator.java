package daniel.szabo.stringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        checkForNegativeNumbers(numbers);
        String separator = findSeparator(numbers, null);
        String[] splitNumbers = numbers.split(Pattern.quote(separator));
        int sum = 0;
        for (String number : splitNumbers) {
            sum += Integer.valueOf(number);
        }
        return sum;
    }

    private void checkForNegativeNumbers(String numbers) {
        if(numbers.contains("-")) {
            String separator = findSeparator(numbers, "-");
            List<Integer> negativeNumbers = getNegativeNumbersFromString(numbers, separator);
            String exceptionMessage = createExceptionMessage(negativeNumbers);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private String createExceptionMessage(List<Integer> negativeNumbers) {
        String exceptionMessage = "Negatives not allowed: ";
        for (Integer negativeNumber : negativeNumbers) {
            exceptionMessage += negativeNumber + ", ";
        }
        return exceptionMessage.substring(0, exceptionMessage.length() - 2);
    }

    private List<Integer> getNegativeNumbersFromString(String numbers, String separator) {
        String[] splitNumbers = numbers.split(Pattern.quote(separator));
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            if(Integer.valueOf(number) < 0) {
                negativeNumbers.add(Integer.valueOf(number));
            }
        }
        return negativeNumbers;
    }

    private String findSeparator(String numbers, String ignoredSeparator) {
        String separator = "";
        if(ignoredSeparator == null) {
            ignoredSeparator = "";
        }
        boolean isSeparatorReached = false;
        for(int i=0; i < numbers.length(); i++) {
            if(!Character.isDigit(numbers.charAt(i)) && !String.valueOf(numbers.charAt(i)).equals(ignoredSeparator)) {
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
