package assignment.assignment_prm392.exception;

import androidx.annotation.Nullable;

public class PhoneException extends Throwable {
    private static final long serialVersionUID = 1L;

    public PhoneException(String message) {
        super(message);
    }

    public PhoneException(@Nullable @org.jetbrains.annotations.Nullable String message, @Nullable @org.jetbrains.annotations.Nullable Throwable cause) {
        super(message, cause);
    }

    public PhoneException(@Nullable @org.jetbrains.annotations.Nullable Throwable cause) {
        super(cause);
    }

    public PhoneException(@Nullable @org.jetbrains.annotations.Nullable String message, @Nullable @org.jetbrains.annotations.Nullable Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PhoneException() {
    }
}
