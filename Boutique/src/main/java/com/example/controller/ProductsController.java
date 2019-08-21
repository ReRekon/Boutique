package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.Product;
import com.example.service.ProductsService;
import com.example.utils.ChangeJsonArray;
import com.example.vo.Historys;
import com.example.vo.AdminVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ProductsController
{
    @Autowired
    private ProductsService productsService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    //根据用户选择的商品id删除历史纪录
    @RequestMapping("/deletehistory")
    public  String deleteSomeHistory(@RequestParam ArrayList<Integer> productId )
    {
        HttpSession session = httpServletRequest.getSession();
         AdminVo admin=(AdminVo) session.getAttribute("admin");
		  Integer userId=admin.getUserId();
        if(userId==null)
        {
            return null;
        }
        else  productsService.deleteSomeHistory(productId,userId);
        return "ok";
    }

    @RequestMapping("/tohistory")
    public  ArrayList<Historys> returnAllHistory()
    {
        HttpSession session = httpServletRequest.getSession();
        AdminVo admin=(AdminVo) session.getAttribute("admin");
        if(admin!=null) {
            Integer userId = admin.getUserId();
            if (userId != null) {
                return productsService.returnAllHistory(userId);
            }
            else return null;
        }
        else return null;
    }


   //商品id返回商品信息
   @RequestMapping("/product")
   public String returnProduct(@RequestParam("productId") Integer productId)
   {
//       HttpSession session = httpServletRequest.getSession();
//       Integer userId = (Integer)session.getAttribute("userId");
//       productsService.returnAllHistory(productId,userId);
//       return productsService.returnProduct(productId);
       try{
           HttpSession session = httpServletRequest.getSession();
           AdminVo admin=(AdminVo) session.getAttribute("admin");
		  Integer userId=admin.getUserId();
           if(userId!=null)
               productsService.updateHistory(productId,userId);

       }catch (Exception E){

       }finally {

           Product product=productsService.returnProduct(productId);
           List<Product> productList=new ArrayList<>();
           productList.add(product);

           //System.out.println(JSONObject.toJSONString(productList));
           return JSONObject.toJSONString(productList);
       }
   }
   @RequestMapping("/moren")
   public String returnmorenProductSpecification(@RequestParam Integer productId)
    {
       return JSONObject.toJSONString( productsService.returnmorenProductSpecification(productId));
    }
    @RequestMapping("/img")
    public String returnAllImg(@RequestParam("productId") Integer productId)
    {
        List<String> productImageList=productsService.returnAllImg(productId);
        String string=JSON.toJSONString(productImageList);
        String str=ChangeJsonArray.transform(string);
        //System.out.println(str);
        return str;
    }
    @RequestMapping("/specification")
    public String returnS(@RequestParam Integer productId)
    {
        return JSONObject.toJSONString(productsService.returnProductSpecification(productId));

    }
}
