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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author rps
 */
public class MenuUtama extends javax.swing.JFrame {
Connection konek;
PreparedStatement pst;
ResultSet rst;

    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        konek = Koneksi.koneksiDB();
 
       
    }
public void mulai(){
    Register.setEnabled(false);
    Logout.setEnabled(false);
    Master.setEnabled(false);
    Transaksi.setEnabled(false);
    RekapLaporan.setEnabled(false);
txtJam.setEnabled(false);
txtTanggal.setEnabled(false);
FromLogin.setVisible(false);
btnRegister.setEnabled(false);
btnProduk.setEnabled(false);
btnPelanggan.setEnabled(false);
btnPenjualan.setEnabled(false);
}
public void tampilanwaktu(){
Thread clock = new Thread(){
        public void run(){
        for(;;){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat Jam = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat Tanggal = new SimpleDateFormat("yy-mm-dd");
        txtJam.setText(Tanggal.format(cal.getTime()));
        txtTanggal.setText(Tanggal.format(cal.getTime()));
        try { sleep(1000);
        }catch (InterruptedException ex){
        Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        
        }
        }
        };
     clock.start();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnPelanggan = new javax.swing.JButton();
        btnProduk = new javax.swing.JButton();
        btnPenjualan = new javax.swing.JButton();
        FromLogin = new javax.swing.JInternalFrame();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBatal = new javax.swing.JButton();
        btnMasuk = new javax.swing.JButton();
        cmbAkses = new javax.swing.JComboBox<>();
        txtUsername = new java.awt.TextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtJam = new java.awt.TextField();
        txtTanggal = new java.awt.TextField();
        lbluser = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();
        labelUser = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        Register = new javax.swing.JMenu();
        Login = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Logout = new javax.swing.JMenuItem();
        Master = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        Transaksi = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        RekapLaporan = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Kasir ");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 51, 102));

        btnPelanggan.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-customer-30.png")); // NOI18N
        btnPelanggan.setText("Pelanggan\n");
        btnPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelangganActionPerformed(evt);
            }
        });

        btnProduk.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-product-30.png")); // NOI18N
        btnProduk.setText("Produk");
        btnProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdukActionPerformed(evt);
            }
        });

        btnPenjualan.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-sale-30.png")); // NOI18N
        btnPenjualan.setText("Penjualan");
        btnPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenjualanActionPerformed(evt);
            }
        });

        FromLogin.setVisible(true);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-password.gif")); // NOI18N
        jLabel7.setText("Password");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-equality-30.png")); // NOI18N
        jLabel8.setText("Hak Ases");

        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBatal.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-cancel-30.png")); // NOI18N
        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnMasuk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMasuk.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-login-30.png")); // NOI18N
        btnMasuk.setText("masuk");
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });

        cmbAkses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Salah Satu-", "User", "Admin" }));
        cmbAkses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAksesActionPerformed(evt);
            }
        });

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-login-50.png")); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-user-locked-32.png")); // NOI18N
        jLabel2.setText("Username");

        txtJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FromLoginLayout = new javax.swing.GroupLayout(FromLogin.getContentPane());
        FromLogin.getContentPane().setLayout(FromLoginLayout);
        FromLoginLayout.setHorizontalGroup(
            FromLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FromLoginLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(btnMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FromLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(FromLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FromLoginLayout.createSequentialGroup()
                    .addGap(0, 60, Short.MAX_VALUE)
                    .addGroup(FromLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FromLoginLayout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(FromLoginLayout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(FromLoginLayout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(FromLoginLayout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(cmbAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 169, Short.MAX_VALUE)))
        );
        FromLoginLayout.setVerticalGroup(
            FromLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FromLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FromLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                .addGroup(FromLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnMasuk))
                .addGap(17, 17, 17))
            .addGroup(FromLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FromLoginLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(20, 20, 20)
                    .addGroup(FromLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(16, 16, 16)
                    .addGroup(FromLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(FromLoginLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(24, 24, 24)
                    .addGroup(FromLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(cmbAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 87, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(FromLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPelanggan)
                        .addGap(62, 62, 62)
                        .addComponent(btnProduk)
                        .addGap(51, 51, 51)
                        .addComponent(btnPenjualan)
                        .addGap(46, 46, 46))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(FromLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProduk)
                    .addComponent(btnPenjualan)
                    .addComponent(btnPelanggan))
                .addGap(29, 29, 29))
        );

        lbluser.setBackground(new java.awt.Color(102, 255, 255));

        btnRegister.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-add-male-user-50.png")); // NOI18N
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        labelUser.setText("login disini");

        javax.swing.GroupLayout lbluserLayout = new javax.swing.GroupLayout(lbluser);
        lbluser.setLayout(lbluserLayout);
        lbluserLayout.setHorizontalGroup(
            lbluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbluserLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(lbluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUser))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        lbluserLayout.setVerticalGroup(
            lbluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbluserLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(labelUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbluser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 47, 6, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        Register.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-home-30 (1).png")); // NOI18N
        Register.setText("Beranda");

        Login.setText("login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        Register.add(Login);

        jMenuItem2.setText("Register");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Register.add(jMenuItem2);

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        Register.add(Logout);

        jMenuBar2.add(Register);

        Master.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-shop-30.png")); // NOI18N
        Master.setText("Master");

        jMenuItem4.setText("Produk");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Master.add(jMenuItem4);

        jMenuItem5.setText("Pelanggan");
        Master.add(jMenuItem5);

        jMenuBar2.add(Master);

        Transaksi.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-transaction-30.png")); // NOI18N
        Transaksi.setText("Transaksi");

        jMenuItem6.setText("Penjualan");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        Transaksi.add(jMenuItem6);

        jMenuBar2.add(Transaksi);

        RekapLaporan.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-report-30.png")); // NOI18N
        RekapLaporan.setText("Laporan");
        RekapLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RekapLaporanActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Rekapan Laporan");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        RekapLaporan.add(jMenuItem1);

        jMenuBar2.add(RekapLaporan);

        jMenu6.setIcon(new javax.swing.ImageIcon("C:\\Users\\rps\\Downloads\\icons8-about-30.png")); // NOI18N
        jMenu6.setText("help");

        jMenuItem3.setText("Tentang");
        jMenu6.add(jMenuItem3);

        jMenuBar2.add(jMenu6);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelangganActionPerformed
new FromPelanggan().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnPelangganActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
      FromLogin.setVisible(true);  // TODO add your handling code here:
    }//GEN-LAST:event_LoginActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
      new MenuUtama().setVisible(true);  // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
new FromRegister().setVisible(true);    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenjualanActionPerformed
new FromPenjualan().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnPenjualanActionPerformed

    private void btnProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdukActionPerformed
new FromProduk().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnProdukActionPerformed

    private void cmbAksesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAksesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAksesActionPerformed

    private void txtJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJamActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
new MenuUtama().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
try{
    String sql = "select *from login where Username='"+txtUsername.getText ()+"' and password='"+txtPassword.getText()+"' and HakAses='"+cmbAkses.getSelectedItem()+"' ";
    pst = konek.prepareStatement(sql);
    rst = pst.executeQuery();
    if(rst.next ()){
        if(txtUsername.getText().equals(rst.getString("Username"))&& txtPassword.getText().equals(rst.getString("Password"))&&cmbAkses.getSelectedItem().equals(rst.getString("HakAses")));
        if(cmbAkses.getSelectedItem().equals("admin"));
        
    }
    }catch (Exception e){
    JOptionPane.showMessageDialog(null,"login gagal");
    }
// TODO add your handling code here:
    }//GEN-LAST:event_btnMasukActionPerformed

    private void RekapLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RekapLaporanActionPerformed
new  LaporanTransaksi().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_RekapLaporanActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame FromLogin;
    private javax.swing.JMenuItem Login;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JMenu Master;
    private javax.swing.JMenu Register;
    private javax.swing.JMenu RekapLaporan;
    private javax.swing.JMenu Transaksi;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JButton btnPelanggan;
    private javax.swing.JButton btnPenjualan;
    private javax.swing.JButton btnProduk;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cmbAkses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelUser;
    private javax.swing.JPanel lbluser;
    private java.awt.TextField txtJam;
    private javax.swing.JPasswordField txtPassword;
    private java.awt.TextField txtTanggal;
    private java.awt.TextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
