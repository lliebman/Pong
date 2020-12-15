package pong;

public class PongMain {
    public static void main(String[] args) {
        Paddle userPaddle = new Paddle();
        Paddle compPaddle = new Paddle(new OpponentStrategy());
        Ball ball = new Ball(userPaddle, compPaddle);
        Environment environment = new Environment(userPaddle, compPaddle, ball);
        PongView pongView = new PongView(environment);
        PaddleKeyListener  keyListener = new PaddleKeyListener(userPaddle);
        PongThread thread = new PongThread(environment, pongView);
        thread.start();
        new PongFrame(pongView, keyListener, environment).setVisible(true);

    }
}
