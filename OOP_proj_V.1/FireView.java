/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fire_oop;

/**
 *
 * @author CandyAou
 */
import java.awt.*;
import javax.swing.*;

/*
  this is the View component
*/

class FireView extends JPanel
{
    private FireCell[][] myGrid;

    // entry point from model, requests grid be redisplayed
    public void updateView( FireCell[][] mg )
    {
        myGrid = mg;
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int testWidth = getWidth() / (FireModel.SIZE+1);
        int testHeight = getHeight() / (FireModel.SIZE+1);
        // keep each Fire cell square
        int boxSize = Math.min(testHeight, testWidth);

        for ( int r = 0; r < FireModel.SIZE; r++ )
        {
            for (int c = 0; c < FireModel.SIZE; c++ )
            {
                if (myGrid[r][c] != null)
                {
                    int ulX = (c+1) * boxSize;
                    int ulY = (r+1) * boxSize;
                   
                    if ( myGrid[r][c].getStatus() == FireCell.Empty ){            
                        g.setColor(Color.yellow);
                    }// dirt
                    if ( myGrid[r][c].getStatus() == FireCell.Tree ) {     
                        g.setColor(Color.green);
                    }// green tree
                    if ( myGrid[r][c].getStatus() == FireCell.Fire ){
                        g.setColor(Color.red);
                    }// burning tree

                    int topLeftX = ulX+2, topLeftY = ulY+2;
                    int sizeX = boxSize-2, sizeY = boxSize-2;
                    g.fillRect( topLeftX, topLeftY, sizeX, sizeY);
                }
            }
        }
    }
}
