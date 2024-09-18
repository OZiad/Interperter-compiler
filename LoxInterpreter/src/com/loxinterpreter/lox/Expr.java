package com.loxinterpreter.lox;

abstract class Expr {

    abstract <R> R accept(Visitor<R> visitor);

    interface Visitor<R> {
        R visitBinaryExpr(Binary binary);

        R visitGroupingExpr(Grouping grouping);

        R visitLiteralExpr(Literal literal);

        R visitUnaryExpr(Unary unary);

    }

    static class Binary extends Expr {

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitBinaryExpr(this);
        }

        final Expr left;
        final Token operator;
        final Expr right;

        Binary(Expr left, Token operator, Expr right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }
    }

    static class Grouping extends Expr {

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitGroupingExpr(this);
        }

        final Expr expression;

        Grouping(Expr expression) {
            this.expression = expression;
        }
    }

    static class Literal extends Expr {

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitLiteralExpr(this);
        }

        final Object value;

        Literal(Object value) {
            this.value = value;
        }
    }

    static class Unary extends Expr {

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitUnaryExpr(this);
        }

        final Token operator;
        final Expr right;

        Unary(Token operator, Expr right) {
            this.operator = operator;
            this.right = right;
        }
    }
}
