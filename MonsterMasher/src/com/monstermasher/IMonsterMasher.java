package com.monstermasher;

//import java.io.File;
import java.util.Map;

public interface IMonsterMasher {

	/**
	 * Get imgs from file and add them to map
	 */
	Map<String, Integer> GetImages (String filepath);
	
	/**
	 * Generate random numbers to pick from list and create final list
	 */
	Map<String, Integer> ChooseFinalImageParts(Map<String, Integer> map);
	
	/**
	 * Go through list and add all imgs to a new img file
	 */
	String BuildImgs (Map<String, Integer> map);
}
