import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Group implements ITestable {
    HashSet<Hotel> hotels;
    private int groupId;

    public Group(int id) {
        hotels = new HashSet<Hotel>();
        groupId = id;
    }

    //getters

    public static boolean checkAllIntancesConstraints(Model model) {
        return true;
    }

    public void addHotelToGroup(Hotel hotel) {
        hotels.add(hotel);
    }

    public int getGroupId() {
        return groupId;
    }

    public HashSet<Hotel> getHotels() {
        return hotels;
    }

    private boolean constraint1() {
        for (Hotel h1 : hotels) {
            for (Hotel h2 : hotels) {
                if (h1 != h2) {
                    if (h1.getCity().equalsIgnoreCase(h2.getCity())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean sameServices(Set<Service> serviceSet1, Set<Service> serviceSet2) {
        return serviceSet1.containsAll(serviceSet2) && serviceSet2.containsAll(serviceSet1);
    }

    private boolean constraint4() {
        if (hotels.size() == 0) {
            return true;
        }
        Hotel h = (Hotel) hotels.toArray()[0];
        Set<Service> serviceSet = h.getServices().keySet();
        for (Hotel hotel : hotels) {
            if (!sameServices(serviceSet, hotel.getServices().keySet())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkConstraints() {
        return constraint1() && constraint4();
    }
}
