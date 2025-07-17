package com.paulograbin.SimpleCRUD;

import java.util.List;


public class Tests {

    public static void main(String[] args) {
        HibernateUtil hu = new HibernateUtil();
        System.out.println("Iniciando...");
        System.out.println("Delete all...");

        List<Pessoas> pessoas = hu.selectAll();


        System.out.println("Encontrados " + hu.getCount() + " registros.");

        System.out.println(hu.selectAll());

        Pessoas p = new Pessoas();
        p.setNome("PAULO HENRIQUE GROLLI GRABIN");
        p.setIdade(23);
        p.setSexo('M');

        System.out.println("Pessoa " + p);

        hu.insert(p);
        System.out.println("Pessoa " + p);
        System.out.println("Encontrados " + hu.getCount() + " registros.");

        System.out.println(hu.selectAll());

        p.setNome("PAULO HENRIQUE GROLLI GRABINNNNNNNNNNNN");
        hu.updatePessoa(p);
        System.out.println(p);
        System.out.println(hu.selectAll());
        System.out.println();
        System.out.println("Deletando agora...");
        System.out.println(hu.getCount());
        hu.deletePessoa(p.getId());
        System.out.println(hu.getCount());
    }

}
