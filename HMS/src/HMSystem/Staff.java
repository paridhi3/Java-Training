package HMSystem;

public class Staff {
    private int id;
    private String name;
    private String role;
    private String contact_number;

    public Staff(int id, String name, String role, String contact_number) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.contact_number = contact_number;
    }

    public Staff(String name, String role, String contact_number) {
        this.name = name;
        this.role = role;
        this.contact_number = contact_number;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactNumber() {
        return contact_number;
    }

    public void setContactNumber(String contact_number) {
        this.contact_number = contact_number;
    }

    @Override
    public String toString() {
        return "Staff [id=" + id + ", name=" + name + ", role=" + role + ", contactNumber=" + contact_number + "]";
    }
}
