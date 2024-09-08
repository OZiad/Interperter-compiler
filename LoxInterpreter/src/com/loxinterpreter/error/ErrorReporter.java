package com.loxinterpreter.error;

public interface ErrorReporter {

    static void error(int line, String message) {
        report(line, "", message);
    }

    private static void report(int line, String where, String message) {
        System.err.println(
                "[line " + line + "] Error" + where + ": " + message);
    }

    boolean hadError();

    void setHadError(boolean bool);

}
