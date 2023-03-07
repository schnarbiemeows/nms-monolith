package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ExerciseTypeDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ExerciseTypeServiceTest {


	/**
	 * get all ExerciseType records
	 * @return
	 * @throws Exception
	 */
	public List<ExerciseTypeDTO> getAllExerciseType() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<ExerciseTypeDTO> exercisetypeDTO = new ArrayList<ExerciseTypeDTO>();
		return exercisetypeDTO;
	}

	/**
	 * get ExerciseType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ExerciseTypeDTO findExerciseTypeById(int id) throws Exception {
		return new ExerciseTypeDTO();
	}

	/**
	 * create a new ExerciseType
	 * @param data
	 * @return
	 */
	public ExerciseTypeDTO createExerciseType(ExerciseTypeDTO data) {
        data.setExerciseTypeId(1);
        return data;
	}

	/**
	 * update a ExerciseType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ExerciseTypeDTO updateExerciseType(ExerciseTypeDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a ExerciseType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteExerciseType(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<ExerciseTypeDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<ExerciseType>
	 * @throws Exception
	*/
	public List<ExerciseTypeDTO> findExerciseTypeByImageLoc(int id) throws Exception {
		List<ExerciseTypeDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
