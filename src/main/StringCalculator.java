package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int calculate(String expression){
        if(!expression.isEmpty()){

            int result = 0;

            String[] numbers = getSplit(expression);

            for(String number: numbers){

                int numeroParseado = Integer.parseInt(number);

                if(numeroParseado < 0){
                    throw new RuntimeException("Negatives not allowed. " + numeroParseado);
                }
                if(numeroParseado > 1000){
                    numeroParseado = 0;
                }else{
                    result += numeroParseado;
                }
            }
            return result;
        }
        return 0;
    }


    public String[] getSplit(String expression){

        if(expression.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(expression);
            if (matcher.matches()) {
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                return toSplit.split(delimiter);
            }
        }
        return  expression.split("[,:\\n]");
    }
}
