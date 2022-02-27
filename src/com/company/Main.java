package com.company;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Fuvar> fuvarLista;
    public static void main(String[] args) {
        beolvasas("fuvar.csv");
        feladat1();
    }

    private static void beolvasas(String file) {
        fuvarLista = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String sor = br.readLine();
            while (sor != null) {
                fuvarLista.add(new Fuvar(sor));
                sor = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void feladat1() {
        System.out.println("1. feladat: " + fuvarLista.stream().count() + "db utazás került feljegyzésre");
    }

}