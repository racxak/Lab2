package pl.projekt;

import javax.swing.*;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //definiujemy operacje która będzie wykonywana po zamknięciu okienka
        loginPage.setVisible(true);
    }
}
