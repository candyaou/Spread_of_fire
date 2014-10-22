/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fire_oop;

import java.awt.Color;

/**
 *
 * @author CandyAou
 */


public class FireModel
{
    public static int SIZE;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view,int a)
    {
        SIZE=a;
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        
        myView = view;
        myView.updateView(myGrid);
    }

    /*
        recursiveFire method 
     */
    
    
    
    public void solve()
    {     
       
        myView.updateView(myGrid);      
    }
    
}

