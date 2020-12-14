package edu.ib;




public class Calculator {


    public double calculate(double nr1, double nr2, String operator){
        double result =0;
        // sprawdzenie dzialania i wykonanie go
        switch (operator) {
            case "+":
                result = nr1 + nr2;
                break;
            case "-":
                result = nr1 - nr2;
                break;
            case "*":
                result = nr1 * nr2;
                break;
            case "/":
                if (nr2 == 0)
                    result = 0;
                else
                    result = nr1 / nr2;
                break;
        }

         return result;
    }


    public  double calculateSpecial(double nr1,String operator){
        // sprawdzenie dzialania i wykonanie go
        double result = switch (operator) {
            case "%" -> nr1 / 100;
            case "C" -> 0;
            case "+/-" -> nr1 * (-1);
            default -> 0;
        };
        return result;
    }



    public String checkZero(String correctNumber){
        // poprawa liczby
        switch (correctNumber) {
            case "00" -> correctNumber = "0";
            case "01" -> correctNumber = "0.1";
            case "02" -> correctNumber = "0.2";
            case "03" -> correctNumber = "0.3";
            case "04" -> correctNumber = "0.4";
            case "05" -> correctNumber = "0.5";
            case "06" -> correctNumber = "0.6";
            case "07" -> correctNumber = "0.7";
            case "08" -> correctNumber = "0.8";
            case "09" -> correctNumber = "0.9";
        }
        return correctNumber;
    }

    public String checkComa(String correctNumber){
        // poprawa liczby
        int count = 0;
        for(int i = 0;i<correctNumber.length(); i++){

            char a = correctNumber.charAt(i);

            if(a == '.')
                count++;

            if(count>1){
                correctNumber = correctNumber.substring(0,correctNumber.length()-1);
            }

        }


        return correctNumber;
    }


}
