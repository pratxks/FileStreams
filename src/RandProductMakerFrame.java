
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class RandProductMakerFrame extends JFrame
{
    private JPanel productInputPanel;
    private JPanel mainPanel;
    private JPanel controlPanel;
    
    private JTextField productName;
    private JTextField productDescription;
    private JTextField productID;
    private JTextField productCost;
    private JTextField productCount;
    
    private JButton addProductButton;
    private JButton quitButton;
    
    private static int productRecordCount;
    private static long productRecordPos = 0;
    
    public RandProductMakerFrame()
    {
        setTitle("Random Product Maker");
        
        productRecordCount = 0;
    }
    
    public void SetRandProductMakerFrameDisplay()
    {
        mainPanel = new JPanel();

        createProductInputPanel();
        createControlPanel();

        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(productInputPanel, BorderLayout.NORTH);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        add(mainPanel);
        
        File workingDirectory = new File(System.getProperty("user.dir"));
        File randomAccessFile = new File(workingDirectory.getPath() + "\\src\\ProductDataRandom.txt");
        
        if(randomAccessFile.exists())
        {
            if(randomAccessFile.delete())
            {
                
            }
            else
            {
                
            }
        }
    }
    
    private void createProductInputPanel()
    {
        productInputPanel = new JPanel();
        
        Font productInputPanelFont  = new Font(Font.DIALOG_INPUT, Font.BOLD, 18);
                
        Border blueLineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
        Border blueTitledBorder = BorderFactory.createTitledBorder(blueLineBorder, "Product Data Input Panel", TitledBorder.LEADING, TitledBorder.TOP, productInputPanelFont);
        
        productInputPanel.setBorder(blueTitledBorder);
                   
        productInputPanel.setFont(productInputPanelFont);
        
        GridBagLayout productInputGridBagLayout = new GridBagLayout();

        productInputPanel.setLayout(productInputGridBagLayout);
                
        GridBagConstraints bagConstraints1 = new GridBagConstraints();
        
        bagConstraints1.insets = new Insets(10, 30, 10, 10);
        bagConstraints1.anchor = GridBagConstraints.WEST;
        
        JLabel productNameLabel = new JLabel("Product Name");
        productNameLabel.setFont(productInputPanelFont);
                
        bagConstraints1.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 1;
            
        productInputPanel.add(productNameLabel, bagConstraints1);
        
        productName = new JTextField(35);
        productName.setFont(productInputPanelFont);
                
        bagConstraints1.fill = GridBagConstraints.NONE;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 1;
        
        productInputPanel.add(productName, bagConstraints1);
        
        JLabel productDescLabel = new JLabel("Product Description");
        productDescLabel.setFont(productInputPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 2;
    
        productInputPanel.add(productDescLabel, bagConstraints1);
        
        productDescription = new JTextField(35);
        productDescription.setFont(productInputPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.NONE;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 2;
        
        productInputPanel.add(productDescription, bagConstraints1);
        
        JLabel productIDLabel = new JLabel("Product ID");
        productIDLabel.setFont(productInputPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 3;
    
        productInputPanel.add(productIDLabel, bagConstraints1);
        
        productID = new JTextField(6);
        productID.setFont(productInputPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.NONE;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 3;
        
        productInputPanel.add(productID, bagConstraints1);
        
        JLabel productCostLabel = new JLabel("Product Cost");
        productCostLabel.setFont(productInputPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 4;
    
        productInputPanel.add(productCostLabel, bagConstraints1);
        
        productCost = new JTextField(10);
        productCost.setFont(productInputPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.NONE;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 4;
        
        productInputPanel.add(productCost, bagConstraints1);
        
        productCount = new JTextField(10);
        productCount.setFont(productInputPanelFont);
        productCount.setEditable(false);
        productCount.setHorizontalAlignment(JTextField.RIGHT);
                
        bagConstraints1.fill = GridBagConstraints.NONE;
        bagConstraints1.anchor = GridBagConstraints.EAST;
        bagConstraints1.insets = new Insets(10, 30, 10, 0);
        
        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 5;
        
        productInputPanel.add(productCount, bagConstraints1);
        
        JLabel productCountLabel = new JLabel("Records Added");
        productCountLabel.setFont(productInputPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.NONE;
        bagConstraints1.anchor = GridBagConstraints.WEST;
        bagConstraints1.insets = new Insets(10, 10, 10, 10);
        
        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 5;
        
        productInputPanel.add(productCountLabel, bagConstraints1);
    }
    
    private void createControlPanel()
    {
        controlPanel = new JPanel();
        
        Border blueLineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
        controlPanel.setBorder(blueLineBorder);
        
        Font controlPanelFont  = new Font(Font.SANS_SERIF, Font.BOLD, 24);
        
        GridBagLayout controlGridBagLayout = new GridBagLayout();

        controlPanel.setLayout(controlGridBagLayout);
                
        GridBagConstraints bagConstraints1 = new GridBagConstraints();
        
        bagConstraints1.anchor = GridBagConstraints.WEST;
        
        addProductButton = new JButton("Add Product");       
        addProductButton.setFont(controlPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.NONE;
        bagConstraints1.insets = new Insets(17, 30, 17, 50);

        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 1;
            
        addProductButton.addActionListener(ae -> addProductButtonClicked());
        
        controlPanel.add(addProductButton, bagConstraints1);
        
        quitButton = new JButton("Quit");
        quitButton.setFont(controlPanelFont);
                
        bagConstraints1.fill = GridBagConstraints.NONE;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 1;
        
        quitButton.addActionListener(ae -> quitButtonClicked());
        
        controlPanel.add(quitButton, bagConstraints1);
    }
    
    private void AddProductRecordToFile()
    {
        if(productName.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Product Name is not Entered");
        }
        else if(productDescription.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Product Description is not Entered");
        }
        else if(productID.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Product Name is not Entered");
        }
        else if(productCost.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Product Cost is not Entered");
        }
        else
        {
            // Creates an object of Product class
            Product productRecord = new Product(productName.getText(), 
                                                productDescription.getText(),
                                                productID.getText(),
                                                Double.valueOf(productCost.getText()));
            
            try 
            {
                File workingDirectory = new File(System.getProperty("user.dir"));
                Path productfile = Paths.get(workingDirectory.getPath() + "/src/ProductDataRandom.txt");
        
                RandomAccessFile productDataFile = new RandomAccessFile(productfile.toFile(), "rw");

                productDataFile.seek(productRecordPos);
                
                productDataFile.writeBytes(productRecord.getM_sName());
                productDataFile.writeBytes(productRecord.getM_sDescription());
                productDataFile.writeBytes(productRecord.getM_sID());
                productDataFile.writeDouble(productRecord.getM_fCost());

                productRecordPos = productDataFile.length();
               
                productDataFile.close();

                productRecordCount++;
                
                productCount.setText("" + productRecordCount);

                productName.setText("");
                productDescription.setText("");
                productID.setText("");
                productCost.setText("");
                
                JOptionPane.showMessageDialog(null, "Product Record added to File");
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Exception in writing Product Object to File");
                //e.getStackTrace();
            }
        }
    }

    private void addProductButtonClicked() 
    {
        AddProductRecordToFile();
    }
    
    private void quitButtonClicked()
    {
        System.exit(0);
    }
}
