package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int calculate(String expression){
        if(!expression.isEmpty()){

            int result = 0;

            if(expression.startsWith("//")){

                Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(expression);
                if(matcher.matches()){
                    String delimiter = matcher.group(1);
                    String toSplit = matcher.group(2);
                    String[] numbers = toSplit.split(delimiter);
                    for(String number: numbers){
                        result += Integer.parseInt(number);
                    }
                    return result;
                }

            }else{
                String[] numbers = expression.split("[,:\\n]");
                for(String number: numbers){
                    int numeroParseado = Integer.parseInt(number);
                    if(numeroParseado > 1000){
                        numeroParseado = 0;
                    }else{
                        result += numeroParseado;
                    }
                }
                return result;
            }
        }
        return 0;
    }
}
