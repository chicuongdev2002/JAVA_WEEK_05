package vn.edu.fit.iuh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.fit.iuh.enities.company;
import vn.edu.fit.iuh.enities.Skill;
import vn.edu.fit.iuh.enums.SkillType;
import vn.edu.fit.iuh.repositories.companyRepository;


@SpringBootApplication
public class SpringJdbcApplication {
    @Autowired
private companyRepository companyRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }
    @Bean
    CommandLineRunner x(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                company a=new company(1l,"Nguyen Van Bao","Ho Chi Minh",1,"2","100001")
//               companyRepository.save()

            }
        };
    }
}
