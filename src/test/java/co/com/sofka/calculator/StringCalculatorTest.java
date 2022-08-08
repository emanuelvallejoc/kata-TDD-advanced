package co.com.sofka.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    void emptyStringEqualZero(){
        var str = "";
        var result = calculator.calculate(str);

        assertEquals(0, result );

    }

    @Test
    void lonelyNumber(){
        var str = "4";
        var result = calculator.calculate(str);

        assertEquals(4, result );

        str = "8";
        result = calculator.calculate(str);

        assertEquals(8, result );

    }

    @Test
    void lineBreakDelimitedNumbersSumTest() {
        var str = "2\n2";
        var result = calculator.calculate(str);
        assertEquals(4, result);

        str = "4\n4";
        result = calculator.calculate(str);
        assertEquals(8, result);

        str = "8\n8";
        result = calculator.calculate(str);
        assertEquals(16, result);
    }

    @Test
    void commaDelimitedNumbersSumTest() {
        var str = "2,2";
        var result = calculator.calculate(str);
        assertEquals(4, result);

        str = "4,4";
        result = calculator.calculate(str);
        assertEquals(8, result);

        str = "8,8";
        result = calculator.calculate(str);
        assertEquals(16, result);
    }

    @Test
     void numbersDelimitedByAnySign() {
        var str = "1.2,3";
        var result = calculator.calculate(str);
        assertEquals(6, result);

        str = "1\n2,1";
        result = calculator.calculate(str);
        assertEquals(4, result);

        str = "5.4~2";
        result = calculator.calculate(str);
        assertEquals(11, result);
    }

    @Test
    void negativeNumbersExceptionTest() {

        var str1  = "-1,2";
        var str2 = "1,-2";
        var str3 = "-1,-2";


        var exception = assertThrows(NumberFormatException.class, ()-> calculator.calculate(str1));
        assertEquals("no se permiten numeros negativos", exception.getMessage());

        exception = assertThrows(NumberFormatException.class, ()-> calculator.calculate(str2));
        assertEquals("no se permiten numeros negativos", exception.getMessage());

        exception = assertThrows(NumberFormatException.class, ()-> calculator.calculate(str3));
        assertEquals("no se permiten numeros negativos", exception.getMessage());


    }

}