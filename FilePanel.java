import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class FilePanel extends JPanel implements ActionListener
{
  // Set up the two panels that will create this Panel
  JPanel topPanel = new JPanel();
  JPanel bottomPanel = new JPanel();
  // Here we create the gridlayout to set up the top and bottom
  GridLayout halves = new GridLayout(2, 1);
  
  // Here we add the top Panel's JTextArea, and two buttons 
  JLabel instructionsLabel = new JLabel("Instructions:                                                       ");
  JTextArea instructions = new JTextArea();
  JButton fileA = new JButton("A");
  JTextField fileAPath = new JTextField(10);
  JButton fileB = new JButton("B");
  JTextField fileBPath = new JTextField(10);
  GridBagLayout topRightLayout = new GridBagLayout();
  
  // Here we add the JText and Compare button for the bottom panel
  JLabel outputLabel = new JLabel("Output:");
  JTextArea output = new JTextArea();
  
  
  JButton compare = new JButton("Compare");
  // We need to make a GridBagLayout in order to add the compare button to the middle
  GridBagConstraints gbc = new GridBagConstraints();
  GridBagLayout compareLayout = new GridBagLayout();
  
  // Here we divide the top and bottom panels into 4 different panels
  JPanel topLeft = new JPanel();
  JPanel topRight = new JPanel();
  // Here we add the gridlayout for the top panel
  GridLayout topP = new GridLayout(1, 2);
  JPanel bottomLeft = new JPanel();
  JPanel bottomRight = new JPanel();
  // Here we add the gridlayout for the bottom panel
  GridLayout bottomP = new GridLayout(1, 2);
  
  // Here we add in the JFileChooser
  final JFileChooser fc = new JFileChooser();
  
  // Here we create a FileSorter object to handle the sorting of all the names of the files
  FileSorter sorter = new FileSorter();
  
  // Here we create the variables that will be used for handling the actual file names
  File filesA[];
  File filesB[];
  
  String selectedA[];
  String selectedB[];
  
  // Here we put the JScrollPane object
  JScrollPane scroller = new JScrollPane(output);
  
  
  public FilePanel(int w, int h)
  {
    setSize(w, h);
    
    fc.setMultiSelectionEnabled(true);
    
    // Here we set the layout for the Panel class
    setLayout(halves);
    
    // Here we add the two panels to the entire panel
    add(topPanel);
    add(bottomPanel);
    
    // Here we set the layout for the top panel
    topPanel.setLayout(topP);
    // We add the two panels to the top
    topPanel.add(topLeft);
    topPanel.add(topRight);
    
    // Here we add all the buttons and Text fields for the top right panel
    topRight.setLayout(topRightLayout);
    gbc.gridx = 0;
    gbc.gridy = 0;
    topRight.add(fileA, gbc);
    gbc.gridx = 1;
    gbc.gridy = 0;
    topRight.add(fileAPath, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    topRight.add(fileB, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    topRight.add(fileBPath, gbc);
    // Here we tweak the file path displays to not allow the user to edit it
    fileAPath.setEditable(false);
    fileBPath.setEditable(false);
    
    // Here we add the actionlisteners for the buttons
    fileA.addActionListener(this);
    fileB.addActionListener(this);
    
    
    
    // Here we set the layout for the bottom panel
    bottomPanel.setLayout(bottomP);
    // We add the two panels to the bottom
    bottomPanel.add(bottomLeft);
    bottomPanel.add(bottomRight);
    
    // Here we add the instructions to the topLeft Panel
    topLeft.add(instructionsLabel);
    topLeft.add(instructions);
    instructions.setText("Choose to the right which two File locations\nyou want to use. In File A, the program will\ncompare which of the files are not located as\nwell in File B.");
    
    // Here we add the Output JTextArea
    bottomLeft.add(outputLabel);
    //bottomLeft.add(output);
    output.setText("");
    //output.setPreferredSize(new Dimension(200, 100));
    //output.setAlignmentX(1);
    //output.setAlignmentY(1);
    // Here we add the scrolling mechamism for this JTextArea
    scroller.setPreferredSize(new Dimension(200, 105));
    //bottomLeft.add(scroller);
    //scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    //scroller.setEnabled(true);
    //scroller.setWheelScrollingEnabled(true);
    //scroller.setAutoscrolls(true);
    //scroller.setBounds(10,60,200,150);
    bottomLeft.add(scroller);
    
    // Here we set the layout and add the compare button to the bottomRight panel
    bottomRight.setLayout(compareLayout);
    gbc.gridx = 2;
    gbc.gridy = 2;
    bottomRight.add(compare, gbc);
    compare.setPreferredSize(new Dimension(90, 23));
    compare.addActionListener(this);
    /*
    topLeft.setBackground(Color.black);
    topRight.setBackground(Color.red);
    bottomLeft.setBackground(Color.blue);
    bottomRight.setBackground(Color.white);
    */
    
    
  }
  
  public void actionPerformed(ActionEvent e)
  {
    
    
    // Here is the action code for the A button
    if (e.getSource() == fileA)
    {
      //output.setText("");
      fc.showOpenDialog(this);
      filesA = fc.getSelectedFiles();
      int size = filesA.length;
      selectedA = new String[size];
      for (int i = 0; i < filesA.length; i++)
      {
        selectedA[i] = filesA[i].getName();
      }
      
      // Here we set the first selected item to the JTextField
      int pos = selectedA[0].lastIndexOf(".");
      fileAPath.setText(selectedA[0].substring(0, pos));
    }
    
    // Here is the action code for the B button
    if (e.getSource() == fileB)
    {
      fc.showOpenDialog(this);
      filesB = fc.getSelectedFiles();
      int size = filesB.length;
      selectedB = new String[size];
      for (int i = 0; i < filesB.length; i++)
      {
        selectedB[i] = filesB[i].getName();
      }
      
      // Here we set the first selected item to the JTextField
      int pos = selectedB[0].lastIndexOf(".");
      fileBPath.setText(selectedB[0].substring(0, pos));
    }
    
    // Here we add the action for the compare button
    if (e.getSource() == compare)
    {
      sorter.returnDifferentFiles(selectedA, selectedB, output);
    }
    
    
    
  }
  
}




