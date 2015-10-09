package msw.conway.lifegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LifeGame {
	DrawingGame drawingGame;
	LifeGameWorld lifeGameWorld;

	public static final String panelDrawFile = "panelData";

	public LifeGame() {
		init();
	}

	private void init() {
		drawingGame = new DrawingGame();

		try {
			readPrefFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		drawingGame.setLifeArray(lifeGameWorld.getLifeArray());
	}

	private void readPrefFile() throws FileNotFoundException {
		Scanner scan = new Scanner(new File(panelDrawFile));
		drawingGame.setPixelSize(scan.nextInt());
		int x = scan.nextInt();
		int y = scan.nextInt();
		drawingGame.setXY(x, y);

		lifeGameWorld = new LifeGameWorld(x, y);
	}

	public void process() {
		lifeGameWorld.process();
	}

	public DrawingGame getDrawingGame() {
		return drawingGame;
	}
}
