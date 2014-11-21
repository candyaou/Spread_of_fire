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

public class FireCell
{
    public static final int Empty = 0, Tree = 1, Fire = 2;
    int status; 
    
    
   public FireCell(int n){
         switch (n) {
            case 0:  status = Empty;
                     break;
            case 1:  status = Tree;
                     break;
            case 2:  status = Fire;
                     break;
            default: status = Empty;
                     break;
        }
    }
    
   
    
    public int getStatus()
    {
        return status;
    }
    
    public void setStatus(int n)
    {
        status = n;
    }
}

