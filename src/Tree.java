
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Tree {
//	private final int numberOfBranches = 100;
//	
	private String sha;
	private HashMap <String, String> hm;
	private File file;
	private PrintWriter pw;
	
	public Tree (HashMap <String, String> h) throws IOException {
		hm = h;
		String str = readHM(hm);
		sha = encryptThisString(str);
		file = new File ("objects/"+sha+".txt");
		file.createNewFile();
		pw= new PrintWriter("objects/"+sha+".txt");
		pw.print(str);
		pw.close();
	}
	
	private String readHM(HashMap <String, String> h) {
		String str = "";
		for (Entry<String, String> entry : h.entrySet()) {
			str+=entry.getKey()+" : "+entry.getValue()+"/n";
		}
		return str;
	}
	
	 private static String encryptThisString(String input)
	    {
	        try {
	            // getInstance() method is called with algorithm SHA-1
	            MessageDigest md = MessageDigest.getInstance("SHA-1");
	 
	            // digest() method is called
	            // to calculate message digest of the input string
	            // returned as array of byte
	            byte[] messageDigest = md.digest(input.getBytes());
	 
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
}
