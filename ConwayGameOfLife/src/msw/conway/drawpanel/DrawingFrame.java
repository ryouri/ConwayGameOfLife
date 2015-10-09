package msw.conway.drawpanel;

import java.awt.Container;

import javax.swing.JFrame;

public class DrawingFrame extends JFrame {
	DrawingPanel drawingPanel;
	
    public DrawingFrame() {
    	init();
    }
    
    private void init() {
        setTitle("Conway's Game of Life");

        drawingPanel = new DrawingPanel();
        this.getContentPane().add(drawingPanel);

        pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

	public DrawingPanel getDrawingPanel() {
		return drawingPanel;
	}
}
