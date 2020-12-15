package pong;

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
        if (ball.getVelX() >= 0) { //ball headed away from paddle
            paddle.setDownAccel(false);
            paddle.setUpAccel(false);
            return;
        }
        int prediction = getBallPrediction();
        if (prediction < paddle.getY()) {
            paddle.setUpAccel(true);
            paddle.setDownAccel(false);
        } else {
            paddle.setUpAccel(false);
            paddle.setDownAccel(true);
        }
    }

    private int getBallPrediction() {
        //get ball y assuming infinitely tall court
        //bounce prediction off the top and bottom walls until it reaches the paddle
        double x = ball.getX();
        double y = ball.getY();
        while (x > paddle.getX()) {
            if (y >= PongFrame.HEIGHT || y <= 0) {
                velY *= -1;
            }
            x += velX;
            y += velY;
        }
        
        return (int) y;
    }

}
