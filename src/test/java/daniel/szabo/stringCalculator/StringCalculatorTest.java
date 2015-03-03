package daniel.szabo.stringCalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void initializeVariables() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroOnEmptyString() {
        Assert.assertTrue(stringCalculator.add("") == 0);
    }

    @Test
    public void shouldReturnTheInputOnSingleInput() {
        Assert.assertTrue(stringCalculator.add("1") == 1);
    }

    @Test
    public void shouldReturnTheSumOfInputWhenSeparatedWithComma() {
        Assert.assertTrue(stringCalculator.add("2,2") == 4);
        Assert.assertTrue(stringCalculator.add("2,2,2") == 6);
    }

    @Test
    public void shouldReturnTheSumOfInputWhenSeparatedWithArbitraryCharacters() {
        Assert.assertTrue(stringCalculator.add("3;4;4;6") == 17);
        Assert.assertTrue(stringCalculator.add("3++4++5++6") == 18);
        Assert.assertTrue(stringCalculator.add("3/4/5/6") == 18);
        Assert.assertTrue(stringCalculator.add("3|4|5|6") == 18);
        Assert.assertTrue(stringCalculator.add("3~4~5~6") == 18);
    }
}
