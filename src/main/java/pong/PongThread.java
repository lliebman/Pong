package pong;

public class PongThread extends Thread {
    private static final int DELAY_MS = 80;

    private final Environment environment;
    private final PongView view;

    public PongThread(Environment environment, PongView view) {
        this.environment = environment;
        this.view = view;
    }

    public void run() {
        while (true) {
            try {
                if (!environment.advance()) break;
            } catch (Exception e) {
                e.printStackTrace();
            }
            view.repaint();
            try {
                Thread.sleep(DELAY_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
