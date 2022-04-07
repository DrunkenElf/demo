package com.example.demo.entities;

import javax.persistence.*;

/* В запросе на изменение данных адреса принимается модель адреса без Id
* Поэтому у меня 2 сущности AddressEntity и AddressWithoutId
* я бы мог просто наследовать AddressEntity от AddressWithoutId с добавлением поля Id,
* но тогда бд не видела бы наследуемые поля(я попробовал, но не получилось. пришлось копипастить)*/

@Entity
@Table(name = "addresses")
public class AddressEntity{

    @Id
    /*в начале думал что оно само должно генерироваться, потом увидел что генерится на стороне клиента
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid")*/
    @Column(length = 36, nullable = false, updatable = false)
    private String id;

    private String plain_address;
    private String instruction;
    @Column(length = 9)
    private String index;
    @Column(length = 200)
    private String region;
    @Column(length = 200)
    private String area;
    @Column(length = 200)
    private String place;
    @Column(length = 200)
    private String district;
    @Column(length = 200)
    private String street;
    @Column(length = 60)
    private String house;
    @Column(length = 2)
    private String letter;
    @Column(length = 8)
    private String slash;
    @Column(length = 8)
    private String corpus;
    @Column(length = 8)
    private String building;
    @Column(length = 60)
    private String room;

    public AddressEntity(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlain_address() {
        return plain_address;
    }

    public void setPlain_address(String plain_address) {
        this.plain_address = plain_address;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getSlash() {
        return slash;
    }

    public void setSlash(String slash) {
        this.slash = slash;
    }

    public String getCorpus() {
        return corpus;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void toEntity(AddressWithoutId addr){
        this.setArea(addr.getArea());
        this.setBuilding(addr.getBuilding());
        this.setCorpus(addr.getCorpus());
        this.setDistrict(addr.getDistrict());
        this.setHouse(addr.getHouse());
        this.setIndex(addr.getIndex());
        this.setInstruction(addr.getInstruction());
        this.setLetter(addr.getLetter());
        this.setPlace(addr.getPlace());
        this.setPlain_address(addr.getPlain_address());
        this.setRegion(addr.getRegion());
        this.setRoom(addr.getRoom());
        this.setSlash(addr.getSlash());
        this.setStreet(addr.getStreet());
    }

}
