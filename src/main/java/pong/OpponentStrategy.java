package pong;

import static pong.PongView.PADDLE_HEIGHT;

public class OpponentStrategy {

    public void directPaddle(Paddle paddle, Ball ball) {
         if (ball.getY() <= paddle.getY()) {
            paddle.setUpAccel(true);
            paddle.setDownAccel(false);
        } else if (ball.getY() >= paddle.getY() + PADDLE_HEIGHT) {
            paddle.setUpAccel(false);
            paddle.setDownAccel(true);
        } else {
             paddle.setUpAccel(false);
             paddle.setDownAccel(false);
         }
    }
}
