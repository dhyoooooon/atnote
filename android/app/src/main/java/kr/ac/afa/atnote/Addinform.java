package kr.ac.afa.atnote;

public class Addinform {
    String place_name;
    String place_address;
    String place_number;
    String place_explain;
    String place_lati;
    String place_long;

    public Addinform(){

    }
    public Addinform(String place_name, String place_address, String place_number, String place_explain, String place_lati, String place_long){
        this.place_name = place_name;
        this.place_address = place_address;
        this.place_number = place_number;
        this.place_explain = place_explain;
        this.place_lati = place_lati;
        this.place_long = place_long;
    }
}
