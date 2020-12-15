package pong;

public class Environment {
    public static final double WIDTH = 700;
    public static final double HEIGHT = 500;

    private final Paddle user;
    private final Paddle opponent;
    private final Ball ball;

    public Environment(Paddle user, Paddle opponent, Ball ball) {
        this.user = user;
        this.opponent = opponent;
        this.ball = ball;
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
            opponent.move();
            opponent.getStrategy().directPaddle(opponent, ball);
            return true;
        }
        return false;
    }

    private boolean moveBall() {
        ball.move();
        return !ball.checkOutOfBounds();
    }
}
