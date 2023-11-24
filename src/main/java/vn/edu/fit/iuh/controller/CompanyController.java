package vn.edu.fit.iuh.controller;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.domain.Page;import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.*;import vn.edu.fit.iuh.enities.Address;import vn.edu.fit.iuh.enities.Candidate;import vn.edu.fit.iuh.enities.Company;import vn.edu.fit.iuh.enities.Job;import vn.edu.fit.iuh.repositories.CandidateRepository;import vn.edu.fit.iuh.repositories.CompanyRepository;import vn.edu.fit.iuh.repositories.JobRepository;import vn.edu.fit.iuh.sevices.AddressService;import vn.edu.fit.iuh.sevices.CandidateService;import vn.edu.fit.iuh.sevices.CompanyService;import java.util.List;import java.util.Optional;import java.util.stream.Collectors;import java.util.stream.IntStream;@Controller@RequestMapping("/companies")public class CompanyController {    @Autowired    private final CompanyService companyService;    @Autowired    private CompanyRepository companyRepository;    @Autowired    private JobRepository jobRepository;    @Autowired    public CompanyController(CompanyService companyService,CompanyRepository companyRepository) {        this.companyService = companyService;        this.companyRepository=companyRepository;    }    //    @GetMapping("/")//    public List<Candidate> getAllCandidates() {//        return candidateService.findAll();//    }    @GetMapping("/")    public List<Company> getAllCompany() {        return companyRepository.findAllCompanyWithAddress();    }    @GetMapping("/{id}")    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {        Company company = companyRepository.findById(id).orElse(null);        if (company != null) {            return ResponseEntity.ok(company);        } else {            return ResponseEntity.notFound().build();        }    }    @PostMapping("/")    public ResponseEntity<Company> createCandidate(@RequestBody Company company) {        if (companyService.save(company)) {            return ResponseEntity.status(201).body(company);        } else {            return ResponseEntity.status(500).build();        }    }    @PutMapping("/{id}")    public ResponseEntity<Company> updateAddress(@PathVariable Long id, @RequestBody Company company) {        company.setId(id);        if (companyService.update(company).isPresent()) {            return ResponseEntity.ok(company);        } else {            return ResponseEntity.notFound().build();        }    }    @DeleteMapping("/{id}")    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {        if (companyService.delete(id).isPresent()) {            return ResponseEntity.noContent().build();        } else {            return ResponseEntity.notFound().build();        }    }    //Load du lieu phan trang    @GetMapping("/paging")    public String showCompanyPaging(Model model,                                          @RequestParam("page") Optional<Integer> page,                                          @RequestParam("size") Optional<Integer> size) {        int currentPage = page.orElse(1);        int pageSize = size.orElse(20);        Page<Company> companyPage= companyService.findAllPage(                currentPage - 1,pageSize,"id","asc");        model.addAttribute("companyPage", companyPage);        int totalPages = companyPage.getTotalPages();        if (totalPages > 0) {            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)                    .boxed()                    .collect(Collectors.toList());            model.addAttribute("pageNumbers", pageNumbers);        }        return "company/company-paging";    }    //Xem các job có trong company    @GetMapping("/viewJob/{id}")    public String showJobByCompany(Model model,@PathVariable Long id){        List<Job> jobList=jobRepository.findByCompanyId(id);        model.addAttribute("jobList",jobList);        return "company/job-list";    }    @GetMapping("/postJob")    public String postJob(Model model){        model.addAttribute("jobs",new Job());        return "user/post_job";    }}