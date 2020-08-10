package telran.measure;

public class Length {
	private float number;
	private LengthUnit unit;
	public Length(float number, LengthUnit unit) {
		super();
		this.number = number;
		this.unit = unit;
	}
	public float getNumber() {
		return number;
	}
	public void setNumber(float number) {
		this.number = number;
	}
	public LengthUnit getUnit() {
		return unit;
	}
	public void setUnit(LengthUnit unit) {
		this.unit = unit;
	}
	@Override
	public String toString(){
		return String.format("%.1f%s",number,unit );
	}
	public Length plus(Length length) {
		return new Length(number+length.convert(unit).number ,unit);
	}
	public Length minus(Length length) {
		return new Length(number-length.convert(unit).number ,unit);
	}
	public Length convert(LengthUnit otherUnit) {
		return new Length( unit.convert(number, otherUnit),otherUnit);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
		Length length = (Length)obj;
		Length other = new Length( unit.convert(number, length.unit), length.unit);
		return unit==other.unit&&number==other.number;
	}
	
}
