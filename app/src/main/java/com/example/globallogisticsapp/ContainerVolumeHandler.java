package com.example.globallogisticsapp;

public class ContainerVolumeHandler {
    private String containerType; //{"40 Dry", "20 Dry", "40 RF", "20 RF", "40 OT", "20 OT", "40 Flat", "20 Flat"}
    private float volume;
    private String dimensions;

    ContainerVolumeHandler() {
        containerType = "";
        volume = 0;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public void setVolume(String type) {

        if (type.equals("40 Dry") || type.equals("40 RF") || type.equals("40 OT") || type.equals("40 Flat")) {
            volume = (float) (12.19 * 2.44 * 2.59);
            setDimensions("12.19m, 2.44m, 2.59m");
        }
        else if (type.equals("20 Dry") || type.equals("20 RF") || type.equals("20 OT") || type.equals("20 Flat")) {
            volume = ((float) (6.10 * 2.44 * 2.59));
            setDimensions("6.10m, 2.44m, 2.59m");
        }
        else {
            volume = 0;
        }
    }

    public float getVolume() {
        return volume;
    }

    private void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getDimensions() {
        return dimensions;
    }
}
