
package restaurantorderingandpayment;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class OrderTableModel extends AbstractTableModel {

    protected static final String COLUMN_NAMES[] = {"Item", "Quantity", "Unit Price", "Total"};
    protected static final Class COLUMN_TYPES[] = {String.class, int.class, double.class, double.class};

    private List<Order> orders;
        
    public OrderTableModel() {
        orders = new ArrayList<>(25);
        
    }

    public void add(Order order) {
        orders.add(order);
        fireTableRowsInserted(orders.size() -1  , orders.size() -1 );
    }

    public void remove(Order order) {
        int row = orders.indexOf(order);
        if (row >= 0) {
            orders.remove(order);
            fireTableRowsDeleted(row, row);
            
        }
    }
   

    public void update(Order order) {
        int row = orders.indexOf(order);
        if (row >= 0) {
            fireTableRowsUpdated(row, row);
        }
    }
    public void removeRowAt(int row) {
    orders.remove(row);
    fireTableRowsDeleted(row, row);
}

    public Order getOrderAt(int row) {
        return orders.get(row);
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        Order order = getOrderAt(rowIndex);
        switch (columnIndex) {
            case 0:
                value = order.getItem();
                break;
            case 1:
                value = order.getQuanity();
                break;
            case 2:
                value = order.getUnitPrice();
                break;
            case 3:
                value = order.getTotalPrice();
                break;
        }
        return value;
    }

}