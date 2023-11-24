package vn.edu.fit.iuh;

import com.neovisionaries.i18n.CountryCode;
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
import vn.edu.fit.iuh.repositories.JobRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;


@SpringBootApplication
@EnableWebMvc
public class SpringJdbcApplication {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private JobRepository jobRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

    @Bean
    CommandLineRunner x() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
              // System.out.println(jobRepository.findByCompanyId(1));
               // System.out.println(candidateRepository.existsCandidateByEmail("chicuong11042002@gmail.com"));
//                System.out.println(candidateRepository.findNameByEmail("chicuong11042002@gmail.com"));

            }
        };
    }

}
