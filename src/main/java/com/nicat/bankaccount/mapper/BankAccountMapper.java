package com.nicat.bankaccount.mapper;

import com.nicat.bankaccount.dto.BankAccountDto;
import com.nicat.bankaccount.entity.BankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankAccountMapper {

    BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "accountNumber", target = "accountNumber")
    @Mapping(source = "balance", target = "balance")
    BankAccountDto bankAccountToBankAccountDTO(BankAccount bankAccount);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "accountNumber", target = "accountNumber")
    @Mapping(source = "balance", target = "balance")
    BankAccount bankAccountDTOToBankAccount(BankAccountDto bankAccountDTO);
}
