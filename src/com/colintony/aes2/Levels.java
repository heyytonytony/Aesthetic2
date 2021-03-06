package com.colintony.aes2;

import java.util.Random;

public class Levels
{
    
    private int[][] levelMap, collectableMap;
    private int[] pattern, curPattern;
    private int level;
    private final int LEVEL_SIZE = 50;
    private final int PATTERN_SIZE = 6;
    private Random rand = new Random();
    
	public Levels(int level)
	{
	    this.level = level;
	    levelMap = new int[LEVEL_SIZE+8][3];
	    collectableMap = new int[LEVEL_SIZE][3];
	    pattern = new int[PATTERN_SIZE];
	    curPattern = new int[PATTERN_SIZE];
	    
	    for(int a = 0; a < LEVEL_SIZE+8; a++)
	    {
	        for(int b = 0; b < 3; b++)
	        {
	            int randInt = 2;
	            if(a%3==0)
	                randInt = rand.nextInt(6) + 1;
	            if(a < LEVEL_SIZE)
	                levelMap[a][b] = randInt;
	            else
	                levelMap[a][b] = 6;
	            
	            if(a > 5 && a < LEVEL_SIZE && rand.nextFloat() < (0.9*level)/(level+5))
	                collectableMap[a][b] = rand.nextInt(7);
	        }
	    }
	    
	    for(int a = 0; a < PATTERN_SIZE; a++)
	    {
	        if(a + 4 - (level - 1) / 2 < PATTERN_SIZE)
	            pattern[a] = rand.nextInt(3) + 7;
	    }
	    
	}
	
	public Levels(boolean tutorial)
	{
	    int[][] levelMap = {{0,1,0,2,0,3,0},{0,1,0,2,0,3,0},{0,1,0,2,0,3,0},{0,1,0,2,0,3,0},
                {0,1,0,2,0,3,0},{0,1,0,2,0,3,0},{0,1,0,2,0,3,0},{0,1,0,2,0,3,0},
                {0,1,0,2,0,3,0},{0,1,0,2,0,3,0},{0,1,0,2,0,3,0},{0,1,0,2,0,3,0},
                {0,1,0,2,0,3,0},{0,1,0,2,0,3,0},{0,1,0,2,0,3,0},{0,1,0,2,0,3,0},
                {0,1,0,2,0,3,0},{0,1,0,2,0,3,0},{0,1,0,2,0,3,0},{0,1,0,2,0,3,0},
                {0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0},
                {0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0},
                {0,1,0,2,0,1,0},{0,1,0,2,0,1,0},{0,1,0,2,0,1,0},{0,1,0,2,0,1,0},
                {0,1,0,2,0,1,0},{0,1,0,2,0,1,0},{0,1,0,2,0,1,0},{0,1,0,2,0,1,0},
                {0,1,0,2,0,1,0},{0,1,0,2,0,1,0},{0,1,0,2,0,1,0},{0,1,0,2,0,1,0},
                {0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0},
                {0,6,0,6,0,6,0},{0,4,0,2,0,1,0},{0,4,0,2,0,1,0},{0,4,0,2,0,1,0},
                {0,4,0,2,0,1,0},{0,4,0,2,0,1,0},{0,4,0,2,0,1,0},{0,4,0,2,0,1,0},
                {0,4,0,2,0,1,0},{0,4,0,2,0,1,0},{0,4,0,2,0,1,0},{0,4,0,2,0,1,0},
                {0,4,0,2,0,1,0},{0,4,0,2,0,1,0},{0,4,0,2,0,1,0},{0,6,0,6,0,6,0},
                {0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0},
                {0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},
                {0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},
                {0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},
                {0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},
                {0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},
                {0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},
                {0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},
                {0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},
                {0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},{0,4,0,5,0,1,0},
                {0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0},
                {0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0},{0,6,0,6,0,6,0}};
        
        int[][] collectableMap = {{0,0,0},{0,0,0},{0,0,0},{0,0,0},
                {0,0,0},{0,0,0},{0,0,0},{0,0,0},{1,1,1},{0,0,0},{2,2,2},{0,0,0},
                {0,0,0},{1,1,1},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
                {0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
                {0,0,0},{0,0,0},{0,0,0},{0,0,0},{5,5,5},{0,0,0},{6,6,6},{0,0,0},
                {6,6,6},{4,4,4},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
                {0,0,0},{0,0,0},{0,0,0},{1,1,1},{0,0,0},{5,5,5},{6,6,6},{0,0,0},
                {2,2,2},{5,5,5},{1,1,1},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
                {0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
                {0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
                {0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
                {0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
                {0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},};
        
        int[] pattern = {7,8,7,0,0,0};
        int[] curPattern = {0,0,0,0,0,0};
        
        this.levelMap = levelMap;
        this.collectableMap = collectableMap;
        this.pattern = pattern;
        this.curPattern = curPattern;
	}
	
	public int[][] getLevelMap()
	{
	    return levelMap;
	}
	
	public int[][] getCollectableMap()
	{
	    return collectableMap;
	}
	
	public int[] getPattern()
	{
	    return pattern;
	}
	
	public int[] getCurPattern()
	{
	    return curPattern;
	}
	
	public int getLevel()
	{
	    return level;
	}
	
	public int getLevelWidth()
	{
	    return LEVEL_SIZE + 8;
	}
	
}
