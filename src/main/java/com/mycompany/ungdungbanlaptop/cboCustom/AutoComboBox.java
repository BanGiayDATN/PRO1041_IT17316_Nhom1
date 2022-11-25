/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.cboCustom;

/**
 *
 * @author thang
 */
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AutoComboBox extends JComboBox<Object> {

    List<String> list ;
    Vector myVector = new Vector();

    public AutoComboBox() {

        setModel(new DefaultComboBoxModel(myVector));
        setSelectedIndex(-1);
        setEditable(true);
        JTextField text = (JTextField) this.getEditor().getEditorComponent();
        text.setFocusable(true);
        text.setText("");
        text.addKeyListener(new ComboListener(this, myVector));
        setMyVector();
    }

    /**
     * set the item list of the AutoComboBox
     *
     * @param keyWord an String array
     */
    public void setKeyWord(List<String> list) {
        this.list = list;
        setMyVectorInitial();
    }

    private void setMyVector() {
        int a;
        if(list != null){
             for (a = 0; a < list.size(); a++) {
            myVector.add(list.get(a));
        }
        }
    }

    private void setMyVectorInitial() {
        myVector.clear();
        int a;
         if(list != null){
             for (a = 0; a < list.size(); a++) {
            myVector.add(list.get(a));
        }
         }
    }

    public void setKeyWord(List<String> list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
