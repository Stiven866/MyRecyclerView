package com.stivenduque.myrecyclerview;

/**
 * Created by stiven on 21/02/18.
 */

class Figure {
    private String figureName, figureNameComent;
    private int idPhoto;

    public Figure(String figureName, String figureNameComent, int idPhoto){
        this.figureName = figureName;
        this.figureNameComent = figureNameComent;
        this.idPhoto = idPhoto;
    }


    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }

    public String getFigureNameComent() {
        return figureNameComent;
    }

    public void setFigureNameComent(String figureNameComent) {
        this.figureNameComent = figureNameComent;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }
}
