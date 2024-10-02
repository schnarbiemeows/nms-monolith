package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ResourcesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Resources;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ResourcesRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ResourcesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ResourcesRepository resourcesRepository;

	/**
	 * get all Resources records
	 * @return
	 * @throws Exception
	 */
	public List<ResourcesDTO> getAllResources() throws Exception {
		Iterable<Resources> resources = resourcesRepository.findAll();
		Iterator<Resources> resourcess = resources.iterator();
		List<ResourcesDTO> resourcesdto = new ArrayList();
		while(resourcess.hasNext()) {
			Resources item = resourcess.next();
			resourcesdto.add(item.toDTO());
		}
		return resourcesdto;
	}

	/**
	 * get Resources by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ResourcesDTO findResourcesById(int id) throws Exception {
		Optional<Resources> resourcesOptional = resourcesRepository.findById(id);
		if(resourcesOptional.isPresent()) {
			Resources results = resourcesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Resources
	 * @param data
	 * @return
	 */
	public ResourcesDTO createResources(ResourcesDTO data) {
		try {
		    Resources createdData = data.toEntity();
		    createdData = resourcesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Resources
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ResourcesDTO updateResources(ResourcesDTO data) throws Exception {
		Optional<Resources> resourcesOptional = resourcesRepository.findById(data.getRsrcId());
		if(resourcesOptional.isPresent()) {
		    Resources updatedData = data.toEntity();
			updatedData = resourcesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRsrcId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Resources by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteResources(int id) throws Exception {
		Optional<Resources> resourcesOptional = resourcesRepository.findById(id);
		if(resourcesOptional.isPresent()) {
			resourcesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<ResourcesDTO> by foreign key : rsrcTypeId
	 * @param rsrcTypeId
	 * @return List<Resources>
	 * @throws Exception
	*/
	public List<ResourcesDTO> findResourcesByRsrcTypeId(int id) throws Exception {
		Iterable<Resources> results = resourcesRepository.findResourcesByRsrcTypeId(id);
		Iterator<Resources> iter = results.iterator();
		List<ResourcesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Resources item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
