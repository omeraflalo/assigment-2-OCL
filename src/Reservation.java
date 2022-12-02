import java.util.Date;
import java.util.ArrayList;

public class Reservation implements  ITestable {
    private int id;
    private RoomCategory roomCategory;
    private Date orderDate;
    private Date requestDate;
    private Booking booking;
    private ReservationSet reservationSet;


    public Reservation(Date ordDate, Date reqDate, int id) {
        this.id = id;
        orderDate = ordDate;
        requestDate = reqDate;
    }

    public void setReservationSet(ReservationSet reservationSet){
        this.reservationSet = reservationSet;
    }


    public void addRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }

    public void addBooking(Booking _booking) {
        booking = _booking;
    }


    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Booking getBookings() {
        return booking;
    }

    public int getId() {
        return id;
    }

    public ReservationSet getReservationSet(){return reservationSet;}

    private boolean constraint8(){
        RoomCategory.RoomType room = booking.getRoom().getRoomCategory().getType();
        if(roomCategory.getType()== RoomCategory.RoomType.VIP){
            if(room == RoomCategory.RoomType.BASIC || room == RoomCategory.RoomType.SUITE){
                return false;
            }
        }
        if(roomCategory.getType()== RoomCategory.RoomType.SUITE){
            if(room == RoomCategory.RoomType.BASIC){
                return false;
            }
        }
        return true;

    }
    @Override
    public boolean checkConstraints() {
        return constraint8();
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return true;
    }


}
    