package pong;

public class Environment {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 40;

    private final Paddle user;
    private final Paddle opponent;
    private final Ball ball;

    public Environment(Paddle user, Paddle opponent, Ball ball) {
        this.user = user;
        this.opponent = opponent;
        this.ball = ball;
    }
}
