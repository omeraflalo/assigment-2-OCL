import java.util.ArrayList;

public class ReservationSet implements  ITestable{
    private Client client;
    private Hotel hotel;
    private ArrayList<Reservation> reservations;

    public ReservationSet(){
        reservations = new ArrayList<Reservation>();
    }

    public void setClient(Client client){
        this.client = client;
    }

    public void setHotel(Hotel hotel){
        this.hotel = hotel;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }


    public Client getClient() {
        return client;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public  boolean constraint7(){
        if(hotel.getCity().equalsIgnoreCase("LAS VEGAS")){
            if(client.getAge() < 21){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkConstraints() {
        return constraint7();
    }

    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }
}
