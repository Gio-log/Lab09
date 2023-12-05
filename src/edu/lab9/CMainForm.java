package edu.lab9;

import edu.shapes.CShapeCircle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class CMainForm extends javax.swing.JFrame{
    private JPanel mainPanel;
    private JPanel graphicsArea;
    private CDocument document;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        graphicsArea = new CGraphicArea();
    }
    public CMainForm(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        graphicsArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                graphicAreaMousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                graphicAreaMouseReleased();
            }
        });
        graphicsArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                graphicAreaMouseDragged(e);
            }
        });

        document = new CDocument((CGraphicArea)graphicsArea);
        document.addShape(new CShapeCircle(200,200, Color.BLUE, Color.BLACK,70));
        document.addShape(new CShapeCircle(600,300,Color.DARK_GRAY,Color.BLACK,90));
        document.redraw();
    }
    private void graphicAreaMousePressed(MouseEvent evt){
        if (evt.getButton()==MouseEvent.BUTTON1){
            if (document.selectShape(evt.getX(), evt.getY()))
                document.redraw();
        }
    }
    private void graphicAreaMouseReleased(){
        document.deselectShape();
        document.redraw();
    }
    private void graphicAreaMouseDragged(MouseEvent evt){
        document.moveSelectedTo(evt.getX(),evt.getY());
        long time = document.redraw();
        if(time>0){
            setTitle(String.format("Kształtowniki, czas rysowania %d ms", time));
        }
    }
}
