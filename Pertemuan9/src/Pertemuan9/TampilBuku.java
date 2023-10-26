/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pertemuan9;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jdk.nashorn.internal.objects.Global.print;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author RIO
 */
public class TampilBuku extends javax.swing.JFrame {

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }

    ArrayList<Buku> dataBuku;

    private void tampil() {

        DefaultTableModel model = (DefaultTableModel) jTableBuku.getModel();
        model.setRowCount(0);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan9PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Buku> cq = cb.createQuery(Buku.class);
        Root<Buku> stud = cq.from(Buku.class);
        cq.select(stud.get("isbn"));

        CriteriaQuery<Buku> select = cq.select(stud);
        TypedQuery<Buku> q = em.createQuery(select);
        List<Buku> list = q.getResultList();

        for (Buku data : list) {
            Object[] baris = new Object[4];
            baris[0] = data.getIsbn();
            baris[1] = data.getJudul();
            baris[2] = data.getTahun();
            baris[3] = data.getPenerbit();

            model.addRow(baris);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public TampilBuku() {
//        try {
        dataBuku = new ArrayList<>();
        initComponents();
//            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "11111");
        tampil();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(TampilBuku.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldISBN = new javax.swing.JTextField();
        jTextFieldJudul = new javax.swing.JTextField();
        jTextFieldTahun = new javax.swing.JTextField();
        jTextFieldPenerbit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBuku = new javax.swing.JTable();
        jButtonSimpan = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jButtonCetak = new javax.swing.JButton();
        jButtonUpload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ISBN");

        jLabel2.setText("Judul Buku");

        jLabel3.setText("Tahun Terbit");

        jLabel4.setText("Penerbit");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTableBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ISBN", "Judul Buku", "Tahun Terbit", "Penerbit"
            }
        ));
        jTableBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBuku);

        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jButtonCetak.setText("Cetak");
        jButtonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCetakActionPerformed(evt);
            }
        });

        jButtonUpload.setText("Upload");
        jButtonUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonSimpan)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldISBN)
                                .addComponent(jTextFieldJudul)
                                .addComponent(jTextFieldTahun)
                                .addComponent(jTextFieldPenerbit, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonHapus)
                                .addGap(42, 42, 42)
                                .addComponent(jButtonEdit)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSimpan)
                            .addComponent(jButtonHapus)
                            .addComponent(jButtonEdit))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed

        try {
            String isbn = jTextFieldISBN.getText().trim();
            String judul = jTextFieldJudul.getText();
            String tahun = jTextFieldTahun.getText();
            String penerbit = jTextFieldPenerbit.getText();

            EntityManager entityManager = Persistence.createEntityManagerFactory("Pertemuan9PU").createEntityManager();

            entityManager.getTransaction().begin();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            Buku b = new Buku();

            b.setIsbn(isbn);
            b.setJudul(judul);
            b.setTahun(tahun);
            b.setPenerbit(penerbit);

            entityManager.persist(b);
            entityManager.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Simpan Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Simpan Gagal");
        }

        jTextFieldISBN.setText("");
        jTextFieldJudul.setText("");
        jTextFieldTahun.setText("");
        jTextFieldPenerbit.setText("");

        tampil();
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed

        try {
            String isbn = jTextFieldISBN.getText().trim();
            String judul = jTextFieldJudul.getText();
            String tahun = jTextFieldTahun.getText();
            String penerbit = jTextFieldPenerbit.getText();
            EntityManager entityManager = Persistence.createEntityManagerFactory("Pertemuan9PU").createEntityManager();

            entityManager.getTransaction().begin();
            Buku b = entityManager.find(Buku.class, isbn);

            b.setIsbn(isbn);
            b.setJudul(judul);
            b.setTahun(tahun);
            b.setPenerbit(penerbit);

            entityManager.persist(b);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Ubah Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ubah Gagal");
        }

        jTextFieldISBN.setText("");
        jTextFieldJudul.setText("");
        jTextFieldTahun.setText("");
        jTextFieldPenerbit.setText("");

        tampil();
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed

        try {

            String isbn = jTextFieldISBN.getText().trim();
            String judul = jTextFieldJudul.getText();
            String tahun = jTextFieldTahun.getText();
            String penerbit = jTextFieldPenerbit.getText();
            EntityManager entityManager = Persistence.createEntityManagerFactory("Pertemuan9PU").createEntityManager();

            entityManager.getTransaction().begin();
            Buku b = entityManager.find(Buku.class,
                    isbn);

            b.setIsbn(isbn);
            b.setJudul(judul);
            b.setTahun(tahun);
            b.setPenerbit(penerbit);

            entityManager.persist(b);
            entityManager.remove(b);
            entityManager.getTransaction().commit();
            entityManager.close();
            JOptionPane.showMessageDialog(null, "Hapus Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hapus Gagal");
        }
        jTextFieldISBN.setText("");
        jTextFieldJudul.setText("");
        jTextFieldTahun.setText("");
        jTextFieldPenerbit.setText("");

        tampil();
    }//GEN-LAST:event_jButtonHapusActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTableBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBukuMouseClicked
        int baris = jTableBuku.rowAtPoint(evt.getPoint());

        String isbn = jTableBuku.getValueAt(baris, 0).toString();
        jTextFieldISBN.setText(isbn);

        String judul = jTableBuku.getValueAt(baris, 1).toString();
        jTextFieldJudul.setText(judul);

        String tahun = jTableBuku.getValueAt(baris, 2).toString();
        jTextFieldTahun.setText(tahun);

        String penerbit = jTableBuku.getValueAt(baris, 3).toString();
        jTextFieldPenerbit.setText(penerbit);
    }//GEN-LAST:event_jTableBukuMouseClicked

    private void jButtonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCetakActionPerformed

        String jrxmlFile = "src/Pertemuan9/report1.jrxml";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan9PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Buku> cq = cb.createQuery(Buku.class);
        Root<Buku> stud = cq.from(Buku.class);
        cq.select(stud);

        TypedQuery<Buku> q = em.createQuery(cq);
        List<Buku> list = q.getResultList();
        Query query = em.createQuery("SELECT b FROM Buku b");
        List<Buku> result = query.getResultList();

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);

        try {
            // TODO add your handling code here:
            // JasperPrint jp = JasperFillManager.fillReport(jasperFile.getPath(), null, conn);
            JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, dataSource);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(TampilBuku.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jButtonCetakActionPerformed

    private void jButtonUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUploadActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser();
        EntityManager entityManager = Persistence.createEntityManagerFactory("Pertemuan9PU").createEntityManager();

        entityManager.getTransaction().begin();

        int i = filechooser.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            File f = filechooser.getSelectedFile();
            String filepath = f.getPath();
            String fi = f.getName();
            //Parsing CSV Data

            try {

                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filepath));
                org.apache.commons.csv.CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
                for (CSVRecord csvRecord : csvParser) {
                    Buku b = new Buku();

                    b.setIsbn(csvRecord.get(0));
                    b.setJudul(csvRecord.get(1));
                    b.setTahun(csvRecord.get(2));
                    b.setPenerbit(csvRecord.get(3));
                    entityManager.persist(b);

                }

            } catch (Exception ex) {
                System.out.println("Error in Parsing CSV File");
            }

        }
        entityManager.getTransaction().commit();
        tampil();
    }//GEN-LAST:event_jButtonUploadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TampilBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TampilBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TampilBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TampilBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TampilBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCetak;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JButton jButtonUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBuku;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldJudul;
    private javax.swing.JTextField jTextFieldPenerbit;
    private javax.swing.JTextField jTextFieldTahun;
    // End of variables declaration//GEN-END:variables
}
