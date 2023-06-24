package ca.agoldfish.tdforeclosurefinalproject.validators;

import android.util.Patterns;

import com.google.android.material.textfield.TextInputLayout;

public class EmailFieldValidator extends BaseValidator {
    public EmailFieldValidator(TextInputLayout errorContainer) {
        super(errorContainer);
        mErrorMessage = "Invalid Email Address";
        mEmptyMessage = "Missing Email Address";
    }

    @Override
    protected boolean isValid(CharSequence charSequence) {
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }
}