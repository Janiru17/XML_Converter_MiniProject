import org.example.FileConverter;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class FileConverterTest {
    @Test
    public void testMain() throws IOException {
        // Create a test input file
        File inputFile = new File("test_projects.txt");
        inputFile.createNewFile();

        // Create a test output file
        File outputFile = new File("test_projects.xml");

        // Run the main method
        String[] args = new String[] {inputFile.getAbsolutePath(), outputFile.getAbsolutePath()};
        FileConverter.main(args);

        // Verify that the output file was created
        assertTrue(outputFile.exists());

    }
}