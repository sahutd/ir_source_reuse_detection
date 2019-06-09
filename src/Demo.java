import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.jgoodies.forms.factories.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Wed Apr 12 20:00:34 IST 2017
 */



/**
 * @author Saimadhav Heblikar
 */
public class Demo extends JPanel {

    public Demo() {
        initComponents();
    }

    public void button1MouseClicked(MouseEvent e) {
        //add to querySet
        createFileAndOpenInEditor("./src/queryset/", newQueryFile.getText());
    }

    public void button2MouseClicked(MouseEvent e) {
        createFileAndOpenInEditor("./src/dataset/", newDatafile.getText());
    }

    private void createFileAndOpenInEditor(String directory, String fileName)
    {
        if (fileName.equals("")){
            return;
        }
        File file = Paths.get(directory, fileName+".java").toFile();
        try
        {
            file.createNewFile();
            refreshView();
            openInEditor(new FileWrapper(file));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }



    public void button4MouseClicked(MouseEvent e) {
        refreshView();
    }

    public void refreshView()
    {
        System.err.println("in resfresh view");
        newDatafile.setText("");
        newQueryFile.setText("");
        querySetList.setModel(queryModel);
        datasetList.setModel(datasetModel);
        table1.setModel(tModel);
        label5.setText("");
        tModel.setRowCount(0);
        updateList(queryModel, "./src/queryset");
        updateList(datasetModel, "./src/dataset");
        tModel.setRowCount(0);
        tModel.addColumn("Document");
        tModel.addColumn("Score");

        table2.setModel(table2Model);
        table2Model.setColumnCount(0);
        table2Model.addColumn("Parent");
        table2Model.addColumn("Child");
        table2Model.addColumn("Query");
        table2Model.addColumn("Document");

    }




    private void updateList(DefaultListModel model, String path)
    {

        model.clear();
        List<File> files = Util.getFileList(path);
        for (File f : files)
        {
            model.addElement(new FileWrapper(f));
        }
    }

    public void openInEditor(Object fw){

        try
        {
            File file = ((FileWrapper)fw).getFile();
            Desktop.getDesktop().open(file);
        } catch (IOException e1)
        {
            e1.printStackTrace();
        }
    }

    public void querySetListMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2){
            openInEditor(querySetList.getSelectedValue());
        }

    }

    public void querySetListKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    public void datasetListMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2){
            openInEditor(datasetList.getSelectedValue());
        }    }

    public void RunMouseClicked(MouseEvent e) {

        Result result = Util.process(datasetList.getSelectedValuesList(), querySetList.getSelectedValuesList());
        tModel.setRowCount(0);
        tModel.setColumnCount(0);
        table1.setModel(tModel);
        tModel.addColumn("Document");
        tModel.addColumn("Score");
        table2.setModel(table2Model);
        table2Model.setColumnCount(0);
        table2Model.setRowCount(0);
        table2Model.addColumn("Parent");
        table2Model.addColumn("Child");
        table2Model.addColumn("Query");
        table2Model.addColumn("Document");
        label5.setText("Result for: " + result.getName());
        for(Score s: result.getSimilarityScores()){
            tModel.addRow(new Object[]{new ScoreWrapper(s), String.format("%.2f", s.getScore())});



        }

    }

    public void table2MouseClicked(MouseEvent e) {
        System.out.println(table2.rowAtPoint(e.getPoint()));
    }

    public void table1MouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2){
            table2Model.setRowCount(0);
            Vector data= (Vector)tModel.getDataVector().elementAt(table1.rowAtPoint(e.getPoint()));
            Score score = ((ScoreWrapper)data.elementAt(0)).getScore();
            ProgramLanguageModel document = score.getDocument();
            for (Map.Entry<Rule, Integer> ruleIntegerEntry : score.getQuery().ruleCounts.entrySet())
            {
                Rule rule = ruleIntegerEntry.getKey();
                String parent = rule.getParentName();
                String child = rule.getChildName();

                table2Model.addRow(new Object[]{parent, child,
                        ruleIntegerEntry.getValue(),
                        document.ruleCounts.get(ruleIntegerEntry.getKey())});

            }


        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Saimadhav Heblikar
        ResourceBundle bundle = ResourceBundle.getBundle("MyProperties");
        panel1 = new JPanel();
        label1 = new JLabel();
        label3 = new JLabel();
        label5 = new JLabel();
        label4 = new JLabel();
        scrollPane1 = new JScrollPane();
        querySetList = new JList();
        scrollPane4 = new JScrollPane();
        table1 = new JTable();
        scrollPane2 = new JScrollPane();
        datasetList = new JList();
        newQueryFile = new JTextField();
        button4 = new JButton();
        newDatafile = new JTextField();
        AddToQuerySet = new JButton();
        Run = new JButton();
        button2 = new JButton();
        scrollPane5 = new JScrollPane();
        table2 = new JTable();

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[576,fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label1 ----
            label1.setText(bundle.getString("label1.text"));
            label1.setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
            panel1.add(label1, "cell 7 0,alignx center,growx 0");

            //---- label3 ----
            label3.setText(bundle.getString("label3.text"));
            label3.setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
            panel1.add(label3, "cell 0 2,alignx center,growx 0");

            //---- label5 ----
            label5.setText(bundle.getString("label5.text"));
            label5.setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
            panel1.add(label5, "cell 7 2,alignx center,growx 0");

            //---- label4 ----
            label4.setText(bundle.getString("label4.text"));
            label4.setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
            panel1.add(label4, "cell 9 2");

            //======== scrollPane1 ========
            {

                //---- querySetList ----
                querySetList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                querySetList.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        querySetListKeyPressed(e);
                    }
                });
                querySetList.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        querySetListMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(querySetList);
            }
            panel1.add(scrollPane1, "cell 0 3 7 1");

            //======== scrollPane4 ========
            {
                scrollPane4.setViewportBorder(null);

                //---- table1 ----
                table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table1.setDragEnabled(true);
                table1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        table1MouseClicked(e);
                    }
                });
                scrollPane4.setViewportView(table1);
            }
            panel1.add(scrollPane4, "cell 7 3");

            //======== scrollPane2 ========
            {

                //---- datasetList ----
                datasetList.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        datasetListMouseClicked(e);
                    }
                });
                scrollPane2.setViewportView(datasetList);
            }
            panel1.add(scrollPane2, "cell 8 3 2 1");
            panel1.add(newQueryFile, "cell 0 4");

            //---- button4 ----
            button4.setText(bundle.getString("button4.text"));
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked(e);
                }
            });
            panel1.add(button4, "cell 7 4");
            panel1.add(newDatafile, "cell 9 4");

            //---- AddToQuerySet ----
            AddToQuerySet.setText(bundle.getString("AddToQuerySet.text"));
            AddToQuerySet.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel1.add(AddToQuerySet, "cell 0 5");

            //---- Run ----
            Run.setText(bundle.getString("Run.text"));
            Run.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    RunMouseClicked(e);
                }
            });
            panel1.add(Run, "cell 7 5");

            //---- button2 ----
            button2.setText(bundle.getString("button2.text"));
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                }
            });
            panel1.add(button2, "cell 9 5");

            //======== scrollPane5 ========
            {
                scrollPane5.setViewportBorder(null);

                //---- table2 ----
                table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table2.setDragEnabled(true);
                table2.setAutoCreateRowSorter(true);
                scrollPane5.setViewportView(table2);
            }
            panel1.add(scrollPane5, "cell 7 7");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Saimadhav Heblikar
    public JPanel panel1;
    public JLabel label1;
    public JLabel label3;
    public JLabel label5;
    public JLabel label4;
    public JScrollPane scrollPane1;
    public JList querySetList;
    public JScrollPane scrollPane4;
    public JTable table1;
    public JScrollPane scrollPane2;
    public JList datasetList;
    public JTextField newQueryFile;
    public JButton button4;
    public JTextField newDatafile;
    public JButton AddToQuerySet;
    public JButton Run;
    public JButton button2;
    public JScrollPane scrollPane5;
    public JTable table2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public DefaultListModel queryModel = new DefaultListModel();
    public DefaultListModel datasetModel = new DefaultListModel();
    DefaultTableModel tModel = new DefaultTableModel(){
        @Override
        public  boolean isCellEditable(int row, int column){
            return false;
        }
    };
    DefaultTableModel table2Model = new DefaultTableModel(){
        @Override
        public  boolean isCellEditable(int row, int column){
            return false;
        }
    };

}
