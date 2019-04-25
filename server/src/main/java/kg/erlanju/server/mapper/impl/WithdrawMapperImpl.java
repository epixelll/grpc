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
        return new WithdrawRequestDto(
                request.getUserId(),
                Currency.valueOf(request.getCurrency().toString()),
                BigDecimal.valueOf(request.getAmount())
        );
    }
}
