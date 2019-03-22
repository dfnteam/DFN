package com.DFN.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "table_album", schema = "dfn", catalog = "")
public class TableAlbumEntity {
    private int albumId;
    private String albumName;
    private Timestamp albumDate;
    private String albumOther;

    @Id
    @Column(name = "album_id")
    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Basic
    @Column(name = "album_name")
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Basic
    @Column(name = "album_date")
    public Timestamp getAlbumDate() {
        return albumDate;
    }

    public void setAlbumDate(Timestamp albumDate) {
        this.albumDate = albumDate;
    }

    @Basic
    @Column(name = "album_other")
    public String getAlbumOther() {
        return albumOther;
    }

    public void setAlbumOther(String albumOther) {
        this.albumOther = albumOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableAlbumEntity that = (TableAlbumEntity) o;
        return albumId == that.albumId &&
                Objects.equals(albumName, that.albumName) &&
                Objects.equals(albumDate, that.albumDate) &&
                Objects.equals(albumOther, that.albumOther);
    }

    @Override
    public int hashCode() {

        return Objects.hash(albumId, albumName, albumDate, albumOther);
    }
}
