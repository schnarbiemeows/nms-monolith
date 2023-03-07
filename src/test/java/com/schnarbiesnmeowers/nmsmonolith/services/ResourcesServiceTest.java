package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ResourcesDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ResourcesServiceTest {


	/**
	 * get all Resources records
	 * @return
	 * @throws Exception
	 */
	public List<ResourcesDTO> getAllResources() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<ResourcesDTO> resourcesDTO = new ArrayList<ResourcesDTO>();
		return resourcesDTO;
	}

	/**
	 * get Resources by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ResourcesDTO findResourcesById(int id) throws Exception {
		return new ResourcesDTO();
	}

	/**
	 * create a new Resources
	 * @param data
	 * @return
	 */
	public ResourcesDTO createResources(ResourcesDTO data) {
        data.setRsrcId(1);
        return data;
	}

	/**
	 * update a Resources
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ResourcesDTO updateResources(ResourcesDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Resources by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteResources(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<ResourcesDTO> by foreign key : rsrcTypeId
	 * @param id
	 * @return List<Resources>
	 * @throws Exception
	*/
	public List<ResourcesDTO> findResourcesByRsrcTypeId(int id) throws Exception {
		List<ResourcesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
