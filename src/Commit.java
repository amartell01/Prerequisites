import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Commit {
	private Commit nextCommit;
	private Commit parentCommit;
	private Path pTree;
	private String summary;
	private String author;
	private String date;
	public Commit (String one, String two, String three, Commit parent) {
		pTree= Path.of(one);
		summary  = two;
		author = three;
		parentCommit = parent;
		 File objects = new File ("objects");
	        if (objects.exists()==false) {
	        	objects.mkdir();
	        }
	        
	}
	public String generateSha1String(){
		String contents = getContents();
		try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");
 
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(contents.getBytes());
 
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
 
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
 
            // return the HashText
            return hashtext;
        }
 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}
	public String pTree() {
		return pTree.toString();
	}
	
	public String getDate() {
		return date;
	}
	public String getContents() {
		String contents = new String ("");
		contents = contents+"objects/"+pTree.getFileName() + "\n";
		if (parentCommit ==null) {
			contents=contents+ "\n";
		} else{
			contents=contents+ "objects/" + parentCommit.generateSha1String() + ".txt\n";
		}
		if (nextCommit ==null) {
			contents=contents+ "\n";
		} else{
			contents=contents+"objects/"+nextCommit.generateSha1String() + ".txt\n";
		}
		contents=contents+author + "\n";
		contents=contents+date + "\n";
		contents=contents+this.summary;
		return contents;
	}
	public void writeFile() throws IOException {
		String contents = getContents();
		String fileName = generateSha1String();
		File commit = new File ("objects/"+fileName+".txt");
		commit.createNewFile();
		 Path p = Paths.get("objects/"+fileName+".txt");
	        try {
	            Files.writeString(p, contents, StandardCharsets.ISO_8859_1);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
}