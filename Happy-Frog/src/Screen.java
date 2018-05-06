
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class Screen extends javax.swing.JFrame{
    
    /**
     * Creates new form Screen
     */
    Timer frog=null;
    Timer pipe=null;
    Timer pointTimer=null;
    Thread frogThread=null;
    Thread pipeThread=null;
    Thread pointThread=null;
    //Timer changePoint=null;
    int status=0;
    int point=0;
    Deque<Pair<JButton,JButton>> dequePipeline=null;
    public Screen() {
        initComponents();
        initFrog();
        initDequePipeline();
        //initTimer();
        initThread();
        this.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                //lbPoint.setText(point+"");
                if (evt.getKeyCode()==KeyEvent.VK_SPACE){
//                    if (!frog.isRunning() && !pipe.isRunning()) {
//                        frog.start();
//                        pipe.start();
//                        pointTimer.start();
//                        status=1;
//                    }
                    if (!frogThread.isAlive()){
                        frogThread.start();
                        pipeThread.start();
                        pointThread.start();
                        status=1;
                    }
                    if (lbFrog.getY()-20<mainScreen.getY())
                        lbFrog.setLocation(lbFrog.getX(), mainScreen.getY());
                    else lbFrog.setLocation(lbFrog.getX(), lbFrog.getY()-20);
                }
            }
        });
    }
    void initDequePipeline(){
        dequePipeline=new ArrayDeque<>();
        dequePipeline.addLast(new Pair<>(pipeUp1,pipeDown1));
        dequePipeline.addLast(new Pair<>(pipeUp2,pipeDown2));
        dequePipeline.addLast(new Pair<>(pipeUp3,pipeDown3));
        dequePipeline.addLast(new Pair<>(pipeUp4,pipeDown4));
    }
    Boolean isMeet(JButton pipeTemp){
        if (pipeTemp.getX()<=(lbFrog.getX()+lbFrog.getWidth())){
            return true;
        }
        return false;
    }
    void moveLeft(JButton pipeLine){
        if (pipeLine.getX()<=mainScreen.getX()){
            pipeLine.setLocation(mainScreen.getX()+mainScreen.getWidth(),pipeLine.getY());
        }
        else pipeLine.setLocation(pipeLine.getX()-5, pipeLine.getY());
    }
    void initFrog(){
        BufferedImage frogImg=null;
        try {
            frogImg=ImageIO.read(new File("frog.png"));
        } catch (IOException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image tempImg=frogImg.getScaledInstance(lbFrog.getWidth(), lbFrog.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon=new ImageIcon(tempImg);
        lbFrog.setIcon(imageIcon);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainScreen = new javax.swing.JPanel();
        lbFrog = new javax.swing.JLabel();
        pipeUp1 = new javax.swing.JButton();
        pipeDown1 = new javax.swing.JButton();
        pipeUp2 = new javax.swing.JButton();
        pipeDown2 = new javax.swing.JButton();
        pipeUp3 = new javax.swing.JButton();
        pipeDown3 = new javax.swing.JButton();
        pipeUp4 = new javax.swing.JButton();
        pipeDown4 = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lbPoint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainScreen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        lbFrog.setBackground(new java.awt.Color(255, 255, 0));
        lbFrog.setOpaque(true);

        pipeUp1.setBackground(new java.awt.Color(0, 255, 255));
        pipeUp1.setForeground(new java.awt.Color(153, 153, 153));
        pipeUp1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pipeUp1.setFocusable(false);
        pipeUp1.setName("pipeUp1"); // NOI18N

        pipeDown1.setBackground(new java.awt.Color(51, 255, 204));
        pipeDown1.setForeground(new java.awt.Color(0, 255, 0));
        pipeDown1.setFocusable(false);
        pipeDown1.setName("pipeDown1"); // NOI18N
        pipeDown1.setOpaque(false);

        pipeUp2.setBackground(new java.awt.Color(255, 0, 255));
        pipeUp2.setFocusable(false);
        pipeUp2.setName("pipeUp2"); // NOI18N

        pipeDown2.setBackground(new java.awt.Color(0, 204, 0));
        pipeDown2.setFocusable(false);

        pipeUp3.setBackground(new java.awt.Color(204, 255, 51));
        pipeUp3.setFocusable(false);

        pipeDown3.setBackground(new java.awt.Color(0, 0, 255));
        pipeDown3.setFocusable(false);

        pipeUp4.setBackground(new java.awt.Color(51, 255, 102));
        pipeUp4.setFocusable(false);

        pipeDown4.setBackground(new java.awt.Color(153, 0, 102));
        pipeDown4.setFocusable(false);

        javax.swing.GroupLayout mainScreenLayout = new javax.swing.GroupLayout(mainScreen);
        mainScreen.setLayout(mainScreenLayout);
        mainScreenLayout.setHorizontalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainScreenLayout.createSequentialGroup()
                .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainScreenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbFrog, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainScreenLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pipeUp1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pipeDown1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pipeUp2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pipeDown2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pipeDown3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pipeUp3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pipeUp4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pipeDown4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        mainScreenLayout.setVerticalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainScreenLayout.createSequentialGroup()
                .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pipeUp1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(pipeUp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pipeDown2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pipeDown1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(mainScreenLayout.createSequentialGroup()
                .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pipeUp3, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(pipeUp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pipeDown4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pipeDown3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(mainScreenLayout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(lbFrog, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        btnPause.setText("Pause");
        btnPause.setFocusable(false);
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setFocusable(false);

        btnExit.setText("Exit");
        btnExit.setFocusable(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lbPoint.setText("Points: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPause)
                        .addGap(54, 54, 54)
                        .addComponent(btnSave)
                        .addGap(56, 56, 56)
                        .addComponent(lbPoint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(btnExit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPause)
                    .addComponent(btnSave)
                    .addComponent(btnExit)
                    .addComponent(lbPoint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        if (frogThread.isAlive())
        try {
            // TODO add your handling code here:
            //lbFrog.setBounds(lbFrog.getX(), lbFrog.getY()+10, lbFrog.getWidth(), lbFrog.getHeight());
            synchronized(this){
                this.wait();
            }
            
//        if (status==1 && frog.isRunning() && pipe.isRunning()){
//            frog.stop();
//            pipe.stop();
//            status=0;
//            btnPause.setText("Resume");
//        }
//        else if (status==0){
//            frog.start();
//            pipe.start();
//            status=1;
//            btnPause.setText("Pause");
//        }
        } catch (InterruptedException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }else{
            frogThread.notify();
        }
    }//GEN-LAST:event_btnPauseActionPerformed

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
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lbFrog;
    private javax.swing.JLabel lbPoint;
    private javax.swing.JPanel mainScreen;
    private javax.swing.JButton pipeDown1;
    private javax.swing.JButton pipeDown2;
    private javax.swing.JButton pipeDown3;
    private javax.swing.JButton pipeDown4;
    private javax.swing.JButton pipeUp1;
    private javax.swing.JButton pipeUp2;
    private javax.swing.JButton pipeUp3;
    private javax.swing.JButton pipeUp4;
    // End of variables declaration//GEN-END:variables

    private void initTimer() {
        frog=new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbFrog.setLocation(lbFrog.getX(), lbFrog.getY()+1);
            }
        });
        Thread t=new Thread();
        
        pipe=new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveLeft(pipeDown1);
                moveLeft(pipeUp1);
                moveLeft(pipeDown2);
                moveLeft(pipeUp2);
                moveLeft(pipeDown3);
                moveLeft(pipeUp3);
                moveLeft(pipeDown4);
                moveLeft(pipeUp4);
            }
        });
        pointTimer=new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton pipeUp=dequePipeline.getFirst().getKey();
                JButton pipeDown=dequePipeline.getFirst().getValue();
                if (isMeet(pipeDown) && isMeet(pipeUp)){
                    Pair tempPair=dequePipeline.poll();
                    dequePipeline.addLast(tempPair);
                    int pointUpFrog=lbFrog.getY();
                    int pointDownFrog=lbFrog.getY()+lbFrog.getHeight();
                    int pointPipeUp=pipeUp.getY()+pipeUp.getHeight();
                    int pointPipeDown=pipeDown.getY();
                    if (pointPipeUp<pointUpFrog && pointDownFrog<pointPipeDown){
                        point++;
                        System.out.println(point);
                        //lbPoint.setText("Points: "+point);
                    }
                }           
            }
        });
    }

    private void initThread() {
        frogThread=new Thread(){
            public void run(){
                while(true){
                    lbFrog.setLocation(lbFrog.getX(), lbFrog.getY()+1);
                    try {
                        sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        pipeThread=new Thread(){
            public void run(){
                while(true){
                    moveLeft(pipeDown1);
                    moveLeft(pipeUp1);
                    moveLeft(pipeDown2);
                    moveLeft(pipeUp2);
                    moveLeft(pipeDown3);
                    moveLeft(pipeUp3);
                    moveLeft(pipeDown4);
                    moveLeft(pipeUp4);
                    try {
                        sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        pointThread=new Thread(){
            public void run(){
                while (true){
                    JButton pipeUp=dequePipeline.getFirst().getKey();
                    JButton pipeDown=dequePipeline.getFirst().getValue();
                    if (isMeet(pipeDown) && isMeet(pipeUp)){
                        Pair tempPair=dequePipeline.poll();
                        dequePipeline.addLast(tempPair);
                        int pointUpFrog=lbFrog.getY();
                        int pointDownFrog=lbFrog.getY()+lbFrog.getHeight();
                        int pointPipeUp=pipeUp.getY()+pipeUp.getHeight();
                        int pointPipeDown=pipeDown.getY();
                        if (pointPipeUp<pointUpFrog && pointDownFrog<pointPipeDown){
                            point++;
                            System.out.println(point);
                            //lbPoint.setText("Points: "+point);
                        }
                    }
                    try {
                        sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
    }
}
