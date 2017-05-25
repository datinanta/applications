/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.datinanta.repository;

import it.datinanta.model.Opera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author Diego
 */
public class SchedaRepositoryImpl /*implements Repository */{

    @Autowired
    MongoTemplate mongoTemplate;
/*
    public Scheda insert(Scheda scheda) {
        return mongoTemplate.insert(scheda);
    }

    public Scheda findById(Integer id) {
        return mongoTemplate.findById(id, Scheda);
    }

    public Scheda delete(Integer id) {
        return mongoTemplate.findAndRemove(id, Scheda);
    }
*/
}
