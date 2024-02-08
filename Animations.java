import greenfoot.*;
/**
 * 
 * 
 * @Mark P 
 * @Jan 12 2024
 */
public class Animations  
{
    public static void wobble(Card[] cards)
    {
        Greenfoot.playSound("wobble.wav");
    }
    
    public static void slideAndTurn(Card[] cards)
    {
        Greenfoot.playSound("swoosh.wav");
        for (int i = 0; i < 3; i++)
        {
                cards[i].move(2000);
        }
    }
}
