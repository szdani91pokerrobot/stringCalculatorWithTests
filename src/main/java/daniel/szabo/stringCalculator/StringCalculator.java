package daniel.szabo.stringCalculator;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        String[] splitNumbers = numbers.split(",");
        int sum = 0;
        for (String number : splitNumbers) {
            sum += Integer.valueOf(number);
        }
        return sum;
    }
}
