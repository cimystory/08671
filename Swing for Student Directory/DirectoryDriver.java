import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.io.BufferedReader;
import java.io.Reader;
/**
 * Directory Class.
 * @author yuxiz
 */
public class DirectoryDriver {
    /**
     * addButton.
     */
    private JButton addButton;
    /**
     * deleteButton.
     */
    private JButton deleteButton;
    /**
     * idButton.
     */
    private JButton idButton;
    /**
     * firstNameButton.
     */
    private JButton firstNameButton;
    /**
     * lastNameButton.
     */
    private JButton lastNameButton;
    /**
     * textArea.
     */
    private JTextArea textArea;
    /**
     * JTextField.
     */
    private JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    /**
     * Student s.
     */
    private Student s;
    /**
     * Directory dir.
     */
    private Directory dir = new Directory();
    /**
     * DirectoryDriver method.
     */
    public DirectoryDriver() {
        JFrame frame = new JFrame("Online Directory");
        frame.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                tf6.requestFocus();
            }
        });
        frame.setSize(900, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ActionListener listener = new MyActionListener();
        KeyListener listener1 = new MyKeyListener();

        Font font = new Font(Font.SERIF, Font.BOLD, 20);

        JPanel pane = new JPanel();

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        JPanel pane1 = new JPanel();
        // pane1.setBackground(Color.gray);
        pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel pane2 = new JPanel();
        JPanel pane3 = new JPanel();
        JPanel pane4 = new JPanel();
        pane.add(pane1);
        pane2.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane.add(pane2);
        pane.add(pane3);
        pane3.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane.add(pane4);
        pane4.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane1.setBorder(BorderFactory.createTitledBorder("Add a new student"));
        pane2.setBorder(BorderFactory.createTitledBorder("Delete a student"));
        pane3.setBorder(BorderFactory.createTitledBorder("Search student(s)"));
        pane4.setBorder(BorderFactory.createTitledBorder("Results"));
        textArea = new JTextArea(17, 70);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JLabel label1 = new JLabel("First Name:");
        JLabel label2 = new JLabel("Last Name:");
        JLabel label3 = new JLabel("Andrew ID:");
        JLabel label4 = new JLabel("Phone Number:");
        tf1 = new JTextField("", 8);
        tf2 = new JTextField("", 8);
        tf3 = new JTextField("", 8);
        tf4 = new JTextField("", 8);
        tf5 = new JTextField("", 15);
        tf6 = new JTextField("", 15);
        tf1.addActionListener(listener);
        tf2.addActionListener(listener);
        tf3.addActionListener(listener);
        tf4.addActionListener(listener);
        tf5.addActionListener(listener);
        tf6.addActionListener(listener);
        tf6.addKeyListener(listener1);
        pane1.add(label1);
        pane1.add(tf1);
        pane1.add(label2);
        pane1.add(tf2);
        pane1.add(label3);
        pane1.add(tf3);
        pane1.add(label4);
        pane1.add(tf4);
        addButton = new JButton("Add");
        pane1.add(addButton);
        addButton.addActionListener(listener);
        JLabel label5 = new JLabel("Andrew ID:");
        pane2.add(label5);
        pane2.add(tf5);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(listener);
        pane2.add(deleteButton);
        JLabel label6 = new JLabel("Search Key:");
        pane3.add(label6);
        pane3.add(tf6);
        idButton = new JButton("By Andrew ID");
        idButton.addActionListener(listener);
        pane3.add(idButton);
        firstNameButton = new JButton("By First Name");
        firstNameButton.addActionListener(listener);
        pane3.add(firstNameButton);
        lastNameButton = new JButton("By Last Name");
        lastNameButton.addActionListener(listener);
        pane3.add(lastNameButton);
        pane4.add(textArea);
        JScrollPane scroller = new JScrollPane(textArea);
        pane4.add(scroller);
        frame.setContentPane(pane);
        frame.setVisible(true);
    }
    /**
     * class MyKeyListener.
     * @author zhangyuxi
     *
     */
    private class MyKeyListener implements KeyListener {
        /**
         * keyTyped.
         * @param e h
         */
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
        }
        /**
         * keyPressed.
         * @param e t
         */
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            String searchKey = tf6.getText();
            if (e.getSource() == tf6 && e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (searchKey == null || searchKey.length() == 0) {
                    textArea.append("Search key missing\n");
                } else if (dir.searchByAndrewId(searchKey) != null) {
                    textArea.append("Match:\n");
                    textArea.append(dir.searchByAndrewId(searchKey).toString());
                    textArea.append("\n");
                    tf6.setText(null);
                } else {
                    textArea.append("No Matches - Wrong Search Key:\n");
                    textArea.append(searchKey);
                    textArea.append("\n\n");
                    tf6.setText(null);
                    return;
                }
            }
        }
        /**
         * keyReleased.
         * @param e r
         */
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
        }
    }
    /**
     * MyActionListener.
     * @author zhangyuxi
     *
     */
    private class MyActionListener implements ActionListener {
        /**
         * actionPerformed.
         * @param event g
         */
        public void actionPerformed(ActionEvent event) {
            String firstName = tf1.getText();
            String lastName = tf2.getText();
            String andrewId = tf3.getText();
            String phoneNumber = tf4.getText();
            String andrewId1 = tf5.getText();
            String searchKey = tf6.getText();
            if (event.getSource() == addButton) {
                if (andrewId == null || andrewId.length() == 0) {
                    textArea.append("Andrew ID missing\n");
                } else if (firstName == null || firstName.length() == 0) {
                    textArea.append("First name missing\n");
                } else if (lastName == null || lastName.length() == 0) {
                    textArea.append("Last name missing\n");
                } else if (dir.searchByAndrewId(andrewId) == null) {
                    Student s1 = new Student(andrewId);
                    s1.setFirstName(firstName);
                    s1.setLastName(lastName);
                    s1.setPhoneNumber(phoneNumber);
                    dir.addStudent(s1);
                    textArea.append("Add a new student:\n");
                    textArea.append(s1.toString());
                    textArea.append("\n");
                    tf1.setText(null);
                    tf2.setText(null);
                    tf3.setText(null);
                    tf4.setText(null);
                } else {
                    textArea.append("Error: This student already exists!\n");
                    return;
                }
            }
            if (event.getSource() == deleteButton) {
                if (andrewId1 == null || andrewId1.length() == 0) {
                    textArea.append("Andrew ID missing\n");
                } else if (dir.searchByAndrewId(andrewId1) != null) {
                    textArea.append("Match - This student has been deleted:\n");
                    textArea.append(dir.searchByAndrewId(andrewId1).toString());
                    textArea.append("\n");
                    dir.deleteStudent(andrewId1);
                    tf5.setText(null);
                } else {
                    textArea.append("No Matches - Wrong Andrew ID:\n");
                    textArea.append(andrewId1);
                    textArea.append("\n");
                    tf5.setText(null);
                    return;
                }
            }
            if (event.getSource() == idButton) {
                if (searchKey == null || searchKey.length() == 0) {
                    textArea.append("Search key missing\n");
                } else if (dir.searchByAndrewId(searchKey) != null) {
                    textArea.append("Match:\n");
                    textArea.append(dir.searchByAndrewId(searchKey).toString());
                    textArea.append("\n");
                    tf6.setText(null);
                } else {
                    textArea.append("No Matches - Wrong Search Key:\n");
                    textArea.append(searchKey);
                    textArea.append("\n\n");
                    tf6.setText(null);
                    return;
                }
            }
            if (event.getSource() == firstNameButton) {
                if (searchKey == null || searchKey.length() == 0) {
                    textArea.append("Search key missing\n");
                } else if (dir.searchByFirstName(searchKey).size() != 0) {
                    textArea.append("Match:\n");
                    List<Student> list = dir.searchByFirstName(searchKey);
                    for (Student i: list) {
                        textArea.append(i.toString());
                    }
                    textArea.append("\n");
                    tf6.setText(null);
                } else {
                    textArea.append("No Matches - Wrong Search Key by First Name:\n");
                    textArea.append(searchKey);
                    textArea.append("\n\n");
                    tf6.setText(null);
                    return;
                }
            }
            if (event.getSource() == lastNameButton) {
                if (searchKey == null || searchKey.length() == 0) {
                    textArea.append("Search key missing\n");
                } else if (dir.searchByLastName(searchKey).size() != 0) {
                    textArea.append("Match:\n");
                    List<Student> list = dir.searchByLastName(searchKey);
                    for (Student i: list) {
                        textArea.append(i.toString());
                    }
                    textArea.append("\n\n");
                    tf6.setText(null);
                } else {
                    textArea.append("No Matches - Wrong Search Key by Last Name:\n");
                    textArea.append(searchKey);
                    textArea.append("\n");
                    tf6.setText(null);
                    return;
                }
            }
        }
    }
    /**
     * main.
     * @param args jjj
     * @throws FileNotFoundException nn
     * @throws IOException nnnn
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DirectoryDriver dd = new DirectoryDriver();
        FileReader fr = new FileReader(args[0]);
        CSVReader c = new CSVReader(fr);
        int lineNum = 0;
        boolean eof = false;

        while (!eof) {
            String[] values = c.readCSVLine();
            if (values == null) {
                eof = true;
            } else {
                lineNum = lineNum + 1;
                Student s = new Student(values[2]);
                s.setFirstName(values[0]);
                s.setLastName(values[1]);
                s.setPhoneNumber(values[3]);
                dd.dir.addStudent(s);
            }
        }
    }
    /**
     * CSVReader.
     * @author zhangyuxi
     *
     */
    static class CSVReader extends BufferedReader {
        /**
         * Initializes the class.
         * @param in the reader from which to read CSV lines
         */
        public CSVReader(Reader in) {
            super(in);
        }

        /**
         * This is the only additional method. It uses readLine from the superclass
         * to get a line but returns the comma separated values as in an array of
         * strings.
         * @return an array of Strings containing the values At the end of the file,
         *         readCSVLine returns null (just as readLine does).
         * @throws IOException throws IOException
         */
        public String[] readCSVLine() throws IOException {

            // Get a line by calling the superclass's readLine method
            String line = super.readLine();

            // If we're at the end of the file, readLine returns null
            // so we return null.
            if (line == null) {
                return null;
            }

            // Count up the number of commas
            int commaCount = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    commaCount = commaCount + 1;
                }
            }

            // Allocate an array of the necessary size to return the strings
            String[] values = new String[commaCount + 1];

            // In a loop, set beginIndex and endIndex to the start and end
            // positions of each argment and then use the substring method
            // to create strings for each of the comma separate values

            // Start beginIndex at the beginning of the String, position 0
            int beginIndex = 0;

            for (int i = 0; i < commaCount; i++) {
                // set endIndex to the position of the (next) comma
                int endIndex = line.indexOf(',', beginIndex);

                // if the argument begins and ends with quotes, remove them
                if (line.charAt(beginIndex) == '"' && line.charAt(endIndex - 1) == '"') {

                    // If we made it here, we have quotes around our string.
                    // Add/substract one from the start/end of the args
                    // to substring to get the value. (See else comment
                    // below for details on how this works.)
                    values[i] = line.substring(beginIndex + 1, endIndex - 1);

                } else {
                    // If we name it here, we don't have quotes around
                    // our string. Take the substring of this line
                    // from the beginIndex to the endIndex. The substring
                    // method called on a String will return the portion
                    // of the String starting with the beginIndex and up
                    // to but not including the endIndex.
                    values[i] = line.substring(beginIndex, endIndex);
                }

                // Set beginIndex to the position character after the
                // comma. (Remember, endIndex was set to the position
                // of the comma.)
                beginIndex = endIndex + 1;
            }

            // handle the value that's after the last comma
            if (line.charAt(beginIndex) == '"' && line.charAt(line.length() - 1) == '"') {
                values[commaCount] = line.substring(beginIndex + 1, line.length() - 1);
            } else {
                values[commaCount] = line.substring(beginIndex, line.length());
            }

            return values;
        }
    }

}
