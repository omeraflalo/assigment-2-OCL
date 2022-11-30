import java.util.HashMap;


public class Client implements  ITestable {
    private HashMap<Hotel,ReservationSet> reservationsHistory;
    private int id;
    private int age;
    private String name;
    private String city;

    public HashMap<Hotel, ReservationSet> getReservationsHistory() {
        return reservationsHistory;
    }

    public Client(int a_id, int a_age, String a_name, String a_city){
        reservationsHistory = new HashMap<Hotel,ReservationSet>();
        id = a_id;
        age = a_age;
        city = a_city;
        name = a_name;
    }

    public void addReservationSet(Hotel hotel, ReservationSet reset){
        reservationsHistory.put(hotel,reset);
    }

    // getters

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    private boolean checkReservationSet(ReservationSet reservationSet){
        if(reservationSet.getReservations().size()>=5){
            for(Reservation reservation : reservationSet.getReservations()) {
                if(reservation.getRoomCategory().getType() == RoomCategory.RoomType.VIP){
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private boolean constraint2() {
        for(ReservationSet reservationSet: reservationsHistory.values()){
            if(!checkReservationSet(reservationSet)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkConstraints() {
        return constraint2();
    }

    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }
}
