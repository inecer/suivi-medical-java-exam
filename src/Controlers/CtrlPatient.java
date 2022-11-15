package Controlers;

import Entities.Consultation;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlPatient
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlPatient() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllPatients()
    {
        ArrayList<String> lesPatients = new ArrayList<>();
        try {
            ps = cnx.prepareStatement(
                    "SELECT nomPatient FROM patient");
            rs = ps.executeQuery();
            while (rs.next()) {
                String clt = rs.getString("nomPatient");
                lesPatients.add(clt);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int getIdPatientByName(String nomPat)
    {

        return 0;
    }
}
