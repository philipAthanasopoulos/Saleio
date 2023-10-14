package domain;
public class Company {
	private String companyName;
	private Address companyAddress;

	public Company(){
		companyAddress = new Address();
	}
	public Company(String companyName, Address companyAddress){
		this.companyName = companyName;
		this.companyAddress = companyAddress;
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
