package pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PaddleKeyListener extends KeyAdapter {

    private final Paddle paddle;

    public PaddleKeyListener(Paddle paddle) {
        this.paddle = paddle;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()) {
           //case KeyEvent.VK_DOWN -> paddle.move(Direction.South);
            //case KeyEvent.VK_UP -> paddle.move(Direction.North);
        }
    }
}