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

public class CtrlConsultation
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlConsultation() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Consultation> GetAllConsultations()
    {
        ArrayList<Consultation> lesConsultations = new ArrayList<>();
        try {
            ps = cnx.prepareStatement(
                    "SELECT DISTINCT idPatient,dateConsult, nomPatient, nomMedecin,prixMedoc*quantite as montant " +
                    "FROM consultation,medicament,prescrire,medecin,patient\n" +
                    "WHERE idPatient = numPatient AND idMedecin = numMedecin\n" +
                    "GROUP BY nomPatient");
            rs = ps.executeQuery();
            while (rs.next()) {
                Consultation clt = new Consultation(rs.getInt("idPatient"), rs.getString("dateConsult"), rs.getString("nomPatient"), rs.getString("nomMedecin"), rs.getDouble("montant"));
                lesConsultations.add(clt);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConsultation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int getLastNumberOfConsultation()
    {

        return 0;
    }
    public void InsertConsultation(int idConsult, String dateConsultation, int numPatient,int numMedecin)
    {

    }
}
