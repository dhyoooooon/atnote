package kr.ac.afa.atnote;

public class Recycler_item {
    String image;
    String place_name;
    String place_address;
    String place_explain;
    String place_lati;
    String place_long;
    String place_number;


    String getImage() {
        return this.image;
    }

    String getPlace_name() {
        return this.place_name;
    }

    String getPlace_address() {
        return this.place_address;
    }
    String getPlace_explain() {
        return this.place_explain;
    }
    String getPlace_number(){
        return this.place_number;
    }

    Recycler_item(String image, String place_name, String place_address, String place_number, String place_explain)
    {
        this.image = image;
        this.place_name = place_name;
        this.place_address = place_address;
        this.place_number = place_number;
        this.place_explain = place_explain;
    }
}