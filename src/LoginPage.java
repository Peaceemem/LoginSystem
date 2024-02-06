import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class LoginPage implements ActionListener {
   //to instant
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordlabel1 = new JLabel("password:");
    JLabel messageLabel = new JLabel();
    HashMap<String,String> logininfo = new HashMap<String,String>();
    LoginPage(HashMap<String,String> logininfoOriginal){
        logininfo = logininfoOriginal;
        //lets set our component
        userIDLabel.setBounds(50, 100,75,25);
        userPasswordlabel1.setBounds(50, 150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));


        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);


        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.add(userIDLabel);
        frame.add(userPasswordlabel1);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //this line of code allows u to reset the userIDField and userPasswordField
        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource()==loginButton) {
            String userID = userIDField.getText();
            // since it uses a JPasswordField instead of a text field, we are usinf different means
            String password = String.valueOf(userPasswordField.getPassword());// it is going to retrieve the password that we typed and convert it to string and then store into a string called password
            // verifying password while refering to our hashmap
         if(logininfo.containsKey(userID)){
             if(logininfo.get(userID).equals(password)){
               messageLabel.setForeground(Color.green);
               messageLabel.setText("Login successful");
               //to get rid of our frame
                 frame.dispose();
               //we are going to lunch the instance of our welcome page
                 WelcomePage welcomePage = new WelcomePage(userID);
             }
             else {
                 messageLabel.setForeground(Color.red);
                 messageLabel.setText("wrong password");
             }
         }
         // incase of userID that we do not locate
            else {
             messageLabel.setForeground(Color.red);
             messageLabel.setText("username not found");
         }
        }


    }
}
