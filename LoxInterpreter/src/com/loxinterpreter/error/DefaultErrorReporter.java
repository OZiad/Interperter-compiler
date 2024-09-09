package com.loxinterpreter.error;

public class DefaultErrorReporter implements ErrorReporter {
    public static String DEFAULT_UNEXPECTED_CHAR = "Unexpected character.";
    private static boolean hadError = false;

    public boolean hadError() {
        return hadError;
    }

    public void setHadError(boolean bool) {
        hadError = bool;
    }

    public void error(int line, String message) {
        ErrorReporter.report(line, "", message);
        setHadError(true);
    }

}
