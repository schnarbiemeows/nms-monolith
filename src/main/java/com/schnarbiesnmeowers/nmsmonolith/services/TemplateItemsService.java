package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.TemplateItemsDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.pojos.TemplateItems;
import com.schnarbiesnmeowers.nmsmonolith.repositories.TemplateItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TemplateItemsService {

    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";

    @Autowired
    TemplateItemsRepository templateItemsRepository;

    public List<TemplateItemsDTO> getAllTemplateItems() throws Exception {
        Iterable<TemplateItems> TemplateItems = templateItemsRepository.findAll();
        Iterator<TemplateItems> TemplateItemss = TemplateItems.iterator();
        List<TemplateItemsDTO> TemplateItemsdto = new ArrayList();
        while(TemplateItemss.hasNext()) {
            TemplateItems item = TemplateItemss.next();
            TemplateItemsdto.add(item.toDTO());
        }
        return TemplateItemsdto;
    }

    /**
     * get TemplateItems by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public TemplateItemsDTO findTemplateItemsById(int id) throws Exception {
        Optional<TemplateItems> TemplateItemsOptional = templateItemsRepository.findById(id);
        if(TemplateItemsOptional.isPresent()) {
            TemplateItems results = TemplateItemsOptional.get();
            return results.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * create a new TemplateItems
     * @param data
     * @return
     */
    public TemplateItemsDTO createTemplateItems(TemplateItemsDTO data) {
        try {
            TemplateItems createdData = data.toEntity();
            createdData = templateItemsRepository.save(createdData);
            return createdData.toDTO();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a TemplateItems
     * @param data
     * @return
     * @throws Exception
     */
    public TemplateItemsDTO updateTemplateItems(TemplateItemsDTO data) throws Exception {
        Optional<TemplateItems> TemplateItemsOptional = templateItemsRepository.findById(data.getTemplateId());
        if(TemplateItemsOptional.isPresent()) {
            TemplateItems updatedData = data.toEntity();
            updatedData = templateItemsRepository.save(updatedData);
            return updatedData.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + data.getTemplateId() + NOT_FOUND);
        }
    }

    /**
     * delete a TemplateItems by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteTemplateItems(int id) throws Exception {
        Optional<TemplateItems> TemplateItemsOptional = templateItemsRepository.findById(id);
        if(TemplateItemsOptional.isPresent()) {
            templateItemsRepository.deleteById(id);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }
}
