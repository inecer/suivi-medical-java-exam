package Vues;

import Controlers.*;
import Entities.Consultation;
import Entities.Medicament;
import Tools.ModelJTable;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrmPrescrire extends JFrame
{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblNumero;
    private JLabel lblDate;
    private JLabel lblNomMedecin;
    private JTextField txtNumeroConsultation;
    private JComboBox cboPatients;
    private JComboBox cboMedecins;
    private JButton btnInserer;
    private JTable tblMedicaments;
    private JPanel pnlDate;
    private JLabel lblNomPatient;
    private JLabel lblMedicaments;
    private JDateChooser dcDateConsultation;
    private CtrlPatient CtrlPatient;
    private CtrlMedecin CtrlMedecin;
    private CtrlMedicament CtrlMedicament;
    private CtrlPrescrire CtrlPrescrire;
    private  ModelJTable mdl;
    public FrmPrescrire()
    {
        this.setTitle("Prescrire");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                dcDateConsultation = new JDateChooser();
                dcDateConsultation.setDateFormatString("yyyy-MM-dd");
                pnlDate.add(dcDateConsultation);
                for (String patient:CtrlPatient.getAllPatients())
                {
                    cboPatients.addItem(patient);
                }
                for (String medecin:CtrlMedecin.getAllMedecins())
                {
                    cboMedecins.addItem(medecin);
                }
                CtrlMedicament = new CtrlMedicament();
                mdl = new ModelJTable();
                mdl.loadDataMedicament(CtrlMedicament.getAllMedicaments());
                tblMedicaments.setModel(mdl);

            }
        });
        btnInserer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(cboMedecins.getSelectedItem() == null)
                {
                    JOptionPane.showMessageDialog(null, "Sélectionner un medecin","Choix du medecin",JOptionPane.WARNING_MESSAGE);
                }
                else if(cboPatients.getSelectedItem() == null)
                {
                    JOptionPane.showMessageDialog(null, "Sélectionner un patient","Choix du patient",JOptionPane.WARNING_MESSAGE);
                }
                else if(txtNumeroConsultation.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Saisir le numéro de consultation","Erreur de saisie",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    CtrlPrescrire.InsertPrescrire();
                    }
                }


            });
        }
    }
}
