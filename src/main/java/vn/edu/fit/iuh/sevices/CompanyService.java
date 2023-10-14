package vn.edu.fit.iuh.sevices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vn.edu.fit.iuh.enities.Company;
import vn.edu.fit.iuh.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public boolean save(Company company) {
        try {
            companyRepository.save(company);

            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return false;
    }

    public Optional<Company> findById(long id) {
        return companyRepository.findById(id);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Boolean> update(Company company) {
        if (!companyRepository.existsById(company.getId())) { // Sử dụng phương thức existsById để kiểm tra sự tồn tại
            return Optional.empty(); // Trả về empty nếu không tồn tại
        }

        try {
            companyRepository.save(company);
            return Optional.of(true);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return Optional.of(false);
    }

    public Optional<Boolean> delete(long id) {
        if (!companyRepository.existsById(id)) {
            return Optional.empty();
        }
        try {
            companyRepository.deleteById(id);
            return Optional.of(true);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.of(false);
    }

}
