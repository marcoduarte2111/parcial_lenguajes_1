import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class TrigCalculator {

    public static void main(String[] args) throws Exception {
        // Open the input file containing the trigonometric expressions
        File file = new File("expr.in");
        Scanner scanner = new Scanner(file);

        // Process each line in the input file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Create a CharStream from the input line
            CharStream input = CharStreams.fromString(line);

            // Create a lexer and parser for the input
            TrigLexer lexer = new TrigLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TrigParser parser = new TrigParser(tokens);

            // Parse the input and generate the parse tree
            ParseTree tree = parser.expr();

            // Visit the tree and calculate the result
            TrigVisitorImpl visitor = new TrigVisitorImpl();
            Double result = visitor.visit(tree);

            // Print the result
            System.out.println(result);
        }

        scanner.close();
    }
}

// Visitor implementation to evaluate trigonometric functions
class TrigVisitorImpl extends TrigBaseVisitor<Double> {

    @Override
    public Double visitExpr(TrigParser.ExprContext ctx) {
        // Get the function name (Sin, Cos, Tan)
        String func = ctx.trig_func().getText();

        // Get the argument (NUMBER) as a double
        double value = Double.parseDouble(ctx.NUMBER().getText());

        // Convert degrees to radians
        double radians = Math.toRadians(value);

        // Perform the appropriate trigonometric calculation
        switch (func) {
            case "Sin":
                return Math.sin(radians);
            case "Cos":
                return Math.cos(radians);
            case "Tan":
                return Math.tan(radians);
            default:
                return 0.0;
        }
    }
}
