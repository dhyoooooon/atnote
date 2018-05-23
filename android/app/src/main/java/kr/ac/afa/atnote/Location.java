package kr.ac.afa.atnote;


public class Location {
    public String place_address;
    public String place_name;
    public double place_lati;
    public double place_long;
    public String place_explain;
    public String place_number;

    public Location(){

        }
    public Location(String place_address, String place_explain, double place_lati, double place_long, String place_name,  String place_number){
        this.place_address = place_address;
        this.place_name = place_name;
        this.place_lati = place_lati;
        this.place_long = place_long;
        this.place_explain = place_explain;
        this.place_number = place_number;
    }
    public String getPlace_address(){
        return place_address;
    }
}