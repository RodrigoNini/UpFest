package com.UpFest.App.services;

import com.UpFest.App.entities.ProdutoComerciante;
import org.springframework.stereotype.Service;

public interface CashlessService {

    boolean addItem(ProdutoComerciante produtoComerciante);

}
