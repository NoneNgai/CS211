package Assignment5;

public class Member implements Comparable<Member>{
	private String code,name,phoneno;
	private Integer amount;
	public Member(String c,String n,String p,Integer a) {
		code = c;
		name = n;
		phoneno = p;
		amount = a;
	}
	public String getCode() {
		return code;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public Integer getAmount() {
		return amount;
	}
	public String getName() {
		return name;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return code + "     " + name;
	}
	@Override
	public int compareTo(Member o) {
		if(amount == o.amount) {
			return 0;
		}
		else if(amount < o.amount) {
			return 1;
		}
		else
			return -1;
	}
}
