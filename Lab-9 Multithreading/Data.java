package lab9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data {
	// store the result of coin toss
	private int result;
	// set if it is player's chance
	private boolean pChance;
	// set if it is monitor's chance
	private boolean mChance;
	// number of players
	private int nop;
	// to implement locking mechanism
	private Object lock = 1;

	public Data() {
		// Q1.
		Scanner inputStreamScanner = null;
		try {
			inputStreamScanner = new Scanner(new FileInputStream("in.txt"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		this.result = inputStreamScanner.nextInt();
		this.pChance = inputStreamScanner.nextBoolean();
		this.mChance = inputStreamScanner.nextBoolean();
		this.nop = inputStreamScanner.nextInt();

	}

	public int getResult() {

		return result;
	}

	public boolean ispChance() {
		return pChance;
	}

	public boolean ismChance() {
		return mChance;
	}

	public int getNop() {
		return nop;
	}

	public Object getLock() {
		return lock;
	}

	public void setResult(int result) {

		this.result = result;

	}

	public void setpChance(boolean pChance) {
		this.pChance = pChance;
	}

	public void setmChance(boolean mChance) {
		this.mChance = mChance;
	}

	public void setNop(int nop) {
		this.nop = nop;
	}

	public void setLock(Object lock) {
		this.lock = lock;
	}
}