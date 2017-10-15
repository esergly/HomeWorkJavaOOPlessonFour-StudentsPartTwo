public class Main {
    public static void main(String[] args) {
        Group genius = new Group();
        try {
            genius.addStudentToTheGroup(new Student("John", "Bell", 21, "male", 181, 75.6,"Finance", 5));
            genius.addStudentToTheGroup(new Student("Jane", "Carroll", 18, "female", 170, 48.7,"Mathematic", 2));
            genius.addStudentToTheGroup(new Student("Anna", "Smith", 19, "female", 174, 50.0,"Logic", 3));
            genius.addStudentToTheGroup(new Student("Nick", "Tompson", 22, "male", 178, 72.5,"Politic", 5));
            genius.addStudentToTheGroup(new Student("Kate", "Blange", 20, "female", 168, 78.2,"Finance", 5));
            genius.addStudentToTheGroup(new Student("Ben", "Bull", 17, "male", 181, 70.1,"Mathematic", 1));
            genius.addStudentToTheGroup(new Student("Chris", "Peterson", 21, "male", 190, 92.8,"Logic", 5));
            genius.addStudentToTheGroup(new Student("Diane", "Holsson", 20, "female", 172, 46.3,"Politic", 2));
            genius.addStudentToTheGroup(new Student("George", "Klarkson", 17, "male", 178, 80.8,"Mathematic", 4));

//   Add students via menu
            genius.addInteractive();
            genius.addStudentToTheGroup(new Student("Pitt", "Erwin", 18, "male", 181, 85.1,"Logic", 5));
//  for reject of addition action test
//            genius.addStudentToTheGroup(new Student("Paula", "Kotlin", 22, "female", 171, 47.3,"Politic", 3));
        } catch (AdditionalException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
//        Methods from previous tasks for tests (search, remove)
        genius.searchBySurname("Smith");
        genius.searchBySurname("Kennedy");
        genius.removeStudentFromTheGroup(4);
//      Sort by parameters
        genius.sortByParameter(0);
        genius.sortByParameter(2);
        genius.sortByParameter(5);

    }
}
