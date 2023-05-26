package org.example;

public class NoteBook {
    private Integer RAM_volume;

    private Integer HDD_volume;
    private String OS;
    private String color_string;
    private String manufacturer;
    private Integer price;
    public void setColor ( String color) {
        this.color_string = color;
    }

    public String getColor ( ) {
        return color_string;
    }

    public void setRAM_volume ( Integer RAM_volume ) {
        this.RAM_volume = RAM_volume;
    }

    public Integer getRAM_volume ( ) {
        return RAM_volume;
    }

    public Integer getHDD_volume ( ) {
        return HDD_volume;
    }

    public String getOS ( ) {
        return OS;
    }

    public String getManufacturer ( ) {
        return manufacturer;
    }

    public Integer getPrice ( ) {
        return price;
    }

    public void setHDD_volume ( Integer HDD_volume ) {
        this.HDD_volume = HDD_volume;
    }

    public void setOS ( String OS ) {
        this.OS = OS;
    }

    public void setManufacturer ( String manufacturer ) {
        this.manufacturer = manufacturer;
    }

    public void setPrice ( Integer price ) {
        this.price = price;
    }

    @Override
    public String toString ( ) {
        return    String.format ( "%s, color: %s, RAM: %dGb, HDD: %dGb, OS: %s, Price: $%d"
                , getManufacturer ()
                , getColor ()
                , getRAM_volume ()
                , getHDD_volume ()
                , getOS ()
                , getPrice ()
                );
    }
}
