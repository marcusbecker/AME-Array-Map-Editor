/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvbos.ame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Marcus Becker
 */
public class TilerMapJDialog extends javax.swing.JDialog {

    private JButton selected;
    private ImageIcon image;
    private final Timer timer;
    private final List<JButton> buttons = new ArrayList<>(10);

    private final Point grid = new Point(10, 10);
    private final AbstractListModel listModel;

    /**
     * Creates new form TilerMapJDialog
     */
    public TilerMapJDialog(Frame parent, boolean modal) {
        super(parent, modal);

        this.listModel = new AbstractListModel() {
            @Override
            public int getSize() {
                return buttons.size();
            }

            @Override
            public Object getElementAt(int i) {
                return buttons.get(i).getName();
            }
        };

        initComponents();

        timer = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pnCanvas.repaint();
            }
        });

        timer.start();
    }

    private void updateSelected() {
        for (JButton b : buttons) {
            if (b.equals(selected)) {
                b.setBackground(new Color(0, 102, 204));
                //b.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204)));
            } else {
                b.setBackground(btnOK.getBackground());
                //b.setBorder(BorderFactory.createEmptyBorder());
            }
        }

        tfBtnValue.setText(selected.getName());
    }

    private void change() {
        tfBtnValue.setText(null);
        selected = null;
        for (JButton b : buttons) {
            pnButtons.remove(b);
        }
        buttons.clear();

        grid.x = Integer.parseInt(tfColumns.getText());
        grid.y = Integer.parseInt(tfLines.getText());

        if ((image == null && !tfFile.getText().isEmpty())) {
            File f = new File(tfFile.getText());
            if (f.exists() && f.isFile()) {
                image = new ImageIcon(f.getAbsolutePath());
            }
        }

        if (grid.x > 0 && grid.y > 0) {

            pnButtons.setLayout(new GridLayout(grid.y, grid.x));

            int alpha = 'A';

            int x = image.getIconWidth() / grid.x;
            int y = image.getIconHeight() / grid.y;

            for (int lin = 0; lin < grid.y; lin++) {
                for (int col = 0; col < grid.x; col++) {
                    BufferedImage bi = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g = bi.createGraphics();
                    //g.drawImage(image.getImage(), i * x, j * y, null);
                    int px = col * x;
                    int py = lin * y;
                    //g.drawImage(image.getImage(), px, py, px + x, py + y, null);

                    g.drawImage(image.getImage(), 0, 0, x, y, px, py, px + x, py + y, null);

                    //System.out.printf("x %d y %d px %d py %d\n", x, y, px, py);
                    bi.flush();
                    g.dispose();

                    ImageIcon img = new ImageIcon(bi);

                    JButton btn = new JButton();
                    btn.setText("");
                    btn.setName(String.format("%s%d", (char) (alpha + lin), col));
                    btn.setToolTipText(String.format("Lin.: %d Col.: %d", lin + 1, col + 1));
                    btn.setIcon(img);

                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("0 " + selected);
                            selected = (JButton) e.getSource();
                            updateSelected();
                        }
                    });

                    buttons.add(btn);
                }
            }

            for (JButton b : buttons) {
                pnButtons.add(b);
                //jListValues.add(b);
            }

            pnButtons.updateUI();
            jListValues.updateUI();
        }
    }

    private JPanel createCanvas() {
        JPanel c = new JPanel() {

            @Override
            public void paint(Graphics gg) {
                super.paint(gg);

                Graphics2D g = (Graphics2D) gg;

                if (image != null) {

                    g.scale(slZoom.getValue(), slZoom.getValue());
                    g.drawImage(image.getImage(), 0, 0, null);

                    g.setColor(Window.line);

                    if (grid.x > 0 && grid.y > 0) {
                        int x = image.getIconWidth() / grid.x;
                        int y = image.getIconHeight() / grid.y;

                        for (int i = 0; i < image.getIconHeight(); i += y) {
                            g.drawLine(0, i, image.getIconWidth(), i);
                        }

                        for (int i = 0; i < image.getIconWidth(); i += x) {
                            g.drawLine(i, 0, i, image.getIconHeight());
                        }
                    }
                }
            }

        };

        c.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //start = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //start = null;
                //end = e.getPoint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.print("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //System.out.print("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        c.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        return c;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfFile = new javax.swing.JTextField();
        btnFC = new javax.swing.JButton();
        tfLines = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfColumns = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        pnCanvas = createCanvas();
        jLabel2 = new javax.swing.JLabel();
        slZoom = new javax.swing.JSlider();
        pnButtons = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListValues = new javax.swing.JList();
        pnBottom = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfBtnValue = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tiles map");

        tfFile.setText("C:\\Users\\Marcus Becker\\Documents\\GitHub\\logica-jogo\\book\\resources\\cap07\\tiles_cenario.png");

        btnFC.setText("Image...");
        btnFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFCActionPerformed(evt);
            }
        });

        tfLines.setText("5");

        jLabel1.setText("Columns:");

        tfColumns.setText("9");

        btnOK.setText("Update");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        pnCanvas.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout pnCanvasLayout = new javax.swing.GroupLayout(pnCanvas);
        pnCanvas.setLayout(pnCanvasLayout);
        pnCanvasLayout.setHorizontalGroup(
            pnCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnCanvasLayout.setVerticalGroup(
            pnCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jLabel2.setText("Lines:");

        slZoom.setMaximum(10);
        slZoom.setMinimum(1);
        slZoom.setMinorTickSpacing(1);
        slZoom.setPaintLabels(true);
        slZoom.setPaintTicks(true);
        slZoom.setSnapToTicks(true);
        slZoom.setValue(1);

        pnButtons.setLayout(new java.awt.GridLayout(5, 10));

        jListValues.setModel(listModel);
        jListValues.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListValues.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListValuesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListValues);

        jLabel3.setText("Tile button value:");

        tfBtnValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBtnValueKeyReleased(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBottomLayout = new javax.swing.GroupLayout(pnBottom);
        pnBottom.setLayout(pnBottomLayout);
        pnBottomLayout.setHorizontalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBottomLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBtnValue, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBottomLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        pnBottomLayout.setVerticalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfBtnValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slZoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnCanvas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(tfFile, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfLines, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfColumns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfColumns, tfLines});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFC)
                    .addComponent(tfLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tfColumns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slZoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFCActionPerformed
        JFileChooser fc = new JFileChooser(tfFile.getText());
        fc.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.isFile() && f.getName().toLowerCase().endsWith(".png");
            }

            @Override
            public String getDescription() {
                return "*.png";
            }
        });

        if (fc.showOpenDialog(this) == JFileChooser.OPEN_DIALOG) {
            tfFile.setText(fc.getSelectedFile().getAbsolutePath());
            image = new ImageIcon(tfFile.getText());
        }


    }//GEN-LAST:event_btnFCActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        change();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        dispose();

    }//GEN-LAST:event_btnSaveActionPerformed

    private void jListValuesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListValuesValueChanged
        if (evt.getValueIsAdjusting()) {
            selected = buttons.get(jListValues.getSelectedIndex());
            updateSelected();
        }
    }//GEN-LAST:event_jListValuesValueChanged

    private void tfBtnValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBtnValueKeyReleased
        if (selected != null) {
            selected.setName(tfBtnValue.getText());
            jListValues.updateUI();
        }
    }//GEN-LAST:event_tfBtnValueKeyReleased

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
            java.util.logging.Logger.getLogger(TilerMapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TilerMapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TilerMapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TilerMapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TilerMapJDialog dialog = new TilerMapJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFC;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jListValues;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnBottom;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnCanvas;
    private javax.swing.JSlider slZoom;
    private javax.swing.JTextField tfBtnValue;
    private javax.swing.JTextField tfColumns;
    private javax.swing.JTextField tfFile;
    private javax.swing.JTextField tfLines;
    // End of variables declaration//GEN-END:variables

    public boolean isOk() {
        return true;
    }

    public List<JButton> getList() {
        return buttons;
    }
}
