package BEAN;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;
import UTIL.DocumentFlags;

public class PriceFilter extends DocumentFilter {

    private static final int MAX_INTEGER_DIGITS = 8;
    private static final int MAX_DECIMAL_DIGITS = 2;

    private boolean isProgrammaticChange(FilterBypass fb) {
        if (fb.getDocument() instanceof AbstractDocument doc) {
            Object o = doc.getProperty(DocumentFlags.PROGRAMMATIC_CHANGE);
            return Boolean.TRUE.equals(o);
        }
        return false;
    }

    private boolean valido(String text) {
        return text.matches("[0-9.]*");
    }

    private boolean formatoValido(String contenido) {
        if (contenido.isEmpty()) return true;

        if (contenido.chars().filter(c -> c == '.').count() > 1) {
            return false;
        }

        String[] partes = contenido.split("\\.", -1);

        if (partes[0].length() > MAX_INTEGER_DIGITS) {
            return false;
        }

        if (partes.length == 2 && partes[1].length() > MAX_DECIMAL_DIGITS) {
            return false;
        }

        return true;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text,
                             AttributeSet attr) throws BadLocationException {

        if (text == null) return;

        if (!isProgrammaticChange(fb)) {

            if (!valido(text)) return;

            String actual = fb.getDocument().getText(0, fb.getDocument().getLength());
            String nuevo = new StringBuilder(actual)
                    .insert(offset, text)
                    .toString();

            if (!formatoValido(nuevo)) return;
        }

        super.insertString(fb, offset, text, attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {

        if (text == null) return;

        if (!isProgrammaticChange(fb)) {

            if (!valido(text)) return;

            String actual = fb.getDocument().getText(0, fb.getDocument().getLength());
            String nuevo = new StringBuilder(actual)
                    .replace(offset, offset + length, text)
                    .toString();

            if (!formatoValido(nuevo)) return;
        }

        super.replace(fb, offset, length, text, attrs);
    }
}
