package com.funcional.interfaces.impl;

import com.funcional.interfaces.Suma;

public class SumaImpl implements Suma {

    @Override
    public int suma(int a, int b) {
        return a+b;
    }
}
