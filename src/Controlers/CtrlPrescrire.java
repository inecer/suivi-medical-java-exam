package Controlers;

import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlPrescrire
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlPrescrire() {
        cnx = ConnexionBDD.getCnx();
    }

    public void InsertPrescrire(int idConsult, int numMedicament,int quantite)
    {
        try {
            ps = cnx.prepareStatement("insert into prescrire values (?,?,?,?)");
            ps.setObject(1, null);
            ps.setInt(2, idConsult);
            ps.setInt(3, numMedicament);
            ps.setInt(4, quantite);
            ps.executeUpdate();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPrescrire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
