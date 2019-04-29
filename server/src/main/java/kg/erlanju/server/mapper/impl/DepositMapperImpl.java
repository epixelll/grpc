package kg.erlanju.server.mapper.impl;

import kg.erlanju.DepositRequest;
import kg.erlanju.server.dto.DepositRequestDto;
import kg.erlanju.server.enums.Currency;
import kg.erlanju.server.mapper.DepositMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DepositMapperImpl implements DepositMapper {

    @Override
    public DepositRequestDto toDepositRequestDto(DepositRequest request) {
        Currency currency;
        try{
            currency = Currency.valueOf(request.getCurrency().toString());
        } catch (Exception e) {
            throw new IllegalStateException("unknown_currency");
        }
        return new DepositRequestDto(
                request.getUserId(),
                currency,
                BigDecimal.valueOf(request.getAmount())
        );
    }
}
