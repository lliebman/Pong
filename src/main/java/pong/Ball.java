package pong;

public class Ball {

    private double x;
    private double y;
    private double velX;
    private double velY;
    public final int MID_OF_BALL = PongView.BALL_WIDTH / 2;

    public Ball() {
        //first position - middle of the board.
        reposition();

        //random velocity to start the game off
        velY = getRandomVelocity();
        velX = getRandomVelocity();
    }

    public void reposition() {
        x = Environment.WIDTH / 2;
        y = Environment.HEIGHT / 2;
    }

    public double getVelX() {
        return velX;
    }

    public double getVelY() {
        return velY;
    }

    public void toggleVelY() {
        velY = -velY;
    }

    public void toggleVelX() {
        velX = -velX;
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
    }


}
