import org.example.Converter;
import org.example.FileWriter;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class FileWriterTest {
    @Test
    public void testWriteDependencies() throws IOException {
        // Create a test output file
        File outputFile = new File("test_output.xml");

        // Create a FileWriter instance
        FileWriter writer = new FileWriter(outputFile.getAbsolutePath());

        // Create a list of dependencies
        List<Converter> dependencies = new ArrayList<>();
        dependencies.add(new Converter("groupId1", "artifactId1", "version1"));
        dependencies.add(new Converter("groupId2", "artifactId2", "version2"));

        // Write the dependencies to the file
        writer.writeDependencies(dependencies);

        // Verify that the file was written correctly
        assertTrue(outputFile.exists());
        String fileContent = new String(java.nio.file.Files.readAllBytes(outputFile.toPath()));
        assertTrue(fileContent.contains("<dependencies>"));
        assertTrue(fileContent.contains("<groupId>groupId1</groupId>"));
        assertTrue(fileContent.contains("<artifactId>artifactId1</artifactId>"));
        assertTrue(fileContent.contains("<version>version1</version>"));
        assertTrue(fileContent.contains("<groupId>groupId2</groupId>"));
        assertTrue(fileContent.contains("<artifactId>artifactId2</artifactId>"));
        assertTrue(fileContent.contains("<version>version2</version>"));
        assertTrue(fileContent.contains("</dependencies>"));
    }
}