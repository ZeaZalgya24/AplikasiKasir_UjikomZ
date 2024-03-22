/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasikasir_ujikomz;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.util.Date;
/**
 *
 * @author rps
 */
public class FromPenjualan extends javax.swing.JFrame {
Connection konek;
PreparedStatement pst,pst2;
ResultSet rst;
int inputstok,inputstok2,inputharga,inputjumlah,kurangstok,tambahstok;
String harga,idproduk,idprodukpenjualan,iddetail,jam,tanggal,subtotal;

    /**
     * Creates new form FromPenjualan
     */
    public FromPenjualan() {
        initComponents();
        konek = Koneksi.koneksiDB();
        tampilWaktu();
        
        detail();
        autonumber();
        subtotal();
    }
    private void simpan() {
String tgl = txtTanggal.getText();
String jam = txtJam.getText();
try {
  String sql = "insert into tbl_penjualan(PenjualanID,DetailID,TanggalPenjualan,JamPenjualan,TotalHarga) value (?,?,?,?,?)";
  pst = konek.prepareStatement(sql);
  pst.setString(1, txtidPenjualan.getText());
  pst.setString(2, iddetail);
  pst.setString(3, tgl);
  pst.setString(4, jam);
  pst.setString(5, txtTotal.getText());
  pst.execute();
  JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
} catch (Exception e) {
  JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
}
}

private void total() {
int total, bayar, kembalian;
total = Integer.parseInt(txtBayar.getText());
bayar = Integer.parseInt(txtTotal.getText());
kembalian = total - bayar;
String subtotal = String.valueOf(kembalian);
txtKembalian.setText(subtotal);
}

public void clear() {
txtJumlah.setText("");
}

public void cari() {
try {
  String sql = "select * from tbl_produk where ProdukID LIKE '%"+txtIdProduk.getText()+"%'";
  pst = konek.prepareStatement(sql);
  rst = pst.executeQuery();
  tblProduk.setModel(DbUtils.resultSetToTableModel(rst));
} catch (Exception e) {
  JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
}
}

private void kurangistok() {
int qty;
qty = Integer.parseInt(txtJumlah.getText());
kurangstok = inputstok - qty;
}

private void subtotal() {
int jumlah, sub;
jumlah = Integer.parseInt(txtJumlah.getText());
sub = jumlah * inputharga;
subtotal = String.valueOf(sub);
}

public void tampilWaktu(){
    Thread clock=new Thread(){
        public void run(){
            for(;;){
                Calendar cal=Calendar.getInstance();
                SimpleDateFormat jam=new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat tanggal=new SimpleDateFormat("yyyy-MM-dd");
                txtJam.setText(jam.format(cal.getTime()));
                 txtTanggal.setText(tanggal.format(cal.getTime()));
                
            try { sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FormPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
      };
    clock.start();
    }


public void tambahstok() {
tambahstok = inputjumlah + inputstok2;
try {
  String update= "update tbl_produk set Stok='"+tambahstok+"' where ProdukID='"+idproduk+"'";
  pst2 = konek.prepareStatement(update);
  pst2.execute();
} catch (Exception e) {
  JOptionPane.showMessageDialog(null, "Gagal Menambah Stok");
}
}

public void ambilstok() {
try {
  String sql = "select * from tbl_produk where ProdukID='"+idproduk+"'";
  pst = konek.prepareStatement(sql);
  rst = pst.executeQuery();
  if (rst.next()) {
  String stok = rst.getString(("Stok"));
  inputstok2 = Integer.parseInt(stok);
  }
} catch (Exception e) {
  JOptionPane.showMessageDialog(null, "Gagal Ambil Stok");
}
}

public void penjumlahan(){
        int totalBiaya = 0;
        int subtot;
        DefaultTableModel dataModel = (DefaultTableModel) tblPenjualan.getModel();
        int jumlah = tblPenjualan.getRowCount();
        for (int i=0; i<jumlah; i++){            
            subtot = Integer.parseInt(dataModel.getValueAt(i, 5).toString());
            totalBiaya += subtot;
        }
        txtTotal.setText(String.valueOf(totalBiaya));
    }

public void autonumber(){
    try{
        String sql = "SELECT MAX(RIGHT(PenjualanID,3)) AS NO FROM tbl_penjualan";
        pst=konek.prepareStatement(sql);
        rst=pst.executeQuery();
        while (rst.next()) {
                if (rst.first() == false) {
                    txtIdPenjualan.setText("IDP001");
                } else {
                    rst.last();
                    int auto_id = rst.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    for (int j = 0; j < 3 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    txtIdPenjualan.setText("IDP" + no);
                }
            }
        rst.close();
        }catch (Exception e){JOptionPane.showMessageDialog(null, "Gagal Menambah ID Penjualan");}
    }

public void detail() {
try {
  String ID_Detail = txtIdPenjualan.getText();
  String iddetail = "D" +ID_Detail;
  String sql = "select * from tbl_detailpenjualan where DetailID='"+iddetail+"'";
  pst = konek.prepareStatement(sql);
  rst = pst.executeQuery();
  tblPenjualan.setModel(DbUtils.resultSetToTableModel(rst));
} catch (Exception e) {
  JOptionPane.showMessageDialog(null, "Gagal Menambah ID Detail");
}
}
    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtJam = new java.awt.TextField();
        txtTanggal = new java.awt.TextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtProduk = new java.awt.TextField();
        btnCari = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtJumlah = new java.awt.TextField();
        btnTambah = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPenjualan = new javax.swing.JTable();
        txtPenjualan = new java.awt.TextField();
        btnHapus = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTotal = new java.awt.TextField();
        jLabel18 = new javax.swing.JLabel();
        txtBayar = new java.awt.TextField();
        txtKembalian = new java.awt.TextField();
        btnBayar = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        txtIdPenjualan = new javax.swing.JLabel();
        txtIDPenjualan1 = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-payment-64.png")); // NOI18N
        jLabel1.setText("FROM TRANSAKSI PENJUALAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 40, 940, 100);

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblProduk);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(70, 220, 331, 109);

        jLabel11.setText("masukan kode barang");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(70, 140, 117, 16);
        getContentPane().add(txtProduk);
        txtProduk.setBounds(80, 170, 117, 20);

        btnCari.setText("cari");
        getContentPane().add(btnCari);
        btnCari.setBounds(306, 150, 72, 23);

        jLabel13.setText("jumlah");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(420, 230, 37, 16);
        getContentPane().add(txtJumlah);
        txtJumlah.setBounds(480, 230, 88, 20);

        btnTambah.setText("tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambah);
        btnTambah.setBounds(410, 310, 72, 23);

        jLabel14.setText("kode transaksi");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(68, 341, 75, 16);

        jLabel15.setText("data transaksi");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(71, 389, 72, 16);

        tblPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblPenjualan);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(69, 417, 340, 108);
        getContentPane().add(txtPenjualan);
        txtPenjualan.setBounds(180, 380, 80, 20);

        btnHapus.setText("hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(427, 428, 72, 23);

        jLabel16.setText("total");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(82, 543, 24, 16);

        jLabel17.setText("bayar");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(82, 573, 29, 16);
        getContentPane().add(txtTotal);
        txtTotal.setBounds(151, 543, 89, 20);

        jLabel18.setText("kembalian");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(60, 615, 55, 16);
        getContentPane().add(txtBayar);
        txtBayar.setBounds(151, 569, 89, 20);
        getContentPane().add(txtKembalian);
        txtKembalian.setBounds(151, 611, 89, 20);

        btnBayar.setText("bayar");
        getContentPane().add(btnBayar);
        btnBayar.setBounds(530, 430, 72, 23);

        btnKeluar.setText("keluar");
        getContentPane().add(btnKeluar);
        btnKeluar.setBounds(630, 430, 72, 23);

        txtIdPenjualan.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\cod (2).jpg")); // NOI18N
        txtIdPenjualan.setText("jLabel2");
        getContentPane().add(txtIdPenjualan);
        txtIdPenjualan.setBounds(-80, -120, 930, 1030);
        getContentPane().add(txtIDPenjualan1);
        txtIDPenjualan1.setBounds(180, 341, 80, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
subtotal();
        kurangi_stok();
        try {
            String Kode_detail=txtIdPenjualan.getText();
            iddetail="D"+Kode_detail;
            String sql="insert into tbl_detailpenjualan (DetailID,ProdukID,Harga,JumlahProduk,Subtotal) value (?,?,?,?,?)";
            String update="update tbl_produk set Stok='"+kurangistok+"' where ProdukID='"+idproduk+"'";
            pst=konek.prepareStatement(sql);
            pst2=konek.prepareStatement(update);
            pst.setString(1, iddetail);
            pst.setString(2, idproduk);
            pst.setString(3, harga);
            pst.setString(4, txtJumlah.getText());
            pst.setString(5, sub_total);
            pst.execute();
            pst2.execute();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        detail();
        penjumlahan();
        cari();
        clsr();        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
try {
            String sql="delete from tbl_detailpenjualan where ProdukID=?";
            pst=konek.prepareStatement(sql);
            pst.setString(1, idprodukpenjualan);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        detail();
        penjumlahan();
        tambah_stok();
        cari();        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(FromPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblPenjualan;
    private javax.swing.JTable tblProduk;
    private java.awt.TextField txtBayar;
    private java.awt.TextField txtIDPenjualan1;
    private javax.swing.JLabel txtIdPenjualan;
    private java.awt.TextField txtJam;
    private java.awt.TextField txtJumlah;
    private java.awt.TextField txtKembalian;
    private java.awt.TextField txtPenjualan;
    private java.awt.TextField txtProduk;
    private java.awt.TextField txtTanggal;
    private java.awt.TextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
