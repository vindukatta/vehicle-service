package uk.ide.dvla.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FileDetails {
	
	public String fileName;
	
	public String fileType;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	

}
