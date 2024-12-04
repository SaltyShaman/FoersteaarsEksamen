package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.models.Calcemp;
import org.example.foersteaarseksamen.models.Calculator;
import org.example.foersteaarseksamen.repositories.CalcempRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CalcempService {

    private final CalcempRepository calcempRepository;

    public CalcempService(CalcempRepository calcempRepository) {
        this.calcempRepository = calcempRepository;
    }

    public List<Calculator> findAllCalculators() {
        return calcempRepository.findAllCalculators();
    }



    public Calcemp getCalcEmpDetails(String calculatorName) {
        return calcempRepository.getCalcEmpDetails(calculatorName);
    }
}
