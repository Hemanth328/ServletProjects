package com.hem.servlet;

public class Sample {
	
	private int a;
	private int b;
	
	public Sample(){
		this.a= a;
		this.b = b;
	}
	
	public Sample(int c, int d) {
		this.a = c;
		this.b = d;
	}
	
	public void display() {
		System.out.println(a);
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		Sample s = new Sample();
		s.display();
		
	}

}
