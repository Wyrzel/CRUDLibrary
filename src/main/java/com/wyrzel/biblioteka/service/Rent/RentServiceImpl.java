package com.wyrzel.biblioteka.service.Rent;

import com.wyrzel.biblioteka.model.Rent;
import com.wyrzel.biblioteka.model.User;
import com.wyrzel.biblioteka.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Override
    public List<Rent> findRentsByUser(User user) {
        return rentRepository.findByUser(user);

    }

    @Override
    public void saveRent(Rent rent) {
        rentRepository.save(rent);

    }

    @Override
    public void deleteRent(Long id) {
        rentRepository.delete(id);
    }
}
