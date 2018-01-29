class Session {
    Date date;
    int startHour;
    int endHour;
    int getDuration() {
        return endHour-startHour;
    }
}
abstract class Course {
    String courseTitle;
    Course(String courseTitle) {
        ...
    }
    String getTitle() {
        return courseTitle;
    }
    abstract double getFee();
    abstract double getDuration();
}
class SimpleCourse extends Course {
    Session sessions[];
    double fee;
    SimpleCourse(String courseTitle, double fee, Session sessions[]) {
        ...
    }
    double getFee() {
        return fee;
    }
    double getDuration() {
        int duration=0;
        for (int i=0; i<sessions.length; i++) {
            duration += sessions[i].getDuration();
        }
        return duration;
    }
    void setFee(int fee) {
        this.fee = fee;
    }
}
class CompoundCourse extends Course { 
	Course modules[];
    CompoundCourse(String courseTitle, Course modules[]) {
        ...
    }
    double getFee() {
        double totalFee = 0;
        for (int i=0; i<modules.length; i++) {
            totalFee += modules[i].getFee();
        }
        return totalFee;
    }
    double getDuration() {
        int duration=0;
        for (int i=0; i<modules.length; i++) {
            duration += modules[i].getDuration();
        }
        return duration;
    }
}
