package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GraphRelationIndexesDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.GraphRelationIndexes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GraphRelationIndexesRepository;
import java.util.List;
/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GraphRelationIndexesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GraphRelationIndexesRepository service;

	/**
	 * get all GraphRelationIndexes records
	 * @return
	 * @throws Exception
	 */
	public List<GraphRelationIndexesDTO> getAllGraphRelationIndexes() throws Exception {
		Iterable<GraphRelationIndexes> graphrelationindexes = service.findAll();
		Iterator<GraphRelationIndexes> graphrelationindexess = graphrelationindexes.iterator();
		List<GraphRelationIndexesDTO> graphrelationindexesdto = new ArrayList();
		while(graphrelationindexess.hasNext()) {
			GraphRelationIndexes item = graphrelationindexess.next();
			graphrelationindexesdto.add(item.toDTO());
		}
		return graphrelationindexesdto;
	}

	/**
	 * get GraphRelationIndexes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GraphRelationIndexesDTO findGraphRelationIndexesById(int id) throws Exception {
		Optional<GraphRelationIndexes> graphrelationindexesOptional = service.findById(id);
		if(graphrelationindexesOptional.isPresent()) {
			GraphRelationIndexes results = graphrelationindexesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new GraphRelationIndexes
	 * @param data
	 * @return
	 */
	public GraphRelationIndexesDTO createGraphRelationIndexes(GraphRelationIndexesDTO data) {
		try {
		    GraphRelationIndexes createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GraphRelationIndexes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GraphRelationIndexesDTO updateGraphRelationIndexes(GraphRelationIndexesDTO data) throws Exception {
		Optional<GraphRelationIndexes> graphrelationindexesOptional = service.findById(data.getGraphRelationIndexId());
		if(graphrelationindexesOptional.isPresent()) {
		    GraphRelationIndexes updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getGraphRelationIndexId() + NOT_FOUND);
		}
	}

	/**
	 * delete a GraphRelationIndexes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGraphRelationIndexes(int id) throws Exception {
		Optional<GraphRelationIndexes> graphrelationindexesOptional = service.findById(id);
		if(graphrelationindexesOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
