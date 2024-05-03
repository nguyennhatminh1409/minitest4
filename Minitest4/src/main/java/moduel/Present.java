package moduel;

public class Present {
    private int id;
    private String code;
    private String name;
    private double price;
    private String ship;
    private String img;

    public Present() {
    }

    public Present(String code, String name, double price, String ship, String img) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.ship = ship;
        this.img = img;
    }

    public Present(int id, String code, String name, double price, String ship, String img) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.ship= ship;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
