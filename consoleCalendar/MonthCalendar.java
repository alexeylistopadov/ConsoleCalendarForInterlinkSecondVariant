package consoleCalendar;

import java.time.LocalDate;
import java.util.ArrayList;

public class MonthCalendar {

    private LocalDate selectedDate;
    private ArrayList<LocalDate> days;

    public MonthCalendar() {
        selectedDate = LocalDate.now();
        days = createDaysList();
    }

    public MonthCalendar(int numberOfMonth) {
        selectedDate = LocalDate.of(LocalDate.now().getYear(), numberOfMonth, 1);
        days = createDaysList();
    }

    public ArrayList<LocalDate> getDays() {
        return days;
    }

    private ArrayList<LocalDate> createDaysList() {
        ArrayList<LocalDate> days = new ArrayList<>();
        for (int i = 1; i <= selectedDate.getMonth().length(selectedDate.isLeapYear()); i++) {
            days.add(LocalDate.of(selectedDate.getYear(), selectedDate.getMonth(), i));
        }
        return days;
    }
}
