package pong;

public class Paddle {
    private int x, y;
    private final int PADDING = 10;

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

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }
}
