package com.auth.ws.company.controller;

import com.auth.ws.company.controller.dto.CompanyDTO;
import com.auth.ws.company.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/1.0/company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/getAll/{name}")
    public List<CompanyDTO> getUserCompanyAll(@PathVariable String name) {
        return companyService.getUserCompanyAll(name).stream().map(CompanyDTO::new).toList();
    }

}
