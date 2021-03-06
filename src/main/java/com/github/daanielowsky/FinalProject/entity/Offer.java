package com.github.daanielowsky.FinalProject.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Category category;

    @Column(name = "image_type")
    private String imageType;

    private LocalDateTime created;

    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] file;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", created=" + created +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;
        Offer offer = (Offer) o;
        return Objects.equals(getId(), offer.getId()) &&
                Objects.equals(getUser(), offer.getUser()) &&
                Objects.equals(getTitle(), offer.getTitle()) &&
                Objects.equals(getDescription(), offer.getDescription()) &&
                Objects.equals(getCategory(), offer.getCategory()) &&
                Objects.equals(getImageType(), offer.getImageType()) &&
                Objects.equals(getCreated(), offer.getCreated()) &&
                Objects.equals(getPrice(), offer.getPrice()) &&
                Arrays.equals(getFile(), offer.getFile());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getUser(), getTitle(), getDescription(), getCategory(), getImageType(), getCreated(), getPrice());
        result = 31 * result + Arrays.hashCode(getFile());
        return result;
    }
}
