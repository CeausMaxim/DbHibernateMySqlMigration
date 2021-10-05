package com.example.dbhibernatemysqlmigration.service.impl;

import com.example.dbhibernatemysqlmigration.exception.ResourceNotFoundException;
import com.example.dbhibernatemysqlmigration.model.City;
import com.example.dbhibernatemysqlmigration.repository.CityRepository;
import com.example.dbhibernatemysqlmigration.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository){
        super();
        this.cityRepository = cityRepository;
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City get(long id) {
        return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", "id", id));
    }

    @Override
    public City update(City country, long id) {
        City existingCountry = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", "id", id));
        existingCountry.setName(country.getName());
        cityRepository.save(existingCountry);
        return null;
    }

    @Override
    public void delete(long id) {
        cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", "id", id));
        cityRepository.deleteById(id);
    }
}
