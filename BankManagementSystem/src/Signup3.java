import javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton savAcc, currAcc, fixDepAcc, recurDepAcc ;

    JButton sumit, cancel;
    JCheckBox atmCard, intBanking, mobBanking, alert, cheBook, eStatement, dec;

    String formno ;


    Signup3(String formno){
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(200,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        savAcc = new JRadioButton("Saving Account");
        savAcc.setFont(new Font("raleway",Font.BOLD,16));
        savAcc.setBackground(Color.white);
        savAcc.setBounds(100,180,150,20);
        add(savAcc);

        fixDepAcc = new JRadioButton("Fixed Deposit Account");
        fixDepAcc.setFont(new Font("raleway",Font.BOLD,16));
        fixDepAcc.setBackground(Color.white);
        fixDepAcc.setBounds(350,180,250,20);
        add(fixDepAcc);

        currAcc = new JRadioButton("Current Account");
        currAcc.setFont(new Font("raleway",Font.BOLD,16));
        currAcc.setBackground(Color.white);
        currAcc.setBounds(100,220,150,20);
        add(currAcc);

        recurDepAcc = new JRadioButton("Recurring Deposit Account");
        recurDepAcc.setFont(new Font("raleway",Font.BOLD,16));
        recurDepAcc.setBackground(Color.white);
        recurDepAcc.setBounds(350,220,250,20);
        add(recurDepAcc);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(savAcc);
        groupAccount.add(fixDepAcc);
        groupAccount.add(currAcc);
        groupAccount.add(recurDepAcc);

        JLabel cardNo = new JLabel("Card Number");
        cardNo.setFont(new Font("Raleway", Font.BOLD,22));
        cardNo.setBounds(100,300,200,30);
        add(cardNo);

        JLabel num = new JLabel("XXXX-XXXX-XXXX-9187");
        num.setFont(new Font("Raleway", Font.BOLD,22));
        num.setBounds(330,300,300,30);
        add(num);

        JLabel cardDetail= new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD,12));
        cardDetail.setBounds(100,330,300,20);
        add(cardDetail);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pnum = new JLabel("XXXX");
        pnum.setFont(new Font("Raleway", Font.BOLD,22));
        pnum.setBounds(330,370,300,30);
        add(pnum);

        JLabel pinDetail= new JLabel("Your 4 Digit Pin Number");
        pinDetail.setFont(new Font("Raleway", Font.BOLD,12));
        pinDetail.setBounds(100,400,300,20);
        add(pinDetail);

        JLabel sevReq = new JLabel("Services Required:");
        sevReq.setFont(new Font("Raleway", Font.BOLD,22));
        sevReq.setBounds(100,450,400,30);
        add(sevReq);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setBackground(Color.white);
        atmCard.setFont(new Font("raleway",Font.BOLD,16));
        atmCard.setBounds(100,500,200,30);
        add(atmCard);

        intBanking = new JCheckBox("Internet Banking");
        intBanking.setBackground(Color.white);
        intBanking.setFont(new Font("raleway",Font.BOLD,16));
        intBanking.setBounds(350,500,200,30);
        add(intBanking);

        mobBanking = new JCheckBox("Mobile Banking");
        mobBanking.setBackground(Color.white);
        mobBanking.setFont(new Font("raleway",Font.BOLD,16));
        mobBanking.setBounds(100,550,200,30);
        add(mobBanking);

        alert = new JCheckBox("Email & SMS Alerts");
        alert.setBackground(Color.white);
        alert.setFont(new Font("raleway",Font.BOLD,16));
        alert.setBounds(350,550,200,30);
        add(alert);

        cheBook = new JCheckBox("Cheque Book");
        cheBook.setBackground(Color.white);
        cheBook.setFont(new Font("raleway",Font.BOLD,16));
        cheBook.setBounds(350,600,200,30);
        add(cheBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.white);
        eStatement.setFont(new Font("raleway",Font.BOLD,16));
        eStatement.setBounds(100,600,200,30);
        add(eStatement);

        dec = new JCheckBox("I Here by declare that the above entered details are correct to the best of my knowledge");
        dec.setBackground(Color.white);
        dec.setFont(new Font("raleway",Font.BOLD,12));
        dec.setBounds(100,680,600,30);
        add(dec);

        sumit = new JButton("Submit");
        sumit.setBackground(Color.BLACK);
        sumit.setForeground(Color.white);
        sumit.setFont(new Font("Raleway",Font.BOLD,14));
        sumit.setBounds(250,720,100,30);
        sumit.addActionListener(this);
        add(sumit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);







        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == sumit){
            String sAccType = "";
            if(savAcc.isSelected()){
                sAccType = "Saving Account";
            }else if(fixDepAcc.isSelected()){
                sAccType = "Fixed Deposit Account";
            }else if(currAcc.isSelected()){
                sAccType = "Current Account";
            }else if(recurDepAcc.isSelected()){
                sAccType = "Recurring Deposit Account";
            }
            Random random = new Random();

            String  cardNumber = "" + (Math.abs(random.nextLong() % 90000000L) + 912165340000000000L);

            String pNumber = "" + (Math.abs(random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(atmCard.isSelected()){
                facility = facility + " ATM Card";
            }else if(intBanking.isSelected()){
                facility = facility + " Internet Banking";
            }else if(mobBanking.isSelected()){
                facility = facility + " Mobile Banking";
            }else if(alert.isSelected()){
                facility = facility + " Email & SMS  Banking";
            }else if(cheBook.isSelected()){
                facility = facility + " Check Book";
            }else if(eStatement.isSelected()){
                facility = facility + " E-Statement";
            }

            try{
                if(sAccType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else{
                    Conn co = new Conn();
                    String query1 = "insert into signup3 values('"+formno+"', '"+sAccType+"','"+cardNumber+"','"+pNumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pNumber+"')";
                    co.s.executeUpdate(query1);
                    co.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: "+cardNumber+"\n Pin: "+pNumber);

                    setVisible(false);
                    new Deposit(pNumber).setVisible(true);


                }

            }catch (Exception e){
                System.out.println(e);
            }



        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);

        }
    }

    public static void main(String[] args) {

    new Signup3("");
    }
}
