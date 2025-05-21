class Student {
    private int studentid;
    private String name;
    private int daysAttended;

    Student(String name, int studentid, int daysAttended) {
        this.name = name;
        this.studentid = studentid;
        this.daysAttended = daysAttended;
    }

    void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    void setName(String name) {
        this.name = name;
    }

    void setDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }

    String getName() {
        return name;
    }

    int getStudentid() {
        return studentid;
    }

    int getDaysAttended() {
        return daysAttended;
    }

    // Override toString to print student details properly
    public String toString() {
        return "ID: " + studentid + ", Name: " + name + ", Days Attended: " + daysAttended;
    }
}

class Classroom {
    private int studentCount;
    private Student[] students;

    Classroom() {
        students = new Student[10]; // corrected array initialization
        studentCount = 0;
    }

    public void addStudent(Student st1) {
        if (studentCount < students.length) {
            students[studentCount] = st1;
            studentCount++; // only increment once
        } else {
            System.out.println("No space for more students");
        }
    }

    public void updateStudents(int studentID, int newDaysAttended) {
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentid() == studentID) {
                students[i].setDaysAttended(newDaysAttended);
                System.out.println("Updated attendance for " + students[i].getName());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + studentID + " can't be found");
        }
    }

    public void displayDetails() {
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Classroom cl1 = new Classroom();

        cl1.addStudent(new Student("Alice Smith", 101, 12));
        cl1.addStudent(new Student("Bob Jones", 102, 15));
        cl1.addStudent(new Student("Carol Lee", 103, 10));

        cl1.updateStudents(102, 16);
        cl1.updateStudents(104, 12);

        cl1.displayDetails();
    }
}

