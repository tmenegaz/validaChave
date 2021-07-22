package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Entrada {
    
    private List<Integer> chave;
    private List<Integer> peso;
    private Integer cDV;
    private String comp;
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
        // String uf = "43";
        
        System.out.print("Digite o aamm: ");
        String aamm = sc.nextLine();
        // String aamm = "2107";
        
        System.out.print("Digite o cnpj_cpf: ");
        String cnpj_cpf = sc.nextLine();
        // String cnpj_cpf = "88709621000190";
        
        System.out.print("Digite o mod: ");
        String mod = sc.nextLine();
        // String mod = "55";
        
        System.out.print("Digite o serie com 3 dígitos (manter zeros a esquerda): ");
        String serie = sc.nextLine();
        // String serie = "002";
        
        System.out.print("Digite o nnf  com 9 dígitos (manter zeros a esquerda): ");
        String nnf = sc.nextLine();
        // String nnf = "000258959";
        
        System.out.print("Digite o tpemis: ");
        String tpemis = sc.nextLine();
        // String tpemis = "1";
        
        System.out.print("Digite o cnf: ");
        String cnf = sc.nextLine();
        // String cnf = "71802232";
        
        sb.append(uf+aamm+cnpj_cpf+mod+serie+nnf+tpemis+cnf);
        for (int i = 0; i < sb.toString().length(); i++){
            chave.add(Integer.parseInt(sb.substring(i,(i+1))));
        }

        comp = sb.toString();
        System.out.println("Composição -->> "+comp);
        
        sc.close();
    }
    
    public void criaChave(){
        util();
        System.out.print("Digite a chave com 43 caracteres numéricos - (chave sem o dígito):\t");
        sb.append(sc.nextLine());
        // sb.append("4321078870962100019055002000258959171802232");
        // sb.append("41180678393592000146558900000006041028190697");
        // sb.append("52060433009911002506550120000007800267301615");
        String uf = sb.toString().substring(0, 2);
        String aamm = sb.toString().substring(2, 6);
        String cnpj_cpf = sb.toString().substring(6, 20);
        String mod = sb.toString().substring(20, 22);
        String serie = sb.toString().substring(22, 25);
        String nnf = sb.toString().substring(25, 34);
        String tpemis = sb.toString().substring(34, 35);
        String cnf = sb.toString().substring(35, 43);
        
        for (int i = 0; i < sb.toString().length(); i++){
            chave.add(Integer.parseInt(sb.substring(i,(i+1))));
        }

        cdv();
        System.out.println(
            "\n<cUF>"+uf+"</cUF>"+
            "\n<cNF>"+cnf+"</cNF>"+
            "\n<mod>"+mod+"</mod>"+
            "\n<serie>"+serie+"</serie>"+
            "\n<nNF>"+nnf+"</nNF>"+
            "\n<dEmi>"+aamm.toString().substring(0, 2)+"-"+aamm.toString().substring(2, 4)+"</dEmi>"+
            "\n<tpEmis>"+tpemis+"</tpEmis>"+
            "\n<cDV>"+cDV+"</cDV>"+
            "\n<CNPJ>"+cnpj_cpf+"</CNPJ>");
        
        comp = sb.toString();
        System.out.println("Composição -->> "+comp);
        System.out.println("Chave com cDV:\t"+comp+cDV);
        sc.close();
    }
    
    public void cdv(){

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
            cDV = cDV;
        }
        
        if(cDV <= 1){
            cDV = 0;
        } else {
            cDV = cDV;
        }
    }
}
