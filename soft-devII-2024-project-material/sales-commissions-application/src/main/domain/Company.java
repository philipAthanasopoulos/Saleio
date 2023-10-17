package main.domain;
public class Company {

	private class Address {


		private String country;
		private String city;
		private String street;
		private int streetNumber;
		private int phoneNumber;

		//TODO : Talk and maybe reformat the address to be a list -- or to somehow make it easy to understand. I am tired of long constructors. 

		public Address(String country, String city, String street, int streetNumber, int phoneNumber)
		{
			this.country = country;
			this.city = city;
			this.street = street;
			this.streetNumber = streetNumber;
			this.phoneNumber = phoneNumber;
		}

		public Address(){
			return; /*TEMPORARY address constructor because i was bored and did not know how to do it, we have to talk
			about it my lil nigga <3 */
		}
	
	
		public String getCity() {
			return city;
		}
	
		public String getCountry() {
			return country;
		}
		
		public String getStreet() {
			return street;
		}
		
		public int getStreetNumber() {
			return streetNumber;
		}
		
		public int getPhoneNumber() {
			return phoneNumber;
		}
	}

	private String companyName;
	private Address companyAddress;
	
	public Company(String companyName, Address companyAddress){
		this.companyName = companyName;
		this.companyAddress = companyAddress;
	}

	public Company(){
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
