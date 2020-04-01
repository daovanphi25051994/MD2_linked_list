package controller;

import linkedlist.MyLinkedList;
import model.Student;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Student> linkedListStudent = new MyLinkedList<>();
        Student student1 = new Student("dao", 18);
        Student student2 = new Student("van", 19);
        Student student3 = new Student("phi", 20);

        linkedListStudent.addFirst(student1);
        linkedListStudent.addLast(student2);
        linkedListStudent.addLast(student3);
        linkedListStudent.remove(student1);

        linkedListStudent.printList();
        System.out.println(linkedListStudent.size());

    }
}
