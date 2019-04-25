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
        return new DepositRequestDto(
                request.getUserId(),
                Currency.valueOf(request.getCurrency().toString()),
                BigDecimal.valueOf(request.getAmount())
        );
    }
}
