package br.edu.ifsp.lp1p1.mapper.loan;

import br.edu.ifsp.lp1p1.dto.loan.LoanRequestDTO;
import br.edu.ifsp.lp1p1.model.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class LoanMapper {

    public static final LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "loanDate", ignore = true)
    public abstract Loan toLoan(LoanRequestDTO loanRequestDTO);
}
