package question1;


public class MyCollection implements DynamicArray{

	@SuppressWarnings("unused")
	private int[] numArray;
	private int count_for_each_array=0;
	
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
	}

	public int search(int searchingNum) 
	{
	 int len=numArray.length;
	 int pos=-1;
	for(int i=0;i<count_for_each_array;i++)
	{
		if(numArray[i]==searchingNum)
		{
			pos=i;
			break;
		}
	}
		return pos;
	}

	public boolean add(int numberToAdd)
	{
		int size_of_array=count_for_each_array;
		if(search(numberToAdd)==-1 && size_of_array!=numArray.length)
		{
			numArray[size_of_array]=numberToAdd;
			count_for_each_array++;
			return true;
		}
		else if(size_of_array==numArray.length)
		{
			doubleCapacity();
			size_of_array=count_for_each_array;
			numArray[size_of_array]=numberToAdd;
			count_for_each_array++;
			return true;
		}
		return false;
	}

	public void doubleCapacity() 
	{
		int []doublearray=new int[numArray.length*2];
		for(int i=0;i<numArray.length;i++)
		{
			doublearray[i]=numArray[i];
		}
		numArray=doublearray;
	}

	public boolean remove(int numberToRemove)
	{
		int position=search(numberToRemove);
		if(position!=-1) {
		for(int i=position;i<count_for_each_array-1;i++) {
			numArray[i]=numArray[i+1];
		}
		numArray[count_for_each_array-1]=0;
		return true;
		}
		return false;
	}

	public int getCount() 
	{
		return count_for_each_array;
	}

	public int[] rotate(int n)
	{
		int []rotate_array=new int[n];
		
		for(int i=0;i<n;i++)
			rotate_array[i]=numArray[i];
		
		for(int j=n;j<numArray.length;j++)
			numArray[j-n]=numArray[j];
		
		for(int i=0;i<n;i++) {
			numArray[count_for_each_array-n+i]=rotate_array[i];
		}
		return null;
	}
	
	public String toString() {
		String substr="";
		String array="{";
		for(int i=0;i<count_for_each_array;i++) {
			array=array+Integer.toString(numArray[i])+",";
		}
		if(array.charAt(array.length()-1)==',') {
			array=array.substring(0, array.length()-1);
		}
		array=array+"}";
		return array;
	}
}
