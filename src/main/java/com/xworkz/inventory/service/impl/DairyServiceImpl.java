package com.xworkz.inventory.service.impl;

import com.xworkz.inventory.dto.DairyDto;
import com.xworkz.inventory.entity.DairyEntity;
import com.xworkz.inventory.repo.DairyRepo;
import com.xworkz.inventory.service.DairyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DairyServiceImpl implements DairyService {
    @Autowired
    DairyRepo dairyRepo;

    @Override
    @Transactional
    public boolean save(DairyDto dairyDto) {
        System.out.println("save() in DairyServiceImpl");
        if(dairyDto!=null)
        {
            System.out.println("dto is not null, so sending from service to repo");
            DairyEntity dairyEntity = new DairyEntity();
            BeanUtils.copyProperties(dairyDto,dairyEntity);
            this.dairyRepo.save(dairyEntity);
            return true;
        }

        return false;
    }
}
