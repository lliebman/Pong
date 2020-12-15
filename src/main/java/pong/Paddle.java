package pong;

public class Paddle {
    private final double x;
    private double y;
    private double yVel;
    private final int SIDE_PADDING = 10;
    private final int BOTTOM_PADDING = 30;
    private boolean upAccel, downAccel;
    private OpponentStrategy strategy;

    //user paddle constructor
    public Paddle(){
        y = Environment.HEIGHT/2;
        x = Environment.WIDTH - PongView.PADDLE_WIDTH * 3;
    }
    //computer paddle constructor
    public Paddle(OpponentStrategy strategy){
        this.strategy = strategy;
        y = Environment.HEIGHT/2;
        //left of screen
        x = PongView.PADDLE_WIDTH + SIDE_PADDING;
    }

    public OpponentStrategy getStrategy() throws Exception {
        if (strategy != null) {
            return strategy;
        } throw new Exception("No strategy found");
    }

    public void move(){
        if(upAccel)
        {
            yVel -= 2;
        }else if (downAccel)
        {
            yVel += 2;
        } else {
            //an arbitrary number. it just needed to be < 0
            double GRAVITY = 0.94;
            yVel *= GRAVITY;
        }

        y += yVel;

        //make sure paddle doesn't go off the sides
        if (y < 0){
            y = 0;
        }
        if (y > Environment.HEIGHT - PongView.PADDLE_HEIGHT - BOTTOM_PADDING){
            y = Environment.HEIGHT - PongView.PADDLE_HEIGHT - BOTTOM_PADDING;
        }
    }

    public void setUpAccel(boolean upAccel){
        this.upAccel = upAccel;
    }

    public void setDownAccel(boolean downAccel){
        this.downAccel = downAccel;
    }

    public int getY(){
        return (int)y;
    }

    public int getX(){
        return (int)x;
    }
}
