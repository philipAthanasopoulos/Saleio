package main.domain;
public class Company {

	private String companyName;
	private Address companyAddress;
	
	public Company(String companyName, Address companyAddress){
		this.companyName = companyName;
		this.companyAddress = companyAddress;
	}

	public Company(String companyName,
					String country,
					String city,
					String street,
					int streetNumber,
					int phoneNumber){
		
		this.companyName = companyName;
		this.companyAddress = new Address(country, city, street, streetNumber, phoneNumber);
	}

	public Company(){
		//Empty Constructor temporary

		return;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}
}
