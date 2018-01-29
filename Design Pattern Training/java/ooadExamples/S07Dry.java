class Restaurant extends Account {
    private class TimeRange {
        private final int fromHour, toHour, fromMinutes, toMinutes;
        public TimeRange(int fromHour, int toHour,
            int fromMinutes, int toMinutes) {
            ...
        }
    }
    final static String RestaurantIDText = "Rest";
    String website;
    String chineseAddress;
    String englishAddress;
    String newFaxNumberToBeConfirmed;
    boolean has_NewFax = false;
    ArrayList<Calendar> listOfHolidays;
    String catId;
    ArrayList<TimeRange> BusinessHours;
    ...
    private static final int BASE_YEAR=1900,
        HOURS_IN_A_DAY=24, MINUTES_IN_AN_HOUR=60;
    void addHoliday(int year,int month,int day){
        if(year<BASE_YEAR) year+=BASE_YEAR;
        Calendar aHoliday = new GregorianCalendar(year,month,day,0,0,0);
        listOfHolidays.add(aHoliday);
    }
    private int getMinutesFromMidnight(int hours, int minutes) {
        return hours * MINUTES_IN_AN_HOUR + minutes;
    }
    private boolean isMinutesWithinOneDay(int minutes) {
        return (minutes >= 0) &&
            (minutes <= HOURS_IN_A_DAY * MINUTES_IN_AN_HOUR );
    }
    public boolean addBsHour(int fromHour, int fromMinute,
            int toHour, int toMinute){
        int fromInMinutes = getMinutesFromMidnight(fromHour, fromMinute);
        int toInMinutes = getMinutesFromMidnight(toHour,toMinute);
        boolean timesValid = isMinutesWithinOneDay(fromInMinutes) &&
                            isMinutesWithinOneDay(toInMinutes) &&
                            fromInMinutes < toInMinutes;
        if (timesValid)
            BusinessHours.add(new TimeRange(fromHour,fromMinute,toHour,toMinute));
        return timesValid;
    }
}
