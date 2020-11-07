package lab9;

import java.util.Random;

public class Player implements Runnable {
	private Data d; // shared object
	Random rand = new Random(); // random number generator

	public Player(Data d) {
		this.d = d;
	}

	public void run() {

		synchronized (d.getLock()) {
			while (d.ismChance()) {
				try {
					System.out.println("Player waiting");
					d.getLock().wait();
					;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println("Player changing values");
			d.setResult(rand.nextInt(2));
			d.setmChance(true);
			d.setpChance(false);
			d.getLock().notifyAll();
		}
	}
}
