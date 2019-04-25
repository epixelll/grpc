package kg.erlanju.server.dto;

import kg.erlanju.server.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class WithdrawRequestDto {
    private Integer accountId;
    private Currency currency;
    private BigDecimal amount;
}
