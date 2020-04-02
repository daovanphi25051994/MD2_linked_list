package controller;

import linkedlist.MyLinkedList;
import model.Student;
import org.w3c.dom.Node;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Student> linkedListStudent = new MyLinkedList<>();
        Student student1 = new Student("dao", 18);
        Student student2 = new Student("van", 19);
        Student student3 = new Student("phi", 20);
        Student student4 = new Student("dao van phi", 21);
        linkedListStudent.add(student1);
        linkedListStudent.add(student2);
        linkedListStudent.add(student3);
        linkedListStudent.add(student4);

        Object[] students = linkedListStudent.clone();
        for (Object student : students) {
            System.out.println(student.toString());
        }

    }
}
