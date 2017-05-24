/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.datinanta.service;

import it.datinanta.model.Multimedia;
import it.datinanta.model.MultimediaStream;
import it.datinanta.model.Opera;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import it.datinanta.repository.OperaRepository;
import it.datinanta.repository.MultimediaRepository;

/**
 *
 * @author Diego
 */
@Service
public class MultimediaService {

    @Autowired
    private MultimediaRepository repo;

    public MultimediaStream insert(MultimediaStream mediaStream) {
        
        mediaStream.getItem().setId(UUID.randomUUID().toString());
        repo.insert(mediaStream);
        return mediaStream;
    }

    public MultimediaStream findById(String id) {
        return repo.findById(id);
    }

    public MultimediaStream update(MultimediaStream media) {
        MultimediaStream mediaFound = null;
        mediaFound = repo.findById(media.getItem().getId());
        if (mediaFound == null) {
            repo.delete(mediaFound);
            repo.insert(media);
        }
        return media;
    }

    public List<MultimediaStream> findAll() {
        return repo.findAll();
    }
    
        public boolean delete(String id){
            MultimediaStream media = repo.findOne(id);
            Boolean founded = true;
            if (media!=null){
              founded= true;
               repo.delete(media);
            } else{
                founded= false;
            }
         return founded;
    }
    

}
