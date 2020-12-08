package pong;

public class Ball {
    private Paddle humanPaddle;
    private Paddle compPaddle;

    private double x;
    private double y;
    private double velX;
    private double velY;
    private final int MID_OF_BALL = PongView.BALL_WIDTH / 2;

    public Ball(Paddle humanPaddle, Paddle compPaddle) {
        //first position - middle of the board.
        x = PongFrame.WIDTH / 2;
        y = PongFrame.HEIGHT / 2;
        velY = 1;
        velX = -2;
        this.humanPaddle = humanPaddle;
        this.compPaddle = compPaddle;
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
        checkPaddleCollide();
        checkWallCollide();
    }

    public void checkWallCollide() {
        if (this.y >= PongFrame.HEIGHT - MID_OF_BALL || this.y <= MID_OF_BALL){
            velX = -velX;
        }

    }

    public void checkPaddleCollide() {
        //check for collision with (humanPaddle) OR (compPaddle)
        if ((this.x >= humanPaddle.getX() + PongView.PADDLE_WIDTH - MID_OF_BALL &&
                this.y >= humanPaddle.getY() &&
                this.y >= humanPaddle.getY() + PongView.PADDLE_HEIGHT) ||
                (this.x <= humanPaddle.getX() + PongView.PADDLE_WIDTH - MID_OF_BALL &&
                        this.y >= compPaddle.getY() &&
                        this.y <= compPaddle.getY() + PongView.PADDLE_HEIGHT)) {
            velY = -velY;
        }
    }
}
