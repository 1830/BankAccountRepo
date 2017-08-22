package packages.utilities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class responseMessage {
	
	@JsonProperty
	private String  MESSAGE;
	@JsonProperty
	private String STATUS;
	
	public String getMESSAGE() {
		return MESSAGE;
	}

	public String getSTATUS() {
		return STATUS;
	}

	

}
