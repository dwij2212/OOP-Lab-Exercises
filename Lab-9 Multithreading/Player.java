package lab9;

import java.util.Random;

public class Player extends Thread {
	private Data d; // shared object
	Random rand = new Random(); // random number generator

	public Player(Data d) {
		this.d = d;
	}

	public void run() {

		synchronized (d) {
			while (d.ismChance()) {
				try {
					System.out.println("Player waiting");
					d.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			d.setResult(rand.nextInt(2));
			d.setmChance(true);
			d.setpChance(false);
			d.notifyAll();
		}
	}
}
