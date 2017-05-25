/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.datinanta.repository;

import it.datinanta.model.Opera;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author Diego
 */
public interface OperaRepository extends MongoRepository<Opera, String> {

    //Scheda save (Scheda scheda);
    //Scheda insert (Scheda scheda);
    //List<Scheda> findAll();
    Opera findById(String id);
    //Scheda delete(Integer idScheda);
    
    
    
   
}