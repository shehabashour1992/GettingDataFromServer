package com.example.nh.gettingdatafromserver;



//  http://188.166.81.130/staging/public/stores.json

public class Store {
    private  int StoreID;
    private String StoreName;
    private String StoreDescription;
    private String StoreLogo;

    public int getStoreID() {
        return StoreID;
    }

    public void setStoreID(int storeID) {
        StoreID = storeID;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public String getStoreDescription() {
        return StoreDescription;
    }

    public void setStoreDescription(String storeDescription) {
        StoreDescription = storeDescription;
    }

    public String getStoreLogo() {
        return StoreLogo;
    }

    public void setStoreLogo(String storeLogo) {
        StoreLogo = storeLogo;
    }
}
