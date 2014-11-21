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
    public static double prob = 0.7;//Fire_OOP.prob;
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
    private boolean run=false;
    private Timer timer;
    public FireModel(FireView view,int a,int b,double d)
    {   
        
        
        SIZE = a;
        burnTree = b;
        probTree = d;
       
        myView = view;
        build();
        
        
    }
    
    public void setProbCatch(double p){
        prob = p;
    }
    
     public void setTreeBurn(int p){
        burnTree = p;
    }
    
    public void setSize(int p){
        SIZE = p;
    }
    
    public void setProbTree(double p){
        probTree=p;
    }
    
    
    
    
    
    public void build(){
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
        
        
        origin = new Point(myGrid.length/2, myGrid.length/2 );
        Queue.add(origin);
        myGrid[myGrid.length/2][myGrid.length/2].setStatus(2);//new FireCell(2);
        tmpburni.add(myGrid.length/2);
        tmpburnj.add(myGrid.length/2);
        System.out.println("point 1 at : "+myGrid.length/2);
        burnTree--;
        for(int i = 0;i < burnTree;i++){
            fire = Math.random()*SIZE;
            fireRan = (int)fire;
            System.out.println("point "+(i+2)+" at : "+fireRan);
            origin = new Point(fireRan, fireRan );
            Queue.add(origin);
            
                myGrid[fireRan][fireRan].setStatus(2);//new FireCell(2);
                
        }      
        
        
        
        Border();
        myView.updateView(myGrid);
    }
    
    public void startBurn(){
        run=true;
    }
    
    public void stopBurn(){
        run=false;
    }
    
    public void resetBurn(){
        build();
    }
    
    
    public void runQueue() {
        
      
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
        
        Queue = new ArrayList<>( tmpQueue );
        tmpQueue.clear();
        myView.updateView(myGrid);
    }
       
    public void fireBurn( Point target ){
        
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

    
  

 public void GameTimer(int timeTime) {
   TimerTask task;
        task = new TimerTask() {
            @Override
            public void run() {
                if(run){runQueue();}                
            }
        };
        
  Timer timer = new Timer();
  timer.schedule(task,0,timeTime);
 }   
}