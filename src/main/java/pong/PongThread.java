package pong;

public class PongThread extends Thread {
    private static final int DELAY_MS =15;

    private final Environment environment;
    private final PongView view;
    private final PongFrame frame;

    public PongThread(Environment environment, PongView view, PongFrame frame) {
        this.environment = environment;
        this.view = view;
        this.frame = frame;
    }

    public void run() {
        while (true) {
            try {
                if (!environment.advance()) break;
            } catch (Exception e) {
                e.printStackTrace();
            }
            view.repaint();
            frame.compScore.setText(Integer.toString(environment.getCompScore()));
            frame.userScore.setText(Integer.toString(environment.getUserScore()));
            try {
                Thread.sleep(DELAY_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
