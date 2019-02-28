package main.java.util;

public class Creature {
    private String continent;
    private String country;
    private String species;
    private String type;
    private String habitat;
    private String alternatives;
    private String source;

    public Creature(String continent, String country, String species, String type, String habitat, String alternatives, String source) {
        this.continent = continent;
        this.country = country;
        this.species = species;
        this.type = type;
        this.habitat = habitat;
        this.alternatives = alternatives;
        this.source = source;
    }

    public String toString(){
        String out = "";
        if(continent.equals("'Sonstiges'")){
            out += continent + "\n";
            out += "Kategorie: " + country + "\n";
        }else{
            out += "Region: " + continent + "\n";
            out += "Teilregion: " + country + "\n";
        }
        out += "Spezies: " + species + "\n";
        out += "Gattung: " + type + "\n";
        out += "Lebensräume: " + habitat + "\n";
        out += "Auch bekannt als: " + alternatives + "\n";
        out += "Quelle: " + source + "\n";
        return out;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(String alternatives) {
        this.alternatives = alternatives;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
