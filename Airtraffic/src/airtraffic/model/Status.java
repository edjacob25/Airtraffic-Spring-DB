package airtraffic.model;

/**
 * Created by jacob on 22/03/2016.
 */
public enum Status {
    ON_TIME,
    DELAYED,
    ON_COURSE,
    ARRIVED,
    ERROR;

    public static Status getStatus(String s){
        switch (s){
            case "on_time":
                return ON_TIME;

            case "delayed":
                return DELAYED;

            case "on_course":
                return ON_COURSE;

            case "arrived":
                return ARRIVED;

            default:
                return ERROR;
        }
    }
}
