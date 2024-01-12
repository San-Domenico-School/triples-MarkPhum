/**
 * Write a description of class Scorekeeper here.
 * 
 * Mark P 
 * Jan 11 2024
 */
public class Scorekeeper  
{
    private static int deckSize;
    private static int score;
    private static long startTime = System.currentTimeMillis();
    
    public static void setDeckSize(int size)
    {
       deckSize = size;
    }
    
    public static void updateScore()
    {
        long duration = System.currentTimeMillis() - startTime;
        
        if (duration <= 1000)
        {
            score += 100;
        }
        else if (duration <= 2000)
        {
            score += 75;
        }
        else if (duration <= 3000)
        {
            score += 50;
        }
        else if (duration <= 4000)
        {
            score += 25;
        }
        else if (duration <= 30000)
        {
            score += 10;
        }
        else if (duration <= 60000)
        {
            score += 5;
        }
        else if (duration <= 90000)
        {
            score += 1;
        }
        
        startTime = System.currentTimeMillis();
    }
    
    public static int getScore()
    {
        return score;
    }
}
