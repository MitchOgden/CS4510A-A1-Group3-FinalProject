package edu.baker.project13;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * RPN Calculator Project
 */
public class Project13 {

    /**
     * Entry point for the application.
     * @param args Command-line arguments. Pass a file path to read from a file.
     */
    public static void main(String[] args) {
        // Display a welcome message
        System.out.println("RPN Calculator!");
        
        // Initialize the reader
        Reader reader;
        try {
            // Check if a file path is provided as a command-line argument
            if (args.length >= 1) {
                Path path = FileSystems.getDefault().getPath(args[0]);
                reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            } else {
                 // If no file path is provided, read from standard input
                System.out.println("Enter one value or function name per line then <ENTER>.");
                System.out.println("Type 'Exit' then <ENTER> to quit.");
                reader = new InputStreamReader(System.in);
            }
            // Create an RPNEquationProcessor and process the input
            RPNEquationProcessor eqProcessor = new RPNEquationProcessor(reader);
            BigDecimal result = eqProcessor.processInput(new OutputStreamWriter(System.out));
            
            // Display the final result
            System.out.println("Result: " + result.toPlainString());
        } catch (Exception ex) {
            // Handle exceptions and display an error message
            System.out.println("An exception occurred: " + 
                ex.getClass().getSimpleName() + " " + ex.getMessage());
        }
    }
}
