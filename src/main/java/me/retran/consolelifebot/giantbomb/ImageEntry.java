package me.retran.consolelifebot.giantbomb;

public class ImageEntry {
	private String tags;
	private String super_url;
	
	
	public String tags() {
		return tags.toLowerCase();
	}
	
	public String url() {
		return super_url;
	}
}
