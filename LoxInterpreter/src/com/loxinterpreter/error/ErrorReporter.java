package com.loxinterpreter.error;

public interface ErrorReporter {

    static void report(int line, String where, String message) {
        System.err.println(
                "[line " + line + "] Error" + where + ": " + message);
    }

    default void error(int line, String message) {
        report(line, "", message);
    }
}
