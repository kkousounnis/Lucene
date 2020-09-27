package Model;

public class Text {
	private String Title;
	private String isbn;
	private int counter;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setCounter(int Counter) {
		counter=Counter;
	}
	public int getCounter() {
		return counter;
	}
	@Override
	public String toString() {
		return "Text counter="+counter+ ", isbn="+isbn+", title="+Title+"";
	}
}
