package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LocalRecipeStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalRecipeSteps;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LocalRecipeStepsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LocalRecipeStepsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalRecipeStepsRepository localRecipeStepsRepository;

	/**
	 * get all LocalRecipeSteps records
	 * @return
	 * @throws Exception
	 */
	public List<LocalRecipeStepsDTO> getAllLocalRecipeSteps() throws Exception {
		Iterable<LocalRecipeSteps> localrecipesteps = localRecipeStepsRepository.findAll();
		Iterator<LocalRecipeSteps> localrecipestepss = localrecipesteps.iterator();
		List<LocalRecipeStepsDTO> localrecipestepsdto = new ArrayList();
		while(localrecipestepss.hasNext()) {
			LocalRecipeSteps item = localrecipestepss.next();
			localrecipestepsdto.add(item.toDTO());
		}
		return localrecipestepsdto;
	}

	/**
	 * get LocalRecipeSteps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LocalRecipeStepsDTO findLocalRecipeStepsById(int id) throws Exception {
		Optional<LocalRecipeSteps> localrecipestepsOptional = localRecipeStepsRepository.findById(id);
		if(localrecipestepsOptional.isPresent()) {
			LocalRecipeSteps results = localrecipestepsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new LocalRecipeSteps
	 * @param data
	 * @return
	 */
	public LocalRecipeStepsDTO createLocalRecipeSteps(LocalRecipeStepsDTO data) {
		try {
		    LocalRecipeSteps createdData = data.toEntity();
		    createdData = localRecipeStepsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalRecipeSteps
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LocalRecipeStepsDTO updateLocalRecipeSteps(LocalRecipeStepsDTO data) throws Exception {
		Optional<LocalRecipeSteps> localrecipestepsOptional = localRecipeStepsRepository.findById(data.getRecipeStepId());
		if(localrecipestepsOptional.isPresent()) {
		    LocalRecipeSteps updatedData = data.toEntity();
			updatedData = localRecipeStepsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRecipeStepId() + NOT_FOUND);
		}
	}

	/**
	 * delete a LocalRecipeSteps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLocalRecipeSteps(int id) throws Exception {
		Optional<LocalRecipeSteps> localrecipestepsOptional = localRecipeStepsRepository.findById(id);
		if(localrecipestepsOptional.isPresent()) {
			localRecipeStepsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<LocalRecipeStepsDTO> by foreign key : recipeId
	 * @param id
	 * @return List<LocalRecipeSteps>
	 * @throws Exception
	*/
	public List<LocalRecipeStepsDTO> findLocalRecipeStepsByRecipeId(int id) throws Exception {
		Iterable<LocalRecipeSteps> results = localRecipeStepsRepository.findLocalRecipeStepsByRecipeId(id);
		Iterator<LocalRecipeSteps> iter = results.iterator();
		List<LocalRecipeStepsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalRecipeSteps item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LocalRecipeStepsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<LocalRecipeSteps>
	 * @throws Exception
	*/
	public List<LocalRecipeStepsDTO> findLocalRecipeStepsByImageLoc(int id) throws Exception {
		Iterable<LocalRecipeSteps> results = localRecipeStepsRepository.findLocalRecipeStepsByImageLoc(id);
		Iterator<LocalRecipeSteps> iter = results.iterator();
		List<LocalRecipeStepsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalRecipeSteps item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LocalRecipeStepsDTO> by foreign key : RecipeIdAndImageLoc
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<LocalRecipeStepsDTO> findLocalRecipeStepsByRecipeIdAndImageLoc(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<LocalRecipeSteps> results = localRecipeStepsRepository.findLocalRecipeStepsByRecipeIdAndImageLoc(id0, id1);
		Iterator<LocalRecipeSteps> iter = results.iterator();
		List<LocalRecipeStepsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalRecipeSteps item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public int deleteRecipeStepsForaLocalRecipe(int id) throws Exception {
		int result = localRecipeStepsRepository.deleteLocalRecipeStepsByRecipeId(id);
		return result;
	}
}
