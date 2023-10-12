package vn.edu.fit.iuh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.fit.iuh.enities.Skill;
import vn.edu.fit.iuh.enums.SkillType;


@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }
    @Bean
    CommandLineRunner x(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                Skill skill1 = new Skill();
//                skill1.setSkill_id(UUID.randomUUID()); // Tạo UUID ngẫu nhiên
//                skill1.setSkill_description("Lap trinh Python");
//                skill1.setSkill_name("Python");
//                skill1.setType(SkillType.FIRM);
//                skillDAO.insert(skill1);
//                List<Skill> list = skillDAO.getAll();
//                list.forEach(p-> System.out.println(p));
//                boolean rs= skillDAO.delete(UUID.fromString("ff3ec1f7-22b6-4d9a-bb80-025e18d6eb8c"));
//                if(rs==true)
//                {
//                    System.out.println("Thanh cong");
//                }else
//                {
//                    System.out.println("That bai");
//                }
//                Skill s= skillDAO.getById(UUID.fromString("ff3ec1f7-22b6-4d9a-bb80-025e18d6eb8c"));
//                System.out.println(s);
            }
        };
    }
}
