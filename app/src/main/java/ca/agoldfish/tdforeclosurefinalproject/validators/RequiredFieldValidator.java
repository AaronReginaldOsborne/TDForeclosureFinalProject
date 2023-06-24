package ca.agoldfish.tdforeclosurefinalproject.validators;

import com.google.android.material.textfield.TextInputLayout;

public class RequiredFieldValidator extends BaseValidator {
    public RequiredFieldValidator(TextInputLayout errorContainer) {
        super(errorContainer);
        mEmptyMessage = "This Field is required";
    }

    @Override
    protected boolean isValid(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }
}