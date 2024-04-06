package atmsimulation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

 class ATM extends JFrame implements ActionListener {
	    JLabel accL,pinL,l3;
	    JTextField accE;
	    JPasswordField pinE;
	    JButton loginB,balanceB,withB,transB,quitB,signup,depositB;
	    String m,j;
	    
	    Font f2 = new Font("SANS-SERIF",Font.BOLD,40);
	    
	    ATM() {
                
	    	setVisible(true);
	        setTitle("Bank of Surya-ATM");
	        setLayout(null);
	        
	        ImageIcon i1 = new ImageIcon("C:\\Users\\CS\\eclipse-workspace\\surya\\src\\surya\\s logo1.jpg");
	        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel image = new JLabel(i3);
	        image.setBounds(0,0,800,500);
	        
	     // All labels
	        
	        l3 = new JLabel("Bank of SURYA");
	        l3.setBounds(250,40,300,70);
	        l3.setForeground(Color.RED);
	        l3.setFont(f2);
	        add(l3);
	        
	        accL = new JLabel("Account Number: ");
	        accL.setBounds(220, 160, 170, 30);
	        accL.setForeground(Color.YELLOW);
	        accL.setFont(new Font("Raleway",Font.BOLD,19));
	        add(accL);
	        
	        pinL = new JLabel("PIN:");
	        pinL.setBounds(220, 200, 170, 30);
	        pinL.setForeground(Color.YELLOW);
	        pinL.setFont(new Font("Raleway",Font.BOLD,19));
	        add(pinL);
	        
	     // All Entry
	        accE = new JTextField();
	        accE.setBounds(420, 160, 150, 30);
	        accE.setFont(new Font("Arial",Font.BOLD,15));
	        add(accE);
	        
	        pinE = new JPasswordField();
	        pinE.setBounds(420, 200, 150, 30);
	        pinE.setFont(new Font("Arial",Font.BOLD,15));
	        add(pinE);
	        
	     // All Buttons
	        
	        depositB = new JButton("DEPOSIT");
	        depositB.setBackground(Color.BLACK);
	        depositB.setForeground(Color.WHITE);
	        
	        signup = new JButton("CREATE ACCOUNT");
	        signup.setForeground(Color.ORANGE);
	        signup.setBackground(Color.BLACK);
	        
	        loginB = new JButton("LOGIN");
	        loginB.setBackground(Color.BLACK);
	        loginB.setForeground(Color.WHITE);
	        
	        balanceB = new JButton("CHECK BALANCE");
	        balanceB.setBackground(Color.BLACK);
	        balanceB.setForeground(Color.WHITE);
	        
	        withB = new JButton("WITHDRAW");
	        withB.setBackground(Color.BLACK);
	        withB.setForeground(Color.WHITE);
	        
	        transB = new JButton("TRANSFER");
	        transB.setBackground(Color.BLACK);
	        transB.setForeground(Color.WHITE);
	        
	        quitB = new JButton("QUIT");
	        quitB.setBackground(Color.BLACK);
	        quitB.setForeground(Color.WHITE);
	        
	     // Button Description
	        
	        signup.setFont(new Font("SERIF",Font.BOLD,15));
	        signup.setBounds(220,300,180,40);
	        add(signup);
	        
	        depositB.setFont(new Font("Arial", Font.BOLD, 12));
	        depositB.setBounds(220,350,180,40);
	        add(depositB);
	        
	        loginB.setFont(new Font("Arial", Font.BOLD, 12));
	        loginB.setBounds(420,260,150,30);
	        add(loginB);
	        
	        balanceB.setFont(new Font("Arial", Font.BOLD, 12));
	        balanceB.setBounds(420,300,150,30);
	        add(balanceB);
	        
	        withB.setFont(new Font("Arial", Font.BOLD, 12));
	        withB.setBounds(420,340,150,30);
	        add(withB);
	        
	        transB.setFont(new Font("Arial", Font.BOLD, 12));
	        transB.setBounds(420,380,150,30);
	        add(transB);
	        
	        quitB.setFont(new Font("Arial", Font.BOLD, 12));
	        quitB.setBounds(420,420,150,30);
	        add(quitB);
	        
	        balanceB.setEnabled(false);
			withB.setEnabled(false);
			transB.setEnabled(false);
			depositB.setEnabled(false);
			
			add(image);
			
	        signup.addActionListener(this);
	        depositB.addActionListener(this);
	        loginB.addActionListener(this);
	        balanceB.addActionListener(this);
	        withB.addActionListener(this);
	        transB.addActionListener(this);
	        quitB.addActionListener(this);
            
	        setSize(800, 500);
	        setLocation(550, 200);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    }
	    
	 public void actionPerformed(ActionEvent ae){
		 if(ae.getSource()==signup) {
			 dispose();
			 new signup1();
		 }
		 if(ae.getSource()==depositB) {
			 deposit();
		 }
		 if(ae.getSource()==loginB) {
			 login();
		 }
		 if(ae.getSource()==balanceB) {
			 checkBalance();
		 }
		 if(ae.getSource()==withB) {
			 withdraw();
		 }
		 if(ae.getSource()==transB) {
			 transfer();
		 }
		 if(ae.getSource()==quitB) {
			dispose();
			new StartPage();
			}
		}
	 
	 public void login() {
		 String accountNumber = accE.getText();
		 String Pin = String.valueOf(pinE.getPassword());
		 String q1 = "select Account_Number,PIN from login where PIN='"+Pin+"';";
		 try {
			 conn c = new conn();
			 ResultSet rs = c.s.executeQuery(q1);
			 while(rs.next()) {
				 m = rs.getString(1);
				 j = rs.getString(2);
			}
				 if(accountNumber.equals(m) && Pin.equals(j)) {
					 showMessage("Login Successful!");
					 enableButtons();
				 }else{
				 	showMessage("Invalid Account number or Pin!");
				 }
		     rs.close();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 public void deposit() {
		    String accountNumber = accE.getText();
		    int amount = askAmount("Enter the Deposit Amount");
		    if (amount < 0) {
		        showMessage("Invalid Amount");
		        return;
		    }

		    String q1 = "select count(*) as count from customer_details where Account_Number='" + accountNumber + "';";
		    String q2 = "update customer_details set balance = ";
		    String q3 = "insert into customer_details values ('" + accountNumber + "','" + amount + "');";
		    String q4 = "select balance as total_balance from customer_details where Account_Number='" + accountNumber + "';";

		    try {
		        conn c = new conn();
		        ResultSet rs = c.s.executeQuery(q1);
		        if (rs.next()) {
		            int count = rs.getInt("count");
		            if (count > 0) {
		                // Account number exists, update the balance
		                ResultSet rsBalance = c.s.executeQuery(q4);
		                if (rsBalance.next()) {
		                    int currentBalance = rsBalance.getInt("total_balance");
		                    int updatedBalance = currentBalance + amount;
		                    c.s.executeUpdate(q2 + updatedBalance + " where Account_Number='" + accountNumber + "'");
		                    showMessage("Deposit Successful!\nUpdated balance: Rs" + updatedBalance);
		                }
		                
		            } else {
		                // Account number does not exist, insert a new entry
		                c.s.executeUpdate(q3);
		                showMessage("Deposit Successful!\nBalance: Rs" + amount);
		            }
		        }
		        rs.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

	 
	 public void checkBalance() {
		 String accountNumber = accE.getText();
		 String q1 = "select balance as total_balance from customer_details where Account_Number='"+accountNumber+"';";
		 try {
			 conn c = new conn();
			 ResultSet rs = c.s.executeQuery(q1);
			 if(rs.next()) {
           	  int totalbalance = rs.getInt("total_balance");
				 showMessage("Your account balance is \nRs" + totalbalance);
			 }else {
				 showMessage("Balance not found.");
			 }
            rs.close();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public void withdraw() {
		 String accountNumber = accE.getText();
		 int amount = askAmount("Enter the Withdrawal Amount");
		 String q1 = "select balance as total_balance from customer_details where Account_Number='"+accountNumber+"';";
		 String q2 = "update customer_details set balance = ";
		 try {
			 conn c = new conn();
			 ResultSet rs = c.s.executeQuery(q1);
			 if(rs.next()) {
				 int currentBalance = rs.getInt("total_balance");
				 if(amount > 0 && amount <=currentBalance) {
					 int updatedBalance = currentBalance - amount;
					 c.s.executeUpdate(q2 + updatedBalance + " where Account_Number='"+accountNumber+"'");
					 showMessage("withdrawal Successful !\nRemaining balance: Rs" + updatedBalance);
				 }else {
					 showMessage("Insufficient balance !");
				 }
			 }
			rs.close();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	  
	 public void enableButtons() {
		 balanceB.setEnabled(true);
		 withB.setEnabled(true);
		 transB.setEnabled(true);
		 depositB.setEnabled(true);	 
	 }
	 
	 public int askAmount(String message) {
		 String input = JOptionPane.showInputDialog(this,message);
		 try {
			 return(Integer.parseInt(input));
		 }catch(NumberFormatException e) {
			 showMessage("Invalid amount !");
			 return -1;
		 }
	 }

	 public void transfer() {
		 String accountNumber = accE.getText();
		 int recipientAccount = askAccount("Enter the recipient's account number");
		 if (recipientAccount < 0) {
		       showMessage("Invalid recipient's account number!");
		        return;
		    }
		 int amount = askAmount("Enter the transfer amount");
		 String q1 = "select balance as total_balance from customer_details where Account_Number='"+accountNumber+"';";
		 String q2 = "update customer_details set balance = ";
		 try {
			 conn c = new conn();
			 ResultSet rs = c.s.executeQuery(q1);
			 if(rs.next()) {
				 int currentBalance = rs.getInt("total_balance");
				 if(amount > 0 && amount <=currentBalance) {
					 int updatedBalance = currentBalance - amount;
					 c.s.executeUpdate(q2 + updatedBalance + " where Account_Number='"+accountNumber+"'");
					 showMessage("Transfer Successful !\nRemaining balance: Rs" + updatedBalance);
			 }else {
				 showMessage("Insufficient amount !");
				 }
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }

	 
	 public int askAccount(String message) {
		 String input = JOptionPane.showInputDialog(this,message);
		 try {
			 return(Integer.parseInt(input));
		 }catch(NumberFormatException e) {
			 showMessage("Invalid account number !");
			 return -1;
		 }
	 }
	 
	 public void showMessage(String message) {
		 JOptionPane.showMessageDialog(this,message, "Automated Teller Machine", JOptionPane.INFORMATION_MESSAGE);
	 }






	public static void main(String args[]) {
		new ATM();
	}
	
}
