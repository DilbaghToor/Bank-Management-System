import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinnumber;

    MiniStatement(String pinnumber){
        setTitle("Mini Statement");

        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,220);
        add(mini);

        JLabel bank = new JLabel("State Bank of india");
        bank.setFont(new Font("Raleway",Font.BOLD,14));
        bank.setBounds(115,20,600,40);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel bal = new JLabel();
        bal.setBounds(20,400,300,20);
        add(bal);

        try{
            Conn conn = new Conn();
            String query = "select * from login where pin = '"+pinnumber+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                card.setText("Card Number: XXXXXXXX"+ rs.getString("cardNumber").substring(14,18) );
            }

        }catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            int balance = 0;
            String query1 = "select * from bank where pin = '"+pinnumber+"'";
            ResultSet rs = conn.s.executeQuery(query1);
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br> <html>");
                if (rs.getString("type").equals("Credit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }

            }
            bal.setText("Your current account balance is Rs "+ balance);

        }catch(Exception e){
            System.out.println(e);
        }


        setSize(400,600);
        setLocation(300,0);
        setVisible(true);
    }

    public static void main(String[] args) {

        new MiniStatement("");

    }
}
