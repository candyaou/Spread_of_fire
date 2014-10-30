/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fire_oop;

//import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Scanner;

/**
 *
 * @author CandyAou
 */


public class FireModel
{
    public static int SIZE;
    public static double prob = Fire_OOP.prob;
    public static int fireRan;
    public static double fire;
   
    
    private static int burnTree;
    private static double probTree;
    private FireCell[][] myGrid;
    private FireView myView;
    private ArrayList<Integer> tmpburni,tmpburnj;
    private Point origin;
    private ArrayList<Point> Queue;
    private ArrayList<Point> tmpQueue;
  
    
    public FireModel(FireView view,int a,int b,double d)
    {   
        
        
        SIZE = a;
        burnTree = b;
        probTree = d;
        
        tmpburni=new ArrayList<>();
        tmpburnj=new ArrayList<>();
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                
                if(Math.random() < probTree){
                    myGrid[r][c] = new FireCell(1);
                    
                }
                else{
                    myGrid[r][c] = new FireCell(0);
                    
                }
            }
        }
        
        
        Queue = new ArrayList<>();
        tmpQueue = new ArrayList<>();
        
        for(int i = 0;i < burnTree;i++){
            fire = Math.random()*SIZE;
            fireRan = (int)fire;
            System.out.println("point "+(i+1)+" at : "+fireRan);
            origin = new Point(fireRan, fireRan );
            Queue.add(origin);
            myGrid[fireRan][fireRan].setStatus(2);//new FireCell(2);
        }
        
        //set burn
        tmpburni.add(fireRan);
        tmpburnj.add(fireRan);
        
        
        
        myView = view;
        Border();
        myView.updateView(myGrid);
    }
    
    public void runQueue(){
        
        //System.out.println("runQueue:" + Queue.size());
        for( int i = 0; i < Queue.size(); i++ ){
            Point tmp = Queue.get(i);
            
            if(Math.random()< prob){
            
            fireBurn( new Point( tmp.x, tmp.y - 1 ));
            }//top
            if(Math.random()< prob){
            
            fireBurn( new Point( tmp.x + 1, tmp.y ));
            }//right
            if(Math.random()< prob){
            
            fireBurn( new Point( tmp.x, tmp.y + 1 ));
            }//bot
            if(Math.random()< prob){
            
            fireBurn( new Point( tmp.x - 1, tmp.y )); 
            }//left
            myGrid[tmp.x][tmp.y].setStatus( FireCell.Empty );
        }
        //System.out.println("tmpQueue.size:" + tmpQueue.size());
        Queue = new ArrayList<>( tmpQueue );
        tmpQueue.clear();
        //System.out.println("Queue.size:" + Queue.size());
        myView.updateView(myGrid);
    }
    public void fireBurn( Point target ){
        //System.out.println("fireBurn:" + myGrid[target.x][target.y].getStatus());
        if( myGrid[target.x][target.y].getStatus() == FireCell.Tree ){
            myGrid[target.x][target.y].setStatus(FireCell.Fire);
            tmpQueue.add(target);
        }
    }
    public void Border(){
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
              if(r==0||c==0||r==SIZE-1||c==SIZE-1){
                myGrid[r][c].setStatus(0);
                
              } 
            }
        }
    }
    
    

    
   /*
    public void burn(){
    
    ArrayList<Integer> tmpi=new ArrayList<>();
    ArrayList<Integer> tmpj=new ArrayList<>();
    for (int i=0; i < tmpburni.size(); i++){
            for (int j=0; j<tmpburnj.size(); j++){
               
                if(myGrid[tmpburni.get(i)][tmpburnj.get(j)].getStatus() == 2){
                    if(myGrid[tmpburni.get(i)-1][tmpburnj.get(j)].getStatus() == 1){
                        myGrid[tmpburni.get(i)-1][tmpburnj.get(j)].setStatus(2);
                        tmpi.add(tmpburni.get(i)-1);
                        tmpj.add(tmpburnj.get(j));
                    }//up
                    
                    if(myGrid[tmpburni.get(i)][tmpburnj.get(j)+1].getStatus() == 1){
                        myGrid[tmpburni.get(i)][tmpburnj.get(j)+1].setStatus(2);
                        tmpi.add(tmpburni.get(i));
                        tmpj.add(tmpburnj.get(j)+1);
                        
                    }//right
                    if(myGrid[tmpburni.get(i)+1][tmpburnj.get(j)].getStatus() == 1){
                        myGrid[tmpburni.get(i)+1][tmpburnj.get(j)].setStatus(2);
                        tmpi.add(tmpburni.get(i)+1);
                        tmpj.add(tmpburnj.get(j));
                       
                    }//bottom
                    
                    if(myGrid[tmpburni.get(i)][tmpburnj.get(j)-1].getStatus() == 1){
                        myGrid[tmpburni.get(i)][tmpburnj.get(j)-1].setStatus(2);
                        tmpi.add(tmpburni.get(i));
                        tmpj.add(tmpburnj.get(j)-1);
                    }//left
                      
                    
                    
                    myGrid[tmpburni.get(i)][tmpburnj.get(j)].setStatus(0);
                    
                   
                    
            }
        }
      }
    tmpburni=tmpi;
    
    tmpburnj=tmpj;
      
    }
    
    
public void solve()
    {    
        burn();
        myView.updateView(myGrid);
}
*/
    
  

    
    
    
 
 public void GameTimer(int timeTime) {
   TimerTask task;
        task = new TimerTask() {
            @Override
            public void run() {
                runQueue();                
//              burn();
//              myView.updateView(myGrid);
//              Scanner a = new Scanner(System.in);  
//              System.out.print("Press Enter");  
//              String temp = a.nextLine();
                
                
            }
        };
        
  Timer timer = new Timer();
  timer.schedule(task,0,timeTime);
 }

    
}

