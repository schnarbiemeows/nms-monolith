package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.entities.LocalRecipeSpices;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.LocalRecipeSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LocalRecipeSpicesRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LocalRecipeSpicesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalRecipeSpicesRepository localRecipeSpicesRepository;

	@Autowired
	private RecipeSpicesService recipeSpicesService;
	/**
	 * get all LocalRecipeSpices records
	 * @return
	 * @throws Exception
	 */
	public List<LocalRecipeSpicesDTO> getAllLocalRecipeSpices() throws Exception {
		Iterable<LocalRecipeSpices> localrecipespices = localRecipeSpicesRepository.findAll();
		Iterator<LocalRecipeSpices> localrecipespicess = localrecipespices.iterator();
		List<LocalRecipeSpicesDTO> localrecipespicesdto = new ArrayList();
		while(localrecipespicess.hasNext()) {
			LocalRecipeSpices item = localrecipespicess.next();
			localrecipespicesdto.add(item.toDTO());
		}
		return localrecipespicesdto;
	}

	/**
	 * get LocalRecipeSpices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LocalRecipeSpicesDTO findLocalRecipeSpicesById(int id) throws Exception {
		Optional<LocalRecipeSpices> localrecipespicesOptional = localRecipeSpicesRepository.findById(id);
		if(localrecipespicesOptional.isPresent()) {
			LocalRecipeSpices results = localrecipespicesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new LocalRecipeSpices
	 * @param data
	 * @return
	 */
	public LocalRecipeSpicesDTO createLocalRecipeSpices(LocalRecipeSpicesDTO data) {
		try {
		    LocalRecipeSpices createdData = data.toEntity();
		    createdData = localRecipeSpicesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalRecipeSpices
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LocalRecipeSpicesDTO updateLocalRecipeSpices(LocalRecipeSpicesDTO data) throws Exception {
		Optional<LocalRecipeSpices> localrecipespicesOptional = localRecipeSpicesRepository.findById(data.getRecipeSpiceId());
		if(localrecipespicesOptional.isPresent()) {
		    LocalRecipeSpices updatedData = data.toEntity();
			updatedData = localRecipeSpicesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRecipeSpiceId() + NOT_FOUND);
		}
	}

	/**
	 * delete a LocalRecipeSpices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLocalRecipeSpices(int id) throws Exception {
		Optional<LocalRecipeSpices> localrecipespicesOptional = localRecipeSpicesRepository.findById(id);
		if(localrecipespicesOptional.isPresent()) {
			localRecipeSpicesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	public int deleteRecipeSpicesForaLocalRecipe(int id, int userId) throws Exception {
		int result = localRecipeSpicesRepository.deleteRecipeSpicesByRecipeIdAndUserId(id, userId);
		return result;
	}

	public boolean checkForRecipesThatAreDependentOnAnSpice(int id, Integer userId, boolean local) {
		if(local) {
			Iterable<LocalRecipeSpices> dependencies = localRecipeSpicesRepository
					.findLocalRecipesThatAreDependentUponGivenLocalSpice(userId,id);
			if(null!=dependencies&&dependencies.iterator().hasNext()) {
				return true;
			}
			return false;
		} else {
			Iterable<LocalRecipeSpices> dependencies = localRecipeSpicesRepository
					.findLocalRecipesThatAreDependentUponGivenGlobalSpice(id);
			if(null!=dependencies&&dependencies.iterator().hasNext()) {
				return true;
			}
			return false;
		}
	}
	/**
	 * get List<LocalRecipeSpicesDTO> by foreign key : recipeId
	 * @param id
	 * @return List<LocalRecipeSpices>
	 * @throws Exception
	*/
	public List<LocalRecipeSpicesDTO> findLocalRecipeSpicesByRecipeId(int id) throws Exception {
		Iterable<LocalRecipeSpices> results = localRecipeSpicesRepository.findLocalRecipeSpicesByRecipeId(id);
		Iterator<LocalRecipeSpices> iter = results.iterator();
		List<LocalRecipeSpicesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalRecipeSpices item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LocalRecipeSpicesDTO> by foreign key : servTypeId
	 * @param id
	 * @return List<LocalRecipeSpices>
	 * @throws Exception
	*/
	public List<LocalRecipeSpicesDTO> findLocalRecipeSpicesByServTypeId(int id) throws Exception {
		Iterable<LocalRecipeSpices> results = localRecipeSpicesRepository.findLocalRecipeSpicesByServTypeId(id);
		Iterator<LocalRecipeSpices> iter = results.iterator();
		List<LocalRecipeSpicesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalRecipeSpices item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LocalRecipeSpicesDTO> by foreign key : RecipeIdAndServTypeId
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<LocalRecipeSpicesDTO> findLocalRecipeSpicesByRecipeIdAndServTypeId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<LocalRecipeSpices> results = localRecipeSpicesRepository.findLocalRecipeSpicesByRecipeIdAndServTypeId(id0, id1);
		Iterator<LocalRecipeSpices> iter = results.iterator();
		List<LocalRecipeSpicesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalRecipeSpices item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
