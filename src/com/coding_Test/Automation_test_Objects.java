package com.coding_Test;

public class Automation_test_Objects {
	public String IMDBlink="https://www.imdb.com";
	public String IMDBSearchBox="suggestion-search";
	public String movieLink="//*[@class='result_text']/a";
	public String movieDetails="//*[text()='Box office']";
	public String relDate="//*[text()='Release date']//parent::li//following-sibling::div//a";
	public String country="//*[text()='Country of origin']//parent::li//following-sibling::div//a";
	public String wikiSearch="//*[@id='searchInput']";
	public String movieDetailsWiki="//*[text()='Box office']";
	public String relDateWiki="//*[text()='Release date']//parent::th//following-sibling::td/div/ul/li";
	public String countryWiki="//*[text()='Country']//following-sibling::td";

}
