import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Waiting to connect");

            Socket socket = serverSocket.accept();
            System.out.println("Connected");

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            String line;
            StringBuilder checkout = new StringBuilder();

            while ((line = reader.readLine()) != null){
                try {
                    if (line.equals("Chicken Burger")) {
                        String a = reader.readLine();
                        String b = reader.readLine();
                        int c = Integer.parseInt(b) * 200;

                        String s = a + " " + "Price:" + c + "\n";

                        checkout.append(s);

                        writer.write(s);
                        writer.flush();
                    } else if (line.equals("Beef Burger")) {
                        String a = reader.readLine();
                        String b = reader.readLine();
                        int c = Integer.parseInt(b) * 300;

                        String s = a + " " + "Price:" + c + "\n";

                        checkout.append(s);

                        writer.write(s);
                        writer.flush();
                    } else if (line.equals("Chicken Pizza")) {
                        String a = reader.readLine();
                        String b = reader.readLine();
                        int c = Integer.parseInt(b) * 320;

                        String s = a + " " + "Price:" + c + "\n";

                        checkout.append(s);

                        writer.write(s);
                        writer.flush();
                    } else if (line.equals("Wonton")) {
                        String a = reader.readLine();
                        String b = reader.readLine();
                        int c = Integer.parseInt(b) * 150;

                        String s = a + " " + "Price:" + c + "\n";

                        checkout.append(s);

                        writer.write(s);
                        writer.flush();

                    } else if (line.equals("Cart")) {
                        String curHistory = checkout.toString();
                        writer.write(curHistory + "<eof>\n");
                        writer.flush();
                    } else if (line.equals("Checkout")) {
                        String a = reader.readLine();
                        String b = reader.readLine();
                        String c= reader.readLine();
                        System.out.println(a);
                        System.out.println(b);
                        System.out.println(c);

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            writer.close();
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
