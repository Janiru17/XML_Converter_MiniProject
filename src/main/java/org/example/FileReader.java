package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {

    private static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());
    // Path of the file
    private final String filePath;

    // Constructor to initialize FileReader with the input file path
    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    // Read dependencies from the file and return them as a list of Converter objects
    public List<Converter> readDependencies() throws IOException {
        // Log the start of the reading process
        LOGGER.info("Starting to read dependencies from " + filePath);
        // List to store the read dependencies
        List<Converter> dependencies = new ArrayList<>();

        // Use try-with-resources to ensure the BufferedReader is closed after use
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            // Variables to hold the parts of each dependency
            String groupId = null, artifactId = null, version = null;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Split the line into key and value
                String[] parts = line.split("=");
                // If the line is not properly formatted, log a warning and skip it
                if (parts.length != 2) {
                    LOGGER.warning("Skipping invalid line: " + line);
                    continue;
                }
                String key = parts[0].trim();
                String value = parts[1].trim().replace(";", ""); // Remove semicolon

                // Determine which part of the dependency is being read and assign it to the correct variable
                if (key.endsWith(".groupId")) {
                    groupId = value;
                } else if (key.endsWith(".artifactId")) {
                    artifactId = value;
                } else if (key.endsWith(".version")) {
                    version = value;
                    // When all parts are read, create a new Converter object and add it to the list
                    dependencies.add(new Converter(groupId, artifactId, version));
                    // Log the addition of a new dependency for finer level debugging
                    LOGGER.fine("Added dependency: " + groupId + ":" + artifactId + ":" + version);
                }
            }
        } catch (IOException e) {
            // Log the exception with a SEVERE level if an error occurs
            LOGGER.log(Level.SEVERE, "An error occurred while reading data from the file", e);
            // Rethrow the exception to notify the caller
            throw e;
        }

        // Log the completion of the reading process
        LOGGER.info("Finished reading data from " + filePath);
        return dependencies;
    }
}
