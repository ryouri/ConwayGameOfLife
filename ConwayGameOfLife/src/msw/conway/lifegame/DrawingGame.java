package msw.conway.lifegame;

import java.awt.Color;
import java.awt.Graphics;

public class DrawingGame {

	private int pixelSize;
	private int x;
	private int y;

	private int drawableWidth;
	private int drawableHeight;

	private boolean[][] lifeArray;

	public void drawGame(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, drawableWidth, drawableHeight);
	}

	public void setSize(int panelWidth, int panelHeight) {
		this.drawableWidth = panelWidth;
		this.drawableHeight = panelHeight;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;

		this.drawableWidth = x * pixelSize;
		this.drawableHeight = y * pixelSize;
	}

	public int getDrawableWidth() {
		return drawableWidth;
	}
	public int getDrawableHeight() {
		return drawableHeight;
	}

	public void setPixelSize(int pixelSize) {
		this.pixelSize = pixelSize;
	}

	public void setLifeArray(boolean[][] lifeArray) {
		this.lifeArray = lifeArray;
	}
}
