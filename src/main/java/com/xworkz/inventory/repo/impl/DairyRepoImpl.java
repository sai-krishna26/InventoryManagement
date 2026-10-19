package com.xworkz.inventory.repo.impl;

import com.xworkz.inventory.entity.DairyEntity;
import com.xworkz.inventory.repo.DairyRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DairyRepoImpl implements DairyRepo {

    public DairyRepoImpl()
    {
        System.out.println("created DairyRepoImpl");
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(DairyEntity dairyEntity) {

        System.out.println("save() in DairyRepoImpl");
        entityManager.persist(dairyEntity);
        return true;
    }
}
