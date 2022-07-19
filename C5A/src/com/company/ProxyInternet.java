package com.company;

import java.util.List;

public class ProxyInternet implements IConexionInternet {
    //Atributos
    private InternetService internetService;
    private List<String> sitiosBloqueados;

    //Constructor
    public ProxyInternet(List<String> sitiosBloqueados, InternetService internetService) {
        this.sitiosBloqueados = sitiosBloqueados;
        this.internetService = internetService;
    }

    //Si la url a la que nos queremos conectar, no esta en la lista de sitios bloqueados, nos conectamos.
    @Override
    public void conectarCon(String url) {
        if(!this.sitiosBloqueados.contains(url))
            this.internetService.conectarCon(url);
        else
            System.out.println("Acceso denegado a la URL: "+url);
    }
}
