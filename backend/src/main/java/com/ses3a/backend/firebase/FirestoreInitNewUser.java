package com.ses3a.backend.firebase;

import com.google.cloud.firestore.Firestore;
import com.ses3a.backend.entity.request.CreateNewUserRequest;

import java.util.HashMap;
import java.util.Map;

public class FirestoreInitNewUser {

    protected static void initVendor(Firestore firestore, CreateNewUserRequest request){
        System.out.println("INIT VENDORS CALLED");
        Map<String, Object> emptyData = new HashMap<>();
        firestore.collection("users")
                .document(FirebaseUtils.convertToUserType(request.getRole()))
                .collection(request.getEmail())
                .document("products")
                .create(emptyData);
        firestore.collection("users")
                .document(FirebaseUtils.convertToUserType(request.getRole()))
                .collection(request.getEmail())
                .document("onlineProducts")
                .create(emptyData);
        firestore.collection("carts")
                .document(request.getEmail())
                .create(emptyData);
        firestore.collection("vendorPurchases")
                .document(request.getEmail())
                .create(emptyData);
    }

    protected static void initSupplier(Firestore firestore, CreateNewUserRequest request){
        System.out.println("INIT SUPPLIERS CALLED");
        Map<String, Object> emptyData = new HashMap<>();
        firestore.collection("users")
                .document(FirebaseUtils.convertToUserType(request.getRole()))
                .collection(request.getEmail())
                .document("products")
                .create(emptyData);
        firestore.collection("supplierPurchases")
                .document(request.getEmail())
                .collection("pendingPurchases")
                .add(emptyData);
        firestore.collection("supplierPurchases")
                .document(request.getEmail())
                .collection("deliveredPurchases")
                .add(emptyData);
    }
}
