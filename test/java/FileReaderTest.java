import org.example.Converter;
import org.example.FileReader;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FileReaderTest {
    @Test
    public void testReadDependencies() throws IOException {
        // Create a test input file
        File inputFile = new File("test_input.txt");
        inputFile.createNewFile();

        // Write some sample data to the input file
        java.io.FileWriter writer = new java.io.FileWriter(inputFile);
        writer.write("groupId1.groupId=groupId1\n");
        writer.write("groupId1.artifactId=artifactId1\n");
        writer.write("groupId1.version=version1\n");
        writer.write("groupId2.groupId=groupId2\n");
        writer.write("groupId2.artifactId=artifactId2\n");
        writer.write("groupId2.version=version2\n");
        writer.close();

        // Create a FileReader instance
        FileReader reader = new FileReader(inputFile.getAbsolutePath());

        // Read the dependencies from the file
        List<Converter> dependencies = reader.readDependencies();

        // Verify that the dependencies were read correctly
        assertEquals(2, dependencies.size());
        Converter dependency1 = dependencies.get(0);
        assertEquals("groupId1", dependency1.getGroupId());
        assertEquals("artifactId1", dependency1.getArtifactId());
        assertEquals("version1", dependency1.getVersion());
        Converter dependency2 = dependencies.get(1);
        assertEquals("groupId2", dependency2.getGroupId());
        assertEquals("artifactId2", dependency2.getArtifactId());
        assertEquals("version2", dependency2.getVersion());
    }
}