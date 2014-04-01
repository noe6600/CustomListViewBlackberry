package com.custom.listField;

import java.util.Vector;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.component.ListFieldCallback;
import net.rim.device.api.ui.container.MainScreen;

public class MyCustomListField extends MainScreen implements ListFieldCallback{
	private int selectedColor = 0x8f52a8;
	private int defaultColor =  0xf2f2f2;
	private int rowHeight = 50;
	private Vector elements;
	private ListField customList;
	
	public MyCustomListField(){
		setTitle("My Custom List Field!");
		
		elements = new Vector();
		for(int i=0; i<30; i++){
			elements.addElement("My #"+i+" element");
		}
		
		customList = new ListField(elements.size());
		customList.setCallback(this);
		customList.setRowHeight(70);
		add(customList);
	}
	
	public void drawListRow(ListField list, Graphics g, int index, int y, int w) {
		String text = (String)elements.elementAt(index);
		
		if(g.isDrawingStyleSet(Graphics.DRAWSTYLE_FOCUS)){
			g.setColor(selectedColor);
			g.fillRect(0,y,Display.getWidth(),list.getRowHeight());
		}else{
			g.setColor(defaultColor);
			g.fillRect(0,y,Display.getWidth(),list.getRowHeight());
		}
		g.setColor(0x000000);
		g.drawLine(0, y, Display.getWidth(), y);
		g.drawText(text, 0, y, 0, w);
	}

	public Object get(ListField listField, int index) {
		return elements.elementAt(index);
	}

	public int getPreferredWidth(ListField listField) {
		return Display.getWidth();
	}

	public int indexOfList(ListField listField, String prefix, int start) {
		return elements.indexOf(prefix, start);
	}

}
