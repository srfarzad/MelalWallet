package com.navin.melalwallet.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product implements Parcelable {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("packageName")
    @Expose
    private String packageName;
    @SerializedName("versionCode")
    @Expose
    private String versionCode;
    @SerializedName("versionName")
    @Expose
    private String versionName;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("fullDescription")
    @Expose
    private String fullDescription;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("rate")
    @Expose
    private String rate;
    @SerializedName("downloadLink")
    @Expose
    private String downloadLink;
    @SerializedName("number_installs")
    @Expose
    private String numberInstalls;
    @SerializedName("minSDK")
    @Expose
    private String minSDK;
    @SerializedName("bulk")
    @Expose
    private String bulk;
    @SerializedName("announcementUrl")
    @Expose
    private String announcementUrl;
    @SerializedName("developer")
    @Expose
    private String developer;


    public Product() {

    }

    protected Product(Parcel in) {
        id = in.readString();
        catId = in.readString();
        title = in.readString();
        icon = in.readString();
        packageName = in.readString();
        versionCode = in.readString();
        versionName = in.readString();
        shortDescription = in.readString();
        fullDescription = in.readString();
        price = in.readString();
        rate = in.readString();
        downloadLink = in.readString();
        numberInstalls = in.readString();
        minSDK = in.readString();
        bulk = in.readString();
        announcementUrl = in.readString();
        developer = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public String getNumberInstalls() {
        return numberInstalls;
    }

    public void setNumberInstalls(String numberInstalls) {
        this.numberInstalls = numberInstalls;
    }

    public String getMinSDK() {
        return minSDK;
    }

    public void setMinSDK(String minSDK) {
        this.minSDK = minSDK;
    }

    public String getBulk() {
        return bulk;
    }

    public void setBulk(String bulk) {
        this.bulk = bulk;
    }

    public String getAnnouncementUrl() {
        return announcementUrl;
    }

    public void setAnnouncementUrl(String announcementUrl) {
        this.announcementUrl = announcementUrl;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(catId);
        parcel.writeString(title);
        parcel.writeString(icon);
        parcel.writeString(packageName);
        parcel.writeString(versionCode);
        parcel.writeString(versionName);
        parcel.writeString(shortDescription);
        parcel.writeString(fullDescription);
        parcel.writeString(price);
        parcel.writeString(rate);
        parcel.writeString(downloadLink);
        parcel.writeString(numberInstalls);
        parcel.writeString(minSDK);
        parcel.writeString(bulk);
        parcel.writeString(announcementUrl);
        parcel.writeString(developer);
    }
}
