package org.example;

public class Converter {
    // Fields to store the groupId, artifactId, and version of the dependency
    private final String groupId;
    private final String artifactId;
    private final String version;

    // Constructor to initialize Converter with groupId, artifactId, and version
    public Converter(String groupId, String artifactId, String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    // Method to convert the dependency information to XML format
    public String toXml() {
        return "  <dependency>\n" +
                "    <groupId>" + groupId + "</groupId>\n" +
                "    <artifactId>" + artifactId + "</artifactId>\n" +
                "    <version>" + version + "</version>\n" +
                "  </dependency>\n";
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getVersion() {
        return version;
    }
}
