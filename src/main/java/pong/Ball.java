package pong;

public class Ball {
    private Paddle userPaddle;
    private Paddle compPaddle;

    private double x;
    private double y;
    private double velX;
    private double velY;
    public final int MID_OF_BALL = PongView.BALL_WIDTH / 2;

    public Ball(Paddle userPaddle, Paddle compPaddle) {
        //first position - middle of the board.
        x = Environment.WIDTH / 2;
        y = Environment.HEIGHT / 2;

        //random velocity to start the game off
        velY = getRandomVelocity();
        velX = getRandomVelocity();
        this.userPaddle = userPaddle;
        this.compPaddle = compPaddle;
    }

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getVelX() {
        return velX;
    }

    public double getVelY() {
        return velY;
    }

    private double getRandomVelocity() {
        //randSpeed can be any number 2-4
        double randSpeed = (Math.random() * 3 + 2);
        double randDirection = Math.random() * 2;
        //randDirection will be assigned as either 1 or -1
        randDirection = randDirection >= 1.0? 1.0: -1.0;

        return randSpeed * randDirection;
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

    public boolean checkOutOfBounds() { //aka did someone score a point
        return this.x == 0 || this.x == Environment.WIDTH;
    }

    private void checkWallCollide() {
        if (this.y >= Environment.HEIGHT - MID_OF_BALL || this.y <= MID_OF_BALL) {
            velY = -velY;

        }
    }

    private void checkPaddleCollide() {
        if ((this.x >= userPaddle.getX() &&
                this.y >= userPaddle.getY() &&
                this.y <= userPaddle.getY() + PongView.PADDLE_HEIGHT)
                ||
                (this.x <= compPaddle.getX() + PongView.PADDLE_WIDTH &&
                        this.y >= compPaddle.getY() &&
                        this.y <= compPaddle.getY() + PongView.PADDLE_HEIGHT)) {
            velX = -velX;
        }
    }
}
