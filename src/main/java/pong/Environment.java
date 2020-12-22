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
    private boolean scored = false;

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

    public boolean hasScored() {
        return scored;
    }

    public void userScored() {
        this.userScore++;
        scored = true;
    }

    public int getCompScore() {
        return compScore;
    }

    public void compScored() {
        this.compScore++;
        scored = true;
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
            scored = false;
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
        ball.checkPaddleCollide(user, opponent);
        ball.checkWallCollide();
        return !ball.checkBallOutOfBounds(user, opponent);
    }
}