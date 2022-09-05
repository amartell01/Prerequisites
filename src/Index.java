import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Index {
	private BufferedWriter bw;
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
}
