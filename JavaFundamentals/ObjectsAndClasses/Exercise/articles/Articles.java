package articles;

public class Articles {

    private String title;
    private String contend;
    private String author;

    public Articles(String title, String contend, String author){
        this.title = title;
        this.contend = contend;
        this.author = author;
    }
    public void Edit (String newContend){
        this.contend = newContend;
    }
    public void ChangeAuthor (String newAuthor){
        this.author = newAuthor;
    }
    public void Rename (String newTitle){
        this.title = newTitle;
    }
    @Override
    public String toString(){
        return this.title + " - " + this.contend + ": " + this.author;
    }
}
