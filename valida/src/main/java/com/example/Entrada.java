package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Entrada {
    
    private List<Integer> chave;
    private List<Integer> peso;
    private Integer cDV;
    private StringBuilder sb;

    Scanner sc;

    public void util(){
        peso = new ArrayList<>();
        
        peso.add(0,2);
        peso.add(1,3);
        peso.add(2,4);
        peso.add(3,5);
        peso.add(4,6);
        peso.add(5,7);
        peso.add(6,8);
        peso.add(7,9);

        chave = new ArrayList<>();
        sb = new StringBuilder();
        sc = new Scanner(System.in);
    }

    public void digitaCampos(){
        util();
        
        System.out.print("Digite o UF: ");
        String uf = sc.nextLine();
        // String uf = "52";
        
        System.out.print("Digite o aamm: ");
        String aamm = sc.nextLine();
        // String aamm = "0604";
        
        System.out.print("Digite o cnpj_cpf: ");
        String cnpj_cpf = sc.nextLine();
        // String cnpj_cpf = "33009911002506";
        
        System.out.print("Digite o mod: ");
        String mod = sc.nextLine();
        // String mod = "55";
        
        System.out.print("Digite o serie: ");
        String serie = sc.nextLine();
        // String serie = "012";
        
        System.out.print("Digite o nnf: ");
        String nnf = sc.nextLine();
        // String nnf = "000000780";
        
        System.out.print("Digite o tpemis: ");
        String tpemis = sc.nextLine();
        // String tpemis = "0";
        
        System.out.print("Digite o cnf: ");
        String cnf = sc.nextLine();
        // String cnf = "26730161";
        
        sb.append(uf+aamm+cnpj_cpf+mod+serie+nnf+tpemis+cnf);
        for (int i = 0; i < sb.toString().length(); i++){
            chave.add(Integer.parseInt(sb.substring(i,(i+1))));
        }
        sc.close();
    }

    public void validaChave(){
        util();
        System.out.print("Digite a chave com 44 caracteres numéricos:\t");
        sb.append(sc.nextLine());
        // sb.append("41180678393592000146558900000006041028190697");
        // sb.append("52060433009911002506550120000007800267301615");
        cDV = Integer.parseInt(sb.toString().substring(43, 44));

        sb.delete(43, 44);
        for (int i = 0; i < sb.toString().length(); i++){
            chave.add(Integer.parseInt(sb.substring(i,(i+1))));
        }
        sc.close();
    }
    
    public Integer cdv(){

        int i = 0;
        int soma = 0;
        
        Collections.reverse(chave);
        
        for (Integer chave : chave){
            soma = soma + (chave*peso.get(i));
            i++;
            if(i==8) i=0;    
        }

        if (cDV == null){
            cDV = (11-(soma%11));
        } else if(cDV == (11-(soma%11))){
            return cDV;
        }
        
        if(cDV <= 1){
            cDV = 0;
            return cDV;
        } else {
            return cDV;
        }
    }
}
