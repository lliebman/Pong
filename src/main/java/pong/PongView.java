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
        paintUserPaddle(g);
        paintCompPaddle(g);
        paintBall(g);

        //scoreboard?
        //demarcation lines?
    }

    private void paintBackground(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void paintUserPaddle(Graphics g) {
        g.setColor(Color.white);
        int x = environment.getUser().getX();
        int y = environment.getUser().getY();
        g.fillRect(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
    }

    private void paintCompPaddle(Graphics g) {
        g.setColor(Color.white);
        int x = environment.getOpponent().getX();
        int y = environment.getOpponent().getY();
        g.fillRect(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
    }

    private void paintBall(Graphics g) {
        g.setColor(Color.white);
        int x = environment.getBall().getX() - (BALL_WIDTH/2);
        int y = environment.getBall().getY() - (BALL_HEIGHT/2);
        g.fillOval(x, y, BALL_WIDTH, BALL_HEIGHT);
    }
}


