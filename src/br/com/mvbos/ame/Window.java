package br.com.mvbos.ame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Marcus Becker
 */
public class Window extends javax.swing.JFrame {

    private final Timer timer;

    private final CodeWindow cw = new CodeWindow();
    private final Dimension grid = new Dimension();

    private String defVal = " ";
    private String valSel;

    private int index;
    private final List<String[][]> list = new ArrayList<>(10);

    private Point size = new Point(810, 600);

    private Point pxy = new Point(0, 0);

    private final Color front = Color.LIGHT_GRAY;
    private final Color back = new Color(248, 248, 248);
    private final Color line = new Color(0, 153, 255);
    private final Color fill = Color.DARK_GRAY;

    //private char[] copy;// = new char[18];
    //private Point start;
    //private Point end;
    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();

        //createCanvas();
        timer = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.repaint();
            }
        });

        timer.start();

        updateLabels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        canvas = createCanvas();
        jPanel3 = new javax.swing.JPanel();
        tfGridWid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfGridHei = new javax.swing.JTextField();
        btnLeft = new javax.swing.JButton();
        btnRigth = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnFillLine = new javax.swing.JToggleButton();
        btnFillColumn = new javax.swing.JToggleButton();
        lblIdx = new javax.swing.JLabel();
        lblCount = new javax.swing.JLabel();
        lblValueSelected = new javax.swing.JLabel();
        btnEmptyLinCol = new javax.swing.JToggleButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnDefault = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btnFill = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        lblPosition = new javax.swing.JLabel();
        btnCode = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miNewGrid = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        canvas.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tfGridWid.setText("0");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(" x ");

        tfGridHei.setText("0");

        btnLeft.setText("<");
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });

        btnRigth.setText(">");
        btnRigth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRigthActionPerformed(evt);
            }
        });

        btnRemove.setText("-");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnFillLine.setText("--");

        btnFillColumn.setText("|");

        lblIdx.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIdx.setText("100");

        lblCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCount.setText("100");

        lblValueSelected.setText("Value selected");

        btnEmptyLinCol.setText("#");

        pnDefault.setBackground(new java.awt.Color(204, 204, 204));
        pnDefault.setLayout(new java.awt.GridLayout(5, 5));

        btn1.setText("+");
        pnDefault.add(btn1);

        jTabbedPane1.addTab("Default", pnDefault);

        btnFill.setText("Fill");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblValueSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLeft)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIdx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRigth))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnFillLine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFillColumn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEmptyLinCol))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfGridWid)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfGridHei)
                            .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnLeft, btnRemove, btnRigth});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEmptyLinCol, btnFillColumn, btnFillLine});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValueSelected)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFillLine)
                    .addComponent(btnFillColumn)
                    .addComponent(btnEmptyLinCol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeft)
                    .addComponent(btnRigth)
                    .addComponent(lblIdx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove)
                    .addComponent(lblCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGridWid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfGridHei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnEmptyLinCol, btnFillColumn, btnFillLine, btnLeft, btnRemove, btnRigth});

        lblPosition.setText("0,0");

        btnCode.setText("View code");
        btnCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCode)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosition)
                    .addComponent(btnCode))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        miNewGrid.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        miNewGrid.setText("New");
        miNewGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewGridActionPerformed(evt);
            }
        });
        jMenu1.add(miNewGrid);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        list.add(newGrid(grid, defVal));
        index++;

        updateLabels();

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        go(-1);
    }//GEN-LAST:event_btnLeftActionPerformed

    private void btnRigthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRigthActionPerformed
        go(1);
    }//GEN-LAST:event_btnRigthActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        removeGrid();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodeActionPerformed
        viewCode();
    }//GEN-LAST:event_btnCodeActionPerformed

    private List<JButton> buttonValues = new ArrayList<>(5);

    private void miNewGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewGridActionPerformed

        NewGridJDialog dialog = new NewGridJDialog(this, true);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        if (!dialog.isOk()) {
            return;
        }

        for (JButton b : buttonValues) {
            pnDefault.remove(b);
        }
        list.clear();
        buttonValues.clear();

        grid.width = dialog.getGridWidth();
        grid.height = dialog.getGridHeight();
        tfGridWid.setText(String.valueOf(dialog.getGridWidth()));
        tfGridHei.setText(String.valueOf(dialog.getGridHeight()));

        defVal = dialog.getDefaultValue();
        valSel = defVal;
        list.add(newGrid(grid, defVal));

        JButton btn;

        btn = new JButton(dialog.getDefaultValue());
        btn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectValue(((JButton) evt.getSource()).getText());
            }
        });

        buttonValues.add(btn);

        for (String v : dialog.getValues()) {
            btn = new JButton(v);
            btn.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    selectValue(((JButton) evt.getSource()).getText());
                }
            });

            buttonValues.add(btn);
        }

        for (JButton b : buttonValues) {
            pnDefault.add(b);
        }

    }//GEN-LAST:event_miNewGridActionPerformed

    private void selectValue(String val) {
        valSel = val;
        lblValueSelected.setText(String.format("Value selected: %s", val));
    }

    private JPanel createCanvas() {
        JPanel c = new JPanel() {

            @Override
            public void paint(Graphics g) {
                if (list.isEmpty()) {
                    super.paint(g);
                    return;
                }

                size = new Point(getWidth(), getHeight());
                int x = size.x / grid.width;
                int y = size.y / grid.height;

                int sp = x / 4;

                //System.out.printf("x %d y %d - px %d py %d\n", x, y, getWidth(), getHeight());
                g.setColor(back);
                g.fillRect(0, 0, getWidth(), getHeight());

                String[][] gridArray = list.get(index);

                g.setColor(fill);

                for (int col = 0; col < gridArray.length; col++) {
                    for (int lin = 0; lin < gridArray[0].length; lin++) {
                        String value = gridArray[col][lin];

                        if (value != null) {

                            if (btnFill.isSelected() && !defVal.equals(value)) {
                                g.setColor(fill);
                                g.fillRect(col * x, lin * y, x, y);
                                g.setColor(back);
                            }

                            /*if (" ".equals(value)) 
                             g.drawString("[]", col * x + x / 2, lin * y + y / 2);*/
                            int fSize = x / 3;
                            g.setFont(new Font("arial", Font.PLAIN, fSize));
                            g.drawString(value, col * x + fSize, lin * y + fSize);
                        }
                    }
                }

                g.setColor(line);

                for (int i = 0; i < size.x; i += x) {
                    g.drawLine(i, 0, i, size.y);
                }

                for (int i = 0; i < size.y; i += y) {
                    g.drawLine(0, i, size.x, i);
                }

                g.setColor(front);
                //int px = e.getPoint().x / x;
                //int py = e.getPoint().y / y;

                g.drawRect(pxy.x - x / 2 + sp, pxy.y - y / 2 + sp, x - sp, y - sp);

                if (btnFillLine.isSelected()) {
                    for (int i = 0; i < getWidth(); i += x) {
                        g.drawRect(i + sp, pxy.y - y / 2 + sp, x / 2, y / 2);
                    }
                }

                if (btnFillColumn.isSelected()) {
                    for (int i = 0; i < getHeight(); i += y) {
                        g.drawRect(pxy.x - x / 2 + sp, i + sp, x / 2, y / 2);
                    }
                }

                /*TODO on mouse press;
                 if (start != null) {
                 //System.out.print("start " + start);
                 //System.out.println(" pxy " + pxy);

                 int temp = (pxy.y - start.y) / 18;
                 int tt = 0;
                 //System.out.println("te " + temp);
                 for (int i = start.x; i < pxy.x; i += x) {
                 //g.drawRect(i - x / 2 + sp, i - y / 2 + sp, x - sp, y - sp);
                 g.drawRect(i - x / 2 + sp, start.y + tt * temp, x - sp, y - sp);
                 tt++;
                 }
                 } {

                 }*/
            }

        };

        c.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = size.x / grid.width;
                int y = size.y / grid.height;

                int px = e.getPoint().x / x;
                int py = e.getPoint().y / y;

                if (e.getButton() == MouseEvent.BUTTON1) {
                    String[][] gridArray = list.get(index);
                    //System.out.printf("x %d y %d - px %d py %d\n", x, y, px, py);

                    if (!isValid(px, py, gridArray)) {
                        return;
                    }

                    if (btnFillLine.isSelected() || btnFillColumn.isSelected()) {

                        if (btnFillLine.isSelected()) {
                            for (int i = 0; i < gridArray.length; i++) {
                                gridArray[i][py] = btnEmptyLinCol.isSelected() ? defVal : valSel;
                            }
                        }

                        if (btnFillColumn.isSelected()) {
                            for (int i = 0; i < gridArray[0].length; i++) {
                                gridArray[px][i] = btnEmptyLinCol.isSelected() ? defVal : valSel;
                            }
                        }

                    } else {
                        gridArray[px][py] = defVal.equals(gridArray[px][py]) ? valSel : defVal;

                        //System.out.println("defVal " + defVal);
                        //System.out.println("valSel " + valSel);
                        //System.out.println("gridArray[px][py] " + gridArray[px][py]);
                    }
                }
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
                pxy = e.getPoint();
                updateMousePosition();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                pxy = e.getPoint();
                updateMousePosition();
            }
        });

        return c;
    }

    private void updateMousePosition() {
        if (grid.width == 0 || grid.height == 0) {
            return;
        }

        int px = pxy.x / (size.x / grid.width);
        int py = pxy.y / (size.y / grid.height);

        if (px >= grid.width || py >= grid.height) {
            lblPosition.setForeground(Color.RED);
        } else {
            lblPosition.setForeground(Color.BLACK);
        }

        lblPosition.setText(String.format("lin %d, col %d", py, px));
    }

    private boolean isValid(int px, int py, Object[][] gridArray) {
        return px >= 0 && px < gridArray.length && py >= 0 && py < gridArray[0].length;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCode;
    private javax.swing.JToggleButton btnEmptyLinCol;
    private javax.swing.JToggleButton btnFill;
    private javax.swing.JToggleButton btnFillColumn;
    private javax.swing.JToggleButton btnFillLine;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRigth;
    private javax.swing.JPanel canvas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblIdx;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblValueSelected;
    private javax.swing.JMenuItem miNewGrid;
    private javax.swing.JPanel pnDefault;
    private javax.swing.JTextField tfGridHei;
    private javax.swing.JTextField tfGridWid;
    // End of variables declaration//GEN-END:variables

    private void go(int id) {
        int t = index + id;

        if (t < 0) {
            t = list.size() - 1;
        } else if (t == list.size()) {
            t = 0;
        }

        index = t;
        updateLabels();
    }

    private void updateLabels() {
        lblCount.setText(String.valueOf(list.size()));
        lblIdx.setText(String.valueOf(index + 1));
    }

    private void removeGrid() {
        int res = JOptionPane.showConfirmDialog(this, String.format("Remove grid %d?", index + 1), "Remove Confirm", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            if (list.size() > 1) {
                list.remove(index);
                go(-1);
            } else {
                list.set(index, newGrid(grid, defVal));
            }
        }
    }

    private void viewCode() {
        cw.setList(list);
        cw.setVisible(true);
    }

    private String[][] newGrid(Dimension grid, String defVal) {
        String[][] arr = new String[grid.width][grid.height];

        for (String[] a : arr) {
            for (int j = 0; j < a.length; j++) {
                a[j] = defVal;
            }
        }

        return arr;
    }
}
