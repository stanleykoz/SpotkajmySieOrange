import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        String workStartTime = "09:00";
        String workEndTime = "20:00";
        List<String> meetings = new ArrayList<String>();
        meetings.add("09:00");
        meetings.add("10:30");
        meetings.add("12:00");
        meetings.add("13:00");
        meetings.add("16:00");
        meetings.add("18:30");
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");

        Timetable timetable = new Timetable(workStartTime, workEndTime, meetings);
        List<TimeSlot> lista = timetable.getAllTimeSlots();
        List<TimeSlot> lista2 = timetable.getMeetingsTimeslots();
        System.out.println("Liczba slotow: " + lista.size());
        System.out.println("Liczba slotow spotkan: " + lista2.size());

        for (int i = 0; i < lista.size(); i++)
        {
        System.out.println(hourFormat.format(lista.get(i).getBeginning()).toString() + " - " + hourFormat.format(lista.get(i).getEnd()).toString());
        }
    }
}
