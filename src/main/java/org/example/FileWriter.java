package org.example;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriter {

    private static final Logger LOGGER = Logger.getLogger(FileWriter.class.getName());
    // Path of the file where dependencies will be written
    private final String filePath;

    // Constructor to initialize FileWriter with the output file path
    public FileWriter(String filePath) {
        this.filePath = filePath;
    }

    // Method to write the list of dependencies to the file in XML format
    public void writeDependencies(List<Converter> dependencies) throws IOException {
        // Log the start of the writing process
        LOGGER.info("Starting to write dependencies to " + filePath);

        // To ensure the FileWriter is closed after use
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            // Write the opening XML tag for dependencies
            writer.write("<dependencies>\n");
            LOGGER.info("Written opening <dependencies> tag.");

            // Iterate through each dependency and write it in XML format
            for (Converter dependency : dependencies) {
                writer.write(dependency.toXml());
                // Log each dependency written for finer level debugging
                LOGGER.fine("Written dependency: " + dependency.toXml());
            }

            // Write the closing XML tag for dependencies
            writer.write("</dependencies>");
            LOGGER.info("Written closing </dependencies> tag.");
        } catch (IOException e) {
            // Log the exception with a SEVERE level if an error occurs
            LOGGER.log(Level.SEVERE, "An error occurred while writing dependencies to the file", e);
            // Rethrow the exception to notify the caller
            throw e;
        }

        // Log the completion of the writing process
        LOGGER.info("Finished writing dependencies to " + filePath);
    }
}
