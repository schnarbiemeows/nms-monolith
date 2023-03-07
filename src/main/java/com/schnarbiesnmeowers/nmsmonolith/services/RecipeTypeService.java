package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.*;
import java.util.stream.Collectors;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GraphRelationsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes.RecipeDisplayType;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes.RecipeTypeHierachy;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes.RecipeTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RecipeType;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecipeTypeService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecipeTypeRepository recipeTypeRepository;

	@Autowired
	private GraphRelationsService graphRelationsService;

	/**
	 * get all RecipeType records
	 * @return
	 * @throws Exception
	 */
	public List<RecipeTypeDTO> getAllRecipeType() throws Exception {
		Iterable<RecipeType> recipetype = recipeTypeRepository.findAll();
		Iterator<RecipeType> recipetypes = recipetype.iterator();
		List<RecipeTypeDTO> recipetypedto = new ArrayList();
		while(recipetypes.hasNext()) {
			RecipeType item = recipetypes.next();
			recipetypedto.add(item.toDTO());
		}
		return recipetypedto;
	}

	public List<RecipeTypeDTO> getAllActiveRecipeTypes() throws Exception {
		Iterable<RecipeType> recipetype = recipeTypeRepository.getAllActiveRecipeTypes();
		Iterator<RecipeType> recipetypes = recipetype.iterator();
		List<RecipeTypeDTO> recipetypedto = new ArrayList();
		while(recipetypes.hasNext()) {
			RecipeType item = recipetypes.next();
			recipetypedto.add(item.toDTO());
		}
		return recipetypedto;
	}
	/**
	 * get RecipeType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecipeTypeDTO findRecipeTypeById(int id) throws Exception {
		Optional<RecipeType> recipetypeOptional = recipeTypeRepository.findById(id);
		if(recipetypeOptional.isPresent()) {
			RecipeType results = recipetypeOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new RecipeType
	 * @param data
	 * @return
	 */
	public RecipeTypeDTO createRecipeType(RecipeTypeDTO data) {
		try {
		    RecipeType createdData = data.toEntity();
		    createdData = recipeTypeRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecipeType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecipeTypeDTO updateRecipeType(RecipeTypeDTO data) throws Exception {
		Optional<RecipeType> recipetypeOptional = recipeTypeRepository.findById(data.getRecipeTypeId());
		if(recipetypeOptional.isPresent()) {
		    RecipeType updatedData = data.toEntity();
			updatedData = recipeTypeRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRecipeTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a RecipeType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecipeType(int id) throws Exception {
		Optional<RecipeType> recipetypeOptional = recipeTypeRepository.findById(id);
		if(recipetypeOptional.isPresent()) {
			recipeTypeRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 *
	 * @param i
	 * @return
	 */
	public RecipeTypeHierachy findGraphOfRecipeTypes(int i) throws Exception {
		/**
		 * Algorithm:
		 * keep the DB calls limited
		 * 1. get all of the recipe types
		 * 2. get all of the relations
		 */
		List<RecipeTypeDTO> recipeTypes = this.getAllActiveRecipeTypes();
		RecipeTypeHierachy hierarchy = new RecipeTypeHierachy(recipeTypes);
		return hierarchy;
	}

	/**
	 * this method gets all of the recipe types, and then filters out the root recipe types
	 * (Breakfast & Brunch
	 * Lunch
	 * Dinner
	 * Appetizers & Snacks
	 * Desserts
	 * Drinks
	 * World Cuisine
	 * Ingredients
	 * Holiday Food
	 * Breads
	 * Side Dishes
	 * Favorites)
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public RecipeTypeHierachy getChildRecipeTypes(int i) throws Exception {
		/**
		 * Algorithm:
		 * keep the DB calls limited
		 * 1. get all of the recipe types
		 * 2. get all of the relations
		 */
		List<RecipeTypeDTO> recipeTypes = this.getAllActiveRecipeTypes();
		List<GraphRelationsDTO> rootRelations =
				graphRelationsService.findRootGraphRelationsByGraphRelationIndexId(i);
		List<Integer> indexes = rootRelations.stream().map(rec -> rec.getChildNode())
				.collect(Collectors.toList());
		List<RecipeTypeDTO> filteredecipeTypes =
				recipeTypes.stream().filter(rec -> !indexes.contains(rec.getRecipeTypeId()))
						.collect(Collectors.toList());
		RecipeTypeHierachy hierarchy = new RecipeTypeHierachy(filteredecipeTypes);
		return hierarchy;
	}

	public RecipeTypeHierachy getChildRecipeTypeDisplays(int i) throws Exception {
		/**
		 * Algorithm:
		 * keep the DB calls limited
		 * 1. get all of the recipe types
		 * 2. get all of the relations
		 * 3. get the roots
		 */
		List<RecipeTypeDTO> recipeTypes = this.getAllActiveRecipeTypes();

		Map<Integer,String> recipeTypeMap = new HashMap();
		recipeTypes.forEach(rec -> recipeTypeMap.put(rec.getRecipeTypeId(),rec.getRecipeTypeDesc()));

		List<RecipeDisplayType> displayTypes = new ArrayList();

		List<GraphRelationsDTO> rootRelations =
				graphRelationsService.findRootGraphRelationsByGraphRelationIndexId(i);

		List<GraphRelationsDTO> allRelations =
				graphRelationsService.findGraphRelationsByGraphRelationIndexId(i);
		Map<Integer,List<Integer>> parentChildMappings = new HashMap();
		for(GraphRelationsDTO dto : allRelations) {
			if(null==dto.getParentNode()&&!parentChildMappings.containsKey(dto.getChildNode())) {
				// root nodes
				parentChildMappings.put(dto.getChildNode(),new ArrayList());
			} else if(!parentChildMappings.containsKey(dto.getParentNode())) {
				List<Integer> children = new ArrayList();
				children.add(dto.getChildNode());
				parentChildMappings.put(dto.getParentNode(),children);
			} else {
				List<Integer> children = parentChildMappings.get(dto.getParentNode());
				children.add(dto.getChildNode());
				parentChildMappings.put(dto.getParentNode(),children);
			}
		}

		List<Integer> rootIndexes = rootRelations.stream().map(rec -> rec.getChildNode())
				.collect(Collectors.toList());

		List<RecipeTypeDTO> rootRecipeTypes =
				recipeTypes.stream().filter(rec -> rootIndexes.contains(rec.getRecipeTypeId()))
						.collect(Collectors.toList());

		rootRecipeTypes.forEach(rec -> {
			String displayValue = rec.getRecipeTypeDesc();
			System.out.println("ROOT displayValue = " + displayValue);
			determineArray(displayTypes, parentChildMappings,recipeTypeMap,displayValue,rec.getRecipeTypeId());
		});


		RecipeTypeHierachy hierarchy = new RecipeTypeHierachy(null,displayTypes);
		return hierarchy;
	}

	private void determineArray(List<RecipeDisplayType> displayTypes,				// final List
								Map<Integer,List<Integer>> parentChildMappings,		// parent -> List<child>
								Map<Integer,String> recipeTypeMap,
								String displayStr,
								Integer dto) {
		if(!parentChildMappings.containsKey(dto)||parentChildMappings.get(dto).isEmpty()) {
			System.out.println("FINAL displayValue = " + displayStr);
			displayTypes.add(new RecipeDisplayType(dto,displayStr));
		} else {
			parentChildMappings.get(dto).forEach(rec -> {
				String displayValue = displayStr + " --> " + recipeTypeMap.get(rec);
				System.out.println("INNER displayValue = " + displayValue);
				determineArray(displayTypes, parentChildMappings,recipeTypeMap,displayValue,rec);
			});
		}
	}
}
