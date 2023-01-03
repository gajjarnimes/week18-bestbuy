package com.bestbuy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.yecht.Data;

public class StorePojo {
    private  int id;
    private  String name;
    private  String type;
    private   String address;
    private  String address2;
    private  String city;
    private  String state;
    private   String zip;
    private   double lat;
    private  double lng;
    private  String hours;
    private String createdAt;
    private String updatedAt;




        public int getId() {
            return this.id; }
        public void setId(int id) {
            this.id = id; }


        public String getName() {
            return this.name; }
        public void setName(String name) {
            this.name = name; }

        public String getType() {
            return this.type; }
        public void setType(String type) {
            this.type = type; }

        public String getAddress() {
            return this.address; }
        public void setAddress(String address) {
            this.address = address; }

        public String getAddress2() {
            return this.address2; }
        public void setAddress2(String address2) {
            this.address2 = address2; }

        public String getCity() {
            return this.city; }
        public void setCity(String city) {
            this.city = city; }

        public String getState() {
            return this.state; }
        public void setState(String state) {
            this.state = state; }

        public String getZip() {
            return this.zip; }
        public void setZip(String zip) {
            this.zip = zip; }

        public double getLat() {
            return this.lat; }
        public void setLat(double lat) {
            this.lat = lat; }

        public double getLng() {
            return this.lng; }
        public void setLng(double lng) {
            this.lng = lng; }

        public String getHours() {
            return this.hours; }
        public void setHours(String hours) {
            this.hours = hours; }

        public String getCreatedAt() {
            return this.createdAt; }
        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt; }


        public String getUpdatedAt() {
            return this.updatedAt; }
        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt; }

    }



