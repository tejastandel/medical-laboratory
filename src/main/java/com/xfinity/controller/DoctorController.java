package com.xfinity.controller;

import com.xfinity.data_access_layer.DoctorDataAccessLayer;
import com.xfinity.data_access_object.Doctor;
import java.util.ArrayList;

public class DoctorController {

    private static final DoctorDataAccessLayer DOC_DAL = new DoctorDataAccessLayer();

    public static boolean addDoctor(Doctor doc) {
        return DOC_DAL.addDoctor(doc);
    }

    public static ArrayList<Doctor> getDoctors() {
        return DOC_DAL.getDoctors();
    }

}
