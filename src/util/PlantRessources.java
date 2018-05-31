package util;

import java.io.*;
import java.util.ArrayList;

public class PlantRessources {

    private static ArrayList<String> garden = new ArrayList<>();
    private static ArrayList<String> meadow = new ArrayList<>();
    private static ArrayList<String> forest = new ArrayList<>();
    private static ArrayList<String> glade = new ArrayList<>();
    private static ArrayList<String> waters = new ArrayList<>();
    private static ArrayList<String> mountains = new ArrayList<>();
    private static ArrayList<String> special = new ArrayList<>();

    static String path = "ressource/";

    public static void init() {
        readIn(garden, new File(path + "garden.txt"));
        readIn(meadow, new File(path + "meadow.txt"));
        readIn(forest, new File(path + "forest.txt"));
        readIn(glade, new File(path + "glade.txt"));
        readIn(waters, new File(path + "waters.txt"));
        readIn(mountains, new File(path + "mountains.txt"));
        readIn(special, new File(path + "special.txt"));
    }

    static void readIn(ArrayList<String> list, File file) {
        String[] temp;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(file) , "UTF-8"));
            temp = reader.readLine().split(";");
            for(String element: temp){
                list.add(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getGarden() {
        return garden;
    }

    public static ArrayList<String> getMeadow() {
        return meadow;
    }

    public static ArrayList<String> getForest() {
        return forest;
    }

    public static ArrayList<String> getGlade() {
        return glade;
    }

    public static ArrayList<String> getWaters() {
        return waters;
    }

    public static ArrayList<String> getMountains() {
        return mountains;
    }

    public static ArrayList<String> getSpecial() {
        return special;
    }
}
