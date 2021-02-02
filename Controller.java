package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;


public class Controller {
    @FXML
    Label i1,i2,i3,i4;
    @FXML
    TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    @FXML
    TextArea ta1,ta2;
    @FXML
    Button checkout,btn1,homebtn,order;

    BufferedReader reader;
    BufferedWriter writer;

    public Controller(){
        try {
            Socket socket = new Socket("127.0.0.1", 5000);

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void ac1btn(){

        try{
            Thread thread = new Thread()
            {
                public void run() {

                    try {
                        String a = i1.getText();
                        String b = tf1.getText();

                        writer.write("Chicken Burger\n");


                        writer.write(a);

                        writer.newLine();
                        writer.write(b);
                        writer.newLine();

                        writer.flush();

                        String s = reader.readLine();
                        ta1.setText(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    }


        };
        thread.start();

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    @FXML
    void ac2btn(){
        String a = i2.getText();
        String b = tf2.getText();

        try{


            writer.write("Beef Burger\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.flush();

            String s = reader.readLine();
            ta1.setText(s);

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void ac3btn(){
        String a = i3.getText();
        String b = tf3.getText();

        try{
            writer.write("Chicken Pizza\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.flush();

            String s = reader.readLine();
            ta1.setText(s);

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void ac4btn(){
        String a = i4.getText();
        String b = tf4.getText();

        try{


            writer.write("Wonton\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.flush();

            String s = reader.readLine();
            ta1.setText(s);

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void cartbtn(){
        try {
            writer.write("Cart\n");
            writer.flush();
            String line;
            ta1.setText("");
            while ((line = reader.readLine()) != null) {
                if (line.equals("<eof>")) break;
                ta1.appendText(line + "\n");

            }


        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    void checkoutbtn() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
        Stage window = (Stage) checkout.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
        String a = tf5.getText();
        String b = tf6.getText();
        String c = tf7.getText();
        try{
            writer.write("Checkout\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.write(c);
            writer.newLine();

            writer.flush();


        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        try {
            String e = tf5.getText();
            String p = tf6.getText();
            String q=tf7.getText();
            FileWriter fileWriter = new FileWriter("info.txt",true);
            BufferedWriter write = new BufferedWriter(fileWriter);
            PrintWriter writer = new PrintWriter(write);
            writer.println(e + " " + p+" "+q);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void orderbtn(){
        ta2.setText("Thank You For Your Order.Your order is now under processing now");
    }
    @FXML
    void btnclick() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
        Stage window = (Stage) checkout.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
    }


    }


