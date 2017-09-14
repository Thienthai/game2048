package Logic;

import Model.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

import static Logic.Constants.myWin;

/**
 * Created by praewpatjiradecha on 9/15/2017 AD.
 */
public class Move extends JPanel {

    public void move(){
        setPreferredSize(new Dimension(340, 400));
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    resetGame();
                }
                if (!canMove()) {
                    myLose = true;
                }

                if (!myWin && !myLose) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            left();
                            break;
                        case KeyEvent.VK_RIGHT:
                            right();
                            break;
                        case KeyEvent.VK_DOWN:
                            down();
                            break;
                        case KeyEvent.VK_UP:
                            up();
                            break;
                    }
                }

                if (!myWin && !canMove()) {
                    myLose = true;
                }

                repaint();
            }
        });
        resetGame();
    }

    public void resetGame() {
        Constants.myScore = 0;
        Constants.myWin = false;
        Constants.myLose = false;
        Tile[] tile = new Tile[4 * 4];
        for (int i = 0; i < tile.length; i++) {
            tile[i] = new Tile();
        }
        addTile();
        addTile();
    }

    private void addTile() {
        java.util.List<Tile> list = availableSpace();
        if (!availableSpace().isEmpty()) {
            int index = (int) (Math.random() * list.size()) % list.size();
            Game2048.Tile emptyTime = list.get(index);
            emptyTime.value = Math.random() < 0.9 ? 2 : 4;
        }
    }
}
