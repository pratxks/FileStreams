
import javax.swing.JFrame;


public class RandProductMaker 
{
    public static void main(String[] args) 
    {
        RandProductMakerFrame MyRandProductMakerFrame = new RandProductMakerFrame();

        MyRandProductMakerFrame.SetRandProductMakerFrameDisplay();

        MyRandProductMakerFrame.setSize(900, 400);

        MyRandProductMakerFrame.setResizable(false);

        MyRandProductMakerFrame.setLocationRelativeTo(null);
        
        MyRandProductMakerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyRandProductMakerFrame.setVisible(true);
    }
}
