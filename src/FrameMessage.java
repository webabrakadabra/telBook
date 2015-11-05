import javax.swing.*;
import java.awt.*;

/**
 * Created by Ser on 05.11.2015.
 */
public class FrameMessage {
    private JFrame frameMessage;
    private JPanel panelMessage, panelButton;
    private JLabel textMessage;
    private JButton buttonOK, buttonCancel;



    FrameMessage(String name, String Message){
        frameMessage = new JFrame(name);
        frameMessage.setSize(250, 170);
        frameMessage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMessage.setResizable(false);
        frameMessage.setLayout(null);
        frameMessage.setLocationRelativeTo(null);

        panelMessage = new JPanel();
        panelMessage.setLayout(new GridBagLayout());
        panelMessage.setBounds(1, 1, 242, 80);
        frameMessage.add(panelMessage);
        textMessage = new JLabel(Message);
        panelMessage.add(textMessage);
        panelButton = new JPanel();
        panelButton.setBounds(1, 80, 242, 60);
        frameMessage.add(panelButton);
        buttonOK = new JButton("Підтвердити");
        panelButton.add(buttonOK);
        buttonCancel = new JButton("Скасувати");
        panelButton.add(buttonCancel);
        frameMessage.setVisible(true);
    }

    public static void main(String[] args){
        FrameMessage frame = new FrameMessage("Окно", "wwewewew");
    }

}
