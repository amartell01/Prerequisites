import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Index {
	private BufferedWriter bw1;
	private BufferedWriter bw2;
	private HashMap <String, String> blobs;
	
	public Index () {
		blobs=new HashMap <String,String>();
	}
	public void init() throws IOException {
        File objects = new File ("objects");
        objects.mkdir();
        File myObj = new File("index.txt"); 
        myObj.delete();
        File f2=new File ("index.txt");
        f2.createNewFile();

	}
	public void add (String filename) throws IOException {
		Blob create = new Blob (filename);
		blobs.put (filename, create.getSha1());
		try(FileWriter fw = new FileWriter("index.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(filename + " : " + create.getSha1());
			    
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}
	public void remove (String filename) throws IOException {
		String Sha1 = blobs.remove(filename);
		File myObj = new File ("objects/"+Sha1+".txt");
		myObj.delete();
		File f2=new File ("indexnew.txt");
        f2.createNewFile();
        Scanner scanner1=new Scanner (new File ("index.txt"));
        if (scanner1.hasNextLine()) {
        	try(FileWriter fw = new FileWriter("indexnew.txt", true);
    			    BufferedWriter bw1 = new BufferedWriter(fw);
    			    PrintWriter out = new PrintWriter(bw1))
    			{
        		String line = scanner1.nextLine();
    			int index = line.indexOf(':');
    			if (line.substring(0,index).equals(filename + " ")) {
    				
    			} else {
    				out.println (line);
    			}
//    			    
    			} catch (IOException e) {
    			}
			
			
			
		}
		while (scanner1.hasNextLine()) {
			try(FileWriter fw = new FileWriter("indexnew.txt", true);
    			    BufferedWriter bw2 = new BufferedWriter(fw);
    			    PrintWriter out = new PrintWriter(bw2))
    			{
        		String line = scanner1.nextLine();
    			int index = line.indexOf(':');
    			if (line.substring(0,index).equals(filename + " ")) {
    				
    			} else {
    				out.println (line);
    			}
//    			    
    			} catch (IOException e) {
    			}
		}
		
		scanner1.close();
		File f1=new File ("index.txt");
        f1.delete();
        File f3=new File ("index.txt");
        f2.renameTo(f3);
	}

}
