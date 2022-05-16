/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingsystem;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author User
 */
public class Analytics extends javax.swing.JFrame {

    Object[] column = {"Item Name", "Cost", "Profit"};
    DefaultTableModel model = new DefaultTableModel();

    File file;
    FileInputStream fis;
    ObjectInputStream ois;

    FileOutputStream fos;
    ObjectOutputStream oos;

    ArrayList<Buisiness> buisinesses = new ArrayList<>();

    ArrayList<String> itemNames = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
    ArrayList<Double> totalProfit = new ArrayList<>();

    ArrayList<Item> items = new ArrayList<>();

    DefaultCategoryDataset dataset;
    JFreeChart chart;

    public Analytics(ArrayList<Item> items,AddItems reference) {
        initComponents();
        this.items = items;

        model.setColumnIdentifiers(column);
        jTable.setModel(model);

        readBusinessData();
        addToList();
        setDate();

        for (int i = 0; i < itemNames.size(); i++) {
            Object[] row = new Object[3];
            row[0] = itemNames.get(i);
            row[1] = quantity.get(i);
            row[2] = totalProfit.get(i);
            model.addRow(row);

        }

        // System.out.println(itemNames.size());
        // System.out.println(buisinesses.size());
        for (Item i : this.items) {
            System.out.println(i.getName());
        }

        showPanelGraph();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
   WindowListener exitListener = new WindowAdapter() {

    @Override
    public void windowClosing(WindowEvent e) {
       
       reference.isAnaliticsSelected=false; 
         
    }
};
        
        this.addWindowListener(exitListener); 
        
    }

    private void showPanelGraph() {

        dataset = new DefaultCategoryDataset();

        for (int i = 0; i < itemNames.size(); i++) {

            dataset.setValue(Integer.valueOf(quantity.get(i)), "Quantity", itemNames.get(i));
        }
        chart = ChartFactory.createBarChart("Daily Chart", "Item Name", "Quantity", dataset, PlotOrientation.VERTICAL, false, true, false);
        ChartPanel myChart = new ChartPanel(chart);
        myChart.setMouseWheelEnabled(true);
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(myChart, BorderLayout.CENTER);
        jPanel1.validate();

    }

    private Analytics() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void resetBusinessData() {

        buisinesses.clear();
        itemNames.clear();
        quantity.clear();
        totalProfit.clear();
        model.setRowCount(0);
        dataset.clear();

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            for (Buisiness b : buisinesses) {
                oos.writeObject(b);
            }

            JOptionPane.showMessageDialog(null, "All business data cleared !", "Info" + " ", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {

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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        datePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        toDate = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analytics");
        setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel2.setBackground(new java.awt.Color(163, 211, 211));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item Name", "Total Sells", "Profit"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jTabbedPane1.addTab("Daily Chart", jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Graph", jPanel1);

        datePanel.setBackground(new java.awt.Color(163, 211, 211));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Date : ");

        date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        date.setText("yyyy/MM/dd");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("To");

        toDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        toDate.setText("yyyy/MM/dd");

        javax.swing.GroupLayout datePanelLayout = new javax.swing.GroupLayout(datePanel);
        datePanel.setLayout(datePanelLayout);
        datePanelLayout.setHorizontalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(toDate)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        datePanelLayout.setVerticalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datePanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(date)
                    .addComponent(jLabel2)
                    .addComponent(toDate))
                .addContainerGap())
        );

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        save.setText("Save Graph");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(save)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(datePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(save))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Do you want to reset all business data ?", "Clear", dialogButton);
        if (dialogResult == 0) {
            resetBusinessData();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection()); 
         
        
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new java.io.File("C:/"));
        fc.setDialogTitle("Select Folder");  
        fc.setFileFilter(new FileTypeFilter(".png","Image File"));
       // fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int result = fc.showSaveDialog(null); 
       
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File file1 = new File(fc.getSelectedFile().getPath());
            
                try
           {
                ChartUtilities.saveChartAsPNG(file1, chart, 900, 600,info); 
                
                
           }catch(Exception ex)
           {
               
           }
        }

    }//GEN-LAST:event_saveActionPerformed

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
            java.util.logging.Logger.getLogger(Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analytics().setVisible(true);
            }
        });
    }

    private void readBusinessData() {
        try {
            file = new File("bin/business.bin");
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            boolean isExist = true;

            while (isExist) {
                if (fis.available() != 0) {
                    Buisiness bitm = (Buisiness) ois.readObject();
                    buisinesses.add(bitm);

                } else {
                    isExist = false;
                }
            }

        } catch (Exception ex) {

        }

    }

    private void setDate() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        if(buisinesses.size()>0)
        {
             date.setText(buisinesses.get(0).getDate());
             toDate.setText(dtf.format(now));
        }else
        {
            
        }
       
        

    }

    private void addToList() {

        itemNames.clear();
        quantity.clear();
        totalProfit.clear();

        for (Buisiness b : buisinesses) {
            ArrayList<String> names = new ArrayList<>();
            ArrayList<String> qty = new ArrayList<>();

            names = b.getItemName();
            qty = b.getQuantity();

            for (int i = 0; i < names.size(); i++) {
                int k = isInList(names.get(i));
                if (k > -1) {
                    int n = Integer.valueOf(quantity.get(k));
                    n += Integer.valueOf(qty.get(i));

                    itemNames.set(k, names.get(i));
                    quantity.set(k, String.valueOf(n));
                    totalProfit.set(k, n * getItemCost(names.get(i)));

                } else {
                    itemNames.add((itemNames.size()), names.get(i));
                    quantity.add((quantity.size()), qty.get(i));
                    totalProfit.add(Integer.valueOf(qty.get(i)) * getItemCost(names.get(i)));
                }

            }

        }
    }

    private double getItemCost(String itemName) {
        for (Item i : items) {
            if (i.getName().equals(itemName)) {
                return i.getCost();
            }
        }
        return -1;
    }

    private int isInList(String key) {
        for (int i = 0; i < itemNames.size(); i++) {
            if (itemNames.get(i).equals(key)) {
                return i;
            }
        }
        return -1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JPanel datePanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton save;
    private javax.swing.JLabel toDate;
    // End of variables declaration//GEN-END:variables
}
