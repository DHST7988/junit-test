package Assignment;
public class DeliveryStaff {

	private String name;
	private String pNumber;
	
	public String getName()
	{
		return name;
	}
	
	public String getNumber()
	{
		return pNumber;
	}
	
	public void setName(String name)
	{
		this.name =  name;
	}
	
	public void setNumber(String Number)
	{
		this.pNumber =  Number;
	}
	
	public DeliveryStaff(String name, String pNumber)
	{
		this.name = name;
		this.pNumber = pNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DeliveryStaff) {
			DeliveryStaff compareDeliveryStaff = (DeliveryStaff)obj;
			if (name.equals(compareDeliveryStaff.getName())
					&& pNumber.equals(compareDeliveryStaff.getNumber()))
				return true;
		}
		return false;
	}
}
