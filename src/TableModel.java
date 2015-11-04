import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private ArrayList<String[]> dataArrayList;


    public TableModel(){
        dataArrayList = new ArrayList<String[]>();
        for (int i = 0; i < dataArrayList.size(); i++){
            dataArrayList.add(new String[getColumnCount()]);
        }
    }

    @Override
    public int getRowCount() {
    return dataArrayList.size();
}

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "ID";
            case 1: return "���.";
            case 2: return "ϳ���������";
            case 3: return "³���";
            case 4: return "�������";
            case 5: return "�����";
            case 6: return "���������� �����";
            case 7: return "��� �����";
            case 8: return "����";
            case 9: return "����";
            case 10: return "��";
            case 11: return "ϲ�";
        }
        return "";
    }
    public void     addData(String[] row){
        String []rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String []rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }
}
