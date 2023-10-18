package edu.baker.finalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * This class is responsible for processing RPN equations from an input source.
 */
public class RPNEquationProcessor {
    // Instance of RPNCalculator to perform calculations
    private final RPNCalculator calc;
    
    // Reader for input
    private final BufferedReader input;
    
    // Map to store variables and their values
    private final Map<String, BigDecimal> variables = new HashMap<>();
    
    // MathContext for precision settings
    private final MathContext mc;  
    
    /**
     * Constructor that initializes the RPNCalculator and input reader.
     * @param reader The reader for input.
     * @param mc MathContext
     */
    public RPNEquationProcessor(Reader reader, MathContext mc) {
        this.mc = mc;
        this.calc = new RPNCalculator(mc);
        this.input = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    /**
     * Processes the input equations and returns the final result.
     * @param writer The writer for output.
     * @return The final result as a BigDecimal.
     * @throws IOException If an I/O error occurs.
     */
    public BigDecimal processInput(Writer writer) throws IOException {
        BufferedWriter buffer = writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer);
        String line;
        while ((line = input.readLine()) != null) {
            String result = processCommand(line.trim());
            if (result == null) break;
            buffer.write(result);
            buffer.newLine();
            buffer.flush();
        }
        return calc.isEmpty() ? BigDecimal.ZERO : calc.peek();
    }

    // Predefined variables that cannot be redefined
    private static final Set<String> predefinedVariables = new HashSet<>(List.of("x", "y", "e", "π", "pi"));

    /**
     * Processes a single command or equation.
     * @param cmd The command to process.
     * @return The result as a string.
     */
    public String processCommand(String cmd) {
        if (cmd.startsWith("#")) return cmd;
        try {
            // Handle variable assignments
            if (cmd.contains("=")) {
                String[] parts = cmd.split("=");
                String variable = parts[0].trim();
                // Check if the variable is predefined and cannot be redefined
                if (predefinedVariables.contains(variable)) {
                    return "Can't redefine " + variable;
                }
                // Assign the new value to the variable
                variables.put(variable, new BigDecimal(parts[1]));
                return cmd;
            }
            
            // Handle various commands and operations
            switch (cmd.toLowerCase()) {
                case "add":
                case "+":
                    calc.add();
                    break;
                case "sub":
                case "-":
                    calc.sub();
                    break;
                case "mult":
                case "*":
                    calc.mult();
                    break;
                case "div":
                case "/":
                    calc.div();
                    break;
                case "swap":
                    calc.swap();
                    break;
                case "min":
                    calc.min();
                    break;
                case "max":
                    calc.max();
                    break;
                case "abs":
                    calc.abs();
                    break;
                case "neg":
                    calc.neg();
                    break;
                case "floor":
                    calc.floor();
                    break;
                case "ceil":
                    calc.ceil();
                    break;
                case "round":
                    calc.round();
                    break;
                case "ipow":
                    calc.ipow();
                    break;
                case "pow":
                    calc.pow();
                    break;
                case "root":
                    calc.root();
                    break;
                case "exp":
                    calc.exp();
                    break;
                case "log":
                    calc.log();
                    break;
                case "cos":
                    calc.cos();
                    break;
                case "sin":
                    calc.sin();
                    break;
                case "tan":
                    calc.tan();
                    break;
                case "acos":
                    calc.acos();
                    break;
                case "asin":
                    calc.asin();
                    break;
                case "atan":
                    calc.atan();
                    break;
                case "e":
                    calc.e();
                    break;
                case "π":
                case "pi":
                    calc.π();
                    break;
                case "x":
                    calc.x();
                    break;
                case "y":
                    calc.y();
                    break;
                case "end":
                case "exit":
                case "quit":
                case "stop":
                    return null;
                default:
                    try {
                        calc.value(new BigDecimal(cmd));
                    } catch (NumberFormatException ex) {
                        BigDecimal d = variables.get(cmd);
                        if (d != null) calc.value(d);
                        else return "Undefined variable: " + cmd;
                    }
                    break;
            }
        } catch (NumberFormatException ex) {
            // Handle number format exceptions
            return "Illegal assignment: " + cmd;
        } catch (NoSuchElementException ex) {
            // Handle empty stack exceptions
            return "Stack empty!";
        } catch (Exception ex) {
            // Handle all other exceptions
            return ex.getClass().getSimpleName() + ": " + ex.getMessage();
        }
        
        // Return the current top value of the calculator stack
        return calc.peek().toEngineeringString();

    }
}
