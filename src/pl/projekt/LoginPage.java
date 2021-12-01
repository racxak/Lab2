package pl.projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.HashMap;

public class LoginPage extends JFrame implements ActionListener {

    private HashMap<String, String> userData = new HashMap<>();
    private JButton bLogin, bClear, tbLogin, tbClear;
    private JLabel lUsername, lPassword, loginError;
    private JTextField tLogin;
    private JPasswordField pPassword;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem mLogin, mClear, mExit;
    private JToolBar toolbar;

    public LoginPage(){

        setBounds(100, 100, 450, 300);
        setLayout(null);

        createButtons();
        createLabels();

        tLogin = createTextField(180, 70, 100, 20);
        pPassword = createPasswordField(180, 120, 100, 20);

        toolbar = createToolBar(0, 0, 450, 30);
        createToolBarButtons();


        menu = new JMenu("MENU");

        createMenuItems();
        menuBar = createMenuBar();

        storageUsersDataInfo();
    }
    private void createButtons(){
        bLogin = createButton("Login",80,200,90,20);
        bClear = createButton("Clear",250,200,90,20);
    }

    private JButton createButton(String name,int x, int y, int width, int height) {
        JButton jButton = new JButton(name);
        jButton.setBounds(x,y,width,height);
        add(jButton);
        jButton.addActionListener(this);
        return jButton;
    }

    private void createLabels(){
        lUsername = createLabel("Username:",80,70,90,20);
        lPassword = createLabel("Password:",80,120,90,20);
    }

    private JLabel createLabel(String name,int x, int y, int width, int height) {
        JLabel jLabel = new JLabel(name);
        jLabel.setBounds(x,y,width,height);
        add(jLabel);
        return jLabel;
    }

    private JTextField createTextField(int x, int y, int width, int height){
        JTextField jTextField = new JTextField("");
        jTextField.setBounds(x,y,width,height);
        add(jTextField);
        jTextField.addActionListener(this);
        return jTextField;
    }

    private JPasswordField createPasswordField(int x, int y, int width, int height){
        JPasswordField jPasswordField = new JPasswordField("");
        jPasswordField.setBounds(x,y,width,height);
        add(jPasswordField);
        jPasswordField.addActionListener(this);
        return jPasswordField;
    }

    private void createToolBarButtons(){
        tbLogin = createToolBarButton("Login");
        tbClear = createToolBarButton("Clear");
    }

    private JToolBar createToolBar(int x,int y, int width, int height){
        JToolBar jToolBar = new JToolBar();
        jToolBar.setBounds(x,y,width,height);
        getContentPane().add(jToolBar);
        return jToolBar;
    }

    private JButton createToolBarButton(String name) {
        JButton jButton = new JButton(name);
        toolbar.add(jButton);
        jButton.addActionListener(this);
        return jButton;
    }

    private JMenuItem createMenuItem(String name, char mnemonic){
        JMenuItem jMenuItem = new JMenuItem(name);
        jMenuItem.setMnemonic(mnemonic);
        menu.add(jMenuItem);
        jMenuItem.addActionListener(this);
        return jMenuItem;
    }

    private void createMenuItems(){
        mLogin = createMenuItem("Login",'L');
        mClear = createMenuItem("Clear",'C');
        menu.addSeparator();
        mExit = createMenuItem("Exit",'E');
    }

    private JMenuBar createMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        jMenuBar.add(menu);
        return jMenuBar;
    }
    public void storageUsersDataInfo() {
        userData.put("bob", "1");
        userData.put("boba", "bobazz1");
        userData.put("username3", "pizza3");
        userData.put("username4", "pizza4");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == bLogin || source == mLogin || source == tbLogin) {
            String username = tLogin.getText();
            if (tLogin.getText().isEmpty()){
                loginError = createLabel("Enter your username",180,45,160,20);
                loginError.setForeground(Color.RED);
                loginError.setFont(new Font("SansSerif",Font.BOLD,10) );
                pPassword.setText("");
            }
            else if (userData.containsKey(username)) {
                if (Arrays.equals(userData.get(username).toCharArray(), pPassword.getPassword())) {
                    getContentPane().setBackground(Color.GREEN);                                         //dobry login i hasło - akceptacja
                } else {                                                                                    //dobry login, złe hasło - błąd
                    getContentPane().setBackground(Color.RED);
                    pPassword.setText("");
                }
            } else {                                                                                         //złe login i hasło - błąd
                getContentPane().setBackground(Color.RED);
                pPassword.setText("");
            }
        } else if (source == bClear || source == mClear || source == tbClear) {
            tLogin.setText("");
            pPassword.setText("");
            getContentPane().setBackground(null);

        } else if (source == mExit)
            dispose();                                                                                 //zamknięcie okna
    }
}
