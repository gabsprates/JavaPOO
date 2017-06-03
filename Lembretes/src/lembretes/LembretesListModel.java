/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lembretes;

import java.util.List;

/**
 *
 * @author gabriel
 */
public class LembretesListModel extends javax.swing.AbstractListModel<String>{

    String[] strings;

    public LembretesListModel(List<String> lista) {

        this.strings = new String[lista.size()];

        this.strings = lista.toArray(this.strings);

    }
    

    @Override
    public int getSize() {
        return this.strings.length;
    }

    @Override
    public String getElementAt(int i) {
        return this.strings[i];
    }
    
}
