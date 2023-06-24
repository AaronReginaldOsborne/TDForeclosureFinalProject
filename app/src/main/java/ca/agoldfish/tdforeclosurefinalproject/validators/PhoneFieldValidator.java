package ca.agoldfish.tdforeclosurefinalproject.validators;

import android.util.Patterns;

import com.google.android.material.textfield.TextInputLayout;

public class PhoneFieldValidator extends BaseValidator {
    public PhoneFieldValidator(TextInputLayout errorContainer) {
        super(errorContainer);
        mErrorMessage = "Invalid Phone Number";
        mEmptyMessage = "Missing Phone Number";
    }

    @Override
    protected boolean isValid(CharSequence charSequence) {
        return Patterns.PHONE.matcher(charSequence).matches();
    }
}