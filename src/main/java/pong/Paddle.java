package pong;

public class Paddle {
    private double x, y, yVel;
    private final int PADDING = 10;
    private boolean upAccel, downAccel;
    //an arbitrary number. it just needed to be < 0
    private final double GRAVITY = 0.94;
    public Paddle(Player player){
        y = Environment.HEIGHT/2;
        if (player.equals(Player.USER)){
            //set human paddle to right side of board
            x = Environment.WIDTH - PongView.PADDLE_WIDTH - PADDING;
        } else {
            //set computer paddle to left side of board
            x = PongView.PADDLE_WIDTH + PADDING;
        }
    }

    public void move(){
        if(upAccel)
        {
            yVel -= 2;
        }else if (downAccel)
        {
            yVel += 2;
        } else if(!upAccel && !downAccel){
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
