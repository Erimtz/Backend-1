package com.company;

public class InternetService implements IConexionInternet {


    @Override
    public void conectarCon(String url) {
        System.out.println("Conectando con "+url);
    }
}
