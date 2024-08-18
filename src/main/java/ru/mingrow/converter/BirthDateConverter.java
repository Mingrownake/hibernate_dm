package ru.mingrow.converter;

import ru.mingrow.model.BirthDate;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.util.Optional;

public class BirthDateConverter implements AttributeConverter<BirthDate, Date> {
    @Override
    public Date convertToDatabaseColumn(BirthDate birthDate) {
        return Optional.ofNullable(birthDate)
                .map(BirthDate::birthDate)
                .map(Date::valueOf)
                .orElse(null);
    }

    @Override
    public BirthDate convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
                .map(convertedDate -> new BirthDate(convertedDate.toLocalDate()))
                .orElse(null);
    }
}
