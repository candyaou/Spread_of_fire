package fire_oop;

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
        
//        JPanel j3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        JLabel jc=new JLabel("Delay");
//        delayin = new JTextField();
//        delayin.setColumns(6);
//        j3.add(jc);
//        j3.add(delayin);
//        wrap.add(j3);
        
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
            public void actionPerformed(ActionEvent e) {
                   model.setProbCatch(Double.parseDouble(probcatchin.getText()));
                   model.setProbTree(Double.parseDouble(probtreein.getText()));
                   model.setSize(Integer.parseInt(treein.getText()));
                   model.setTreeBurn(Integer.parseInt(howin.getText()));
                   model.resetBurn();
                   model.startBurn();
                   model.GameTimer(150);
//                   (new Thread(new Runnable(){
//                       public void run(){
//                   model.GameTimer(Integer.parseInt(delayin.getText()));
//                       
//                       }
//                   })).start();
                   
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

        sb.setSize(1100,1000);
        sb.setVisible(true);
    }
}
