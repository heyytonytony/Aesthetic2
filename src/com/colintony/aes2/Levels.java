package com.colintony.aes2;


public class Levels {
	
	public Levels() {

	}
	
	public int[][] setLevel(int level){
		
		if(level == 0)	{
			int map[][] = {{0,0,0,1,1},{0,0,0,1,2}};
			return map;
		}
		else{
			int map[][] = {{0,0,0,1,1},{0,0,0,1,1}};
			return map;
		}
		

	}
	
}