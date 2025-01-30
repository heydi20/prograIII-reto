package com.itsqmet.app_biblioteca.Entidad;





public class Libro {
    private int id;
    private String titulo;
    private String editorial;
    private int paginas;

    public Libro(int id, String titulo, String editorial, int paginas) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.paginas = paginas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}
