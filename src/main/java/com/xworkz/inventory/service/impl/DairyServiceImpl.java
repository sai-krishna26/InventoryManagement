package com.xworkz.inventory.service.impl;

import com.xworkz.inventory.dto.DairyDto;
import com.xworkz.inventory.entity.DairyEntity;
import com.xworkz.inventory.repo.DairyRepo;
import com.xworkz.inventory.service.DairyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DairyServiceImpl implements DairyService {

    private DairyRepo dairyRepo;
    private BCryptPasswordEncoder passwordEncoder;

    public DairyServiceImpl(DairyRepo dairyRepo, BCryptPasswordEncoder passwordEncoder) {
        this.dairyRepo = dairyRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public boolean save(DairyDto dairyDto) {
        System.out.println("save() in DairyServiceImpl");
        if(dairyDto!=null)
        {
            System.out.println("dto is not null, so sending from service to repo");
            DairyEntity dairyEntity = new DairyEntity();


            String ePhone = passwordEncoder.encode(dairyDto.getPhoneNumber());
            System.out.println("encoded phone number: "+ePhone);
            dairyDto.setPhoneNumber(ePhone);


            BeanUtils.copyProperties(dairyDto,dairyEntity);
            this.dairyRepo.save(dairyEntity);
            return true;
        }

        return false;
    }
}
