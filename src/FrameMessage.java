import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMessage implements ActionListener {
    private JFrame frameMessage;
    private JPanel panelMessage, panelButton;
    private JLabel textMessage;
    private JButton buttonOK, buttonCancel;
    String buttonClick;

    FrameMessage(String name, String Message, String buttonClick){
        this.buttonClick = buttonClick;
        frameMessage = new JFrame(name);
        frameMessage.setSize(250, 170);
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

        buttonOK.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Functions functions = new Functions();
        if(e.getSource() == buttonOK){
         this.frameMessage.setVisible(false);
            if(buttonClick == "add"){
                functions.addRecord();
            }else if(buttonClick == "clear"){
                functions.clearFields();
            }else if(buttonClick == "change"){
                functions.change(Main.window.telNumber, Main.window.organ, Main.window.viddil, Main.window.abonent,
                        Main.window.vuzol, Main.window.stanNumber, Main.window.uasNumber, Main.window.tzmkNumber,
                        Main.window.gatewayNumber, Main.window.mzNumber, Main.window.pib, Main.window.id);
            }
        }else if(e.getSource() == buttonCancel){
            this.frameMessage.setVisible(false);

        }
    }
}
