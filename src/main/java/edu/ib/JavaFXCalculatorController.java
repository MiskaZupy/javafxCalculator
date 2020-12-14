package edu.ib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class JavaFXCalculatorController {

    private double nr1 =0;
    private String operator ="";
    private String operator2 ="";
    private String number;
    private String correctNumber="";
    double result;
    @FXML
    private TextField display;



    @FXML
    void onAction(ActionEvent event) {
        Calculator calculator = new Calculator();
        operator = ((Button) event.getSource()).getText();
        // znak =
        if (operator.equals("=")){
            // wykonanie dzialania
            result = calculator.calculate(nr1, Double.parseDouble(display.getText()), operator2);
            display.setText(String.valueOf(result));
            operator="";
         }
        // dzialania potrzebujace wiecej niz dwoch liczb
         else if(operator.equals("+") || operator.equals("-") || operator.equals("*")|| operator.equals("/")) {
            //zapisanie pierwszej liczby
            nr1 = Double.parseDouble(display.getText());
            // zresetownie stringa z numere,
            correctNumber = "";
            // usuniecie liczby z ekranu
            display.setText("");
            // zapisanie dzialania
            operator2=operator;
            operator="";
         }
         // dzialanie wykorzystujace jedna liczbe
         else{
             // pobranie liczby z ekranu i wykonenie odpowiedniego dzialania
            result = calculator.calculateSpecial(Double.parseDouble(display.getText()),operator);
            // zresetowanie string zawierajacego liczbe
            correctNumber = "";
            // wyswietlenie wyniku
            display.setText(String.valueOf(result));
            operator="";
        }




    }

    @FXML
    void onActionNumbers(ActionEvent event) {

        // pobranie tekstu z przycisku
        number = ((Button)event.getSource()).getText();
        correctNumber += number;
        // poprawa liczb z 0 na poczatku
        Calculator calculator = new Calculator();
        correctNumber = calculator.checkZero(correctNumber);
        // nie wiecej niz dwie kropki
        correctNumber = calculator.checkComa(correctNumber);

        display.setText(correctNumber);


    }





}
