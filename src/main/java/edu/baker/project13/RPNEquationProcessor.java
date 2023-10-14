package edu.baker.project13;

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

public class RPNEquationProcessor {
    private final RPNCalculator calc;
    private final BufferedReader input;
    private final Map<String, BigDecimal> variables = new HashMap<>();
    private final MathContext mc = new MathContext(8);  // Precision can be adjusted if needed

    public RPNEquationProcessor(Reader reader) {
        this.calc = new RPNCalculator(mc);
        this.input = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

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

    private static final Set<String> predefinedVariables = new HashSet<>(List.of("x", "y", "e", "π", "pi"));

    public String processCommand(String cmd) {
        if (cmd.startsWith("#")) return cmd;
        try {
            if (cmd.contains("=")) {
                String[] parts = cmd.split("=");
                String variable = parts[0].trim();
                if (predefinedVariables.contains(variable)) {
                    return "Can't redefine " + variable;
                }
                variables.put(variable, new BigDecimal(parts[1]));
                return cmd;
            }
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
            return "Illegal assignment: " + cmd;
        } catch (NoSuchElementException ex) {
            return "Stack empty!";
        } catch (Exception ex) {
            return ex.getClass().getSimpleName() + ": " + ex.getMessage();
        }
        return calc.peek().toString();
    }
}
