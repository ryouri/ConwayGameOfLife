package msw.conway.drawpanel;

import javax.swing.JFrame;

public class DrawingFrame extends JFrame {
	DrawingPanel drawingPanel;

    public DrawingFrame() {
    	init();
    }

    private void init() {
        setTitle("Conway's Game of Life");

        drawingPanel = new DrawingPanel(this);
        this.getContentPane().add(drawingPanel);

        pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

	public DrawingPanel getDrawingPanel() {
		return drawingPanel;
	}
}
