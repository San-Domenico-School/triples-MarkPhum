import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Dealer extends Actor
{
    public Deck deck;
    private ArrayList<Card> cardsOnBoard = new ArrayList<Card>();    
    private ArrayList<Integer> selectedCardsIndex = new ArrayList<Integer>();
    private Card[] cardsSelected;
    private int numCardsInDeck;
    private int triplesRemaining;
    
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        triplesRemaining = numCardsInDeck/3;
        deck = new Deck(numCardsInDeck); //not complete
        cardsSelected = new Card[3];
    }
    
    public void addedToWorld(World world)
    {
        dealBoard();
        setUI();
    }
    
    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.wav");

        for (int row = 1; row <= 5; row++)
        {
            for (int column = 1; column <= 3; column++)
            {
                getWorld().addObject(deck.getTopCard(), column * 120 - 20, row * 75 + 10);
                
            }
        }
    }
    
    public void setUI()
    {
        Integer score = new Integer(Scorekeeper.getScore());
        getWorld().showText(score.toString(), 320, 505);
        Integer cardsRemaining = new Integer(deck.getNumCardsInDeck());
        getWorld().showText(cardsRemaining.toString(), 320, 470);
    }
    
    public void endGame()
    {
        
    }
    
    public void checkIfTriple()
    {
        
    }
    
    public void actionIfTriple()
    {
        
    }
    
    public void setCardsSelected(ArrayList<Card> cards, ArrayList<Integer> Ints, Card[] allCards)
    {
        
    }
    

}
