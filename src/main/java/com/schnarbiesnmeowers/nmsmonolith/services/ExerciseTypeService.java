package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ExerciseTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ExerciseType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ExerciseTypeRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ExerciseTypeService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ExerciseTypeRepository exerciseTypeRepository;

	/**
	 * get all ExerciseType records
	 * @return
	 * @throws Exception
	 */
	public List<ExerciseTypeDTO> getAllExerciseType() throws Exception {
		Iterable<ExerciseType> exercisetype = exerciseTypeRepository.findAll();
		Iterator<ExerciseType> exercisetypes = exercisetype.iterator();
		List<ExerciseTypeDTO> exercisetypedto = new ArrayList();
		while(exercisetypes.hasNext()) {
			ExerciseType item = exercisetypes.next();
			exercisetypedto.add(item.toDTO());
		}
		return exercisetypedto;
	}

	/**
	 * get ExerciseType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ExerciseTypeDTO findExerciseTypeById(int id) throws Exception {
		Optional<ExerciseType> exercisetypeOptional = exerciseTypeRepository.findById(id);
		if(exercisetypeOptional.isPresent()) {
			ExerciseType results = exercisetypeOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new ExerciseType
	 * @param data
	 * @return
	 */
	public ExerciseTypeDTO createExerciseType(ExerciseTypeDTO data) {
		try {
		    ExerciseType createdData = data.toEntity();
		    createdData = exerciseTypeRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ExerciseType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ExerciseTypeDTO updateExerciseType(ExerciseTypeDTO data) throws Exception {
		Optional<ExerciseType> exercisetypeOptional = exerciseTypeRepository.findById(data.getExerciseTypeId());
		if(exercisetypeOptional.isPresent()) {
		    ExerciseType updatedData = data.toEntity();
			updatedData = exerciseTypeRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getExerciseTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a ExerciseType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteExerciseType(int id) throws Exception {
		Optional<ExerciseType> exercisetypeOptional = exerciseTypeRepository.findById(id);
		if(exercisetypeOptional.isPresent()) {
			exerciseTypeRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<ExerciseTypeDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<ExerciseType>
	 * @throws Exception
	*/
	public List<ExerciseTypeDTO> findExerciseTypeByImageLoc(int id) throws Exception {
		Iterable<ExerciseType> results = exerciseTypeRepository.findExerciseTypeByImageLoc(id);
		Iterator<ExerciseType> iter = results.iterator();
		List<ExerciseTypeDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ExerciseType item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
