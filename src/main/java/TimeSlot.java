import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSlot {
    boolean isAvaliable;
    Date beginning;
    Date end;

    public TimeSlot(boolean isAvaliable, Date beginning, Date end) {
        this.isAvaliable = isAvaliable;
        this.beginning = beginning;
        this.end = end;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }

    public Date getBeginning() {
        return beginning;
    }

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
