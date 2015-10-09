package msw.conway.main;
import msw.conway.drawpanel.DrawingFrame;


public class Main {

	public static void main(String[] args) {
		DrawingFrame drawingFrame = new DrawingFrame();
		GameLoop gameLoop = new GameLoop(drawingFrame.getDrawingPanel());
		
		Thread gameThread = new Thread(gameLoop);
		gameThread.start();
	}
}
