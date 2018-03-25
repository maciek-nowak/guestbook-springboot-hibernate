package com.codecool.krk.mcnowak.dao;

import com.codecool.krk.mcnowak.models.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Integer> {

}