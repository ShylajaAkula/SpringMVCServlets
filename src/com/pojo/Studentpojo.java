package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="studentslist")
/*@Table(name="studentslist")*/
public class Studentpojo {

	private Integer sno;
	private String sname;
	private String batch;
	private String famt;
	private MultipartFile file;
	
	@Transient
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Id
	@GeneratedValue
	
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	@Column(name="sname")
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Column(name="batch")
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	@Column(name="famt")
	public String getFamt() {
		return famt;
	}
	public void setFamt(String famt) {
		this.famt = famt;
	}
}
