package com.example;


public class App 
{
    public static void main( String[] args )
    {
        Entrada entrada = new Entrada();
        entrada.validaChave();
        System.out.println("Dígito verificador:\t"+entrada.cdv()+ " OK");
    }
}
