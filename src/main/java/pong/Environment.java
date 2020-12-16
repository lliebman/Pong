package pong;

public class Environment {
    public static final double WIDTH = 700;
    public static final double HEIGHT = 500;
    public static final double BOTTOM_PADDING = 30;

    private final Paddle user;
    private final Paddle opponent;
    private final Ball ball;

    private int userScore;
    private int compScore;

    public Environment(Paddle user, Paddle opponent, Ball ball) {
        this.user = user;
        this.opponent = opponent;
        this.ball = ball;
        userScore = 0;
        compScore = 0;
    }

    public int getUserScore() {
        return userScore;
    }

    public void userScored() {
        this.userScore++;
    }

    public int getCompScore() {
        return compScore;
    }

    public void compScored() {
        this.compScore++;
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getUser() {
        return user;
    }

    public Paddle getOpponent() {
        return opponent;
    }

    public boolean advance() throws Exception {
        if (moveBall()) {
            user.move();
            opponent.getStrategy().directPaddle(opponent, ball);
            opponent.move();
        } else { //point has been scored
            if (ball.getX() > user.getX()) {
                compScored();
            } else {
                userScored();
            }
            ball.reposition();
        }
        return true;
    }

    private boolean moveBall() {
        ball.move();
        checkPaddleCollide();
        checkWallCollide();
        return !checkBallOutOfBounds();
    }

    public boolean checkBallOutOfBounds() { //aka did someone score a point
        return ball.getX() > user.getX() + ball.MID_OF_BALL || ball.getX() < opponent.getX() + ball.MID_OF_BALL;
    }

    private void checkWallCollide() {
        if (ball.getY() >= Environment.HEIGHT - BOTTOM_PADDING - ball.MID_OF_BALL || ball.getY() <= ball.MID_OF_BALL) {
            ball.toggleVelY();
        }
    }

    private void checkPaddleCollide() {
        if ((ball.getX() >= user.getX() &&
                ball.getY() >= user.getY() &&
                ball.getY() <= user.getY() + PongView.PADDLE_HEIGHT)

                ||

                (ball.getX() <= opponent.getX() + PongView.PADDLE_WIDTH &&
                        ball.getY() >= opponent.getY() &&
                        ball.getY() <= opponent.getY() + PongView.PADDLE_HEIGHT)) {

            ball.toggleVelX();
        }
    }
}
