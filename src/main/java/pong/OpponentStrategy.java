package pong;

import static pong.PongView.PADDLE_HEIGHT;

public class OpponentStrategy {

    Paddle paddle;
    Ball ball;
    double velX;
    double velY;

    public void directPaddle(Paddle paddle, Ball ball) {
        this.paddle = paddle;
        this.ball = ball;
        this.velX = ball.getVelX();
        this.velY = ball.getVelY();
         if (ball.getY() < paddle.getY()) {
            paddle.setUpAccel(true);
            paddle.setDownAccel(false);
        } else if (ball.getY() > paddle.getY() + PADDLE_HEIGHT) {
            paddle.setUpAccel(false);
            paddle.setDownAccel(true);
        } else {
             paddle.setUpAccel(false);
             paddle.setDownAccel(false);
         }
    }
}
