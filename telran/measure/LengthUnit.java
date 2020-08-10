package telran.measure;

public enum LengthUnit {
	MM(1.0f),CM(10.0f),IN(25.4f),FT(304.8f),M(1000.0f), KM(1000000.0f);
	private float value;
	private LengthUnit(float value){
		this.value=value;
	}
	public float getValue(){
		return value;
	}
	public float between(Length l1, Length l2){	
		return l2.convert(this).getNumber() - l1.convert(this).getNumber();
	}
	public float convert(float length,LengthUnit to) {
		return length*value/to.value;
	}
}
