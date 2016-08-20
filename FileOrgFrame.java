import javax.swing.JFrame;

public class FileOrgFrame extends JFrame
{
  // The two parameters for the size of the program
  int WIDTH = 500;
  int HEIGHT = 300;
  
  // Here we create an instance of the Panel to add to the Frame
  FilePanel panel = new FilePanel(WIDTH, HEIGHT);
  
  public FileOrgFrame()
  {
    setTitle("File Organizer v1.0");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(WIDTH, HEIGHT);
    setResizable(false);
    
    add(panel);
    
  }
  
}