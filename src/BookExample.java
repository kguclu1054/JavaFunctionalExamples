import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BookExample {

	public static void main(String[] args) {

		class Book{
			String title;
			int pageCount;
			
			Book(String title, int pageCount){
			this.title = title;
			this.pageCount = pageCount;
			}
			
			@Override public String toString() {
				return title + " (" + pageCount + " pages)";
			}
		}
		
		Book book1 = new Book("Book one", 560);
		Book book2 = new Book("Book two", 240);
		
		Comparator<Book> pageCountComparator = Comparator.comparingInt(book -> book.pageCount);
		
		BinaryOperator<Book> maxByPageCount = BinaryOperator.maxBy(pageCountComparator);
		
		Book result = maxByPageCount.apply(book1, book2);
		System.out.println("Book with more pages" + result);
	}

}
