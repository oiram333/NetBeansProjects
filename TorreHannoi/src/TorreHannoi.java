/**
 * @author Mario Moreno
 */

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TorreHannoi extends javax.swing.JFrame {
    
    int contNumMovimientos = 0;
    int objetivo = 0;
    double numMinMovimientos = 0;
    boolean stop = false;
    
    Pila pilaTowerOne;
    Pila pilaTowerTwo;
    Pila pilaTowerTrhee;
    
    DefaultTableModel modelTableTowerOne, modelTableTowerTwo, modelTableTowerTrhee;
    
    public TorreHannoi() {
        initComponents();
        
        modelTableTowerOne = (DefaultTableModel) towerOne.getModel();
        modelTableTowerOne.setRowCount(10);
        
        modelTableTowerTwo = (DefaultTableModel) towerTwo.getModel();
        modelTableTowerTwo.setRowCount(10);
        
        modelTableTowerTrhee = (DefaultTableModel) towerTrhee.getModel();
        modelTableTowerTrhee.setRowCount(10);
    
        DefaultTableCellRenderer renderUno = new DefaultTableCellRenderer();
        renderUno.setHorizontalAlignment(SwingConstants.CENTER);
        towerOne.getColumnModel().getColumn(0).setCellRenderer(renderUno);
        
        DefaultTableCellRenderer renderDos = new DefaultTableCellRenderer();
        renderDos.setHorizontalAlignment(SwingConstants.CENTER);
        towerTwo.getColumnModel().getColumn(0).setCellRenderer(renderUno);
        
        DefaultTableCellRenderer renderTres = new DefaultTableCellRenderer();
        renderTres.setHorizontalAlignment(SwingConstants.CENTER);
        towerTrhee.getColumnModel().getColumn(0).setCellRenderer(renderUno);
        
        
    }

    private void cleanUp(){
        contNumMovimientos  = 0;
        numMinMovimientos = 0;
        comboBox.setSelectedItem(String.valueOf(objetivo));
    }
  
    private void start(){
        
        try{
        pilaTowerOne = new Pila();
        pilaTowerTwo = new Pila();
        pilaTowerTrhee = new Pila();
        
        objetivo = Integer.parseInt(comboBox.getSelectedItem().toString());
        
        numMinMovimientos = Math.pow(2, objetivo)-1;
        
        lbMovement.setText(String.valueOf(contNumMovimientos));
        lbMinMovimientos.setText(String.valueOf(String.format("%.0f", numMinMovimientos)));
        
        for(int x = objetivo; x>=1; x--){
            Nodo plataforma = new Nodo();
            String disco = "";
            for(int y = x; y>0; y--){
                disco += "#";
            }
            plataforma.setDato(disco);
            pilaTowerOne.push(plataforma);  
        }
        
        lodgeTowerOne();
        lodgeTowerTwo();
        lodgeTowerTrhee();
        
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }
    }
    
    private void restart(){
        try{
            if(!lbMinMovimientos.getText().equals("")){
                
                cleanUp();
                start();
            }
        }catch(Exception E){
            System.out.println("Error "+E.getMessage());
        }
    }
    
    private void quantityMovements(){
        contNumMovimientos ++;
        lbMovement.setText(String.valueOf(contNumMovimientos));
    }
    
    private void lodgeTowerOne(){
        ((DefaultTableModel)towerOne.getModel()).setRowCount(0);
        modelTableTowerOne.setRowCount(10);
        Nodo k;
        int rowDisco = (10-pilaTowerOne.getContNodo());
        
        if(pilaTowerOne.getContNodo()>0){
            for(k = pilaTowerOne.getHead(); k.getDown()!=null; k = k.getDown()){
                String[] vectorNormal = {k.getDato()};
                modelTableTowerOne.insertRow(rowDisco, vectorNormal);
                rowDisco++;
            }
            if(k.getDown()==null){
                String[] vectorNormal = {k.getDato()};
                modelTableTowerOne.insertRow(rowDisco, vectorNormal);
            }
        }
        towerOne.setModel(modelTableTowerOne);
        modelTableTowerOne.setRowCount(10);
    }
    
    private void lodgeTowerTwo(){
        ((DefaultTableModel)towerTwo.getModel()).setRowCount(0);
        modelTableTowerTwo.setRowCount(10);
        Nodo k;
        int rowDisco = (10-pilaTowerTwo.getContNodo());
        
        if(pilaTowerTwo.getContNodo()>0){
            for(k = pilaTowerTwo.getHead(); k.getDown()!=null; k = k.getDown()){
                String[] vectorNormal = {k.getDato()};
                modelTableTowerTwo.insertRow(rowDisco, vectorNormal);
                rowDisco++;
            }
            if(k.getDown()==null){
                String[] vectorNormal = {k.getDato()};
                modelTableTowerTwo.insertRow(rowDisco, vectorNormal);
            }
        }
        towerTwo.setModel(modelTableTowerTwo);
        modelTableTowerTwo.setRowCount(10);
    }
    
    private void lodgeTowerTrhee(){
        ((DefaultTableModel)towerTrhee.getModel()).setRowCount(0);
        modelTableTowerTrhee.setRowCount(10);
        Nodo k;
        int rowDisco = (10-pilaTowerTrhee.getContNodo());
        
        if(pilaTowerTrhee.getContNodo()>0){
            for(k = pilaTowerTrhee.getHead(); k.getDown()!=null; k = k.getDown()){
                String[] vectorNormal = {k.getDato()};
                modelTableTowerTrhee.insertRow(rowDisco, vectorNormal);
                rowDisco++;
            }
            if(k.getDown()==null){
                String[] vectorNormal = {k.getDato()};
                modelTableTowerTrhee.insertRow(rowDisco, vectorNormal);
            }
        }
        towerTrhee.setModel(modelTableTowerTrhee);
        modelTableTowerTrhee.setRowCount(10);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        towerTwo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        towerTrhee = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        towerOne = new javax.swing.JTable();
        btnOneToTwo = new javax.swing.JButton();
        btnOneToTrhee = new javax.swing.JButton();
        btnTwoToOne = new javax.swing.JButton();
        btnTwoToThree = new javax.swing.JButton();
        btnTrheeToOne = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbMinMovimientos = new javax.swing.JLabel();
        lbMovement = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
        btnTrheeToTwo = new javax.swing.JButton();
        btnResolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        towerTwo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre Dos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        towerTwo.setAutoscrolls(false);
        towerTwo.setFocusable(false);
        towerTwo.setRowSelectionAllowed(false);
        towerTwo.setShowHorizontalLines(false);
        towerTwo.setShowVerticalLines(false);
        jScrollPane1.setViewportView(towerTwo);
        if (towerTwo.getColumnModel().getColumnCount() > 0) {
            towerTwo.getColumnModel().getColumn(0).setResizable(false);
        }

        towerTrhee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre Tres"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        towerTrhee.setAutoscrolls(false);
        towerTrhee.setFocusable(false);
        towerTrhee.setRowSelectionAllowed(false);
        towerTrhee.setShowHorizontalLines(false);
        towerTrhee.setShowVerticalLines(false);
        jScrollPane2.setViewportView(towerTrhee);
        if (towerTrhee.getColumnModel().getColumnCount() > 0) {
            towerTrhee.getColumnModel().getColumn(0).setResizable(false);
        }

        towerOne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre Uno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        towerOne.setAutoscrolls(false);
        towerOne.setFocusable(false);
        towerOne.setRowSelectionAllowed(false);
        towerOne.setShowHorizontalLines(false);
        towerOne.setShowVerticalLines(false);
        jScrollPane3.setViewportView(towerOne);
        if (towerOne.getColumnModel().getColumnCount() > 0) {
            towerOne.getColumnModel().getColumn(0).setResizable(false);
        }

        btnOneToTwo.setText("Dos");
        btnOneToTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOneToTwoActionPerformed(evt);
            }
        });

        btnOneToTrhee.setText("Tres");
        btnOneToTrhee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOneToTrheeActionPerformed(evt);
            }
        });

        btnTwoToOne.setText("Uno");
        btnTwoToOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoToOneActionPerformed(evt);
            }
        });

        btnTwoToThree.setText("Tres");
        btnTwoToThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoToThreeActionPerformed(evt);
            }
        });

        btnTrheeToOne.setText("Uno");
        btnTrheeToOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrheeToOneActionPerformed(evt);
            }
        });

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Numero de discos:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Numero min. de movimientos:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Numero de movimientos:");

        lbMinMovimientos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbMovement.setForeground(new java.awt.Color(255, 0, 0));
        lbMovement.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnStart.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnStart.setText("Iniciar");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnRestart.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRestart.setText("Reiniciar");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        btnTrheeToTwo.setText("Dos");
        btnTrheeToTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrheeToTwoActionPerformed(evt);
            }
        });

        btnResolver.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnResolver.setText("Resolver");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMinMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(lbMovement, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOneToTwo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOneToTrhee))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTwoToOne)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTwoToThree)))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTrheeToOne)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTrheeToTwo))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOneToTrhee)
                    .addComponent(btnOneToTwo)
                    .addComponent(btnTwoToOne)
                    .addComponent(btnTwoToThree)
                    .addComponent(btnTrheeToOne)
                    .addComponent(btnTrheeToTwo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMinMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMovement, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        start();
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        restart();
    }//GEN-LAST:event_btnRestartActionPerformed

    private void moveOne_Two(){
        try{
            if(pilaTowerOne.getContNodo()>0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTowerOne.peek());
                if(pilaTowerTwo.getContNodo()>0){
                    if(plataforma.getDato().compareTo(pilaTowerTwo.peek())>0){
                        return;
                    }
                }
                pilaTowerOne.pop();
                pilaTowerTwo.push(plataforma);
                
                lodgeTowerOne();
                lodgeTowerTwo();
                quantityMovements();
            }
        }catch(Exception E){
            System.out.println("Error "+E.getMessage());
        }
    }
    
    private void btnOneToTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOneToTwoActionPerformed
        moveOne_Two();
    }//GEN-LAST:event_btnOneToTwoActionPerformed
    
    private void moveOne_Trhee(){
        try{
            if(pilaTowerOne.getContNodo()>0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTowerOne.peek());
                if(pilaTowerTrhee.getContNodo()>0){
                    if(plataforma.getDato().compareTo(pilaTowerTrhee.peek())>0){
                        return;
                    }
                }
                pilaTowerOne.pop();
                pilaTowerTrhee.push(plataforma);
                
                lodgeTowerOne();
                lodgeTowerTrhee();
                quantityMovements();
                
                if(pilaTowerTrhee.getContNodo()==objetivo && contNumMovimientos==numMinMovimientos){
                    JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo de minimo de movimientos\n\nIntenta con otro nivel de dificultad", "Felicitaciones",JOptionPane.WARNING_MESSAGE);
                }else if(pilaTowerTrhee.getContNodo()==objetivo && contNumMovimientos!=numMinMovimientos){
                    JOptionPane.showMessageDialog(null, "Felicidades has terminado pero intentaalcanzar el minimo numero de movimientos\n\nIntenta con otro nivel de dificultad", "Felicitaciones",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(Exception E){
            System.out.println("Error "+E.getMessage());
        }
    }
    
    private void btnOneToTrheeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOneToTrheeActionPerformed
        moveOne_Trhee();
    }//GEN-LAST:event_btnOneToTrheeActionPerformed

    private void moveTwo_One(){
        try{
            if(pilaTowerTwo.getContNodo()>0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTowerTwo.peek());
                if(pilaTowerOne.getContNodo()>0){
                    if(plataforma.getDato().compareTo(pilaTowerOne.peek())>0){
                        return;
                    }
                }
                pilaTowerTwo.pop();
                pilaTowerOne.push(plataforma);
                
                lodgeTowerOne();
                lodgeTowerTwo();
                quantityMovements();
            }
        }catch(Exception E){
            System.out.println("Error "+E.getMessage());
        }
    }
    
    private void btnTwoToOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoToOneActionPerformed
        moveTwo_One();
    }//GEN-LAST:event_btnTwoToOneActionPerformed

    private void moveTwo_Trhee(){
        try{
            if(pilaTowerTwo.getContNodo()>0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTowerTwo.peek());
                if(pilaTowerTrhee.getContNodo()>0){
                    if(plataforma.getDato().compareTo(pilaTowerTrhee.peek())>0){
                        return;
                    }
                }
                pilaTowerTwo.pop();
                pilaTowerTrhee.push(plataforma);
                
                lodgeTowerTwo();
                lodgeTowerTrhee();
                quantityMovements();
                
                if(pilaTowerTrhee.getContNodo()==objetivo && contNumMovimientos==numMinMovimientos){
                    JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo de minimo de movimientos\n\nIntenta con otro nivel de dificultad", "Felicitaciones",JOptionPane.WARNING_MESSAGE);
                }else if(pilaTowerTrhee.getContNodo()==objetivo && contNumMovimientos!=numMinMovimientos){
                    JOptionPane.showMessageDialog(null, "Felicidades has terminado pero intentaalcanzar el minimo numero de movimientos\n\nIntenta con otro nivel de dificultad", "Felicitaciones",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(Exception E){
            System.out.println("Error "+E.getMessage());
        }
    }
    
    private void btnTwoToThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoToThreeActionPerformed
        moveTwo_Trhee();
    }//GEN-LAST:event_btnTwoToThreeActionPerformed

    private void moveTrhee_One(){
        try{
            if(pilaTowerTrhee.getContNodo()>0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTowerTrhee.peek());
                if(pilaTowerOne.getContNodo()>0){
                    if(plataforma.getDato().compareTo(pilaTowerOne.peek())>0){
                        return;
                    }
                }
                pilaTowerTrhee.pop();
                pilaTowerOne.push(plataforma);
                
                lodgeTowerOne();
                lodgeTowerTrhee();
                quantityMovements();
            }
        }catch(Exception E){
            System.out.println("Error "+E.getMessage());
        }
    }
    
    private void btnTrheeToOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrheeToOneActionPerformed
        moveTrhee_One();
    }//GEN-LAST:event_btnTrheeToOneActionPerformed

    private void moveThree_Two(){
        try{
            if(pilaTowerTrhee.getContNodo()>0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTowerTrhee.peek());
                if(pilaTowerTwo.getContNodo()>0){
                    if(plataforma.getDato().compareTo(pilaTowerTwo.peek())>0){
                        return;
                    }
                }
                pilaTowerTrhee.pop();
                pilaTowerTwo.push(plataforma);
                
                lodgeTowerTwo();
                lodgeTowerTrhee();
                quantityMovements();
                
                if(pilaTowerTwo.getContNodo()==objetivo && contNumMovimientos==numMinMovimientos){
                    JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo de minimo de movimientos\n\nIntenta con otro nivel de dificultad", "Felicitaciones",JOptionPane.WARNING_MESSAGE);
                }else if(pilaTowerTwo.getContNodo()==objetivo && contNumMovimientos!=numMinMovimientos){
                    JOptionPane.showMessageDialog(null, "Felicidades has terminado pero intentaalcanzar el minimo numero de movimientos\n\nIntenta con otro nivel de dificultad", "Felicitaciones",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(Exception E){
            System.out.println("Error "+E.getMessage());
        }
    }
    private void btnTrheeToTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrheeToTwoActionPerformed
        moveThree_Two();
    }//GEN-LAST:event_btnTrheeToTwoActionPerformed
    
    private void movePlataforma(Pila origen, Pila destino){
        if(stop==false){
            Nodo Plataforma = new Nodo();
            Plataforma.setDato(origen.peek());
            origen.pop();
            destino .push(Plataforma);
            
            lodgeTowerOne();
            lodgeTowerTwo();
            lodgeTowerTrhee();
            quantityMovements();
            
            JOptionPane pane = new JOptionPane("Paso #"+lbMovement.getText()+"\n\n¿Continuar?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
            JDialog dialog = pane.createDialog("Numero de pasos");
            dialog.setLocation(600,400);
            dialog.setVisible(true);
            
            int opt = (int)pane.getValue();
            
            if(opt==JOptionPane.NO_OPTION){
                stop = true;
            }
        }
    }
    
    private void resolver(int n, Pila Origen, Pila Auxiliar, Pila Destino){
        if(n==1){
            movePlataforma(Origen, Destino);
        }else{
            resolver(n-1, Origen, Destino, Auxiliar);
            movePlataforma(Origen, Destino);
            
            resolver(n-1, Auxiliar, Origen, Destino);
        }
    }
    
    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
        if(!lbMinMovimientos.getText().equals("") && pilaTowerTrhee.getContNodo()!=objetivo){
            restart();
            stop = false;
            
            resolver(objetivo, pilaTowerOne, pilaTowerTwo, pilaTowerTrhee);
        }
    }//GEN-LAST:event_btnResolverActionPerformed
     
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
            java.util.logging.Logger.getLogger(TorreHannoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TorreHannoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TorreHannoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TorreHannoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TorreHannoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOneToTrhee;
    private javax.swing.JButton btnOneToTwo;
    private javax.swing.JButton btnResolver;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnTrheeToOne;
    private javax.swing.JButton btnTrheeToTwo;
    private javax.swing.JButton btnTwoToOne;
    private javax.swing.JButton btnTwoToThree;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbMinMovimientos;
    private javax.swing.JLabel lbMovement;
    private javax.swing.JTable towerOne;
    private javax.swing.JTable towerTrhee;
    private javax.swing.JTable towerTwo;
    // End of variables declaration//GEN-END:variables
}
