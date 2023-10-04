package com.UpFest.App.services;

import com.UpFest.App.repositories.CashlessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class CashlessServiceImp implements CashlessService{

    @Autowired
    CashlessRepository cashlessRepository;


}
