package com.advoops.assignment4;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class RunArray {

	private List<Object[]> runFontMap=new ArrayList<Object[]>();
	private int runCount=0;
			
	public boolean addRun(int startIndex,int runLength,Font runFont)
	{
		
		runCount=runCount +runLength;	
		int endIndex=startIndex+runLength;
		Object[] runInfo={startIndex,endIndex,runFont};
		runFontMap.add(runInfo);
		
		return true;
	}
	
	public boolean appendRun(int runs,Font runFont)
	{		
		this.addRun(runCount, runs, runFont);
		return true;
	}

	
	public Font getFontAt(int index)
	{		
		for(Object runInfo[] : runFontMap)
		{
			if(index >= (Integer) runInfo[0] && index < (Integer) runInfo[1])
			{
				return (Font) runInfo[2];
			}
		}
		return null;
	}
}

