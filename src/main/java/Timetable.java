import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

public class Timetable {
    private String workStartTime;
    private String workEndTime;
    private SimpleDateFormat hourFormat;
    private List<String> meetings;
    private List<List<Date>> meetingHours = new ArrayList<List<Date>>();
    private Date start;
    private Date ending;

    Timetable(String workStartTime1, String workEndTime2, List<String> meetings2) throws ParseException {
        hourFormat = new SimpleDateFormat("HH:mm");
        this.workStartTime = workStartTime1;
        this.workEndTime = workEndTime2;

        this.start = hourFormat.parse(workStartTime);
        this.ending = hourFormat.parse(workEndTime);

        this.meetings = meetings2;

        //List of lists containing meeting's beginings and endings
        for (int i = 0; i < meetings.size(); i+=2) {
           Date meetingStart = hourFormat.parse(meetings.get(i));
           Date meetingEnd = hourFormat.parse(meetings.get(i + 1));
           List<Date> pom = new ArrayList<Date>();
           pom.add(meetingStart);
           pom.add(meetingEnd);
           this.meetingHours.add(pom);

        }
    }

    //Creating time slots for all meetings
    List<TimeSlot> getMeetingsTimeslots() {
        int timeStep = 30;
        List<TimeSlot> list = new ArrayList<TimeSlot>();
        for (int i = 0; i < meetingHours.size(); i++) {
            List<Date> pom = new ArrayList<Date>();
            pom = meetingHours.get(i);
            Date begg = pom.get(0);
            Date end =  DateUtils.addMinutes(begg, timeStep);
            for (int j = 0; j < -1 * hoursDifference(pom.get(0), pom.get(1))* 2 ; j++) {
                TimeSlot timeSlot = new TimeSlot(true, begg, end);
                begg = end;
                end = DateUtils.addMinutes(begg, timeStep);
                list.add(timeSlot);
            }
        }
        return list;
    }

    //Getting all time slots of a whole working day
    List<TimeSlot> getAllTimeSlots() {
        int timeStep = 30;
        Date begg = start;
        Date end =  DateUtils.addMinutes(begg, timeStep);
        List<TimeSlot> list = new ArrayList<TimeSlot>();

        for (float i = 0; i < -1*hoursDifference(start, ending)*2; i++) {
            TimeSlot timeSlot = new TimeSlot(true, begg, end);
            begg = end;
            end = DateUtils.addMinutes(begg, timeStep);
            list.add(timeSlot);
        }

        return list;
    }

    //Getting difference between two hours
    private static float hoursDifference(Date date1, Date date2) {

        final int MILLI_TO_HOUR = 1000 * 60 * 60;
        return (float) (date1.getTime() - date2.getTime()) / MILLI_TO_HOUR;
    }

    //Exclude meetings from all time slots from a working day
    List<TimeSlot> compareSetsOfTimeSlots(List<TimeSlot> timeSlotsAll, List<TimeSlot> timeSlotsMeeting) {

        for (int i = 0; i < timeSlotsAll.size(); i++) {
            for (int j = 0; j< timeSlotsMeeting.size(); j++) {
                if (timeSlotsAll.get(i).getBeginning().compareTo(timeSlotsMeeting.get(j).getBeginning()) == 0 && timeSlotsAll.get(i).getEnd().compareTo(timeSlotsMeeting.get(j).getEnd()) == 0) {
                   timeSlotsAll.remove(timeSlotsAll.get(i));

                }
            }
        }
        return timeSlotsAll;
    }
    // compare timetables (should be done after excluding planned meetings for a person)
    List<TimeSlot> compareTwoTimetables(List<TimeSlot> timeSlotsAll, List<TimeSlot> timeSlotsMeeting) {
    List<TimeSlot> avaliableHours = new ArrayList<TimeSlot>();
        for (int i = 0; i < timeSlotsAll.size(); i++) {
            for (int j = 0; j< timeSlotsMeeting.size(); j++) {
                if (timeSlotsAll.get(i).getBeginning().compareTo(timeSlotsMeeting.get(j).getBeginning()) == 0 && timeSlotsAll.get(i).getEnd().compareTo(timeSlotsMeeting.get(j).getEnd()) == 0) {
                    avaliableHours.add(timeSlotsAll.get(i));
                }
            }
        }
        return avaliableHours;
    }



}
