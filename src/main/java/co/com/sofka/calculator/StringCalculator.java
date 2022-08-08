package co.com.sofka.calculator;


import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    private  String delimiterBasic = "[,|\n]";
    private String  delimiterCompleted = "[!\"#$%&'()*./:;<=>?@,^_ `{|}\n~]";
    public Integer calculate(String numbers){
        List<Integer> numbersToSum = filteringString(numbers);
        return sumNumbers(numbersToSum);


    }

    public Integer sumNumbers(List<Integer> numbers){
      return  numbers.stream()
              .reduce(0, Integer::sum);
    }

    private List<Integer> filteringString(String numbers) {
        var numberSplit = getSplit(numbers);
        validateNegativeNumbers(numberSplit);
        return Stream.of(numberSplit)
                .filter(Predicate.not(String::isEmpty))
                .map(Integer::parseInt)
                .filter(number -> number <=1000).toList();

    }

    private void validateNegativeNumbers (String...numbers){
        var numbersNegative = Stream.of(numbers)
                .filter(Predicate.not(String::isEmpty))
                .map(Integer::parseInt)
                .filter(number -> number > 0).toList();

        if(!numbersNegative.isEmpty()){
            throw new  NumberFormatException("no se permiten numeros negativos");
        }

    }



    private String[] getSplit(String numbers) {
        var delimiter = numbers.matches("(^\\d+|^-)\n?.*") ? delimiterCompleted : delimiterBasic;
        return numbers.split(delimiter);
    }

    


}
