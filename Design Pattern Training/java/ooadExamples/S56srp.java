class Restaurant {
    String name;
    String password;
    String telNo;
    String faxNo;
    String address;
}
abstract class RestaurantTaskActivator {
    String verificationCode;
    Restaurant restaurant;
    boolean tryToActivate(String restName, String verificationCode) {
        if (restName.equals(restaurant.getName()) &&
            this.verificationCode.equals(verificationCode)) {
            doSomethingToRestaurant();
            return true;
        }
        return false;
    }
    abstract void doSomethingToRestaurant();
}
class RestaurantActivator extends RestaurantTaskActivator {
    void doSomethingToRestaurant() {
        //add restaurant to the system;
    }
}
class FaxNoActivator extends RestaurantTaskActivator {
    String newFaxNo;
    void doSomethingToRestaurant() {
        restaurant.setFaxNo(newFaxNo);
    }
}
class RestaurantTaskActivators {
    RestaurantTaskActivator activators[];
    void activate(String restName, String verificationCode) {
        for (int i = 0; i < activators.length; i++) {
            if (activators[i].tryToActivate(restName, verificationCode)) {
                //remove activator[i] from activators;
                return;
            }
        }
    }
}
class Category {
    String catId;

}
class Holidays {
    List holidays;
    void addHoliday(int year, int month, int day) {
        ...
    }
    void removeHoliday(int year, int month, int day) {
        ...
    }
    List getAllHolidays() {
        return holidays;
    }
}
class BusinessSessions {
    List businessSessions;
    boolean addBusinessSession(int fromHour, int fromMin,
        int toHour, int toMin) {
        ...
    }
    boolean isInBusinessHour(Calendar time) {
        ...
    }
    List getAllBusinessSessions() {
        return businessSessions;
    }
}
class RestaurantSystem {
    Restaurant restaurants[];
    RestaurantTaskActivators restaurantTaskActivators;
    HashMap<Restaurant,Category[]> mapRestIdToCatagories;
    HashMap<Restaurant,Holidays> mapRestIdToHolidays;
    HashMap<Restaurant,BusinessSessions> mapRestIdToBusinessSessions;
}

