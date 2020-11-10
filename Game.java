/**************************************************************************************
 @file Game.java
 @brief My final project: a memory game with circles of different colors
 @author Charlotte Van Houtven
 @date April 27, 2020
 *************************************************************************************/



import java.awt.*; //Imports StdDraw


public class Game {

    public static void main(String[] args) { //Main Method


        //Display 4x4 array of cards face down
        StdDraw.setScale(0, 140);
        Card[][] cards = new Card[4][4];
        int i, j; //i for rows, j for columns

        //Colors of array of cards
        Color[] arraycolors = {Color.orange, Color.lightGray, Color.red, Color.green, Color.blue, Color.magenta, Color.yellow, Color.red, Color.yellow, Color.green, Color.blue, Color.magenta, Color.cyan,  Color.orange, Color.cyan, Color.lightGray};

        //Displays array of cards face down
        for (i =0; i < cards.length; i++) { //Creating each row of cards
            for (j = 0; j < cards.length; j++) {
                cards[j][i]= new Card ((j*19.5)+11, (i*27.5)+15,arraycolors[(i*4+j)]); //Creates an array of card objects
                cards[j][i].drawback(); //Calls the drawback method for each location of cards
            }
        }

        int numflips=0;
        boolean test = true;
        double clickx = 0, clicky = 0; //Initializing location of click variables
        Card pick1 = new Card (); //Creating card object for pick 1
        Card pick2 = new Card (); //Creating card object for pick 2
        while (test) {
            if (StdDraw.isMousePressed() && pick1.getColor().toString().equals(Color.black.toString())
                    && pick2.getColor().toString().equals(Color.black.toString())) { //If the mouse is pressed and the first card has not been picked

                clickx = StdDraw.mouseX(); //Location of mouse to variable
                clicky = StdDraw.mouseY();

                if( clickx < 78 && clicky < 110 ) { //If the click is on a specific card
                    int x = (int) (clickx / 19.5);
                    int y = (int) (clicky / 27.5);

                    pick1 = cards[x][y]; //assigning pick 1 to the card chosen
                    pick1.drawfront(); //Card flips over
                    System.out.println("pick1: " + pick1.getColor().toString()); //prints the pick
                    StdDraw.pause(1000); //prevents program from buffering
                }
            }

            if (StdDraw.isMousePressed() && !pick1.getColor().toString().equals(Color.black.toString())
                    && pick2.getColor().toString().equals(Color.black.toString())) { //If the mouse is pressed and the second card has not been chosen

                clickx = StdDraw.mouseX();
                clicky = StdDraw.mouseY();

                if( clickx < 78 && clicky < 110 ) {
                    int x = (int) (clickx / 19.5);
                    int y = (int) (clicky / 27.5);

                    pick2 = cards[x][y];
                    pick2.drawfront();
                    System.out.println("pick2: " + pick2.getColor().toString());
                    StdDraw.pause(1000);
                }
            }

            if(!pick1.getColor().toString().equals(Color.black.toString()) && !pick2.getColor().toString().equals(Color.black.toString())){
                if(pick1.getColor().toString().equals(pick2.getColor().toString())) { //If the cards are the same color
                    System.out.println("Match");
                    pick1 = new Card(); //Resetting pick1
                    pick2 = new Card(); //Resetting pick2
                }
                else{ //If cards are not the same color
                    System.out.println("No Match");
                    StdDraw.pause(1000); //Pause for a second
                    pick1.drawback(); //Cards flipped back over
                    pick2.drawback();
                    pick1 = new Card(); //Resetting pick1
                    pick2 = new Card(); //Resetting pick2
                    StdDraw.pause(1000); //Pause for another second

                }
            }
        }
    }
}
