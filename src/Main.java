import javax.swing.*;

public class Main {
    static Window window;
    public static void main(String[] args){

        window = new Window();
        window.frame.setVisible(true);
        window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.frame.setLocationRelativeTo(null);

    }
}
