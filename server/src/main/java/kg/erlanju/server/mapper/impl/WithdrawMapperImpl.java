package kg.erlanju.server.mapper.impl;

import kg.erlanju.WithdrawRequest;
import kg.erlanju.server.dto.WithdrawRequestDto;
import kg.erlanju.server.enums.Currency;
import kg.erlanju.server.mapper.WithdrawMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WithdrawMapperImpl implements WithdrawMapper {

    @Override
    public WithdrawRequestDto toWithdrawRequestDto(WithdrawRequest request) {
        Currency currency;
        try{
            currency = Currency.valueOf(request.getCurrency().toString());
        } catch (Exception e) {
            throw new IllegalStateException("unknown_currency");
        }
        return new WithdrawRequestDto(
                request.getUserId(),
                currency,
                BigDecimal.valueOf(request.getAmount())
        );
    }
}
