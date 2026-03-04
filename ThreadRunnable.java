import java.util.*;

class Worker implements Runnable{
	public void run() {
		display();
	}
	
	public void display() {
		System.out.println(Thread.currentThread().getId());
	}
}

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			Worker w = new Worker();
			Thread t = new Thread(w);
			t.start();
		}
	}
}