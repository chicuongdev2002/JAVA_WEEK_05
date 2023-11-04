package vn.edu.fit.iuh.controller;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.domain.Page;import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.*;import vn.edu.fit.iuh.enities.Candidate;import vn.edu.fit.iuh.repositories.CandidateRepository;import vn.edu.fit.iuh.sevices.CandidateService;import java.util.List;import java.util.Optional;import java.util.stream.Collectors;import java.util.stream.IntStream;@Controller@RequestMapping("/candidates")public class CandidateController {    @Autowired    private final CandidateService candidateService;    @Autowired    private CandidateRepository candidateRepository;    @Autowired    public CandidateController(CandidateService candidateService,CandidateRepository candidateRepository) {        this.candidateService = candidateService;        this.candidateRepository=candidateRepository;    }//    @GetMapping("/")//    public List<Candidate> getAllCandidates() {//        return candidateService.findAll();//    }//@GetMapping("/")//public List<Candidate> getAllCandidates() {//    return candidateRepository.findAllCandidatesWithAddress();//}//Load du lieu khong phan trang    @GetMapping("/list")    public String getAllCandidates(Model model) {        System.out.println("aaa");        List<Candidate> candidates = candidateRepository.findAll();        model.addAttribute("candidates", candidates);        return "candidates/candidates";    }    @GetMapping("/{id}")    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {        Candidate candidate = candidateService.findById(id).orElse(null);        if (candidate != null) {            return ResponseEntity.ok(candidate);        } else {            return ResponseEntity.notFound().build();        }    }    @PostMapping("/")    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {        if (candidateService.save(candidate)) {            return ResponseEntity.status(201).body(candidate);        } else {            return ResponseEntity.status(500).build();        }    }    @PutMapping("/{id}")    public ResponseEntity<Candidate> updateAddress(@PathVariable Long id, @RequestBody Candidate candidate) {        candidate.setId(id);        if (candidateService.update(candidate).isPresent()) {            return ResponseEntity.ok(candidate);        } else {            return ResponseEntity.notFound().build();        }    }    @DeleteMapping("/{id}")    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {        if (candidateService.delete(id).isPresent()) {            return ResponseEntity.noContent().build();        } else {            return ResponseEntity.notFound().build();        }    }    //Load du lieu phan trang    @GetMapping("/candidates")    public String showCandidateListPaging(Model model,                                          @RequestParam("page") Optional<Integer> page,                                          @RequestParam("size") Optional<Integer> size) {        int currentPage = page.orElse(1);        int pageSize = size.orElse(20);        Page<Candidate> candidatePage= candidateService.findAllPage(                currentPage - 1,pageSize,"id","asc");        model.addAttribute("candidatePage", candidatePage);        int totalPages = candidatePage.getTotalPages();        if (totalPages > 0) {            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)                    .boxed()                    .collect(Collectors.toList());            model.addAttribute("pageNumbers", pageNumbers);        }        return "candidates/candidates-paging";    }}