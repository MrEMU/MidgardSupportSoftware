package main.java.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CreatureRessources {

    private static ArrayList<Creature> lamaran = new ArrayList<>();
    private static ArrayList<Creature> nahuatlan = new ArrayList<>();
    private static ArrayList<Creature> sirao = new ArrayList<>();
    private static ArrayList<Creature> vesternesse = new ArrayList<>();
    private static ArrayList<Creature> inseln = new ArrayList<>();
    private static ArrayList<Creature> meere = new ArrayList<>();
    private static ArrayList<Creature> sonstige = new ArrayList<>();

    static String path = "src/main/resources/";

    public static void init() {
        readIn(lamaran, new File(path + "beasts.csv"), "Lamaran");
        readIn(nahuatlan, new File(path + "beasts.csv"), "Nahuatlan");
        readIn(sirao, new File(path + "beasts.csv"), "Sirao");
        readIn(vesternesse, new File(path + "beasts.csv"), "Vesternesse");
        readIn(inseln, new File(path + "beasts.csv"), "Inseln");
        readIn(meere, new File(path + "beasts.csv"), "Meere");
        readIn(sonstige, new File(path + "beasts.csv"), "Sonstige");
    }

    static void readIn(ArrayList<Creature> list, File file, String region) {
        String[] temp;
        Creature creature;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(file) , "UTF-8"));
            temp = reader.readLine().split(";");
            if(temp[0].equals(region)) {
                creature = new Creature(region, temp[1].replaceAll("\'",""),
                        temp[2].replaceAll("\'",""),
                        temp[3].replaceAll("\'",""),
                        temp[4].replaceAll("\'","").split(","),
                        temp[5].replaceAll("\'",""),
                        temp[6].replaceAll("\'",""));
                list.add(creature);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Creature> getLamaran() {
        return lamaran;
    }

    public static ArrayList<Creature> getNahuatlan() {
        return nahuatlan;
    }

    public static ArrayList<Creature> getSirao() {
        return sirao;
    }

    public static ArrayList<Creature> getVesternesse() {
        return vesternesse;
    }

    public static ArrayList<Creature> getInseln() {
        return inseln;
    }

    public static ArrayList<Creature> getMeere() {
        return meere;
    }

    public static ArrayList<Creature> getSonstige() {
        return sonstige;
    }
}
