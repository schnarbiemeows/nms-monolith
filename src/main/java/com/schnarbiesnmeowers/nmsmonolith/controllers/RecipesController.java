package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;
import java.io.*;
import java.math.BigDecimal;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/recipes")
public class RecipesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecipesService recipesService;

	/**
	 * get all Recipes records
	 * @return Iterable<Recipes>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RecipesDTO>> getAllRecipes() throws Exception {
		List<RecipesDTO> recipes = recipesService.getAllRecipes();
		return ResponseEntity.status(HttpStatus.OK).body(recipes);
	}

	/**
	 * gets all of the global recipes plus alll of the local_recipes for a given user id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/all-displays/{id}")
	public ResponseEntity<RecipeWrapper> getAllRecipeDisplays(@PathVariable int id) throws Exception {
		RecipeWrapper recipes = recipesService.getAllRecipeDisplays(id);
		return ResponseEntity.status(HttpStatus.OK).body(recipes);
	}

	@GetMapping(path = "/all-displays-ranked/{id}/{rankedBy}")
	public ResponseEntity<RecipeWrapper> getRecipesByRanking(@PathVariable int id,
		@PathVariable String rankedBy) throws Exception {
		RecipeWrapper recipes = recipesService.getRecipesByRanking(id, rankedBy);
		return ResponseEntity.status(HttpStatus.OK).body(recipes);
	}

	/**
	 * this method gets called when a user selects a recipe for inclusion in another recipe
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/display/{id}")
	public ResponseEntity<RecipeIngredientDisplay> getRecipeDisplayById(@PathVariable int id) throws Exception {
		RecipeIngredientDisplay recipes = recipesService.getRecipeDisplayById(id);
		return ResponseEntity.status(HttpStatus.OK).body(recipes);
	}

	/**
	 * this method gets called whenever a child recipe in the ingredients list on the recipe form gets changed
	 * we need to recalculate a new M1 for that recipe, because they might have changed the serving type
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@PostMapping(path = "/findM1")
	public ResponseEntity<BigDecimal> findM1(@Valid @RequestBody RecipeIngredientDisplay data) throws Exception {
		try {
			BigDecimal results = recipesService.findM1(data) ;
			return ResponseEntity.status(HttpStatus.OK).body(results);
		} catch(Exception e) {
			throw e;
		}
	}

	/**
	 * get Recipes by primary key
	 * @param id
	 * @return Recipes
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RecipeFormDTO> findRecipesById(@PathVariable int id) throws Exception {
		RecipeFormDTO results = recipesService.findRecipesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Recipes
	 * @param data
	 * @return Recipes
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RecipesDTO> createRecipes(@Valid @RequestBody RecipeFormDTO data) throws Exception {
		try {
		    RecipesDTO createdData = recipesService.createRecipe(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Recipes
	 * @param data
	 * @return Recipes
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<ResponseMessage> updateRecipes(@Valid @RequestBody RecipeFormDTO data) throws Exception {
		RecipesDTO updatedData = recipesService.updateRecipe(data);
		ResponseMessage rb = new ResponseMessage("successfully updated");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * delete a Recipes by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRecipes(@PathVariable int id) throws Exception {
		recipesService.deleteRecipe(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<RecipesDTO> by foreign key : ingrId
	 * @param id
	 * @return List<Recipes>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByIngrId/{id}")
	public ResponseEntity<List<RecipesDTO>> findRecipesByIngrId(@PathVariable int id) throws Exception {
		List<RecipesDTO> results = recipesService.findRecipesByIngrId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/*@GetMapping("/users/export/pdf")
	public void exportToPDF(HttpServletResponse response, ) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<User> listUsers = service.listAll();

		UserPDFExporter exporter = new UserPDFExporter(listUsers);
		exporter.export(response);

	}*/

	@PostMapping(path = "/print")
	public ResponseEntity<String> printRecipe(HttpServletResponse response,
											  @Valid @RequestBody RecipeFormDTO data) throws Exception {
		// HttpServletResponse response,
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=iTextHelloWorld.pdf";
		response.setHeader(headerKey, headerValue);

		Font fontTitle = new Font(Font.FontFamily.COURIER, 30,
				Font.BOLD, BaseColor.BLACK);
		Font fontSubTitles = new Font(Font.FontFamily.COURIER, 24,
				Font.BOLD, BaseColor.BLACK);
		Font normalText = new Font(Font.FontFamily.COURIER, 16,
				Font.NORMAL);

		Document document = new Document();
		PdfWriter.getInstance(document, /*response.getOutputStream()*/new FileOutputStream("recipe.pdf"));
		document.open();

		// add recipe name
		Paragraph titlePara = new Paragraph(data.getRecipeMetaData().getRecipeName(), fontTitle);
		Chapter catPart = new Chapter(1);
		Section subCatPart = catPart.addSection(titlePara);
		// add blank lines
		Paragraph paragraph = new Paragraph();
		addEmptyLine(paragraph, 2);
		subCatPart.add(paragraph);
		// add ingredients title
		subCatPart.add(new Paragraph("Ingredients:", fontSubTitles));
		// add ingredients
		createIngredientList(subCatPart,data.getRecipeIngredients(),normalText);
		// add blank lines
		addEmptyLine(paragraph, 1);
		subCatPart.add(paragraph);
		// add ingredients title
		subCatPart.add(new Paragraph("Spices:", fontSubTitles));
		// add spices
		createSpicesList(subCatPart,data.getRecipeSpices(),normalText);
		// add blank lines
		addEmptyLine(paragraph, 1);
		subCatPart.add(paragraph);
		// add ingredients title
		subCatPart.add(new Paragraph("Steps:", fontSubTitles));
		// add steps
		createStepsList(subCatPart,data.getRecipeSteps(),normalText);

		// add all to the document
		document.add(catPart);
		document.close();
		response.getOutputStream().flush();
		/*File file = new File("iTextHelloWorld.pdf");
		FileInputStream fis = new FileInputStream(file);
		byte [] outputdata = new byte[(int)file.length()];
		fis.read(outputdata);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		outputdata = bos.toByteArray();
		response.getOutputStream().write(outputdata);*/
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}

	private static void createIngredientList(Section subCatPart, List<RecipeIngredientDisplay> ingredients,Font font) {
		com.itextpdf.text.List list = new com.itextpdf.text.List(false, false);
		for(RecipeIngredientDisplay ingredient : ingredients) {
			String display = ingredient.getServSz() + " " + ingredient.getServUnitDesc() + " "
					+ ingredient.getDescription();
			list.add(new ListItem(display,font));
		}
		subCatPart.add(list);
	}

	private static void createSpicesList(Section subCatPart, List<RecipeSpiceDisplay> spices,Font font) {
		com.itextpdf.text.List list = new com.itextpdf.text.List(false, false);
		for(RecipeSpiceDisplay spice : spices) {
			String display = spice.getServSz() + " " + spice.getServUnitDesc() + " "
					+ spice.getDescription();
			list.add(new ListItem(display,font));
		}
		subCatPart.add(list);
	}

	private static void createStepsList(Section subCatPart, List<RecipeStepsDisplay> steps,Font font ) {
		com.itextpdf.text.List list = new com.itextpdf.text.List(false, false);
		for(RecipeStepsDisplay step : steps) {
			String display = step.getStepDescription();
			list.add(new ListItem(display,font));
		}
		subCatPart.add(list);
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}
