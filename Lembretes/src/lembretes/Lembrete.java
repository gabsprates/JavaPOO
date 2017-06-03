/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lembretes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 *
 * @author gabriel
 */
public class Lembrete implements Runnable {

    String titulo;
    Timer timer;
    Date data;
    
    public Lembrete(String titulo, Date data) {
        
        this.titulo = titulo;
        this.data   = data;
        
    }

    
    @Override
    public void run() {
        this.timer = new Timer();
        LembreteTask task = new LembreteTask(this.titulo, this.getDataFormatada());
        this.timer.schedule(task, this.data);
    }


    @Override
    public String toString() {
        return this.getDataFormatada() + " :: " + this.titulo;
    }

    
    public String getDataFormatada() {
        
        SimpleDateFormat formatar = new SimpleDateFormat("[dd/MM/yyyy HH:mm]");
        return formatar.format(this.data);

    }

    public void cancelar() {
        this.timer.cancel();
    }
    
}
