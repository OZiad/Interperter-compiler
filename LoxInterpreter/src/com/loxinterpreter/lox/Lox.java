package com.loxinterpreter.lox;

import com.loxinterpreter.error.DefaultErrorReporter;
import com.loxinterpreter.error.ErrorReporter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lox {
    private static final ErrorReporter errorReporter = new DefaultErrorReporter();

    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    private static void runPrompt() throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        while (true) {
            System.out.print("> ");
            String line = reader.readLine();
            if (line == null) break;
            run(line);
            errorReporter.setHadError(false);
        }
    }

    public static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
        if (errorReporter.hadError()) System.exit(65);
    }

    private static void run(String source) {
//        Scanner scanner = new Scanner(source);
//        List<Token> tokens = scanner.scanTokens();
//
//        for (Token token : tokens) {
//            System.out.println(token);
    }
}
