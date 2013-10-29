package test;

public class ThreadsFunctionTest {
	
	
	public static void main(String[] args){
		Calculator c = new Calculator();
		CalculatorThread c1 = new CalculatorThread(c, 2);
		//CalculatorThread c2 = new CalculatorThread(c, 0);
		
		new Thread(c1).start();
		//new Thread(c2).start();
	}
	
}

class CalculatorThread implements Runnable{
	
	Calculator c;
	int a;
	
	public CalculatorThread(Calculator c, int a) {
		this.c = c;
		this.a = a;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			c.calc(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Calculator{
	
	public void calc(int a) throws InterruptedException{
		
		int sum = 1;
		for(int i=0;i<100;i++){
			sum *= a;
			System.out.println(sum);
			Thread.sleep(1000);
		}
		
		System.out.println(sum);
	}
}