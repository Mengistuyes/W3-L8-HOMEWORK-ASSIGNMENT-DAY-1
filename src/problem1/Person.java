package problem1;

class Person {
	
private String lastName;
private String firstName;
private int age;
private Person[] personArray;//=new Person[5]; 
private int size;
private final int INITIAL_LENGTH = 4;
public Person() {
	personArray = new Person[INITIAL_LENGTH];
	size = 0;
}
	// --------------------------------------------------------------
	public Person(String last, String first, int a) { // constructor
		//personArray=new Person[5];
		lastName = last;
		firstName = first;
		age = a;
		
	}
	
	// --------------------------------------------------------------
	public String getLast() // get last name
	{
		return lastName;
	}
	@Override
	public String toString() {
	StringBuilder st=new StringBuilder();
		for(int i=0;i<size;i++)
		{
			st.append((i+1) + "." + "lastName= " + personArray[i].getLast() + ", FirstName= " + personArray[i].firstName +
					", Age= " + personArray[i].age + "\n");
		}
		return st.toString();
	}
	public void add(Person p){
		if(size == personArray.length)
			resize();
		personArray[size++] = p;
	}
		
	public boolean find(String lstName){
		
			for(int i=0;i<size;i++)
			{
				if(personArray[i].getLast().equals(lstName)) 
				return true;
			}
		
		return false;
	}
	
	public void insert(Person p, int pos){
		if(pos > size) return;
		if(pos >= personArray.length||size+1 > personArray.length) {
			resize();
		}
		Person[] temp = new Person[personArray.length+1];
		System.arraycopy(personArray,0,temp,0,pos);
		temp[pos] = p;
		
		System.arraycopy(personArray,pos,temp,pos+1, personArray.length - pos);
		personArray = temp;
		++size;	
	}

	public boolean remove(String lastName){
		if(size == 0) return false;
		int index = -1;
		for(int i = 0; i < size; ++i ){
			if(personArray[i].getLast().equals(lastName)){
				index = i;
				break;
			}
		}
		if(index==-1) return false;
		Person[] temp = new Person[personArray.length];
		System.arraycopy(personArray,0,temp,0,index);
		System.arraycopy(personArray,index+1,temp,index,personArray.length-(index+1));
		personArray = temp;
		--size;
		return true;
	}
	private void resize(){
		int len = personArray.length;
		int newlen = 2*len;
		Person[] temp = new Person[newlen];
		System.arraycopy(personArray,0,temp,0,len);
		personArray = temp;
	}
	public int size() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public static void main(String[] args) {
	
		System.out.println("___________________________Adding___________________________________\n");
		Person p=new Person();
		p.add(new Person("Bogale","Mengistu",27));
		p.add(new Person("Yeshiwas","Meng",31));
		p.add(new Person("Abebe","kflu",17));
		p.add(new Person("mitku","Addis",27));
		p.add(new Person("Dawit","jos",31));
		p.add(new Person("Tedla","Dereje",17));
		
		System.out.println("The size of the list Before remove is: " + p.size()+ " \n" + p.toString());
		
		System.out.println("___________________________Remove___________________________________\n");
		p.remove("Abebe");
		System.out.println("The list of size "+p.size()+" after removing Abebe into pos 1 is \n"+p);
		p.insert(new Person("Teddy","worku",37), 1);
		p.insert(new Person("Kebede","Seble",30), 1);
		System.out.println("___________________________inserting___________________________________\n");
		System.out.println("The list of size "+p.size()+" after inserting Kebede and Teddy into pos 1 is \n"+p);
		
		System.out.println("___________________________Find___________________________________\n");
		String personToBeFound="Bogale";
		if(p.find(personToBeFound))
		{
			System.out.println(personToBeFound + " is found in our record!");
		}
		else
		{
			System.out.println(personToBeFound + " is not found in our database repository!");
			
		}

	}
} // end class Person