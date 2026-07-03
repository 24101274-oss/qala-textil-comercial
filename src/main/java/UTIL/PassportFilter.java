package UTIL;

import javax.swing.text.*;

public class PassportFilter extends DocumentFilter {

    private final int maxLength;

    public PassportFilter(int maxLength) {
        this.maxLength = maxLength;
    }

    private boolean valido(String text) {
        return text.matches("[A-Za-z0-9]*");
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text,
                             AttributeSet attr) throws BadLocationException {

        if (text == null || !valido(text)) return;

        int newLength = fb.getDocument().getLength() + text.length();
        if (newLength > maxLength) return;

        super.insertString(fb, offset, text, attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {

        if (text == null || !valido(text)) return;

        int newLength = fb.getDocument().getLength() - length + text.length();
        if (newLength > maxLength) return;

        super.replace(fb, offset, length, text, attrs);
    }
}
