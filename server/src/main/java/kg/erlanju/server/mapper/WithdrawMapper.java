package kg.erlanju.server.mapper;

import kg.erlanju.WithdrawRequest;
import kg.erlanju.server.dto.WithdrawRequestDto;

public interface WithdrawMapper {
    WithdrawRequestDto toWithdrawRequestDto(WithdrawRequest request);
}
