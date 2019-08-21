package com.example.service.impl;

import com.example.entity.Product;
import com.example.entity.ShoppingCart;
import com.example.entity.ShoppingCartItem;
import com.example.mapper.ShoppingCartItemMapper;
import com.example.service.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ShoppingCartItemServiceImp implements ShoppingCartItemService {

    @Autowired
    ShoppingCartItemMapper shoppingCartItemMapper;



    //通过用户id创建与用户相对应的购物车
    public void addCartByUid(int id){

        int tag=1;
        List<ShoppingCart> shoppingCartList=new ArrayList();
        shoppingCartList=shoppingCartItemMapper.checkoutShopCartByUid(id);

        for (ShoppingCart sc:shoppingCartList) {

            if(sc.getUserId()==id){
                tag=0;
                break;
            }
        }
        if(tag==1){
            ShoppingCart shoppingCart=new ShoppingCart();
            shoppingCart.setUserId(id);
            shoppingCartItemMapper.insertCart(shoppingCart);
        }
        else {
            System.out.println("一个用户只能对应一个购物车");
        }

    }

    /*
    通过用户id查到购物车里面的所有商品（购物车项）
     */
    public List<ShoppingCartItem> getShoppingCart(int id){

        List<ShoppingCartItem> shoppingCartItemList=new ArrayList();

        shoppingCartItemList=shoppingCartItemMapper.findByUid(id);
        return  shoppingCartItemList;

    }

    /*
    通过购物车项id删除对应的购物车项
     */
    public void deleteItemByGid(List<Integer> list){

        Iterator it=list.iterator();
        while(it.hasNext())
        {
            int id=(int)it.next();
            shoppingCartItemMapper.deleteByGid(id);
        }

    }


    /*
    通过用户id添加用户购物车里面的商品
     */
    public boolean addShopItem(int productid,int psid,Long num,int id){

        boolean b=true;

        ShoppingCartItem shoppingCartItem=new ShoppingCartItem();

        //用户所对应的购物车
        int shopcart=shoppingCartItemMapper.findCartByUid(id);
        shoppingCartItem.setShoppingCartId(shopcart);

        System.out.println("*********商品库存");
        System.out.println(shoppingCartItemMapper.findInventoryByPid(id));

//        通过商品id查到商品的库存,然后先判断库存是否大于用户选择的数量，再添加
        if(shoppingCartItemMapper.findInventoryByPid(id)>num){

            shoppingCartItem.setNumber(num);
            shoppingCartItem.setProductSpecificationId(psid);
            shoppingCartItem.setProductId(productid);

            /*
            再判断购物车里面是否有相同的购物车项(通过商品规格id和商品id判断)，
            若有相同的，则只需要在原来的基础上增加数量，不需要增加新的购物车项
             */
            List<ShoppingCartItem> shoppingCartItemList=new ArrayList();
            //通过用户id找到用户购物车里面所有的商品集合

            shoppingCartItemList=shoppingCartItemMapper.findByUid(id);
            int flag=1;
            int gid=0;  //gid标记购物车项，当数量变为0时，用来删除购物车
            int sid=0;  //sid标记购物车里面已经有的购物车项id
            for (ShoppingCartItem shoppingCartItem2:shoppingCartItemList) {

                if(shoppingCartItem2.getProductId()==productid&&shoppingCartItem2.getProductSpecificationId()==psid){
                    flag=0;
                    sid=shoppingCartItem2.getShoppingCartItemId();
                    gid=shoppingCartItem2.getShoppingCartItemId();
                    System.out.println("+++++++++++++++++++++++");
                    System.out.println(gid);
                    break;
                }
            }

            /*
            若flag=1：购物车项里面 没有 用户所要加的商品 此时要 添加 新的购物车项
            若flag=0：购物车项里面  有 用户要加的商品 此时应该 修改 购物车项的数量
             */
            if(flag==1){

//              通过商品规格id查到的商品原价，并根据用户选择数量算的商品总的原价格
                BigDecimal price=shoppingCartItemMapper.findPriceBySid(psid);
                BigDecimal num1=BigDecimal.valueOf(num);
                BigDecimal totalprice=price.multiply(num1);
                shoppingCartItem.setTotalPrice(totalprice);

                String img=shoppingCartItemMapper.findPictureByPid(productid);
                System.out.println("**********************");
                System.out.println(img);
                shoppingCartItem.setLogo(img);

                shoppingCartItem.setState(1);

//              将折扣discount的类型float改为bigdecimal
                Float discount=shoppingCartItemMapper.findDiscountByPid(productid);

                System.out.println("###############################");
                System.out.println(discount);

                BigDecimal discount1=BigDecimal.valueOf(discount);
//                计算折后价
                BigDecimal finalprice=discount1.multiply(totalprice);

                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
                System.out.println(finalprice);

                shoppingCartItem.setFinalPrice(finalprice);
                shoppingCartItemMapper.addShopItem(shoppingCartItem);
            }
            else{

                if(num!=0){
                   // 此时应该是修改数量
                    BigDecimal price1=shoppingCartItemMapper.findPriceBySid(psid);
//                    BigDecimal num1=BigDecimal.valueOf(num);

                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@用户选择修改了数量");
                    System.out.println(num);
                    BigDecimal num1=BigDecimal.valueOf(num);
                    System.out.println(num1
                    );
                    BigDecimal totalprice1=price1.multiply(num1);

                    System.out.println("!!!!!!!!!修改后的总价格");
                    System.out.println(totalprice1);
//              将折扣discount的类型float改为bigdecimal
                    Float discount=shoppingCartItemMapper.findDiscountByPid(productid);
                    BigDecimal discount1=BigDecimal.valueOf(discount);
//              计算折后价
                    BigDecimal finalprice1=discount1.multiply(totalprice1);
                    System.out.println("#################购物车项id");
                    System.out.println(gid);

                    System.out.println("@@@@@@@@@折扣后的价格");
                    System.out.println(finalprice1);
                    shoppingCartItemMapper.updataNumByGid(sid,num,totalprice1,finalprice1);

                }
                else {
                    //若数量变为0，那么删除该购物项，否则就只修改商品数量
                    shoppingCartItemMapper.deleteByGid(gid);
                }

                b=true;

            }

        }
        else {
            b=false;
        }
      return b;
    }

//    public String getImgByPid(int id){
//       return shoppingCartItemMapper.findPictureByPid(id);
//    }

    /**
     * 通过商品名字查到所有的商品
     * @param name
     * @return
     */
    public List<Product> getAllProductByName(String name){

        return shoppingCartItemMapper.findProductsByName(name);
    }

    //通过名字获取有关商品名的list
    public List<String> getAllProductNameByName(String name){

        return shoppingCartItemMapper.productNameList(name);
    }

    //通过商品id获取唯一价格
    public BigDecimal getProductOnePrice(int id)
    {
        return shoppingCartItemMapper.productpriceByPid(id);

    }


}
