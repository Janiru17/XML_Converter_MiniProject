import org.example.Converter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConverterTest {
    @Test
    public void testToXml() {
        Converter converter = new Converter("groupId", "artifactId", "version");
        String xml = converter.toXml();
        assertEquals("  <dependency>\n" +
                "    <groupId>groupId</groupId>\n" +
                "    <artifactId>artifactId</artifactId>\n" +
                "    <version>version</version>\n" +
                "  </dependency>\n", xml);
    }
}