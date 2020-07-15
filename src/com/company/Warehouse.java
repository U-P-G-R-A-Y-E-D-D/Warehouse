package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse {
    float celkCena = 0;
    Scanner sc = new Scanner(System.in,"UTF-8");
    private final ArrayList<Object> container;
    private Object objects;

    public Warehouse() {
        container = new ArrayList<>();
    }

    public void addBarrel() {
        System.out.println("Vložení nového sudu");
        System.out.println("-------------------");
        try {
            System.out.println("Zadej výšku: ");
            float height = sc.nextFloat();
            System.out.println("Zadej průměr: ");
            float diameter = sc.nextFloat();
            Barrel b = new Barrel(height, diameter);
            sc.nextLine();
            System.out.println("Zadej označení látky:");
            b.setLiquid(sc.nextLine());
            System.out.println("Zadej hustotu latky: ");
            float density = sc.nextFloat();
            System.out.println("Zadej cenu za litr: ");
            float costPerLitre = sc.nextFloat();
            System.out.println("Zadej pocet litru: ");
            float litres = sc.nextFloat();
            System.out.println(b.toString());
            container.add(b);
            //celkCena += costPerLitre*litres;
        } catch (Exception e) {
            System.out.println("Chybné zadání parametrů sudů.");
        }
    }

    public void addBarrel(String[] arr) {

        try {
            if(arr.length != 7) throw new Exception();

            float height = Float.parseFloat(arr[1]);
            float diameter = Float.parseFloat(arr[2]);
            float density;
            int costPerLitre;
            int litres;
            Barrel b = new Barrel(height, diameter);

            b.setLiquid(arr[3]);

            b.setDensity(Float.parseFloat(arr[4]));
            b.setCostPerLitre(Integer.parseInt(arr[5]));
            b.setLitres(Integer.parseInt(arr[6]));

            container.add(b);
            //double vaha = b.getWeightOfLiquid();
        } catch (Exception e) {
            System.out.println("Chybné při parsování souboru.");
        }
    }

    public void list(){
        int i=0;
        for(Object o: container){
            //for(i = 0; i<container.size();i++){
            System.out.print(i);
            System.out.print(") ");


            // }
            System.out.println(o.toString());
            i++;
        }
        // System.out.print("Celkov� cena je "+ celkCena);
    }

    public void addBox() {
        System.out.println("Vložení nového boxu");
        System.out.println("-------------------");
        try {
            System.out.println("Zadej výšku v metrech: ");
            float height = sc.nextFloat();
            System.out.println("Zadej hloubku v metrech: ");
            float depth = sc.nextFloat();
            System.out.println("Zadej šířku v metrech: ");
            float width = sc.nextFloat();
            Box bo = new Box(height, width, depth);
            sc.nextLine();
            System.out.println("Zadej obsah: ");
            bo.setDescription(sc.nextLine());
            System.out.println("Zadej počet kusu: ");
            bo.setMaxQuantity(sc.nextInt());
            System.out.println("Zadej vahu 1ks v kilogramech: ");
            bo.setWeightKg(sc.nextInt());
            System.out.println("Zadej cenu 1ks v kč: ");
            bo.setPrice(sc.nextInt());
            System.out.println("Vytvořený box: " + bo.toString());
            container.add(bo);
            //celkCena += maxQuantity*price;
        } catch (Exception e) {
            System.out.println("Chybné zadání parametrů boxu.");
        }
    }

    public void addBox(String[] arr) {

        try {
            if(arr.length != 9) throw new Exception();

            float height = Float.parseFloat(arr[1]);
            float width = Float.parseFloat(arr[2]);
            float depth = Float.parseFloat(arr[3]);
            int quantity;
            int maxQuantity;
            int weightKg;
            double price;

            Box b = new Box(height, depth, width);

            b.setDescription(arr[4]);

            b.setQuantity(Integer.parseInt(arr[5]));
            b.setMaxQuantity(Integer.parseInt(arr[6]));
            b.setWeightKg(Integer.parseInt(arr[7]));
            b.setPrice(Double.parseDouble(arr[8]));

            container.add(b);
        } catch (Exception e) {
            System.out.println("Chybné při parsování souboru.");
        }

    }

    public void delete(int index){
        try{
            container.remove(index);
        }catch (Exception e){
            System.out.println("Objekt ve skladu neexistuje!");
        }
    }

    public void getObject(int o){
        try{
            if(container.get(o) instanceof Barrel){
                System.out.println("Barrel");
            }else{
                System.out.println("Crate");
            }
        }catch(Exception e){
            System.out.println("Nelze ziskat objekt");
        }
    }

    public String readCSVBarrel(String file) {
        try {
            String output = "";
            String csv = "";
            Scanner sc = new Scanner(new File(file),"UTF-8");
            sc.useDelimiter("\n");
            while(sc.hasNext()) {
                csv = sc.next();
                output += csv;
                String [] arr = csv.split(";");
                this.addBarrel(arr);
            }
            sc.close();
            return output;

        } catch (FileNotFoundException ex){
            //Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE);
            return "";
        }
    }

    public String readCSVBox(String file) {
        try {
            String output = "";
            String csv = "";
            Scanner sc = new Scanner(new File(file),"UTF-8");
            sc.useDelimiter("\n");
            while(sc.hasNext()) {
                csv = sc.next();
                output += csv;
                String [] arr = csv.split(";");
                this.addBox(arr);
            }
            sc.close();
            return output;

        } catch (FileNotFoundException ex){
            //Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE);
            return "";
        }
    }
    /**
     * @param args the command line arguments
     */



    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        //w.readCSV("files/sklad.csv");
        System.out.println();
        while (true) {
            System.out.println("\nVytvoření boxu = 1 ");
            System.out.println("Vytvoření barelu = 2 ");
            System.out.println("Načtení z csv: barrel = 3");
            System.out.println("Načtení z csv: box = 4");
            System.out.println("Vymazání = 5");
            System.out.println("Vypsání = 6");
            System.out.println("Konec = 7");
            System.out.print("Zadej volbu: ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            try {
                switch (option) {
                    case 1:
                        System.out.println("Vytvoření boxu");
                        w.addBox();
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Vytvoření barelu");
                        w.addBarrel();
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Nacteni z csv\nSoubor musí být v adresáři files a musí se jmenovat skladbarrel.csv");
                        w.readCSVBarrel("files/skladbarrel.csv");
                        w.list();
                        break;
                    case 4:
                        System.out.println("Nacteni z csv\nSoubor musí být v adresáři files a musí se jmenovat skladbox.csv");
                        w.readCSVBox("files/skladbox.csv");
                        w.list();
                        break;
                    case 5:
                        System.out.println("Nacteni z csv\nSoubor musí být v adresáři files a musí se jmenovat sklad.csv");
                        w.list();
                        System.out.println("***********************************************");
                        System.out.println("Zadej, index položky, kterou chceš odstranit: ");
                        int index = sc.nextInt();
                        w.delete(index);
                        System.out.println("***********************************************");
                        w.list();
                        break;
                    case 6:
                        w.list();
                        break;
                    case 7:
                        System.out.println("Konec");
                        return;
                }

            } catch (Exception e) {
                System.out.println("Chybná volba!");
            }
        }
    }
}
