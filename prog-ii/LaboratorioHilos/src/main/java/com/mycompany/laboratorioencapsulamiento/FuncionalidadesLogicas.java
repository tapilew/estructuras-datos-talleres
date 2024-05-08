package com.mycompany.laboratorioencapsulamiento;

public class FuncionalidadesLogicas {
    private int tipoRopa;
    private int pesoRopa;
    private double volumenAgua;
    private double temperaturaSecado;
    // Variables de control de estado de proceso de lavado
    private boolean lavado = false;
    private boolean enjuage = false;
    private boolean centrifugado = false;
    private boolean planchado = false;
    private boolean agua = false;
    private boolean secado = false;

    public FuncionalidadesLogicas(int tipoRopa, int pesoRopa, double volumenAgua, double temperaturaSecado) {
        this.tipoRopa = tipoRopa;
        this.pesoRopa = pesoRopa;
        this.volumenAgua = volumenAgua;
        this.temperaturaSecado = temperaturaSecado;

        recibirValores();
    }

    private void recibirValores() {
        // Verificar que la temperatura de secado esté en el rango permitido
        if (temperaturaSecado > 50 || temperaturaSecado < 30) {
            System.out.println("La temperatura de secado debe estar entre 30 y 50 grados");
        } else {
        }

        // Variable para verifcar que el tipo y el peso de la ropa estén en el margen
        // dado
        String verif = tipoRopa + "-" + pesoRopa;

        switch (verif) {
            case "1-10":
                System.out.println("Iniciando lavado de ropa delicada");
                iniciarLavado();
                break;

            case "2-20":
                System.out.println("Iniciando lavado de ropa normal");
                iniciarLavado();
                break;

            case "3-30":
                System.out.println("Iniciando lavado de ropa pesada");
                iniciarLavado();
                break;

            default:
                System.out.println(
                        "Los valores de peso y tipo están estrictamente relacionados.\n Ingreselos de acuerdo al márgen.");
                break;
        }
    }

    private boolean controlarAgua() {
        // Verificando que el nivel de agua esté de acuerdo a los límites
        if (volumenAgua > 4.5 || volumenAgua < 4.0) {
            agua = false;
        } else {
            agua = true;
        }

        return agua;
    }

    private void iniciarLavado() {
        lavado = true;
        // Iniciando el proceso de lavado
        if (!controlarAgua()) {
            System.out.println("Debe ingresar un volumen de agua entre 4.0 y 4.5");
        } else {
            System.out.println("Iniciando lavado de ropa tipo " + tipoRopa + " y peso " + pesoRopa + "lbs");
            System.out.println("Lavando...");
            System.out.println("Lavado terminado");
            enjuagar();
        }

    }

    private void enjuagar() {
        // Iniciando el proceso de enjuague
        enjuage = true;
        System.out.println("Iniciando enjuague");
        System.out.println("Enjuagando...");
        System.out.println("Enjuague terminado");
        centrifugar();
    }

    private void centrifugar() {
        centrifugado = true;
        // Posible evaluación del tiempo de centrifugado

        /*
         * String temp = getTipoRopa() + "-" + getPesoRopa();
         * switch(temp) {
         * case "1-10":
         * System.out.println("Centrifugado de 4 minutos");
         * break;
         *
         * case "2-20":
         * System.out.println("Centrifugado de 10 minutos");
         * break;
         *
         * case "3-30":
         * System.out.println("Centrifugado de 15 minutos");
         * break;
         *
         * default:
         * System.out.println("No se ha podido determinar el tiempo de centrifugado");
         * break;
         * }
         */

        // Iniciando el proceso de centrifugado
        System.out.println("Iniciando centrifugado de 4 minutos");
        System.out.println("Centrifugando...");
        System.out.println("Centrifugado terminado");
        secar();
    }

    private void secar() {
        secado = true;
        // Verificando si la ropa necesita planchado
        if (temperaturaSecado < 35.7) {
            System.out.println("la ropa no se secó.");
            planchar();
        } else if (temperaturaSecado >= 35.7 && temperaturaSecado < 40.7) {
            System.out.println("La ropa se secó correctamente");
            planchar();
        } else {
            System.out.println("La ropa se secó y planchó correctamente");
            planchado = true;
        }
        // Iniciando el proceso de secado
        System.out.println("Iniciando secado");
        System.out.println("Secando...");
        System.out.println("Secado terminado");
    }

    private void planchar() {
        planchado = true;
        // Iniciando el proceso de planchado
        System.out.println("Iniciando planchado");
        System.out.println("Planchando...");
        System.out.println("Planchado terminado");
    }

    public void terminarCicloLogico() {
        if (lavado && enjuage && centrifugado && secado && planchado) {
            System.out.println("Ciclo de lavado terminado");
        } else {
            System.out.println("Ciclo de lavado no ha terminado");
        }
    }
}
