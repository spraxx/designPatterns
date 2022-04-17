package com.es2.memento;

import java.util.ArrayList;

public class Server
{
    private Memento state;
    private ArrayList<String> students = new ArrayList<>();

    public Server() {}

    public void addStudent(String studentName) throws ExistingStudentException
    {
        for (String estudante:students)
        {
            if(estudante.equals(studentName))
            {
                throw new ExistingStudentException();
            }
        }
        students.add(studentName);
    }

    public void restore(Memento state)
    {
        students.clear();
        students.addAll(state.getState());
    }

    public ArrayList<String> getStudentNames()
    {
        return students;
    }
}
