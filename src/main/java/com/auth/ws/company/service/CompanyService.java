package com.auth.ws.company.service;
import com.auth.ws.company.entity.AppCompany;
import com.auth.ws.company.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public AppCompany register(AppCompany appCompany) {
       companyRepository.save(appCompany);
       return appCompany;
    }

    public List<AppCompany> getUserCompanyAll(String name) {
        if(name.equalsIgnoreCase("argebul_Company"))
            return companyRepository.findFirsts(PageRequest.of(0,25));
        else
            return companyRepository.findByName(name, PageRequest.of(0,25));
    }

    public AppCompany getCompanyById(Long id) {
        Optional<AppCompany> appCompany=companyRepository.findById(id);
        if (appCompany.isEmpty()) return null;
        return appCompany.get();
    }
}
