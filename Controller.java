package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_field;

    @FXML
    private Button clear_btn;

    @FXML
    private Button pls_min_btn;

    @FXML
    private Button percent_btn;

    @FXML
    private Button divide_btn;

    @FXML
    private Button seven_btn;

    @FXML
    private Button eight_btn;

    @FXML
    private Button nine_btn;

    @FXML
    private Button ix_btn;

    @FXML
    private Button four_btn;

    @FXML
    private Button five_btn;

    @FXML
    private Button six_btn;

    @FXML
    private Button minus_btn;

    @FXML
    private Button one_btn;

    @FXML
    private Button two_btn;

    @FXML
    private Button three_btn;

    @FXML
    private Button plus_btn;

    @FXML
    private Button zero_btn;

    @FXML
    private Button separ_btn;

    @FXML
    private Button eql_btn;

    String str_num = "";
    private float first_num = 0;
    private char operation;
    @FXML
    void initialize() {
        zero_btn.setOnAction(event ->{
            addNumber(0);
        } );
        one_btn.setOnAction(event ->{
            addNumber(1);
        } );
        two_btn.setOnAction(event ->{
            addNumber(2);
        } );
        three_btn.setOnAction(event ->{
            addNumber(3);
        } );
        four_btn.setOnAction(event ->{
            addNumber(4);
        } );
        five_btn.setOnAction(event ->{
            addNumber(5);
        } );
        six_btn.setOnAction(event ->{
            addNumber(6);
        } );
        seven_btn.setOnAction(event ->{
            addNumber(7);
        } );
        eight_btn.setOnAction(event ->{
            addNumber(8);
        } );
        nine_btn.setOnAction(event ->{
            addNumber(9);
        } );
        plus_btn.setOnAction(event ->{
            mathActions('+');
        });
        minus_btn.setOnAction(event ->{
            mathActions('-');
        });
        ix_btn.setOnAction(event ->{
            mathActions('*');
        });
        divide_btn.setOnAction(event ->{
            mathActions('/');
        });

    eql_btn.setOnAction(event ->
    {
        if (this.operation != '+' || this.operation != '-' || this.operation != '/'
                || this.operation != '*')
        {
        equalMethod();
        }
    });
        separ_btn.setOnAction(event ->{
        if(!this.str_num.contains("."))
        {
            this.str_num += ".";
            label_field.setText(str_num);
        }
        });
        percent_btn.setOnAction(event -> {
        if(this.str_num != "")
            {
                float num = Float.parseFloat(this.str_num) * 0.1f;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        pls_min_btn.setOnAction(event -> {
            if(this.str_num != "")
            {
                float num = Float.parseFloat(this.str_num) * -1;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        clear_btn.setOnAction(event -> {

                label_field.setText("0");
                this.str_num ="";
                this.first_num = 0;
                this.operation = 'A';

        });

    }
    void equalMethod() {
        float res = 0;
        switch (this.operation) {
            case '+':
                res= this.first_num + Float.parseFloat(this.str_num);
                break;
            case '-':
                res= this.first_num - Float.parseFloat(this.str_num);
                break;
            case '/':
                if(Integer.parseInt(this.str_num) != 0 )
                res= this.first_num / Float.parseFloat(this.str_num);
                else
                    res = 0;
                break;
            case '*':
                res= this.first_num * Float.parseFloat(this.str_num);
                break;
        }
        label_field.setText(Float.toString(res));
        this.str_num = "";
        this.operation = 'A';
        this.first_num = 0;
    }

     void mathActions(char operation) {
         if (this.operation != '+' && this.operation != '-'
                 && this.operation != '/' && this.operation != '*') {
             this.first_num = Float.parseFloat(this.str_num);
             label_field.setText(String.valueOf(operation));
             this.str_num = "";
             this.operation = operation;

         }
     }

    void addNumber(int number) {
        this.str_num += Integer.toString(number);
        label_field.setText(str_num);

    }
}
