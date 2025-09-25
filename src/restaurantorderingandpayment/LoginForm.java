
package restaurantorderingandpayment;
import java.awt.Point;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;


public class LoginForm extends javax.swing.JFrame {
     private Point initialClick;
     private boolean check;
     private boolean valid;
     public  String mobileno; 
     public String fullname;
     char[] rand;
    
     public static boolean isvalidated = false;
     

    public LoginForm() {
        
        initComponents();
       setBackground(new Color(0, 0, 0, 0));
       UserAddr.setEchoChar((char)0);
       UserFullName.setEchoChar((char)0);
       CreatePassword.setEchoChar('\u2022');
       TextFieldPass.setEchoChar('\u2022');
       error1.setVisible(false);
       error2.setVisible(false);
       error3.setVisible(false);
       error4.setVisible(false);
       error5.setVisible(false);
       error6.setVisible(false);
 UIManager.put("ToolTip.background", Color.white);
 UIManager.put("ToolTip.border",new LineBorder(Color.BLACK,1));
      
//SecurityQuestions.setOpaque(false);
// SecurityQuestions.setEditable(true);
//JTextField boxField = (JTextField)SecurityQuestions.getEditor().getEditorComponent();
//boxField.setBorder(BorderFactory.createEmptyBorder());
//boxField.setBackground(new Color(0, 0, 0, 0));
//boxField.setForeground(new Color(255,255,255));
//boxField.setFocusable(false);
//
//Object child =  SecurityQuestions.getAccessibleContext().getAccessibleChild(0);
//BasicComboPopup popup = (BasicComboPopup)child;
//JList list = popup.getList();
//list.setSelectionBackground(new Color(0, 0, 0, 0));
//SecurityQuestions.setFocusable(false);
//      UIManager.put("ToolTip.background", Color.white);
// UIManager.put("ToolTip.border",new LineBorder(Color.BLACK,1));     
((AbstractDocument)UserPhoneNo.getDocument()).setDocumentFilter(new DocumentFilter(){
        Pattern regEx = Pattern.compile("\\d*");

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {          
            Matcher matcher = regEx.matcher(text);
            if(!matcher.matches()){
                Toolkit.getDefaultToolkit().beep();
                return;
                
            }
            super.replace(fb, offset, length, text, attrs);
        }
    });
((AbstractDocument)UserFullName.getDocument()).setDocumentFilter(new DocumentFilter(){
        Pattern regEx = Pattern.compile("^[a-zA-Z\\s]*$");
       
       
        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {          
            Matcher matcher = regEx.matcher(text);
            if(!matcher.matches()){
                Toolkit.getDefaultToolkit().beep();
                return;
                
            }
            super.replace(fb, offset, length, text, attrs);
        }
    });



         this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/restaurantorderingandpayment/images/flaticon2.png")));
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher()
    {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e)
        {
            if (KeyEvent.VK_CAPS_LOCK == e.getKeyCode())
            {  
               check = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK); 
               if (check == true) {
                CapsLock.setText("Caps Lock is on!");
              Toolkit.getDefaultToolkit().beep();
               }
               else if (check == false) {
                CapsLock.setText("");
               }
            }
             
         
//           if (KeyEvent.VK_ALT == e.getKeyCode()) {
//                TextFieldPass.setEchoChar((char)0);
//          }
//           else {
//                TextFieldPass.setEchoChar('\u2022');
//           }
//           
          
               
            
        
             
                 
            return false;
        }
 
        
    });
        //password validation listener
		CreatePassword.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(CreatePassword.getText().length() > 0) {
					if(validatePassword(CreatePassword.getText())) {
						 ValidatePass.setForeground(new Color(50, 168, 58));
                                                  ValidatePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/valid.png"))); 
						 ValidatePass.setText("Password is valid");
					}
				}
				else {
					ValidatePass.setText("");
                                        ValidatePass.setIcon(null);
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(CreatePassword.getText().length() > 0) {
					if(validatePassword(CreatePassword.getText())) {
						ValidatePass.setForeground(new Color(50, 168, 58));
                                                ValidatePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/valid.png"))); 
						ValidatePass.setText("Password is valid");
					}
				}
				else {
					ValidatePass.setText("");
                                        ValidatePass.setIcon(null);
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(CreatePassword.getText().length() > 0 ) {
					if(validatePassword(CreatePassword.getText())) {
						ValidatePass.setForeground(new Color(50, 168, 58));
                                                ValidatePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/valid.png"))); 
						ValidatePass.setText("Password is valid");
					}
				}
				else {
					ValidatePass.setText("");
                                        ValidatePass.setIcon(null);
				}
			}
		});

        
               

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginForm = new RoundedPanel(new java.awt.Dimension(45, 45), 0);
        LoginTitle = new javax.swing.JLabel();
        BrandIcon = new javax.swing.JLabel();
        DontHaveAccount = new javax.swing.JLabel();
        TextFieldUser = new javax.swing.JTextField();
        UserIcon = new javax.swing.JLabel();
        PasswordIcon = new javax.swing.JLabel();
        TextFieldPass = new javax.swing.JPasswordField();
        Separator = new javax.swing.JSeparator();
        Separator2 = new javax.swing.JSeparator();
        LoginButton = new RoundedPanel(new java.awt.Dimension(50, 50), 0);
        Login = new javax.swing.JLabel();
        Exit = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SignUp = new javax.swing.JLabel();
        CapsLock = new javax.swing.JLabel();
        Info = new RoundedPanel(new java.awt.Dimension(100, 100),0);
        information = new javax.swing.JLabel();
        error5 = new javax.swing.JLabel();
        error6 = new javax.swing.JLabel();
        SignupForm = new RoundedPanel(new java.awt.Dimension(45, 45), 0);
        CreateAccount = new javax.swing.JLabel();
        PleaseFIll = new javax.swing.JLabel();
        UserIcon1 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        Separator3 = new javax.swing.JSeparator();
        PasswordIcon1 = new javax.swing.JLabel();
        UserAddr = new javax.swing.JPasswordField();
        PasswordIcon2 = new javax.swing.JLabel();
        CreatePassword = new javax.swing.JPasswordField();
        Separator4 = new javax.swing.JSeparator();
        PasswordIcon3 = new javax.swing.JLabel();
        UserFullName = new javax.swing.JPasswordField();
        Separator5 = new javax.swing.JSeparator();
        PasswordIcon4 = new javax.swing.JLabel();
        Separator6 = new javax.swing.JSeparator();
        SignupButton = new RoundedPanel(new java.awt.Dimension(50, 50), 0);
        SignUp2 = new javax.swing.JLabel();
        DontHaveAccount1 = new javax.swing.JLabel();
        Signinnow = new javax.swing.JLabel();
        Separator8 = new javax.swing.JSeparator();
        Info1 = new RoundedPanel(new java.awt.Dimension(100, 100),0);
        information2 = new javax.swing.JLabel();
        ValidatePass = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        Error = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        Info2 = new RoundedPanel(new java.awt.Dimension(100, 100),0);
        information1 = new javax.swing.JLabel();
        UserPhoneNo = new javax.swing.JTextField();
        BrandIcon2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        LoginForm.setBackground(new java.awt.Color(31, 25, 46));
        LoginForm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginFormKeyPressed(evt);
            }
        });
        LoginForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LoginTitle.setForeground(new java.awt.Color(255, 255, 255));
        LoginTitle.setText("Login");
        LoginForm.add(LoginTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        BrandIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BrandIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/brandIcon9.png"))); // NOI18N
        BrandIcon.setToolTipText("");
        LoginForm.add(BrandIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 300, 40));

        DontHaveAccount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        DontHaveAccount.setForeground(new java.awt.Color(116, 113, 126));
        DontHaveAccount.setText("Don't have an account?");
        LoginForm.add(DontHaveAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, -1));

        TextPrompt user = new TextPrompt("Username", TextFieldUser);
        user.setForeground(new java.awt.Color(107, 102, 117));
        user.setFont(new java.awt.Font("Segoe UI", 1, 13));
        TextFieldUser.setBackground(new java.awt.Color(31, 25, 46));
        TextFieldUser.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        TextFieldUser.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldUser.setBorder(null);
        TextFieldUser.setCaretColor(new java.awt.Color(255, 255, 255));
        TextFieldUser.setSelectedTextColor(new java.awt.Color(0, 255, 255));
        TextFieldUser.setSelectionColor(new java.awt.Color(31, 25, 46));
        TextFieldUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextFieldUserKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldUserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldUserKeyTyped(evt);
            }
        });
        LoginForm.add(TextFieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 180, 30));

        UserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/user.png"))); // NOI18N
        LoginForm.add(UserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 30, 30));

        PasswordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/lock.png"))); // NOI18N
        PasswordIcon.setToolTipText("");
        LoginForm.add(PasswordIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 30, 30));

        TextPrompt pass = new TextPrompt("\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022", TextFieldPass);
        pass.setForeground(new java.awt.Color(107, 102, 117));
        pass.setFont(new java.awt.Font("Segoe UI", 1, 13));
        TextFieldPass.setBackground(new java.awt.Color(31, 25, 46));
        TextFieldPass.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        TextFieldPass.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldPass.setToolTipText("");
        TextFieldPass.setBorder(null);
        TextFieldPass.setCaretColor(new java.awt.Color(255, 255, 255));
        TextFieldPass.setSelectedTextColor(new java.awt.Color(0, 255, 255));
        TextFieldPass.setSelectionColor(new java.awt.Color(31, 25, 46));
        TextFieldPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextFieldPassKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldPassKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldPassKeyTyped(evt);
            }
        });
        LoginForm.add(TextFieldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 180, 30));

        Separator.setBackground(new java.awt.Color(255, 255, 255));
        Separator.setForeground(new java.awt.Color(255, 255, 255));
        LoginForm.add(Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 220, 10));

        Separator2.setBackground(new java.awt.Color(255, 255, 255));
        Separator2.setForeground(new java.awt.Color(255, 255, 255));
        LoginForm.add(Separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 220, 10));

        LoginButton.setBackground(new java.awt.Color(13, 245, 227));

        Login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Login.setForeground(new java.awt.Color(30, 31, 52));
        Login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login.setText("LOGIN");
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginMouseExited(evt);
            }
        });

        javax.swing.GroupLayout LoginButtonLayout = new javax.swing.GroupLayout(LoginButton);
        LoginButton.setLayout(LoginButtonLayout);
        LoginButtonLayout.setHorizontalGroup(
            LoginButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        LoginButtonLayout.setVerticalGroup(
            LoginButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        LoginForm.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 160, 50));

        Exit.setBackground(new java.awt.Color(104, 101, 112));
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
        LoginForm.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 30, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(116, 113, 126));
        jLabel7.setText("Please sign in to continue");
        LoginForm.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        SignUp.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        SignUp.setForeground(new java.awt.Color(13, 245, 227));
        SignUp.setText("Sign Up");
        SignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignUpMouseExited(evt);
            }
        });
        LoginForm.add(SignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 60, -1));

        CapsLock.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        CapsLock.setForeground(new java.awt.Color(116, 113, 126));
        CapsLock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CapsLock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CapsLockKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CapsLockKeyTyped(evt);
            }
        });
        LoginForm.add(CapsLock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 300, 40));

        Info.setBackground(new java.awt.Color(255, 255, 255));
        Info.setForeground(new java.awt.Color(255, 255, 255));

        information.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        information.setForeground(new java.awt.Color(116, 113, 126));
        information.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        information.setText("i");
        information.setToolTipText("Press CTRL+S to show password.");

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

        LoginForm.add(Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 20, 20));

        error5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        error5.setForeground(new java.awt.Color(181, 45, 45));
        error5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/warningmessage.png"))); // NOI18N
        error5.setText("Please input your password");
        LoginForm.add(error5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 260, 30));

        error6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        error6.setForeground(new java.awt.Color(181, 45, 45));
        error6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/warningmessage.png"))); // NOI18N
        error6.setText("Please input your username");
        LoginForm.add(error6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 260, 30));

        getContentPane().add(LoginForm, "card4");

        SignupForm.setBackground(new java.awt.Color(31, 25, 46));
        SignupForm.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                SignupFormMouseDragged(evt);
            }
        });
        SignupForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignupFormMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SignupFormMousePressed(evt);
            }
        });
        SignupForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CreateAccount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CreateAccount.setForeground(new java.awt.Color(255, 255, 255));
        CreateAccount.setText("Create Account");
        SignupForm.add(CreateAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        PleaseFIll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PleaseFIll.setForeground(new java.awt.Color(116, 113, 126));
        PleaseFIll.setText("Please fill the input below here ");
        SignupForm.add(PleaseFIll, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        UserIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/user.png"))); // NOI18N
        SignupForm.add(UserIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 30, 30));

        TextPrompt createfullname = new TextPrompt("Username", UserName);
        createfullname.setForeground(new java.awt.Color(107, 102, 117));
        createfullname.setFont(new java.awt.Font("Segoe UI", 1, 13));
        UserName.setBackground(new java.awt.Color(31, 25, 46));
        UserName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        UserName.setForeground(new java.awt.Color(255, 255, 255));
        UserName.setBorder(null);
        UserName.setCaretColor(new java.awt.Color(255, 255, 255));
        UserName.setSelectedTextColor(new java.awt.Color(0, 255, 255));
        UserName.setSelectionColor(new java.awt.Color(31, 25, 46));
        UserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UserNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UserNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UserNameKeyTyped(evt);
            }
        });
        SignupForm.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 180, 30));

        Separator3.setBackground(new java.awt.Color(255, 255, 255));
        Separator3.setForeground(new java.awt.Color(255, 255, 255));
        SignupForm.add(Separator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 220, -1));

        PasswordIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/address.png"))); // NOI18N
        SignupForm.add(PasswordIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 30, 30));

        TextPrompt confirmpass = new TextPrompt("Address", UserAddr);
        confirmpass.setForeground(new java.awt.Color(107, 102, 117));
        confirmpass.setFont(new java.awt.Font("Segoe UI", 1, 13));
        UserAddr.setBackground(new java.awt.Color(31, 25, 46));
        UserAddr.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        UserAddr.setForeground(new java.awt.Color(255, 255, 255));
        UserAddr.setBorder(null);
        UserAddr.setCaretColor(new java.awt.Color(255, 255, 255));
        UserAddr.setSelectedTextColor(new java.awt.Color(0, 255, 255));
        UserAddr.setSelectionColor(new java.awt.Color(31, 25, 46));
        UserAddr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserAddrActionPerformed(evt);
            }
        });
        UserAddr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UserAddrKeyTyped(evt);
            }
        });
        SignupForm.add(UserAddr, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 180, 30));

        PasswordIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/lock.png"))); // NOI18N
        SignupForm.add(PasswordIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 30, 30));

        TextPrompt phone = new TextPrompt("Create Password", CreatePassword);
        phone.setForeground(new java.awt.Color(107, 102, 117));
        phone.setFont(new java.awt.Font("Segoe UI", 1, 13));
        CreatePassword.setBackground(new java.awt.Color(31, 25, 46));
        CreatePassword.setEchoChar((char)0);
        CreatePassword.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        CreatePassword.setForeground(new java.awt.Color(255, 255, 255));
        CreatePassword.setBorder(null);
        CreatePassword.setCaretColor(new java.awt.Color(255, 255, 255));
        CreatePassword.setSelectedTextColor(new java.awt.Color(0, 255, 255));
        CreatePassword.setSelectionColor(new java.awt.Color(31, 25, 46));
        CreatePassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CreatePasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CreatePasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CreatePasswordKeyTyped(evt);
            }
        });
        SignupForm.add(CreatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 180, 30));

        Separator4.setBackground(new java.awt.Color(255, 255, 255));
        Separator4.setForeground(new java.awt.Color(255, 255, 255));
        SignupForm.add(Separator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 220, 10));

        PasswordIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/fullname.png"))); // NOI18N
        SignupForm.add(PasswordIcon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 30, 30));

        TextPrompt useranswer = new TextPrompt("Full Name", UserFullName);
        useranswer.setForeground(new java.awt.Color(107, 102, 117));
        useranswer.setFont(new java.awt.Font("Segoe UI", 1, 13));
        UserFullName.setBackground(new java.awt.Color(31, 25, 46));
        UserFullName.setEchoChar((char)0);
        UserFullName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        UserFullName.setForeground(new java.awt.Color(255, 255, 255));
        UserFullName.setBorder(null);
        UserFullName.setCaretColor(new java.awt.Color(255, 255, 255));
        UserFullName.setSelectedTextColor(new java.awt.Color(0, 255, 255));
        UserFullName.setSelectionColor(new java.awt.Color(31, 25, 46));
        UserFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserFullNameActionPerformed(evt);
            }
        });
        UserFullName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UserFullNameKeyTyped(evt);
            }
        });
        SignupForm.add(UserFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 180, 30));

        Separator5.setBackground(new java.awt.Color(255, 255, 255));
        Separator5.setForeground(new java.awt.Color(255, 255, 255));
        SignupForm.add(Separator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 220, 10));

        PasswordIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/phone.png"))); // NOI18N
        SignupForm.add(PasswordIcon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 30, 30));

        Separator6.setBackground(new java.awt.Color(255, 255, 255));
        Separator6.setForeground(new java.awt.Color(255, 255, 255));
        SignupForm.add(Separator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 220, 10));

        SignupButton.setBackground(new java.awt.Color(13, 245, 227));

        SignUp2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SignUp2.setForeground(new java.awt.Color(30, 31, 52));
        SignUp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SignUp2.setText("SIGN UP");
        SignUp2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignUp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignUp2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignUp2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignUp2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout SignupButtonLayout = new javax.swing.GroupLayout(SignupButton);
        SignupButton.setLayout(SignupButtonLayout);
        SignupButtonLayout.setHorizontalGroup(
            SignupButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SignupButtonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SignUp2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SignupButtonLayout.setVerticalGroup(
            SignupButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SignupButtonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SignUp2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        SignupForm.add(SignupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 160, 50));

        DontHaveAccount1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        DontHaveAccount1.setForeground(new java.awt.Color(116, 113, 126));
        DontHaveAccount1.setText("Already have an account?");
        SignupForm.add(DontHaveAccount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, -1, 40));

        Signinnow.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Signinnow.setForeground(new java.awt.Color(13, 245, 227));
        Signinnow.setText("Sign in");
        Signinnow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Signinnow.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SigninnowFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SigninnowFocusLost(evt);
            }
        });
        Signinnow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SigninnowMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SigninnowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SigninnowMouseExited(evt);
            }
        });
        SignupForm.add(Signinnow, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 610, 60, 40));

        Separator8.setBackground(new java.awt.Color(255, 255, 255));
        Separator8.setForeground(new java.awt.Color(255, 255, 255));
        SignupForm.add(Separator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 220, 10));

        Info1.setBackground(new java.awt.Color(255, 255, 255));
        Info1.setForeground(new java.awt.Color(255, 255, 255));

        information2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        information2.setForeground(new java.awt.Color(116, 113, 126));
        information2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        information2.setText("i");
        information2.setToolTipText("Press CTRL+S to show password.");

        javax.swing.GroupLayout Info1Layout = new javax.swing.GroupLayout(Info1);
        Info1.setLayout(Info1Layout);
        Info1Layout.setHorizontalGroup(
            Info1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Info1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(information2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Info1Layout.setVerticalGroup(
            Info1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Info1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(information2))
        );

        SignupForm.add(Info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 20, 20));

        ValidatePass.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        SignupForm.add(ValidatePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 260, 30));

        error4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        error4.setForeground(new java.awt.Color(181, 45, 45));
        error4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/warningmessage.png"))); // NOI18N
        error4.setText("Please fill in this field");
        SignupForm.add(error4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 260, 30));

        Error.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SignupForm.add(Error, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 300, 20));

        error1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        error1.setForeground(new java.awt.Color(181, 45, 45));
        error1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/warningmessage.png"))); // NOI18N
        error1.setText("Please fill in this field");
        SignupForm.add(error1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 260, 30));

        error2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        error2.setForeground(new java.awt.Color(181, 45, 45));
        error2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/warningmessage.png"))); // NOI18N
        error2.setText("Please fill in this field");
        error2.setToolTipText("");
        SignupForm.add(error2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 260, 30));

        error3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        error3.setForeground(new java.awt.Color(181, 45, 45));
        error3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/warningmessage.png"))); // NOI18N
        error3.setText("Mobile no. must be 12 digits long");
        SignupForm.add(error3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 260, 30));

        Info2.setBackground(new java.awt.Color(255, 255, 255));
        Info2.setForeground(new java.awt.Color(255, 255, 255));

        information1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        information1.setForeground(new java.awt.Color(116, 113, 126));
        information1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        information1.setText("i");
        information1.setToolTipText("Please include your country code e.g 639128562896");

        javax.swing.GroupLayout Info2Layout = new javax.swing.GroupLayout(Info2);
        Info2.setLayout(Info2Layout);
        Info2Layout.setHorizontalGroup(
            Info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Info2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(information1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Info2Layout.setVerticalGroup(
            Info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Info2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(information1))
        );

        SignupForm.add(Info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, -1));

        TextPrompt createpass = new TextPrompt("Mobile No.", UserPhoneNo);
        createpass.setForeground(new java.awt.Color(107, 102, 117));
        createpass.setFont(new java.awt.Font("Segoe UI", 1, 13));
        UserPhoneNo.setBackground(new java.awt.Color(31, 25, 46));
        UserPhoneNo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        UserPhoneNo.setForeground(new java.awt.Color(255, 255, 255));
        UserPhoneNo.setBorder(null);
        UserPhoneNo.setCaretColor(new java.awt.Color(255, 255, 255));
        UserPhoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserPhoneNoActionPerformed(evt);
            }
        });
        UserPhoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UserPhoneNoKeyTyped(evt);
            }
        });
        SignupForm.add(UserPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 180, 30));

        BrandIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BrandIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/brandIcon9.png"))); // NOI18N
        BrandIcon2.setToolTipText("");
        SignupForm.add(BrandIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 300, 40));

        getContentPane().add(SignupForm, "card3");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        initialClick = evt.getPoint();
        getComponentAt(initialClick);
      
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // get location of Window
            int thisX = this.getLocation().x;
            int thisY = this.getLocation().y;

            // Determine how much the mouse moved since the initial click
            int xMoved = evt.getX() - initialClick.x;
            int yMoved = evt.getY() - initialClick.y;

            // Move window to this position
            int X = thisX + xMoved;
            int Y = thisY + yMoved;
            this.setLocation(X, Y);
            new Success(this, true).setLocation(X , Y);
    }//GEN-LAST:event_formMouseDragged

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        ConfirmDialog invoke = new ConfirmDialog(this, true);
        invoke.setLocationRelativeTo(this);
        Exit.setForeground(new java.awt.Color(104, 101, 112));
          Toolkit.getDefaultToolkit().beep();
       invoke.setVisible(true);
       
       
    }//GEN-LAST:event_ExitMouseClicked

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
       Exit.setForeground(new java.awt.Color(255, 119, 119));
    }//GEN-LAST:event_ExitMouseEntered

    private void ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseExited
       Exit.setForeground(new java.awt.Color(104, 101, 112));
    }//GEN-LAST:event_ExitMouseExited

    private void LoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMouseEntered
       Login.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_LoginMouseEntered

    private void LoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMouseExited
        Login.setForeground(new java.awt.Color(30, 31, 50));
    }//GEN-LAST:event_LoginMouseExited

    private void SignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpMouseEntered
       SignUp.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_SignUpMouseEntered

    private void SignUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpMouseExited
       SignUp.setForeground(new java.awt.Color(13,245,227));
//     SignUp.removeMouseListener(null);
   
        
        
    }//GEN-LAST:event_SignUpMouseExited

    private void SignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpMouseClicked
         TextFieldUser.setText("");
         TextFieldPass.setText("");
         error6.setVisible(false);
         error5.setVisible(false);
        
//        this.remove(LoginForm);
          
//         this.remove(SignupForm);
        LoginForm.setVisible(false);
//       this.remove(ForgotPassForm);
       this.add(SignupForm);
       SignupForm.setVisible(true);
//       SignupForm.repaint();
//       SignupForm.revalidate();
        
    }//GEN-LAST:event_SignUpMouseClicked

    private void UserAddrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserAddrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserAddrActionPerformed

    private void UserFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserFullNameActionPerformed

    private void SignUp2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUp2MouseEntered
        SignUp2.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_SignUp2MouseEntered

    private void SignUp2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUp2MouseExited
        SignUp2.setForeground(new java.awt.Color(30, 31, 50));
    }//GEN-LAST:event_SignUp2MouseExited

    private void SigninnowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SigninnowMouseClicked
     
       UserName.setText("");
       CreatePassword.setText("");
       UserFullName.setText("");
       UserPhoneNo.setText("");
       UserAddr.setText("");
       ValidatePass.setText("");
       error1.setText("Please fill in this field");
       ValidatePass.setIcon(null);
       error1.setVisible(false);
        error2.setVisible(false);
         error3.setVisible(false);
          error4.setVisible(false);

//       this.remove(SignupForm);
//       this.remove(ForgotPassForm);
//       this.add(LoginForm);
//       LoginForm.setVisible(true);
//       LoginForm.repaint();
//       this.LoginForm.revalidate();
       SignupForm.setVisible(false);
//       this.remove(ForgotPassForm);
       this.add(LoginForm);
       LoginForm.setVisible(true);
       
    }//GEN-LAST:event_SigninnowMouseClicked

    private void SigninnowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SigninnowMouseEntered
        Signinnow.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_SigninnowMouseEntered

    private void SigninnowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SigninnowMouseExited
       
        Signinnow.setForeground(new java.awt.Color(13, 245, 227));
   
    }//GEN-LAST:event_SigninnowMouseExited

    private void SigninnowFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SigninnowFocusGained
//          Signinnow.setForeground(new java.awt.Color(13, 245, 227));
    }//GEN-LAST:event_SigninnowFocusGained

    private void SigninnowFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SigninnowFocusLost
//              Signinnow.setForeground(new java.awt.Color(255, 255, 255)); 
    }//GEN-LAST:event_SigninnowFocusLost

    private void CapsLockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CapsLockKeyPressed
             
                   
    }//GEN-LAST:event_CapsLockKeyPressed

    private void CapsLockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CapsLockKeyTyped
      
         
         
    }//GEN-LAST:event_CapsLockKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
   
    }//GEN-LAST:event_formKeyTyped

    private void TextFieldUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldUserKeyPressed
    boolean isControlDown = evt.isControlDown();
        if (isControlDown == true && KeyEvent.VK_S == evt.getKeyCode()) {
             TextFieldPass.setEchoChar((char)0);
        } 
        
    }//GEN-LAST:event_TextFieldUserKeyPressed

    private void TextFieldPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldPassKeyPressed
//         if (KeyEvent.VK_ALT == evt.getKeyCode()) {
//               TextFieldPass.setEchoChar((char)0);
//            }
        boolean isControlDown = evt.isControlDown();
        if (isControlDown == true && KeyEvent.VK_S == evt.getKeyCode()) {
             TextFieldPass.setEchoChar((char)0);
        } 
      
    }//GEN-LAST:event_TextFieldPassKeyPressed

    private void TextFieldPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldPassKeyReleased
 boolean isControlDown = evt.isControlDown();
        if (isControlDown == true && KeyEvent.VK_S == evt.getKeyCode()) {
             TextFieldPass.setEchoChar('\u2022');
        }           
    }//GEN-LAST:event_TextFieldPassKeyReleased

    private void TextFieldPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldPassKeyTyped
                if(TextFieldPass.getText().length() == 16) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
                         if (TextFieldPass.getText().length() > 0) {
                        error5.setVisible(false);
            }
    }//GEN-LAST:event_TextFieldPassKeyTyped

    private void LoginFormKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginFormKeyPressed
       
    }//GEN-LAST:event_LoginFormKeyPressed

    private void TextFieldUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldUserKeyReleased

     boolean isControlDown = evt.isControlDown();
        if (isControlDown == true && KeyEvent.VK_S == evt.getExtendedKeyCode()) {
             TextFieldPass.setEchoChar('\u2022');
        } 
           
    }//GEN-LAST:event_TextFieldUserKeyReleased

    private void LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMouseClicked
        String username = TextFieldUser.getText().trim();
        String password = TextFieldPass.getText();
        
        if(TextFieldUser.getText().trim().isEmpty()) {
             error6.setVisible(true);
      }		
			
         if (TextFieldPass.getText().trim().isEmpty()) {
            error5.setVisible(true);
      }
         else {
             Login.setForeground(new java.awt.Color(30, 31, 50));
             Connection conn = SushiDBConnection.connectDB();
               if (conn == null) {
            DatabaseError dialog = new DatabaseError(this, true);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
               }
               else if (validateLogin()) {           
                   Login(username, password);
  
             }
         }
       

     
 
        
      
    }//GEN-LAST:event_LoginMouseClicked

    private void SignUp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUp2MouseClicked
           
            String username = UserName.getText().trim().replaceAll("\\s+", "");;
            String userpassword = CreatePassword.getText().trim().replaceAll("\\s+", "");;
            String userfullname = UserFullName.getText().trim();
            String userphoneno = UserPhoneNo.getText().trim().replaceAll("\\s+", "");;
            String useraddr = UserAddr.getText().trim();
             
          Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]");
   Matcher m = regex.matcher(UserFullName.getText());
                 String regEx = "(\\p{Lu})";
    Pattern pattern = Pattern.compile(regEx);
    Matcher matcher = pattern.matcher(username);
    
           if (UserName.getText().trim().isEmpty()) {
                  error1.setVisible(true);
                
           }
           if (matcher.find()) {
               error1.setText("Only lowercase letters allowed!");
               error1.setVisible(true);
           }
           if (CreatePassword.getText().isEmpty()) {
                 validatePassword(CreatePassword.getText());
           }
           if (UserFullName.getText().trim().isEmpty()) {
               error2.setVisible(true);
               
           }
           if (m.find()) {
               error2.setText("Name cannot contain special characters");
               error2.setVisible(true);
           }
           if (!UserPhoneNo.getText().startsWith("639") && !UserPhoneNo.getText().isEmpty()) {
               error3.setText("Invalid mobile No.");
               error3.setVisible(true);
               
           }
           if (UserPhoneNo.getText().trim().isEmpty() || UserPhoneNo.getText().length() != 12)  {
               error3.setText("Mobile no. must be 12 digits long");
               error3.setVisible(true);
               
           }
       
           if (UserAddr.getText().trim().isEmpty()) {
               error4.setVisible(true);
                
           }
           else {
              Connection conn = SushiDBConnection.connectDB();
              if (conn == null) {
            DatabaseError dialog = new DatabaseError(this, true);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }      
              else if (CheckDuplicateUser(username)) {
                          
                         error1.setText("Username is already taken!");
                         error1.setVisible(true);
             }
              else if (valid  && ValidateFilled()) {
                   
                
                    int length = 6;
          rand = (OTP.OTP(length));
//        String sendotp = Arrays.toString(otp);
       
        String phone = UserPhoneNo.getText();

String formattedString = Arrays.toString(rand)
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "")  //remove the left bracket
    .replaceAll("\\s+", "") // remove all spaces
    .trim();
                  System.out.println(formattedString);
                  
        
//        SendSMS sms = new SendSMS();
//          try {
//              sms.sendSMS(phone, "Hello " +UserFullName.getText().trim()+"," + " your OTP is :" + formattedString);
//          } catch (IOException ex) {
//              System.out.println(ex);
//              Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
//          }
SMS2 sms2 = new SMS2();
           sms2.sendSMS(phone, "Hello " +UserFullName.getText()+"," + " your OTP is :" +formattedString);
                       
                   SignUp2.setForeground(new java.awt.Color(30, 31, 50));   
                  OTPDialog dialog = new OTPDialog(this, true, fullname = UserFullName.getText() ,mobileno = UserPhoneNo.getText(), rand);
                  dialog.setLocationRelativeTo(this);
                  dialog.setVisible(true);
               
                  if(isvalidated) {
                   error1.setText("Please fill in this field");
                    Loading2 loading = new Loading2(this, new Loading2.Observer() {
        @Override
        public void loadingDidComplete() {
               Register(username, userpassword, userfullname, userphoneno, useraddr);
               ClearSignUp();
               isvalidated = false;
        }
    });
    
    loading.setLocationRelativeTo(this);
    loading.setVisible(true);
               
               Success dialog1 = new Success(this, true);
               dialog1.pack();
               dialog1.setLocationRelativeTo(this);
               Toolkit.getDefaultToolkit().beep();
               dialog1.setVisible(true);
                 error1.setText("Please fill in this field");
                  
        }
                    
         }
                  
                
                    
         }
      
    }//GEN-LAST:event_SignUp2MouseClicked

    private void CreatePasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CreatePasswordKeyPressed
       boolean isControlDown = evt.isControlDown();
        if (isControlDown == true && KeyEvent.VK_S == evt.getKeyCode()) {
             CreatePassword.setEchoChar((char)0);
        } 
      
          
    }//GEN-LAST:event_CreatePasswordKeyPressed

    private void CreatePasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CreatePasswordKeyReleased
           boolean isControlDown = evt.isControlDown();
        if (isControlDown == true && KeyEvent.VK_S == evt.getKeyCode()) {
             CreatePassword.setEchoChar('\u2022');
        } 
      
    }//GEN-LAST:event_CreatePasswordKeyReleased

    private void UserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserNameKeyPressed
        boolean isControlDown = evt.isControlDown();
        if (isControlDown == true && KeyEvent.VK_S == evt.getKeyCode()) {
             CreatePassword.setEchoChar((char)0);
        } 
    }//GEN-LAST:event_UserNameKeyPressed

    private void UserNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserNameKeyReleased
            boolean isControlDown = evt.isControlDown();
        if (isControlDown == true && KeyEvent.VK_S == evt.getKeyCode()) {
             CreatePassword.setEchoChar('\u2022');
        } 
    }//GEN-LAST:event_UserNameKeyReleased

    private void UserNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserNameKeyTyped
        if(UserName.getText().length() == 15 ) {
                  evt.consume();
           Toolkit.getDefaultToolkit().beep();
        }
   
            if (UserName.getText().length() > 0) {
                 error1.setText("Please fill in this field");  
                error1.setVisible(false);
            }
             
                
    }//GEN-LAST:event_UserNameKeyTyped

    private void UserFullNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserFullNameKeyTyped
       if(UserFullName.getText().length() == 50) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        
    } 
          if (UserFullName.getText().length() > 0) {
                 error2.setText("Please fill in this field");
                error2.setVisible(false);
            }
             

    }//GEN-LAST:event_UserFullNameKeyTyped

    private void TextFieldUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldUserKeyTyped
              if(TextFieldUser.getText().length() == 15) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
               if (TextFieldUser.getText().length() > 0) {
                error6.setVisible(false);
            }
                 
            
    }//GEN-LAST:event_TextFieldUserKeyTyped

    private void UserAddrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserAddrKeyTyped
             if(UserAddr.getText().length() == 100) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
              if (UserAddr.getText().length() > 0) {
                error4.setVisible(false);
            }
    }
    private boolean validatePassword(String text) {
   ValidatePass.setForeground(new java.awt.Color(181, 45, 45));
   Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]");
    Matcher m = regex.matcher(text);
     String regEx = "(\\p{Lu})";
    Pattern pattern = Pattern.compile(regEx);
    Matcher matcher = pattern.matcher(text);
		if(text.length() < 8) {
                        ValidatePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/warningmessage.png")));
			ValidatePass.setText("Password must be 8-16 characters");
			 valid = false;
                        return false;
		}
		else if(!matcher.find()) {
                        ValidatePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/warningmessage.png")));
			ValidatePass.setText("Password must contain Uppercase");
			 valid = false;
                        return false;
                  
                 
		}
                else if (text.contains(" ")) {
                         ValidatePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/warningmessage.png")));
			ValidatePass.setText("Password contains spaces");
			 valid = false;
                        return false;
                }
                else if (!m.find()) {
                        ValidatePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/warningmessage.png")));
                        ValidatePass.setText("Password must contain symbol");
                         valid = false;
                        return false;
                }
		else if(!text.matches(".*\\d.*")) {
                        ValidatePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantorderingandpayment/images/warningmessage.png")));
			ValidatePass.setText("Password must contain digits");
			 valid = false;
                        return false;
                        
		}
		
		else    valid = true;
			return true;
                       
    
             
    }//GEN-LAST:event_UserAddrKeyTyped

    private void CreatePasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CreatePasswordKeyTyped
          if(CreatePassword.getText().length() == 16) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();   
          }
              
       
             
    }//GEN-LAST:event_CreatePasswordKeyTyped

    private void UserPhoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserPhoneNoActionPerformed
        
    }//GEN-LAST:event_UserPhoneNoActionPerformed

    private void UserPhoneNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserPhoneNoKeyTyped
          if(UserPhoneNo.getText().length() == 12) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();   
          }
             if (UserPhoneNo.getText().length() > 0) {
                error3.setVisible(false);
            }
    }//GEN-LAST:event_UserPhoneNoKeyTyped

    private void SignupFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignupFormMouseClicked
    
    }//GEN-LAST:event_SignupFormMouseClicked

    private void SignupFormMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignupFormMousePressed
            initialClick = evt.getPoint();
        getComponentAt(initialClick);
    }//GEN-LAST:event_SignupFormMousePressed

    private void SignupFormMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignupFormMouseDragged
        // get location of Window
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
    }//GEN-LAST:event_SignupFormMouseDragged
    public void ClearSignUp() {
        UserName.setText("");
        CreatePassword.setText("");
        UserFullName.setText("");
        UserPhoneNo.setText("");
        UserAddr.setText("");
        
    }
    public boolean ValidateFilled() {   
         String username = UserName.getText().trim().replaceAll("\\s+", "");;
           	     String regEx = "(\\p{Lu})";
          Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]");
   Matcher m = regex.matcher(UserFullName.getText());
    Pattern pattern = Pattern.compile(regEx);
    Matcher matcher = pattern.matcher(username);
		if(UserName.getText().trim().isEmpty() || (matcher.find())) {
			 
			return false;
		}
		else if(CreatePassword.getText().isEmpty()) {
			 validatePassword(CreatePassword.getText());
			return false;
		}
		else if(UserFullName.getText().trim().isEmpty() || m.find()) {
			
			return false;
		}
                else if(UserPhoneNo.getText().trim().isEmpty() || UserPhoneNo.getText().length() != 12 || !UserPhoneNo.getText().startsWith("639")) {
			 
			return false;
                }
                else if(UserAddr.getText().trim().isEmpty()) {
			
			return false;
                }
		else 
			return true;
	}
    private boolean validateLogin() {
		
		if(TextFieldUser.getText().trim().isEmpty()) {
			
			return false;
		}
		else if (TextFieldPass.getText().trim().isEmpty()) {
			
			return false;
		} else return true;		
    
    }
    public void LoginClear() {
        TextFieldUser.setText("");
        TextFieldPass.setText("");
    }
    
          
    
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
                    ColorUIResource colorResource = new ColorUIResource(Color.red.darker().darker());
                    UIManager.put("ComboBox.background", new ColorUIResource(UIManager.getColor("TextField.background")));
javax.swing.UIManager.put("nimbusOrange",colorResource);
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
               
              
            }
            
        });
    }
    public void Register(String username, String userpassword, String userfullname, String userphoneno, String  useraddr) {
        Connection con = null;
        PreparedStatement st = null;
        
        String query = " insert into customers (customer_id, user_name, user_pass, full_name, mobile_no, user_addr)"
        + " values (null, ?, ?, ?, ?, ?)";
        con = SushiDBConnection.connectDB();
        
        try {
        st = con.prepareStatement(query);
       
        st.setString(1, username);
        st.setString(2, userpassword);
        st.setString(3, userfullname);
        st.setString(4, userphoneno);
        st.setString(5, useraddr);
        st.execute();
        
        } catch (SQLException e) {
            System.out.println("not success");
        }  finally {
            try {
      if(st != null)
                    System.out.println("close stament");
            st.close();
         } catch (SQLException e) {
                System.out.println("unable to close statement");
         }
            try {
                if (con != null) 
                    System.out.println("close connection");
                con.close();
            } catch (SQLException e) {
                System.out.println("unable to close the statement");
            }

         
    }
 }
    public void Login(String username, String password) {
    PreparedStatement st = null;
     PreparedStatement st2 = null;
    Connection con = null;
    ResultSet rs = null;
    String customerid;
    String fullname;
   
    try {    
      
    String query = "select *  from customers where BINARY user_name = ? and BINARY user_pass = ?";
    
    con = SushiDBConnection.connectDB();
    
    st  = con.prepareStatement(query);
   
   
    st.setString(1, username);
    st.setString(2, password);

    rs = st.executeQuery();
    
    //check if you have found a valid row
    if(rs.next()) {
        
         customerid = rs.getString("customer_id");
         fullname = rs.getString("full_name");
        Loading loading = new Loading(this, new Loading.Observer() {
        @Override
        public void loadingDidComplete() {
        dispose();
         MainMenu menu = new MainMenu();
        
        menu.OrderID.setText(customerid);
        menu.Welcome.setText("Welcome " +fullname);
        menu.pack();
       
        menu.setLocationRelativeTo(null);
 
        menu.setVisible(true);
        
   
        }
    });
    loading.setLocationRelativeTo(this);
    loading.setVisible(true);
   
       
        
    } else {
       InvalidAccount invoke = new InvalidAccount(this, true);
       invoke.setLocationRelativeTo(this);
       invoke.setVisible(true);

    }
    

    } catch (SQLException e) {
            System.out.println("error");
             
        } finally {
            try {
               if (st != null ) 
                   st.close();
                    System.out.println("close statement");
               } catch (SQLException e) {
                     System.out.println("unable to close statement");  
               }
               try {
                   if (con != null)
                     con.close();
                    System.out.println("close connection");
                       
               } catch (SQLException e) {
                  e.printStackTrace();
                    System.out.println("unable to close db");
            }
                try {
                if (rs != null) 
                    System.out.println("close rs");
                rs.close();
            } catch (SQLException e) {
                System.out.println("unable to close rs");
            }
    }   
}
public boolean CheckDuplicateUser(String username) {
     PreparedStatement st = null;
    Connection con = null;
    ResultSet rs = null;
    try {    
      
    String query = "select * from customers where user_name = ?";
    
    con = SushiDBConnection.connectDB();
    
    st  = con.prepareStatement(query);
   
    st.setString(1, username);

    rs = st.executeQuery();

    //check if duplicated username
    while(rs.next()) {
    String user = rs.getString("user_name");
    if (username.equals(user)) { 
          return true;
    }

    }
    

    } catch (SQLException e) {
            System.out.println("error");
             
        } finally {
            try {
               if (st != null ) 
                   st.close();
                    System.out.println("close statement");
               } catch (SQLException e) {
                     System.out.println("unable to close statement");  
               }
               try {
                   if (con != null)
                     con.close();
                    System.out.println("close connection");
                       
               } catch (SQLException e) {
                  e.printStackTrace();
                    System.out.println("unable to close db");
            }
                try {
                if (rs != null) 
                    System.out.println("close rs");
                rs.close();
            } catch (SQLException e) {
                System.out.println("unable to close rs");
            }
    }

     return false;



              
}
    
//public static ArrayList<Customer> getAllCustomer() throws ClassNotFoundException, SQLException {
//    Connection con = SushiDBConnection.connectDB();
//    Statement st;
//    st = con.createStatement();
//    String sql = "select * from customers";
//    ResultSet rst;
//    rst = st.executeQuery(sql);
//     ArrayList<Customer> customerList = new ArrayList<>();
//    while (rst.next()) {
//    Customer customer = new Customer();
//    customer.setCustomerUser("user_name");
//    customerList.add(customer);
//    System.out.println(customer);
//    }
//    return customerList;
//}
//    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BrandIcon;
    private javax.swing.JLabel BrandIcon2;
    private static javax.swing.JLabel CapsLock;
    private javax.swing.JLabel CreateAccount;
    private javax.swing.JPasswordField CreatePassword;
    private javax.swing.JLabel DontHaveAccount;
    private javax.swing.JLabel DontHaveAccount1;
    private javax.swing.JLabel Error;
    private javax.swing.JLabel Exit;
    private javax.swing.JPanel Info;
    private javax.swing.JPanel Info1;
    private javax.swing.JPanel Info2;
    private javax.swing.JLabel Login;
    private javax.swing.JPanel LoginButton;
    private javax.swing.JPanel LoginForm;
    private javax.swing.JLabel LoginTitle;
    private javax.swing.JLabel PasswordIcon;
    private javax.swing.JLabel PasswordIcon1;
    private javax.swing.JLabel PasswordIcon2;
    private javax.swing.JLabel PasswordIcon3;
    private javax.swing.JLabel PasswordIcon4;
    private javax.swing.JLabel PleaseFIll;
    private javax.swing.JSeparator Separator;
    private javax.swing.JSeparator Separator2;
    private javax.swing.JSeparator Separator3;
    private javax.swing.JSeparator Separator4;
    private javax.swing.JSeparator Separator5;
    private javax.swing.JSeparator Separator6;
    private javax.swing.JSeparator Separator8;
    private javax.swing.JLabel SignUp;
    private javax.swing.JLabel SignUp2;
    private javax.swing.JLabel Signinnow;
    private javax.swing.JPanel SignupButton;
    private javax.swing.JPanel SignupForm;
    private javax.swing.JPasswordField TextFieldPass;
    private javax.swing.JTextField TextFieldUser;
    private javax.swing.JPasswordField UserAddr;
    private javax.swing.JPasswordField UserFullName;
    private javax.swing.JLabel UserIcon;
    private javax.swing.JLabel UserIcon1;
    private javax.swing.JTextField UserName;
    public javax.swing.JTextField UserPhoneNo;
    private javax.swing.JLabel ValidatePass;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel error5;
    private javax.swing.JLabel error6;
    private javax.swing.JLabel information;
    private javax.swing.JLabel information1;
    private javax.swing.JLabel information2;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
