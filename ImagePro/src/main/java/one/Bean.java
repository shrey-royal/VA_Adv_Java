package one;

public class Bean {
	private int id;
	private String name;
	private byte[] data;
	
	public Bean() {}
	
	public Bean(String name, byte[] data) {
		this.name = name;
		this.data = data;
	}
	
	public Bean(int id, String name, byte[] data) {
		this.id = id;
		this.name = name;
		this.data = data;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}
}
