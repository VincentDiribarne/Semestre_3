package ObserverExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class observerExample {
    JFrame frame;

    public static void main(String[] args) {
        observerExample example = new observerExample();
        example.go();
    }

    public void go() {
        frame = new JFrame();
        JButton button = new JButton("Est-ce que je peux rater un cours ?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());

        frame.getContentPane().add(BorderLayout.CENTER, button);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    static class AngelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("Ne fais pas ça, tu pourrais être un jour défaillant !");
        }
    }

    static class DevilListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("Allez, vas-y, ce n'est qu'une petite absence non justifiée de rien du tout !");
        }
    }
}

