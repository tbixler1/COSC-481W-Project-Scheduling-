/*
 * This is the main screen for the ENTIRE math lab scheduler
 * From here, all needed edits, saves, and opening of files
 * can be done.
 */
package senior.project;

import java.awt.Desktop;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.showMessageDialog;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
/**
 *
 * @author andre
 */
public class frontScreen extends javax.swing.JFrame {

    /**
     * Creates new form frontScreen
     */
    public frontScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tutorProfileListNewButton = new javax.swing.JButton();
        tutorProfileListOpenButton = new javax.swing.JButton();
        tutorProfileListBox = new javax.swing.JComboBox();
        tutorProfileListBox.setVisible(false);
        scheduleInProgressNewButton = new javax.swing.JButton();
        scheduleInProgressOpenButton = new javax.swing.JButton();
        finishedScheduleBuildButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        rulesModifyButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");

        tutorProfileListNewButton.setText("New Tutor List");
        tutorProfileListNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorProfileListNewButtonActionPerformed(evt);
            }
        });

        tutorProfileListOpenButton.setText("Open Tutor List");
        tutorProfileListOpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorProfileListOpenButtonActionPerformed(evt);
            }
        });

        tutorProfileListBox.setMaximumRowCount(20);
        tutorProfileListBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "new" }));
        tutorProfileListBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tutorProfileListBoxMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tutorProfileListBoxMousePressed(evt);
            }
        });
        tutorProfileListBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorProfileListBoxActionPerformed(evt);
            }
        });

        scheduleInProgressNewButton.setText("New Schedule");
        scheduleInProgressNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scheduleInProgressNewButtonMouseClicked(evt);
            }
        });
        scheduleInProgressNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleInProgressNewButtonActionPerformed(evt);
            }
        });

        scheduleInProgressOpenButton.setText("Open Schedule");
        scheduleInProgressOpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleInProgressOpenButtonActionPerformed(evt);
            }
        });

        finishedScheduleBuildButton.setText("Build Schedule");
        finishedScheduleBuildButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishedScheduleBuildButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Open Schedule");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        rulesModifyButton.setText("Modify Scheduling Rules & Preferences");
        rulesModifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rulesModifyButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Profiles");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setText("No .sch Currently Open");

        jButton1.setText("Clone List");
        jButton1.setMaximumSize(new java.awt.Dimension(121, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(121, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lab Info");

        jButton3.setText("?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("?");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("?");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("?");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rulesModifyButton)
                                .addGap(18, 20, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tutorProfileListBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tutorProfileListOpenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tutorProfileListNewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(finishedScheduleBuildButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(scheduleInProgressOpenButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(scheduleInProgressNewButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tutorProfileListNewButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tutorProfileListOpenButton)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tutorProfileListBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scheduleInProgressNewButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scheduleInProgressOpenButton))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(finishedScheduleBuildButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rulesModifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tutorProfileListBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorProfileListBoxActionPerformed
        // TODO add your handling code here:
        //Tutor drop down list
        //if the user selects the first item, "new", create a new tutor
        if(tutorProfileListBox.getSelectedItem() == tutorProfileListBox.getItemAt(0))
        {
            //System.out.println("new tutor is selected");
            //create new tutor and display their editting window
            newTutor = new TutorInfo(database, pathTut, rules);
            newTutor.setVisible(true);
            //save tutor to global variable
            tutorList.add(newTutor);
        }
        else
        {
            //if a person is selected, find that person in the global variable
            //and display that tutor's window
            int index = tutorProfileListBox.getSelectedIndex();
            tutorList.get(index-1).setVisible(true);
        }
    }//GEN-LAST:event_tutorProfileListBoxActionPerformed

    private void scheduleInProgressNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleInProgressNewButtonActionPerformed
        // TODO add your handling code here:
        //New Schedule Button
        //ask for file name to save a new schedule to
        JFileChooser fc = new JFileChooser();
        int choice = fc.showSaveDialog(null);
        //if user hits save button...
        if(choice == JFileChooser.APPROVE_OPTION)
        {
            //System.out.println("rdtfhvghbjn");
            //get file name with .sch extention
            pathSch=fc.getSelectedFile().getAbsolutePath()+".sch";
            //System.out.println(pathSch);
            //change the label name to this file path location
            jLabel2.setText(pathSch);
            //create a schedule object and make it visible
            //takes a few seconds to initialize 7*24 LabStats objects, so
            //display a "Please Wait" window until the schedule is ready
            PleaseWait waitMessage = new PleaseWait();
            waitMessage.setVisible(true);
            
            openSchedule = new Schedule(true, pathSch);
            openSchedule.setVisible(true);
            waitMessage.setVisible(false);
        }
    }//GEN-LAST:event_scheduleInProgressNewButtonActionPerformed

    private void finishedScheduleBuildButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishedScheduleBuildButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finishedScheduleBuildButtonActionPerformed

    private void rulesModifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulesModifyButtonActionPerformed
        // TODO add your handling code here:
        rules.setVisible(true);
    }//GEN-LAST:event_rulesModifyButtonActionPerformed

    private void scheduleInProgressNewButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleInProgressNewButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_scheduleInProgressNewButtonMouseClicked

    private void scheduleInProgressOpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleInProgressOpenButtonActionPerformed
        // TODO add your handling code here:
        //Open Schedule Button
        //ask for file name to save a new schedule to
        do
        {
            JFileChooser fc = new JFileChooser();
            int choice = fc.showOpenDialog(null);
            if(choice == JFileChooser.APPROVE_OPTION)
            {
                //System.out.println("rdtfhvghbjn");

                //get file name
                pathSch=fc.getSelectedFile().getAbsolutePath();

                if(pathSch.endsWith(".sch"))
                {
                    //change the label name to this file path location
                    jLabel2.setText(pathSch);
                    //create a schedule object and make it visible
                    //takes a few seconds to initialize 7*24 LabStats objects, so
                    //display a "Please Wait" window until the schedule is ready
                    PleaseWait waitMessage = new PleaseWait();
                    waitMessage.setVisible(true);

                    openSchedule = new Schedule(false, pathSch);
                    openSchedule.setVisible(true);
                    waitMessage.setVisible(false);
                }
                else
                    showMessageDialog(null, "ERROR: Chosen file must have extention:  .sch\nPlease try again");
            }
        } while(!pathSch.endsWith(".sch"));
    }//GEN-LAST:event_scheduleInProgressOpenButtonActionPerformed

    private void tutorProfileListNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorProfileListNewButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int choice = fc.showSaveDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION)
        {
            Scanner stdin = new Scanner(System.in);
            pathTut=fc.getSelectedFile().getAbsolutePath();
            int index = pathTut.lastIndexOf('\\');
            pathTut = pathTut.substring(0, index);
            //System.out.println(pathTut);
            
            database = new seniorDatabase(pathTut);
            tutorList.clear();
            while(tutorProfileListBox.getItemCount() > 1)
                tutorProfileListBox.removeItemAt(1);
            //tutorProfileListBox.addItem("new");
            
            tutorProfileListBox.setVisible(true);
        }
    }//GEN-LAST:event_tutorProfileListNewButtonActionPerformed

    private void tutorProfileListBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tutorProfileListBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tutorProfileListBoxMouseClicked

    private void tutorProfileListBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tutorProfileListBoxMousePressed
        // TODO add your handling code here:
        //this triggers when the mouse clicks to open the tutor drop down list
        //if there's a tutor waiting to be added to the drop down visually...
        if(tutorProfileListBox.getItemCount() == tutorList.size())
        {
            //System.out.println(tutorProfileListBox.getItemCount()+"  "+tutorList.size());
            //add the last tutor to the drop down list
            tutorProfileListBox.addItem(tutorList.get(tutorList.size()-1));
        }
    }//GEN-LAST:event_tutorProfileListBoxMousePressed

    private void tutorProfileListOpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorProfileListOpenButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int choice = fc.showOpenDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION)
        {
            //System.out.println("rdtfhvghbjn");
            pathTut=fc.getSelectedFile().getAbsolutePath();
            int index = pathTut.lastIndexOf('\\');
            pathTut = pathTut.substring(0, index);
            //System.out.println(pathTut);
            
            database = new seniorDatabase(pathTut);
            
            tutorList.clear();
            while(tutorProfileListBox.getItemCount() > 1)
                tutorProfileListBox.removeItemAt(1);
            
            //tutorProfileListBox.setVisible(true);
        //}
        
            // -> is called a lambda expression supported in java8
            File[] tutorFiles = new File(pathTut).listFiles((File dir, String name) -> name.endsWith(".tut"));
            //System.out.println(tutorFiles.length);
            PleaseWait wait = new PleaseWait();
            wait.setVisible(true);
            for(int i=0; i<tutorFiles.length; i++)
            {
                System.out.println(tutorFiles[i].getName());
                Object[] objArray = database.readDatabase(tutorFiles[i].getName());
                newTutor = new TutorInfo(database, pathTut, objArray, rules);
                tutorList.add(newTutor);
                //add the last tutor to the drop down list
                tutorProfileListBox.addItem(newTutor);

            }

    //        //create new tutor and display their editting window
    //        newTutor = new TutorInfo(database, pathTut);
    //        newTutor.setVisible(true);
    //        //save tutor to global variable
    //        tutorList.add(newTutor);
            wait.setVisible(false);


            tutorProfileListBox.setVisible(true);
        }
    }//GEN-LAST:event_tutorProfileListOpenButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //TODO add your handling code here:
        //Open Excel file
        JFileChooser fc = new JFileChooser();
        int choice = fc.showOpenDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fc.getSelectedFile().getAbsolutePath()+".xls";
            
            try {
                //Workbook x = Workbook.getWorkbook(new File(path));
                WritableWorkbook wBook = Workbook.createWorkbook(new File(path));
                WritableSheet sheet = wBook.createSheet("tSHEET",0);
//                for(int i=0; i<7; i++)
//                    sheet.setColumnView(i, 30);
                sheet.addCell(new Label(1,1,"test\nhsdjbhsh\n",new WritableCellFormat(new WritableFont(WritableFont.TIMES,12))));
                sheet.addCell(new Label(1,2,"test\nhsdjbhsh\n",new WritableCellFormat(new WritableFont(WritableFont.TIMES,12))));
                
                wBook.write();
                wBook.close();
                
                
                
            } catch (Exception ex) {
                Logger.getLogger(frontScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            //opens file with default program associated with that file type
            try {
                Desktop.getDesktop().open(new File(path));
            } catch (IOException ex) {
                //Logger.getLogger(frontScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Clone Tutor List Box
//        JFileChooser fc = new JFileChooser();
//        int choice = fc.showSaveDialog(null);
//        if(choice == JFileChooser.APPROVE_OPTION)
//        {
//            Scanner stdin = new Scanner(System.in);
//            pathTut=fc.getSelectedFile().getAbsolutePath();
//            int index = pathTut.lastIndexOf('\\');
//            pathTut = pathTut.substring(0, index);
//            //System.out.println(pathTut);
//            
//            database = new seniorDatabase(pathTut);
//            tutorList.clear();
//            while(tutorProfileListBox.getItemCount() > 1)
//                tutorProfileListBox.removeItemAt(1);
//            //tutorProfileListBox.addItem("new");
//            
//            tutorProfileListBox.setVisible(true);
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String s = "You clicked the help box for \"Student Profiles\"";
        new InfoBox(s).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String s = "You clicked the help box for \"Lab Info\"";
        new InfoBox(s).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String s = "You clicked the help box for \"Rules and Preferrences\"";
        new InfoBox(s).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String s = "You clicked the help box for \"Schedule Creation\"";
        new InfoBox(s).setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(frontScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frontScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frontScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frontScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frontScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton finishedScheduleBuildButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton rulesModifyButton;
    private javax.swing.JButton scheduleInProgressNewButton;
    private javax.swing.JButton scheduleInProgressOpenButton;
    private javax.swing.JComboBox tutorProfileListBox;
    private javax.swing.JButton tutorProfileListNewButton;
    private javax.swing.JButton tutorProfileListOpenButton;
    // End of variables declaration//GEN-END:variables
    //private variables
    private String pathSch;
    private String pathTut;
    private ArrayList<TutorInfo> tutorList = new ArrayList<TutorInfo>();
    private TutorInfo newTutor;
    private seniorDatabase database;
    private Rules rules = new Rules();
    private Schedule openSchedule;
}