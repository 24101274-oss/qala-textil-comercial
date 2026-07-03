package UTIL;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;
import UTIL.DocumentFlags;

public class FixedDigitsFilter extends DocumentFilter {

    private final int fixedLength;

    public FixedDigitsFilter(int fixedLength) {
        this.fixedLength = fixedLength;
    }

    private boolean valido(String text) {
        return text.matches("[0-9]*");
    }

    private boolean isProgrammaticChange(FilterBypass fb) {
        if (fb.getDocument() instanceof AbstractDocument doc) {
            Object o = doc.getProperty(DocumentFlags.PROGRAMMATIC_CHANGE);
            return Boolean.TRUE.equals(o);
        }
        return false;
    }

    private boolean longitudValida(String contenido) {
        return contenido.length() <= fixedLength;
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

            if (!longitudValida(nuevo)) return;
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

            if (!longitudValida(nuevo)) return;
        }

        super.replace(fb, offset, length, text, attrs);
    }
}
