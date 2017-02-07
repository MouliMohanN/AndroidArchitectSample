/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 10/11/16 1:17 PM
 */

package gaurav.com.example.androidarchitectsample.data.local;

//import io.realm.Realm;
//import io.realm.RealmObject;
//import io.realm.RealmQuery;
//import io.realm.RealmResults;
//import io.realm.Sort;

/**
 * Created by Gaurav on 07/11/16.
 */
public class DatabaseManager implements IDBOperations {

    private static DatabaseManager instance;
//    Realm realm = Realm.getDefaultInstance();

//    private DatabaseManager() {
//
//    }

//    public static IDBOperations getOperations() {
//        if (instance == null) {
//            instance = new DatabaseManager();
//        }
//        return instance;
//    }

//    public RealmResults<? extends RealmObject> prepareWhereClause(RealmQuery<? extends RealmObject> query, String[] fieldNames, String... values) {
//        for(int i = 0 ; i < fieldNames.length; i++){
//            query.equalTo(fieldNames[i], values[i]);
//        }
//
//        return query.findAll();
//    }
//
//    @Override
//    public void insert(final RealmObject model) {
//
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                realm.copyToRealm(model);
//            }
//        });
//
//    }
//
//    @Override
//    public void update(final RealmObject model, String where) {
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                realm.copyToRealmOrUpdate(model);
//            }
//        });
//    }
//
//    @Override
//    public void delete(Class<? extends RealmObject> model, String fieldName, String value) {
//        final RealmResults<RealmObject> results = (RealmResults<RealmObject>) realm.where(model).findAll();
//        // All changes to data must happen in a transaction
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                results.deleteAllFromRealm();
//            }
//        });
//    }
//
//    @Override
//    public void delete(Class<? extends RealmObject> model, String[] fieldNames, String... values) {
//        final RealmResults<RealmObject> results = (RealmResults<RealmObject>) prepareWhereClause(realm.where(model), fieldNames, values);
//        // All changes to data must happen in a transaction
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                results.deleteAllFromRealm();
//            }
//        });
//    }
//
//    @Override
//    public void bulkInsert(List<? extends RealmObject> modelList) {
//
//    }
//
//    @Override
//    public void bulkUpdate(List<? extends RealmObject> modelList, String where) {
//
//    }
//
//    @Override
//    public void deleteAll(Class<? extends RealmObject> model) {
//
//    }
//
//    @Override
//    public RealmResults<? extends RealmObject> getAll(Class<? extends RealmObject> model) {
//        return realm.where(model).findAll();
//    }
//
//    @Override
//    public RealmResults<? extends RealmObject> getAll(Class<? extends RealmObject> model, String whereField, String value) {
//        return realm.where(model).equalTo(whereField,value).findAll();
//    }
//
//    @Override
//    public RealmResults<? extends RealmObject> getAll(Class<? extends RealmObject> model, String[] whereFields, String... values) {
//        return prepareWhereClause(realm.where(model), whereFields, values);
//    }
//
//    @Override
//    public RealmResults<? extends RealmObject> getAllOrderByAsc(Class<? extends RealmObject> model, String fieldName) {
//        RealmResults<? extends RealmObject> result = getAll(model);
//        return result.sort(fieldName);
//    }
//
//    @Override
//    public RealmResults<? extends RealmObject> getAllOrderByAsc(Class<? extends RealmObject> model, String whereField, String value, String orderField) {
//        RealmResults<? extends RealmObject> result =realm.where(model).equalTo(whereField,value).findAll();
//        return result.sort(orderField, Sort.ASCENDING);
//    }
//
//    @Override
//    public RealmResults<? extends RealmObject> getAllOrderByAsc(Class<? extends RealmObject> model, String[] whereFields, String[] values, String orderField) {
//        RealmResults<? extends RealmObject> result = prepareWhereClause(realm.where(model), whereFields, values);
//        return result.sort(orderField, Sort.ASCENDING);
//    }
//
//    @Override
//    public RealmResults<? extends RealmObject> getAllOrderByDesc(Class<? extends RealmObject> model, String fieldName) {
//        RealmResults<? extends RealmObject> result = getAll(model);
//        return result.sort(fieldName, Sort.DESCENDING);
//    }
//
//    @Override
//    public RealmResults<? extends RealmObject> getAllOrderByDesc(Class<? extends RealmObject> model, String whereField, String value, String orderField) {
//        RealmResults<? extends RealmObject> result =realm.where(model).equalTo(whereField,value).findAll();
//        return result.sort(orderField, Sort.DESCENDING);
//    }
//
//    @Override
//    public RealmResults<? extends RealmObject> getAllOrderByDesc(Class<? extends RealmObject> model, String[] whereFields, String[] values, String orderField) {
//        RealmResults<? extends RealmObject> result = prepareWhereClause(realm.where(model), whereFields, values);
//        return result.sort(orderField, Sort.DESCENDING);
//    }
//
//    @Override
//    public void deleteDataBase() {
//
//    }
}
