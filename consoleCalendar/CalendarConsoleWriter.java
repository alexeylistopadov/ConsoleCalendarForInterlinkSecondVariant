package consoleCalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class CalendarConsoleWriter {

    public void writeCalendar(MonthCalendar monthCalendar) {
        ArrayList<LocalDate> days = monthCalendar.getDays();
        writeDaysTitle();
        skipEmptyDays(days);
        writeDays(days);
    }

    private void writeDaysTitle() {
        Locale locale = Locale.getDefault();
        for (DayOfWeek dayTitle : DayOfWeek.values()) {
            System.out.print(getDayColor(dayTitle) + dayTitle.getDisplayName(TextStyle.SHORT, locale) + "\t");
        }
        System.out.println();
    }

    private void writeDays(ArrayList<LocalDate> days) {
        for (LocalDate day : days) {
            if (day.equals(LocalDate.now())) {
                System.out.print("\u001B[34m" + day.getDayOfMonth() + "\t");
            } else {
                System.out.print(getDayColor(day.getDayOfWeek()) + day.getDayOfMonth() + "\t");
            }
            if (day.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
        }
    }

    private String getDayColor(DayOfWeek dayOfWeek) {
        if (dayOfWeek.getValue() > 5) {
            return "\u001B[31m";
        } else {
            return "\u001B[0m";
        }
    }

    private void skipEmptyDays(ArrayList<LocalDate> days) {
        for (int i = 1; i < days.get(0).getDayOfWeek().getValue(); i++) {
            System.out.print("\t");
        }
    }
}
