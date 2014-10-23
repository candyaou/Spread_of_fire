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
    private static int x;
    private static int y;
    private static int SIZE;
    private static int time;
    private static double prob;
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
       System.out.print("insert tree = tree^2: 3-200 :");  
       SIZE = h.nextInt();
       
       Scanner a = new Scanner(System.in);  
       System.out.print("insert time :");  
       time = a.nextInt();
       
       

       
       
         // build the model
        model = new FireModel(view,SIZE);
        //model.solve();
        
        sb.setSize(1000,1000);
        sb.setVisible(true);
        model.GameTimer(time);
    }
}
