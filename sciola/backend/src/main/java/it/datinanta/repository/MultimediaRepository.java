/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.datinanta.repository;

import it.datinanta.model.Multimedia;
import it.datinanta.model.MultimediaStream;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author Diego
 */
public interface MultimediaRepository extends MongoRepository<MultimediaStream, String> {

    //Scheda save (Scheda scheda);
    //Scheda insert (Scheda scheda);
    //List<Scheda> findAll();
    MultimediaStream findById(String id);
    //Scheda delete(Integer idScheda);
    
    
    
   
}