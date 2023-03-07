package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeEquipDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RecipeEquip;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeEquipRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecipeEquipService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecipeEquipRepository recipeEquipRepository;

	/**
	 * get all RecipeEquip records
	 * @return
	 * @throws Exception
	 */
	public List<RecipeEquipDTO> getAllRecipeEquip() throws Exception {
		Iterable<RecipeEquip> recipeequip = recipeEquipRepository.findAll();
		Iterator<RecipeEquip> recipeequips = recipeequip.iterator();
		List<RecipeEquipDTO> recipeequipdto = new ArrayList();
		while(recipeequips.hasNext()) {
			RecipeEquip item = recipeequips.next();
			recipeequipdto.add(item.toDTO());
		}
		return recipeequipdto;
	}

	/**
	 * get RecipeEquip by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecipeEquipDTO findRecipeEquipById(int id) throws Exception {
		Optional<RecipeEquip> recipeequipOptional = recipeEquipRepository.findById(id);
		if(recipeequipOptional.isPresent()) {
			RecipeEquip results = recipeequipOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new RecipeEquip
	 * @param data
	 * @return
	 */
	public RecipeEquipDTO createRecipeEquip(RecipeEquipDTO data) {
		try {
		    RecipeEquip createdData = data.toEntity();
		    createdData = recipeEquipRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecipeEquip
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecipeEquipDTO updateRecipeEquip(RecipeEquipDTO data) throws Exception {
		Optional<RecipeEquip> recipeequipOptional = recipeEquipRepository.findById(data.getRecipeEquipId());
		if(recipeequipOptional.isPresent()) {
		    RecipeEquip updatedData = data.toEntity();
			updatedData = recipeEquipRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRecipeEquipId() + NOT_FOUND);
		}
	}

	/**
	 * delete a RecipeEquip by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecipeEquip(int id) throws Exception {
		Optional<RecipeEquip> recipeequipOptional = recipeEquipRepository.findById(id);
		if(recipeequipOptional.isPresent()) {
			recipeEquipRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<RecipeEquipDTO> by foreign key : recEqTypeId
	 * @param recEqTypeId
	 * @return List<RecipeEquip>
	 * @throws Exception
	*/
	public List<RecipeEquipDTO> findRecipeEquipByRecEqTypeId(int id) throws Exception {
		Iterable<RecipeEquip> results = recipeEquipRepository.findRecipeEquipByRecEqTypeId(id);
		Iterator<RecipeEquip> iter = results.iterator();
		List<RecipeEquipDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RecipeEquip item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RecipeEquipDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<RecipeEquip>
	 * @throws Exception
	*/
	public List<RecipeEquipDTO> findRecipeEquipByImageLoc(int id) throws Exception {
		Iterable<RecipeEquip> results = recipeEquipRepository.findRecipeEquipByImageLoc(id);
		Iterator<RecipeEquip> iter = results.iterator();
		List<RecipeEquipDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RecipeEquip item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RecipeEquipDTO> by foreign key : RecEqTypeIdAndImageLoc
	 * @param RecEqTypeIdAndImageLoc
	 * @return List<RecipeEquip>
	 * @throws Exception
	*/
	public List<RecipeEquipDTO> findRecipeEquipByRecEqTypeIdAndImageLoc(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<RecipeEquip> results = recipeEquipRepository.findRecipeEquipByRecEqTypeIdAndImageLoc(id0, id1);
		Iterator<RecipeEquip> iter = results.iterator();
		List<RecipeEquipDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RecipeEquip item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
