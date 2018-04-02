package com.telecom.project.beans;

public class Combobox {

	private String id;
	private String text;
	private boolean selected = false;
	
	public Combobox(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public Combobox() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Override
	public String toString() {
		return "Combobox [id=" + id + ", text=" + text + ", selected=" + selected + "]";
	}
}
