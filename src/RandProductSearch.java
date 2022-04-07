
import javax.swing.JFrame;


public class RandProductSearch 
{
    public static void main(String[] args)
    {
        RandProductSearchFrame MyRandProductSearchFrame = new RandProductSearchFrame();

        MyRandProductSearchFrame.SetRandProductSearchFrameDisplay();

        MyRandProductSearchFrame.setSize(1000, 500);

        MyRandProductSearchFrame.setResizable(false);

        MyRandProductSearchFrame.setLocationRelativeTo(null);
        
        MyRandProductSearchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyRandProductSearchFrame.setVisible(true);
    }
}
