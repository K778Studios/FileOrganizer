import javax.swing.JTextArea;


public class FileSorter
{
  public FileSorter()
  {
    // Nothing added in here
  }
  
  
  public void returnDifferentFiles(String filesA[], String filesB[], JTextArea output)
  {
    // Here we have a count variable to keep track if there is the specific file
    int count = 0;
    
    // Here we clear the Text Area
    output.setText("");
    
    int a = filesA.length;
    int b = filesB.length;
    
    if (a > b)
    {
      for (int z = 0; z < a; z++)
      {
        int posA = filesA[z].lastIndexOf(".");
        for (int i = 0; i < b; i++)
        {
          int posB = filesB[i].lastIndexOf(".");
          if (filesA[z].substring(0, posA).equals(filesB[i].substring(0, posB)))
          {
            count++;
          }
        }
        
        if (count == 0)
        {
          output.append(filesA[z].substring(0, posA) + "\n");
          System.out.println(filesA[z].substring(0, posA));
        }
        count = 0;
      }
    }
    
  }
  
}