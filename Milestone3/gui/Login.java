package gui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    JFrame login;
    JTextField username;
    JTextField password;
    JButton logButton;

    // Create the frame
    login = new JFrame("Login");
    login.setPreferredSize(500, 500); 

    // Create Text Fields
    username = new JTextField("Enter your username");
    password = new JTextField("Enter your password");

    // Create Button
    logButton = new JButton("Login");

    // Add Items to frame
    add(username);
    add(password);
    add(logButton);

}