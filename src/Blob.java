import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Blob {
	private String Sha1;
	
	public Blob (String file) throws IOException {
		Path p1=Paths.get(file);
		String contents = Files.readString(p1) ;
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
	            Sha1 = no.toString(16);
	 
	            // Add preceding 0s to make it 32 bit
	            while (Sha1.length() < 32) {
	                Sha1 = "0" + Sha1;
	            }
	 
	            
	            
	        }
	 
	        // For specifying wrong message digest algorithms
	        catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
		 
	}
	public String getSha1(){
		return Sha1;
	}
}
