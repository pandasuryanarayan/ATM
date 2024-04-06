package atmsimulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StartPage extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
	JButton b1;
    
	Font f = new Font("SERIF",Font.BOLD,30);
	Font f1 = new Font("SERIF",Font.BOLD,20);
	Font f2 = new Font("SANS-SERIF",Font.BOLD,30);
	
	StartPage() {
            
        setTitle("Bank of Surya-ATM");
        setVisible(true);
        setTitle("WELCOME");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\CS\\eclipse-workspace\\surya\\src\\surya\\s logo1.jpg");
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,500);
        
        
       l1 = new JLabel("Welcome");
       l1.setBounds(350,30,150,100);
       l1.setForeground(Color.YELLOW);
       l1.setFont(f);
       
       l2 = new JLabel("TO");
       l2.setBounds(390,100,80,50);
       l2.setForeground(Color.YELLOW);
       l2.setFont(f1);
       
       l3 = new JLabel("Bank of SURYA");
       l3.setBounds(500,200,250,70);
       l3.setForeground(Color.RED);
       l3.setFont(f2);
                
       b1 = new JButton("START");
       b1.setBounds(360,380,80,50);
       b1.setBackground(Color.CYAN);
       b1.addActionListener(this);
       
       add(l1); add(l2); add(l3); add(image);
       image.add(b1);
       
       setSize(800,500);
       setBackground(Color.BLUE);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
        
		if(e.getSource() == b1){
			dispose();
            new ATM();
         }
    }
    
    public static void main(String [] args){
        new StartPage();
     }
}
