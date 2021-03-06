package a.talenting.com.talenting.domain.hosting;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daeho on 2017. 12. 11..
 */

public class Hosting {
    @Expose(serialize = false)
    private String owner;
    @Expose(serialize = false)
    private String created_at;
    @Expose(serialize = false)
    private String published;
    @Expose(serialize = false)
    private String recommend_counter;
    @Expose(serialize = false)
    private String updated_at;
    @Expose(serialize = false)
    private String primary_photo;
    @Expose(serialize = false)
    private String wish_status;

    @Expose private String summary;
    @Expose private String max_stay;
    @Expose private String transportation;
    @Expose private String room_type;
    @Expose private String title;
    @Expose private String house_type;
    @Expose private String smoking;
    @Expose private String description;
    @Expose private String capacity;
    @Expose private String to_do;
    @Expose private String exchange;
    @Expose private String meal_type;
    @Expose private String neighborhood;
    @Expose private String rules;
    @Expose private String category;
    @Expose private String pet;
    @Expose private String min_stay;
    @Expose private List<String> language;
    @Expose private String internet;
    @Expose private String lat;
    @Expose private String lon;


    @Expose private String country = "KR";
    @Expose private String street = "empty";
    @Expose private String address = "empty";
    @Expose private String postcode = "empty";
    @Expose private String city = "empty";
    @Expose private String distinct = "empty";

    public boolean isWish(){
        return !(wish_status == null || wish_status.equals("") || wish_status.toUpperCase().equals("FALSE"));
    }

    public String getWish_status() {
        return wish_status;
    }

    public void setWish_status(String wish_status) {
        this.wish_status = wish_status;
    }

    public String getPrimary_photo() {
        return primary_photo;
    }

    public void setPrimary_photo(String primary_photo) {
        this.primary_photo = primary_photo;
    }

    public String getLat() {
        if(lat == null || "".equals(lat)) lat = "0";
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        if(lon == null || "".equals(lon)) lon = "0";
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    public String getStreet ()
    {
        return street;
    }

    public void setStreet (String street)
    {
        this.street = street;
    }

    public String getMax_stay ()
    {
        return max_stay;
    }

    public void setMax_stay (String max_stay)
    {
        this.max_stay = max_stay;
    }

    public String getTransportation ()
    {
        return transportation;
    }

    public void setTransportation (String transportation)
    {
        this.transportation = transportation;
    }

    public String getRoom_type ()
    {
        return room_type;
    }

    public void setRoom_type (String room_type)
    {
        this.room_type = room_type;
    }

    public String getDistinct ()
    {
        return distinct;
    }

    public void setDistinct (String distinct)
    {
        this.distinct = distinct;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getHouse_type ()
    {
        return house_type;
    }

    public void setHouse_type (String house_type)
    {
        this.house_type = house_type;
    }

    public String getSmoking ()
    {
        return smoking;
    }

    public boolean isSmoking(){
        return "true".equals(smoking);
    }

    public void setSmoking (String smoking)
    {
        this.smoking = smoking;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getCapacity ()
    {
        return capacity;
    }

    public void setCapacity (String capacity)
    {
        this.capacity = capacity;
    }

    public String getTo_do ()
    {
        return to_do;
    }

    public void setTo_do (String to_do)
    {
        this.to_do = to_do;
    }

    public String getPublished ()
    {
        return published;
    }

    public void setPublished (String published)
    {
        this.published = published;
    }

    public String getExchange ()
    {
        return exchange;
    }

    public void setExchange (String exchange)
    {
        this.exchange = exchange;
    }

    public String getMeal_type ()
    {
        return meal_type;
    }

    public void setMeal_type (String meal_type)
    {
        this.meal_type = meal_type;
    }

    public String getRecommend_counter ()
    {
        return recommend_counter;
    }

    public void setRecommend_counter (String recommend_counter)
    {
        this.recommend_counter = recommend_counter;
    }

    public String getNeighborhood ()
    {
        return neighborhood;
    }

    public void setNeighborhood (String neighborhood)
    {
        this.neighborhood = neighborhood;
    }

    public String getPostcode ()
    {
        return postcode;
    }

    public void setPostcode (String postcode)
    {
        this.postcode = postcode;
    }

    public String getRules ()
    {
        return rules;
    }

    public void setRules (String rules)
    {
        this.rules = rules;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getPet ()
    {
        return pet;
    }

    public boolean isPet(){
        return "true".equals(pet);
    }

    public void setPet (String pet)
    {
        this.pet = pet;
    }

    public String getOwner ()
    {
        return owner;
    }

    public void setOwner (String owner)
    {
        this.owner = owner;
    }

    public String getMin_stay ()
    {
        return min_stay;
    }

    public void setMin_stay (String min_stay)
    {
        this.min_stay = min_stay;
    }

    public List<String> getLanguage ()
    {
        if(language == null) language = new ArrayList<>();
        return language;
    }

    public void setLanguage (List<String> language)
    {
        this.language = language;
    }

    public String getInternet ()
    {
        return internet;
    }

    public void setInternet (String internet)
    {
        this.internet = internet;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", street = "+street+", max_stay = "+max_stay+", transportation = "+transportation+", room_type = "+room_type+", lat = "+lat+", distinct = "+distinct+", city = "+city+", title = "+title+", house_type = "+house_type+", smoking = "+smoking+", description = "+description+", created_at = "+created_at+", capacity = "+capacity+", to_do = "+to_do+", published = "+published+", exchange = "+exchange+", meal_type = "+meal_type+", recommend_counter = "+recommend_counter+", neighborhood = "+neighborhood+", postcode = "+postcode+", rules = "+rules+", country = "+country+", category = "+category+", updated_at = "+updated_at+", address = "+address+", pet = "+pet+", lon = "+lon+", owner = "+owner+", min_stay = "+min_stay+", language = "+language+", internet = "+internet+"]";
    }
}
