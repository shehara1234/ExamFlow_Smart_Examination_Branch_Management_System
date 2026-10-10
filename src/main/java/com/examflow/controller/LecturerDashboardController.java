package com.examflow.controller;

import com.examflow.dao.ResultDAO;
import com.examflow.model.ExamResult;
import com.examflow.service.GPACalculationEngine;

public class LecturerController {

    private GPACalculationEngine gpaEngine = new GPACalculationEngine();
    private ResultDAO resultDAO = new ResultDAO();

    public void submitMarks(long studentId, long courseId, double caMarks, double finalMarks) {

        String[] calculated = gpaEngine.computeGradeAndPoint(caMarks, finalMarks);

        double totalMarks = Double.parseDouble(calculated[0]);
        String grade = calculated[1];
        double gradePoint = Double.parseDouble(calculated[2]);

        ExamResult result = new ExamResult(0, studentId, courseId, caMarks, finalMarks, totalMarks, grade, gradePoint);

        boolean isSuccess = resultDAO.saveResult(result);
        if (isSuccess) {
            System.out.println("Marks submitted successfully with Grade: " + grade);
        } else {
            System.err.println("Failed to submit marks.");
        }
    }
}
