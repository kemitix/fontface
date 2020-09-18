package net.kemitix.fontface;

public class FatalFontFaceError extends RuntimeException {
    public FatalFontFaceError(final String message) {
        super(message);
    }

    public FatalFontFaceError(final String message, final Throwable cause) {
        super(message, cause);
    }
}
