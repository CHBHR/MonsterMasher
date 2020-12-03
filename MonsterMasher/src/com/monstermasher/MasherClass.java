package com.monstermasher;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MasherClass implements IMonsterMasher{

	@Override
	public Map<String, Integer> GetImages(String filepath) {
		
		File  directory = new File(filepath);
		
		Map<String, Integer> imgMap = new HashMap<String, Integer>();

		int y = 1;
		
		for (File file : directory.listFiles()) //can lift a nullPOinter Exception
		{
		    // could also use a FileNameFilter
		    if(file.getName().toLowerCase().endsWith(".png")){
		    	
		        //imgMap.put(file.getName(), new Integer(file.getPath()));
		        imgMap.put(file.getName(), y);
		        y++;
		        
		        //System.out.println(file.getName()); //ok
		        
		    }
		}
		
		//System.out.println(imgMap); //ok unordered list
		
		return imgMap;
	}

	@Override
	public Map<String, Integer> ChooseFinalImageParts(Map<String, Integer> imgMap) {
		
		Random r = new Random();
		
		int randNumbOfTotalParts;
		//Quick fix to avoid having only one part
		do {
			randNumbOfTotalParts = r.nextInt(4)+1;
			}while(randNumbOfTotalParts <= 1);
		int randNumOfMapKey;
		
		//map init for final result
		Map<String, Integer> resultMap = new HashMap<String, Integer>();	
		
		
		for(int i = 0; i <randNumbOfTotalParts; i++) {
			
			//Quick fix to avoid having key = 0
			do {
				randNumOfMapKey = r.nextInt(imgMap.size()+1);
			}while(randNumOfMapKey == 0 && !imgMap.containsValue(randNumOfMapKey));
			
			//get key and value from input map
			for(Map.Entry<String, Integer> entry : imgMap.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				
				//add key and value to result map
				if(value == randNumOfMapKey) {
					resultMap.put(key, value);
				}
			}
			
			//System.out.println(randNumOfMapKey);
		
		}
		System.out.println(resultMap);
		return resultMap;
	}

	@Override
	public String BuildImgs(Map<String, Integer> resultMap) {
		//get list and get img corresponding to value
		//show result in gui
		
		System.out.println("getting in BuidImgs class");
		
		JFrame frame = new JFrame("Display multiple images from files.");
		JPanel panel = new JPanel();
		
		for(Map.Entry<String, Integer> entry : resultMap.entrySet()) {
			
			File file = new File(entry.getKey());
			String path = file.getPath();
			
			//System.out.println(path); ok
			
			//Resize the image to fit the window
			ImageIcon imageIcon = new ImageIcon("D:/eclipse_workspace/MonsterMasher/ressources/monsterMasher/"+path);
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance(168, 120, java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			
			//Add the image to the panel
			//panel.add(new JLabel (new ImageIcon ("D:/eclipse_workspace/MonsterMasher/ressources/monsterMasher/"+path)));
			panel.add(new JLabel(imageIcon));
			
			//add panel to the JFrame
			frame.getContentPane().add(panel);
			//frame.pack();
			frame.setVisible(true);
		}
		
			frame.pack();
			frame.setLayout(new BorderLayout());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		System.out.println("end of BuildImg class");
		return null;
	}

	
}
