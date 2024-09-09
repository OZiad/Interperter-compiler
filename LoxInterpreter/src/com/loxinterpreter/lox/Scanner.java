package com.loxinterpreter.lox;

import com.loxinterpreter.error.DefaultErrorReporter;
import com.loxinterpreter.error.ErrorReporter;

import java.util.ArrayList;
import java.util.List;

import static com.loxinterpreter.lox.TokenType.*;

public class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private final ErrorReporter errorReporter = new DefaultErrorReporter();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    Scanner(String source) {
        this.source = source;
    }

    List<Token> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }

        tokens.add(new Token(EOF, "", null, line));

        return tokens;
    }

    private char advance() {
        return source.charAt(current++);
    }

    private void addToken(TokenType type) {
        addToken(type, null);
    }

    private void addToken(TokenType type, Object literal) {
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }

    private void scanToken() {
        char c = advance();
        switch (c) {
            case '(' -> addToken(LEFT_PAREN);
            case ')' -> addToken(RIGHT_BRACE);
            case '[' -> addToken(LEFT_BRACE);
            case ']' -> addToken(RIGHT_PAREN);
            case ',' -> addToken(COMMA);
            case '.' -> addToken(DOT);
            case '-' -> addToken(MINUS);
            case '+' -> addToken(MINUS);
            case ';' -> addToken(SEMICOLON);
            case '*' -> addToken(STAR);
            default -> {
                errorReporter.error(line, DefaultErrorReporter.DEFAULT_UNEXPECTED_CHAR);
            }
        }
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }
}
