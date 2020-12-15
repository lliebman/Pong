package pong;

import javax.swing.*;
import java.awt.*;

public class PongView extends JComponent {

    public static final int BALL_HEIGHT = 20;
    public static final int BALL_WIDTH = 20;
    public static final int PADDLE_HEIGHT = 80;
    public static final int PADDLE_WIDTH = 20;
    private final Environment environment;

    public PongView(Environment environment) {
        this.environment = environment;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintBackground(g);
        paintPaddles(g);
        paintBall(g);

        //scoreboard?
        //demarcation lines?
    }

    private void paintBackground(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void paintPaddles(Graphics g) {
        g.setColor(Color.white);
    }

    private void paintBall(Graphics g) {
        g.setColor(Color.white);
    }
}


