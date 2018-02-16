package com.wyrzel.biblioteka.service.Rent;

import com.wyrzel.biblioteka.model.Rent;
import com.wyrzel.biblioteka.model.User;
import com.wyrzel.biblioteka.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    @Override
    public List<Rent> getAllRents() {
        List<Rent> AllRents = new ArrayList<>();
        rentRepository.findAll().forEach(AllRents::add);
        return AllRents;

    }

    @Override
    public Rent findRent(Long id) {
        return rentRepository.findOne(id);

    }
}
