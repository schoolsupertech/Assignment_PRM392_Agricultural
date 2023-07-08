package assignment.assignment_prm392.exception;

import androidx.annotation.Nullable;

public class ProductException extends Throwable {
    public ProductException(@Nullable @org.jetbrains.annotations.Nullable String message, @Nullable @org.jetbrains.annotations.Nullable Throwable cause) {
        super(message, cause);
    }

    public ProductException(@Nullable @org.jetbrains.annotations.Nullable Throwable cause) {
        super(cause);
    }

    public ProductException(@Nullable @org.jetbrains.annotations.Nullable String message, @Nullable @org.jetbrains.annotations.Nullable Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProductException() {
    }
}
