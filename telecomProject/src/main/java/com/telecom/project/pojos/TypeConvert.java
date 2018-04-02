package com.telecom.project.pojos;

public class TypeConvert {
	
	private String id;
	private String text;
	private boolean selected;
	
	public TypeConvert() {
		// TODO Auto-generated constructor stub
	}

	public TypeConvert(String id, String text) {
		super();
		this.id = id;
		this.text = text;
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
		return "TypeConvert [id=" + id + ", text=" + text + ", selected=" + selected + "]";
	}
	
	

}
