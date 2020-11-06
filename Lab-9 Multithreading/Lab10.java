package lab9;

public class Lab10 {
	public static void main(String[] args) {
		Data d = new Data();
		Thread[] players = new Thread[d.getNop()];
		Thread monitor;

		monitor = new Monitor(d);

		for (int i = 0; i < d.getNop(); i++) {
			players[i] = new Player(d);
		}

		for (int i = 0; i < players.length; i++) {
			players[i].start();

		}

		monitor.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(((Monitor) monitor).getHeads());
		System.out.println(((Monitor) monitor).getTails());
	}
}
