package test;


import main.StringCalculator;
import org.junit.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator;
    @Test
    public void if_string_is_empty_should_return_zero(){

        stringCalculator = new StringCalculator();
        Assert.assertEquals(0, stringCalculator.calculate(""));
    }

    @Test
    public void one_number_should_return_the_number(){

        stringCalculator = new StringCalculator();
        Assert.assertEquals(1, stringCalculator.calculate("1"));
    }

    @Test
    public void calculate_should_return_sum_of_numbers(){

        stringCalculator = new StringCalculator();
        Assert.assertEquals(5, stringCalculator.calculate("2,3"));
    }

    @Test
    public void if_there_are_new_lines_instead_of_commas(){

        stringCalculator = new StringCalculator();
        Assert.assertEquals(7, stringCalculator.calculate("3\n2,1\n1"));
    }

    @Test
    public void string_have_different_delimiters(){

        stringCalculator = new StringCalculator();
        Assert.assertEquals(5, stringCalculator.calculate("//;\n3,1\n1"));
    }

    @Test
    public void numbers_bigger_than_one_thousand_should_be_ignored(){

        stringCalculator = new StringCalculator();
        Assert.assertEquals(7, stringCalculator.calculate("7,1001\n0"));
    }

    @Test
    public void should_throw_exception_for_negative_numbers(){

        stringCalculator = new StringCalculator();
        Assert.assertEquals("Negatives not allowed.", stringCalculator.calculate("-1"));
    }

}
