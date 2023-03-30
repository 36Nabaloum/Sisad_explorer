/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetjtable;

import java.sql.PreparedStatement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;

import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import javax.swing.table.TableRowSorter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
/**
 *
 * @author HP
 */
public class JTablePro extends javax.swing.JFrame {

    /** Creates new form JTablePro */
    public static ArrayList<ProjetJTable> List;
    
    public JTablePro() {
        super("Add for Data Base management");
        List=new ArrayList();
         DefaultTableModel Tab;
          
          
        initComponents();
       
        ImageIcon ic=new  ImageIcon("G:\\LOGICIELS\\netbeans\\java Swing\\JMenuBar\\icons\\about.png");
        this.setIconImage(ic.getImage());
        
        //charger lefichier
         File charge= new File("C:\\Users\\HP\\Desktop\\emile\\FichierV");
         
        try {
            BufferedReader chargeLire=new BufferedReader(new FileReader(charge));
            String liree;
            while ((liree=chargeLire.readLine())!=null) {
                
                    String[] afficher=liree.split(";");
                    ProjetJTable pro1=new ProjetJTable(afficher[0],afficher[1],Integer.parseInt(afficher[2]));
                    List.add(pro1);
            
            }
        } 
        catch (FileNotFoundException ex) {
                    Logger.getLogger(JTablePro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                    Logger.getLogger(JTablePro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      //permet de charger les donner sur excel
        for (ProjetJTable lis : List) {
                    String listSa=String.valueOf(lis.getSalaire());
                    String TabeL[]={lis.getNom(),lis.getPrenom(),listSa};
                DefaultTableModel Table = (DefaultTableModel) jTable1.getModel();
                Table.addRow(TabeL);
                }
        
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
    }
private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook){
         HSSFFont font=workbook.createFont();
         font.setBold(true);
         HSSFCellStyle style=workbook.createCellStyle();
         style.setFont(font);
                  
return style;}

      Connection conn;
      PreparedStatement prepa;
      ResultSet resul;
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        salaire = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        filtre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("G:\\LOGICIELS\\netbeans\\java Swing\\JMenuBar\\icons\\save.png")); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("G:\\LOGICIELS\\netbeans\\java Swing\\JMenuBar\\icons\\about.png")); // NOI18N
        jButton2.setText("Charge Export Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjtable/save_as.png"))); // NOI18N
        jButton4.setText("ADD JDBC");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prenom", "Salaire", "Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("Nom");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Prenom");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Salaire");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenom)
                            .addComponent(nom)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(salaire, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(salaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("Filter Database(by Salary)");

        filtre.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                filtreHierarchyChanged(evt);
            }
        });
        filtre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtreKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(filtre, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        try {
            
            //enregistre les donnee dans la classe projetJTable et dans mon arraylist
            int sal=Integer.parseInt(salaire.getText());
            ProjetJTable pro=new ProjetJTable(nom.getText(),prenom.getText(),sal);
            List.add(pro);
            
            //ecrire les donnees dans un fichier
            Path file=Paths.get("C:\\Users\\HP\\Desktop\\emile","FichierV");
            String ecrire=nom.getText()+";"+prenom.getText()+";"+sal+"\n";
            Files.write(file, ecrire.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND); 
         
            //enregistrer les données dans un JTable
            if(nom.getText().equals("")||prenom.getText().equals("")||salaire.getText().equals("")){
                    JOptionPane.showMessageDialog(this,"veuillez saisr tout les champs");
        }else{
                String Tabe[]={nom.getText(),prenom.getText(),salaire.getText()};
                DefaultTableModel Table = (DefaultTableModel) jTable1.getModel();
                Table.addRow(Tabe);
                
                JOptionPane.showMessageDialog(this,"saisie reusie");
            }
                
           //supprimer les JtextField apres ajout
        nom.setText("");
        prenom.setText("");
        salaire.setText(""); 

        } catch (IOException ex) {
            Logger.getLogger(JTablePro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        //declaraion de la creation du claseur
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet();
        
        int rownum=0;
        //creation des lignes de la feuille decalcul
        HSSFCellStyle style=createStyleForTitle(workbook);
        HSSFRow ligne = sheet.createRow(rownum);
        
        //creation des ligne de ma feuille de calcule
        //1---premiere colone de la feuille Nom
        HSSFCell cellule=ligne.createCell(0,CellType.STRING);
        cellule.setCellValue("Nom");
        cellule.setCellStyle(style);
        
        //2---creation de la deuxieme colone
        HSSFCell cellule1=ligne.createCell(1,CellType.STRING);
        cellule1.setCellValue("Prenom");
        cellule1.setCellStyle(style);
        
        //3--creation de la troisieme colone
        HSSFCell cellule2=ligne.createCell(2,CellType.STRING);
        cellule2.setCellValue("Salaire");
        cellule2.setCellStyle(style);
        
        
        for (ProjetJTable lis : List) {
            rownum++;
            ligne=sheet.createRow(rownum);
            
         cellule=ligne.createCell(0,CellType.STRING);
        cellule.setCellValue(lis.getNom());
        
        cellule1=ligne.createCell(1,CellType.STRING);
        cellule1.setCellValue(lis.getPrenom());
        
        cellule2=ligne.createCell(2,CellType.STRING);
        cellule2.setCellValue(lis.getSalaire());
        }
        
        //creation de la feuille excel nommmer personne.xls
            File file=new File("C:\\Users\\HP\\Desktop\\emile\\personne.xls");
                file.getParentFile().mkdirs();     
        try {
            //ecriture dans le fichier
            FileOutputStream oufile=new FileOutputStream(file);
            workbook.write(oufile);
            System.out.println("Created file:"+file.getAbsolutePath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JTablePro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JTablePro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

            //enregistre les donnee dans la classe projetJTable et dans mon arraylist
            int sal=Integer.parseInt(salaire.getText());
//                     ProjetJTable pro=new ProjetJTable(nom.getText(),prenom.getText(),sal);
//                     List.add(pro);
//           //JTablerecuperer les donner dans mon jtable
//            if(nom.getText().equals("")||prenom.getText().equals("")||salaire.getText().equals("")){
//                    JOptionPane.showMessageDialog(this,"veuillez saisr tout les champs");
//            }else{
//                    String Tabe[]={nom.getText(),prenom.getText(),salaire.getText()};
//                    DefaultTableModel Table = (DefaultTableModel) jTable1.getModel();
//                    Table.addRow(Tabe);
//            }
            //connection a ma base mysql workbence avec java
                Connection conn = null;
                        try {     
                            String val1=nom.getText(); //valeur recupere de mes jtextfield
                             String val2=prenom.getText();
                              int val=Integer.parseInt(salaire.getText());

                        String url="jdbc:oracle:thin:@localhost:1521:xe"; //url de connecton a ma bes
                        String user = "reserve";
                        String password = "reserve";
                        conn = DriverManager.getConnection(url, user, password); //utilisation du drive manager pour la conncection
                        String inserte="INSERT INTO utilisateur VALUES (?,?,?)";
                        
                        //INSERT INTO `base`.`basev` (`nom`, `prenom`, `salaire`) VALUES (?,?,?)";//commendes pour l'insertion dans la base
                         java.sql.PreparedStatement emil=conn.prepareStatement(inserte); //en fin insere
                         emil.setString(1,val1);
                         emil.setString(2,val2); //recuperation des valeurs saisie par jtextied pour mysql 8.0.27
                         emil.setInt(3,val);
                         int i=emil.executeUpdate();// apres l'execution mettre à jour la table mysql
                         if(i!=0){ 
                             //System.out.println("add data succesffuly");
                             //JOptionPane.showMessageDialog(this,"insertion reusi");
                         JOptionPane.showMessageDialog(this,"add data succesffuly");
                         }
                         else{
                             System.out.println("falled to add data detail, revews");
                         }
                        }
                        catch(Exception e){ System.out.println(e);} 
                       
                        JOptionPane.showMessageDialog(this,"add data succesffuly");
           //supprimer les JtextField apres ajout
        nom.setText("");
        prenom.setText("");
        salaire.setText(""); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void filtreHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_filtreHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_filtreHierarchyChanged

  
    
    
    
    private void filtreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_filtreKeyReleased

    private void filtreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtreKeyTyped
     
        filtre.addKeyListener(new KeyAdapter() {
            DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
   TableRowSorter tsr=new TableRowSorter(table);
          @Override
          public void keyReleased(KeyEvent ke) {
              //super.keyReleased(ke); //To change body of generated methods, choose Tools | Templates.
               
            tsr.setRowFilter( RowFilter.regexFilter(filtre.getText(),0)); 
            jTable1.setRowSorter(tsr);
          }
          
      });
      
      
    }//GEN-LAST:event_filtreKeyTyped

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int selection=jTable1.rowAtPoint(evt.getPoint());
        nom.setText(String.valueOf(jTable1.getValueAt(selection,0)));
        prenom.setText(String.valueOf(jTable1.getValueAt(selection,1)));
        salaire.setText(String.valueOf(jTable1.getValueAt(selection,2)));
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(JTablePro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JTablePro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JTablePro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JTablePro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JTablePro().setVisible(true);
                /*for (ProjetJTable lis : List) {
                    System.out.printf(lis.getNom()+"  "+lis.getPrenom()+"  "+lis.getSalaire()+"\n");
                    
                }*/ //
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filtre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField prenom;
    private javax.swing.JTextField salaire;
    // End of variables declaration//GEN-END:variables

    

}
