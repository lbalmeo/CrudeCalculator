package com.example.calculator308;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    Label label1;
    Button butt0;
    Button butt1;
    Button butt2;
    Button butt3;
    Button butt4;
    Button butt5;
    Button butt6;
    Button butt7;
    Button butt8;
    Button butt9;
    Button buttadd;
    Button buttsub;
    Button buttmult;
    Button buttdiv;
    Button butteq;
    String i1;
    String i2;
    String op;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Very Crude Calculator");
        label1 = new Label("Equation will display here.");
        VBox root = new VBox();
        Scene scene = new Scene(root, 400, 800);
        stage.setScene(scene);

        i1 = i2 = op = "";
        butt0 = makeButton("0");
        butt1 = makeButton("1");
        butt2 = makeButton("2");
        butt3 = makeButton("3");
        butt4 = makeButton("4");
        butt5 = makeButton("5");
        butt6 = makeButton("6");
        butt7 = makeButton("7");
        butt8 = makeButton("8");
        butt9 = makeButton("9");
        buttadd = makeButton("+");
        buttsub = makeButton("-");
        buttmult = makeButton("*");
        buttdiv = makeButton("/");
        butteq = makeEqButton("=");

        root.getChildren().addAll(label1,butt0,butt1,butt2,butt3,butt4,butt5,butt6,butt7,butt8,butt9,buttadd,buttsub,buttmult,buttdiv,butteq);
        stage.show();
    }

    public Button makeButton(String str){
        Button butt = new Button(str);
        butt.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if(str.compareTo("+") == 0 || str.compareTo("-") == 0 || str.compareTo("*") == 0 || str.compareTo("/") == 0){
                    op = str;
                }
                else if(op.compareTo("") == 0) i1 += str;
                else i2 += str;

                label1.setText(i1 + " " + op + " " + i2);
            }
        });
        return butt;
    }

    public Button makeEqButton(String str){
        Button butt = new Button(str);
        butt.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if(i1.compareTo("") == 0 || i2.compareTo("") == 0 || op.compareTo("") == 0){
                    label1.setText("Invalid equation. Please try again.");
                    return;
                }
                float x = Integer.parseInt(i1);
                float y = Integer.parseInt(i2);
                if(op.compareTo("+") == 0) label1.setText(i1 + " " + op + " " + i2 + " = " + (x + y));
                else if(op.compareTo("-") == 0) label1.setText(i1 + " " + op + " " + i2 + " = " + (x - y));
                else if(op.compareTo("*") == 0) label1.setText(i1 + " " + op + " " + i2 + " = " + (x * y));
                else if(y == 0) label1.setText("Error: Division by zero");
                else label1.setText(i1 + " " + op + " " + i2 + " = " + (x / y));
                i1 = op = i2 = "";
            }
        });

        return butt;
    }
}