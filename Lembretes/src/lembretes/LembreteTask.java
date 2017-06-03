/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lembretes;

import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
class LembreteTask extends TimerTask {

    String msg;
    String titulo;

    public LembreteTask(String msg, String titulo) {
        this.msg = msg;
        this.titulo = titulo;
    }

    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, this.msg, this.titulo, JOptionPane.INFORMATION_MESSAGE);
    }

}