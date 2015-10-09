package msw.conway.lifegame;

import java.util.Random;

public class LifeGameWorld {

	private int width;
	private int height;

	private boolean[][] lifeArray;
	private boolean[][] tempLifeArray;

	private int generatedRate = 90;

	int[][] aroundArray = {
			{-1,  0},
			{-1,  1},
			{ 0,  1},
			{ 1,  1},
			{ 1,  0},
			{ 1, -1},
			{ 0, -1},
			{-1, -1},};


	public LifeGameWorld(int x, int y) {
		this.width = x;
		this.height = y;
		init();
	}

	private void init() {
		lifeArray = new boolean[height][width];
		tempLifeArray = new boolean[height][width];
		randomBornLife();
	}

	private void randomBornLife() {
		Random rand = new Random();
		for (int ix = 0; ix < width; ix++) {
			for (int iy = 0; iy < height; iy++) {
				if (generatedRate <= rand.nextInt(99) + 1) {
					lifeArray[iy][ix] = true;
				}
			}
		}
	}

	public void process() {
		for (int ix = 0; ix < width; ix++) {
			for (int iy = 0; iy < height; iy++) {
				tempLifeArray[iy][ix] = lifeArray[iy][ix];
			}
		}

		for (int ix = 0; ix < width; ix++) {
			for (int iy = 0; iy < height; iy++) {
				deadOrAlive(ix, iy);
			}
		}

		for (int ix = 0; ix < width; ix++) {
			for (int iy = 0; iy < height; iy++) {
				lifeArray[iy][ix] = tempLifeArray[iy][ix];
			}
		}
	}

	private void deadOrAlive(int ix, int iy) {
		int livingLifeNum = countAroundLive(ix, iy);

		if (lifeArray[iy][ix]) {
			if (livingLifeNum <= 1) {
				tempLifeArray[iy][ix] = false;
			} else if (4 <= livingLifeNum) {
				tempLifeArray[iy][ix] = false;
			}
		} else if (!lifeArray[iy][ix] && livingLifeNum == 3) {
			tempLifeArray[iy][ix] = true;
		}
	}

	private int countAroundLive(int ix, int iy) {
		int livingLifeNum = 0;
		for (int[] yx : aroundArray) {
			int y = yx[0] + iy;
			int x = yx[1] + ix;
			if (y < 0 || height <= y || x < 0 || width <= x) {
				continue;
			}
			if (lifeArray[y][x]) {
				livingLifeNum++;
			}
		}
		return livingLifeNum;
	}

	public boolean[][] getLifeArray() {
		return lifeArray;
	}


}
