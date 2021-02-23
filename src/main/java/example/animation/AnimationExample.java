package example.animation;

import javax.swing.*;
import java.awt.*;

public class AnimationExample extends JFrame {

    public AnimationExample() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);


        SingleTimer singleTimer = new SingleTimer();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panel);

        JButton button1 = new JButton("Start");
        button1.addActionListener(e -> {
            JLabel label = new JLabel(" ");
            TimerParams params = TimerParams.of(20, 1000, (f, t) -> {
                label.setText(f + "/" + t);
            });
            singleTimer.start(params);
            panel.add(label, 0);


        });


        getContentPane().add(button1, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            AnimationExample example = new AnimationExample();
            example.setVisible(true);
        });
    }
}
