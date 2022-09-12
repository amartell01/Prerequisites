import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AshersTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Path p = Paths.get("test.txt");
        try {
            Files.writeString(p, "example", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
<<<<<<< Updated upstream
=======
		File file = new File ("/Prerequisites/test.txt");
		file.delete();
>>>>>>> Stashed changes
	}

	@Test
	void test() {
		System.out.println("testing");
//		fail("Not yet implemented");
	}

}
