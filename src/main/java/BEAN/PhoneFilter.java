package BEAN;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;
import UTIL.DocumentFlags;

public class PhoneFilter extends DocumentFilter {

    private final int maxLength;

    public PhoneFilter(int maxLength) {
        this.maxLength = maxLength;
    }

    private boolean valido(String text) {
        return text.matches("[0-9+ -]*");
    }

    private boolean isProgrammatic(FilterBypass fb) {
        if (!(fb.getDocument() instanceof AbstractDocument doc)) {
            return false;
        }
        Object owner = doc.getProperty("filterNewlines");
        return false;
    }

    private boolean isProgrammaticChange(FilterBypass fb) {
        if (fb.getDocument() instanceof AbstractDocument doc) {
            Object o = doc.getProperty(DocumentFlags.PROGRAMMATIC_CHANGE);
            return Boolean.TRUE.equals(o);
        }
        return false;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text,
                             AttributeSet attr) throws BadLocationException {

        if (text == null) return;

        if (!isProgrammaticChange(fb)) {
            if (!valido(text)) return;

            int newLength = fb.getDocument().getLength() + text.length();
            if (newLength > maxLength) return;
        }

        super.insertString(fb, offset, text, attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {

        if (text == null) return;

        if (!isProgrammaticChange(fb)) {
            if (!valido(text)) return;

            int currentLength = fb.getDocument().getLength();
            int newLength = currentLength - length + text.length();
            if (newLength > maxLength) return;
        }

        super.replace(fb, offset, length, text, attrs);
    }
}
