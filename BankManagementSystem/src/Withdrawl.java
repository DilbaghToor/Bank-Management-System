import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawl extends JFrame  implements ActionListener {


    JTextField amount;
    JButton withdrawl, back;

    String pinnumber;
    Withdrawl(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("  Enter the Amount you want to Withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == withdrawl){
            String swithdrawl = amount.getText();
            String stype = "Debited";
            Date date = new Date();
            if(pinnumber.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");

            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','"+stype+"','"+swithdrawl+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"The amount of Rs "+swithdrawl+" Withdraw Sucessfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);

                } catch (Exception e){
                    System.out.println(e);
                }

            }

        }else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }


    }

    public static void main(String[] args) {
        new Withdrawl("");

    }
}
