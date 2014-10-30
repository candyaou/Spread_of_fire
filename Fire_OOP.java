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
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Scanner;  

/*
    this is the Controller component
*/


class Fire_OOP extends JFrame
{
    private static int x,y,SIZE,time,burnTree;
    public static double prob,probTree;
    private static FireView view;
    private static FireModel model;
    
    Fire_OOP()
    {
        super("Forest Fire");

        // build the view
        view = new FireView();
        view.setBackground(Color.white);
        Container c = getContentPane();
        c.add(view, BorderLayout.CENTER);

       
    }

    public static void main(String[] args)
    {
        Fire_OOP sb = new Fire_OOP();
        sb.addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
               System.exit(0);
            }
        });
        
        
        
       Scanner h = new Scanner(System.in);  
       System.out.print("insert tree Max is 175 :");  
       SIZE = h.nextInt();
       
       Scanner a = new Scanner(System.in);  
       System.out.print("insert time :");  
       time = a.nextInt();
       
       Scanner b = new Scanner(System.in);  
       System.out.print("insert ProbBurn :");  
       prob = b.nextDouble();
       
       Scanner d = new Scanner(System.in);  
       System.out.print("insert ProbTree :"); 
       probTree = d.nextDouble();
       
       Scanner c = new Scanner(System.in);  
       System.out.print("How many tree burn :");  
       burnTree = c.nextInt();
       
       

       
       
         // build the model
        model = new FireModel(view,SIZE,burnTree,probTree);
        //model.solve();
        
        sb.setSize(1000,1000);
        sb.setVisible(true);
        model.GameTimer(time);
    }
}
