package atmsimulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signup3 extends JFrame implements ActionListener{
	
    JCheckBox c1;
    JButton submit,cancel;
    String formno,name;
    
    signup3(String formno, String name){
    	this.name = name;
        this.formno=formno;
        
        setTitle("Bank of Surya-ATM");
        setLayout(null);
        setSize(850,800);
        setLocation(350,0);
        setVisible(true);
        setLocationRelativeTo(null);
        
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,10,400,40);
        add(l1);
        
        
        JLabel card=new JLabel("Account Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,180,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-2433");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,180,250,30);
        add(number);
        
        JLabel accountdetail=new JLabel("Your 16 Account Number");
        accountdetail.setFont(new Font("Raleway",Font.BOLD,12));
        accountdetail.setBounds(100,210,300,20);
        add(accountdetail);
        
        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,250,200,30);
        add(pin);
        
        JLabel pdetail=new JLabel("Your 4 Digit PIN Number");
        pdetail.setFont(new Font("Raleway",Font.BOLD,12));
        pdetail.setBounds(100,280,300,20);
        add(pdetail);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,250,200,30);
        add(pnumber);
        
    
        c1=new JCheckBox("I hereby declared that above details are correct to the best of my knowledge");
        c1.setFont(new Font("Raleway",Font.BOLD,12));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,450,600,30);
        add(c1);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,500,100,30);
        add(submit);
        submit.addActionListener(this);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,500,100,30);
        add(cancel);
        cancel.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            
            Random random=new Random();
            String Account_Number="" +Math.abs((random.nextLong() %90000000L)+504096000000000L);
            String PIN="" +Math.abs((random.nextLong() %9000L)+1000L);
            
            
            try{
                
                    conn c=new conn();
                    String q1 = "insert into signupthree values('"+formno+"','"+name+"','"+Account_Number+"','"+PIN+"')";
                    String q2 = "insert into login values('"+formno+"','"+name+"','"+Account_Number+"','"+PIN+"')";
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Account Number: "+Account_Number+"\nPin:"+PIN);
                    dispose();
                    new ATM();
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==cancel){
            dispose();
            new ATM().setVisible(true);
        }
    }
    private Object signup1() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String args[]){
        new signup3("","");
    }
}