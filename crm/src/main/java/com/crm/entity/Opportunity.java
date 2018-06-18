package com.crm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Opportunity")
public class Opportunity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6510485633100541230L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contactinfo_id")
	private ContactInformation contactInformation;

	private String title;

	private String tags;

	private Float minrev;

	private Float maxrev;

	private Date saledate;

	private String projecttype;

	@OneToOne
	@JoinColumn(name = "salesperson")
	private SalesPerson salesperson;
	@OneToMany
	@JoinColumn(name = "company_id")
	private List<Company> companies;

	private Lead lead;

	private Long confidence;

	private String status;

	private String notes;
	@Version
	private int version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContactInformation getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Float getMinrev() {
		return minrev;
	}

	public void setMinrev(Float minrev) {
		this.minrev = minrev;
	}

	public Float getMaxrev() {
		return maxrev;
	}

	public void setMaxrev(Float maxrev) {
		this.maxrev = maxrev;
	}

	public Date getSaledate() {
		return saledate;
	}

	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}

	public String getProjecttype() {
		return projecttype;
	}

	public void setProjecttype(String projecttype) {
		this.projecttype = projecttype;
	}

	public SalesPerson getSalesperson() {
		return salesperson;
	}

	public void setSalesperson(SalesPerson salesperson) {
		this.salesperson = salesperson;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}

	public Long getConfidence() {
		return confidence;
	}

	public void setConfidence(Long confidence) {
		this.confidence = confidence;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
