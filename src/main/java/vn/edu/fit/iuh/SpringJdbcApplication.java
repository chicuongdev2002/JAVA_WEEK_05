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

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

    @Bean
    CommandLineRunner x() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                    List<Candidate> list= candidateRepository.findAllCandidatesWithAddress();
//                    list.forEach(p-> System.out.println(p));
//                Random rnd = new Random();
//                for (int i = 1; i < 1000; i++) {
//                    Address add = new Address("Nguyen Van Bao", "HCM", CountryCode.VN, rnd.nextInt(1, 1000) + "", rnd.nextInt(70000, 80000) + "");
//                    addressRepository.save(add);
//                    Candidate can = new Candidate(LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)), "email_" + i + "@gmail.com", "Name #" + i, rnd.nextLong(1111111111L, 9999999999L) + "", add);
//                    candidateRepository.save(can);
//                    System.out.println("Added: " + can);
//                    Address a = new Address("Le Loi", "HCM", CountryCode.VN, "123", "70000");
//                    addressRepository.save(a);
//                System.out.println(a);
//                }
//            }

            }
        };
    }

}
