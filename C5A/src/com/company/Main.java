package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> sitiosBloqueados = Arrays.asList("www.youtube.com","www.facebook.com","www.clarin.com");

        IConexionInternet proxy = new ProxyInternet(sitiosBloqueados,new InternetService());

        //Solicita conectarse a determinas URLs
        proxy.conectarCon("www.google.com");
        proxy.conectarCon("www.clarin.com");
    }
}
