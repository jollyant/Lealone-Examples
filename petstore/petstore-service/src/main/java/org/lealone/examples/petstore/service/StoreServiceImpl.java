package org.lealone.examples.petstore.service;

import java.sql.Blob;
import java.util.List;

import org.lealone.examples.petstore.dal.model.Category;
import org.lealone.examples.petstore.dal.model.Item;
import org.lealone.examples.petstore.dal.model.Product;
import org.lealone.examples.petstore.service.generated.StoreService;
import org.lealone.orm.json.JsonArray;

public class StoreServiceImpl implements StoreService {

    @Override
    public Category getCategory(String categoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String addProduct(Product product, String categoryId, Blob picture) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAllCategories() {
        Product p = Product.dao;
        // TODO 不加where()会导致排序错误
        List<Category> list = Category.dao.join(p).on().catid.eq(p.categoryid).where().orderBy().catid.asc().findList();
        return new JsonArray(list).encode();
    }

    @Override
    public String getAllProductItems(String productId) {
        Category c = Category.dao;
        Product p = Product.dao;
        Item i = Item.dao;

        // TODO 还不支持三表join
        List<Category> list = c.join(p).on().catid.eq(p.categoryid).m(p).join(i).on().productid.eq(i.productid)
                .where().productid.eq(productId).m(c).findList();
        return new JsonArray(list).encode();
    }

    @Override
    public Item getProductItem(String itemId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCartItems(String cart) {
        // TODO Auto-generated method stub
        return null;
    }

}
