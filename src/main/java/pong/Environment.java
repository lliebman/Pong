package pong;

public class Environment {
    public static final double WIDTH = 700;
    public static final double HEIGHT = 500;

    private final Paddle user;
    private final Paddle opponent;
    private Ball ball;

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
        ball.move();
        if (!ball.checkOutOfBounds()) {
            user.move();
            opponent.getStrategy().directPaddle(opponent, ball);
            opponent.move();
            updatePoints();
            return true;
        }
        else {
            ball.reposition();
            return false;
        }
    }

    private void updatePoints() {
        if(ball.compSide()) {
            userScored();
        }
        if(ball.userSide()) {
            compScored();
        }
    }
}
