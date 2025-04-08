package com.funcional.funcional.function;

import java.util.function.Function;

// R apply(T t)
/**Type parameters:
*    <T> – the type of the input to the function
*    <R> – the type of the result of the function
 */

public class FunctionApp {
    private String fun(){
        Function<Integer, String> fx = integer -> Integer.toString(integer);
        return fx.apply(10);
    }

    private int fun2(int num){
        Function<Integer, Integer> fx = x -> x *10;
        Function<Integer, Integer> fx2 = x -> x+10;
        return fx.andThen(fx2).apply(num);
    }

    private int fun3(int num){
        Function<Integer, Integer> fx = x -> x *10;
        Function<Integer, Integer> fx2 = x -> x+10;
        return fx.compose(fx2).apply(num);
    }

    public static void main(String[] args) {
        FunctionApp app = new FunctionApp();
        System.out.println(app.fun());
        System.out.println("El resultado de la funcion andThen es : " + app.fun2(5));
        System.out.println("El resultado de la compose andThen es : " + app.fun3(5));
    }
}
