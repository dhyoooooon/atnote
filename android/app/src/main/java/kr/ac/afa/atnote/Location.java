package kr.ac.afa.atnote;


public class Location {
    public String place_address;
    public String place_name;
    public String place_lati;
    public String place_long;
    public String place_explain;
    public String place_number;

    public Location(){

        }
    public Location(String place_address, String place_explain, String place_lati, String place_long, String place_name,  String place_number){
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
    public String getPlace_lati(){
        return place_lati;
    }
    public String getPlace_long(){
        return place_long;
    }
    public String getPlace_name(){ return place_name;}
    public String getPlace_number(){return  place_number;}
    public String getPlace_explain(){return place_explain;}
}