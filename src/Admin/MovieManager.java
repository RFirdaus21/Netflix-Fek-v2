package Admin;

import API.FilmApiHandler;
import Helper.ImageRemover;
import Model.FilmRequestResponse;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rfirdaus
 */
public class MovieManager extends javax.swing.JFrame {
    private int movieId;
    /**
     * Creates new form MovieManager
     */
    public MovieManager() {
        initComponents();
        this.initTable();
        
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
   
    private void initTable() {
            DefaultTableModel tableModelMovies = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            FilmApiHandler api = new FilmApiHandler();
            List<FilmRequestResponse> users = api.getAll();

            String[] columnNames = { "id", "title", "year", "director", "genre", "cast", "synopsis", "image"};
            tableModelMovies.setColumnIdentifiers(columnNames);

            for (FilmRequestResponse film : users) {
                Object[] rowData = new Object[columnNames.length];
                rowData[0] = film.getId();
                rowData[1] = film.getTitle();
                rowData[2] = film.getYear();
                rowData[3] = film.getDirector();
                rowData[4] = film.getGenre();
                rowData[5] = film.getCast();
                rowData[6] = film.getSynopsis();
                rowData[7] = film.getImage();
                tableModelMovies.addRow(rowData);
            }

            tableMovies.setModel(tableModelMovies);
    }
     
     private void resetTableMovie(){
         this.initTable();
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btn_movieAdd = new javax.swing.JButton();
        btn_movieRemove = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMovies = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel5.setText("Movies List");

        btn_movieAdd.setText("Add");
        btn_movieAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_movieAddMouseClicked(evt);
            }
        });

        btn_movieRemove.setText("Remove");
        btn_movieRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_movieRemoveMouseClicked(evt);
            }
        });

        btn_back.setText("<<");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        tableMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Title", "Year", "Director", "Genre", "Cast", "Synopsis", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMoviesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMovies);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_back)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(btn_movieAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_movieRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_movieAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_movieRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        new AdminPage().setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void tableMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMoviesMouseClicked
        int selectedRow = tableMovies.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tableMovies.getModel();
            
            this.setMovieId(Integer.parseInt(model.getValueAt(selectedRow, 0).toString()));
        }
    }//GEN-LAST:event_tableMoviesMouseClicked

    private void btn_movieRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_movieRemoveMouseClicked
        FilmApiHandler api = new FilmApiHandler();
        FilmRequestResponse film = api.getById(this.getMovieId());
        boolean success = api.delete(this.getMovieId());
        
        if(!success){
            JOptionPane.showMessageDialog(null,"Failed Delete Movie");
            return;
        }
        
        boolean succesRemoveImage = ImageRemover.getInstance().removeImage(film.getImage());
        
        if(!succesRemoveImage){
            JOptionPane.showMessageDialog(null,"Failed Delete Movie");
            return;
        }
        
        this.resetTableMovie();
        JOptionPane.showMessageDialog(null,"Success Delete Movie");
    }//GEN-LAST:event_btn_movieRemoveMouseClicked

    private void btn_movieAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_movieAddMouseClicked
        dispose();
        new AddMovie().setVisible(true);
    }//GEN-LAST:event_btn_movieAddMouseClicked

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
            java.util.logging.Logger.getLogger(MovieManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovieManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_movieAdd;
    private javax.swing.JButton btn_movieRemove;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableMovies;
    // End of variables declaration//GEN-END:variables
}
