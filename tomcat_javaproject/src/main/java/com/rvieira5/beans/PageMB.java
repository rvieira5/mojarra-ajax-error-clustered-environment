package com.rvieira5.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PageMB implements Serializable {

	private String internalPage = "page1.xhtml";
	private String internalSubpage;

	public String getInternalPage() {
		return internalPage;
	}

	public void loadInternalPage(String internalPage) {
		this.internalPage = internalPage;
	}

	public String getInternalSubpage() {
		return internalSubpage;
	}

	public void switchInternalSubpageTo(String internalSubpage) {
		this.internalSubpage = internalSubpage;
	}

}
