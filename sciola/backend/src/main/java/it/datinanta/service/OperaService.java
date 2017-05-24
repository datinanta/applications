/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.datinanta.service;

import it.datinanta.model.Opera;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import it.datinanta.repository.OperaRepository;

/**
 *
 * @author Diego
 */
@Service
public class OperaService {

    @Autowired
    private OperaRepository repo;

    public Opera insert(Opera opera) {
        opera.setId(UUID.randomUUID().toString());
        repo.insert(opera);
        return opera;
    }

    public Opera findById(String id) {
        return repo.findById(id);
    }

    public Opera update(Opera opera) {
        Opera operaFound = null;
        operaFound = repo.findById(opera.getId());
        if (operaFound != null) {
            repo.delete(operaFound);
            repo.insert(opera);
        }
        return opera;
    }

    public List<Opera> findAll() {
        return repo.findAll();
    }
    
        public boolean delete(String id){
            Opera opera = repo.findOne(id);
            Boolean founded = true;
            if (opera!=null){
              founded= true;
               repo.delete(opera);
            } else{
                founded= false;
            }
         return founded;
    }
    

}
