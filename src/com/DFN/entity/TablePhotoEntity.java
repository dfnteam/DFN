package com.DFN.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "table_photo", schema = "dfn", catalog = "")
public class TablePhotoEntity {
    private int photoId;
    private String photoAddress;
    private Integer photoAlbumId;
    private String photoOther;

    @Id
    @Column(name = "photo_id")
    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    @Basic
    @Column(name = "photo_address")
    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress;
    }

    @Basic
    @Column(name = "photo_album_id")
    public Integer getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(Integer photoAlbumId) {
        this.photoAlbumId = photoAlbumId;
    }

    @Basic
    @Column(name = "photo_other")
    public String getPhotoOther() {
        return photoOther;
    }

    public void setPhotoOther(String photoOther) {
        this.photoOther = photoOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TablePhotoEntity that = (TablePhotoEntity) o;
        return photoId == that.photoId &&
                Objects.equals(photoAddress, that.photoAddress) &&
                Objects.equals(photoAlbumId, that.photoAlbumId) &&
                Objects.equals(photoOther, that.photoOther);
    }

    @Override
    public int hashCode() {

        return Objects.hash(photoId, photoAddress, photoAlbumId, photoOther);
    }
}
