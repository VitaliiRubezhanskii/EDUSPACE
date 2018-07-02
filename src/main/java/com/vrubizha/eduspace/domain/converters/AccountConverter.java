package com.vrubizha.eduspace.domain.converters;

import com.vrubizha.eduspace.domain.Account;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter
public class AccountConverter implements AttributeConverter<Account,String> {

    private static final String SEPARATOR = "|";

    @Override
    public String convertToDatabaseColumn(Account account) {
        StringBuilder sb = new StringBuilder();
        sb.append(account.getId())
                .append(SEPARATOR)
                .append(account.getAccountUID());


        return sb.toString();
    }

    @Override
    public Account convertToEntityAttribute(String s) {

        String[] accountField = s.split(SEPARATOR);
       Account account=new Account();
       account.setId(Integer.parseInt(accountField[0]));
       account.setAccountUID(Integer.parseInt(accountField[2]));
       return account;
    }
}
