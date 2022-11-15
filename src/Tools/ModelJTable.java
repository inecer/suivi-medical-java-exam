package Tools;



import Entities.Consultation;
import Entities.Medicament;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel {
    private String[] colonnes;
    private Object[][] lignes;

    @Override
    public String getColumnName(int column) {
        return colonnes[column];
    }

    @Override
    public int getRowCount() {
        return lignes.length;
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return lignes[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        lignes[row][column] = value;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 3 ;
    }

    public void loadDataConsultation(ArrayList<Consultation> lesConsultations) {
        colonnes = new String[]{"Numéro", "Date", "Nom du patient", "Nom du medecin", "Montant"};
        lignes = new Object[lesConsultations.size()][5];
        int i = 0;
        for (Consultation clt : lesConsultations) {
            lignes[i][0] = clt.getNumero();
            lignes[i][1] = clt.getDate();
            lignes[i][2] = clt.getNomPatient();
            lignes[i][3] = clt.getNomMedecin();
            lignes[i][4] = clt.getMontant();
            i++;
        }
        fireTableChanged(null);
    }

    public void loadDataMedicament(ArrayList<Medicament> lesMedicaments) {
        colonnes = new String[]{"Numéro", "Nom", "Prix"};
        lignes = new Object[lesMedicaments.size()][3];
        int i = 0;
        for (Medicament mdt : lesMedicaments) {
            lignes[i][0] = mdt.getNumero();
            lignes[i][1] = mdt.getNom();
            lignes[i][2] = mdt.getPrix();
            i++;
        }
        fireTableChanged(null);
    }
}
