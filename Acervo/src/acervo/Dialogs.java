package acervo;

import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
class Dialogs {

    Dialogs () {}

    static void erro (String msg, String titulo) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.ERROR_MESSAGE);
    }

    static void sucesso (String msg, String titulo) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

}
