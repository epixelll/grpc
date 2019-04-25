package kg.erlanju.client.dto;

import kg.erlanju.client.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class WalletInfoDto {
    private Currency currency;
    private BigDecimal amount;
}
