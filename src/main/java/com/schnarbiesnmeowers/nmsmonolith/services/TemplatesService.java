package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.TemplatesDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.entities.Templates;
import com.schnarbiesnmeowers.nmsmonolith.repositories.TemplatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TemplatesService {

    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";

    @Autowired
    TemplatesRepository templatesRepository;

    public List<TemplatesDTO> getAllTemplates() throws Exception {
        Iterable<Templates> Templates = templatesRepository.findAll();
        Iterator<Templates> Templatess = Templates.iterator();
        List<TemplatesDTO> Templatesdto = new ArrayList();
        while(Templatess.hasNext()) {
            Templates item = Templatess.next();
            Templatesdto.add(item.toDTO());
        }
        return Templatesdto;
    }

    /**
     * get Templates by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public TemplatesDTO findTemplatesById(int id) throws Exception {
        Optional<Templates> TemplatesOptional = templatesRepository.findById(id);
        if(TemplatesOptional.isPresent()) {
            Templates results = TemplatesOptional.get();
            return results.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * create a new Templates
     * @param data
     * @return
     */
    public TemplatesDTO createTemplates(TemplatesDTO data) {
        try {
            Templates createdData = data.toEntity();
            createdData = templatesRepository.save(createdData);
            return createdData.toDTO();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a Templates
     * @param data
     * @return
     * @throws Exception
     */
    public TemplatesDTO updateTemplates(TemplatesDTO data) throws Exception {
        Optional<Templates> TemplatesOptional = templatesRepository.findById(data.getTemplateId());
        if(TemplatesOptional.isPresent()) {
            Templates updatedData = data.toEntity();
            updatedData = templatesRepository.save(updatedData);
            return updatedData.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + data.getTemplateId() + NOT_FOUND);
        }
    }

    /**
     * delete a Templates by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteTemplates(int id) throws Exception {
        Optional<Templates> TemplatesOptional = templatesRepository.findById(id);
        if(TemplatesOptional.isPresent()) {
            templatesRepository.deleteById(id);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }
}
