
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class RandProductSearchFrame extends JFrame 
{
    private JPanel mainPanel;
    private JPanel searchPanel;
    private JPanel productDisplayPanel;
    private JPanel controlPanel;
    
    private JTextField searchProduct;
    private JButton searchButton;
    
    private JTextField productName;
    private JTextField productDescription;
    private JTextField productID;
    private JTextField productCost;
    private JTextField productCount;
    private JLabel productCountLabel;
    
    private JButton prevRecordButton;
    private JButton nextRecordButton;
    private JButton quitButton;
    
    private ArrayList<Product> productArray;
    
    public RandProductSearchFrame()
    {
        setTitle("Random Product Search");
        
        productArray = new ArrayList<>();
    }
    
    public void SetRandProductSearchFrameDisplay()
    {
        mainPanel = new JPanel();

        createSearchPanel();
        createProductDisplayPanel();
        createControlPanel();

        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(productDisplayPanel, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
    
    private void createSearchPanel()
    {
        searchPanel = new JPanel();
        
        Font searchPanelFont  = new Font(Font.DIALOG_INPUT, Font.BOLD, 18);
                
        Border blueLineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
//        Border blueTitledBorder = BorderFactory.createTitledBorder(blueLineBorder, "Product Data Input Panel", TitledBorder.LEADING, TitledBorder.TOP, searchPanelFont);
        
        searchPanel.setBorder(blueLineBorder);
                   
        searchPanel.setFont(searchPanelFont);
        
        GridBagLayout productInputGridBagLayout = new GridBagLayout();

        searchPanel.setLayout(productInputGridBagLayout);
                
        GridBagConstraints bagConstraints1 = new GridBagConstraints();
        
        bagConstraints1.insets = new Insets(10, 30, 10, 10);
        bagConstraints1.anchor = GridBagConstraints.WEST;
        
        JLabel productNameLabel = new JLabel("Search Product");
        productNameLabel.setFont(searchPanelFont);
                
        bagConstraints1.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 1;
            
        searchPanel.add(productNameLabel, bagConstraints1);
        
        searchProduct = new JTextField(35);
        searchProduct.setFont(searchPanelFont);
        searchProduct.setHorizontalAlignment(JTextField.RIGHT);
                        
        bagConstraints1.fill = GridBagConstraints.NONE;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 1;
        
        searchPanel.add(searchProduct, bagConstraints1);
        
        searchButton = new JButton("Search");       
        searchButton.setFont(searchPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.NONE;
//        bagConstraints1.insets = new Insets(17, 30, 17, 50);

        bagConstraints1.gridx = 2;
        bagConstraints1.gridy = 1;
            
        searchButton.addActionListener(ae -> searchProductButtonClicked());
        
        searchPanel.add(searchButton, bagConstraints1);
    }
    
    private void createProductDisplayPanel()
    {
        productDisplayPanel = new JPanel();
        
        Font productDisplayFont  = new Font(Font.DIALOG_INPUT, Font.BOLD, 18);
                
        Border blueLineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
        Border blueTitledBorder = BorderFactory.createTitledBorder(blueLineBorder, "Product Data Display Panel", TitledBorder.LEADING, TitledBorder.TOP, productDisplayFont);
        
        productDisplayPanel.setBorder(blueTitledBorder);
                   
        productDisplayPanel.setFont(productDisplayFont);

        GridBagLayout productDisplayGridBagLayout = new GridBagLayout();

        productDisplayPanel.setLayout(productDisplayGridBagLayout);
                
        GridBagConstraints bagConstraints1 = new GridBagConstraints();
        
        bagConstraints1.insets = new Insets(10, 30, 10, 10);
        bagConstraints1.anchor = GridBagConstraints.WEST;
        
        JLabel productNameLabel = new JLabel("Product Name");
        productNameLabel.setFont(productDisplayFont);
                
        bagConstraints1.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 1;
            
        productDisplayPanel.add(productNameLabel, bagConstraints1);
        
        productName = new JTextField(35);
        productName.setFont(productDisplayFont);
        productName.setHorizontalAlignment(JTextField.RIGHT);
        
        bagConstraints1.fill = GridBagConstraints.NONE;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 1;
        
        productDisplayPanel.add(productName, bagConstraints1);
        
        JLabel productDescLabel = new JLabel("Product Description");
        productDescLabel.setFont(productDisplayFont);
        
        bagConstraints1.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 2;
    
        productDisplayPanel.add(productDescLabel, bagConstraints1);
        
        productDescription = new JTextField(40);
        productDescription.setFont(productDisplayFont);
        productDescription.setHorizontalAlignment(JTextField.RIGHT);
        
        bagConstraints1.fill = GridBagConstraints.NONE;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 2;
        
        productDisplayPanel.add(productDescription, bagConstraints1);
        
        JLabel productIDLabel = new JLabel("Product ID");
        productIDLabel.setFont(productDisplayFont);
        
        bagConstraints1.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 3;
    
        productDisplayPanel.add(productIDLabel, bagConstraints1);
        
        productID = new JTextField(6);
        productID.setFont(productDisplayFont);
        productID.setHorizontalAlignment(JTextField.RIGHT);
        
        bagConstraints1.fill = GridBagConstraints.NONE;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 3;
        
        productDisplayPanel.add(productID, bagConstraints1);
        
        JLabel productCostLabel = new JLabel("Product Cost");
        productCostLabel.setFont(productDisplayFont);
        
        bagConstraints1.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 4;
    
        productDisplayPanel.add(productCostLabel, bagConstraints1);
        
        productCost = new JTextField(10);
        productCost.setFont(productDisplayFont);
        productCost.setHorizontalAlignment(JTextField.RIGHT);
        
        bagConstraints1.fill = GridBagConstraints.NONE;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 4;
        
        productDisplayPanel.add(productCost, bagConstraints1);
        
        productCount = new JTextField(10);
        productCount.setFont(productDisplayFont);
        productCount.setEditable(false);
        productCount.setHorizontalAlignment(JTextField.RIGHT);
                
        bagConstraints1.fill = GridBagConstraints.NONE;
        bagConstraints1.anchor = GridBagConstraints.EAST;
        bagConstraints1.insets = new Insets(10, 30, 10, 0);
        
        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 5;
        
        productDisplayPanel.add(productCount, bagConstraints1);
        
        productCountLabel = new JLabel("");
        productCountLabel.setFont(productDisplayFont);
        
        bagConstraints1.fill = GridBagConstraints.NONE;
        bagConstraints1.anchor = GridBagConstraints.WEST;
        bagConstraints1.insets = new Insets(10, 10, 10, 10);
        
        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 5;
        
        productDisplayPanel.add(productCountLabel, bagConstraints1);
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
        
        prevRecordButton = new JButton("Prev Product");       
        prevRecordButton.setFont(controlPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.NONE;
        bagConstraints1.insets = new Insets(17, 30, 17, 50);

        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 1;
            
        prevRecordButton.addActionListener(ae -> prevProductButtonClicked());
        
        controlPanel.add(prevRecordButton, bagConstraints1);
        
        nextRecordButton = new JButton("Next Product");       
        nextRecordButton.setFont(controlPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.NONE;
        bagConstraints1.insets = new Insets(17, 30, 17, 50);

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 1;
            
        nextRecordButton.addActionListener(ae -> nextProductButtonClicked());
        
        controlPanel.add(nextRecordButton, bagConstraints1);
        
        quitButton = new JButton("Quit");
        quitButton.setFont(controlPanelFont);
                
        bagConstraints1.fill = GridBagConstraints.NONE;

        bagConstraints1.gridx = 2;
        bagConstraints1.gridy = 1;
        
        quitButton.addActionListener(ae -> { System.exit(0); });
        
        controlPanel.add(quitButton, bagConstraints1);
    }
    
    private void nextProductButtonClicked()
    {
        if((productRecIndex + 1) < productArray.size()) productRecIndex += 1;
        DisplayProductInfo(productRecIndex);
    }
    
    private void prevProductButtonClicked()
    {
        if((productRecIndex - 1) >= 0) productRecIndex -= 1;
        DisplayProductInfo(productRecIndex);
    }
    
    private void DisplayProductInfo(int productIndex)
    {
        if((productArray.size() > 0) && (productIndex < productArray.size()))
        {
            productName.setText(productArray.get(productIndex).getM_sName().trim());
            productDescription.setText(productArray.get(productIndex).getM_sDescription().trim());
            productID.setText(productArray.get(productIndex).getM_sID().trim());
            productCost.setText(String.valueOf(productArray.get(productIndex).getM_fCost()));
            
            productCount.setText("" + (productIndex + 1));
            productCountLabel.setText(" of " + productArray.size());
        }
    }
    
    private void ClearProductDisplay()
    {
        productName.setText("");
        productDescription.setText("");
        productID.setText("");
        productCost.setText("");

        productCount.setText("");
        productCountLabel.setText("");
    }
    
    private static long productRecordPos = 0;
    private static int productRecIndex = 0;
    
    private void SerachProductRecordInFile()
    {
        String strSearchProduct = searchProduct.getText();
        
        if(strSearchProduct.isEmpty()) return;
            
        long fileLength = 0;
        
        final int NAMESIZE = 35;
        final int DESCSIZE = 75;
        final int IDSIZE = 6;
        
        try 
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            Path productfile = Paths.get(workingDirectory.getPath() + "/src/ProductDataRandom.txt");

            RandomAccessFile productDataFile = new RandomAccessFile(productfile.toFile(), "r");

            fileLength = productDataFile.length();
            
            while(productRecordPos < fileLength)
            {
                productDataFile.seek(productRecordPos);

                byte[] productNameBytes = new byte[NAMESIZE];

                productDataFile.read(productNameBytes);

                String strProductName = new String(productNameBytes);
                
                if(!strProductName.contains(strSearchProduct))
                {
                    productRecordPos += (NAMESIZE + DESCSIZE + IDSIZE + Double.BYTES);
                    continue;
                }
                
                Product productRecord = new Product();
                
                productRecord.setM_sName(strProductName.trim());

                productRecordPos += NAMESIZE;
                
                byte[] productDescBytes = new byte[DESCSIZE];

                productDataFile.read(productDescBytes);

                String strProductDesc = new String(productDescBytes);
                                
                productRecord.setM_sDescription(strProductDesc.trim());

                productRecordPos += DESCSIZE;
                
                byte[] productIDBytes = new byte[IDSIZE];

                productDataFile.read(productIDBytes);

                String strProductID = new String(productIDBytes);
                
                productRecord.setM_sID(strProductID.trim());

                productRecordPos += IDSIZE;
                
                double fProductCost = productDataFile.readDouble();
                
                productRecord.setM_fCost(fProductCost);

                productRecordPos += Double.BYTES;
                                
                productArray.add(productRecord);
            }
            
            productDataFile.close();
            
            DisplayProductInfo(productRecIndex);

            if(productArray.isEmpty())
                JOptionPane.showMessageDialog(null, "No Product Record found in File");
        }
        catch (EOFException e) 
        {
            JOptionPane.showMessageDialog(null, "EOF Exception in Reading Product Object from File");
            //e.getStackTrace();
        }
        catch (FileNotFoundException e) 
        {
            JOptionPane.showMessageDialog(null, "File Not Found Exception in Reading Product Object from File");
            //e.printStackTrace();
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(null, "IOException in Reading Product Object from File");
            //e.printStackTrace();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Exception in writing Product Object to File");
            //e.getStackTrace();
        }
    }
    
    private void searchProductButtonClicked()
    {
        productRecordPos = 0;
        productRecIndex = 0;
        productArray.clear();
        ClearProductDisplay();
        SerachProductRecordInFile();
    }
}
