package Entities;

public class Table {
    
    private int id;
    private int number;
    private int capactity;
    private int location;

    public Table() {
    }

    public Table(int number, int capactity, int location) {
        this.number = number;
        this.capactity = capactity;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapactity() {
        return capactity;
    }

    public void setCapactity(int capactity) {
        this.capactity = capactity;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Table other = (Table) obj;
        return this.id == other.id;
    }
    
    
    
}
