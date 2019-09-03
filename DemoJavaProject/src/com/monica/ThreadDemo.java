package com.monica;
//anonymous inner class with and without inner class
public class ThreadDemo {

	public static void main(String[] args) {
/*Runnable r = new Runnable(){

	@Override
	public void run() {
for(int i =0;i<10;i++){
	System.out.println("child class"+i);
}
	}
};*/
		
		//using lambda
		Runnable r = ()->{
			for(int i =0;i<10;i++){
				System.out.println("child class"+i);
			}
		};
	Thread t = new Thread(r);
	t.start();
	for(int i =0;i<10;i++){
		System.out.println("Main class"+i);
	}
	}
}
