package com.xfinity.data_access_layer;

import com.xfinity.data_access_object.Doctor;
import com.xfinity.db.DBHandler;
import com.xfinity.db.DbConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorDataAccessLayer {

    public boolean addDoctor(Doctor doc) {
        try (Connection connection = DbConnectionProvider.getDbConnection()) {
	    String sql = "insert into tbl_doctor(docName) values (?)";
            int response = DBHandler.setData(connection, sql, doc.getDocName());
            return response > 0;
	} catch (SQLException | ClassNotFoundException ex) {
	    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            return false;
	}
    }

    public ArrayList<Doctor> getDoctors() {
        ArrayList<Doctor> availableDoctors = new ArrayList<>();
	try (Connection connection = DbConnectionProvider.getDbConnection()) {
	    String sql = "SELECT docName FROM tbl_doctor order by docName asc";
	    ResultSet docData = DBHandler.getData(connection, sql);
	    if (docData.first()) {
		int indexDoctorName = docData.findColumn("docName");
		Doctor doc;
		do {
		    doc = new Doctor();
                    doc.setDocName(docData.getString(indexDoctorName));
                    availableDoctors.add(doc);
		} while (docData.next());
	    }
	} catch (SQLException | ClassNotFoundException ex) {
	    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
	}
	return availableDoctors;
    }
    
}
