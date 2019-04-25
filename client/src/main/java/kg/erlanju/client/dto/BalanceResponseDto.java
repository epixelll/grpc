package kg.erlanju.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class BalanceResponseDto {
    private Integer accountId;
    private Set<WalletInfoDto> wallets;
}
