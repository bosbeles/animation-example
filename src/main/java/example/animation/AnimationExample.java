package example.animation;

import javax.swing.*;
import java.awt.*;

public class AnimationExample extends JFrame {

    public AnimationExample() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);



        AnimationTimer animationTimer = new AnimationTimer(50, 1000);

        JPanel panel = new JPanel();


        JButton button1 = new JButton("Start");
        button1.addActionListener(e->{
            JLabel label = new JLabel();
            animationTimer.start((f, t) -> {
                label.setText(f + "/" + t);
            });
            panel.add(label);
        });

        panel.add(button1);


        setContentPane(panel);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            AnimationExample example = new AnimationExample();
            example.setVisible(true);
        });
    }
}
