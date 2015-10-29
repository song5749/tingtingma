package com.tingtingma.test;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimmer {
	public static void main(String[] args) {
		new TestTimmer(4);
	}
	
	public  TestTimmer(int second){
		Timer timer = new Timer();
		timer.schedule(new MyTimerTast(), 0, second*1000L);
	}
	
	private class MyTimerTast extends TimerTask{

		@Override
		public void run() {
			System.out.println("run timer");
			
		}
		
	}
}
