package Socket;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
//www.ridvancakir.com.tr
public class Server {
    Server() throws IOException {

        JButton button = new JButton("Send");
        JTextField textField = new JTextField(20);
        JTextArea textArea = new JTextArea(8,20);
        JFrame frame = new JFrame("Server");
        frame.setLayout(new FlowLayout());
        frame.add(textArea);
        frame.add(textField);
        frame.add(button);
        frame.setSize(350,300);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ServerSocket server = new ServerSocket(3000);
        System.out.println("Server  ready for chatting");
        Socket s = server.accept( );
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        button.addActionListener(e -> {
            String sendMessage = textField.getText();
            try {
                dos.writeUTF(sendMessage);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        while(true){
            String receiveMessage=dis.readUTF();
            textArea.append(receiveMessage+"\n");
            System.out.println(receiveMessage);
        }
    }
    public static void main(String[] args) throws Exception {
        new Server();
    }
}                        