import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

public class Timetable {
    private String workStartTime;
    private String workEndTime;
    private SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
    private List<String> meetings;
    private List<Date[]> meetingHours;
    private Date start;
    private Date ending;

    Timetable() {


//        for (int i = 0; i < meetings.size(); i+=2) {
//           Date meetingStart = hourFormat.parse(meetings.get(i));
//           Date meetingEnd = hourFormat.parse(meetings.get(i + 1));
//           Date[] meetingSet = {meetingStart, meetingEnd};
//           this.meetingHours.add(meetingSet);
//
//        }
    }

    void ProcessTimetable() {
            int timeStep = 30;
            DateUtils.addMinutes(start, timeStep);



    }

    List<TimeSlot> getAllTimeSlots(String workStartTime, String workEndTime) throws ParseException {
        this.start = hourFormat.parse(workStartTime);
        this.ending = hourFormat.parse(workEndTime);
        System.out.println(hoursDifference(start, ending));

        int timeStep = 30;
        Date begg = start;
        Date end =  DateUtils.addMinutes(begg, timeStep);
        List<TimeSlot> list = new ArrayList<TimeSlot>();

        ///list.add(timeSlot);
        //System.out.println(timeSlot.getBeginning().toString() + "    -    " +timeSlot.getEnd().toString());
        for (float i = 0; i < -1*hoursDifference(start, ending)*2; i++) {
            TimeSlot timeSlot = new TimeSlot(true, begg, end);
            //timeSlot = new TimeSlot(true, begg, end);
            begg = end;
            end = DateUtils.addMinutes(begg, timeStep);
          //  System.out.println(timeSlot.getBeginning().toString() + "    -    " +timeSlot.getEnd().toString());
            list.add(timeSlot);
        }

        return list;
    }

    private static float hoursDifference(Date date1, Date date2) {

        final int MILLI_TO_HOUR = 1000 * 60 * 60;
        return (float) (date1.getTime() - date2.getTime()) / MILLI_TO_HOUR;
    }
}
