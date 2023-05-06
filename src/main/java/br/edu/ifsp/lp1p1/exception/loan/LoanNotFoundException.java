package br.edu.ifsp.lp1p1.exception.loan;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LoanNotFoundException extends RuntimeException{

    public LoanNotFoundException(Long id){
        super("loan: "+id+" not found");
    }
}
