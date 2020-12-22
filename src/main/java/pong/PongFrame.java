package pong;

import javax.swing.*;
import java.awt.*;

public class PongFrame extends JFrame {
        JPanel scorePanel;
        public JLabel userScore, compScore;
        private Environment environment;

    public PongFrame(PongView pongView, PaddleKeyListener paddleListener, Environment environment) throws HeadlessException {
        super();
        setSize((int) Environment.WIDTH, (int) Environment.HEIGHT + 30);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pong");
        setLayout(new BorderLayout());

        this.environment = environment;
        add(pongView, BorderLayout.CENTER);
        addScoreBoard();
        addKeyListener(paddleListener);
    }

    private void addScoreBoard() {
        scorePanel = new JPanel();
        scorePanel.setOpaque(true);
        scorePanel.setBackground(Color.BLACK);

        userScore = new JLabel();
        userScore.setOpaque(true);
        userScore.setBackground(Color.BLACK);
        userScore.setForeground(Color.WHITE);
        userScore.setText(String.valueOf(environment.getUserScore()));

        compScore = new JLabel();
        compScore.setOpaque(true);
        compScore.setBackground(Color.BLACK);
        compScore.setForeground(Color.WHITE);
        compScore.setText(String.valueOf(environment.getCompScore()));

        scorePanel.add(compScore);
        scorePanel.add(userScore);

        add(scorePanel, BorderLayout.SOUTH);
    }
}