package Socket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
//www.ridvancakir.com.tr
public class Client {
    Client() throws IOException {

        JButton button = new JButton("Send");
        JTextField textField = new JTextField(20);
        JTextArea textArea = new JTextArea(8,20);
        JFrame frame = new JFrame("Client");
        frame.setLayout(new FlowLayout());
        frame.add(textArea);
        frame.add(textField);
        frame.add(button);
        frame.setSize(350,300);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Socket s = new Socket("127.0.0.1", 3000);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());
        System.out.println("Start the chitchat, type and press Enter key");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        button.addActionListener(e -> {
            String sendMessage = textField.getText();
            try {
                dos.writeUTF(sendMessage);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        while(true)
        {
            String receiveMessage = dis.readUTF();
            textArea.append(receiveMessage +"\n");
            System.out.println(receiveMessage);
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Client();
    }
}                        