/**
 *
 * @author CandyAou
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Scanner;  

class Fire_OOP extends JFrame
{
    private static int x,y,SIZE,time,burnTree;
    public static double prob,probTree;
    private static FireView view;
    private static FireModel model;
    private JTextField probcatchin,probtreein,delayin,treein,howin;
    private double probcatch,probtree;
    Fire_OOP()
    {
        super("Forest Fire");
        
        // build the view
        view = new FireView();
        view.setBackground(Color.white);
        model = new FireModel(view,100,1,1);
        getContentPane().setLayout(new BorderLayout(0,0));
        getContentPane().add(view, BorderLayout.CENTER);
        
        JPanel wrap=new JPanel();
        wrap.setLayout(new GridLayout(15,1));
        
        
        JPanel j11=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jG4 = new JButton("Group 7");
        j11.add(jG4);
        wrap.add(j11);
        
        jG4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                   JOptionPane.showMessageDialog(null, "54270322    Thanakrit Chirawannaphron\n"
                                                     + "56130500241 Jaruwarin Kanjanakulsitti\n"
                                                     + "56130500251 Paspana Assarasee","Members",
                                                       JOptionPane.INFORMATION_MESSAGE);
                                                    
                }
        });
        
        
        
        JPanel j1=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel jb=new JLabel("prob Catch");
        probcatchin = new JTextField();
        probcatchin.setColumns(6);
        j1.add(jb);
        j1.add(probcatchin);
        wrap.add(j1);
        
        JPanel j2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel ja=new JLabel("prob Tree");
        probtreein = new JTextField();
        probtreein.setColumns(6);
        j2.add(ja);
        j2.add(probtreein);
        wrap.add(j2);
        
        JPanel j4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel jd=new JLabel("Forest Size");
        treein = new JTextField();
        treein.setColumns(6);
        j4.add(jd);
        j4.add(treein);
        wrap.add(j4);
        
        JPanel j5=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel je=new JLabel("Many Tree Burn?");
        howin = new JTextField();
        howin.setColumns(6);
        j5.add(je);
        j5.add(howin);
        wrap.add(j5);
        
        
        
        
        JPanel j7=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jstart = new JButton("Start");
        howin.setColumns(6);
        j7.add(jstart);
        wrap.add(j7);
        
        jstart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
                probcatch = Double.parseDouble(probcatchin.getText());
                probtree = Double.parseDouble(probtreein.getText());
                if(probcatch > 0 && probcatch <= 1){
                   model.setProbCatch(probcatch);
                }else{
                    JOptionPane.showMessageDialog(null, "probCatch is only 0-1","ERROR",JOptionPane.INFORMATION_MESSAGE);
                }
                if( probtree > 0 &&  probtree <= 1){
                   model.setProbTree( probtree);
                }else{
                    JOptionPane.showMessageDialog(null, "probTreeis only 0-1","ERROR",JOptionPane.INFORMATION_MESSAGE);
                }
                   model.setSize(Integer.parseInt(treein.getText()));
                   model.setTreeBurn(Integer.parseInt(howin.getText()));
                   model.time(150);
                   
                   model.resetBurn();
                   model.startBurn();
                  
                   
             }
        });
        
        
        JPanel j6=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jstep = new JButton("Step");
        j6.add(jstep);
        wrap.add(j6);
        
        jstep.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                   model.runQueue();
                }
        });
        
        
        
        JPanel j8=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jstop = new JButton("Stop");
        j8.add(jstop);
        wrap.add(j8);
        
        jstop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                   model.stopBurn();
                }
        });
        
        
        JPanel j9=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jreset = new JButton("Reset");
        j9.add(jreset);
        wrap.add(j9);
        
        jreset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                   model.resetBurn();
                }
        });
        
        JPanel j10=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jhelp = new JButton("HELP");
        j10.add(jhelp);
        wrap.add(j10);
        
        jhelp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                   JOptionPane.showMessageDialog(null, "prob Catch : to set the probability of spread of fire(0-1)\n"
                                                     + "prob Tree  : to set the probability of tree          (0-1)\n"
                                                     + "Forest size: to set the size of forest              (3-200)\n"
                                                     + "Many tree burn : when start how many tree that you want to burn\n"
                                                     + "Start :Click to begin spread of fire\n"
                                                     + "Step  :Click to spread of fire step by step\n"
                                                     + "Stop  :Click to stop \n"
                                                     + "Reset :Click to reset project","HELP",
                                                       JOptionPane.INFORMATION_MESSAGE);
                }
        });
        
        
        
        getContentPane().add(wrap, BorderLayout.EAST);
        revalidate();
        repaint();
       
    }

    public static void main(String[] args)
    {
        Fire_OOP sb = new Fire_OOP();
        sb.addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
               System.exit(0);
            }
        });
        

//        model = new FireModel(view,SIZE,burnTree,probTree);

        sb.setSize(1100,1000); //set size of GUI 1100px*1000px
        sb.setVisible(true);
    }
}
