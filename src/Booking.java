import java.util.ArrayList;
import java.util.Date;

public class Booking implements ITestable {
    private Date date;
    private Room room;
    private ArrayList<HotelService> services;
    private Reservation reservation;
    private Review review;


    public Booking(Date a_date, Room a_room) {
        date = a_date;
        room = a_room;
        services = new ArrayList<HotelService>();
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return true;
    }

    public void addService(HotelService s) {
        services.add(s);
    }

    public void addReview(Review a_review) {
        review = a_review;
    }

    public void addReservation(Reservation r) {
        reservation = r;
    }


    // getters

    public void assignRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public Room getRoom() {
        return room;
    }

    public ArrayList<HotelService> getServices() {
        return services;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Review getReview() {
        return review;
    }

    private boolean constraint3() {
        return room.getHotel() == reservation.getReservationSet().getHotel();
    }

    private boolean constraint13() {
        for (HotelService hotelService : services) {
            if (hotelService.getHotel() != reservation.getReservationSet().getHotel()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkConstraints() {
        return constraint3() && constraint13();
    }
}
