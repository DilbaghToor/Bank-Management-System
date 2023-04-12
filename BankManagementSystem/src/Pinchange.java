import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame  implements ActionListener {

    JPasswordField pin, spin;

    JLabel nPin, rPin, cPin;

    JButton change, back;

    String oldpinnumber;

    Pinchange(String oldpinnumber){
        this.oldpinnumber = oldpinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        cPin = new JLabel("CHANGE YOUR PIN");
        cPin.setForeground(Color.white);
        cPin.setFont(new Font("Raleway",Font.BOLD,16));
        cPin.setBounds(250,280,500,35);
        image.add(cPin);

        nPin = new JLabel("New PIN:");
        nPin.setForeground(Color.white);
        nPin.setFont(new Font("Raleway",Font.BOLD,16));
        nPin.setBounds(165,320,180,25);
        image.add(nPin);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        rPin = new JLabel("Re-Enter New PIN:");
        rPin.setForeground(Color.white);
        rPin.setFont(new Font("Raleway",Font.BOLD,16));
        rPin.setBounds(165,360,180,25);
        image.add(rPin);

        spin = new JPasswordField();
        spin.setFont(new Font("Raleway",Font.BOLD,25));
        spin.setBounds(330,360,180,25);
        image.add(spin);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

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
        if(ae.getSource() == change){
            try{
                String newPin = pin.getText();
                String rePin =  spin.getText();

                if(!newPin.equals(rePin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if(newPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                      return;
                }
                if(rePin.equals("")){

                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rePin+"' where pin = '"+oldpinnumber+"'";
                String query2 = "update login set pin = '"+rePin+"' where pin = '"+oldpinnumber+"'";
                String query3 = "update signup3 set pNumber = '"+rePin+"' where pNumber = '"+oldpinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");

                setVisible(false);
                new Transaction(newPin).setVisible(true);


            }catch (Exception e){
                System.out.println(e);
            }

        }else {

        }


    }

    public static void main(String[] args) {

        new Pinchange("").setVisible(true);

    }
}
