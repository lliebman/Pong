package pong;

import java.util.Random;

public class Ball {

    private double x;
    private double y;
    private double velX;
    private double velY;
    public final int MID_OF_BALL = PongView.BALL_WIDTH / 2;

    public Ball() {
        //first position - middle of the board.
        reposition();

        //random velocity to start the game off
        velY = getRandomVelocity();
        velX = getRandomVelocity();
    }

    public void reposition() {
        x = Environment.WIDTH / 2;
        y = Environment.HEIGHT / 2;
    }

    public void toggleVelY() {
        velY = -velY;
    }

    public void toggleVelX() {
        velX = -velX;
    }

    private double getRandomVelocity() {
        //randSpeed can be any number 2-4
        double randSpeed = (Math.random() * 3 + 2);
        Random random = new Random();
        boolean randDirection = random.nextBoolean();
        return randDirection ? randSpeed : (randSpeed*-1);
    }
    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public void move() {
        x += velX;
        y += velY;
    }
}
