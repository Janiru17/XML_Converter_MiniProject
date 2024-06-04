# FileConverter
## Overview
FileConverter is a Java application that reads project dependencies from a text file (projects.txt) and writes them to an XML file (projects.xml). The application includes three main components: FileReader, FileWriter, and Converter.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven (for dependency management and building the project)


## Getting Started
 - Open IntelliJ IDEA
 - Clone the repository
   `https://github.com/Janiru17/XML_Converter.git`
   OR
 - Import the Project: 
   - Click on File > New > Project from Existing Sources...
   - Select the root directory of the project.
   - Choose the pom.xml file when prompted.


## Build the Project
1. Open Terminal (or use the built-in terminal in IntelliJ IDEA)
2. Navigate to the root directory of the project where the pom.xml file is located.
3. Run the following command to compile the project and download dependencies:
`mvn clean install`

## Running the Application
Ensure projects.txt exists in the root directory and contains dependencies in this format:
```
dependency1.groupId=com.example
dependency1.artifactId=my-project
dependency1.version=1.0.0;
dependency2.groupId=org.sample
dependency2.artifactId=sample-project
dependency2.version=2.0.0;
```

## Create a Run Configuration:
- Click on Run > Edit Configurations....
- Click the + button and select Application.
-Set the Main class to org.example.FileConverter.


## Run the application:
- Click the Run button.
  
## File Format
#### Input File (projects.txt)
- The input file should contain project dependencies in the following format:

```
dependency1.groupId=com.example
dependency1.artifactId=my-project
dependency1.version=1.0.0;
dependency2.groupId=org.sample
dependency2.artifactId=sample-project
dependency2.version=2.0.0;
Output File (projects.xml)
```

- The output file will be an XML file with the dependencies formatted as follows:

```
<dependencies>
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>my-project</artifactId>
        <version>1.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.sample</groupId>
        <artifactId>sample-project</artifactId>
        <version>2.0.0</version>
    </dependency>
</dependencies>
```

## Author
- Janiru Wickramage - [Initial work - @janiruw17](https://github.com/Janiru17/XML_Converter)
