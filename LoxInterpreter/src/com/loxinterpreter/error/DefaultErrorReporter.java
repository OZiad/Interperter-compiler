package com.loxinterpreter.error;

public class DefaultErrorReporter implements ErrorReporter {
    private static boolean hadError = false;

    public boolean hadError() {
        return hadError;
    }

    public void setHadError(boolean bool) {
        hadError = bool;
    }
}
