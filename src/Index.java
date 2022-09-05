import java.io.File;
import java.io.IOException;

public class Index {
	public Index () {
		
	}
	public void init() throws IOException {
        File objects = new File ("objects");
        objects.mkdir();
        File f2=new File ("index.txt");
        f2.createNewFile();

	}
}
