package com.monstermasher;

import java.util.Map;

public class MasherMain {

	public static void main(String[] args) {

		Map<String, Integer> imgMap; //= new Map<String, Integer>();
		Map<String, Integer> resultMap;
		
		MasherClass masher = new MasherClass();
		
		imgMap = masher.GetImages("D:/eclipse_workspace/MonsterMasher/ressources/monsterMasher");
		
		resultMap = masher.ChooseFinalImageParts(imgMap);
		
		masher.BuildImgs(resultMap);
		
	}

}
