package pong;

public class Paddle {
    private final double x;
    private double y;
    private double yVel;
    private final int PADDING = 10;
    private boolean upAccel, downAccel;
    private OpponentStrategy strategy;

    public Paddle(){
        y = Environment.HEIGHT/2;
        x = Environment.WIDTH - PongView.PADDLE_WIDTH - PADDING;
    }
    public Paddle(OpponentStrategy strategy){
        this.strategy = strategy;
        y = Environment.HEIGHT/2;
        x = PongView.PADDLE_WIDTH + PADDING;
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
        } else if(!upAccel && !downAccel){
            //an arbitrary number. it just needed to be < 0
            double GRAVITY = 0.94;
            yVel *= GRAVITY;
        }

        y += yVel;

        //make sure paddle doesn't go off the sides
        if (y < 0){
            y = 0;
        }
        if (y > Environment.HEIGHT){
            y = 420;
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
