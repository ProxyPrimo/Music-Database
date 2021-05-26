package musicdb.data.service;

import musicdb.data.entity.enumeration.ArtistName;
import musicdb.data.entity.enumeration.GenreName;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumServiceModel {
    private String name;
    private String imageURL;
    private BigDecimal price;
    private Integer copies;
    private String description;
    private LocalDate releaseDate;
    private String producer;
    private ArtistName artist;
    private GenreName genre;
    private String addedFromUsername;

    public AlbumServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArtistName getArtist() {
        return artist;
    }

    public void setArtist(ArtistName artist) {
        this.artist = artist;
    }

    public GenreName getGenre() {
        return genre;
    }

    public void setGenre(GenreName genre) {
        this.genre = genre;
    }

    public String getAddedFromUsername() {
        return addedFromUsername;
    }

    public void setAddedFromUsername(String addedFromUsername) {
        this.addedFromUsername = addedFromUsername;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
