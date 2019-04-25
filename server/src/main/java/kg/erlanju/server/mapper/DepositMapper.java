package kg.erlanju.server.mapper;

import kg.erlanju.DepositRequest;
import kg.erlanju.server.dto.DepositRequestDto;

public interface DepositMapper {
    DepositRequestDto toDepositRequestDto(DepositRequest request);
}
