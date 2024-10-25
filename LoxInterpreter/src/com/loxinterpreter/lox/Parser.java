package com.loxinterpreter.lox;

import java.util.List;

public class Parser {
    final List<Token> tokens;
    int current = 0;

    Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

}
