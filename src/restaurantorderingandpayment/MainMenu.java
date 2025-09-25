
package restaurantorderingandpayment;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterAbortException;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import static java.lang.Thread.sleep;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Jerickson Mayor
 */
public class MainMenu extends javax.swing.JFrame {
        // fields
         private Point initialClick;
         boolean isThereAnyRowSelected;
         int range;
         Double bHeight;
         boolean isLoadingDone = false;
         boolean isLoadingDone2 = false;
       
        
         
    public MainMenu() {
        initComponents();

        
        
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/restaurantorderingandpayment/images/flaticon2.png")));
((AbstractDocument)QuantityUpdate.getDocument()).setDocumentFilter(new DocumentFilter(){
        Pattern regEx = Pattern.compile("\\d*");

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {          
            Matcher matcher = regEx.matcher(text);
            if(!matcher.matches()){
                Toolkit.getDefaultToolkit().beep();
                return;
                
            }
            super.replace(fb, offset, length, text, attrs);
        }
    });
         
       //AmaEBi
  AmaEbiQuantity.setOpaque(false);
        AmaEbiQuantity.getEditor().setOpaque(false);
        ((JSpinner.NumberEditor)AmaEbiQuantity.getEditor()).getTextField().setOpaque(false);
AmaEbiQuantity.getEditor().getComponent(0).setBackground(new java.awt.Color(0, 0, 0, 0));
AmaEbiQuantity.getEditor().getComponent(0).setForeground(new java.awt.Color(255, 255, 255));
//Kani
KaniQuantity.setOpaque(false);
        KaniQuantity.getEditor().setOpaque(false);
        ((JSpinner.NumberEditor)KaniQuantity.getEditor()).getTextField().setOpaque(false);
KaniQuantity.getEditor().getComponent(0).setBackground(new java.awt.Color(0, 0, 0, 0));
KaniQuantity.getEditor().getComponent(0).setForeground(new java.awt.Color(255, 255, 255));
// Tamago
TamagoQuantity.setOpaque(false);
        TamagoQuantity.getEditor().setOpaque(false);
        ((JSpinner.NumberEditor)TamagoQuantity.getEditor()).getTextField().setOpaque(false);
TamagoQuantity.getEditor().getComponent(0).setBackground(new java.awt.Color(0, 0, 0, 0));
TamagoQuantity.getEditor().getComponent(0).setForeground(new java.awt.Color(255, 255, 255));
//Aburi
AburiQuantity.setOpaque(false);
        AburiQuantity.getEditor().setOpaque(false);
        ((JSpinner.NumberEditor)AburiQuantity.getEditor()).getTextField().setOpaque(false);
AburiQuantity.getEditor().getComponent(0).setBackground(new java.awt.Color(0, 0, 0, 0));
AburiQuantity.getEditor().getComponent(0).setForeground(new java.awt.Color(255, 255, 255));
// Saki
SakiQuantity.setOpaque(false);
        SakiQuantity.getEditor().setOpaque(false);
        ((JSpinner.NumberEditor)SakiQuantity.getEditor()).getTextField().setOpaque(false);
SakiQuantity.getEditor().getComponent(0).setBackground(new java.awt.Color(0, 0, 0, 0));
SakiQuantity.getEditor().getComponent(0).setForeground(new java.awt.Color(255, 255, 255));
//Maki
MakiQuantity.setOpaque(false);
        MakiQuantity.getEditor().setOpaque(false);
        ((JSpinner.NumberEditor)MakiQuantity.getEditor()).getTextField().setOpaque(false);
MakiQuantity.getEditor().getComponent(0).setBackground(new java.awt.Color(0, 0, 0, 0));
MakiQuantity.getEditor().getComponent(0).setForeground(new java.awt.Color(255, 255, 255));
 JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) AmaEbiQuantity.getEditor();
editor.getTextField().setEnabled( true );
editor.getTextField().setEditable( false );
JSpinner.DefaultEditor editor1 = ( JSpinner.DefaultEditor ) KaniQuantity.getEditor();
editor1.getTextField().setEnabled( true );
editor1.getTextField().setEditable( false );
JSpinner.DefaultEditor editor2 = ( JSpinner.DefaultEditor ) TamagoQuantity.getEditor();
editor2.getTextField().setEnabled( true );
editor2.getTextField().setEditable( false );
JSpinner.DefaultEditor editor3 = ( JSpinner.DefaultEditor ) AburiQuantity.getEditor();
editor3.getTextField().setEnabled( true );
editor3.getTextField().setEditable( false );
JSpinner.DefaultEditor editor4 = ( JSpinner.DefaultEditor ) SakiQuantity.getEditor();
editor4.getTextField().setEnabled( true );
editor4.getTextField().setEditable( false );
JSpinner.DefaultEditor editor5 = ( JSpinner.DefaultEditor ) MakiQuantity.getEditor();
editor5.getTextField().setEnabled( true );
editor5.getTextField().setEditable( false );
                     //getComponent(0) gives you text field
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
       DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer)
     OrderList.getDefaultRenderer(String.class);
    stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        this.clock();
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//        OrderList.setModel(new OrderTableModel());
//        OrderList.setRowSelectionAllowed(false);
            OrderList.getSelectionModel().addListSelectionListener(new RowSelectionListener());
            OrderList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
//        LocalDate today = LocalDate.now();	//23-Feb-022
//    
//        int day = today.getDayOfMonth();	//23
//        Month month = today.getMonth(); 	//2
//        int year = today.getYear();
//        Date.setText(month + " " + day + " " + year);
//        DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
//    	String dateString = dateFormat.format(new Date()).toString();
//    	Time.setText(dateString);
        OrderList.getTableHeader().setFont(new java.awt.Font("Segoe UI", 1, 12));
        OrderList.getTableHeader().setOpaque(false);
        OrderList.getTableHeader().setForeground(new java.awt.Color(51,51,55));
        OrderList.getTableHeader().setBackground(new java.awt.Color(13,245,227));
        OrderList.getTableHeader().setOpaque(false);
        Total.setEditable(false);
                 UIManager.put("ToolTip.background", Color.white);
 UIManager.put("ToolTip.border",new LineBorder(Color.BLACK,1));
        
//OrderList.getTableHeader().setBackground(new java.awt.Color(0,0,0,255));
//OrderList.getTableHeader().setForeground(Color.white);
//        ((DefaultTableCellRenderer)OrderList.getDefaultRenderer(Object.class)).setBackground(new java.awt.Color(0, 0, 0, 255));
//        Scroll.setOpaque(false);
//        Scroll.setBackground(new java.awt.Color(0, 0, 0, 0));
//        ((DefaultTableCellRenderer)OrderList.getDefaultRenderer(Object.class)).setOpaque(false);
//        Scroll.getViewport().setOpaque(false);
//        OrderList.setBackground(new java.awt.Color(24,24,24));
//        OrderList.setForeground(new java.awt.Color(255, 255, 255));
//        OrderList.setSelectionBackground(new java.awt.Color(13,245,227));
//        OrderList.setShowGrid(false);
OrderList.setDefaultEditor(Object.class, null);
        // this is for changing scrollpanel 
 UIManager.put("ScrollBar.thumb", new ColorUIResource(new java.awt.Color(13,245,227)));
 OrderList.setModel(new OrderTableModel());
Scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() );
Scroll.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
          this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ExitConfirmation();
               
                
            }
        
    });  
    

                    
            
                    
          
//          MainPanel.addMouseListener(new MouseAdapter()
//{
//    @Override
//    public void mouseExited(MouseEvent e)
//    {
//        Rectangle r = e.getComponent().getBounds();
//        Point p = e.getPoint();
//
//        if (p.x < 0 || p.x >= r.width
//        ||  p.y < 0 || p.y >= r.height)
//             Minimize.setForeground(new java.awt.Color(255, 119, 119));
//          
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e)
//    {
//       
//    }
//});
//    
       }
    
    
public void clock()
     {
         Thread clock= new Thread()
                 {
                 public void run()
                 {
                     try {
                    while(true)
                        {
//                         Calendar cal=new GregorianCalendar();
//                         int day=cal.get(Calendar.DAY_OF_MONTH);
//                         int month=cal.get(Calendar.MONTH)+1;
//                         int year=cal.get(Calendar.YEAR);                   
//                    int second=cal.get(Calendar.SECOND);
//                    int minute=cal.get(Calendar.MINUTE);
//                    int hour=cal.get(Calendar.HOUR);
                            LocalDate today = LocalDate.now();
                                 int day = today.getDayOfMonth();	//23
                        Month month = today.getMonth(); 	//2
                    int year = today.getYear();
        Date.setText(month + " " + day + " " + year);
        DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	Time.setText(dateString);
                     
                   
                    Time.setText(dateString);
                    Date.setText( month +" "+ day +" "+ year );
                  //  getTime=lbltime.getText();
                   // getDate=lbldate.getText();
                                    sleep(500);
                           
                            
                    }
                } catch (Exception e) {
                    


                }
            }
        };
    clock.start();

}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new RoundedPanel(new java.awt.Dimension(45, 45), 0);
        jPanel3 = new RoundedPanel(new java.awt.Dimension(45, 45), 0);
        jPanel1 = new javax.swing.JPanel();
        AmaEbi = new RoundedPanel(new java.awt.Dimension(45, 45),0);
        AmaEbiQuantity = new javax.swing.JSpinner();
        AddButton1 = new javax.swing.JLabel();
        jPanel19 = new RoundedPanel(new java.awt.Dimension(100,100), 0);
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Kani = new RoundedPanel(new java.awt.Dimension(45, 45), 0);
        KaniQuantity = new javax.swing.JSpinner();
        AddButton2 = new javax.swing.JLabel();
        jPanel20 = new RoundedPanel(new java.awt.Dimension(100,100), 0);
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Tamago = new RoundedPanel(new java.awt.Dimension(45, 45), 0);
        TamagoQuantity = new javax.swing.JSpinner();
        AddButton3 = new javax.swing.JLabel();
        jPanel21 = new RoundedPanel(new java.awt.Dimension(100,100), 0);
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Aburi = new RoundedPanel(new java.awt.Dimension(45, 45) ,0);
        AburiQuantity = new javax.swing.JSpinner();
        AddButton4 = new javax.swing.JLabel();
        jPanel22 = new RoundedPanel(new java.awt.Dimension(100,100), 0);
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Saki = new RoundedPanel(new java.awt.Dimension(45, 45), 0);
        SakiQuantity = new javax.swing.JSpinner();
        AddButton5 = new javax.swing.JLabel();
        jPanel23 = new RoundedPanel(new java.awt.Dimension(100,100), 0);
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Maki = new RoundedPanel(new java.awt.Dimension(45, 45),0);
        MakiQuantity = new javax.swing.JSpinner();
        AddButton6 = new javax.swing.JLabel();
        jPanel29 = new RoundedPanel(new java.awt.Dimension(100,100), 0);
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new RoundedPanel(new java.awt.Dimension(45, 45), 0);
        OrderID = new javax.swing.JLabel();
        BrandIcon = new javax.swing.JLabel();
        Scroll = new javax.swing.JScrollPane();
        OrderList = new javax.swing.JTable();
        Welcome = new javax.swing.JLabel();
        jPanel5 = new RoundedPanel(new java.awt.Dimension(45, 45), 0);
        ClearAll = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new RoundedPanel(new java.awt.Dimension(45, 45), 0);
        Order = new javax.swing.JLabel();
        jPanel8 = new RoundedPanel(new java.awt.Dimension(45, 45), 0);
        Remove = new javax.swing.JLabel();
        QuantityUpdate = new javax.swing.JTextField(3);
        jSeparator2 = new javax.swing.JSeparator();
        UpdatePanel = new RoundedPanel(new java.awt.Dimension(22, 22), 0);
        UpdateLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Info = new RoundedPanel(new java.awt.Dimension(100, 100),0);
        information = new javax.swing.JLabel();
        Minimize = new javax.swing.JLabel();
        Exit = new javax.swing.JLabel();
        Movable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(31, 25, 46));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setBackground(new java.awt.Color(31, 25, 46));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(31, 25, 46));
        jPanel3.setForeground(new java.awt.Color(31, 25, 46));
        jPanel3.setLayout(new java.awt.GridLayout(0, 2, 5, 0));

        jPanel1.setBackground(new java.awt.Color(31, 25, 46));
        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        AmaEbi.setBackground(new java.awt.Color(24, 24, 24));
        AmaEbi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AmaEbiQuantity.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        AmaEbiQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        AmaEbiQuantity.setToolTipText("Choose quantity");
        AmaEbiQuantity.setBorder(null);
        AmaEbiQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AmaEbi.add(AmaEbiQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 40, 30));

        AddButton1.setFont(new java.awt.Font("MS UI Gothic", 0, 24)); // NOI18N
        AddButton1.setForeground(new java.awt.Color(51, 51, 55));
        AddButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AddButton1.setText("+");
        AddButton1.setToolTipText("Click to order");
        AddButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddButton1MouseExited(evt);
            }
        });
        AmaEbi.add(AddButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jPanel19.setBackground(new java.awt.Color(13, 245, 227));
        jPanel19.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel19FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        AmaEbi.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/sushi1.png"))); // NOI18N
        jLabel12.setToolTipText("Ama Ebi");
        AmaEbi.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 167, 130));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("      ₱59.00 Ama Ebi");
        AmaEbi.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 160, 30));

        jPanel1.add(AmaEbi);

        Kani.setBackground(new java.awt.Color(24, 24, 24));
        Kani.setToolTipText("");
        Kani.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        KaniQuantity.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        KaniQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        KaniQuantity.setToolTipText("Choose quantity");
        KaniQuantity.setBorder(null);
        KaniQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kani.add(KaniQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 40, 30));

        AddButton2.setFont(new java.awt.Font("MS UI Gothic", 0, 24)); // NOI18N
        AddButton2.setForeground(new java.awt.Color(51, 51, 55));
        AddButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AddButton2.setText("+");
        AddButton2.setToolTipText("Click to order");
        AddButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddButton2MouseExited(evt);
            }
        });
        Kani.add(AddButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jPanel20.setBackground(new java.awt.Color(13, 245, 227));
        jPanel20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel20FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Kani.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/sushi2.png"))); // NOI18N
        jLabel13.setToolTipText("Kani");
        Kani.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 167, 130));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("            ₱39.00 Kani");
        Kani.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 160, 30));

        jPanel1.add(Kani);

        Tamago.setBackground(new java.awt.Color(24, 24, 24));
        Tamago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TamagoQuantity.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TamagoQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        TamagoQuantity.setToolTipText("Choose quantity");
        TamagoQuantity.setBorder(null);
        TamagoQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tamago.add(TamagoQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 40, 30));

        AddButton3.setFont(new java.awt.Font("MS UI Gothic", 0, 24)); // NOI18N
        AddButton3.setForeground(new java.awt.Color(51, 51, 55));
        AddButton3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AddButton3.setText("+");
        AddButton3.setToolTipText("Click to order");
        AddButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddButton3MouseExited(evt);
            }
        });
        Tamago.add(AddButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jPanel21.setBackground(new java.awt.Color(13, 245, 227));
        jPanel21.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel21FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Tamago.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/sushi3.png"))); // NOI18N
        jLabel14.setToolTipText("Tamago");
        Tamago.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 167, 130));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("      ₱39.00 Tamago");
        Tamago.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 160, 30));

        jPanel1.add(Tamago);

        Aburi.setBackground(new java.awt.Color(24, 24, 24));
        Aburi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AburiQuantity.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        AburiQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        AburiQuantity.setToolTipText("Choose quantity");
        AburiQuantity.setBorder(null);
        AburiQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Aburi.add(AburiQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 40, 30));

        AddButton4.setFont(new java.awt.Font("MS UI Gothic", 0, 24)); // NOI18N
        AddButton4.setForeground(new java.awt.Color(51, 51, 55));
        AddButton4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AddButton4.setText("+");
        AddButton4.setToolTipText("Click to order");
        AddButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddButton4MouseExited(evt);
            }
        });
        Aburi.add(AddButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jPanel22.setBackground(new java.awt.Color(13, 245, 227));
        jPanel22.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel22FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Aburi.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/sushi4.png"))); // NOI18N
        jLabel15.setToolTipText("Aburi");
        Aburi.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 167, 130));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("          ₱49.00 Aburi");
        jLabel8.setToolTipText("");
        Aburi.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 160, 30));

        jPanel1.add(Aburi);

        Saki.setBackground(new java.awt.Color(24, 24, 24));
        Saki.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SakiQuantity.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        SakiQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        SakiQuantity.setToolTipText("Choose quantity");
        SakiQuantity.setBorder(null);
        SakiQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Saki.add(SakiQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 40, 30));

        AddButton5.setFont(new java.awt.Font("MS UI Gothic", 0, 24)); // NOI18N
        AddButton5.setForeground(new java.awt.Color(51, 51, 55));
        AddButton5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AddButton5.setText("+");
        AddButton5.setToolTipText("Click to order");
        AddButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddButton5MouseExited(evt);
            }
        });
        Saki.add(AddButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jPanel23.setBackground(new java.awt.Color(13, 245, 227));
        jPanel23.setToolTipText("");
        jPanel23.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel23FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Saki.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/sushi5.png"))); // NOI18N
        jLabel16.setToolTipText("Saki");
        Saki.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 167, 130));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("             ₱59.00 Saki");
        Saki.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 160, 30));

        jPanel1.add(Saki);

        Maki.setBackground(new java.awt.Color(24, 24, 24));
        Maki.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MakiQuantity.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        MakiQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        MakiQuantity.setToolTipText("Choose quantity");
        MakiQuantity.setBorder(null);
        MakiQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Maki.add(MakiQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 40, 30));

        AddButton6.setFont(new java.awt.Font("MS UI Gothic", 0, 24)); // NOI18N
        AddButton6.setForeground(new java.awt.Color(51, 51, 55));
        AddButton6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AddButton6.setText("+");
        AddButton6.setToolTipText("Click to order");
        AddButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddButton6MouseExited(evt);
            }
        });
        Maki.add(AddButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jPanel29.setBackground(new java.awt.Color(13, 245, 227));
        jPanel29.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel29FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Maki.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 30, 30));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/sushi6.png"))); // NOI18N
        jLabel17.setToolTipText("Maki");
        Maki.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 167, 130));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("           ₱39.00 Maki");
        Maki.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 160, 30));

        jPanel1.add(Maki);

        jPanel3.add(jPanel1);

        jPanel4.setBackground(new java.awt.Color(24, 24, 24));
        jPanel4.setForeground(new java.awt.Color(31, 25, 46));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrderID.setBackground(new java.awt.Color(24, 24, 24));
        OrderID.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        OrderID.setForeground(new java.awt.Color(24, 24, 24));
        jPanel4.add(OrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 30, 30));

        BrandIcon.setForeground(new java.awt.Color(255, 255, 255));
        BrandIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BrandIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/brandIcon9.png"))); // NOI18N
        BrandIcon.setToolTipText("");
        jPanel4.add(BrandIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 240, 40));

        Scroll.setForeground(new java.awt.Color(0, 255, 255));

        OrderList.setBackground(new java.awt.Color(24, 24, 24));
        OrderList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        OrderList.getTableHeader().setForeground(new java.awt.Color(51,51,55));
        OrderList.setForeground(new java.awt.Color(255, 255, 255));
        OrderList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity", "Price"
            }
        ));
        OrderList.setToolTipText("Please select to remove");
        OrderList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OrderList.setFillsViewportHeight(true);
        OrderList.setIntercellSpacing(new java.awt.Dimension(5, 5));
        OrderList.setRowHeight(30);
        OrderList.setSelectionBackground(new java.awt.Color(13, 245, 227));
        OrderList.setSelectionForeground(new java.awt.Color(51, 51, 55));
        OrderList.setShowGrid(false);
        OrderList.getTableHeader().setResizingAllowed(false);
        OrderList.getTableHeader().setReorderingAllowed(false);
        Scroll.setViewportView(OrderList);
        if (OrderList.getColumnModel().getColumnCount() > 0) {
            OrderList.getColumnModel().getColumn(0).setResizable(false);
            OrderList.getColumnModel().getColumn(0).setPreferredWidth(20);
            OrderList.getColumnModel().getColumn(1).setResizable(false);
            OrderList.getColumnModel().getColumn(1).setPreferredWidth(20);
            OrderList.getColumnModel().getColumn(2).setResizable(false);
            OrderList.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        jPanel4.add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 320, 160));

        Welcome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Welcome.setForeground(new java.awt.Color(255, 255, 255));
        Welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(Welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 320, 20));

        jPanel5.setBackground(new java.awt.Color(13, 245, 227));

        ClearAll.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        ClearAll.setForeground(new java.awt.Color(51, 51, 55));
        ClearAll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ClearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/clearall.png"))); // NOI18N
        ClearAll.setToolTipText("Remove all");
        ClearAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearAllMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClearAllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClearAllMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        Date.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Date.setForeground(new java.awt.Color(255, 255, 255));
        Date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 130, 20));

        Time.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 130, 20));

        Total.setBackground(new java.awt.Color(24, 24, 24));
        Total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Total.setForeground(new java.awt.Color(255, 255, 255));
        Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total.setText("0.00");
        Total.setToolTipText("Total price");
        Total.setBorder(null);
        jPanel4.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 80, 20));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 90, 10));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/pesos.png"))); // NOI18N
        jLabel2.setToolTipText("Total price");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 40, 30));

        jPanel6.setBackground(new java.awt.Color(13, 245, 227));

        Order.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Order.setForeground(new java.awt.Color(51, 51, 55));
        Order.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/order.png"))); // NOI18N
        Order.setToolTipText("Process your order");
        Order.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OrderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OrderMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Order, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Order, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, 40));

        jPanel8.setBackground(new java.awt.Color(13, 245, 227));

        Remove.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Remove.setForeground(new java.awt.Color(51, 51, 55));
        Remove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/remove.png"))); // NOI18N
        Remove.setToolTipText("Remove");
        Remove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemoveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, 40));

        QuantityUpdate.setBackground(new java.awt.Color(24, 24, 24));
        QuantityUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        QuantityUpdate.setForeground(new java.awt.Color(255, 255, 255));
        QuantityUpdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        QuantityUpdate.setToolTipText("Quantity");
        QuantityUpdate.setBorder(null);
        QuantityUpdate.setCaretColor(new java.awt.Color(255, 255, 255));
        QuantityUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QuantityUpdateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                QuantityUpdateKeyTyped(evt);
            }
        });
        jPanel4.add(QuantityUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 40, 20));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 110, 20));

        UpdatePanel.setBackground(new java.awt.Color(13, 245, 227));
        UpdatePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UpdateLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        UpdateLabel.setForeground(new java.awt.Color(51, 51, 55));
        UpdateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UpdateLabel.setText("Update");
        UpdateLabel.setToolTipText("Click to update");
        UpdateLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout UpdatePanelLayout = new javax.swing.GroupLayout(UpdatePanel);
        UpdatePanel.setLayout(UpdatePanelLayout);
        UpdatePanelLayout.setHorizontalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdatePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(UpdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        UpdatePanelLayout.setVerticalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdatePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(UpdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(UpdatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 50, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(116, 113, 126));
        jLabel3.setText("Quantity:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        Info.setBackground(new java.awt.Color(255, 255, 255));
        Info.setForeground(new java.awt.Color(255, 255, 255));

        information.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        information.setForeground(new java.awt.Color(116, 113, 126));
        information.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        information.setText("i");
        information.setToolTipText("The minimum and maximum between 1 to 100.");

        javax.swing.GroupLayout InfoLayout = new javax.swing.GroupLayout(Info);
        Info.setLayout(InfoLayout);
        InfoLayout.setHorizontalGroup(
            InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(information, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        InfoLayout.setVerticalGroup(
            InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(information))
        );

        jPanel4.add(Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 20, 20));

        jPanel3.add(jPanel4);

        MainPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 690, 420));

        Minimize.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Minimize.setForeground(new java.awt.Color(104, 101, 112));
        Minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Minimize.setText("—");
        Minimize.setToolTipText("Minimize");
        Minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeMouseClicked(evt);
            }
        });
        MainPanel.add(Minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 30, 30));

        Exit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Exit.setForeground(new java.awt.Color(104, 101, 112));
        Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Exit.setText("X");
        Exit.setToolTipText("Exit");
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitMouseExited(evt);
            }
        });
        MainPanel.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 30, 30));

        Movable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/movegrabber.png"))); // NOI18N
        Movable.setToolTipText("Press and drag to move ");
        Movable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Movable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MovableMouseDragged(evt);
            }
        });
        Movable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MovableMousePressed(evt);
            }
        });
        MainPanel.add(Movable, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 30, 20));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel19FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel19FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19FocusLost

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
       ConfirmDialog invoke = new ConfirmDialog(this, true);
       invoke.setLocationRelativeTo(this);
       Exit.setForeground(new java.awt.Color(104,101,112));
       Toolkit.getDefaultToolkit().beep();
       invoke.setVisible(true);
      
    }//GEN-LAST:event_ExitMouseClicked

    private void MinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseClicked
            this.setExtendedState(this.ICONIFIED);
        
                
   
    }//GEN-LAST:event_MinimizeMouseClicked

    private void AddButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton1MouseEntered
        AddButton1.setForeground(new java.awt.Color(255, 255, 255));
        AmaEbi.setBackground(new java.awt.Color(37, 42, 52));
    }//GEN-LAST:event_AddButton1MouseEntered

    private void AddButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton1MouseExited
         AddButton1.setForeground(new java.awt.Color(51,51,55));
         AmaEbi.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_AddButton1MouseExited

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
       Exit.setForeground(new java.awt.Color(255, 119, 119));
    }//GEN-LAST:event_ExitMouseEntered

    private void ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseExited
       Exit.setForeground(new java.awt.Color(104,101,112));
    }//GEN-LAST:event_ExitMouseExited

    private void OrderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderMouseEntered
        Order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/orderselected.png")));
    }//GEN-LAST:event_OrderMouseEntered

    private void OrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderMouseExited
        Order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/order.png")));
    }//GEN-LAST:event_OrderMouseExited

    private void ClearAllMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearAllMouseEntered
        ClearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/clearallselected.png")));
    }//GEN-LAST:event_ClearAllMouseEntered

    private void ClearAllMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearAllMouseExited
        ClearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/clearall.png")));
    }//GEN-LAST:event_ClearAllMouseExited

    private void AddButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton1MouseClicked

            OrderTableModel model = (OrderTableModel) OrderList.getModel();
                Order order = new Order();
                boolean isDuplicate = false;
                String duplicate = "Ama Ebi";
                // checkin if the jtable is null
                if (model.getRowCount() == 0) {
//                order.setId(1);
//                order.setItem("Ama Ebi");
//                order.setQuanity(1);
//                order.setUnitPrice(245);
//                model.add(order); 
                 }
                // check if theres a duplicate row
                else {
                    
                        for (int row =0; row < model.getRowCount(); row++) {
                           if (duplicate.equals(model.getValueAt(row, 0))) {
                               isDuplicate = true;
                            }
                        }
                   }
              if (isDuplicate == false) {
                order.setItem("Ama Ebi");
                order.setQuanity(1);
                order.setUnitPrice(59);
                model.add(order);
                new QuantityUpdate("Ama Ebi", AmaEbiQuantity).Update();
               new QuantityUpdate("Ama Ebi", AmaEbiQuantity).GetTotal();
            
              }
              else {
                                  
                  
                   new QuantityUpdate("Ama Ebi", AmaEbiQuantity).Update();
                    new QuantityUpdate("Ama Ebi", AmaEbiQuantity).GetTotal();
              }
        
                
//    for (int qty = 0; qty < model.getRowCount(); qty++) {
//                  quantity = quantity + (int) model.getValueAt(qty, 2);
//                   order.setQuanity(quantity);
//                  model.update(order);
//                double sum=0;
//                for(int a=0; a<j.getRowCount(); a++)
//                {
//                    sum = sum + (double) j.getValueAt(a, 3);
//                }
//                Total.setText((String.valueOf(sum)));
           
               
    }//GEN-LAST:event_AddButton1MouseClicked
        
    private void MovableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovableMousePressed
         initialClick = evt.getPoint();
        getComponentAt(initialClick);
    }//GEN-LAST:event_MovableMousePressed

    private void MovableMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovableMouseDragged
       //          // get location of Window
            int thisX = this.getLocation().x;
            int thisY = this.getLocation().y;

            // Determine how much the mouse moved since the initial click
            int xMoved = evt.getX() - initialClick.x;
            int yMoved = evt.getY() - initialClick.y;

            // Move window to this position
            int X = thisX + xMoved;
            int Y = thisY + yMoved;
            this.setLocation(X, Y);
            
            this.revalidate();
    }//GEN-LAST:event_MovableMouseDragged

    private void ClearAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearAllMouseClicked
//          OrderList.setModel(new OrderTableModel());
//             DefaultTableModel tblModel = (DefaultTableModel)OrderList.getModel();
             
                OrderTableModel model = (OrderTableModel) OrderList.getModel();
        int removeAllRow = model.getRowCount();
        
        for (int i=removeAllRow - 1; i>=0; i--){
        model.removeRowAt(i);
        }  
          new QuantityUpdate("Kani", KaniQuantity).GetTotal();
         QuantityUpdate.setText("");
         AmaEbiQuantity.setValue(1);
         KaniQuantity.setValue(1);
         TamagoQuantity.setValue(1);
         AburiQuantity.setValue(1);
         SakiQuantity.setValue(1);
         MakiQuantity.setValue(1);
         
    }//GEN-LAST:event_ClearAllMouseClicked

    private void AddButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton2MouseClicked
          
            OrderTableModel model = (OrderTableModel) OrderList.getModel();
                    Order order = new Order();
                boolean isDuplicate = false;
                String duplicate = "Kani";
                // checkin if the jtable is null
                if (model.getRowCount() == 0) {
//                order.setId(1);
//                order.setItem("Ama Ebi");
//                order.setQuanity(1);
//                order.setUnitPrice(245);
//                model.add(order);
                 }
                // check if theres a duplicate row
                else {
                    
                        for (int row =0; row < model.getRowCount(); row++) {
                           if (duplicate.equals(model.getValueAt(row, 0))) {
                               isDuplicate = true;
                            }
                        }
                   }
              if (isDuplicate == false) {
                order.setItem("Kani");
                order.setQuanity(1);
                order.setUnitPrice(39);
                model.add(order);
                new QuantityUpdate("Kani", KaniQuantity).Update();
                  new QuantityUpdate("Kani", KaniQuantity).GetTotal();
                   
              }
              else {
                 
                 
                 new QuantityUpdate("Kani", KaniQuantity).Update();
                 new QuantityUpdate("Kani", KaniQuantity).GetTotal();
              }
      
    }//GEN-LAST:event_AddButton2MouseClicked

    private void AddButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton2MouseEntered
              AddButton2.setForeground(new java.awt.Color(255, 255, 255));
            Kani.setBackground(new java.awt.Color(37, 42, 52));
    }//GEN-LAST:event_AddButton2MouseEntered

    private void AddButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton2MouseExited
            AddButton2.setForeground(new java.awt.Color(51,51,55));
          Kani.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_AddButton2MouseExited

    private void jPanel20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel20FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20FocusLost

    private void AddButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton3MouseClicked
                 
            OrderTableModel model = (OrderTableModel) OrderList.getModel();
                    Order order = new Order();
                boolean isDuplicate = false;
                String duplicate = "Tamago";
                // checkin if the jtable is null
                if (model.getRowCount() == 0) {
//                order.setId(1);
//                order.setItem("Ama Ebi");
//                order.setQuanity(1);
//                order.setUnitPrice(245);
//                model.add(order);
                 }
                // check if theres a duplicate row
                else {
                    
                        for (int row =0; row < model.getRowCount(); row++) {
                           if (duplicate.equals(model.getValueAt(row, 0))) {
                               isDuplicate = true;
                            }
                        }
                   }
              if (isDuplicate == false) {
                order.setItem("Tamago");
                order.setQuanity(1);
                order.setUnitPrice(39);
                model.add(order);
                new QuantityUpdate("Tamago", TamagoQuantity).Update();
                new QuantityUpdate("Tamago", TamagoQuantity).GetTotal();
                 
              }
              else {
                 
                 
                 new QuantityUpdate("Tamago", TamagoQuantity).Update();
                    new QuantityUpdate("Tamago", TamagoQuantity).GetTotal();
              }
    }//GEN-LAST:event_AddButton3MouseClicked

    private void AddButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton3MouseEntered
        AddButton3.setForeground(new java.awt.Color(255, 255, 255));
            Tamago.setBackground(new java.awt.Color(37, 42, 52));
    }//GEN-LAST:event_AddButton3MouseEntered

    private void AddButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton3MouseExited
      AddButton3.setForeground(new java.awt.Color(51,51,55));
          Tamago.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_AddButton3MouseExited

    private void jPanel21FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel21FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21FocusLost

    private void AddButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton4MouseClicked
             
            OrderTableModel model = (OrderTableModel) OrderList.getModel();
               Order order = new Order();
                boolean isDuplicate = false;
                String duplicate = "Aburi";
                // checkin if the jtable is null
                if (model.getRowCount() == 0) {
//                order.setId(1);
//                order.setItem("Ama Ebi");
//                order.setQuanity(1);
//                order.setUnitPrice(245);
//                model.add(order);
                 }
                // check if theres a duplicate row
                else {
                    
                        for (int row =0; row < model.getRowCount(); row++) {
                           if (duplicate.equals(model.getValueAt(row, 0))) {
                               isDuplicate = true;
                            }
                        }
                   }
              if (isDuplicate == false) {
                order.setItem("Aburi");
                order.setQuanity(1);
                order.setUnitPrice(49);
                model.add(order);
                new QuantityUpdate("Aburi", AburiQuantity).Update();
                  new QuantityUpdate("Aburi", AburiQuantity).GetTotal();
                   
              }
              else {
                 
                 
                  new QuantityUpdate("Aburi", AburiQuantity).Update();
                    new QuantityUpdate("Aburi", AburiQuantity).GetTotal();
              }
    }//GEN-LAST:event_AddButton4MouseClicked

    private void AddButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton4MouseEntered
        AddButton4.setForeground(new java.awt.Color(255, 255, 255));
            Aburi.setBackground(new java.awt.Color(37, 42, 52));
    }//GEN-LAST:event_AddButton4MouseEntered

    private void AddButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton4MouseExited
       AddButton4.setForeground(new java.awt.Color(51,51,55));
          Aburi.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_AddButton4MouseExited

    private void jPanel22FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel22FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel22FocusLost

    private void jPanel23FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel23FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel23FocusLost

    private void AddButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton5MouseExited
         AddButton5.setForeground(new java.awt.Color(51,51,55));
          Saki.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_AddButton5MouseExited

    private void AddButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton5MouseEntered
         AddButton5.setForeground(new java.awt.Color(255, 255, 255));
            Saki.setBackground(new java.awt.Color(37, 42, 52));
    }//GEN-LAST:event_AddButton5MouseEntered

    private void AddButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton5MouseClicked
                 
            OrderTableModel model = (OrderTableModel) OrderList.getModel();
               Order order = new Order();
                boolean isDuplicate = false;
                String duplicate = "Saki";
                // checkin if the jtable is null
                if (model.getRowCount() == 0) {
//                order.setId(1);
//                order.setItem("Ama Ebi");
//                order.setQuanity(1);
//                order.setUnitPrice(245);
//                model.add(order);
                 }
                // check if theres a duplicate row
                else {
                    
                        for (int row =0; row < model.getRowCount(); row++) {
                           if (duplicate.equals(model.getValueAt(row, 0))) {
                               isDuplicate = true;
                            }
                        }
                   }
              if (isDuplicate == false) {
                order.setItem("Saki");
                order.setQuanity(1);
                order.setUnitPrice(59);
                model.add(order);
                new QuantityUpdate("Ama Ebi", SakiQuantity).Update();
                 new QuantityUpdate("Saki", SakiQuantity).GetTotal();
                  
              }
              else {
                 
                 
                  new QuantityUpdate("Saki", SakiQuantity).Update();
                  new QuantityUpdate("Saki", SakiQuantity).GetTotal();
              }
    }//GEN-LAST:event_AddButton5MouseClicked

    private void AddButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton6MouseClicked
                  
            OrderTableModel model = (OrderTableModel) OrderList.getModel();
             Order order = new Order();
                boolean isDuplicate = false;
                String duplicate = "Maki";
                // checkin if the jtable is null
                if (model.getRowCount() == 0) {
//                order.setId(1);
//                order.setItem("Ama Ebi");
//                order.setQuanity(1);
//                order.setUnitPrice(245);
//                model.add(order);
                 }
                // check if theres a duplicate row
                else {
                    
                        for (int row =0; row < model.getRowCount(); row++) {
                           if (duplicate.equals(model.getValueAt(row, 0))) {
                               isDuplicate = true;
                            }
                        }
                   }
              if (isDuplicate == false) {
                order.setItem("Maki");
                order.setQuanity(1);
                order.setUnitPrice(39);
                model.add(order);
                 new QuantityUpdate("Ama Ebi", MakiQuantity).Update();
              new QuantityUpdate("Maki", MakiQuantity).GetTotal();
              
              }
              else {
                 
                 
                  new QuantityUpdate("Maki", MakiQuantity).Update();
                  new QuantityUpdate("Maki", MakiQuantity).GetTotal();
              }
    }//GEN-LAST:event_AddButton6MouseClicked

    private void AddButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton6MouseEntered
       AddButton6.setForeground(new java.awt.Color(255, 255, 255));
            Maki.setBackground(new java.awt.Color(37, 42, 52));
    }//GEN-LAST:event_AddButton6MouseEntered

    private void AddButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButton6MouseExited
       AddButton6.setForeground(new java.awt.Color(51,51,55));
          Maki.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_AddButton6MouseExited

    private void jPanel29FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel29FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29FocusLost

    private void RemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveMouseClicked
    OrderTableModel model = (OrderTableModel) OrderList.getModel();
    Order order = new Order();
        int row = OrderList.getSelectedRow();
        
  
    // checking if the cart is  empty
    if (model.getRowCount() == 0) {
            CartIsEmptyAlert warning = new CartIsEmptyAlert(this, true);
            warning.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              
            warning.setLocationRelativeTo(OrderList);
            Toolkit.getDefaultToolkit().beep();
            warning.setVisible(true);
    }
    else if (isThereAnyRowSelected == false) {
            InformationDialog info = new InformationDialog(this, true);
            info.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              
            info.setLocationRelativeTo(OrderList);
            Toolkit.getDefaultToolkit().beep();
            info.setVisible(true);
    }
    else {
//        if (row != -1) {
  
   
    int currentqty = (int) (model.getValueAt(row, 1));
   
    order =  model.getOrderAt(row);
    // decrement current quantity by one
    currentqty--;
    // if current quantity has hit the minimum? - i assumed 0 would be the number where you want to remove the row
    if (currentqty <= 0) {
        model.removeRowAt(row);
         new QuantityUpdate("Maki", MakiQuantity).GetTotal();
    } else {
        order.setQuanity(currentqty);
        model.update(order);
        new QuantityUpdate("Maki", MakiQuantity).GetTotal();
    }
        
    
     
       
    // First you need to check if the cart is empty
    // Second you need to check if the user select the specified row
    // if not then proceed to remove

}
      
  
     
      
       
       
      
     
       
    
        
          
 
    
    }//GEN-LAST:event_RemoveMouseClicked
    
    private void RemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveMouseEntered
            Remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/removeselected.png")));
    }//GEN-LAST:event_RemoveMouseEntered

    private void RemoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveMouseExited
            Remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/remove.png")));
    }//GEN-LAST:event_RemoveMouseExited

    private void UpdateLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateLabelMouseEntered
            UpdateLabel.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_UpdateLabelMouseEntered

    private void UpdateLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateLabelMouseExited
            UpdateLabel.setForeground(new java.awt.Color(51, 51, 55));
    }//GEN-LAST:event_UpdateLabelMouseExited

    private void QuantityUpdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QuantityUpdateKeyTyped

                 if (QuantityUpdate.getText().length() == 3) {
                     evt.consume();
                     Toolkit.getDefaultToolkit().beep();
                 }

//            
//       
//         
//              QuantityUpdate.setToolTipText("Please input number only!");             
//               jSeparator1.setBackground(new java.awt.Color(255, 0, 0));
//               jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
//                Toolkit.getDefaultToolkit().beep();
//       }
//         else if (filter.matches("[0-9]*")) {
//             jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
//              jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
//              QuantityUpdate.setToolTipText("Quantity");
//             
//                 // you can uise this also
//                      Character.isAlphabetic(char)

          
    }//GEN-LAST:event_QuantityUpdateKeyTyped

    private void UpdateLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateLabelMouseClicked
         OrderTableModel model = (OrderTableModel) OrderList.getModel();
         
         Order order = new Order();
         int row = OrderList.getSelectedRow();
        boolean empty = QuantityUpdate.getText().trim().isEmpty();
        try{
    range = Integer.parseInt(QuantityUpdate.getText().trim());
         } catch(NumberFormatException ex){ //handling exeption
        
}
        
//        String strPattern = "^0+(?!$)";
        
         if (model.getRowCount() == 0) {
            CartIsEmptyAlert warning = new CartIsEmptyAlert(this, true);
            warning.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              
            warning.setLocationRelativeTo(OrderList);
            Toolkit.getDefaultToolkit().beep();
            warning.setVisible(true);
         }
       else if (empty) {
            QuantityAlert qty  = new QuantityAlert(this, true);
            qty.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              
            qty.setLocationRelativeTo(QuantityUpdate);
            Toolkit.getDefaultToolkit().beep();
            qty.setVisible(true);
        }
        else if (!(range >= 0 && range <= 100 )) {
            MaximumAlert limit = new MaximumAlert(this, true);
            limit.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              
            limit.setLocationRelativeTo(QuantityUpdate);
            Toolkit.getDefaultToolkit().beep();
            limit.setVisible(true);
        }
    
//        else if (isThereAnyRowSelected)   
    
    else if (isThereAnyRowSelected == false) {
            InformationDialog info = new InformationDialog(this, true);
            info.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              
            info.setLocationRelativeTo(OrderList);
            Toolkit.getDefaultToolkit().beep();
            info.setVisible(true);
              
        }
    else  {
          int currentqty = (int) (model.getValueAt(row, 1));
   
    order =  model.getOrderAt(row);

    // if current quantity has hit the minimum? - i assumed 0 would be the number where you want to remove the row
    if (range == 0) {
        model.removeRowAt(row);
         new QuantityUpdate("Maki", MakiQuantity).GetTotal();
    } else {
        order.setQuanity(range);
        model.update(order);
        new QuantityUpdate("Maki", MakiQuantity).GetTotal();
    }
    }
        
        
    
    }//GEN-LAST:event_UpdateLabelMouseClicked

    private void QuantityUpdateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QuantityUpdateKeyReleased
       
    }//GEN-LAST:event_QuantityUpdateKeyReleased

    private void OrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderMouseClicked
            OrderTableModel model = (OrderTableModel) OrderList.getModel();
           
      
          // checking if the cart is  empty
    if (model.getRowCount() == 0) {
          CartIsEmptyAlert warning = new CartIsEmptyAlert(this, true);
            warning.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            warning.setLocationRelativeTo(OrderList);
            Toolkit.getDefaultToolkit().beep();
            warning.setVisible(true);
    }
    else {
           Order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/order.png")));
          Loading3 loading = new Loading3(this, new Loading3.Observer() {
        @Override
        public void loadingDidComplete() {
          ProcessOrder();
          Clear();
          isLoadingDone = true;
        }
    });
    loading.setLocationRelativeTo(this);
    loading.setVisible(true);
    if (isLoadingDone) {
               
               Thankyou loading1 = new Thankyou(this, new Thankyou.Observer() {
        @Override
        public void loadingDidComplete() {
           isLoadingDone = false;
           isLoadingDone2 = true;           
}
        
    });
    loading1.setLocationRelativeTo(this);
    loading1.setVisible(true);
   }
       PrinterJob pj = PrinterJob.getPrinterJob();        
        pj.setPrintable(new MainMenu.Invoice(),getPageFormat(pj));
        if (isLoadingDone2) {
        try {
            
           pj.print();
        } catch (final PrinterAbortException e) {
            } catch (final Exception e) {
        } finally {
            isLoadingDone2 = false;
        }
    }
      
    }
//                 for (int i = 0; i < row; i++) {
//         System.out.println(model.getValueAt(i, 0));
//         String item_name = (String) model.getValueAt(i, 0);  
//         int quantity = (int) (model.getValueAt(i, 1));
//         Double unitprice = (double) model.getValueAt(i, 2);  
//         Double totalamount = (double) model.getValueAt(i, 3);
//    }
     
//            ResultSet rs = null;
       
//        
//  

//    
//       
//    ArrayList<Customer> customers = getAllCustomers();
//    for (int i = 0; i < customers.size(); i++) {
//        System.out.println(customers.get(i).getCustomerId());      
//        System.out.println(customers.get(i).getCustomerName()); 
//        System.out.println(customers.get(i).getCustomerUser());
//        System.out.println(customers.get(i).getCustomerPhone());
//        System.out.println(customers.get(i).getCustomerAddr());
//       
//        
//    }   
//    

//        for (int i = 0; i < model.getRowCount(); i++) {
//         String item_name = (String) model.getValueAt(i, 0);  
//         int quantity = (int) (model.getValueAt(i, 1));
//         Double unitprice = (double) model.getValueAt(i, 2);  
//         Double totalamount = (double) model.getValueAt(i, 3);
//         
         
//            try {
//        String query = "insert into sales (order_id, order_created, item_name)"
//        + " values (?, ?, ?)";
//       
//        st = conn.prepareStatement(query);
//        st.setInt(1, orderid);
//        st.setDate(2, startDate);
//        st.setString(3, item_name);
//        st.setInt(4, quantity);
//        st.setDouble(5, unitprice);
//        st.setDouble(6, totalamount);
//        st.addBatch(query);
//        st.executeBatch();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//                st.close();
//                
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
               
        
        
//        
//    }    
      
   
    }//GEN-LAST:event_OrderMouseClicked
    private void ExitConfirmation() {
        this.setExtendedState(this.NORMAL);
        ConfirmDialog invoke = new ConfirmDialog(this, true);
      
       Toolkit.getDefaultToolkit().beep();
       
      
      
        invoke.setLocationRelativeTo(this);
          invoke.setVisible(true);
    }
    public int GetRowIndex(String a) {
        
      int index = 0;
      OrderTableModel model = (OrderTableModel) OrderList.getModel();
      
    for (int i = model.getRowCount() - 1; i >= 0; --i) {
        for (int j = model.getColumnCount() - 1; j >= 0; --j) {
            if (model.getValueAt(i, j).equals(a)) {
                // what if value is not unique?
                index = i;
            }
        }
    }
   return index;
    }
    
   public class QuantityUpdate extends JSpinner {
       JSpinner spinner;
       int index;
      
       OrderTableModel model = (OrderTableModel) OrderList.getModel();
       QuantityUpdate(String sushi, JSpinner spinner) {
           this.spinner = spinner;
           this.index = GetRowIndex(sushi);
           GetTotal();
          
       }
       public void Update() {
           int qty = (int)spinner.getValue();
           Order order = model.getOrderAt(index);
           order.setQuanity(qty);
           model.update(order);
           
           
       }
       public void GetTotal() {
         
                double sum=0;
                for(int a=0; a<model.getRowCount(); a++)
                {
                    sum = sum + (double) model.getValueAt(a, 3);
                }
                Total.setText((String.valueOf(String.format("%.2f", sum))));
                
       }
    
           
       
   }
//    class RowSelectionListener implements ListSelectionListener {
//       @Override
//       public void valueChanged(ListSelectionEvent event) {
//           int viewrow = OrderList.getSelectedRow();
//           
//           if (!event.getValueIsAdjusting() && viewrow != -1 ) {
//               int columnIndex = 1;
//               int modelRow = OrderList.convertRowIndexToModel(viewrow);
//               Object modelvalue = OrderList.getValueAt(modelRow, viewrow);
//               System.out.println(modelvalue);
//           }
//       }
//   }
//    
       class RowSelectionListener implements ListSelectionListener {
       @Override
       public void valueChanged(ListSelectionEvent event) {
         
          int row = OrderList.getSelectedRow();
          
          boolean a = OrderList.isRowSelected(row);
          isThereAnyRowSelected = a;
           
          
       }
       
   }
         public static String removeLeadingZeroes(String str) {
      String strPattern = "^0+(?!$)";
      str = str.replaceAll(strPattern, "");
      return str;
   }
        public boolean CheckInternetConnecton() {
          boolean isConnected = false;
        try{
            String host="redhat.com";
            int port=80;
            int timeOutInMilliSec=1000;// 1 Seconds
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), timeOutInMilliSec);
            isConnected = true;
           
         
           
            
        }
        catch(Exception ex){
            isConnected = false;
           
        }      
        
         return isConnected;
        }
        
 
public ArrayList<Customer> getAllCustomers() 
{
    ArrayList<Customer> customers = new ArrayList<Customer>();
    Connection c = null;
    PreparedStatement st = null;
    ResultSet rs        = null;
    int id = Integer.valueOf(OrderID.getText());

    try {
        c           = SushiDBConnection.connectDB();
      
        String s    = "SELECT * FROM customers where customer_id = ?";
  st   = c.prepareStatement(s);
  st.setInt(1, id);
          rs = st.executeQuery();
       

        while (rs.next()) {
            Customer customer = new Customer();
     int cus_id = rs.getInt("customer_id");
     String cus_user = rs.getString("user_name");
      String cus_fullname = rs.getString("full_name");
      String cus_phoneno = rs.getString("mobile_no");
      String cus_addr = rs.getString("user_addr");
      customer.setCustomerId(cus_id);
      customer.setCustomerName(cus_fullname);
      customer.setCustomerUser(cus_user);
      customer.setCustomerPhone(cus_phoneno);
      customer.setCustomerAddr(cus_addr);
      customers.add(customer);
      
            
        }
    } catch (Exception e) {
        System.out.println(e);
    }finally{
       try{
   rs.close();
   st.close();
   c.close();
} catch(SQLException e) {
   System.out.println(e.getMessage());
}
       
    }

    return customers;
}
public void ProcessOrder() {
            Connection conn = null;
            PreparedStatement st = null;
     try{

  int rows=OrderList.getRowCount();
   int orderid = Integer.valueOf(OrderID.getText());
       Calendar calendar = Calendar.getInstance();
     java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
      conn = SushiDBConnection.connectDB();
  for(int row = 0; row<rows; row++)
  {   
    String item_name = (String)OrderList.getValueAt(row, 0);
    int quantity = (int) OrderList.getValueAt(row, 1);
    Double unitprice = (double)OrderList.getValueAt(row, 2);
    Double totalamount = (double)OrderList.getValueAt(row, 3);
    String query = "Insert into sales(order_id, order_created, item_name, item_quantity, unit_price, total_amount) values ('"+orderid+"','"+startDate+"','"+item_name+"','"+quantity+"','"+unitprice+"','"+totalamount+"')";

    st = conn.prepareStatement(query);
    st.execute();     
  }

  
}
catch(Exception e){
  
} finally {
          try {
              st.close();
              conn.close();
          } catch(Exception e) {
              e.printStackTrace();
          }
      }
      
}
public void Clear() {
    QuantityUpdate.setText("");
//         Total.setText("0.00");
         QuantityUpdate.setText("");
         AmaEbiQuantity.setValue(1);
         KaniQuantity.setValue(1);
         TamagoQuantity.setValue(1);
         AburiQuantity.setValue(1);
         SakiQuantity.setValue(1);
         MakiQuantity.setValue(1);
//    OrderTableModel model = (OrderTableModel) OrderList.getModel();
//        int removeAllRow = model.getRowCount();
//        
//        for (int i=removeAllRow - 1; i>=0; i--){
//        model.removeRowAt(i);
//        }  
}


public PageFormat getPageFormat(PrinterJob pj) {
    
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double bodyHeight = bHeight;  
    double headerHeight = 5.0;                  
    double footerHeight = 5.0;        
    double width = toPPI(4); 
//    double height = toPPI(3);
    double height = toPPI(headerHeight+bodyHeight+footerHeight); 
    paper.setSize(width, height);
    paper.setImageableArea(0,10,width,height - cm_to_pp(1));  
// paper.setImageableArea(
//                    toPPI(4),
//                    toPPI(4),
//                    width - toPPI(0),
//                    height - toPPI(1));
           
    pf.setOrientation(PageFormat.PORTRAIT);  
    pf.setPaper(paper);    

    return pf;
    }
        
    protected static double cm_to_pp(double cm)
    {            
	        return toPPI(cm * 0.393600787);            
    }
 
    protected static double toPPI(double inch)
    {            
	        return inch * 72d;            
    }
    
// The number of CMs per Inch
public static final double CM_PER_INCH = 0.393700787d;
// The number of Inches per CMs
public static final double INCH_PER_CM = 2.545d;
// The number of Inches per mm's
public static final double INCH_PER_MM = 25.45d;

public static double cmsToPixel(double cms, double dpi) {
    return cmToInches(cms) * dpi;
}
public static double pixelsToCms(double pixels, double dpi) {
    return inchesToCms(pixels / dpi);
}

public static double cmToInches(double cms) {
    return cms * CM_PER_INCH;
}

public static double inchesToCms(double inch) {
    return inch * INCH_PER_CM;
}


public class Invoice implements Printable {
         private String customerfullname;
         private String customermobileno;
         private String customeraddress;
         private String Total;
         java.sql.Date startDate;
        ArrayList<String> itemName = new ArrayList<>();
        ArrayList<String> quantity = new ArrayList<>();
        ArrayList<String> unitprice = new ArrayList<>();
        ArrayList<String> total = new ArrayList<>();
  Invoice() {
        OrderTableModel model = (OrderTableModel) OrderList.getModel();
        bHeight = Double.valueOf(itemName.size());   
        Calendar calendar = Calendar.getInstance();
      
//        int row = (int) model.getRowCount();
//        bHeight = Double.valueOf(row);
      startDate = new java.sql.Date(calendar.getTime().getTime());
    ArrayList<Customer> customers = getAllCustomers();
    for (int i = 0; i < customers.size(); i++) {    
        customerfullname = (customers.get(i).getCustomerName()); 
        customermobileno = (customers.get(i).getCustomerPhone());
        customeraddress = (customers.get(i).getCustomerAddr());
    }
             for (int i = 0; i < model.getRowCount(); i++) {
              itemName.add(model.getValueAt(i, 0).toString());
              quantity.add(model.getValueAt(i, 1).toString());
              unitprice.add(model.getValueAt(i, 2).toString());
              total.add(model.getValueAt(i, 3).toString());
       
    }
           double sum=0;
                for(int a=0; a<model.getRowCount(); a++)
                {
                    sum = sum + (double) model.getValueAt(a, 3);
                }
                Total = (String.valueOf(String.format("%.2f", sum)));
       
     

  }
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      
      int r= itemName.size();
      ImageIcon icon=new ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/branicon9_black.png"));
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    
            double width = pageFormat.getImageableWidth();                               
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

        
        try{
            int y=20;
            int yShift = 10;
            int headerRectHeight=15;
           // int headerRectHeighta=40;
            
                
      g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawImage(icon.getImage(), 40, 20, 150, 35, rootPane);y+=yShift+30;
            g2d.drawString("---------------------------------------",12,y);y+=yShift;
            g2d.drawString("            KUYA JERICK                ",12,y);y+=yShift;
            g2d.drawString("    San Jose, Balanga, Bataan          ",12,y);y+=yShift;
            g2d.drawString("    Pag asa Wawa, Orion, Bataan        ",12,y);y+=yShift;
            g2d.drawString("    www.facebook.com/kuyajerick        ",12,y);y+=yShift;
            g2d.drawString("            +639128562896              ",12,y);y+=yShift;
            g2d.drawString("---------------------------------------",10,y);y+=headerRectHeight;
            g2d.drawString(" Bill to:               Date:       ",12,y);y+=yShift;
            g2d.drawString(" "+customerfullname+"  ",12,y); g2d.drawString(""+startDate+" ",142,y);y+=yShift;
            g2d.drawString(" "+customeraddress+"                 ",12,y);y+=yShift;
            g2d.drawString(" "+customermobileno+"                 ",12,y);y+=yShift;
            g2d.drawString("---------------------------------------",12,y);y+=headerRectHeight;
            g2d.drawString(" Item Name   Qty   Unit Price  Total ",10,y);y+=yShift;
            g2d.drawString("---------------------------------------",10,y);y+=headerRectHeight;
            for(int s=0; s<r; s++)
            {
            g2d.drawString(" "+itemName.get(s)+" ",10,y); g2d.drawString(quantity.get(s),85,y); g2d.drawString(unitprice.get(s),125,y); g2d.drawString(total.get(s),180,y);y+=yShift;
            g2d.drawString("",10,y);y+=yShift;
            }
            g2d.drawString("---------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Total amount: ",10,y); g2d.drawString(""+Total+" ",178,y);y+=yShift;
            g2d.drawString("---------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Payment Method: COD                 ",10,y);y+=yShift;
            g2d.drawString("---------------------------------------",10,y);y+=yShift;
            g2d.drawString("***************************************",10,y);y+=yShift;
            g2d.drawString("      THANK YOU FOR YOUR ORDER!      ",10,y);y+=yShift;
            g2d.drawString("***************************************",10,y);y+=yShift;
            g2d.drawString("    SOFTWARE BY: JERICKSON MAYOR     ",10,y);y+=yShift;
            g2d.drawString("  CONTACT: jericksonmayor@gmail.com  ",10,y);y+=yShift;       
    }
    catch(Exception e){
    e.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
   }
//            g2d.drawString("  * "+unitprice.get(s),10,y); g2d.drawString(total.get(s),160,y);y+=yShift;

        


                  
        
         
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                           
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
                
               
               
             
            }
        });
      
    }
    
 

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Aburi;
    private javax.swing.JSpinner AburiQuantity;
    private javax.swing.JLabel AddButton1;
    private javax.swing.JLabel AddButton2;
    private javax.swing.JLabel AddButton3;
    private javax.swing.JLabel AddButton4;
    private javax.swing.JLabel AddButton5;
    private javax.swing.JLabel AddButton6;
    private javax.swing.JPanel AmaEbi;
    private static javax.swing.JSpinner AmaEbiQuantity;
    private javax.swing.JLabel BrandIcon;
    private javax.swing.JLabel ClearAll;
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Exit;
    private javax.swing.JPanel Info;
    private javax.swing.JPanel Kani;
    private javax.swing.JSpinner KaniQuantity;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel Maki;
    private javax.swing.JSpinner MakiQuantity;
    private static javax.swing.JLabel Minimize;
    private javax.swing.JLabel Movable;
    private javax.swing.JLabel Order;
    public javax.swing.JLabel OrderID;
    public javax.swing.JTable OrderList;
    private static javax.swing.JTextField QuantityUpdate;
    private javax.swing.JLabel Remove;
    private javax.swing.JPanel Saki;
    private javax.swing.JSpinner SakiQuantity;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JPanel Tamago;
    private javax.swing.JSpinner TamagoQuantity;
    private javax.swing.JLabel Time;
    private static javax.swing.JTextField Total;
    private javax.swing.JLabel UpdateLabel;
    private javax.swing.JPanel UpdatePanel;
    public static javax.swing.JLabel Welcome;
    private javax.swing.JLabel information;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
