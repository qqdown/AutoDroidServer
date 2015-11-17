package edu.nju.autodroid.activity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Rect;

public class ActivityNode {
	public int index;
	public String text;
	public String className;
	public String packageName;
	public String contentDesc;
	public boolean checkable;
	public boolean checked;
	public boolean clickable;
	public boolean enabled;
	public boolean focusable;
	public boolean focuesd;
	public boolean scrollable;
	public boolean longClickable;
	public boolean password;
	public boolean selected;
	public int[] bound;
	public String indexXpath;
	
	public ActivityNode parent;
	public List<ActivityNode> children;
	
	public ActivityNode(){
		bound = new int[4];
		children = new ArrayList<ActivityNode>();
	}
	
	public void addChild(ActivityNode child){
		children.add(child);
	}

	public int getChildrenCount(){
		return children.size();
	}
	
	@Override
	public String toString() {
		String str = "";
		str += "index=" + index + " ";
		str += "text=" + text + " ";
		str += "className=" + className + " ";
		str += "packageName=" + packageName + " ";
		str += "contentDesc=" + contentDesc + " ";
		str += "checkable=" + checkable + " ";
		str += "checked=" + checked + " ";
		str += "clickable=" + clickable + " ";
		str += "enabled=" + enabled + " ";
		str += "focusable=" + focusable + " ";
		str += "focuesd=" + focuesd + " ";
		str += "scrollable=" + scrollable + " ";
		str += "longClickable=" + longClickable + " ";
		str += "password=" + password + " ";
		str += "selected=" + selected + " ";
		str += "bound=[" + bound[0] + "," + bound[1] + "][" + bound[2] + "," + bound[3] + "]";
		return str;
	}
}
