
public class DrawACrate
{
    public static void main(String[] args)
    {
        Rectangle box = new Rectangle (20, 70 , 40, 30 );
        box.setColor(new Color(0, 0, 255));
      
        
        Rectangle box2 = new Rectangle (60, 70 , 40, 30 );
        box2.setColor(new Color(255, 0, 255));
        
        Rectangle box3 = new Rectangle (100, 70 , 40, 30 );
        box3.setColor(new Color(0,255, 255));
        box3.draw();
        
        
        Rectangle box4 = new Rectangle (40, 40 , 40, 30 );
        box4.setColor(new Color(255, 0,0));
        box4.draw();
        
        Rectangle box5 = new Rectangle (80, 40 , 40, 30 );
        box5.setColor(new Color(255, 150,125));
        box5.draw();
        
        Rectangle box6 = new Rectangle (60, 10 , 40, 30 );
        box6.setColor(new Color(125,125, 255));
        box6.draw();
        
         box.draw();
         box2.draw();
        box.fill();
       
        box2.fill();
        box3.fill();
        box4.fill();
        box5.fill();
        box6.fill();
        
       
        
    }
}






































































