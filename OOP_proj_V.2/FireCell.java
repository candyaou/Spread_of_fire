/**
 *
 * @author CandyAou
 */
//create cell 
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
