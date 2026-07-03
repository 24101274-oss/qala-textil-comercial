package UTIL;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;
import UTIL.DocumentFlags;

public class MaxLengthFilter extends DocumentFilter {

    private final int maxLength;

    public MaxLengthFilter(int maxLength) {
        this.maxLength = maxLength;
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
            int currentLength = fb.getDocument().getLength();
            int newLength = currentLength - length + text.length();
            if (newLength > maxLength) return;
        }

        super.replace(fb, offset, length, text, attrs);
    }
}
