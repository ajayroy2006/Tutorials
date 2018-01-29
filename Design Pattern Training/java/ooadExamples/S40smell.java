interface Schedule {
    int getDurationInDays();
    void print();
}
class WeeklySchedule implements Schedule {
    int noWeeks;
    Date fromDate;
    Date toDate;
    int getDurationInDays() {
        return noWeeks;
    }
    void print() {
        ...
    }
}
class RangeSchedule implements Schedule {
    Date fromDate;
    Date toDate;
    int getDurationInDays() {
        int milliSecondsInOneDay = 24*60*60*1000;
        return (int)((toDate.getTime()-fromDate.getTime()) /
                    milliSecondsInOneDay);
    }
    void print() {
        ...
    }
}
class ListSchedule implements Schedule {
    Date dateList[];
    int getDurationInDays() {
        return dateList.length;
    }
    void print() {
    ...
    }
}
class Course {
    String courseTitle;
    Schedule schedule;
	//...
    int getDurationInDays() {
        return schedule.getDurationInDays();
    }
    void printSchedule() {
        schedule.print();
    }
}
