//Improve the code
class SurveyData {
    String path; //save the data to this file.
    boolean hidden; //should the file be hidden?
    //set the path to save the data according to the type of data (t).
    void setSavePath(int t) {
        if (t==0) { //raw data.
            path = "c:/application/data/raw.dat";
            hidden = true;
        } else if (t==1) { //cleaned up data.
            path = "c:/application/data/cleanedUp.dat";
            hidden = true;
        } else if (t==2) { //processed data.
            path = "c:/application/data/processed.dat";
            hidden = true;
        } else if (t==3) { //data ready for publication.
            path = "c:/application/data/publication.dat";
            hidden = false;
        }
    }
}