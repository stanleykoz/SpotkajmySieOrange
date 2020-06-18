import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        //Calendar 1
        String workStartTime = "09:00";
        String workEndTime = "20:00";
        List<String> meetings = new ArrayList<String>();
        meetings.add("09:00");
        meetings.add("10:30");
        meetings.add("12:00");
        meetings.add("13:00");
        meetings.add("16:00");
        meetings.add("18:30");

        //Calendar 2
        String workStartTime2 = "10:00";
        String workEndTime2 = "18:30";
        List<String> meetings2 = new ArrayList<String>();
        meetings2.add("10:00");
        meetings2.add("11:30");
        meetings2.add("12:30");
        meetings2.add("14:30");
        meetings2.add("14:30");
        meetings2.add("15:00");
        meetings2.add("16:00");
        meetings2.add("17:00");

        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");

        Timetable timetable = new Timetable(workStartTime, workEndTime, meetings);
        List<TimeSlot> lista = timetable.getAllTimeSlots();
        List<TimeSlot> lista2 = timetable.getMeetingsTimeslots();

        Timetable timetable2 = new Timetable(workStartTime2, workEndTime2, meetings2);
        List<TimeSlot> lista3 = timetable2.getAllTimeSlots();
        List<TimeSlot> lista4 = timetable2.getMeetingsTimeslots();



        timetable.compareSetsOfTimeSlots(lista, lista2);
        timetable2.compareSetsOfTimeSlots(lista3, lista4);


        List<TimeSlot> result = timetable.compareTwoTimetables(lista3, lista);
        System.out.println("Possible meetings hours (meeting lasting 30 minutes): ");
        for (int i = 0; i < result.size(); i++)
        {
            System.out.println(hourFormat.format(result.get(i).getBeginning()).toString() + " - " + hourFormat.format(result.get(i).getEnd()).toString());
        }

    }
}
