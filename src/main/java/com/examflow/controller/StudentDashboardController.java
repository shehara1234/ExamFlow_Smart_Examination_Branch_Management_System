package com.examflow.controller;

import com.examflow.dao.TimetableDAO;
import com.examflow.model.Timetable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML private Label lblStudentName;
    @FXML private Label lblIndexNo;
    @FXML private Label lblDegree;
    @FXML private Button btnLogout;

    // Exam Timetable Tab Controls
    @FXML private TableView<Timetable> tblTimetable;
    @FXML private TableColumn<Timetable, String> colCourseCode;
    @FXML private TableColumn<Timetable, String> colCourseTitle;
    @FXML private TableColumn<Timetable, String> colExamDate;
    @FXML private TableColumn<Timetable, String> colTimeSlot;
    @FXML private TableColumn<Timetable, String> colHallName;
    @FXML private TableColumn<Timetable, String> colBuilding;
    @FXML private TableColumn<Timetable, String> colSeatNumber;

    // Results Tab Controls
    @FXML private Label lblSGPA;
    @FXML private Label lblCGPA;
    @FXML private TableView<?> tblResults;

    // Re-Correction Tab Controls
    @FXML private ComboBox<String> cmbCourse;
    @FXML private ComboBox<String> cmbRequestType;
    @FXML private TextField txtPaymentStatus;
    @FXML private Button btnSubmitRequest;
    @FXML private TableView<?> tblRecorrection;

    private final TimetableDAO timetableDAO = new TimetableDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTimetables();
    }

    public void loadTimetables() {
        List<Timetable> timetables = timetableDAO.getAllTimetables();
        System.out.println("Loaded " + timetables.size() + " timetables for student display.");
        if (tblTimetable != null && timetables != null) {
            tblTimetable.setItems(FXCollections.observableArrayList(timetables));
        }
    }
}