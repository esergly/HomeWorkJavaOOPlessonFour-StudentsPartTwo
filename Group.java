import javax.swing.*;
import java.util.Arrays;

public class Group implements Voenkomat {

    private Student[] students = new Student[10];

    public Group() {
        super();
    }

    public void addStudentToTheGroup(Student student) throws AdditionalException {
        if (student == null) {
            throw new IllegalArgumentException("Nothing to add!");
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        throw new AdditionalException();
    }

    public void addInteractive() throws AdditionalException {
        String name, surname, sex, faculty;
        int age, growth, course;
        double weight;
        Student student = null;
        try {
            for (; ; ) {
                name = String.valueOf(JOptionPane.showInputDialog("Input name: "));
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Incorrect value. Can't be empty. Try again.");
                } else {
                    break;
                }
            }
            for (; ; ) {
                surname = String.valueOf(JOptionPane.showInputDialog("Input surname: "));
                if (surname.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Incorrect value. Can't be empty. Try again.");
                } else {
                    break;
                }
            }
            for (; ; ) {
                age = Integer.valueOf(JOptionPane.showInputDialog("Input age: "));
                if (age < 16) {
                    JOptionPane.showMessageDialog(null, "Incorrect value. The age value is too small. Try again.");
                } else {
                    break;
                }
            }
            for (; ; ) {
                sex = String.valueOf(JOptionPane.showInputDialog("Input sex (male/female): "));
                if (sex.equals("male") || sex.equals("female")) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect value. The sex value can be male or female. Try again.");
                }
            }
            for (; ; ) {
                growth = Integer.valueOf(JOptionPane.showInputDialog("Input growth in sm: "));
                if (growth < 80 && growth > 250) {
                    JOptionPane.showMessageDialog(null, "Incorrect value. The growth value available between 80 and 250 sm. Try again.");
                } else {
                    break;
                }
            }
            for (; ; ) {
                weight = Double.valueOf(JOptionPane.showInputDialog("Input weight in kg (use \".\" as separator if needed): "));
                if (weight < 20) {
                    JOptionPane.showMessageDialog(null, "Incorrect value. The value must be more than 20 kg. Try again.");
                } else {
                    break;
                }
            }
            for (; ; ) {
                faculty = String.valueOf(JOptionPane.showInputDialog("Input faculty: "));
                if (faculty.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Incorrect value. Can't be empty. Try again.");
                } else {
                    break;
                }
            }
            for (; ; ) {
                course = Integer.valueOf(JOptionPane.showInputDialog("Input course: "));
                if ((1 > course) && (course > 5)) {
                    JOptionPane.showMessageDialog(null, "Incorrect value. The value must be between 1 and 5. Try again.");
                } else {
                    break;
                }
            }
            Student addstudent = new Student(name, surname, age, sex, growth, weight, faculty, course);
            this.addStudentToTheGroup(addstudent);
            System.out.println(Arrays.toString(students));
            return;
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "You've pressed cancel");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error number format"); //Microsoft style
        }
    }

    public Student searchBySurname(String surname) {
        for (Student student : students) {
            if (student != null && student.getSurname().equals(surname)) {
                return student;
            }
        }
        return null;
    }

    public void removeStudentFromTheGroup(int p) {
        if (p > 0 && p < students.length) {
            students[p - 1] = null;
        }
    }

    public void sortByParameter(int i) {
        Arrays.sort(students, new SortByParameter(i));
//        System.out.println(Arrays.toString(students)); This string for test only
    }


    private void sortBySurname() {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (compareStudentBySurname(students[i], students[j]) > 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    private int compareStudentBySurname(Student i, Student j) {
        if (i != null && j == null) {
            return 1;
        }
        if (i == null && j != null) {
            return -1;
        }
        if (i == null && j == null) {
            return 0;
        }
        return i.getSurname().compareTo(j.getSurname());
    }

    @Override
    public String toString() {
        sortBySurname();
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(System.lineSeparator());
        int j = 1;
        for (Student student : students) {
            if (student != null) {
                stringBuilder.append(Integer.toString(j)).append(") ").append(student).append("\n");
                j++;
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public Student[] getArmy() {
        Student[] voenkom = new Student[1];
        int count = 0;
        int control = 0;
        for (Student student : students) {
            if (student != null && student.getSex().equals("male") && (student.getAge() > 17)) {
                control++;
                count++;
                Student[] temp = new Student[control + 1];
                System.arraycopy(voenkom, 0, temp, 0, voenkom.length);
                temp[control - 1] = student;
                voenkom = temp;
            } else {
                count++;
            }
            if (count == students.length - 1 && control == 0) {
                return null;
            }
        }
        return voenkom;
    }
}




