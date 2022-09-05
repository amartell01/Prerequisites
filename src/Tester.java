import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Tester {
	public static void main (String[] args) throws IOException, NoSuchAlgorithmException {
		Index git = new Index();
		git.init();
//		Blob something = new Blob ("something.txt");
//		System.out.println(something.getSha1());
	}
}
