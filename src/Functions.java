import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Functions {
    TableModel tableModel;
    ConnectDB connectDB;
    String resultFindId, resultFindTelNum, resultFindOrg, resultFindViddil, resultFindAbonent, resultFindVuzol,
            resultFindStan, resultFindUas, resultFindTzmk, resultFindGateway, resultFindMZ, resultFindPib,
            getTelNumber, getOrgan, getViddil, getAbonent, getVuzol, getStan, getUas, getTzmk, getGateway, getMZ,
            getPib, getID, getKodNumber, sql;
    ResultSet rs;

    public void searchOrg(String sql){
        try {
            rs = connectDB.statement.executeQuery(sql);
            while (rs.next()){
                resultFindTelNum = rs.getString(1);
                resultFindOrg = rs.getString(2);
                resultFindViddil = rs.getString(3);
                resultFindAbonent = rs.getString(4);
                resultFindVuzol = rs.getString(5);
                resultFindStan = rs.getString(6);
                resultFindTzmk = rs.getString(7);
                resultFindGateway = rs.getString(8);
                resultFindPib = rs.getString(9);
                resultFindUas = rs.getString(10);
                resultFindMZ = rs.getString(11);
                resultFindId = rs.getString(12);
                String[] colWords = resultFindOrg.split(" ");
                String[] searchWords = getOrgan.split(" ");
                label: for (int i = 0; i < searchWords.length; i++){
                    for (int k = 0; k < colWords.length; k++){
                        if(searchWords[i].equals(colWords[k])){
                            String [] row = {
                                    resultFindId,
                                    resultFindTelNum,
                                    resultFindOrg,
                                    resultFindViddil,
                                    resultFindAbonent,
                                    resultFindVuzol,
                                    resultFindStan,
                                    resultFindUas,
                                    resultFindTzmk,
                                    resultFindGateway,
                                    resultFindMZ,
                                    resultFindPib
                            };
                            tableModel.addData(row);
                            break label;

                        }

                    }

                }

            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Помилка функції searchOrg ");
        }
    }

    public void searchPib(String sql){
        try {
        rs = connectDB.statement.executeQuery(sql);
        while (rs.next()){
            resultFindTelNum = rs.getString(1);
            resultFindOrg = rs.getString(2);
            resultFindViddil = rs.getString(3);
            resultFindAbonent = rs.getString(4);
            resultFindVuzol = rs.getString(5);
            resultFindStan = rs.getString(6);
            resultFindTzmk = rs.getString(7);
            resultFindGateway = rs.getString(8);
            resultFindPib = rs.getString(9);
            resultFindUas = rs.getString(10);
            resultFindMZ = rs.getString(11);
            resultFindId = rs.getString(12);
            String[] colWords = resultFindPib.split(" ");
            String[] searchWords = getPib.split(" ");

            label: for (int i = 0; i < searchWords.length; i++){
                for (int k = 0; k < colWords.length; k++){
                    if(searchWords[i].equals(colWords[k])){
                        String [] row = {
                                resultFindId,
                                resultFindTelNum,
                                resultFindOrg,
                                resultFindViddil,
                                resultFindAbonent,
                                resultFindVuzol,
                                resultFindStan,
                                resultFindUas,
                                resultFindTzmk,
                                resultFindGateway,
                                resultFindMZ,
                                resultFindPib
                        };
                        tableModel.addData(row);
                        break label;

                    }

                }

            }

        }

    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Помилка функцій searchPib ");
    }
    }

    public void createMassive(String sql){
        tableModel = new TableModel();

        try {
            rs = connectDB.statement.executeQuery(sql);
            while (rs.next()) {
                resultFindTelNum = rs.getString(1);
                resultFindOrg = rs.getString(2);
                resultFindViddil = rs.getString(3);
                resultFindAbonent = rs.getString(4);
                resultFindVuzol = rs.getString(5);
                resultFindStan = rs.getString(6);
                resultFindTzmk = rs.getString(7);
                resultFindGateway = rs.getString(8);
                resultFindPib = rs.getString(9);
                resultFindUas = rs.getString(10);
                resultFindMZ = rs.getString(11);
                resultFindId = rs.getString(12);


                String [] row = {
                        resultFindId,
                        resultFindTelNum,
                        resultFindOrg,
                        resultFindViddil,
                        resultFindAbonent,
                        resultFindVuzol,
                        resultFindStan,
                        resultFindUas,
                        resultFindTzmk,
                        resultFindGateway,
                        resultFindMZ,
                        resultFindPib
                };
                tableModel.addData(row);
            }
            connectDB.statement.close();
            connectDB.connection.close();

        }catch (SQLException a) {
            JOptionPane.showMessageDialog(null, "Помилка функції searchPib!");
        }
    }

    public void search(JTextField telNumber, JTextField organ, JTextField viddil, JTextField abonent, JTextField vuzol,
                    JTextField stanNumber, JTextField uasNumber, JTextField tzmkNumber, JTextField gatewayNumber,
                    JTextField mzNumber, JTextField pib) {
        try {
            connectDB = new ConnectDB();
            tableModel = new TableModel();

            getTelNumber = telNumber.getText();
            getOrgan = organ.getText();
            getViddil = viddil.getText();
            getAbonent = abonent.getText();
            getVuzol = vuzol.getText();
            getStan = stanNumber.getText();
            getUas = uasNumber.getText();
            getTzmk = tzmkNumber.getText();
            getGateway = gatewayNumber.getText();
            getMZ = mzNumber.getText();
            getPib = pib.getText();

            if (!getTelNumber.isEmpty()) {
                sql = "SELECT * FROM PHONE WHERE TEL_NUMBER LIKE '" + getTelNumber + "' ";
                createMassive(sql);
            } else if (!getOrgan.isEmpty()) {
                sql = "SELECT * FROM PHONE";
                searchOrg(sql);
            } else if (!getViddil.isEmpty()) {
                sql = "SELECT * FROM PHONE WHERE VIDDIL LIKE'" + getViddil + "' ";
                createMassive(sql);
            } else if (!getAbonent.isEmpty()) {
                sql = "SELECT * FROM PHONE WHERE ABONENT LIKE'" + getAbonent + "' ";
                createMassive(sql);
            } else if (!getVuzol.isEmpty()) {
                sql = "SELECT * FROM PHONE WHERE VUZOL LIKE'" + getVuzol + "' ";
                createMassive(sql);
            } else if (!getStan.isEmpty()) {
                sql = "SELECT * FROM PHONE WHERE STAN_NUMBER LIKE'" + getStan + "' ";
                createMassive(sql);
            } else if (!getUas.isEmpty()) {
                sql = "SELECT * FROM PHONE WHERE UAS_NUMBER LIKE'" + getUas + "' ";
                createMassive(sql);
            } else if (!getTzmk.isEmpty()) {
                sql = "SELECT * FROM PHONE WHERE TZMK LIKE'" + getTzmk + "' ";
                createMassive(sql);
            } else if (!getGateway.isEmpty()) {
                sql = "SELECT * FROM PHONE WHERE GATEWAY_NUMBER LIKE'" + getGateway + "' ";
                createMassive(sql);
            } else if (!getMZ.isEmpty()) {
                sql = "SELECT * FROM PHONE WHERE MZ_NUMBER LIKE'" + getMZ + "' ";
                createMassive(sql);
            } else if (!getPib.isEmpty()) {
                sql = "SELECT * FROM PHONE";
                searchPib(sql);
            } else {
                JOptionPane.showMessageDialog(null, "Помилка пошуку!");
            }
            connectDB.statement.close();
            connectDB.connection.close();


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Помилка функції search!");
        }
    }


    public void searchAll(){
        try {
            connectDB = new ConnectDB();
            tableModel = new TableModel();

            sql = "SELECT * FROM PHONE";
            rs = connectDB.statement.executeQuery(sql);
            while (rs.next()) {
                resultFindTelNum = rs.getString(1);
                resultFindOrg = rs.getString(2);
                resultFindViddil = rs.getString(3);
                resultFindAbonent = rs.getString(4);
                resultFindVuzol = rs.getString(5);
                resultFindStan = rs.getString(6);
                resultFindTzmk = rs.getString(7);
                resultFindGateway = rs.getString(8);
                resultFindPib = rs.getString(9);
                resultFindUas = rs.getString(10);
                resultFindMZ = rs.getString(11);
                resultFindId = rs.getString(12);


                String [] row = {
                        resultFindId,
                        resultFindTelNum,
                        resultFindOrg,
                        resultFindViddil,
                        resultFindAbonent,
                        resultFindVuzol,
                        resultFindStan,
                        resultFindUas,
                        resultFindTzmk,
                        resultFindGateway,
                        resultFindMZ,
                        resultFindPib
                };
                tableModel.addData(row);
            }
            connectDB.statement.close();
            connectDB.connection.close();

        }catch (SQLException a) {
            JOptionPane.showMessageDialog(null, "Помилка функції searchAll!");
        }
    }


    /*-----------Проверка на ввод чисел в поле Телефонный номер------------*/
    public boolean checkStringNum(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }
    /*-----------Проверка на ввод чисел и кирилици------------*/
    public static boolean checkStringLetter(String string) {
        if (string == null) return false;
        return string.matches("^[\\sа-яА-ЯёЁa0-9]+$");
    }

    public void change(JTextField telNumber, JTextField organ, JTextField viddil, JTextField abonent, JTextField vuzol,
                       JTextField stanNumber, JTextField uasNumber, JTextField tzmkNumber, JTextField gatewayNumber,
                       JTextField mzNumber, JTextField pib, JTextField id){
        try{
            connectDB = new ConnectDB();
            getTelNumber = telNumber.getText();
            getOrgan = organ.getText();
            getViddil = viddil.getText();
            getAbonent = abonent.getText();
            getVuzol = vuzol.getText();
            getStan = stanNumber.getText();
            getUas = uasNumber.getText();
            getTzmk = tzmkNumber.getText();
            getGateway = gatewayNumber.getText();
            getMZ = mzNumber.getText();
            getPib = pib.getText();
            getID = id.getText();

            sql = "UPDATE PHONE SET TEL_NUMBER='"+getTelNumber+"', ORG_NAME='"+getOrgan+"', VIDDIL='"+getViddil+"', " +
                    "ABONENT='"+getAbonent+"', VUZOL='"+getVuzol+"', STAN_NUMBER='"+getStan+"', UAS_NUMBER='"+getUas+"', " +
                    "TZMK='"+getTzmk+"', GATEWAY_NUMBER='"+getGateway+"', MZ_NUMBER='"+getMZ+"', PIB='"+getPib+"' WHERE ID='"+getID+"'";
            connectDB.statement.executeUpdate(sql);

            connectDB.statement.close();
            connectDB.connection.close();

        }catch (Exception e){

        }

    }
    public void addRecord(){
        ConnectDB connectDB = new ConnectDB();
                    try {
                String getTelNumber = Main.window.telNumber.getText();
                String getOrgan = Main.window.organ.getText();
                String getAbonent = Main.window.abonent.getText();
                String getViddil = Main.window.viddil.getText();
                String getVuzol = Main.window.vuzol.getText();
                String getstanNumber = Main.window.stanNumber.getText();
                String getUasNumber = Main.window.uasNumber.getText();
                String gettzmkNumber = Main.window.tzmkNumber.getText();
                String getGatewayNumber = Main.window.gatewayNumber.getText();
                String getMzNumber = Main.window.mzNumber.getText();
                String getPib = Main.window.pib.getText();

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

    }
    public void clearFields(){
        Main.window.telNumber.setText(null);
        Main.window.organ.setText(null);
        Main.window.viddil.setText(null);
        Main.window.abonent.setText(null);
        Main.window.vuzol.setText(null);
        Main.window.stanNumber.setText(null);
        Main.window.uasNumber.setText(null);
        Main.window.tzmkNumber.setText(null);
        Main.window.gatewayNumber.setText(null);
        Main.window.mzNumber.setText(null);
        Main.window.pib.setText(null);
        Main.window.id.setText(null);
    }
    public void pushFields(){
//        try{
//            ConnectDB connectDB = new ConnectDB();
            //String setTelNumber = "11111";
           Main.window.telNumber.setText("1111111111");
//            String getOrgan = Main.window.organ.getText();
//            String getAbonent = Main.window.abonent.getText();
//            String getViddil = Main.window.viddil.getText();
//            String getVuzol = Main.window.vuzol.getText();
//            String getstanNumber = Main.window.stanNumber.getText();
//            String getUasNumber = Main.window.uasNumber.getText();
//            String gettzmkNumber = Main.window.tzmkNumber.getText();
//            String getGatewayNumber = Main.window.gatewayNumber.getText();
//            String getMzNumber = Main.window.mzNumber.getText();
//            String getPib = Main.window.pib.getText();
          String getId = Main.window.id.getText();


            //String sql = "SELECT TEL_NUMBER='"+setTelNumber+"' FROM PHONE WHERE ID = '"+getId+"'" ;

          //  rs = connectDB.statement.executeQuery(sql);
//            JOptionPane.showMessageDialog(null, "Значення добавлено");
//            connectDB.statement.close();
//            connectDB.connection.close();
//
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Такого ID не існує!");
//        }
   }
}

