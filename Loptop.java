package HomeWorkJava;


import java.util.Objects;

public class Loptop { 
    
    private int HardDisk;
    private int RAM;
    private String color;
    private String OperatingSystem;

    public Loptop(int HardDisk, int RAM, String color, String OperatingSystem) {
        this.HardDisk = HardDisk;
        this.RAM = RAM;
        this.color = color;
        this.OperatingSystem = OperatingSystem;
    }

    public int getHardDisk() {
        return HardDisk;
    }

    public int getRAM() {
        return RAM;
    }

    public String getColor() {
        return color;
    }

    public String getOperatingSystem() {
        return OperatingSystem;
    }

    public void setHardDisk(int HardDisk) {
        this.HardDisk = HardDisk;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOperatingSystem(String OperatingSystem) {
        this.OperatingSystem = OperatingSystem;
    }

    @Override
    public String toString() {
        String result = "HardDisk: " + HardDisk + System.lineSeparator()
                + "RAM: " + RAM + System.lineSeparator()
                + "Color: " + color + System.lineSeparator()
                + "OperatingSystem: " + OperatingSystem;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

            Loptop Loptop = (Loptop) obj;

        return HardDisk == Loptop.HardDisk && RAM == Loptop.RAM
                && color.equals(Loptop.color) && OperatingSystem.equals(Loptop.OperatingSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(HardDisk, RAM, color, OperatingSystem);
    }
}