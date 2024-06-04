package org.example;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileConverter {
    private static final Logger LOGGER = Logger.getLogger(FileConverter.class.getName());

    public static void main(String[] args) {
        // Define the input and output file paths
        String inputFilePath = "projects.txt";
        String outputFilePath = "projects.xml";

        // Create FileReader and FileWriter objects with the specified file paths
        FileReader reader = new FileReader(inputFilePath);
        FileWriter writer = new FileWriter(outputFilePath);

        try {
            // Read dependencies from the input file
            List<Converter> dependencies = reader.readDependencies();
            // Write dependencies to the output file in XML format
            writer.writeDependencies(dependencies);
        } catch (IOException e) {
            // Log the exception with a SEVERE level
            LOGGER.log(Level.SEVERE, "An error occurred while converting the file", e);
        }
    }
}
