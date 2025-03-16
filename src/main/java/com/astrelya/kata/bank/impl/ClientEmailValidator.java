package com.astrelya.kata.bank.impl;
import com.astrelya.kata.bank.IClientValidator;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ClientEmailValidator  implements IClientValidator {



    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @Override
    public boolean isValidEmail(final String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
