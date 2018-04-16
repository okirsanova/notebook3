package javacourses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static final String TIME_FORMAT = "HH:mm";
    public static final DateTimeFormatter TIME_FORMATTER
            = DateTimeFormatter.ofPattern(TIME_FORMAT);

    static Scanner scanner = new Scanner(System.in);
    //    static ArrayList<Record> records = new ArrayList<>();
    static TreeMap<Integer, Record> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        commandLoop();
    }

    private static void commandLoop() {
        System.out.println("This is your personal notebook. Enter 'help' for all available commands");
        for (; ; ) {
            String cmd = askString("cmd> ");

            switch (cmd.toLowerCase()) {
                case "exit":
                    return;
                case "create":
                    create();
                    break;
                case "find":
                    find();
                    break;
                case "list":
                    list();
                    break;
                case "show":
                    showById();
                    break;
                case "expired":
                    findExpired();
                    break;
                case "help":
                    showHelp();
                    break;
                default:
                    System.out.println("Unknown command. Enter 'help' for all available options");
            }
        }
    }

    private static void findExpired() {
        for (Record r : treeMap.values()) {
            if (r instanceof Expirable) {
                Expirable expirable = (Expirable) r;
                if (expirable.isExpired()) {
                    System.out.println(expirable);
                }
            }
        }
    }

    private static void list() {
        for (Record r : treeMap.values()) {
            System.out.println(r);
        }
    }

    private static void find() {
        String part = askString("What to find? ");
        for (Record r : treeMap.values()) {
            if (r.contains(part)) {
                System.out.println(r);
            }
        }
    }

    private static void showById() {
        for (; ; ) {
            try {
                String strId = askString("Enter id of record you want to find: ");
                int id = Integer.parseInt(strId);
                Record r = treeMap.get(id);
                System.out.println(r);
            } catch (NumberFormatException e) {
                scanner.next();
                System.out.println("Only numbers, please!");
            }
        }
    }


    private static void create() {
        for (; ; ) {
            System.out.println("Enter type of the record to create. 'help' for all available options");
            String type = askString("type: ");

            switch (type.toLowerCase()) {
                case "exit":
                    return;
                case "person":
                    addRecord(new Person());
                    return;
                case "pet":
                    addRecord(new Pet());
                    return;
                case "note":
                    addRecord(new Note());
                    return;
                case "alarm":
                    addRecord(new Alarm());
                    return;
                case "reminder":
                    addRecord(new Reminder());
                    return;
                case "help":
                    showHelpCreate();
                    break;
                default:
                    System.out.println("Unknown type");
            }
        }
    }

    private static void addRecord(Record record) {
        record.askUserData();
        int id = record.getId();
        treeMap.put(id, record); // associacion what with what
        System.out.println("Created!");
    }


    private static void showHelpCreate() {
        System.out.println("\tperson  creates a new phone book record");
        System.out.println("\tpet  creates a new record about pet");
        System.out.println("\tnote    creates a new note record");
        System.out.println("\talarm   creates a new alarm");
        System.out.println("\treminder  creates a new reminder");
        System.out.println("\texit    returns to main menu");
        System.out.println("\tshow    searches data using ID");
    }

    private static void showHelp() {
        System.out.println("\thelp    shows this help");
        System.out.println("\tcreate  creates a new record");
        System.out.println("\tlist    lists all records");
        System.out.println("\tfind    searches for text");
        System.out.println("\texit    exit from the program");
    }

    public static LocalDate askDate(String message) {
        for (; ; ) {
            String strDate = askString(message + "(" + DATE_FORMAT + ")");
            try {
                LocalDate date = LocalDate.parse(strDate, DATE_FORMATTER);
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Date format is not correct.");
            }
        }
    }

    public static LocalTime askTime(String message) {
        for (; ; ) {
            String strTime = askString(message + "(" + TIME_FORMAT + ")");
            try {
                LocalTime time = LocalTime.parse(strTime, TIME_FORMATTER);
                return time;
            } catch (DateTimeParseException e) {
                System.out.println("Time format is not correct, use HH:mm format.");
            }
        }
    }


    public static String askString(String message) {
        System.out.print(message);
        String str = scanner.next();
        if (str.startsWith("\"")) {
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            while (!str.endsWith("\"")) {
                str = scanner.next();
                list.add(str);
            }
            str = String.join(" ", list);
            str = str.substring(1, str.length() - 1);
        }
        return str;
    }
}
