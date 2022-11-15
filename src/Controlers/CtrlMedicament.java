package Controlers;

import Entities.Consultation;
import Entities.Medicament;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedicament
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedicament() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Medicament> getAllMedicaments()
    {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            ps = cnx.prepareStatement(
                    "SELECT idMedoc,nomMedoc,prixMedoc,quantite FROM medicament,prescrire WHERE idMedoc = numMedoc GROUP BY nomMedoc");
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicament mdt = new Medicament(rs.getInt("idMedoc"), rs.getString("nomMedoc"), rs.getDouble("prixMedoc"), rs.getInt("quantite"));
                lesMedicaments.add(mdt);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedicament.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Medicament> GetAllMedicamentsByIdConsultations(int idConsultation)
    {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            ps = cnx.prepareStatement(
                    "SELECT idMedoc,nomMedoc,prixMedoc\n" +
                            "        FROM medicament,prescrire,consultation\n" +
                            "        WHERE idConsult = numConsult AND idMedoc = numMedoc\n" +
                            "        GROUP BY nomMedoc");
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicament mdt = new Medicament(rs.getInt("idMedoc"), rs.getString("nomMedoc"), rs.getDouble("prixMedoc"));
                lesMedicaments.add(mdt);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedicament.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
