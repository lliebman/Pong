package pong;

public class Paddle {
    private int x, y;

    public Paddle(Player player){
        y = PongFrame.HEIGHT/2;
        if (player.equals(Player.USER)){
            //set human paddle to right side of board
            x = PongFrame.WIDTH - PongView.PADDLE_WIDTH;
        } else {
            //set computer paddle to left side of board
            x = PongView.PADDLE_WIDTH;
        }
    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }
}
