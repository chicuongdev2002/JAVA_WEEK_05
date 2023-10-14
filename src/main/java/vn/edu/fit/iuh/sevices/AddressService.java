package vn.edu.fit.iuh.sevices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vn.edu.fit.iuh.enities.Address;
import vn.edu.fit.iuh.repositories.AddressRepository;


import java.util.List;
import java.util.Optional;
@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public boolean save(Address address) {
        try {
            addressRepository.save(address);

            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return false;
    }

    public Optional<Address> findById(long id) {
        return addressRepository.findById(id);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Optional<Boolean> update(Address address) {
        if (!addressRepository.existsById(address.getId())) { // Sử dụng phương thức existsById để kiểm tra sự tồn tại
            return Optional.empty(); // Trả về empty nếu không tồn tại
        }

        try {
            addressRepository.save(address);
            return Optional.of(true);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return Optional.of(false);
    }

    public Optional<Boolean> delete(long id) {
        if (!addressRepository.existsById(id)) {
            return Optional.empty();
        }
        try {
            addressRepository.deleteById(id);
            return Optional.of(true);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.of(false);
    }

}
