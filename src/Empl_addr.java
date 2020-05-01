public class Empl_addr {
    private String full_name;
    private String position;
    private String address;

    public Empl_addr(String full_name, String position, String address) {
        this.full_name = full_name;
        this.position = position;
        this.address = address;

    }
    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String login) {
        this.full_name = full_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
