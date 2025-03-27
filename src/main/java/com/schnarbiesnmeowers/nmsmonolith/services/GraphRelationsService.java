package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GraphRelationsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GraphRelations;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GraphRelationsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GraphRelationsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GraphRelationsRepository service;

	/**
	 * get all GraphRelations records
	 * @return
	 * @throws Exception
	 */
	public List<GraphRelationsDTO> getAllGraphRelations() throws Exception {
		Iterable<GraphRelations> graphrelations = service.findAll();
		Iterator<GraphRelations> graphrelationss = graphrelations.iterator();
		List<GraphRelationsDTO> graphrelationsdto = new ArrayList();
		while(graphrelationss.hasNext()) {
			GraphRelations item = graphrelationss.next();
			graphrelationsdto.add(item.toDTO());
		}
		return graphrelationsdto;
	}

	/**
	 * get GraphRelations by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GraphRelationsDTO findGraphRelationsById(int id) throws Exception {
		Optional<GraphRelations> graphrelationsOptional = service.findById(id);
		if(graphrelationsOptional.isPresent()) {
			GraphRelations results = graphrelationsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new GraphRelations
	 * @param data
	 * @return
	 */
	public GraphRelationsDTO createGraphRelations(GraphRelationsDTO data) {
		try {
		    GraphRelations createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GraphRelations
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GraphRelationsDTO updateGraphRelations(GraphRelationsDTO data) throws Exception {
		Optional<GraphRelations> graphrelationsOptional = service.findById(data.getGraphRelationsId());
		if(graphrelationsOptional.isPresent()) {
		    GraphRelations updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getGraphRelationsId() + NOT_FOUND);
		}
	}

	/**
	 * delete a GraphRelations by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGraphRelations(int id) throws Exception {
		Optional<GraphRelations> graphrelationsOptional = service.findById(id);
		if(graphrelationsOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<GraphRelationsDTO> by foreign key : graphRelationIndexId
	 * @param id
	 * @return List<GraphRelations>
	 * @throws Exception
	*/
	public List<GraphRelationsDTO> findGraphRelationsByGraphRelationIndexId(int id) throws Exception {
		Iterable<GraphRelations> results = service.findGraphRelationsByGraphRelationIndexId(id);
		Iterator<GraphRelations> iter = results.iterator();
		List<GraphRelationsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GraphRelations item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public List<GraphRelationsDTO> findRootGraphRelationsByGraphRelationIndexId(int id) throws Exception {
		Iterable<GraphRelations> results = service.findRootRelations(id);
		Iterator<GraphRelations> iter = results.iterator();
		List<GraphRelationsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GraphRelations item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}
}
