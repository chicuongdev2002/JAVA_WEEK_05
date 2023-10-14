package vn.edu.fit.iuh.sevices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vn.edu.fit.iuh.enities.Address;
import vn.edu.fit.iuh.enities.Company;
import vn.edu.fit.iuh.repositories.AddressRepository;
import vn.edu.fit.iuh.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CompanyService(CompanyRepository companyRepository,AddressRepository addressRepository) {
        this.companyRepository = companyRepository;
        this.addressRepository=addressRepository;
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
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent() && company.get().getAddress() != null) {
            // Lấy thông tin địa chỉ nếu addressId tồn tại
            Optional<Address> address = addressRepository.findById(company.get().getAddress().getId());
            if (address.isPresent()) {
                company.get().setAddress(address.get());
            }
        }
        return company;
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
