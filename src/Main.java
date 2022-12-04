import java.util.Date;

public class Main {

    public static void test1() {
        Model m1 = new Model();
        Group g = new Group(1);
        Hotel h1 = new Hotel("Haifa", "Dan Panorama", 4);
        Hotel h2 = new Hotel("Haifa", "Dan Carmel", 4);
        m1.addObjectToModel(g);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(h2);
        m1.create_link_group_hotel(h1, g);
        m1.create_link_group_hotel(h2, g);
        System.out.println(m1.checkModelConstraints());
    }

    public static void test3() {
        Model m = new Model();
        Client client = new Client(1, 30, "Dolev", "Tel Aviv");
        Hotel hotel = new Hotel("Las", "Paris", 5);
        Hotel hotel2 = new Hotel("Lass", "Paris", 5);
        Room room = new Room(35);
        ReservationSet reservationSet = new ReservationSet();
        Date date1 = Model.getDateFromString("25-11-2019");
        Date date2 = Model.getDateFromString("10=10=2022");
        Booking booking = new Booking(date1, room);
        Reservation reservation = new Reservation(date1, date2, 100);
        RoomCategory roomCategory = new RoomCategory(200, RoomCategory.RoomType.BASIC);
        m.addObjectToModel(client);
        m.addObjectToModel(hotel);
        m.addObjectToModel(hotel2);
        m.addObjectToModel(room);
        m.addObjectToModel(booking);
        m.addObjectToModel(reservationSet);
        m.addObjectToModel(reservation);
        m.addObjectToModel(roomCategory);
        m.create_link_client_hotel_reservationSet(client, hotel, reservationSet);
        m.create_link_reservationSet_reservation(reservationSet, reservation);
        m.create_link_reservation_roomCategory(reservation, roomCategory);
        m.create_link_hotel_room(room, hotel);
        m.create_link_room_roomCategory(room, roomCategory);
        m.create_link_room_Booking(room, booking);
        m.create_link_reservation_booking(booking, reservation);
        System.out.println(m.checkModelConstraints());


    }

    public static void test7() {
        Model m = new Model();
        Client client = new Client(1, 22, "Dolev", "Tel Aviv");
        Hotel hotel = new Hotel("Las Vegas", "Paris", 5);
        Room room = new Room(55);
        ReservationSet reservationSet = new ReservationSet();
        Date date1 = Model.getDateFromString("25-11-2019");
        Date date2 = Model.getDateFromString("10=10=2022");
        Reservation reservation = new Reservation(date1, date2, 100);
        RoomCategory roomCategory = new RoomCategory(200, RoomCategory.RoomType.BASIC);
        m.addObjectToModel(client);
        m.addObjectToModel(hotel);
        m.addObjectToModel(room);
        m.addObjectToModel(reservationSet);
        m.addObjectToModel(reservation);
        m.addObjectToModel(roomCategory);
        m.create_link_client_hotel_reservationSet(client, hotel, reservationSet);
        m.create_link_reservationSet_reservation(reservationSet, reservation);
        m.create_link_reservation_roomCategory(reservation, roomCategory);
        m.create_link_hotel_room(room, hotel);
        m.create_link_room_roomCategory(room, roomCategory);
        System.out.println(m.checkModelConstraints());

    }

    public static void test11() {
        Model m = new Model();
        Hotel hotel = new Hotel("fed", "df", 3);
        Group group = new Group(5);
        RegularService regularService = new RegularService("ddd");
        RegularService regularService2 = new RegularService("dFd");
        HotelService hotelService = new HotelService(1, 1);
        HotelService hotelService2 = new HotelService(2, 2);
        m.addObjectToModel(hotel);
        m.addObjectToModel(group);
        m.create_link_group_hotel(hotel, group);
        m.addObjectToModel(regularService);
        m.addObjectToModel(regularService2);
        m.create_link_hotel_service_hotelService(hotel, regularService, hotelService);
        m.create_link_hotel_service_hotelService(hotel, regularService2, hotelService2);
        System.out.println(m.checkModelConstraints());
    }

    public static void test12(){
        Model m = new Model();
        Client client = new Client(1, 30, "Dolev", "Tel Aviv");
        Hotel hotel = new Hotel("Las", "Paris", 5);
        Hotel hotel2 = new Hotel("Lass", "Paris", 5);
        Room room = new Room(35);
        ReservationSet reservationSet = new ReservationSet();
        Date date1 = Model.getDateFromString("25-11-2019");
        Date date2 = Model.getDateFromString("10-10-2020");

        Booking booking = new Booking(date1, room);
        Booking booking1 = new Booking(date2,room);
        Reservation reservation = new Reservation(date1, date2, 100);
        RoomCategory roomCategory = new RoomCategory(200, RoomCategory.RoomType.BASIC);

        RegularService regularService = new RegularService("ddd");
        RegularService regularService2 = new RegularService("dFd");
        HotelService hotelService = new HotelService(1, 1);
        HotelService hotelService2 = new HotelService(2, 2);


        m.addObjectToModel(client);
        m.addObjectToModel(hotel);
        m.addObjectToModel(hotel2);
        m.addObjectToModel(room);
        m.addObjectToModel(booking);
        m.addObjectToModel(booking1);
        m.addObjectToModel(reservationSet);
        m.addObjectToModel(reservation);
        m.addObjectToModel(roomCategory);
        m.create_link_client_hotel_reservationSet(client, hotel, reservationSet);
        m.create_link_reservationSet_reservation(reservationSet, reservation);
        m.create_link_reservation_roomCategory(reservation, roomCategory);
        m.create_link_hotel_room(room, hotel);
        m.create_link_room_roomCategory(room, roomCategory);
        m.create_link_room_Booking(room, booking);
        m.create_link_reservation_booking(booking, reservation);

        m.create_link_room_Booking(room,booking1);

        m.addObjectToModel(regularService);
        m.addObjectToModel(regularService2);
        m.create_link_hotel_service_hotelService(hotel, regularService, hotelService);
        m.create_link_hotel_service_hotelService(hotel, regularService2, hotelService2);

        m.create_link_hotelService_booking(hotelService,booking);
        System.out.println(m.checkModelConstraints());


    }


    public static void main(String[] args) {
//        test1();
//        test3();
        test11();
        test11();

    }
}
