package main;
enum Day {Mon, Tue, Wed, Thu, Fri, Sat, Sun};
/**
 * Example of Enum. Shows old style switch and new style (better)
 * Shows how to iterate over enum values
 *
 * @author Gerard Pons-Moll
 */
public class EnumDemoNew {

    public static void main(String[] args) {
        Day currentDay;
        currentDay = Day.Sat;
        // old style switch
        switch (currentDay) {
            case Tue:
            case Thu:
                System.out.println("Lecture!");
                break;
            case Sat:
            case Sun:
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("Work on exercises");
                break;
        }
        System.out.println("The new syntax. Outcome is exaclty the same, but code is much nicer!");
        // New style switch
        switch (currentDay) {
            case Tue, Thu -> System.out.println("Lecture!");
            case Sat, Sun -> System.out.println("Weekend!");
            default -> System.out.println("Work on exercises");
        }
        // For each element in enum
        System.out.println("Loop over elements of enum");
        for (Day d : Day.values()) {
            System.out.println(d + " is the “ + " +
                    (d.ordinal() + 1) + " Day of the week");
        }
    }
}
