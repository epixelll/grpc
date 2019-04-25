package kg.erlanju.client.dto;

import kg.erlanju.client.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WithdrawRequestDto {
    private Integer userId;
    private Double amount;
    private Currency currency;
}
