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
            case 1: return "Òåë.";
            case 2: return "Ï³äïðèºìñòâî";
            case 3: return "Â³ää³ë";
            case 4: return "Àáîíåíò";
            case 5: return "Âóçîë";
            case 6: return "Ñòàíö³éíèé íîìåð";
            case 7: return "ÓÀÑ íîìåð";
            case 8: return "ÒÇÌÊ";
            case 9: return "Øëþç";
            case 10: return "ÌÇ";
            case 11: return "Ï²Á";
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
