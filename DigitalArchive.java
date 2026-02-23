public class DigitalArchive{
    public static void main(String[]args){
        Librarian librarian= new Librarian(12345678,"Efe",26,5);
        Book book1= new Book("12-23-34-45","Art Of War",45,100);
        Book book2= new Book("23-34-45-56","Random book",345,768.57);
        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.displayAllBooks();
        librarian.removeBook("12-23-34-45");
        librarian.displayAllBooks();
        librarian.findBookAndApplyDiscount("23-34-45-56",60);
        librarian.displayAllBooks();
        librarian.updatePrice(book2,600);
        librarian.displayAllBooks();
    }
}
class Book{
    private String isbn;
    private String title;
    private int pageCount;
    private double price;
    public Book(String isbn,String title,int pageCount,double price){
        this.isbn=isbn;
        this.title=title;
        this.pageCount=pageCount;
        this.price=price;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
class Librarian{
    private long employeeID;
    private String name;
    private int age;
    Book[] books;

    public long getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Librarian(long employeeID, String name, int age, int books){
        this.employeeID=employeeID;
        this.name=name;
        this.age=age;
        this.books= new Book[books];
    }
    public void addBook(Book book){
        for (int i=0;i<books.length;i++){
            if(books[i]==null){
                books[i]=book;
                break;
            }
        }
    }
    public void removeBook(String isbn){
        for(int i=0;i< books.length;i++){
            if(books[i]!=null && books[i].getIsbn().equals(isbn)){
                books[i]=null;
                break;
            }
        }
    }
    public Book findBook(String isbn){
        for (int i = 0; i < books.length; i++) {
            if(books[i] != null && isbn.equals(books[i].getIsbn())) {
                return books[i];
            }
        }
        return null;
    }
    public void updatePrice(Book book, double newPrice){
        for (int i = 0; i < books.length; i++) {
            if(book==books[i]){
                books[i].setPrice(newPrice);
            }
        }
    }
    public void findBookAndApplyDiscount(String isbn, double discountPercentage){
        if (findBook(isbn)!=null){
            findBook(isbn).setPrice(findBook(isbn).getPrice()*((100-discountPercentage)/100));
        }
    }
    public void displayAllBooks(){
        System.out.println("Librarian;");
        System.out.println("Employee ID: "+getEmployeeID());
        System.out.println("Name: "+getName());
        System.out.println("Age: "+getAge());
        for (int i = 0; i < books.length; i++) {
            if(books[i]==null){
                continue;
            }
            System.out.println(" Book "+(i+1)+" ;");
            System.out.println("   ISBN: "+books[i].getIsbn());
            System.out.println("   Title: "+books[i].getTitle());
            System.out.println("   Price: "+books[i].getPrice());
            System.out.println("   Page Count: "+books[i].getPageCount());
        }
    }
}