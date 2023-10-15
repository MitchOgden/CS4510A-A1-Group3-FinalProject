package edu.baker.project13;

/**
 * This class contains integration tests for the RPNCalculator and RPNEquationProcessor classes.
 * It reads .rpn files from the test_cases directory, executes them, and confirms that the final result
 * is a very small number. It also tests for error situations.
 */

import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;
import java.io.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.MathContext;



public class RPNEquationProcessorTest {

    @Test
    public void testProcessInput() throws IOException {
        MathContext mc = new MathContext(10); // or whatever precision you need
        Path path = FileSystems.getDefault().getPath("test_cases");
        for (var p : Files.list(path).collect(Collectors.toList())) {
            if (p.toString().endsWith(".rpn") && !p.toString().endsWith("error_cases.rpn")) {
                System.out.println("Executing: " + p.toString());
                Reader reader = Files.newBufferedReader(p, java.nio.charset.StandardCharsets.UTF_8);
                RPNEquationProcessor eqProcessor = new RPNEquationProcessor(reader, mc); // pass MathContext
                BigDecimal result = eqProcessor.processInput(new OutputStreamWriter(System.out));
                assertTrue(result.abs().compareTo(new BigDecimal("1e-9")) < 0, "Failed at " + p.toString());
            }
        }
    }
    

    @Test
    public void testProcessBadInput() throws IOException {
        StringWriter buffer = new StringWriter();
        MathContext mc = new MathContext(10); // or whatever precision you need
        Path path = FileSystems.getDefault().getPath("test_cases", "error_cases.rpn");
        Reader reader = Files.newBufferedReader(path, java.nio.charset.StandardCharsets.UTF_8);
        RPNEquationProcessor eqProcessor = new RPNEquationProcessor(reader, mc); // pass MathContext
        BigDecimal result = eqProcessor.processInput(buffer);
        String s = buffer.toString();
        assertTrue(s.contains("Stack empty!"), "Stack empty error not found");
    }
}
