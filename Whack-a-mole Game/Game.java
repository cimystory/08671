import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Game class.
 * @author yuxiz
 *
 */
public class Game {
    /**
     * buttons.
     */
    private JButton[] buttons;
    /**
     * start Button.
     */
    private JButton startButton;
    /**
     * text field of time and score.
     */
    private JTextField timef, scoref;
    /**
     * time.
     */
    private static int iTime = 20;
    /**
     * score.
     */
    private static int iScore = 0;
    /**
     * down string.
     */
    private static final String DOWN = "   ";
    /**
     * up string.
     */
    private static final String UP = ":-)";
    /**
     * hit string.
     */
    private static final String HIT = ":-(";
    /**
     * down color.
     */
    private static final Color DOWN_COLOR = Color.LIGHT_GRAY;
    /**
     * up color.
     */
    private static final Color UP_COLOR = Color.GREEN;
    /**
     * hit color.
     */
    private static final Color HIT_COLOR = Color.RED;
    /**
     * random.
     */
    private static Random random = new Random();
    /**
     * Game method.
     */
    public Game() {
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);

        JFrame frame = new JFrame("Whac-A-Mole");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();

        JPanel pane1 = new JPanel();
        pane1.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(pane1, BorderLayout.PAGE_START);

        JPanel pane2 = new JPanel();
        pane2.setLayout(new GridLayout(8, 8, 10, 10));
        pane.add(pane2, BorderLayout.CENTER);

        JLabel label1 = new JLabel("Time Left:");
        JLabel label2 = new JLabel("Score:");

        timef = new JTextField("", 8);
        timef.setEditable(false);
        scoref = new JTextField("", 8);
        scoref.setEditable(false);

        ActionListener listener = new MyActionListener();
        startButton = new JButton("Start");
        pane1.add(startButton);
        startButton.addActionListener(listener);

        pane1.add(label1);
        pane1.add(timef);
        pane1.add(label2);
        pane1.add(scoref);

        buttons = new JButton[64];
        for (int i = 0; i < 64; i++) {
            buttons[i] = new JButton("   ");
            buttons[i].setFont(font);
            buttons[i].setBackground(Color.LIGHT_GRAY);
            buttons[i].setOpaque(true);
            buttons[i].addActionListener(listener);
            pane2.add(buttons[i]);
        }

        frame.setContentPane(pane);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    /**
     * class MyActionListener.
     * @author zhangyuxi
     *
     */
    private class MyActionListener implements ActionListener {
        /**
         * actionPerformed.
         * @param event action
         */
        public void actionPerformed(ActionEvent event) {
            Thread[] gameThread = new Thread[buttons.length];
            if (event.getSource() == startButton) {
                startButton.setEnabled(false);
                iTime = 20;
                iScore = 0;
                timef.setText("" + iTime);
                scoref.setText("" + iScore);
                Thread timerThread = new Thread(new Runnable() {
                    public void run() {
                        while (iTime >= 0) {
                            try {
                                timef.setText("" + iTime);
                                iTime--;
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new AssertionError(e);
                            }
                        }
                        for (int i = 0; i < 64; i++) {
                            buttons[i].setText(DOWN);
                            buttons[i].setBackground(DOWN_COLOR);
                        }
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new AssertionError(e);
                        }
                        startButton.setEnabled(true);
                    }
                });
                timerThread.start();
                for (int i = 0; i < 64; i++) {
                    int r = random.nextInt(64);
                    JButton button = buttons[r];
                    gameThread[r] = new GameThread(button);
                    gameThread[r].start();
                }
            }
            for (int i = 0; i < buttons.length; i++) {
                if (iTime > 0) {
                    if (event.getSource() == buttons[i]) {
                        if (buttons[i].getText().equals(UP)) {
                            buttons[i].setText(HIT);
                            buttons[i].setBackground(HIT_COLOR);
                            iScore++;
                            scoref.setText("" + iScore);
                        }
                    }
                }
            }
        }
    }
    /**
     * Main.
     * @param args string
     */
    public static void main(String[] args) {
        new Game();
    }
    /**
     * GameThread class.
     * @author zhangyuxi
     *
     */
    private static class GameThread extends Thread {
        /**
         * button.
         */
        private JButton button;
        /**
         * GameThread method.
         * @param button i
         */
        GameThread(JButton button) {
            this.button = button;
            if (iTime > 0) {
                if (button.getText().equals(DOWN)) {
                    button.setText(UP);
                    button.setBackground(UP_COLOR);
                } else {
                    button.setText(DOWN);
                    button.setBackground(DOWN_COLOR);
                }
            }
        }
        /**
         * run method.
         */
        public void run() {
            while (iTime >= 0) {
                int randomSleepTime = random.nextInt(4000);
                if (!button.getText().equals(UP)) {
                    button.setText(UP);
                    button.setBackground(UP_COLOR);
                } else {
                    button.setText(DOWN);
                    button.setBackground(DOWN_COLOR);
                }
                try {
                    Thread.sleep(randomSleepTime);
                } catch (InterruptedException e) {
                    throw new AssertionError(e);
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new AssertionError(e);
                }
            }
            if (iTime == 0) {
                button.setText(DOWN);
                button.setBackground(DOWN_COLOR);
            }
        }
    }
}
