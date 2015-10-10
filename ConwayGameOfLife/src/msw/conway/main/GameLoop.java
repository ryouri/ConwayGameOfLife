package msw.conway.main;

import msw.conway.drawpanel.DrawingPanel;
import msw.conway.lifegame.LifeGame;

public class GameLoop implements Runnable{
	DrawingPanel drawingPanel;
	LifeGame lifeGame;

	long startTime;
	long nowTime;

	public GameLoop(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
		init();
	}

	private void init() {
		this.lifeGame = new LifeGame();
		this.drawingPanel.setDrawingGame(lifeGame.getDrawingGame());
		startTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		while (true) {
			//ゲーム処理
			lifeGame.process();

			drawingPanel.repaint();

			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				System.err.println("Class:GameLoop Thread.sleep() Error");
				e.printStackTrace();
			}

			if (System.currentTimeMillis() - startTime >= 60000) {
				init();
			}
		}
	}
}
