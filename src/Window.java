import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Created by sergik on 03.09.2015.
 */
public class Window implements ActionListener, ItemListener{
     JFrame frame;
     private JButton find, clear, add, change, del, searchAll;
     private JTextField telNumber, organ, telKod, viddil, abonent, vuzol, stanNumber, uasNumber, tzmkNumber, gatewayNumber,
             mzNumber, pib, id;
     private JLabel telNum, org, kod, viddilLabel, abon, vuz, stNumber, uasNum, tzmkNum, gatewayNum, mzNum, pibLabel, idLabel;
     private JTable table;
     private JPanel panelButton, panelField, panelTable, panelCheckBox;
     private JCheckBox checkBoxRibalci, checkBoxBugru, checkBoxMPablivka, checkBoxKozievka, checkBoxOhturka,
             checkBoxGorod;
     private static final int MAX_LEN_NUMBER = 10;
     private static final int MAX_LEN_LETTER = 27;
    // private int resultFindTelNum;
     //private String resultFindOrg;

    public Window(){

        frame = new JFrame("База телефонних номерів");
        frame.setSize(935, 325);
        frame.setResizable(false);
        frame.setLayout(null);

/*-----------------------------------------------------*/
/*-----------------------------------------------------*/

        panelField = new JPanel();
        panelField.setBounds(10, 10, 907, 220);
        panelField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        panelField.setLayout(null);
        frame.add(panelField);
//
        telNum = new JLabel("Телефонний номер");
        telNum.setBounds(60, 10, 150, 30);
        panelField.add(telNum);
//
        telNumber = new JTextField(6){
            public void replaceSelection(String content) {
                Functions func = new Functions();
                super.replaceSelection(content);
                String text = getText();
                if (func.checkStringNum(text)){
                    if ((text.length()) > MAX_LEN_NUMBER){
                        setText(text.substring(0, MAX_LEN_NUMBER));
                    }
                }else {if(text.length() <= MAX_LEN_NUMBER) {
                    JOptionPane.showMessageDialog(null, "Введите числовое значение!!!");
                    setText(text.substring(0, text.length() - 1));
                }else {
                    setText(text.substring(0, text.length() - 1));
                }
                }
            }
        };
        telNumber.setBounds(5, 35, 222, 40);
        telNumber.setFont(new Font("Arial", Font.PLAIN, 40));
        panelField.add(telNumber);
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/


        org = new JLabel("Підприємство");
        org.setBounds(295, 10, 100, 30);
        panelField.add(org);

        organ = new JTextField(){
            public void replaceSelection(String content) {
                Functions func = new Functions();
                super.replaceSelection(content);
                String text = getText();
                if (func.checkStringLetter(text)){
                    if ((text.length()) > MAX_LEN_LETTER){
                        setText(text.substring(0, MAX_LEN_LETTER));
                    }
                }else {if(text.length() <= MAX_LEN_LETTER) {
                    JOptionPane.showMessageDialog(null, "ВВеден недопустимый символ!!!");
                    setText(text.substring(0, text.length() - 1));
                }else {
                    setText(text.substring(0, text.length() - 1));
                }
                }
            }
        };

        organ.setBounds(230, 35, 222, 40);
        organ.setFont(new Font("Arial", Font.PLAIN, 20));
        panelField.add(organ);
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/

        viddilLabel = new JLabel("Відділ");
        viddilLabel.setBounds(540, 10, 100, 30);
        panelField.add(viddilLabel);

        viddil = new JTextField();
        viddil.setBounds(455, 35, 222, 40);
        viddil.setFont(new Font("Arial", Font.PLAIN, 20));
        panelField.add(viddil);
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/

        abon = new JLabel("Абонент");
        abon.setBounds(760, 10, 100, 30);
        panelField.add(abon);

        abonent = new JTextField();
        abonent.setBounds(680, 35, 222, 40);
        abonent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelField.add(abonent);
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/
        vuz = new JLabel("Вузол");
        vuz.setBounds(95, 75, 150, 30);
        panelField.add(vuz);

        vuzol = new JTextField();
        vuzol.setBounds(5, 100, 222, 40);
        vuzol.setFont(new Font("Arial", Font.PLAIN, 20));
        panelField.add(vuzol);
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/

        stNumber = new JLabel("Станційний номер");
        stNumber.setBounds(285, 75, 150, 30);
        panelField.add(stNumber);

        stanNumber = new JTextField(){
            public void replaceSelection(String content) {
                Functions func = new Functions();
                super.replaceSelection(content);
                String text = getText();
                if (func.checkStringNum(text)){
                    if ((text.length()) > MAX_LEN_NUMBER){
                        setText(text.substring(0, MAX_LEN_NUMBER));
                    }
                }else {if(text.length() <= MAX_LEN_NUMBER) {
                    JOptionPane.showMessageDialog(null, "Введите числовое значение!!!");
                    setText(text.substring(0, text.length() - 1));
                }else {
                    setText(text.substring(0, text.length() - 1));
                }
                }
            }
        };
        stanNumber.setBounds(230, 100, 222, 40);
        stanNumber.setFont(new Font("Arial", Font.PLAIN, 40));
        panelField.add(stanNumber);
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/

        uasNum = new JLabel("УАС номер");
        uasNum.setBounds(530, 75, 150, 30);
        panelField.add(uasNum);

        uasNumber = new JTextField(){
            public void replaceSelection(String content) {
                Functions func = new Functions();
                super.replaceSelection(content);
                String text = getText();
                if (func.checkStringNum(text)){
                    if ((text.length()) > MAX_LEN_NUMBER){
                        setText(text.substring(0, MAX_LEN_NUMBER));
                    }
                }else {if(text.length() <= MAX_LEN_NUMBER) {
                    JOptionPane.showMessageDialog(null, "Введите числовое значение!!!");
                    setText(text.substring(0, text.length() - 1));
                }else {
                    setText(text.substring(0, text.length() - 1));
                }
                }
            }
        };
        uasNumber.setBounds(455, 100, 222, 40);
        uasNumber.setFont(new Font("Arial", Font.PLAIN, 40));
        panelField.add(uasNumber);
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/
        tzmkNum = new JLabel("ТЗМК номер");
        tzmkNum.setBounds(750, 75, 150, 30);
        panelField.add(tzmkNum);

        tzmkNumber = new JTextField(){
            public void replaceSelection(String content) {
                Functions func = new Functions();
                super.replaceSelection(content);
                String text = getText();
                if (func.checkStringNum(text)){
                    if ((text.length()) > MAX_LEN_NUMBER){
                        setText(text.substring(0, MAX_LEN_NUMBER));
                    }
                }else {if(text.length() <= MAX_LEN_NUMBER) {
                    JOptionPane.showMessageDialog(null, "Введите числовое значение!!!");
                    setText(text.substring(0, text.length() - 1));
                }else {
                    setText(text.substring(0, text.length() - 1));
                }
                }
            }
        };
        tzmkNumber.setBounds(680, 100, 222, 40);
        tzmkNumber.setFont(new Font("Arial", Font.PLAIN, 40));
        panelField.add(tzmkNumber);
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/
        gatewayNum = new JLabel("Шлюз номер");
        gatewayNum.setBounds(75, 140, 150, 30);
        panelField.add(gatewayNum);

        gatewayNumber = new JTextField(){
            public void replaceSelection(String content) {
                Functions func = new Functions();
                super.replaceSelection(content);
                String text = getText();
                if (func.checkStringNum(text)){
                    if ((text.length()) > MAX_LEN_NUMBER){
                        setText(text.substring(0, MAX_LEN_NUMBER));
                    }
                }else {if(text.length() <= MAX_LEN_NUMBER) {
                    JOptionPane.showMessageDialog(null, "Введите числовое значение!!!");
                    setText(text.substring(0, text.length() - 1));
                }else {
                    setText(text.substring(0, text.length() - 1));
                }
                }
            }
        };
        gatewayNumber.setBounds(5, 165, 222, 40);
        gatewayNumber.setFont(new Font("Arial", Font.PLAIN, 40));
        panelField.add(gatewayNumber);
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/
        mzNum = new JLabel("МЗ номер");
        mzNum.setBounds(310, 140, 180, 30);
        panelField.add(mzNum);

        mzNumber = new JTextField(){
            public void replaceSelection(String content) {
                Functions func = new Functions();
                super.replaceSelection(content);
                String text = getText();
                if (func.checkStringNum(text)){
                    if ((text.length()) > MAX_LEN_NUMBER){
                        setText(text.substring(0, MAX_LEN_NUMBER));
                    }
                }else {if(text.length() <= MAX_LEN_NUMBER) {
                    JOptionPane.showMessageDialog(null, "Введите числовое значение!!!");
                    setText(text.substring(0, text.length() - 1));
                }else {
                    setText(text.substring(0, text.length() - 1));
                }
                }
            }
        };
        mzNumber.setBounds(230, 165, 222, 40);
        mzNumber.setFont(new Font("Arial", Font.PLAIN, 40));
        panelField.add(mzNumber);
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/
        pibLabel = new JLabel("Прізвище Ім'я По-батькові");
        pibLabel.setBounds(550, 140, 180, 30);
        panelField.add(pibLabel);

        pib = new JTextField();
        pib.setBounds(455, 165, 350, 40);
        pib.setFont(new Font("Arial", Font.PLAIN, 20));
        panelField.add(pib);
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/
        idLabel = new JLabel("ID");
        idLabel.setBounds(850, 140, 180, 30);
        panelField.add(idLabel);

        id = new JTextField(){
            public void replaceSelection(String content) {
                Functions func = new Functions();
                super.replaceSelection(content);
                String text = getText();
                if (func.checkStringNum(text)){
                    if ((text.length()) > MAX_LEN_NUMBER){
                        setText(text.substring(0, MAX_LEN_NUMBER));
                    }
                }else {if(text.length() <= MAX_LEN_NUMBER) {
                    JOptionPane.showMessageDialog(null, "Введите числовое значение!!!");
                    setText(text.substring(0, text.length() - 1));
                }else {
                    setText(text.substring(0, text.length() - 1));
                }
                }
            }
        };
        id.setBounds(807, 165, 95, 40);
        id.setFont(new Font("Arial", Font.PLAIN, 40));
        panelField.add(id);


/*--------------------------------------------------------*/

/*-------------------- Check Box -------------------------*/
        panelCheckBox = new JPanel();
        panelCheckBox.setLayout(new FlowLayout());
        panelCheckBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        panelCheckBox.setBounds(20, 120, 600, 40);
        //frame.add(panelCheckBox);

        checkBoxOhturka = new JCheckBox("Охтирка");
        //checkBoxOhturka.setBounds(20, 5, 100, 20);
        checkBoxRibalci = new JCheckBox("Рибальцы");
        //checkBoxRibalci.setBounds(130,5,100,20);
        checkBoxBugru = new JCheckBox("Бугруватое");
        //checkBoxBugru.setBounds(240,5,100,20);
        checkBoxMPablivka = new JCheckBox("М.Павловка");
        //checkBoxMPablivka.setBounds(350,5,100,20);
        checkBoxKozievka = new JCheckBox("Козиевка");
       // checkBoxKozievka.setBounds(460, 5, 100, 20);
        checkBoxGorod = new JCheckBox("Город");
        //checkBoxKozievka.setBounds(460, 5, 100, 20);
/*-------------------Кнопки-------------------------*/

        panelButton = new JPanel();
        panelButton.setBounds(10, 235, 907, 40);
        panelButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        panelButton.setLayout(new FlowLayout());
        frame.add(panelButton);

        find = new JButton("Знайти");
       // find.setBounds(10, 10, 100, 30);
        panelButton.add(find);

        clear = new JButton("Очистити");
        //clear.setBounds(10, 45, 100, 30);
        panelButton.add(clear);

        add = new JButton("Добавити");
        //add.setBounds(10, 80, 1000, 30);
        panelButton.add(add);

        change = new JButton("Редактувати");
        //change.setBounds(10, 80, 100, 30);
        panelButton.add(change);

        del = new JButton("Видалити");
        //del.setBounds(10, 80, 100, 30);
        panelButton.add(del);

        searchAll = new JButton("Знайти всі записи");
        //del.setBounds(10, 80, 100, 30);
        panelButton.add(searchAll);
/*---------------------------------------------------*/

/*-------------------Таблица--------------------------------*/
        panelTable = new JPanel();
        panelTable.setBounds(10, 280, 907, 10);
        panelTable.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEmptyBorder(25, 25, 25, 25)));
        panelTable.setLayout(null);
        frame.add(panelTable);
        //TableModel tm = new TableModel();

/*---------------------------------------------------*/

/*----------------Подключение к БД-------------------*/
      //  ConnectDB connectDB = new ConnectDB();
      //  tm.addDate(connectDB);
/*---------------------------------------------------*/




        panelCheckBox.add(checkBoxOhturka);
        panelCheckBox.add(checkBoxRibalci);
        panelCheckBox.add(checkBoxBugru);
        panelCheckBox.add(checkBoxMPablivka);
        panelCheckBox.add(checkBoxKozievka);
        panelCheckBox.add(checkBoxGorod);

        ButtonGroup group = new ButtonGroup();
        group.add(checkBoxOhturka);
        group.add(checkBoxRibalci);
        group.add(checkBoxBugru);
        group.add(checkBoxMPablivka);
        group.add(checkBoxKozievka);
        group.add(checkBoxGorod);

        checkBoxOhturka.addItemListener(this);
        checkBoxRibalci.addItemListener(this);
        checkBoxBugru.addItemListener(this);
        checkBoxMPablivka.addItemListener(this);
        checkBoxKozievka.addItemListener(this);
        checkBoxGorod.addItemListener(this);

        find.addActionListener(this);
        clear.addActionListener(this);
        add.addActionListener(this);
        change.addActionListener(this);
        del.addActionListener(this);
        searchAll.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ConnectDB connectDB = new ConnectDB();
        Functions func = new Functions();
/*---------------- Поиск по БД -------------------*/
        if(e.getSource() == find){
            func.search(telNumber, organ, viddil, abonent, vuzol, stanNumber, uasNumber, tzmkNumber, gatewayNumber,
                    mzNumber, pib);
            JFrame frameTable = new JFrame("Результати пошуку");
            frameTable.setBounds(10, 10, 1000, 300);

            table = new JTable(func.tableModel);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            TableColumn columnTelId = table.getColumnModel().getColumn(0);
            TableColumn columnTelNum = table.getColumnModel().getColumn(1);
            TableColumn columnOrg = table.getColumnModel().getColumn(2);
            TableColumn columnViddil = table.getColumnModel().getColumn(3);
            TableColumn columnAbon = table.getColumnModel().getColumn(4);
            TableColumn columnVuzol = table.getColumnModel().getColumn(5);
            TableColumn columnStan = table.getColumnModel().getColumn(6);
            TableColumn columnUas = table.getColumnModel().getColumn(7);
            TableColumn columnTzmk = table.getColumnModel().getColumn(8);
            TableColumn columnGateway = table.getColumnModel().getColumn(9);
            TableColumn columnMZ = table.getColumnModel().getColumn(10);
            TableColumn columnPib = table.getColumnModel().getColumn(11);
            columnTelId.setPreferredWidth(30);
            columnOrg.setPreferredWidth(100);
            columnTelNum.setPreferredWidth(30);
            columnViddil.setPreferredWidth(120);
            columnAbon.setPreferredWidth(150);
            columnVuzol.setPreferredWidth(90);
            columnStan.setPreferredWidth(50);
            columnUas.setPreferredWidth(66);
            columnTzmk.setPreferredWidth(50);
            columnGateway.setPreferredWidth(50);
            columnMZ.setPreferredWidth(50);
            columnPib.setPreferredWidth(198);


            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(10, 10, 890, 280);
            frameTable.add(jsp);
            frameTable.setVisible(true);
/*---------------- Очистка полей ввода -------------------*/
        }else if(e.getSource() == clear){
            telNumber.setText(null);
            organ.setText(null);
            viddil.setText(null);
            abonent.setText(null);
            vuzol.setText(null);
            stanNumber.setText(null);
            uasNumber.setText(null);
            tzmkNumber.setText(null);
            gatewayNumber.setText(null);
            mzNumber.setText(null);
            pib.setText(null);
            id.setText(null);
/*----------------Добавление значений в БД-------------------*/
        }else if(e.getSource() == add){
            try {
                String getTelNumber = telNumber.getText();
                String getOrgan = organ.getText();
                String getAbonent = abonent.getText();
                String getViddil = viddil.getText();
                String getVuzol = vuzol.getText();
                String getstanNumber = stanNumber.getText();
                String getUasNumber = uasNumber.getText();
                String gettzmkNumber = tzmkNumber.getText();
                String getGatewayNumber = gatewayNumber.getText();
                String getMzNumber = mzNumber.getText();
                String getPib = pib.getText();

                if(getVuzol.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Заповніть поле \"Вузол\"");
                    return;
                }
                String sql = "INSERT INTO PHONE(TEL_NUMBER, ORG_NAME, VIDDIL, ABONENT, VUZOL, STAN_NUMBER, UAS_NUMBER, TZMK," +
                        " GATEWAY_NUMBER, MZ_NUMBER, PIB) " + "VALUES ('"+getTelNumber+"', '"+getOrgan+"', '"+getViddil+"', " +
                        " '"+getAbonent+"', '"+getVuzol+"', '"+getstanNumber+"', '"+getUasNumber+"', '"+gettzmkNumber+"'," +
                        " '"+getGatewayNumber+"', '"+getMzNumber+"', '"+getPib+"')";

                connectDB.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Значення добавлено");
                connectDB.statement.close();
                connectDB.connection.close();
            }catch (SQLException a){
                JOptionPane.showMessageDialog(null, "Помилка добавлення значення! SQLException");
            }

        }else if (e.getSource() == change){
            func.change(telNumber, organ, viddil, abonent, vuzol, stanNumber, uasNumber, tzmkNumber, gatewayNumber,
                    mzNumber, pib, id);
            System.out.print("111");
        }
        else if(e.getSource() == del) {
            try {
                int getId = Integer.valueOf(id.getText());
                String sql = "DELETE FROM PHONE WHERE ID LIKE " + getId + "";
                connectDB.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Запис з ID = "+getId+" видалений");
                connectDB.statement.close();
                connectDB.connection.close();
            }catch (SQLException s){
                JOptionPane.showMessageDialog(null, "Помилка видалення! SQLException");
            }catch (NumberFormatException z){
                JOptionPane.showMessageDialog(null, "Помилка видалення! Введіть ID");
            }
        }else if(e.getSource() == searchAll) {
            func.searchAll();
            JFrame frameTable = new JFrame("Результати пошуку всіх записів");
            frameTable.setBounds(10, 10, 1000, 300);

            table = new JTable(func.tableModel);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            TableColumn columnTelId = table.getColumnModel().getColumn(0);
            TableColumn columnTelNum = table.getColumnModel().getColumn(1);
            TableColumn columnOrg = table.getColumnModel().getColumn(2);
            TableColumn columnViddil = table.getColumnModel().getColumn(3);
            TableColumn columnAbon = table.getColumnModel().getColumn(4);
            TableColumn columnVuzol = table.getColumnModel().getColumn(5);
            TableColumn columnStan = table.getColumnModel().getColumn(6);
            TableColumn columnUas = table.getColumnModel().getColumn(7);
            TableColumn columnTzmk = table.getColumnModel().getColumn(8);
            TableColumn columnGateway = table.getColumnModel().getColumn(9);
            TableColumn columnMZ = table.getColumnModel().getColumn(10);
            TableColumn columnPib = table.getColumnModel().getColumn(11);
            columnTelId.setPreferredWidth(30);
            columnOrg.setPreferredWidth(100);
            columnTelNum.setPreferredWidth(30);
            columnViddil.setPreferredWidth(120);
            columnAbon.setPreferredWidth(150);
            columnVuzol.setPreferredWidth(90);
            columnStan.setPreferredWidth(50);
            columnUas.setPreferredWidth(50);
            columnTzmk.setPreferredWidth(50);
            columnGateway.setPreferredWidth(50);
            columnMZ.setPreferredWidth(50);
            columnPib.setPreferredWidth(198);

            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(10, 10, 890, 280);
            frameTable.add(jsp);
            frameTable.setVisible(true);
        }

/*-------------------------------------------------------------------------------------*/

    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getItem() == checkBoxOhturka){
            telKod.setText("840");
        }else if(e.getItem() == checkBoxRibalci){
            telKod.setText("843");
        }else if(e.getItem() == checkBoxBugru){
            telKod.setText("842");
        }else if(e.getItem() == checkBoxMPablivka){
            telKod.setText("844");
        }else if(e.getItem() == checkBoxKozievka){
            telKod.setText("843");
        }else if(e.getItem() == checkBoxGorod){
            telKod.setText("9");
        }

        telNumber.requestFocus();
    }
}
