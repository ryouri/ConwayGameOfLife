package msw.conway.drawpanel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import msw.conway.lifegame.DrawingGame;

public class DrawingPanel extends JPanel {
    private static final int PANEL_WIDTH = 240;
    private static final int PANEL_HEIGHT = 240;
    
    DrawingGame drawingGame;

    public DrawingPanel() {
    	init();
    }
    
    private void init() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        drawingGame = null;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (drawingGame != null) {
        	drawingGame.drawGame(g);
        }
    }
    
    public void setDrawingGame(DrawingGame drawingGame) {
    	this.drawingGame = drawingGame;
    }
}
