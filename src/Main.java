import java.util.HashMap;
import java.util.List;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        // Сделай минимум два студента с одинаковым GPA (для Task 3)
        students.put("1", new Student("Ali", 3.5, 20));
        students.put("2", new Student("Bek", 3.5, 20));
        students.put("3", new Student("Charlie", 3.9, 22));
        students.put("4", new Student("Damir", 3.2, 19));
        students.put("5", new Student("Elena", 4.0, 23));
        // TODO: Напечатай всех студентов (ID + объект)
        System.out.println("--- Список студентов ---");
        for (String id : students.keySet()) {
            System.out.println("ID: " + id + " | " + students.get(id));
        }
        // TODO: Найди студента по ID и выведи его
        System.out.println("\nИщем студента с ID 3:");
        Student s3 = students.get("3");
        System.out.println(s3);
        // TODO: Удали одного студента по ID
        System.out.println("\nУдаляем студента с ID 4...");
        students.remove("4");
        // TODO: Обнови GPA у одного студента
        System.out.println("Обновляем GPA студенту Ali...");
        Student ali = students.get("1");
        if (ali != null) {
            ali.setGpa(3.7);
        }
        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        ArrayList<Student> studentList = new ArrayList<>(students.values());
        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        Collections.sort(studentList);
        System.out.println("\nСортировка по GPA (по возрастанию):");
        for (Student s : studentList) System.out.println(s);
        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        System.out.println("\nСортировка по имени:");
        for (Student s : studentList) System.out.println(s);
        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        ArrayList<Student> topStudents = new ArrayList<>(students.values());
        topStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getGpa(), s1.getGpa());
            }
        });
        // Выводим первые 3
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + topStudents.get(i));
        }

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");

        HashMap<Double, List<String>> gpaGroups = new HashMap<>();

        for (Student s : students.values()) {
            double gpa = s.getGpa();
            if (!gpaGroups.containsKey(gpa)) {
                gpaGroups.put(gpa, new ArrayList<>());
            }
            gpaGroups.get(gpa).add(s.getName());
        }

        for (Double gpa : gpaGroups.keySet()) {
            List<String> names = gpaGroups.get(gpa);
            if (names.size() > 1) {
                System.out.println("GPA " + gpa + " -> " + names);
            }
        }
        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();

        Course java = new Course("Java");
        Course python = new Course("Python");

        courseMap.put(java, new ArrayList<>(students.values())); // Все на Java
        courseMap.put(python, new ArrayList<>()); // На Python только один
        courseMap.get(python).add(students.get("5"));

        for (Course c : courseMap.keySet()) {
            System.out.println(c.getName() + ": " + courseMap.get(c));
        }
        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        ArrayList<Student> finalSort = new ArrayList<>(students.values());

        finalSort.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                
                int res = Double.compare(s2.getGpa(), s1.getGpa());
                if (res == 0) {
                    res = s1.getName().compareTo(s2.getName());
                }
                return res;
            }
        });

        for (Student s : finalSort) System.out.println(s);
    }
}


