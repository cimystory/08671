/**
 * 08-671 Exam.
 * @author Yuxi Zhang
 * andrewID : yuxiz1
 * 
 */

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MakeupGUI implements ActionListener {
    private JTextArea textArea;
    private JTextField tf1, tf2, tf3, tf4, tf5;
    private JButton button1 = new JButton("Add Item to Store");
    private JButton button2 = new JButton("Add Item to Customer Bill");
    private JButton button3 = new JButton("Pay");
    private JButton button4 = new JButton("Clear Text Area");
    private Map<String, MakeupData> map = new HashMap<String, MakeupData>();
    private List<Double> total = new ArrayList<Double>();

    
    public MakeupGUI() {
    	JFrame frame = new JFrame("Java Cash Register");
        frame.setSize(1200, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
        JPanel pane1 = new JPanel();
        JPanel pane2 = new JPanel();
        JPanel pane3 = new JPanel();
        JPanel pane4 = new JPanel();
        
        pane.add(pane1);
        pane1.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(pane2);
        pane2.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(pane3);
        pane3.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(pane4);
        pane4.setLayout(new FlowLayout(FlowLayout.CENTER));

        textArea = new JTextArea(17, 90);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JLabel label1 = new JLabel("Name of New Item to sell:");
        JLabel label2 = new JLabel("Price:");
        JLabel label3 = new JLabel("Quantity Being Purchased:");
        JLabel label4 = new JLabel("Item Name:");
        JLabel label5 = new JLabel("Cash Tendered:");
        
        tf1 = new JTextField("", 10);
        tf2 = new JTextField("", 10);
        tf3 = new JTextField("", 10);
        tf4 = new JTextField("", 10);
        tf5 = new JTextField("", 10);
        
        tf1.addActionListener(this);
        tf2.addActionListener(this);
        tf3.addActionListener(this);
        tf4.addActionListener(this);
        tf5.addActionListener(this);
        
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        
        pane1.add(label1);
        pane1.add(tf1);
        pane1.add(label2);
        pane1.add(tf2);
        pane1.add(button1);
        pane2.add(label3);
        pane2.add(tf3);
        pane2.add(label4);
        pane2.add(tf4);
        pane2.add(button2);
        pane3.add(label5);
        pane3.add(tf5);
        pane3.add(button3);
        pane3.add(button4);
        
        pane4.add(textArea);

        JScrollPane scroller = new JScrollPane(textArea);
        pane4.add(scroller);

        frame.setContentPane(pane);
        frame.setVisible(true);       
    }
    public void add(MakeupData s) {
        if (s == null) {
            throw (new IllegalArgumentException("invalid augrment"));
        } else {
            map.put(s.getItem(), s);
        }
        
    }
    

    public MakeupData search(String s) {
        if (s == null) {
            throw new IllegalArgumentException("invalid augrment");
        } else if (map.get(s) == null) {
            return null;
        }
        return map.get(s);
    }
//    public boolean isNumeric(String str){ 
//    	   Pattern pattern = Pattern.compile("[0-9]*"); 
//    	   Matcher isNum = pattern.matcher(str);
//    	   if( !isNum.matches() ){
//    	       return false; 
//    	   } 
//    	   return true; 
//    	}
    public static boolean isInteger(String value) {
    	try {  
            Integer.parseInt(value);  
            return true;  
        } catch (NumberFormatException e) {  
            return false;  
        }
    }
    public static boolean isDouble(String value) {
    	try {  
            Double.parseDouble(value);  
            if (value.contains("."))  
                return true;  
            return false;  
        } catch (NumberFormatException e) {  
            return false;  
        }
    }
    public static boolean isNumber(String value) {  
        return isInteger(value) || isDouble(value);  
    }
    public static void main(String[] args) {
    	new MakeupGUI();
    }
    public void actionPerformed(ActionEvent event) {
    	String item1 = tf1.getText();
    	String price = tf2.getText();
    	String quantity = tf3.getText();
    	String item2 = tf4.getText();
    	Font textFont = new Font(Font.MONOSPACED, Font.BOLD, 14);
        textFont.deriveFont(30);
        textArea.setFont(textFont);
    	if ((event.getSource() == button1)) {
    		int sum = 0;
    		if (tf1.getText() == null || item1.trim().equals("")) {
    			textArea.append("item missing!\r\n");
                sum++;
    		} else if (tf2.getText() == null || price.trim().equals("")) {
    			textArea.append("price missing!\r\n");
                sum++;
    		} else if (!isNumber(price)) {
    			textArea.append("price should be number!\r\n");
                sum++;
    		} else if (Double.parseDouble(price) <= 0) {
    			textArea.append("price should be greater than 0!\r\n");
                sum++;
    		} else if (map.get(item1) != null) {
    			textArea.append("item already for sale!\r\n");
                sum++;
    		}
    		if (sum == 0) {
    		MakeupData s1 = new MakeupData();
    		s1.set1(item1);
            s1.set2(Double.parseDouble(price));
            add(s1);
            String format = "%-25.25s %-20.20s %-5.5s %-3.3s %10.10s";
            String format12 = "%.2f";
            String x = String.format(format12, Double.parseDouble(price));
            tf1.setText(null);
            tf2.setText(null);
            String t1 = "New item for sale:";
            String t2 = "at";
            String t3 = "$";
            String line = String.format(format, t1, item1, t2, t3, x);
            textArea.append(line+ "\r\n");
    	}
    	}
    	if ((event.getSource() == button2)) {
    		int sum1 = 0;
    		if (tf3.getText() == null || tf3.getText().trim().equals("")) {
    			textArea.append("quantity missing!\r\n");
                sum1++;
    		} else if (tf4.getText() == null || tf4.getText().trim().equals("")) {
    			textArea.append("item missing!\r\n");
                sum1++;
    		} else if (!(quantity.matches("^[0-9]*$")) && !(quantity.matches("^-[0-9]*$"))) {
    			textArea.append("quantity should be integer!\r\n");
                sum1++;
    		} else if (Integer.parseInt(quantity) <= 0) {
    			textArea.append("quantity should be greater than 0!\r\n");
                sum1++;
    		}
    		if (sum1 == 0) {
    			String m1 = tf3.getText();
    			String m2 = tf4.getText();

    			if (search(tf4.getText()) == null) {
    				textArea.append("no such item!\r\n");
    			} else {
    				MakeupData m3 = search(tf4.getText());
        			double m4 = m3.getPrice();
    			double m5 = m4 * Integer.parseInt(m1);
    			String format13 = "%.2f";
                String x1 = String.format(format13, m5);
    			total.add(m5);
    			String format1 = "%5.5s %-20.20s %-5.5s %-3.3s %.2f %-10.10s %-3.3s %10.10s";

                tf1.setText(null);
                tf2.setText(null);
                String m6 = "at";              
                String m7 = "$";
                String m8 = "each";
    			String line1 = String.format(format1, m1, m2, m6, m7, m4, m8, m7, x1);
                textArea.append(line1+ "\r\n");
    			}
    		}
    	}
    	if ((event.getSource() == button3)) {
    		int sum3 = 0;
    		if (tf5.getText() == null || tf5.getText().trim().equals("")) {
    			textArea.append("cash missing!\r\n");
                sum3++;
    		} else if (!isNumber(tf5.getText())) {
    			textArea.append("cash should be number!\r\n");
    			sum3++;
    		} else if (Double.parseDouble(tf5.getText()) <= 0) {
    			textArea.append("cash should be greater than 0!\r\n");
                sum3++;
    		} else {
    			double totalmoney = 0;
    		
    			for (int i = 0; i < total.size(); i++) {
    				totalmoney = totalmoney + total.get(i);
    			}
    			
    			if (Double.parseDouble(tf5.getText()) < totalmoney) {
    				textArea.append("not enough cash tentered!\r\n");
    			} else {
    				String format14 = "%.2f";
                    String x5 = String.format(format14, totalmoney);
                    String x6 = String.format(format14, Double.parseDouble(tf5.getText()));
                    String x7 = String.format(format14, Double.parseDouble(tf5.getText()) - totalmoney);
    				String format3 = "%41.20s %-1.3s %10.10s";
    	            String n1 = "Total";
    	            String n2 = "cash tentered";
    	            String n3 = "change";
    	            String n4 = "$";
    	            String line5 = String.format(format3, n1, n4, x5);
    	            String line6 = String.format(format3, n2, n4, x6);
    	            String line7 = String.format(format3, n3, n4, x7);
    	            textArea.append(line5 + "\r\n");
    	            textArea.append(line6 + "\r\n");
    	            textArea.append(line7 + "\r\n");
    	            total.clear();
    			}
    		}
    	}
    	if ((event.getSource() == button4)) {
    		textArea.setText(null);
    		tf1.setText(null);
    		tf2.setText(null);
    		tf3.setText(null);
    		tf4.setText(null);
    		tf5.setText(null);
    	}
    	
    }
}
