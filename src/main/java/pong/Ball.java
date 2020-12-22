package pong;
//Resource:
//https://www.youtube.com/watch?v=xIqeK2hzx1I
import java.util.Random;

import static pong.Environment.BOTTOM_PADDING;
import static pong.Environment.HEIGHT;

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
        y = HEIGHT / 2;
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
    public void checkPaddleCollide(Paddle user, Paddle opponent){
        if ((this.getX() >= user.getX() &&
                this.getY() >= user.getY() &&
                this.getY() <= user.getY() + PongView.PADDLE_HEIGHT)
                ||
                (this.getX() <= opponent.getX() + PongView.PADDLE_WIDTH &&
                        this.getY() >= opponent.getY() &&
                        this.getY() <= opponent.getY() + PongView.PADDLE_HEIGHT)) {
            this.toggleVelX();
        }
    }

    public boolean checkBallOutOfBounds(Paddle user, Paddle opponent) { //aka did someone score a point
        return this.getX() > user.getX() + this.MID_OF_BALL || this.getX() < opponent.getX() + this.MID_OF_BALL;
    }

    public void checkWallCollide(){
        if (this.getY() >= HEIGHT - BOTTOM_PADDING - this.MID_OF_BALL || this.getY() <= this.MID_OF_BALL) {
            this.toggleVelY();
        }
    }
}
