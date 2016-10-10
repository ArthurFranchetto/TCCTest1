package model;

import java.io.Serializable;

/**
 * Created by ArthurF on 03/10/16.
 */
public class Anuncio implements Comparable<Anuncio>, Serializable {

    public String titles;
    public String descriptions;
    public int images;

    public Anuncio(){

    }

    public Anuncio(String titles, String descriptions, int images){
        this.titles = titles;
        this.descriptions = descriptions;
        this.images = images;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "titles='" + titles + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", images=" + images +
                '}';
    }

    @Override
    public int compareTo(Anuncio anuncio){
        if (titles.equals(anuncio.getTitles())){
            return 0;
        }
        return this.getTitles().compareTo(anuncio.getTitles());
    }

}
