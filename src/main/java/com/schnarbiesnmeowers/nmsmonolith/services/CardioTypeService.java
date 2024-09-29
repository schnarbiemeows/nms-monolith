package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.CardioTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.pojos.CardioType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.CardioTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CardioTypeService {

    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
    /**
     * JPA Repository handle
     */
    @Autowired
    private CardioTypeRepository cardioTypeRepository;

    /**
     * get all CardioType records
     * @return
     * @throws Exception
     */
    public List<CardioTypeDTO> getAllCardioType() throws Exception {
        Iterable<CardioType> CardioType = cardioTypeRepository.findAll();
        Iterator<CardioType> CardioTypes = CardioType.iterator();
        List<CardioTypeDTO> CardioTypedto = new ArrayList();
        while(CardioTypes.hasNext()) {
            CardioType item = CardioTypes.next();
            CardioTypedto.add(item.toDTO());
        }
        return CardioTypedto;
    }

    /**
     * get CardioType by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public CardioTypeDTO findCardioTypeById(int id) throws Exception {
        Optional<CardioType> CardioTypeOptional = cardioTypeRepository.findById(id);
        if(CardioTypeOptional.isPresent()) {
            CardioType results = CardioTypeOptional.get();
            return results.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * create a new CardioType
     * @param data
     * @return
     */
    public CardioTypeDTO createCardioType(CardioTypeDTO data) {
        try {
            CardioType createdData = data.toEntity();
            createdData = cardioTypeRepository.save(createdData);
            return createdData.toDTO();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a CardioType
     * @param data
     * @return
     * @throws Exception
     */
    public CardioTypeDTO updateCardioType(CardioTypeDTO data) throws Exception {
        Optional<CardioType> CardioTypeOptional = cardioTypeRepository.findById(data.getCardioTypeId());
        if(CardioTypeOptional.isPresent()) {
            CardioType updatedData = data.toEntity();
            updatedData = cardioTypeRepository.save(updatedData);
            return updatedData.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + data.getCardioTypeId() + NOT_FOUND);
        }
    }

    /**
     * delete a CardioType by primary key
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteCardioType(int id) throws Exception {
        Optional<CardioType> CardioTypeOptional = cardioTypeRepository.findById(id);
        if(CardioTypeOptional.isPresent()) {
            cardioTypeRepository.deleteById(id);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

}
