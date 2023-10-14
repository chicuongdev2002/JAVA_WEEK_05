package vn.edu.fit.iuh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import vn.edu.fit.iuh.enities.Address;
import vn.edu.fit.iuh.enities.Candidate;
import vn.edu.fit.iuh.repositories.AddressRepository;
import vn.edu.fit.iuh.repositories.CandidateRepository;

import java.util.List;


@SpringBootApplication
@EnableWebMvc
public class SpringJdbcApplication {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CandidateRepository candidateRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }
    @Bean
    CommandLineRunner x(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                    List<Candidate> list= candidateRepository.findAllCandidatesWithAddress();
//                    list.forEach(p-> System.out.println(p));

            }
        };
    }
}
