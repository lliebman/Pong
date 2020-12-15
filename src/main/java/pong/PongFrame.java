package pong;

import javax.swing.*;
import java.awt.*;

public class PongFrame extends JFrame {
    private JLabel scoreboard;
    private Environment environment;

    public PongFrame(PongView pongView, Environment environment, PaddleKeyListener paddleListener) throws HeadlessException {
        super();
        this.environment = environment;
        setSize((int) Environment.WIDTH, (int) Environment.HEIGHT + 30);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pong");
        setLayout(new BorderLayout());

        scoreboard = new JLabel();
        scoreboard.setText("Computer: " + environment.getCompScore() + " User: " + environment.getUserScore());

        add(pongView, BorderLayout.CENTER);
        add(scoreboard, BorderLayout.SOUTH);
        addKeyListener(paddleListener);
    }
}
