import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PatientReport {

    public static void writeReport(ArrayList<Patient> patients, int reportType, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            switch (reportType) {
                case 1:
                    sortById(patients);
                    for (Patient p : patients) {
                        writer.write(p.getID() + ", " + p.getName() + ", " + p.getEmail() + "\n");
                    }
                    break;

                case 2:
                    sortByName(patients);
                    for (Patient p : patients) {
                        writer.write(p.getID() + ", " + p.getName() + ", " + p.getEmail() + "\n");
                    }
                    break;

                case 3:
                    sortByEmail(patients);
                    for (Patient p : patients) {
                        writer.write(p.getEmail() + "\n");
                    }
                    break;

                case 4:
                    for (Patient p : patients) {
                        writer.write(p.toString() + "\n");
                    }
                    break;

                default:
                    System.out.println("Invalid report type selected.");
                    break;
            }
            System.out.println("Report written successfully to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the report: " + e.getMessage());
        }
    }

    private static void sortById(ArrayList<Patient> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getID() < list.get(minIdx).getID()) {
                    minIdx = j;
                }
            }
            swap(list, i, minIdx);
        }
    }

    private static void sortByName(ArrayList<Patient> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getName().compareToIgnoreCase(list.get(minIdx).getName()) < 0) {
                    minIdx = j;
                }
            }
            swap(list, i, minIdx);
        }
    }

    private static void sortByEmail(ArrayList<Patient> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getEmail().compareToIgnoreCase(list.get(minIdx).getEmail()) < 0) {
                    minIdx = j;
                }
            }
            swap(list, i, minIdx);
        }
    }

    private static void swap(ArrayList<Patient> list, int i, int j) {
        Patient temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}