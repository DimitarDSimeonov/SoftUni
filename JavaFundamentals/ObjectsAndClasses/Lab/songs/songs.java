package songs;

public class Songs {

    private String type;
    private String name;
    private String time;

    Songs(String type, String name, String time){
        this.type = type;
        this.name = name;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
