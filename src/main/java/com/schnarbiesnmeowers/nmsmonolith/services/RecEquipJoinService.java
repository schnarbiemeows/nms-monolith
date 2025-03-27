package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEquipJoinDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecEquipJoin;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecEquipJoinRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecEquipJoinService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecEquipJoinRepository recEquipJoinRepository;

	/**
	 * get all RecEquipJoin records
	 * @return
	 * @throws Exception
	 */
	public List<RecEquipJoinDTO> getAllRecEquipJoin() throws Exception {
		Iterable<RecEquipJoin> recequipjoin = recEquipJoinRepository.findAll();
		Iterator<RecEquipJoin> recequipjoins = recequipjoin.iterator();
		List<RecEquipJoinDTO> recequipjoindto = new ArrayList();
		while(recequipjoins.hasNext()) {
			RecEquipJoin item = recequipjoins.next();
			recequipjoindto.add(item.toDTO());
		}
		return recequipjoindto;
	}

	/**
	 * get RecEquipJoin by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecEquipJoinDTO findRecEquipJoinById(int id) throws Exception {
		Optional<RecEquipJoin> recequipjoinOptional = recEquipJoinRepository.findById(id);
		if(recequipjoinOptional.isPresent()) {
			RecEquipJoin results = recequipjoinOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new RecEquipJoin
	 * @param data
	 * @return
	 */
	public RecEquipJoinDTO createRecEquipJoin(RecEquipJoinDTO data) {
		try {
		    RecEquipJoin createdData = data.toEntity();
		    createdData = recEquipJoinRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecEquipJoin
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecEquipJoinDTO updateRecEquipJoin(RecEquipJoinDTO data) throws Exception {
		Optional<RecEquipJoin> recequipjoinOptional = recEquipJoinRepository.findById(data.getRecEquipJoinId());
		if(recequipjoinOptional.isPresent()) {
		    RecEquipJoin updatedData = data.toEntity();
			updatedData = recEquipJoinRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRecEquipJoinId() + NOT_FOUND);
		}
	}

	/**
	 * delete a RecEquipJoin by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecEquipJoin(int id) throws Exception {
		Optional<RecEquipJoin> recequipjoinOptional = recEquipJoinRepository.findById(id);
		if(recequipjoinOptional.isPresent()) {
			recEquipJoinRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<RecEquipJoinDTO> by foreign key : recipeId
	 * @param recipeId
	 * @return List<RecEquipJoin>
	 * @throws Exception
	*/
	public List<RecEquipJoinDTO> findRecEquipJoinByRecipeId(int id) throws Exception {
		Iterable<RecEquipJoin> results = recEquipJoinRepository.findRecEquipJoinByRecipeId(id);
		Iterator<RecEquipJoin> iter = results.iterator();
		List<RecEquipJoinDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RecEquipJoin item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RecEquipJoinDTO> by foreign key : recipeEquipId
	 * @param recipeEquipId
	 * @return List<RecEquipJoin>
	 * @throws Exception
	*/
	public List<RecEquipJoinDTO> findRecEquipJoinByRecipeEquipId(int id) throws Exception {
		Iterable<RecEquipJoin> results = recEquipJoinRepository.findRecEquipJoinByRecipeEquipId(id);
		Iterator<RecEquipJoin> iter = results.iterator();
		List<RecEquipJoinDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RecEquipJoin item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RecEquipJoinDTO> by foreign key : RecipeIdAndRecipeEquipId
	 * @param RecipeIdAndRecipeEquipId
	 * @return List<RecEquipJoin>
	 * @throws Exception
	*/
	public List<RecEquipJoinDTO> findRecEquipJoinByRecipeIdAndRecipeEquipId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<RecEquipJoin> results = recEquipJoinRepository.findRecEquipJoinByRecipeIdAndRecipeEquipId(id0, id1);
		Iterator<RecEquipJoin> iter = results.iterator();
		List<RecEquipJoinDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RecEquipJoin item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
