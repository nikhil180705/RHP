import java.util.*;

class Worker extends Thread{
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
			w.start();
		}
	}
}