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
        Greenfoot.stop();
    }
    
    public void checkIfTriple()
    {
        boolean shape = (cardsSelected[0].getShape().ordinal() + cardsSelected[0].getShape().ordinal() + cardsSelected[0].getShape().ordinal()) % 3 == 0;
        boolean color = (cardsSelected[0].getColor().ordinal() + cardsSelected[0].getColor().ordinal() + cardsSelected[0].getColor().ordinal()) % 3 == 0;
        boolean shading = (cardsSelected[0].getShading() + cardsSelected[1].getShading() + cardsSelected[2].getShading()) % 3 == 0;    
        boolean numberOfShape = (cardsSelected[0].getNumberOfShapes() + cardsSelected[1].getNumberOfShapes() + cardsSelected[2].getNumberOfShapes()) % 3 == 0;
        if (shape && color && shading && numberOfShape)
        {
            actionIfTriple();
        }
    }
    
    public void actionIfTriple()
    {
        for (int i = 0; i < 3; i++)
        {
            int x = cardsSelected[i].getX();
            int y = cardsSelected[i].getY();
            Card card = deck.getTopCard();
            if (card.getColor() != Card.Color.NO_COLOR)
            {
                getWorld().addObject(card, x, y);
                cardsOnBoard.set(selectedCardsIndex.get(i), card);
            }
        }
        Animations.slideAndTurn(cardsSelected);
        Scorekeeper.updateScore();
        triplesRemaining--;
        if (triplesRemaining == 0)
        {
            endGame();
        }
        setUI();
    }
    
    public void setCardsSelected(ArrayList<Card> cards, ArrayList<Integer> ints, Card[] allCards)
    {
        cardsOnBoard = cards;
        selectedCardsIndex = ints;
        cardsSelected = allCards;
    }
    

}
