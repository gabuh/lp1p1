package br.edu.ifsp.lp1p1.controller;

import br.edu.ifsp.lp1p1.dto.loan.LoanResponseDTO;
import br.edu.ifsp.lp1p1.model.User;
import br.edu.ifsp.lp1p1.service.LoanService;
import br.edu.ifsp.lp1p1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<LoanResponseDTO>> findAll(){
        List<LoanResponseDTO> loanResponseDTOs = this.loanService.findAll();
        return ResponseEntity.ok(loanResponseDTOs);
    }

    @GetMapping("/find")
    public ResponseEntity<List<LoanResponseDTO>> findAllByParam(@RequestParam(required = false) Long clientId,
                                                                @RequestParam(required = false) String date){

        if(clientId != null) {
            User client = this.userService.findById(clientId);
            List<LoanResponseDTO> loanResponseDTOs = this.loanService.findAllByClient(client);
            return ResponseEntity.ok(loanResponseDTOs);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
//        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.of(23, 59, 0));
//        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);

        List<LoanResponseDTO> loanResponseDTOs = this.loanService.findAll();
        List<LoanResponseDTO> filteredLoanResponseDTOs = new ArrayList<>();
        for (LoanResponseDTO l : loanResponseDTOs){
            LocalDate loanResponseLocalDate = l.loanDate().atZone(ZoneOffset.UTC).toLocalDate();
            if(loanResponseLocalDate != localDate){
                filteredLoanResponseDTOs.add(l);
            }
        }
        return ResponseEntity.ok(filteredLoanResponseDTOs);
    }

}
