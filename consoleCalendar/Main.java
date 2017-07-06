package consoleCalendar;

public class Main {

    public static void main(String[] args) {
        try {
            CalendarConsoleWriter calendarConsoleWriter = new CalendarConsoleWriter();
            if (args.length != 0) {
                calendarConsoleWriter.writeCalendar(new MonthCalendar(Integer.parseInt(args[0])));
            } else {
                calendarConsoleWriter.writeCalendar(new MonthCalendar());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
