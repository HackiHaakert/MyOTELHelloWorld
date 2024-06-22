package org.example;

import io.opentelemetry.instrumentation.annotations.WithSpan;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        method1();

        System.out.println("Waiting for exit");
        try {
            Thread.sleep(20000);  // 20000 wait to allow Spans to be send
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @WithSpan
    public static void method1() {
        System.out.println("Method 1 called");
        try {
            Thread.sleep(100);  // 100 Milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method2();
    }

    @WithSpan
    public static void method2() {
        System.out.println("Method 2 called");
        try {
            Thread.sleep(100);  // 100 Milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method3();
    }

    @WithSpan
    public static void method3() {
        System.out.println("Method 3 called");
        try {
            Thread.sleep(100);  // 100 Milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method4();
    }

    @WithSpan
    public static void method4() {
        try {
            Thread.sleep(100);  // 100 Milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello, World!");

    }
}