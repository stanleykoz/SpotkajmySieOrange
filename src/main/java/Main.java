import java.text.ParseException;
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


        Timetable timetable = new Timetable();
        List<TimeSlot> lista = timetable.getAllTimeSlots(workStartTime, workEndTime);
        System.out.println("Liczba slotow: " + lista.size());

        for (int i = 0; i < lista.size(); i++)
        {
        System.out.println(lista.get(i).getBeginning().toString() + " - " + lista.get(i).getEnd().toString());
        }
    }
}
