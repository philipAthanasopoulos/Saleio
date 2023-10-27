package main.domain;
public class Company {

	private String companyName;
	private Address companyAddress;
	
	public Company(String companyName, Address companyAddress){
		this.companyName = companyName;
		this.companyAddress = companyAddress;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getCompanyAddress() {
		return this.companyAddress;
	}

	public String getAddressCountry(){
		return companyAddress.getCountry();
	}

	public String getAddressCity(){
		return companyAddress.getCity();
	}

	public String getAddressStreet(){
		return companyAddress.getStreet();
	}

	public int getAddressNumber(){
		return companyAddress.getStreetNumber();
	}

	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}
	
}
