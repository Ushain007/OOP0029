package com.example.oop0029;

import java.io.Serializable;

public class Monitor_2320676 implements Serializable {

    private String name;
    private String resolution;
    private int diagonal;
    private int ppi;

    public Monitor_2320676(String name, String resolution, int diagonal) {
        this.name = name;
        this.resolution = resolution;
        this.diagonal = diagonal;
        this.ppi = calculatePPI();
    }

    private int calculatePPI() {
        if (resolution.equals("HD")) {
            switch (diagonal) {
                case 17: return 86;
                case 19: return 77;
                case 22: return 67;
                case 24: return 61;
            }
        }

        if (resolution.equals("HD+")) {
            switch (diagonal) {
                case 17: return 108;
                case 19: return 97;
                case 22: return 83;
                case 24: return 76;
            }
        }

        if (resolution.equals("Full-HD")) {
            switch (diagonal) {
                case 17: return 130;
                case 19: return 116;
                case 22: return 100;
                case 24: return 92;
            }
        }

        if (resolution.equals("QHD")) {
            switch (diagonal) {
                case 17: return 173;
                case 19: return 155;
                case 22: return 134;
                case 24: return 122;
            }
        }

        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
        this.ppi = calculatePPI();
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
        this.ppi = calculatePPI();
    }

    public int getPpi() {
        return ppi;
    }

    @Override
    public String toString() {
        return "Monitor_2320676{" +
                "name='" + name + '\'' +
                ", resolution='" + resolution + '\'' +
                ", diagonal=" + diagonal +
                ", ppi=" + ppi +
                '}';
    }
}
