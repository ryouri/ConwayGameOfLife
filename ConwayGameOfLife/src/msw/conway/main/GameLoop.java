package msw.conway.main;

import msw.conway.drawpanel.DrawingPanel;
import msw.conway.lifegame.LifeGame;

public class GameLoop implements Runnable{
	DrawingPanel drawingPanel;
	LifeGame lifeGame;

	public GameLoop(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
		init();
	}

	private void init() {
		this.lifeGame = new LifeGame();
		this.drawingPanel.setDrawingGame(lifeGame.getDrawingGame());
	}

	@Override
	public void run() {
		while (true) {
			//ゲーム処理
			lifeGame.process();

			drawingPanel.repaint();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("Class:GameLoop Thread.sleep() Error");
				e.printStackTrace();
			}
		}
	}
}
