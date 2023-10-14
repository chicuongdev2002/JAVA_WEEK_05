package vn.edu.fit.iuh.controller;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.*;import vn.edu.fit.iuh.enities.Address;import vn.edu.fit.iuh.enities.Candidate;import vn.edu.fit.iuh.enities.Company;import vn.edu.fit.iuh.repositories.CandidateRepository;import vn.edu.fit.iuh.repositories.CompanyRepository;import vn.edu.fit.iuh.sevices.AddressService;import vn.edu.fit.iuh.sevices.CandidateService;import vn.edu.fit.iuh.sevices.CompanyService;import java.util.List;@Controller@RequestMapping("/companies")public class CompanyController {    @Autowired    private final CompanyService companyService;    @Autowired    private CompanyRepository companyRepository;    @Autowired    public CompanyController(CompanyService companyService,CompanyRepository companyRepository) {        this.companyService = companyService;        this.companyRepository=companyRepository;    }    //    @GetMapping("/")//    public List<Candidate> getAllCandidates() {//        return candidateService.findAll();//    }    @GetMapping("/")    public List<Company> getAllCompany() {        return companyRepository.findAllCompanyWithAddress();    }    @GetMapping("/{id}")    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {        Company company = companyRepository.findById(id).orElse(null);        if (company != null) {            return ResponseEntity.ok(company);        } else {            return ResponseEntity.notFound().build();        }    }    @PostMapping("/")    public ResponseEntity<Company> createCandidate(@RequestBody Company company) {        if (companyService.save(company)) {            return ResponseEntity.status(201).body(company);        } else {            return ResponseEntity.status(500).build();        }    }    @PutMapping("/{id}")    public ResponseEntity<Company> updateAddress(@PathVariable Long id, @RequestBody Company company) {        company.setId(id);        if (companyService.update(company).isPresent()) {            return ResponseEntity.ok(company);        } else {            return ResponseEntity.notFound().build();        }    }    @DeleteMapping("/{id}")    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {        if (companyService.delete(id).isPresent()) {            return ResponseEntity.noContent().build();        } else {            return ResponseEntity.notFound().build();        }    }}