package ie.tudublin;

import processing.data.TableRow;

public class Nematode {
    private String name;
    private int length;
    private int limbs;
    private String gender;
    private int eyes;
    
    public Nematode(String name, int length, int limbs, String gender, int eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public Nematode(TableRow row)
    {
        this(row.getString("name"), row.getInt("length"), row.getInt("limbs"), row.getString("gender"), row.getInt("eyes"));
    }

}
