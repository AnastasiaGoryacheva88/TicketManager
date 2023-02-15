package ru.netology.javaqa;


public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String depAirport;
    private String arrAirport;
    private int travelTime; //


    public Ticket(int id, int price, String depAirport, String arrAirport, int travelTime) {
        this.id = id;
        this.price = price;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }


    public int getPrice() {
        return price;
    }


    public String getDepAirport() {
        return depAirport;
    }


    public String getArrAirport() {
        return arrAirport;
    }


    @Override
    public int compareTo(Ticket o) {
        if (getPrice() < o.getPrice()) {
            return -1;
        }
        if (getPrice() > o.getPrice()) {
            return 1;
        }
        return 0;
    }
}
