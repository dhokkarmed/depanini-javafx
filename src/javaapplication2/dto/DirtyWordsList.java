package javaapplication2.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import dto.DirtyWords;

public class DirtyWordsList {
    @JsonProperty( "RECORDS" )
    private List<DirtyWords> listofBadWords;

	public List<DirtyWords> getListofBadWords() {
		return listofBadWords;
	}

	public void setListofBadWords(List<DirtyWords> listofBadWords) {
		this.listofBadWords = listofBadWords;
	}

	@Override
	public String toString() {
		return "DirtyWordsList [listofBadWords=" + listofBadWords + "]";
	}


    
    

}
