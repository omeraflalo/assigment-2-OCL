public class Main {

    public static void test1(){
        Model m1 = new Model();
        Group g = new Group(1);
        Hotel h1 = new Hotel("Haifa","Dan Panorama",4);
        Hotel h2 = new Hotel("Haifa","Dan Carmel",4);
        m1.addObjectToModel(g);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(h2);
        m1.create_link_group_hotel(h1,g);
        m1.create_link_group_hotel(h2,g);
        System.out.println(m1.checkModelConstraints());
    }

    public static void test7() {
        Model m1 = new Model();
        Client client = new Client(1,20,"Dolev","Tel Aviv");
        Hotel hotel = new Hotel("Las Vegas","Paris", 5);

    }


        public static void main(String[] args) {
//        test1();

    }
}
