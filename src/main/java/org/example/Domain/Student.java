package org.example.Domain;

import java.util.Objects;

public class Student extends Entity<Long>{
    private String nume;
    private String prenume;
    private String grupa;
    private double media;

    public Student(String nume, String prenume, String grupa, double media) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.media = media;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume=" + nume +
                ", prenume='" + prenume + '\'' +
                ", grupa='" + grupa + '\'' +
                ", media=" + media +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.media, media) == 0 && Objects.equals(nume, student.nume) && Objects.equals(prenume, student.prenume) && Objects.equals(grupa, student.grupa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, grupa, media);
    }
}
