import java.util.*;

public class Hotel implements ITestable {
    private String name;
    private HashMap<Client, ReservationSet> allReservation;
    private HashMap<Service, HotelService> services;
    private HashMap<Integer, Room> rooms;
    private String city;
    private Group group;
    private int rate;


    public Hotel(String city, String name, int rate) {
        this.city = city;
        this.name = name;
        this.rate = rate;
        rooms = new HashMap<Integer, Room>();
        allReservation = new HashMap<Client, ReservationSet>();
        services = new HashMap<Service, HotelService>();

    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return true;
    }

    public void addReservationSet(Client client, ReservationSet reservationSet) {
        allReservation.put(client, reservationSet);
    }

    public void addService(Service service, HotelService hotelService) {
        services.put(service, hotelService);
    }

    public void addRoom(int roomNumber, Room room) {
        rooms.put(roomNumber, room);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public HashMap<Client, ReservationSet> getAllReservation() {
        return allReservation;
    }

    public HashMap<Service, HotelService> getServices() {
        return services;
    }

    public int getRate() {
        return rate;
    }

    private boolean constraint5() {
        for (HotelService hotelService : services.values()) {
            for (Booking booking : hotelService.getGivenServices()) {
                if (booking.getRoom().getRoomCategory().getType() == RoomCategory.RoomType.VIP && !(hotelService.getService() instanceof VipService)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean constraint6() {
        if(rooms.size()==0) return true;
        int vipCount = 0;
        for (Room room : rooms.values()) {
            if (room.getRoomCategory().getType() == RoomCategory.RoomType.VIP) {
                vipCount++;
            }
        }
        return (float) vipCount / rooms.size() <= 0.1;
    }

    private boolean constraint10() {
        int sum = 0, amount = 0;
        if (rate == 5) {
            for (ReservationSet reservationSet : allReservation.values()) {
                for (Reservation reservation : reservationSet.getReservations()) {
                    if (reservation.getBookings() != null && reservation.getBookings().getReview() != null) {
                        amount++;
                        sum += reservation.getBookings().getReview().getRank();
                    }
                }
            }
            if ((float) sum / amount <= 7.5) {
                return false;
            }
        }
        return true;
    }

    private boolean constraint11() {
        for (Service service1 : services.keySet()) {
            for (Service service2 : services.keySet()) {
                if (service1 != service2 && service1.getServiceName().equalsIgnoreCase(service2.getServiceName())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean constraint12() {
        HashMap<Integer, Integer> income = new HashMap<>();
        for (ReservationSet reservationSet : allReservation.values()) {
            for (Reservation reservation : reservationSet.getReservations()) {
                if (reservation.getBookings() != null) {
                    for (HotelService hotelService : reservation.getBookings().getServices()) {
                        int price = hotelService.getPrice() * hotelService.getQuality();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(reservation.getBookings().getDate());
                        Integer year = calendar.get(Calendar.YEAR);
                        income.put(year, income.getOrDefault(year, 0) + price);
                    }
                }
            }
        }
        List<Integer> sortedKeys = new ArrayList<Integer>(income.keySet());
        Collections.sort(sortedKeys);
        for (int i = 0; i < sortedKeys.size() - 1; i++) {
            if (income.get(sortedKeys.get(i)) != 0 && sortedKeys.get(i) + 1 != sortedKeys.get(i + 1)) {
                return false;
            }
            if (income.getOrDefault(sortedKeys.get(i), 0) >= income.getOrDefault(sortedKeys.get(i + 1), 0)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkConstraints() {
        return constraint5() && constraint6() && constraint10() && constraint11() && constraint12();
    }
}
