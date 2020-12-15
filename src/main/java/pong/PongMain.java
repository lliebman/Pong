package pong;

public class PongMain {
    public static void main(String[] args) {
        Paddle userPaddle = new Paddle();
        Paddle compPaddle = new Paddle(new OpponentStrategy());
        Ball ball = new Ball();
        Environment environment = new Environment(userPaddle, compPaddle, ball);
        PongView pongView = new PongView(environment);
        PaddleKeyListener  keyListener = new PaddleKeyListener(userPaddle);
        PongFrame frame = new PongFrame(pongView, keyListener, environment);
        frame.setVisible(true);
        PongThread thread = new PongThread(environment, pongView, frame);
        thread.start();

    }
}
