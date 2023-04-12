import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    String pinnumber;
    JButton cash1H, cash5H, cash1T, cash2T, cash5T, cash10T, back;

    Fastcash(String pinnumber){

        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        cash1H = new JButton("Rs 100");
        cash1H.setBounds(170,415,150,30);
        cash1H.addActionListener(this);
        image.add(cash1H);

        cash5H = new JButton("Rs 500");
        cash5H.setBounds(355,415,150,30);
        cash5H.addActionListener(this);
        image.add(cash5H);

        cash1T = new JButton("Rs 1000");
        cash1T.setBounds(170,450,150,30);
        cash1T.addActionListener(this);
        image.add(cash1T);

        cash2T = new JButton("Rs 2000");
        cash2T.setBounds(355,450,150,30);
        cash2T.addActionListener(this);
        image.add(cash2T);

        cash5T = new JButton("Rs 5000");
        cash5T.setBounds(170,485,150,30);
        cash5T.addActionListener(this);
        image.add(cash5T);

        cash10T = new JButton("Rs 10000");
        cash10T.setBounds(355,485,150,30);
        cash10T.addActionListener(this);
        image.add(cash10T);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);






        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        } else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance  = 0;
                while (rs.next()){
                    if(rs.getString("type").equals("Credit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != back && (balance < Integer.parseInt(amount))){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                    Date date = new Date();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Debited','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdraw Successfully");

                   setVisible(false);
                   new Transaction(pinnumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args) {

        new Fastcash("");

    }
}
